package com.kkk.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Joke {
    @NotNull
    private Integer id;

    @Length(max = 20, min = 6)
    @NotNull
    private String author;

    @NotNull
    private Byte atype;

    @NotNull
    private String atag;

    private Date cdate;

    private String article;

}