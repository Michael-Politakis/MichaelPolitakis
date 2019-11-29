package com.renzard.michaelpolitakis.ui.call

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

class CallFragment : Fragment() {

    private lateinit var callViewModel: CallViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        callViewModel =
            ViewModelProviders.of(this).get(CallViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        callViewModel.text.observe(this, Observer {
            textView.text = it
        })
        callMichael()
        return root
    }

    private fun callMichael() {
        val phone = "306983874261"
        val call = Intent(
            Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null)
        )
        try {
            startActivity(Intent.createChooser(call, "Call Michael"))
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(
                context, "No call clients Installed",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}