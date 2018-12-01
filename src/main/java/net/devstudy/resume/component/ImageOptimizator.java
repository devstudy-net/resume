package net.devstudy.resume.component;

import java.nio.file.Path;

import javax.annotation.Nonnull;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface ImageOptimizator {

	void optimize (@Nonnull Path image);
}
