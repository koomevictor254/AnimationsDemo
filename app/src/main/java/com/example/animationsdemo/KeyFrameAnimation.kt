package com.example.animationsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import kotlinx.android.synthetic.main.keyframe_animaton_detail.*

class KeyFrameAnimation : AppCompatActivity() {
    private var isDetailLayout = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_key_frame_animation)
        constraintLayout.setOnClickListener(){
            if(isDetailLayout)
                swapFrames(R.layout.activity_key_frame_animation)//switch to default layout
            else
                swapFrames(R.layout.keyframe_animaton_detail)//switch to detail layout
        }
    }
  private fun swapFrames(layoutId: Int){
    val constraintSet=ConstraintSet()
      constraintSet.clone(this,layoutId)

      val transition = ChangeBounds()
      transition.interpolator = AnticipateOvershootInterpolator(1.0f)
      transition.duration = 1200

      TransitionManager.beginDelayedTransition(constraintLayout)
      constraintSet.applyTo(constraintLayout)

      isDetailLayout = !isDetailLayout



    }
}
