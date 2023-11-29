package com.example.contactapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "ARG_ITEM_ID"

/**
 * A simple [Fragment] subclass.
 * Use the [ContactDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var itemId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itemId = it.getString(ARG_PARAM1)?.toInt()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact_detail, container, false)
        val contact = ContactModel.contacts[itemId?:0]

        view.findViewById<TextView>(R.id.name_text_view).text = contact.name
        view.findViewById<TextView>(R.id.id_text_view).text = contact.id
        view.findViewById<TextView>(R.id.phone_text_view).text = contact.number
        view.findViewById<TextView>(R.id.email_text_view).text = contact.email
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Item ID
         * @return A new instance of fragment ContactDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            ContactDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}