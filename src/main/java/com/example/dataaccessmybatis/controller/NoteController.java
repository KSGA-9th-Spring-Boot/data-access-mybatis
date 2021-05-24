package com.example.dataaccessmybatis.controller;

import com.example.dataaccessmybatis.model.Note;
import com.example.dataaccessmybatis.repository.NoteRepository;
import com.example.dataaccessmybatis.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public String notes(Model model) {
        List<Note> note = noteService.getAllNotes();
        System.out.println(note);
        model.addAttribute("notes", note);
        return "index";
    }

    @GetMapping("/notes/{id}")
    public String notes(Model model, @PathVariable int id) {
        Note note = noteService.findNoteById(id);
        model.addAttribute("note", note);
        return "index";
    }

    @GetMapping("/insert-note-static")
    public String insert(Model model) {
        Note note = new Note();
        note.setId((int)(Math.random() * 100)).setTitle("my note 4").setDesc("my desc 4");

        if(noteService.insertNote(note)) {
            System.out.println("insert succcess");
        } else {
            System.out.println("insert fail");
        }

        List<Note> notes = noteService.getAllNotes();
        model.addAttribute("notes", notes);
        return "index";
    }

    @GetMapping("/delete/notes/{id}")
    public String deleteNote(@PathVariable int id) {
        if(noteService.deleteNote(id)) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
        return "redirect:/notes";
    }
}
