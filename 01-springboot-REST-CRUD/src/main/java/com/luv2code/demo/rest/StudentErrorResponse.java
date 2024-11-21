package com.luv2code.demo.rest;

public class StudentErrorResponse
{
    private int Status;
    private String message;
    private long timeStamp;


    public StudentErrorResponse()
    {

    }

    public StudentErrorResponse(long timeStamp, String message, int status) {
        this.timeStamp = timeStamp;
        this.message = message;
        Status = status;
    }

    public int getStatus() {
        return Status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
