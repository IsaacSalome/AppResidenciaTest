package com.example.appresidenciatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.appresidenciatest.Minerales.ActivityMinerales
import com.example.appresidenciatest.vitaminas.ActivityVitaminas

class PrincipalActivity : AppCompatActivity() {
 /*   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }*/

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //   menuInflater.inflate(R.menu.menu_main, menu)

        if (item.getItemId() == R.id.menu_settings)
        {

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "hello")
            }
            startActivity(intent)

            Toast.makeText(this, "Configuración",

                Toast.LENGTH_LONG).show();

        }else if (item.getItemId() == R.id.menu_vitaminas){
            val intent = Intent(this, ActivityVitaminas::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "hello")
            }
            startActivity(intent)

            Toast.makeText(this, "Vitaminas",

                Toast.LENGTH_LONG).show();

        }else if (item.getItemId() == R.id.menu_Minerales){
            val intent = Intent(this, ActivityMinerales::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "hello")
            }
            startActivity(intent)

            Toast.makeText(this, "Vitaminas",

                Toast.LENGTH_LONG).show();
        }

        else

        {

            return super.onContextItemSelected(item);

        }

        return true;

    }

}