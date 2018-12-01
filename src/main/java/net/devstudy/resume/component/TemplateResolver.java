package net.devstudy.resume.component;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface TemplateResolver {

	@Nonnull String resolve(@Nonnull String template, @Nullable Object model);
}
