package com.example.contactapp

data class ContactModel(val id: String, val name: String, val number: String, val email: String) {

    companion object {
        var contacts = ArrayList<ContactModel>()
    }
}