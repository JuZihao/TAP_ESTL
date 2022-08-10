package com.example.esm.entity;

/**
 * Employee model
 */
public class Response<T> {
    private int statusCode;
    private String statusMessage;
    private T data;

    public Response(int statusCode, String statusMessage, T data) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
