package com.polarbookshop.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "polar")
public class PolarProperties {

  /**
   * Welcome greeting on home page
   */
  @Getter @Setter private String greeting;
}
