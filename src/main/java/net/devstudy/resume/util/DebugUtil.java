package net.devstudy.resume.util;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class DebugUtil {
	public static void turnOnShowMongoQuery() {
		Logger sqlLogger = (Logger) LoggerFactory.getLogger("org.springframework.data.mongodb.core.MongoTemplate");
		sqlLogger.setLevel(Level.DEBUG);
	}

	public static void turnOffShowMongoQuery() {
		Logger sqlLogger = (Logger) LoggerFactory.getLogger("org.springframework.data.mongodb.core.MongoTemplate");
		sqlLogger.setLevel(Level.INFO);
	}
}
