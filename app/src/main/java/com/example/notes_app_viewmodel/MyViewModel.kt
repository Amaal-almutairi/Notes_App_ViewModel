package com.example.notes_app_viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//Application is a subclass (Context)

class MyViewModel(application: Application):AndroidViewModel(application){
 var repository: NoteRepository
   var AllNotes: LiveData<List<Notes>>
  // create a variable (notesDao) so we can access to database class and Doa class
  init {
      val notesDao = NotesDatabase.getinstance(application).NotesDao()
      repository = NoteRepository(notesDao)
      AllNotes = repository.getallnotes
  }
    fun getallnotes(): LiveData<List<Notes>>{
        return AllNotes
    }
    fun Insertnote(notes:Notes){
        CoroutineScope(Dispatchers.IO).launch {
            repository.Insertnote(notes)
        }

    }
    fun updatenote(id:Int,notes:String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.updatenote(Notes(id,notes))
        }

    }
    fun deletenote(id:Int){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deletenote(Notes(id," "))
        }
    }

}