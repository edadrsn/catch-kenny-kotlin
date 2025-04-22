package com.example.catchkennykotlin

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.catchkennykotlin.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding : ActivityMain2Binding
    var score=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        var getSelectedKenny=intent.getStringExtra("selectedKenny")
        if(getSelectedKenny.equals("orange")){
            binding.gridLayoutOrange.visibility= View.VISIBLE
        }else if(getSelectedKenny.equals("pink")){
            binding.gridLayoutPink.visibility=View.VISIBLE
        }
        else{
            binding.gridLayoutBlue.visibility=View.VISIBLE
        }

    }

    fun increaseScore(view:View){
        score+=1
        binding.textScore.text="SCORE: ${score}"
    }

    fun decreaseScore(view:View){
        score-=2
        binding.textScore.text="SCORE: ${score}"
    }
}