package com.example.appresidenciatest.vitaminas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appresidenciatest.MyApp
import com.example.appresidenciatest.R
import kotlinx.android.synthetic.main.activity_addnew_vitamias_item.*
import kotlinx.android.synthetic.main.listitem_vitaminas.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class addnewVitamiasItemActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE_ADD_VITAMINAS_ITEM = 1000
        const val EXTRA_VITAMINAS_ITEM = "vitaminas_item"
        fun startActivity(activity: AppCompatActivity) {
            val intent = Intent(activity, addnewVitamiasItemActivity::class.java)
            activity.startActivityForResult(intent, REQUEST_CODE_ADD_VITAMINAS_ITEM)
        }
    }

    private var vitaminasitem = VitaminItem(-1, "", "", "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnew_vitamias_item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_add_vitaminas_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_none -> {
                if (etnombre.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Porfavor escribe un nombre", Toast.LENGTH_LONG).show()
                    return true
                }

                if (etabreviaturas.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Escribe un tipo de clima", Toast.LENGTH_LONG).show()
                    return true
                }

                vitaminasitem.nombre = etnombre.text.toString()
                vitaminasitem.abreviaturas = etabreviaturas.text.toString()
                vitaminasitem.porcentaje = etaporcentaje.text.toString()
                vitaminasitem.cantidad = etacantidad.text.toString()
                vitaminasitem.descripcion = etdescripcion.text.toString()


                addVitaminasItemToServer()

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addVitaminasItemToServer() {
        progressBar.visibility = View.VISIBLE
        MyApp.getInstance().getApiServices().vitaminas(vitaminasitem)
            .enqueue(object : Callback<VitaminItem> {
                override fun onResponse(
                    call: Call<VitaminItem>,
                    response: Response<VitaminItem>
                ) {
                    progressBar.visibility = View.GONE
                    val data = Intent()
                    data.putExtra(EXTRA_VITAMINAS_ITEM, vitaminasitem)
                    setResult(Activity.RESULT_OK, data)
                    finish()
                }

                override fun onFailure(call: Call<VitaminItem>, t: Throwable) {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this@addnewVitamiasItemActivity, "Failed to post", Toast.LENGTH_LONG).show()
                }

            })
    }
}

