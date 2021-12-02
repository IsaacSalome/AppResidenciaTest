package com.example.appresidenciatest.Fertilizantes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FertilizantesItem(var id:Int, var nombre:String, var tipofertilizantes:String, var descripcion:String) : Parcelable


