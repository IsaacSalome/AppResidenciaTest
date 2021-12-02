package com.example.appresidenciatest.vitaminas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appresidenciatest.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.faAddclimaitem
import kotlinx.android.synthetic.main.activity_main.recyclerview
import kotlinx.android.synthetic.main.activity_vitaminas.*
import retrofit2.Call
import retrofit2.Response

class ActivityVitaminas : AppCompatActivity(), AdapterVitaminasItem.onDeleteItemCliCkListener {

    private val adapterVitaminasItem = AdapterVitaminasItem()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapterVitaminasItem
        adapterVitaminasItem.onDeleteItemClickListener = this@ActivityVitaminas
        faAddclimaitem.setOnClickListener {
            addnewVitamiasItemActivity.startActivity(this)
        }
        MyApp.getInstance().getApiServices().vitaminas().enqueue(object :retrofit2.Callback<List<VitaminItem>>{
            override fun onResponse(
                call: Call<List<VitaminItem>>,
                response: Response<List<VitaminItem>>
            ) {
                if (response.isSuccessful && !response.body().isNullOrEmpty()){
                    adapterVitaminasItem.setList(response.body() as ArrayList<VitaminItem>)
                }else{
                    Toast.makeText(this@ActivityVitaminas, "Error loading list", Toast.LENGTH_LONG).show()
                }            }

            override fun onFailure(call: Call<List<VitaminItem>>, t: Throwable) {
                Toast.makeText(this@ActivityVitaminas, "Error loading list", Toast.LENGTH_LONG).show()
            }
        })
    }



    override fun onDeleteItem(vitaminasItem: VitaminItem, position: Int) {
        MyApp.getInstance().getApiServices().deletevitaminasItem(vitaminasItem.id).enqueue(object: retrofit2.Callback<DeleteResponse>{
            override fun onResponse(
                call: Call<DeleteResponse>,
                response: Response<DeleteResponse>
            ) {
                if (response.isSuccessful && response.body()!= null){
                    Toast.makeText(this@ActivityVitaminas,response.body()?.response, Toast.LENGTH_LONG).show()
                    adapterVitaminasItem.deleteItem(position)
                }else{
                    Toast.makeText(this@ActivityVitaminas, "Error deleting item", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(
                call: Call<DeleteResponse>,
                t: Throwable
            ) {
                Toast.makeText(this@ActivityVitaminas,"Error deleting item", Toast.LENGTH_LONG).show()
            }
        })
    }
}