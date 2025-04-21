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
    lateinit var selectedKenny:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences=getSharedPreferences("com.example.catchkennykotlin",Context.MODE_PRIVATE)
        val orangeKenny=binding.orangeKenny.toString()
        val pinkKenny=binding.pinkKenny.toString()
        val blueKenny=binding.blueKenny.toString()
        binding.btnStart.isEnabled=false

    }

    fun btnOrange(view:View){
        selectedKenny="orange"
        binding.btnStart.isEnabled=true
    }

    fun btnPink(view:View){
        selectedKenny="pink"
        binding.btnStart.isEnabled=true
    }

    fun btnBlue(view:View){
        selectedKenny="blue"
        binding.btnStart.isEnabled=true
    }

    fun startGame(view: View){
        val intent = Intent(this@MainActivity,MainActivity2::class.java)
        intent.putExtra("selectedKenny",selectedKenny)
        startActivity(intent)

    }

    fun save(view:View){

    }


    fun delete(view:View){

    }

    // sharedPreferences.edit().putString("user_name",binding.nameText.text.toString()).apply()
    //        sharedPreferences.edit().putString("user_email",binding.mailText.text.toString()).apply()
}