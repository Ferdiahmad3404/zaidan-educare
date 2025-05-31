package com.tujuhbelasan.zaidanEducare;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/tujuhbelasan/zaidanEducare/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.tujuhbelasan.zaidanEducare.stepDefinition,com.tujuhbelasan.zaidanEducare.utility,com.tujuhbelasan.zaidanEducare.hooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-html-report.html, json:target/cucumber.json")
public class RunZaidanEducareTest {
}

