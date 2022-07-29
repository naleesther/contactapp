package com.nalenyi.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.nalenyi.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContacts()
    }
    fun displayContacts(){
        var contact = Contact("Esther","esthernalenyi@gmail.com","0746745729","254 Nairobi","https://images.unsplash.com/photo-1630510305975-1b1c9298e632?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YWZyaWNhbiUyMGxhZGllc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60")
        var contact2 = Contact("lark","larknyi@gmail.com","0746720729","204 Nakuru","https://images.unsplash.com/photo-1583147610149-78ac5cb5a303?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8YWZyaWNhbiUyMGxhZGllc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60")
        var contact3 = Contact("naregae","naregae@gmail.com","0746741699","123 Kitale","https://media.istockphoto.com/photos/modern-day-entrepreneurs-connect-together-on-social-media-picture-id1197155846?b=1&k=20&m=1197155846&s=170667a&w=0&h=CEjNsk9zziy4QZ06iKtjde1ItgJlAbE7Y5VNE6KUR44=")
        var contact4 = Contact("lisalove","lisa@gmail.com","0796895729","765 dago","https://images.unsplash.com/photo-1628144029346-8a98676311b6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=386&q=80")
        var contact5 = Contact("winnie","winnie@gmail.com","0723545729","001 landless","https://images.unsplash.com/photo-1526382925646-27b5eb86796e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjF8fGFmcmljYW4lMjBsYWRpZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        var contactsAdapter= listOf(contact,contact2,contact3,contact4,contact5)

        var contactAdapter = ContactRvAdapter(contactsAdapter)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = contactAdapter

    }
}