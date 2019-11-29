package com.renzard.michaelpolitakis.ui.github

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

class GithubFragment : Fragment() {

    private lateinit var githubViewModel: GithubViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        githubViewModel =
            ViewModelProviders.of(this).get(GithubViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_github, container, false)
        val textView: TextView = root.findViewById(R.id.text_tools)
        githubViewModel.text.observe(this, Observer {
            textView.text = it
        })

        githubOpen()
        return root
    }

    private fun githubOpen() {
        val url = "https://github.com/Renzard"
        val webOpen = Intent(
            Intent.ACTION_VIEW
        )
        webOpen.data = Uri.parse(url)
        try {
            startActivity(Intent.createChooser(webOpen, "Open Github"))
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(
                context, "No email clients installed",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}