package com.ms.rider_service.utils;

public class ApiUrlUtil {
    static final String BASE_URL = "/api";
    static final String VERSION = "/v1";

    public static final String AUTH_URL = BASE_URL + VERSION + "/auth/riders";
    public static final String RIDER_URL = BASE_URL + VERSION + "/riders";
    public static final String S2S_URL = BASE_URL + VERSION+ "/s2s/riders";
}
