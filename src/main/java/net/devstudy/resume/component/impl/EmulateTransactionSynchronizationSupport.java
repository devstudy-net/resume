package net.devstudy.resume.component.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Emulates TransactionSynchronization support for not transactional environment
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Aspect
@Component
public class EmulateTransactionSynchronizationSupport {

	@Around("@annotation(org.springframework.transaction.annotation.Transactional)")
	public Object advice(ProceedingJoinPoint pjp) throws Throwable {
		TransactionSynchronizationManager.initSynchronization();
		try {
			Object result = pjp.proceed();
			for(TransactionSynchronization transactionSynchronization : TransactionSynchronizationManager.getSynchronizations()) {
				transactionSynchronization.afterCommit();
			}
			return result;
		} catch (Exception e) {
			for(TransactionSynchronization transactionSynchronization : TransactionSynchronizationManager.getSynchronizations()) {
				if(e instanceof RuntimeException) {
					transactionSynchronization.afterCompletion(TransactionSynchronization.STATUS_ROLLED_BACK);
				} else {
					transactionSynchronization.afterCommit();
				}
			}
			throw e;
		} finally {
			TransactionSynchronizationManager.clearSynchronization();
		}
	}
}
