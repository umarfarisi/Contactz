package com.skefenzer.archcomponent.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.skefenzer.archcomponent.R
import com.skefenzer.archcomponent.model.Contact

class ContactAdapter(private val ctx: Context, private val listener: ((position: Int) -> Unit)? = null)
    : RecyclerView.Adapter<ContactVH>() {

    var contacts = listOf<Contact>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: ContactVH?, position: Int) {
        holder?.setUp(contacts[position], position, listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) =
            ContactVH(LayoutInflater.from(ctx).inflate(R.layout.item_contact, parent, false))

    override fun getItemCount() = contacts.size

}
