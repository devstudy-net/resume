package net.devstudy.resume.component.impl;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import net.devstudy.resume.filter.AbstractFilter;
import net.devstudy.resume.util.DebugUtil;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@Component
public class DebugFilter extends AbstractFilter {

	public boolean isEnabledDebug(){
		return true;
	}
	
	public String[] getDebugUrl(){
		return new String[]{"/richard-hendricks", "/welcome"};
	}

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		try {
			LOGGER.info("**************************************************** start ***************************************************");
			DebugUtil.turnOnShowSQL();
			chain.doFilter(req, resp);
		} finally {
			DebugUtil.turnOffShowSQL();
			LOGGER.info("****************************************************  end  ***************************************************");
		}
	}
}
