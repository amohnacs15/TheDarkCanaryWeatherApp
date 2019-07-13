package com.zhudapps.darkcanary.main

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import javax.inject.Inject

/**
 * Created by adrian mohnacs on 2019-07-12
 */ //don't forget to add DataManager as parameter here?
class MainViewModel @Inject constructor(val fusedLocationClient: FusedLocationProviderClient): ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    //val lastKnowLocationLiveData = MutableLiveData<Location>()

    @SuppressLint("MissingPermission") //supress permission check because we check in MainActivity (activity context is required)
    fun initUserLocation() {
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            // Got last known location. In some rare situations this can be null.
            Log.e(TAG, location.toString())
        }
    }
}