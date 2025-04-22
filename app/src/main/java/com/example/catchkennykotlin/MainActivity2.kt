package com.example.catchkennykotlin

import android.content.DialogInterface
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
        //Imageler tanımlandı kulanıcının seçtiği kenny imageına göre ilgili imageler visible yapılacak
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


        //Sayaç oluşturuldu
        object:CountDownTimer(25000,1000){

            //Her saniyede bir time yazısı güncelleniyor
            override fun onTick(millisUntilFinished: Long) {
              binding.textTime.text="TIME: ${millisUntilFinished/1000}"
            }

           //Süre bittiğinde kullanıcıya oyuna devam edip etmeyeceğini sormak için alert dialog oluşturuldu
            //Text ve Score yazıları güncellendi
            override fun onFinish() {
                binding.textTime.text="TIME'S UP !"
                binding.textScore.text="SCORE: ${score}"
                //Runnable durdurduk
                handler.removeCallbacks(runnable)
                for(img in imageArray){
                    img.visibility=View.INVISIBLE
                }

               //AlertDialog oluşturuldu
                val alert= AlertDialog.Builder(this@MainActivity2)
                alert.setTitle("Game Over")
                alert.setMessage("Do you want to play again?")
                alert.setPositiveButton("Yes",{dialoginterface,i ->
                //Restart
                    val intentFromMain2=intent
                    finish()
                    startActivity(intentFromMain2)

                })
                alert.setNegativeButton("No",{dialoginterface,i ->
                        binding.textTime.text="TIME: 25"
                        binding.textScore.text="SCORE: 0"
                        val intent= Intent(this@MainActivity2,MainActivity::class.java)
                        startActivity(intent)
                    })
                alert.show()
            }
        }.start()



        //Kullanıcı hangi kenny resmini seçtiyse ilgili grid özelliği visible yapıldı
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

    //Skoru artır
    fun increaseScore(view:View){
        score+=1
        binding.textScore.text="SCORE: ${score}"
    }

    //Skoru azalt
    fun decreaseScore(){
        score-=2
        binding.textScore.text="SCORE: ${score}"
    }


    //Handler ve Runnable oluşturuldu. for döngüsü ile dizideki resimlerin üzerinde gezildi ve görünümleri invisible yapıldı sonrasında random iki adet random sayı oluşturularak
    //ilk random sayıyla ilgil indexteki image görünür yapıldı diğer random sayı ile rastgele gelen indexteki kedi resmi görünür yapıldı ve kedi resimlerine basılınca decreaseScore metodu çağrılarak skor azaltıldı
    fun hideImages() {

        runnable = object : Runnable {
            override fun run() {
                for(image in imageArray){
                   image.visibility=View.INVISIBLE
                }
                for(image2 in catArray){
                    image2.visibility=View.INVISIBLE
                }
                val random= java.util.Random()
                val randomIndex1=random.nextInt(9)
                if (Random.nextBoolean()) {
                    val randomIndex2 = Random.nextInt(catArray.size)
                    catArray[randomIndex2].visibility = View.VISIBLE
                    catArray[randomIndex2].setOnClickListener(object: View.OnClickListener {
                        override fun onClick(v: View?) {
                            decreaseScore()
                        }
                    })
                }
                else{
                    imageArray[randomIndex1].visibility=View.VISIBLE
                }
                handler.postDelayed(runnable, 500)

            }
        }
        handler.post(runnable)

    }



}