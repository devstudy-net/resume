package net.devstudy.resume.service.impl;

import org.springframework.stereotype.Service;

import net.devstudy.resume.service.NameService;

@Service
public class NameServiceImpl implements NameService{

	@Override
	public String convertName(String name) {
		return name.toUpperCase();
	}
}
