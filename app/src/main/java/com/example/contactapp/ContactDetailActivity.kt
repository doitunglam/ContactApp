package com.example.contactapp

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)

        val contactPosition = intent.getIntExtra("contactPosition",-1)

        val contact = ContactModel.contacts[contactPosition]

        findViewById<TextView>(R.id.name_text_view).text = contact.name
        findViewById<TextView>(R.id.id_text_view).text = contact.id
        findViewById<TextView>(R.id.phone_text_view).text = contact.number
        findViewById<TextView>(R.id.email_text_view).text = contact.email





//        try {
//            val param1 = intent.getStringExtra("param1")?.toInt()
//            val param2 = intent.getStringExtra("param2")?.toInt()
//            val result = param1!! + param2!!
//
//            val textView = findViewById<TextView>(R.id.textView)
//            textView.text = "Param1: $param1\nParam2: $param2\nResult: $result\n"
//
//            intent.putExtra("result", result)
//
//            setResult(Activity.RESULT_OK, intent)
//        } catch (ex: Exception) {
//            setResult(Activity.RESULT_CANCELED)
//        }
    }


}