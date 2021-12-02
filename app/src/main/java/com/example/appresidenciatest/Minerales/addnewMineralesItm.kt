package com.example.appresidenciatest.Minerales

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.appresidenciatest.MyApp
import com.example.appresidenciatest.R
import kotlinx.android.synthetic.main.activity_addnew_minerales_itm.*
import kotlinx.android.synthetic.main.activity_addnew_minerales_itm.etnombre
import kotlinx.android.synthetic.main.listitem_minerales.*
import kotlinx.android.synthetic.main.listitem_vitaminas.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class addnewMineralesItm : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE_ADD_MINERALES_ITEM = 1000
        const val EXTRA_MINERALES_ITEM = "minerales_item"
        fun startActivity(activity: AppCompatActivity) {
            val intent = Intent(activity, addnewMineralesItm::class.java)
            activity.startActivityForResult(intent, REQUEST_CODE_ADD_MINERALES_ITEM)
        }
    }

    private var mineralesItem = MineralesItem(-1, "", "", "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnew_minerales_itm)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_add_minerales_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_none -> {
                if (etnombre.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Porfavor escribe un nombre", Toast.LENGTH_LONG).show()
                    return true
                }

                if (etabreviatura.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Escribe un tipo de clima", Toast.LENGTH_LONG).show()
                    return true
                }
                if (etaporcentaje.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Escribe un tipo de clima", Toast.LENGTH_LONG).show()
                    return true
                }

                if (etacantidad.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Escribe un tipo de clima", Toast.LENGTH_LONG).show()
                    return true
                }

                if (etdescripcion.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Escribe un tipo de clima", Toast.LENGTH_LONG).show()
                    return true
                }


                mineralesItem.nombre = etnombre.text.toString()
                mineralesItem.abreviaturas = etabreviatura.text.toString()
                mineralesItem.porcentaje = etaporcentaje.text.toString()
                mineralesItem.cantidad = etacantidad.text.toString()
                mineralesItem.descripcion = etdescripcion.text.toString()


                addMineralesItemToServer()

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addMineralesItemToServer() {
        progressBar.visibility = View.VISIBLE
        MyApp.getInstance().getApiServices().mineral(mineralesItem)
            .enqueue(object : Callback<MineralesItem> {
                override fun onResponse(
                    call: Call<MineralesItem>,
                    response: Response<MineralesItem>
                ) {
                    progressBar.visibility = View.GONE
                    val data = Intent()
                    data.putExtra(EXTRA_MINERALES_ITEM, mineralesItem)
                    setResult(RESULT_OK, data)
                    finish()
                }

                override fun onFailure(call: Call<MineralesItem>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this@addnewMineralesItm, "Failed to post", Toast.LENGTH_LONG)
                        .show()
                }

            })
    }
}