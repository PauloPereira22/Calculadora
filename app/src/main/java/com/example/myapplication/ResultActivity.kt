package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        var classificacao = if(result < 18.5){
            "Abaixo do peso"
        }else if(result in 18.5..24.9){
            "Normal"
        }else if(result in 25.0..29.9){
            "Sobrepeso"
        }else if(result in 30.0..34.9){
            "Obesidade grau I"
        }else if(result in 35.0..39.9){
            "Obsesidade grau II"
        }else {
            "Obesidade grau III"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}