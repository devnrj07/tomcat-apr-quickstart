package com.devnrj.apr.tomcatapr;

import org.apache.catalina.LifecycleListener;
import org.apache.catalina.core.AprLifecycleListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AprConfiguration {
	
	@Value("${tomcat.apr.enabled:true}")
     private boolean enabled;
		    @Bean
		    public TomcatServletWebServerFactory servletContainer() {
		    	TomcatServletWebServerFactory container = new TomcatServletWebServerFactory();
	
		      if(enabled) {
		    	LifecycleListener arpLifecycle = new AprLifecycleListener();
		        container.setProtocol("org.apache.coyote.http11.Http11AprProtocol");
		        container.addContextLifecycleListeners(arpLifecycle);
		      }
	        return container;
		    }
	}
	

