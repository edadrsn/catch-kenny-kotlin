package com.example.catchkennykotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.catchkennykotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var sharedPreferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences=getSharedPreferences("com.example.catchkennykotlin",Context.MODE_PRIVATE)

    }

    fun btnStart(view: View){
        val intent= Intent(this@MainActivity,MainActivity2::class.java)
        sharedPreferences.edit().putString("user_name",binding.nameText.text.toString()).apply()
        sharedPreferences.edit().putString("user_email",binding.mailText.text.toString()).apply()
        startActivity(intent)

    }
}