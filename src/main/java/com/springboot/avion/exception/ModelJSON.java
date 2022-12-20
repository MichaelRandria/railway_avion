package com.springboot.avion.exception;

public class ModelJSON {
    Object data;
    ErrorMessage error;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(ErrorMessage error) {
        this.error = error;
    }
}
