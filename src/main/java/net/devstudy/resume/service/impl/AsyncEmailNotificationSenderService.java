package net.devstudy.resume.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import net.devstudy.resume.domain.Profile;
import net.devstudy.resume.model.NotificationMessage;
import net.devstudy.resume.service.NotificationSenderService;

@Service
public class AsyncEmailNotificationSenderService implements NotificationSenderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AsyncEmailNotificationSenderService.class);
	
	@Autowired
	@Qualifier("defaultExecutorService")
	private ExecutorService executorService;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${email.fromEmail}")
	private String fromEmail;

	@Value("${email.fromName}")
	private String fromName;
	
	@Value("${email.sendTryCount}")
	private int tryCount;
	
	@Value("${application.production}")
	private boolean production;
	
	@Override
	public void sendNotification(NotificationMessage message) {
		executorService.submit(new EmailItem(message, tryCount));
	}

	@Override
	public String findDestinationAddress(Profile profile) {
		return profile.getEmail();
	}
	
	/**
	 * 
	 * @author devstudy
	 * @see http://devstudy.net
	 */
	protected class EmailItem implements Runnable {
		protected final NotificationMessage notificationMessage;
		protected int tryCount;

		protected EmailItem(NotificationMessage notificationMessage, int tryCount) {
			super();
			this.notificationMessage = notificationMessage;
			this.tryCount = tryCount;
		}

		@Override
		public void run() {
			try {
				if(production) {
					MimeMailMessage msg = buildMessage();
					javaMailSender.send(msg.getMimeMessage());
					LOGGER.debug("Email to {} successful sent", notificationMessage.getDestinationAddress());
				} else {
					LOGGER.warn("DEMO MODE: Email to {}, {}/{}", notificationMessage.getDestinationAddress(), notificationMessage.getSubject(), notificationMessage.getContent());
				}
			} catch (Exception e) {
				LOGGER.error("Can't send email to " + notificationMessage.getDestinationAddress() + ": " + e.getMessage(), e);
				tryCount--;
				if (tryCount > 0) {
					LOGGER.debug("Decrement tryCount and try again to send email: tryCount={}, destinationEmail={}", tryCount, notificationMessage.getDestinationAddress());
					executorService.submit(this);
				} else {
					LOGGER.error("Email not sent to " + notificationMessage.getDestinationAddress());
				}
			}
		}
		
		protected MimeMailMessage buildMessage() throws MessagingException, UnsupportedEncodingException{
			MimeMessageHelper message = new MimeMessageHelper(javaMailSender.createMimeMessage(), false);
			message.setSubject(notificationMessage.getSubject());
			message.setTo(new InternetAddress(notificationMessage.getDestinationAddress(), notificationMessage.getDestinationName()));
			message.setFrom(fromEmail, fromName);
			message.setText(notificationMessage.getContent());
			return new MimeMailMessage(message);
		}
	}
}
