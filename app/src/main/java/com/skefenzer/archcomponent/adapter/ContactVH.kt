package com.skefenzer.archcomponent.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.skefenzer.archcomponent.model.Contact
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun setUp(contact: Contact, position: Int, listener: ((position: Int) -> Unit)?) {
        itemView?.tvName?.text = contact.name
        itemView?.tvPhone?.text = contact.phone
        itemView?.btnRemove?.setOnClickListener {
            listener?.invoke(position)
        }
    }

}