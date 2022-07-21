package com.nalenyi.mycontacts

import android.provider.ContactsContract

data class Contact(
    var name:String,
    var email:String,
    var phoneNumber:String,
    var address:String,
    var image:String
)
