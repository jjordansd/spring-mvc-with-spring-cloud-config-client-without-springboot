package com.zenika.controller;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "github")
public class GithubProperties {

  /**
   * Oauth token used for authenticating with GitHub
   */
  private String token;
  /**
   * Root dir path to clone the repos
   */
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
    System.out.println("Github Properties are " + token + " with " + cloneBaseDir);
  }
}
