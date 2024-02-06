package com.openfoodfacts.config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:api.properties")
public interface ApiConfig extends Config  {
//    public static String baseURI = "https://world.openfoodfacts.net";
//    public static String apiBasePath = "/api";
//    public static String cgiBasePath = "/cgi";

        @Key("baseURI")
        String baseURI();

        @Key("apiBasePath")
        String apiBasePath();

    @Key("cgiBasePath")
    String cgiBasePath();
}
