package com.example.dataaccessmybatis.repository.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class NoteProvider {

    public String getNote(@Param("id") Integer id) {
        id = null;
        Integer finalId = id;
        String sql = new SQL() {{
            SELECT("*");
            FROM("notes");
            if (finalId == null) {
                System.out.println("Id is null");
            } else {
                WHERE("id = 1");
            }
            ORDER_BY("id");
            OFFSET(0);
        }}.toString();
        System.out.println(sql);
        return sql;
    }

}
