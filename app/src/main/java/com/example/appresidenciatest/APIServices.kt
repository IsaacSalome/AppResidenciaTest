package com.example.appresidenciatest

import com.example.appresidenciatest.Cultivo.CultivoItem
import com.example.appresidenciatest.Estaciones.EstacionesItem
import com.example.appresidenciatest.Fertilizantes.FertilizantesItem
import com.example.appresidenciatest.Indicador_bioquimico.IndicadorItem
import com.example.appresidenciatest.Minerales.MineralesItem
import com.example.appresidenciatest.Suelo.SueloItem
import com.example.appresidenciatest.Ubicacion.UbicacionItem
import com.example.appresidenciatest.vitaminas.VitaminItem
import retrofit2.Call
import retrofit2.http.*

interface APIServices {

    //Método API de la tabla de climas
    @POST("clima")
    fun clima(@Body climaitem: ClimaItem) : Call<ClimaItem>


    @GET("clima")
    fun clima() : Call<List<ClimaItem>>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "clima", hasBody = true)
    fun deleteclimaItem(@Field("id") id: Int): Call<DeleteResponse>

    //Método API de la tabla de Vitaminas
    @POST("vitamina")
    fun vitaminas(@Body vitaminasItem: VitaminItem) : Call<VitaminItem>


    @GET("vitamina")
    fun vitaminas() : Call<List<VitaminItem>>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "vitamina", hasBody = true)
    fun deletevitaminasItem(@Field("id") id: Int): Call<DeleteResponse>


    //Método API de la tabla de Minerales
    @POST("mineral")
    fun mineral(@Body mineralesItem: MineralesItem) : Call<MineralesItem>


    @GET("mineral")
    fun mineral() : Call<List<MineralesItem>>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "mineral", hasBody = true)
    fun deletemineralItem(@Field("id") id: Int): Call<DeleteResponse>

    //Método API de la tabla de fertilizante
    @POST("fertilizante")
    fun fertilizante(@Body fertilizantesItem: FertilizantesItem) : Call<FertilizantesItem>


    @GET("fertilizante")
    fun fertilizante() : Call<List<FertilizantesItem>>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "fertilizante", hasBody = true)
    fun deletefertilizanteItem(@Field("id") id: Int): Call<DeleteResponse>


    //Método API de la tabla de estacion
    @POST("estacion")
    fun estacion(@Body estacionesItem: EstacionesItem) : Call<EstacionesItem>


    @GET("estacion")
    fun estacion() : Call<List<EstacionesItem>>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "fertilizante", hasBody = true)
    fun deleteestacionteItem(@Field("id") id: Int): Call<DeleteResponse>


    //Método API de la tabla de ubicacion
    @POST("ubicacion")
    fun ubicacion(@Body ubicacionItem: UbicacionItem) : Call<UbicacionItem>


    @GET("ubicacion")
    fun ubicacion() : Call<List<UbicacionItem>>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "ubicacion", hasBody = true)
    fun deleteubicacionteItem(@Field("id") id: Int): Call<DeleteResponse>


    //Método API de la tabla de indicadorBio
    @POST("indicadorBio")
    fun indicadorBio(@Body indicadorItem: IndicadorItem) : Call<IndicadorItem>


    @GET("indicadorBio")
    fun indicadorBio() : Call<List<IndicadorItem>>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "indicadorBio", hasBody = true)
    fun deleteindicadorBioteItem(@Field("id") id: Int): Call<DeleteResponse>


    //Método API de la tabla de suelo
    @POST("suelo")
    fun indicadorBio(@Body sueloItem: SueloItem) : Call<SueloItem>


    @GET("suelo")
    fun suelo() : Call<List<SueloItem>>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "suelo", hasBody = true)
    fun deletesueloteItem(@Field("id") id: Int): Call<DeleteResponse>



    //Método API de la tabla de cultivo
    @POST("cultivo")
    fun cultivo(@Body cultivoItem: CultivoItem) : Call<CultivoItem>


    @GET("cultivo")
    fun cultivo() : Call<List<CultivoItem>>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "cultivo", hasBody = true)
    fun deletecultivosItem(@Field("id") id: Int): Call<DeleteResponse>

}

data class DeleteResponse(var response: String)