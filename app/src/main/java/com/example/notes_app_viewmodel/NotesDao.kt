package com.example.notes_app_viewmodel

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NotesDao {
    // get all notes in Notes table and update data  ( LiveData )in the same time
    @Query("SELECT* FROM Notes")
    fun getallnotes():LiveData<List<Notes>>
    @Insert
    suspend fun Insertnote(note:Notes)
    @Update
    suspend fun updatenote(note:Notes)
    @Delete
    suspend fun deletenote(note:Notes)

}