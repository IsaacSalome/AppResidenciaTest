package com.example.appresidenciatest.Estaciones

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EstacionesItem(var id:Int, var nombre:String, var descripcion:String) : Parcelable

