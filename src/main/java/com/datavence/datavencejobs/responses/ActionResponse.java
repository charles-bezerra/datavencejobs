package com.datavence.datavencejobs.responses;

public class ActionResponse {
    private Boolean success;
    private String error;

    public ActionResponse(Boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }
}
