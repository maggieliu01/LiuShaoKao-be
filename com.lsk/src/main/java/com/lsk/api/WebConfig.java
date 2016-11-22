package com.lsk.api;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lsk.api.interceptors.CustomizedInterceptor;

/**
 * @author I326998
 */

@Configuration
@ComponentScan(basePackages = WebConfig.BASED_PACKAGE)
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
	public static final String BASED_PACKAGE = "ocm.lsk.api";

	private ApplicationContext applicationContext;

	@Autowired
	List<CustomizedInterceptor> customizedInterceptors;

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.applicationContext = arg0;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		if (!customizedInterceptors.isEmpty()) {
			for (HandlerInterceptor interceptor : customizedInterceptors) {
				registry.addInterceptor(interceptor);
			}
		}
		super.addInterceptors(registry);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
		super.configureDefaultServletHandling(configurer);
	}
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setApplicationContext(this.applicationContext);
		viewResolver.setSuffix(".html");
		viewResolver.setPrefix("/WEB-INF/views");
		return viewResolver; 
	}

}
