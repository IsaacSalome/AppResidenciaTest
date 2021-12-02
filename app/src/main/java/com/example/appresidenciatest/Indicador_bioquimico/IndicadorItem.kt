package com.example.appresidenciatest.Indicador_bioquimico

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
data class IndicadorItem(var id:Int,
                         var titulo:String,
                         var fecha: Date,
                         var ph_minimo:String,
                         var ph_maximo:String,
                         var MO_minimo:String,
                         var MO_maximo:String,
                         var Olsen_minimo:String,
                         var Olsen_maximo:String,
                         var Ca_minimo:String,
                         var Ca_maximo:String,
                         var Mg_minimo:String,
                         var Mg_maximo:String,
                         var K_minimo:String,
                         var K_maximo:String,
                         var CICE_minimo:String,
                         var CICE_maximo:String,
                         var C_minimo:String,
                         var C_maximo:String) :
    Parcelable
