package com.esm.common;

import com.esm.entity.Response;

public class ResponseUtil {

    public static Response createResponse(int statusCode, String statusMessage, Object data){
        return new Response(statusCode,statusMessage,data);
    }
}
