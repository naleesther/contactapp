package com.nalenyi.mycontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nalenyi.mycontacts.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso

class ContactRvAdapter(var contactList: List<Contact>):
    RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_list_item,parent,false)
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
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}
class ContactViewHolder(val binding:ContactListItemBinding):
        RecyclerView.ViewHolder(binding.root)
