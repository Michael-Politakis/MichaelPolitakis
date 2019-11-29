package com.renzard.michaelpolitakis.ui.call

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CallViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "6983874261"
    }
    val text: LiveData<String> = _text


}