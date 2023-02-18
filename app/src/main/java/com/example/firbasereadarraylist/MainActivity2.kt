package com.example.firbasereadarraylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.firbasereadarraylist.databinding.ActivityMain2Binding
import com.example.firbasereadarraylist.model.Personus
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Personus")

        binding.apply {
            btnadd.setOnClickListener {
                chekked()
                val personus = Personus(edittextfirstname.text.toString(), edittextlastname.text.toString())
                databaseReference.push().setValue(personus)
                progressbarr1.visibility= View.GONE
            }
        }
    }

    fun chekked(){
        if (binding.edittextfirstname.text.toString().isEmpty()){
            binding.edittextfirstname.setError("Empty")
        }else if (binding.edittextlastname.text.toString().isEmpty()){
            binding.edittextlastname.setError("Empty")
        }
        else{
            //  Toast.makeText(this@MainActivity2, "Nice", Toast.LENGTH_SHORT).show()
        }
    }
}