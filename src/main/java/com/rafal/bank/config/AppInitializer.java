package com.rafal.bank.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.*;
import java.util.HashSet;
import java.util.Set;

public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
                dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");


        FilterRegistration.Dynamic filter = servletContext.addFilter("openSessionInViewFilter", OpenSessionInViewFilter.class);
        filter.addMappingForServletNames(null, false, "SpringDispatcher");

        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(appContext);

        servletContext.addListener(contextLoaderListener);

    }

}
