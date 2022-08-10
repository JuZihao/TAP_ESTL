package com.example.esm.common;


import com.example.esm.entity.Response;

public class ResponseUtil {

    public static Response createResponse(int statusCode, String statusMessage, Object data){
       return new Response(statusCode,statusMessage,data);
    }
}
