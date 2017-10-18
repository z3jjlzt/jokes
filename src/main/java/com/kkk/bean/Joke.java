package com.kkk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Joke {
    private Integer id;

    private String author;

    private Byte atype;

    private String atag;

    private Date cdate;

    private String article;

}