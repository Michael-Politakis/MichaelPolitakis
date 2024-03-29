package com.renzard.michaelpolitakis.ui.send

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.renzard.michaelpolitakis.R

class SendFragment : Fragment() {

    private lateinit var sendViewModel: SendViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sendViewModel =
            ViewModelProviders.of(this).get(SendViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_send, container, false)
        val textView: TextView = root.findViewById(R.id.text_send)
        sendViewModel.text.observe(this, Observer {
            textView.text = it
        })

        emailToMichael()
        return root
    }

    private fun emailToMichael() {
        val email = Intent(
            Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",
                "michael.politakis.w@gmail.com", null
            )
        )
        try {
            startActivity(Intent.createChooser(email, "Send mail to Michael"))
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(
                context, "No email clients installed",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}