package com.renzard.michaelpolitakis.ui.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GithubViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "github.com/renzard"
    }
    val text: LiveData<String> = _text
}