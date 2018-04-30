package com.skefenzer.archcomponent

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.support.v7.app.AppCompatActivity
import com.skefenzer.archcomponent.model.Contact

class MainObserver(private val activity: AppCompatActivity, private val viewModel: MainViewModel)
    : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun resume() {
        viewModel.contacsLD.value = mutableListOf(
                Contact("Badu", "08571234567890"),
                Contact("Budi", "081234567890"),
                Contact("Patan", "08571234567890")
        )
    }

    fun onContactRemove(position: Int) {
        viewModel.contacsLD.value?.removeAt(position)
        viewModel.contacsLD.value = viewModel.contacsLD.value
    }

}