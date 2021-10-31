package com.example.notes_app_viewmodel

import androidx.lifecycle.LiveData


class NoteRepository (var notesDao: NotesDao){

// her we have an arraylist if there is any change in this array it will apply in notesDao object
    var getallnotes:LiveData<List<Notes>> = notesDao.getallnotes()
// this function will add notes
    suspend fun Insertnote(note:Notes){
        notesDao.Insertnote(note)
    }
// her will update
    suspend fun updatenote(note:Notes){
        notesDao.updatenote(note)
    }
// her will delete
    suspend fun deletenote(note:Notes){
        notesDao.deletenote(note)
    }

}