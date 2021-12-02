package com.example.appresidenciatest.vitaminas

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VitaminItem(var id:Int, var nombre:String, var abreviaturas:String, var porcentaje:String, var cantidad:String, var descripcion:String) : Parcelable
