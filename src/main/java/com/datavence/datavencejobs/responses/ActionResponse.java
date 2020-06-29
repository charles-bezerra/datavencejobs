package com.datavence.datavencejobs.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionResponse <T> {
    private Boolean success;
    private String error;
    private T t;

    public ActionResponse(Boolean success, String error) {
        this.success = success;
        this.error = error;
        this.t = null;
    }

    public ActionResponse(Boolean success, String error, T t) {
        this.success = success;
        this.error = error;
        this.t = t;
    }
}
