package com.example.dataaccessmybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Note {
    private int id;
    private String title;
    private String desc;
}
