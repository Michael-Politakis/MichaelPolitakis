package com.renzard.michaelpolitakis.ui.html
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.renzard.michaelpolitakis.R

class HtmlBioFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {


        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val webView: WebView = root.findViewById(R.id.bioView)
        webView.loadUrl("file:///android_asset/MichaelPolitakis.html")
        return root
    }


}

