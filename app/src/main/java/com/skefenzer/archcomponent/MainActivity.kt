package com.skefenzer.archcomponent

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.skefenzer.archcomponent.adapter.ContactAdapter
import com.skefenzer.archcomponent.model.Contact
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel = lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
    private val observer = lazy { MainObserver(this, viewModel.value) }
    private val adapter = lazy { ContactAdapter(this, observer.value::onContactRemove) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContacts.layoutManager = LinearLayoutManager(this)
        rvContacts.adapter = adapter.value
        rvContacts.animation = null

        lifecycle.addObserver(observer.value)

    }

    private fun populate(contacts: MutableList<Contact>?) {
        contacts?.let {
            adapter.value.contacts = it
        }
    }

}
