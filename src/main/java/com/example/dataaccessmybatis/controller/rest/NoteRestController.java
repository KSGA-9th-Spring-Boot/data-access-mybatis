package com.example.dataaccessmybatis.controller.rest;

import com.example.dataaccessmybatis.model.Note;
import com.example.dataaccessmybatis.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NoteRestController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes/{id}")
    public ResponseEntity<?> notes(@PathVariable int id) {
        Note note = noteService.findNoteById(id);
        return ResponseEntity.ok(note);
    }

}
