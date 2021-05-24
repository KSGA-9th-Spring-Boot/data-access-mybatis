package com.example.dataaccessmybatis.repository;

import com.example.dataaccessmybatis.model.Note;
import com.example.dataaccessmybatis.repository.provider.NoteProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface NoteRepository {
//    @Select("select * from notes where id = #{id}")
//    @Results(id = "noteMapping", value = {
//            @Result(property = "title", column = "t"),
//            @Result(property = "desc", column = "description")
//    })
//    Note findNoteById(@Param("id") int noteId);

    @Select("select * from notes")
    @ResultMap("noteMapping")
    List<Note> findAll();

    @Insert("insert into notes (id, t, description) values (#{id}, #{title}, #{desc})")
    boolean insertNote(Note note);

    @Delete("delete from notes where id = #{id}")
    boolean deleteNote(int id);

    @SelectProvider(type = NoteProvider.class, method = "getNote")
    @Results(id = "noteMapping", value = {
            @Result(property = "title", column = "t"),
            @Result(property = "desc", column = "description")
    })
    Note findNoteById(@Param("id") Integer id);
}
