package com.example.animationsdemo

import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import kotlinx.android.synthetic.main.activity_vector_animation.*

class VectorAnimation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector_animation)
        var isChecked=true
        img_avd.setOnClickListener {
           if (isChecked)
               checkToClose()
            else
               closeToCheck()
               isChecked=!isChecked
        }
    }
    private fun closeToCheck() {
        img_avd.setImageResource(R.drawable.avd_close_to_check)
        val avdCheckToClose=img_avd.drawable as AnimatedVectorDrawableCompat
        avdCheckToClose.start()
    }
    private fun checkToClose() {
    img_avd.setImageResource(R.drawable.avd_check_to_close)
    val avdCheckToClose=img_avd.drawable as AnimatedVectorDrawableCompat
    avdCheckToClose.start()
}

}
