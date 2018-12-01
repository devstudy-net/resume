package net.devstudy.resume.component;

import javax.annotation.Nonnull;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public interface TranslitConverter {

	@Nonnull String translit(@Nonnull String text);
}
