package com.example.animationsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.view.View
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_transition.*

class TransitionActivity : AppCompatActivity() {
    private lateinit var scene1:Scene
    private lateinit var scene2:Scene
    private lateinit var currentScene:Scene
    private lateinit var transition:Transition
    private lateinit var transitionSet:TransitionSet


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)
        // Step 1: Create a Scene object for both the starting and ending layout
        scene1=Scene.getSceneForLayout(sceneRoot,R.layout.scene1,this)
        scene2= Scene.getSceneForLayout(sceneRoot,R.layout.scene2,this)
        // Step 2: Create a Transition object to define what type of animation you want

       // transition=TransitionInflater.from(this).inflateTransition(R.transition.example_2) //for use with xml
        //to use code only to animate..
        val cbTransition=ChangeBounds()
        cbTransition.duration=500
        cbTransition.interpolator=LinearInterpolator()

        val fadeInTransation=Fade(Fade.IN)
        fadeInTransation.duration=250
        fadeInTransation.startDelay=400
        fadeInTransation.addTarget(R.id.txvTitle)

        val fadeOutTransition=Fade(Fade.OUT)
        fadeOutTransition.duration=50
        fadeOutTransition.addTarget(R.id.txvTitle)

        transitionSet= TransitionSet()
        transitionSet.ordering=TransitionSet.ORDERING_TOGETHER
        transitionSet.addTransition(cbTransition)
        transitionSet.addTransition(fadeInTransation)
        transitionSet.addTransition(fadeOutTransition)


        scene1.enter()
        currentScene=scene1
    }

    fun onClick(view: View){
        // Step 3: Call TransitionManager.go() to run animation
        currentScene = if (currentScene==scene1){

            TransitionManager.go(scene2,transitionSet)
            scene2
        }else{
            TransitionManager.go(scene1,transitionSet)
            scene1
        }

    }
}
