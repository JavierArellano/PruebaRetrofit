package com.example.franj.pruebaretrofit;

import java.util.List;

/**
 * Created by franj on 10/11/2017.
 */



public class ChisteLista {

    private String type;
    private List<Value> value = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

}