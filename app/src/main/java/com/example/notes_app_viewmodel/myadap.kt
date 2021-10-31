package com.example.notes_app_viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes_app_viewmodel.databinding.ListItemBinding


class myadap (val activity:MainActivity, var Notes:List<Notes>): RecyclerView.Adapter<myadap.ItemViewHolder>(){

    class ItemViewHolder(val binding:ListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            (ListItemBinding.inflate(
                LayoutInflater.from(parent.context),parent
                ,false)))

    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val NOTE = Notes[position]
        holder.binding.apply {
            textv.text=NOTE.Note
            imgbrvEdit.setOnClickListener {
                activity.openwendow(NOTE)



            }

            imgbrvdelete.setOnClickListener {
           activity.mymodle.deletenote(NOTE.id)


            }

        }
    }

    override fun getItemCount() = Notes.size


}