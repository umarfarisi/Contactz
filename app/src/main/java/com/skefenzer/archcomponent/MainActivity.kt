package com.skefenzer.archcomponent

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.skefenzer.archcomponent.adapter.ContactAdapter
import com.skefenzer.archcomponent.model.Contact
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = lazy { ContactAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContacts.layoutManager = LinearLayoutManager(this)
        rvContacts.adapter = adapter.value

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.contacsLD.observe({ lifecycle }, this::populate)
        lifecycle.addObserver(MainObserver(this, viewModel))

    }

    private fun populate(contacts: List<Contact>?) {
        contacts?.let {
            adapter.value.contacts = it.toMutableList()
        }
    }

}
