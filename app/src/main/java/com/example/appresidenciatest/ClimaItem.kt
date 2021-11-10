package com.example.appresidenciatest

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClimaItem(var id:Int, var nombre:String, var tipo:String) : Parcelable