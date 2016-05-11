package net.devstudy.resume.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.devstudy.resume.service.NameService;

@Controller
public class ProfileController extends HttpServlet{
	private static final long serialVersionUID = -1961434718891521031L;
	
	@Autowired
	private NameService nameService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("name");
		if(StringUtils.isNotBlank(param)) {
			req.setAttribute("name", nameService.convertName(param));
		}
		req.getRequestDispatcher("/WEB-INF/JSP/profile.jsp").forward(req, resp);;
	}
}
