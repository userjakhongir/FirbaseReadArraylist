package com.example.firebasereadarraylist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firbasereadarraylist.databinding.RecylerviewItemBinding
import com.example.firbasereadarraylist.model.Personus

class PersonusAdapter constructor(
    val context: Context,
    val arrayList: ArrayList<Personus>
):RecyclerView.Adapter<PersonusAdapter.PersounusViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersounusViewHolder {
        val view = RecylerviewItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return PersounusViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: PersounusViewHolder, position: Int) {

        holder.binding.apply {
            textviewrecycfirstname.text=arrayList.get(position).firstname
            textviewrecyclastname.text=arrayList.get(position).lastname
        }
    }

    class PersounusViewHolder(val binding: RecylerviewItemBinding):RecyclerView.ViewHolder(binding.root)

}