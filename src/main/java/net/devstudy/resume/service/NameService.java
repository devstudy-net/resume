package net.devstudy.resume.service;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class NameService {

	public static NameService getInstance(){
		return new NameService();
	}

	public String convertName(String name) {
		return name.toUpperCase();
	}
}
