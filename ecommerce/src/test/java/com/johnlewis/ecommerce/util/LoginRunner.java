package com.johnlewis.ecommerce.util;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author MMahadevan Runner class
 * 
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {
  "src/test/resources" }, strict = true, format = { "pretty",
  "html:target/cucumber", "json:target/login.json" }, tags = { "@login" }, monochrome = true,glue = {
		  "com.johnlewis.ecommerce.login.steps"})
public class LoginRunner {

 
}

