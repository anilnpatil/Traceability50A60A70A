package com.nf.traceability.constant;

public class SecurityConstant {
    public static final long EXPIRATION_TIME = 432_000_000; // 5 days expressed in milliseconds
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String TRACEABILITY_LLC = "Traceability, LLC";
    public static final String TRACEABILITY_ADMINISTRATION = "User Management Portal";
    public static final String AUTHORITIES = "authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String[] PUBLIC_URLS = { "/user/login",
            "/user/register", "/data/getLogData", "/user/resetpassword/**", "/user/image/**",
            "/data/getMachine1UpdatedData", "/data/getMachine1UpdatedResults", "/data/getMachine1FilteredData/**","/data/getMachine1DataUsingProductId/**",
            "/data/getMachine2UpdatedData", "/data/getMachine2UpdatedResults", "/data/getMachine2FilteredData/**","/data/getMachine2DataUsingProductId/**",
            "/data/getMachine3UpdatedData", "/data/getMachine3UpdatedResults", "/data/getMachine3FilteredData/**","/data/getMachine3DataUsingProductId/**",
            "/data/getMachine4UpdatedData", "/data/getMachine4UpdatedResults", "/data/getMachine4FilteredData/**","/data/getMachine4DataUsingProductId/**",
            "/data/getMachine5UpdatedData", "/data/getMachine5UpdatedResults", "/data/getMachine5FilteredData/**","/data/getMachine5DataUsingProductId/**",
            "/data/getMachine6UpdatedData", "/data/getMachine6UpdatedResults", "/data/getMachine6FilteredData/**","/data/getMachine6DataUsingProductId/**",
            "/data/getMachine7UpdatedData", "/data/getMachine7UpdatedResults", "/data/getMachine7FilteredData/**","/data/getMachine7DataUsingProductId/**",
            "/data/getMachine8UpdatedData", "/data/getMachine8UpdatedResults", "/data/getMachine8FilteredData/**","/data/getMachine8DataUsingProductId/**",
            "/data/getMachine9UpdatedData", "/data/getMachine9UpdatedResults", "/data/getMachine9FilteredData/**","/data/getMachine9DataUsingProductId/**",
            "/data/getMachine10UpdatedData", "/data/getMachine10UpdatedResults", "/data/getMachine10FilteredData/**","/data/getMachine10DataUsingProductId/**",
            "/data/getMachine11UpdatedData", "/data/getMachine11UpdatedResults", "/data/getMachine11FilteredData/**","/data/getMachine11DataUsingProductId/**",
            "/data/getMachine19UpdatedData", "/data/getMachine19UpdatedResults", "/data/getMachine19FilteredData/**","/data/getMachine19DataUsingProductId/**",
            "/data/getMachine13UpdatedData", "/data/getMachine13UpdatedResults", "/data/getMachine13FilteredData/**","/data/getMachine13DataUsingProductId/**",
            "/data/getMachine14UpdatedData", "/data/getMachine14UpdatedResults", "/data/getMachine14FilteredData/**","/data/getMachine14DataUsingProductId/**",
            "/data/getTotalProductionCount","/data/getLine1UpdatedResults", "/data/getLine1FilteredData/**","/data/getLine1DataUsingProductId/**",
            "/data/checkError", "/data/updateErrorStatus", "/data/getDailyReport", "/data/deleteLine1/**"
    };
    // public static final String[] PUBLIC_URLS = { "**" };
}
