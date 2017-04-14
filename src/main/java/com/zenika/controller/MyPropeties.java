package com.zenika.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyPropeties {

  /**
   * Oauth token used for authenticating with GitHub
   */
  @Value("${github.token}")
  private String token;
  /**
   * Root dir path to clone the repos
   */
  @Value("${github.cloneBaseDir}")
  private String cloneBaseDir;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getCloneBaseDir() {
    return cloneBaseDir;
  }

  public void setCloneBaseDir(String cloneDir) {
    this.cloneBaseDir = cloneDir;
  }

  @PostConstruct
  public void loadedProperties() {
    System.out.println("My Properties are: " + token + " with " + cloneBaseDir);
  }
}
