package service;

import model.Note;

import java.util.List;

public interface iNoteService {
    void addNote(String title, String content, int idType);

    void removeNote(int id);

    List<Note> searchNote(String keyWord);

    List<Note> getAllNote();
}