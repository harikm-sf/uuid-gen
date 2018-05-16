package io.digicom.core.uuid.handlers;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public abstract class BaseHandler {
	@Autowired
	protected MessageSource messageSource;
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected Locale locale = LocaleContextHolder.getLocale();
	
	@PostConstruct
	public void postConstruct() {
		logger.trace("Constructing BaseServiceInstance: "+ getClass().getSimpleName());
		
	}

}
