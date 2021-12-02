package com.example.appresidenciatest.Suelo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SueloItem(var id:Int, var nombre:String, var descripcion:String, var fotos:String, var humedad:String, var ubicacion:String, var datos_bioquimicos:String) :    Parcelable
