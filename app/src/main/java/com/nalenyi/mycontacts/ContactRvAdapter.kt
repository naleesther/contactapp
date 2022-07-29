package com.nalenyi.mycontacts

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nalenyi.mycontacts.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso

class ContactRvAdapter(var contactList: List<Contact>):


    RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        var binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact = contactList.get(position)
        holder.binding.tvName.text = currentContact.name
        holder.binding.tvPhonenumber.text = currentContact.phoneNumber
        holder.binding.tvemail.text = currentContact.email
        holder.binding.tvAdress.text = currentContact.address
        Picasso.get()
            .load(currentContact.image)
            .resize(200,200)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_person_24)

            .into(holder.binding.ivContact)
        val context=holder.itemView.context
        holder.binding.ivContact.setOnClickListener {
            Toast
                .makeText(context,"You have clicked the image",Toast.LENGTH_SHORT)
                .show()
        }
        holder.binding.cvContact.setOnClickListener {
            val intent = Intent(context,ViewContactActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("ADDRESS",currentContact.address)
            intent.putExtra("EMAIL", currentContact.email)
            intent.putExtra("PHONENUMBER", currentContact.phoneNumber)
            intent.putExtra("image",currentContact.image)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}
class ContactViewHolder(val binding:ContactListItemBinding):
        RecyclerView.ViewHolder(binding.root)
