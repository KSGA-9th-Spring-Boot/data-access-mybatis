package com.example.dataaccessmybatis.service;

import com.example.dataaccessmybatis.model.Note;

import java.util.List;

public interface NoteService {
    Note findNoteById(int noteId);
    List<Note> getAllNotes();
    boolean insertNote(Note note);
    boolean deleteNote(int id);
}
