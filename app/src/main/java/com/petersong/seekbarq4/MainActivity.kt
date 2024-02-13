package com.petersong.seekbarq4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.SeekBar
import android.widget.Toast
import com.petersong.seekbarq4.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var f = 3200
    var c = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.creading.text = 0.0.toString()
        binding.freading.text = 32.00.toString()

        binding.seekBarc.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // write custom code when progress is changed
                    // °F = (°C × 9/5) + 32
                    if(fromUser){
                        c = progress
                        f = (progress * 1.8 +3200).toInt()
                        binding.seekBarf.progress = f

                        Log.d("TAG", "SeekBar C: f: $f")
                        Log.d("TAG", "Seekbar C: c: $c")
                        binding.creading.text = (c/100.0).toString()
                        binding.freading.text = (f/100.0).toString()
                    }
                    if(c <= 2000){
                        binding.interestingText.text = "I wish it were warmer."
                    }

                    else if(c > 2000){
                        binding.interestingText.text = "I wish it were colder."
                    }

                }
                override fun onStartTrackingTouch(p0: SeekBar) {
                    Log.d("TAG", "SeekBar C: OnStart()")
                }
                override fun onStopTrackingTouch(p0: SeekBar) {
                    Log.d("TAG", "SeekBar C: OnStop()")
                }
            }
        )
        binding.seekBarf.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // write custom code when progress is changed
                    // °F = (°C × 9/5) + 32

                    if(fromUser){
                        if(progress < 3200){
                            seekBar.progress = 3200
                            f = 3200
                            c = 0
                        }
                        else{
                            f = progress
                            c = ((0.55) * (progress - 3200)).toInt()
                        }
                        Log.d("TAG", "SeekBar F: f: $f")
                        Log.d("TAG", "SeekBar F: c: $c")

                        binding.seekBarc.progress = c
                        binding.creading.text = (c / 100.0).toString()
                        binding.freading.text = (f / 100.0).toString()
                    }
                }
                override fun onStartTrackingTouch(p0: SeekBar) {
                    Log.d("TAG", "SeekBar F: OnStart()")
                }
                override fun onStopTrackingTouch(p0: SeekBar) {
                    Log.d("TAG", "SeekBar F: OnStop()")
                }
            }
        )
//        binding.seekBarf.setOnSeekBarChangeListener(
//            object : SeekBar.OnSeekBarChangeListener{
//                override fun onProgressChanged(
//                    seekBar: SeekBar,
//                    progress: Int,
//                    fromUser: Boolean
//                ) {
//                    //°C = (°F − 32) x 5/9
//                    f = progress
//
//                    c = (f-32)*(5/9)
//
//                    binding.textc.text = c.toString()
//                    binding.textf.text = f.toString()
//                    binding.seekBarc.progress = c
//                }
//
//                override fun onStartTrackingTouch(seekBar: SeekBar) {
//
//                }
//
//                override fun onStopTrackingTouch(seekBar: SeekBar) {
//
//                }
//
//            }
//        )
    }
}