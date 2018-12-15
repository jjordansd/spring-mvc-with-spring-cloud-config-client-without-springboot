package com.zenika.controller.config;

import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.web.context.support.StandardServletEnvironment;

public class CloudEnvironment extends StandardServletEnvironment {

  @Override
  protected void customizePropertySources(MutablePropertySources propertySources) {
    super.customizePropertySources(propertySources);
    try {
      PropertySource<?> source = initConfigServicePropertySourceLocator(this);
      propertySources.addLast(source);

    } catch (

    Exception ex) {
      logger.warn("failed to initialize cloud config environment", ex);
    }
  }

  private PropertySource<?> initConfigServicePropertySourceLocator(Environment environment) {

    ConfigClientProperties configClientProperties = new ConfigClientProperties(environment);
    configClientProperties.setUri("http://localhost:8888");
    configClientProperties.setName("customer-manager");
    configClientProperties.setLabel("master");

    System.out.println("##################### will load the client configuration");
    System.out.println(configClientProperties);

    ConfigServicePropertySourceLocator configServicePropertySourceLocator =
        new ConfigServicePropertySourceLocator(configClientProperties);

    return configServicePropertySourceLocator.locate(environment);
  }
}
