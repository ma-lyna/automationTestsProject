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

        @Key("user_id")
        String userId();

        @Key("password")
        String password();

        @Key("category")
        String category();

        @Key("productCode")
        String productCode();

        @Key("productInvalidCode")
        String productInvalidCode();

        @Key("randomPassword")
        String randomPassword();
}