package com.renzard.michaelpolitakis.ui.send

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SendViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "michael.politakis.w@gmail.com"
    }
    val text: LiveData<String> = _text


}