package com.lsk.api;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author I326998
 */

public class AppBoot extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { App.class, SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/*" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(RequestContextListener.class);
		super.onStartup(servletContext);
	}
	/*
	 * Q:为什么这里又要引入一个额外的RequestContextListener呢?
	 * A:在整合spring容器时使用ContextLoaderListener,它实现了ServletContextListener监听器接口,
	 * ServletContextListener
	 * 只负责监听web容器启动和关闭的事件.而RequestContextListener实现ServletRequestListener监听器接口,
	 * 该监听器监听 HTTP请求事件,web服务器接收的每一次请求都会通知该监听器.
	 * spring容器启动和关闭操作由web容器的启动和关闭事件触发,但如果spring容器中的Bean需要request,session,
	 * globalsession
	 * 作用域的支持,spring容器本身就必须获得web容器的HTTP请求事件,以HTTP请求的事件"驱动"Bean作用域的控制逻辑.
	 */

}
