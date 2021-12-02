package com.example.appresidenciatest.Minerales

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MineralesItem(var id:Int, var nombre:String, var abreviaturas:String, var porcentaje:String, var cantidad:String, var descripcion:String) : Parcelable
