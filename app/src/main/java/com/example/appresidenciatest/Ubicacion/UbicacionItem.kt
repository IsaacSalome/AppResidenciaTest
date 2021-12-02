package com.example.appresidenciatest.Ubicacion

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UbicacionItem(var id:Int, var direccion:String, var latitud:String, var longitud:String, var pais:String) :  Parcelable
