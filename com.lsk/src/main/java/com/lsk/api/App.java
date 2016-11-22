package com.lsk.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author I326998
 *
 */
@Configuration
@ComponentScan(basePackages = App.SCAN_PACKAGE)
public class App 
{
	public static final String SCAN_PACKAGE="com.lsk.api";
}
