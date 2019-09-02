package com.example.animationsdemo

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_charging.*

class Charging : AppCompatActivity() {
lateinit var batteryAnimation:AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charging)


    }

    override fun onStart() {
        super.onStart()
        img_battery.setBackgroundResource(R.drawable.battery_animation_list)
        batteryAnimation=img_battery.background as AnimationDrawable
        //batteryAnimation.start()
    }

    fun startStopAnimation(view: View){
        if (batteryAnimation.isRunning)
            batteryAnimation.stop()
        else
            batteryAnimation.start()
    }
}
