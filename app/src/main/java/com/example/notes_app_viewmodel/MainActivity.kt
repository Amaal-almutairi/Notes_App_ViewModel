package com.example.notes_app_viewmodel

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var addNote: EditText
    lateinit var btnsub: Button
    lateinit var Notes: List<Notes>
    lateinit var rvadap: RecyclerView
    var note =""

    // we create object class so we can access to MyViewModel class
    lateinit var mymodle: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addNote = findViewById(R.id.edtext)
        btnsub = findViewById(R.id.b1)
        rvadap = findViewById(R.id.rvmain)
        Notes = arrayListOf()
        // we create object class so we can access to MyViewModel class
        mymodle = ViewModelProvider(this).get(MyViewModel::class.java)

        updtRC()

// will add notes in arraylist
        btnsub.setOnClickListener {
            // her we will add note
            var note=addNote.text.toString()
            // we call Insertnote function to add the note to database
            mymodle.Insertnote(Notes(0,note))
            addNote.text.clear()
            addNote.clearFocus()
        }
    }
//    this function will observe if notes are updated it will update the database
    fun updtRC(){

        mymodle.getallnotes().observe(this,{
                AllNotes ->
            // her notes will display in recyclerview
            rvadap.adapter = myadap(this,AllNotes)
            rvadap.layoutManager = LinearLayoutManager(this)

        })

    }


    fun openwendow(oldnote: Notes){
        val dialog= AlertDialog.Builder(this)
        val newNote=EditText(this)
        val id = oldnote.id
        newNote.hint="Enter new text"
        dialog.setCancelable(false).setPositiveButton("Save", DialogInterface.OnClickListener {
                _, i -> mymodle.updatenote(id,newNote.text.toString())})

        dialog.setNegativeButton("Cancel", DialogInterface.OnClickListener { _, i ->  })
        // the alert will create if we press the edit icon the function edit will cal the updatNote function
        // in database so we can make change in database
        val Alert = dialog.create()
        Alert.setTitle("Update Note")
        // setView will show the value in edittext inside alert
        Alert.setView(newNote)
        Alert.show()


    }
}