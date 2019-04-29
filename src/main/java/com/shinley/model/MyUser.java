package com.shinley.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyUser implements Serializable {

    private Integer id;

    private String name;

    private String mqMsg;
}
