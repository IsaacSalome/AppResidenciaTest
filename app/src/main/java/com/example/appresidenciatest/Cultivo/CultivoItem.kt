package com.example.appresidenciatest.Cultivo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CultivoItem(var id:Int, var tipoCultivo :String, var nombre:String, var nombreCientifico:String, var fertilizantes:String, var vitamina:String, var mineral:String, var estacion:String, var clima:String, var fotos:String ) :
    Parcelable
