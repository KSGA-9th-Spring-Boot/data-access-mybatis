package com.example.dataaccessmybatis.service.impl;

import com.example.dataaccessmybatis.model.Note;
import com.example.dataaccessmybatis.repository.NoteRepository;
import com.example.dataaccessmybatis.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note findNoteById(int noteId) {
        return noteRepository.findNoteById(noteId);
    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return notes;
    }

    @Override
    public boolean insertNote(Note note) {
        return noteRepository.insertNote(note);
    }

    @Override
    public boolean deleteNote(int id) {
        return noteRepository.deleteNote(id);
    }
}
