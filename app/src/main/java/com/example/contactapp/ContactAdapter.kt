package com.example.contactapp

import android.content.Intent
import android.graphics.Color
import android.view.*
import android.view.View.OnClickListener
import android.view.View.OnCreateContextMenuListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.avatarfirst.avatargenlib.AvatarGenerator
import de.hdodenhof.circleimageview.CircleImageView


class ContactAdapter(private val contacts: List<ContactModel>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder(view: View): RecyclerView.ViewHolder(view),
        OnCreateContextMenuListener,
        OnClickListener{
        val nameTextView: TextView = view.findViewById(R.id.item_name_text_view)
        val avatarCircleImageView: CircleImageView =
            view.findViewById(R.id.avatar_circle_image_view)

        init {
            view.setOnCreateContextMenuListener(this)
            view.setOnClickListener(this)
        }


        override fun onCreateContextMenu(
            contextMenu: ContextMenu?,
            view: View?,
            contextMenuInfo: ContextMenu.ContextMenuInfo?
        ) {
            if (view != null) {
                contextMenu?.add(0, view.id, 0, "Call")
                contextMenu?.add(0, view.id, 0, "Message")
                contextMenu?.add(0, view.id, 0, "Email")
            };
        }

        override fun onClick(p0: View?) {

            val intent = Intent(p0?.context, ContactDetailActivity::class.java)
//            intent.putExtra("param1", edit1.text.toString())
//            intent.putExtra("param2", edit2.text.toString())
            //startActivity(intent)
            //startActivityForResult(intent, 123)
            try {

                intent.putExtra("contactPosition", adapterPosition)
                p0?.context?.startActivity(intent)
            } catch (e: java.lang.Exception) {
                print(e)
            }
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.avatarCircleImageView.setImageDrawable(
            contact.name?.get(0)?.let {
                AvatarGenerator.AvatarBuilder(holder.avatarCircleImageView.context)
                    .setLabel(it.toString())
                    .setAvatarSize(80)
                    .setTextSize(15)
                    .toSquare()
                    .toCircle()
                    .setBackgroundColor(Color.RED)
                    .build()
            }
        )

        holder.nameTextView.text = contact.name
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}