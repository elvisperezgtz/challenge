package com.petstore.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.DecoderConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseConf {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setBaseConfiguration() {

        SerenityRest.config().decoderConfig(DecoderConfig
                .decoderConfig().defaultContentCharset("UTF-8"));
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at("http://localhost:8080/")));
        SerenityRest.setDefaultRequestSpecification(defaultRequestSpecification());
    }

    private RequestSpecification defaultRequestSpecification() {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        return new RequestSpecBuilder().addFilters(filters).build();
    }
}