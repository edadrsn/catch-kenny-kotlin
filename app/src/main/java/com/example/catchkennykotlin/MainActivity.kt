package com.example.catchkennykotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        val user_name=binding.nameText.text.toString()
        val user_email=binding.mailText.text.toString()
        if(!user_name.isEmpty() && !user_email.isEmpty()){
            sharedPreferences.edit().putString("user_name",user_name).apply()
            sharedPreferences.edit().putString("user_email",user_email).apply()
            Toast.makeText(this@MainActivity,"Saved!",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@MainActivity,"Username and email cannot be left blank",Toast.LENGTH_SHORT).show()
        }
    }


    fun delete(view:View){
        val user_name=binding.nameText.text.toString()
        val user_email=binding.mailText.text.toString()
        if(!user_name.isEmpty() && !user_email.isEmpty()){
            sharedPreferences.edit().remove("user_name").apply()
            sharedPreferences.edit().remove("user_email").apply()
            binding.nameText.setText("")
            binding.mailText.setText("")
            Toast.makeText(this@MainActivity,"Deleted",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@MainActivity,"There is no data to deleted",Toast.LENGTH_SHORT).show()
        }

    }

}