package net.devstudy.resume.service.impl;

import org.apache.commons.lang.WordUtils;
import org.springframework.stereotype.Service;

import net.devstudy.resume.service.NameService;

@Service
public class NameServiceImpl implements NameService{

	@Override
	public String convertName(String name) {
		if(name.contains("-")) {
			String[] parts = name.split("-");
			return WordUtils.capitalize(parts[0]) + " " + WordUtils.capitalize(parts[1]);
		}
		return WordUtils.capitalize(name);
	}
}
