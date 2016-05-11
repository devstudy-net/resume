package net.devstudy.resume.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devstudy.resume.service.NameService;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
@WebServlet("/search")
public class SearchController extends HttpServlet{
	private static final long serialVersionUID = 2847786613235117603L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.debug("doGet search");
		req.getRequestDispatcher("/WEB-INF/JSP/search-form.jsp").forward(req, resp);
	}
	
	private boolean isValid(String name) {
		return name != null && name.trim().length() != 0;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.debug("doPost search: {}", req.getParameterMap());
		String name = req.getParameter("query");
		if(!isValid(name)) {
			req.setAttribute("invalid", Boolean.TRUE);
			req.getRequestDispatcher("/WEB-INF/JSP/search-form.jsp").forward(req, resp);
			return;
		}
		String result = NameService.getInstance().convertName(name);
		req.setAttribute("name", result);
		req.getRequestDispatcher("/WEB-INF/JSP/search-result.jsp").forward(req, resp);
	}
}
