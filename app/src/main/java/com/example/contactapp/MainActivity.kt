package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.ContactModel.Companion.contacts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts = ContactModel.contacts;
        contacts.add(ContactModel("1","My Name","099843938","demo@gmail.com"));
        contacts.add(ContactModel("2","My Name 2","099843938","demo@gmail.com"));
        contacts.add(ContactModel("3","My Name 3","099843938","demo@gmail.com"));
        contacts.add(ContactModel("4","My Name 4","099843938","demo@gmail.com"));
        contacts.add(ContactModel("5","My Name 5","099843938","demo@gmail.com"));

        val contactAdapter = ContactAdapter(contacts);
        val layoutManager =LinearLayoutManager(this);

        val contactListRecyclerView = findViewById<RecyclerView>(R.id.contact_list_recycler_view)
        contactListRecyclerView.adapter = contactAdapter
        contactListRecyclerView.layoutManager = layoutManager
    }
}