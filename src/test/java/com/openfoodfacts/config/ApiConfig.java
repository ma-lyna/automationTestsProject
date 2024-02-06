package com.openfoodfacts.config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:api.properties")
public interface ApiConfig extends Config  {
        @Key("baseURI")
        String baseURI();

        @Key("apiBasePath")
        String apiBasePath();

        @Key("cgiBasePath")
        String cgiBasePath();
}