package com.skefenzer.archcomponent

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.skefenzer.archcomponent.model.Contact

class MainViewModel : ViewModel() {

    var contacsLD = MutableLiveData<MutableList<Contact>>()

}