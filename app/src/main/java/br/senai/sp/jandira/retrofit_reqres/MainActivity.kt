package br.senai.sp.jandira.retrofit_reqres

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)


        // Botão de get
        findViewById<Button>(R.id.btnGET).setOnClickListener{
            //Log.e("getting-data", "teste de botao get")
            getUserByID()
        }
        // Botão de put
        findViewById<Button>(R.id.btnPUT).setOnClickListener{
            Log.e("putting-data", "teste de botao put")
        }
        // Botão de delete
        findViewById<Button>(R.id.btnDELETE).setOnClickListener{
            Log.e("deleting-data", "teste de botao delete")
        }
        // Botão de post
        findViewById<Button>(R.id.btnPOST).setOnClickListener{
            Log.e("posting-data", "teste de botao post")
        }
    }

    private fun getUserByID() {
        lifecycleScope.launch {
            val result = apiService.getUserById("2")

            if(result.isSuccessful) {
                Log.e("gettitng-data", "${result.body()?.data}")
            }
            else{
                Log.e("gettitng-data", "${result.message()}")
            }

        }
    }
}