package com.example.firbasereadarraylist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firbasereadarraylist.databinding.ActivityMainBinding
import com.example.firbasereadarraylist.model.Personus
import com.example.firebasereadarraylist.PersonusAdapter
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var databaseReference: DatabaseReference
    var arrayList = ArrayList<Personus>()
    lateinit var personusAdapter: PersonusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.apply {
            imgaeviewadd.setOnClickListener {
                startActivity(Intent(this@MainActivity, MainActivity2 :: class.java))
            }
        }

        databaseReference=FirebaseDatabase.getInstance().getReference().child("Personus")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                arrayList.clear()
                for (datasnapshot : DataSnapshot in snapshot.children){
                    val personus= datasnapshot.getValue(Personus::class.java)
                    arrayList.add(personus!!)
                }

                personusAdapter= PersonusAdapter(this@MainActivity,arrayList)
                binding.apply {
                    recycleerview1.layoutManager = LinearLayoutManager(this@MainActivity)
                    recycleerview1.adapter=personusAdapter
                }
            }


            override fun onCancelled(error: DatabaseError) {

            }

        })


    }
}