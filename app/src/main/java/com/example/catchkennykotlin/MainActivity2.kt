package com.example.catchkennykotlin

import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.catchkennykotlin.databinding.ActivityMain2Binding
import kotlin.random.Random
import kotlin.random.Random as Random1

class MainActivity2 : AppCompatActivity() {

    lateinit var binding : ActivityMain2Binding
    var score=0
    var orangeArray=ArrayList<ImageView>()
    var pinkArray=ArrayList<ImageView>()
    var blueArray=ArrayList<ImageView>()
    var catArray=ArrayList<ImageView>()
    var imageArray=ArrayList<ImageView>()
    var runnable=Runnable{}
    var handler= Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        //IMAGEARRAY
        orangeArray.add(binding.orange1)
        orangeArray.add(binding.orange2)
        orangeArray.add(binding.orange3)
        orangeArray.add(binding.orange4)
        orangeArray.add(binding.orange5)
        orangeArray.add(binding.orange6)
        orangeArray.add(binding.orange7)
        orangeArray.add(binding.orange8)
        orangeArray.add(binding.orange9)


        pinkArray.add(binding.pink1)
        pinkArray.add(binding.pink2)
        pinkArray.add(binding.pink3)
        pinkArray.add(binding.pink4)
        pinkArray.add(binding.pink5)
        pinkArray.add(binding.pink6)
        pinkArray.add(binding.pink7)
        pinkArray.add(binding.pink8)
        pinkArray.add(binding.pink9)

        blueArray.add(binding.blue1)
        blueArray.add(binding.blue2)
        blueArray.add(binding.blue3)
        blueArray.add(binding.blue4)
        blueArray.add(binding.blue5)
        blueArray.add(binding.blue6)
        blueArray.add(binding.blue7)
        blueArray.add(binding.blue8)
        blueArray.add(binding.blue9)

        catArray.add(binding.cat1)
        catArray.add(binding.cat2)
        catArray.add(binding.cat3)
        catArray.add(binding.cat4)
        catArray.add(binding.cat5)
        catArray.add(binding.cat6)
        catArray.add(binding.cat7)
        catArray.add(binding.cat8)
        catArray.add(binding.cat9)
        hideImages()


        var getSelectedKenny=intent.getStringExtra("selectedKenny")
        if(getSelectedKenny.equals("orange")){
            imageArray=orangeArray
            binding.gridLayoutOrange.visibility= View.VISIBLE
            binding.gridLayoutCat.visibility=View.VISIBLE

        }else if(getSelectedKenny.equals("pink")){
            imageArray=pinkArray
            binding.gridLayoutPink.visibility=View.VISIBLE
            binding.gridLayoutCat.visibility=View.VISIBLE

        }
        else{
            imageArray=blueArray
            binding.gridLayoutBlue.visibility=View.VISIBLE
            binding.gridLayoutCat.visibility=View.VISIBLE

        }

    }

    fun hideImages() {

        runnable = object : Runnable {
            override fun run() {

                for(image in imageArray){
                   image.visibility=View.VISIBLE
                }
                val random= java.util.Random()
                val randomIndex=random.nextInt(9)
                imageArray[randomIndex].visibility=View.VISIBLE
                handler.postDelayed(runnable, 500)
            }
        }
        handler.post(runnable)

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