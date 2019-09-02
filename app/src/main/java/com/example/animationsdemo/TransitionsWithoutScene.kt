package com.example.animationsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.view.Gravity
import android.view.View
import androidx.transition.Fade
import androidx.transition.Slide
import androidx.transition.Transition
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_transition.*
import kotlinx.android.synthetic.main.activity_transition.sceneRoot
import kotlinx.android.synthetic.main.activity_transitions_without_scene.*

class TransitionsWithoutScene : AppCompatActivity() {
    private var visibility=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transitions_without_scene)
    }



    fun fadeAnimation(view: View) {

        val transition: Transition=Fade()

        TransitionManager.beginDelayedTransition(sceneRoot1,transition)

        txvDescription.visibility = if (visibility) View.INVISIBLE else View.VISIBLE
        visibility = !visibility
    }

    fun slideEffect(view: View){

        val transition :Transition = Slide(Gravity.END)
        TransitionManager.beginDelayedTransition(sceneRoot1,transition)



        txvDescription.visibility = if (visibility) View.INVISIBLE else View.VISIBLE
        visibility = !visibility



    }
}
