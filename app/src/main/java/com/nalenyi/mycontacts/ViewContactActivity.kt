package com.nalenyi.mycontacts

import android.location.Address
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.nalenyi.mycontacts.databinding.ActivityMainBinding
import com.nalenyi.mycontacts.databinding.ActivityViewContactBinding
import com.squareup.picasso.Picasso

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }

    fun getExtras(){
        var name = intent.extras?.getString("NAME")
        var address = intent.extras?.getString("ADDRESS")
        var email = intent.extras?.getString("EMAIL")
        var phoneNumber = intent.extras?.getString("PHONENUMBER")

        Toast.makeText(this,name, Toast.LENGTH_LONG).show()
        binding.tvname.text=name
        binding.tvLocation.text=address
        binding.tvEmail.text=email
//        binding.tvCalls.text=phoneNumber

        Picasso.get().load(intent.getStringExtra("image")).resize(200,200).centerCrop().into(binding.imgPerson1)

    }
}