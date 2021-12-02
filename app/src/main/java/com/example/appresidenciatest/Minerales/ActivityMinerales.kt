package com.example.appresidenciatest.Minerales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appresidenciatest.DeleteResponse
import com.example.appresidenciatest.MyApp
import com.example.appresidenciatest.R
import kotlinx.android.synthetic.main.activity_minerales.*
import retrofit2.Call
import retrofit2.Response

class ActivityMinerales : AppCompatActivity(), AdapterMineralItem.onDeleteItemCliCkListener {

    private val adapterMineralItem = AdapterMineralItem()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapterMineralItem
        adapterMineralItem.onDeleteItemClickListener = this@ActivityMinerales
        faAddclimaitem.setOnClickListener {
            addnewMineralesItm.startActivity(this)
        }
        MyApp.getInstance().getApiServices().mineral().enqueue(object :retrofit2.Callback<List<MineralesItem>>{
            override fun onResponse(
                call: Call<List<MineralesItem>>,
                response: Response<List<MineralesItem>>
            ) {
                if (response.isSuccessful && !response.body().isNullOrEmpty()){
                    adapterMineralItem.setList(response.body() as ArrayList<MineralesItem>)
                }else{
                    Toast.makeText(this@ActivityMinerales, "Error loading list", Toast.LENGTH_LONG).show()
                }            }

            override fun onFailure(call: Call<List<MineralesItem>>, t: Throwable) {
                Toast.makeText(this@ActivityMinerales, "Error loading list", Toast.LENGTH_LONG).show()
            }
        })
    }



    override fun onDeleteItem(mineralesItem: MineralesItem, position: Int) {
        MyApp.getInstance().getApiServices().deletemineralItem(mineralesItem.id).enqueue(object: retrofit2.Callback<DeleteResponse>{
            override fun onResponse(
                call: Call<DeleteResponse>,
                response: Response<DeleteResponse>
            ) {
                if (response.isSuccessful && response.body()!= null){
                    Toast.makeText(this@ActivityMinerales,response.body()?.response, Toast.LENGTH_LONG).show()
                    adapterMineralItem.deleteItem(position)
                }else{
                    Toast.makeText(this@ActivityMinerales, "Error deleting item", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(
                call: Call<DeleteResponse>,
                t: Throwable
            ) {
                Toast.makeText(this@ActivityMinerales,"Error deleting item", Toast.LENGTH_LONG).show()
            }
        })
    }
}