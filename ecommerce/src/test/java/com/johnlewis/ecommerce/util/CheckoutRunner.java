package com.johnlewis.ecommerce.util;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
  "src/test/resources" }, strict = true, format = { "pretty",
  "html:target/cucumber", "json:target/Regression.json" }, tags = { "@Regression" }, monochrome = true,glue = {
		  "com.johnlewis.ecommerce.login.steps"})
public class CheckoutRunner {

}
