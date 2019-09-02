package com.example.animationsdemo

import android.animation.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Animator.AnimatorListener {

    private var rotateAnimator: ObjectAnimator?=null
    private var scaleAnimator: ObjectAnimator?=null
    private var translateAnimator: ObjectAnimator?=null
    private var fadeAnimator: ObjectAnimator?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun fadeAnimation(view: View) {
        fadeAnimator=ObjectAnimator.ofFloat(target_image,"alpha",1.0f,0.0f)
        fadeAnimator?.apply {
            duration=1500
            repeatCount=1
            repeatMode=ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()

        }

    }
    fun rotateAnimation(view: View) {

        rotateAnimator=ObjectAnimator.ofFloat(target_image,"rotation",0.0f,-180f)
        rotateAnimator?.apply {
            duration=1000
            repeatMode=ValueAnimator.REVERSE
            repeatCount=1
            addListener(this@MainActivity)
            start()
        }
    }
    fun scaleAnimation(view: View) {
        scaleAnimator=ObjectAnimator.ofFloat(target_image,"scaleX",1.0f,3.0f)
        scaleAnimator?.apply {
            duration=1000
            repeatCount=1
            repeatMode=ValueAnimator.REVERSE
            addListener(this@MainActivity)
            start()
        }

    }
    fun translateAnimation(view: View) {
       translateAnimator=ObjectAnimator.ofFloat(target_image,"translationX",0f,200f)
        translateAnimator?.apply {
            duration=1000
            repeatMode=ValueAnimator.REVERSE
            repeatCount=1
            addListener(this@MainActivity)
            start()
        }
    }
    fun setFromXml(view: View){
        val setAnimator=AnimatorInflater.loadAnimator(this,R.animator.set)
        setAnimator.apply {
            setTarget(target_image)
            start()
        }
    }
fun setFromCode(view: View) {

    //Root Animation set
    val rootSet=AnimatorSet()

    //Flip Animation set
    val flip=ObjectAnimator.ofFloat(target_image,"rotationX",0f,360f)
    flip.duration=500

    //child Animation set
    val childset=AnimatorSet()

    //Scale Animations
    val scaleX=ObjectAnimator.ofFloat(target_image,"scaleX",1.0f,1.5f)
    scaleX.duration=1000
    scaleX.interpolator=BounceInterpolator()

    val scaleY=ObjectAnimator.ofFloat(target_image, "scaleY", 1.0f, 1.5f)
    scaleY.duration=1000
    scaleY.interpolator=BounceInterpolator()
    //rootSet.playSequentially(flip,childset)
    //childset.playTogether(scaleX,scaleY)
    rootSet.play(flip).before(childset)
    childset.play(scaleX).with(scaleY)
    rootSet.start()
}

    fun viewPropertyAnimator(view: View) {
        val vpa=target_image.animate()
        vpa.apply {
            duration=1000
            rotationX(360.0f)
            scaleX(1.5f)
            scaleY(1.5f)
            alpha(0.5f)
            translationX(200.0f)


            interpolator=OvershootInterpolator()
            start()
        }

    }

    fun propertyValuesHolder(view: View) {

        val rotX=PropertyValuesHolder.ofFloat("rotationX",360f)
        val scaleX=PropertyValuesHolder.ofFloat("scaleX",1.5f)
        val scaleY=PropertyValuesHolder.ofFloat("scaleY",1.5f)

        val objA=ObjectAnimator.ofPropertyValuesHolder(target_image,rotX,scaleX,scaleY)
        objA.apply {
            duration=1000
            interpolator=OvershootInterpolator()
            start()
        }

    }
    //This is the implementation of the AnimatorListener Interface
    override fun onAnimationRepeat(Animation: Animator?) {
        if(Animation==scaleAnimator)
           Toast.makeText(this,"Scale Animation Repeated",Toast.LENGTH_LONG).show()
        if (Animation==rotateAnimator)
            Toast.makeText(this,"Rotate Animation Repeated",Toast.LENGTH_LONG).show()
        if (Animation==translateAnimator)
            Toast.makeText(this,"Translate Animation Repeated",Toast.LENGTH_LONG).show()
        if (Animation==fadeAnimator)
            Toast.makeText(this,"Fade Animation Repeated",Toast.LENGTH_LONG).show()

    }

    override fun onAnimationEnd(Animation: Animator?) {
        if(Animation==scaleAnimator)
        Toast.makeText(this,"Scale Animation Ended",Toast.LENGTH_LONG).show()
        if (Animation==rotateAnimator)
            Toast.makeText(this,"Rotate Animation Ended",Toast.LENGTH_LONG).show()
        if (Animation==translateAnimator)
            Toast.makeText(this,"Translate Animation Ended",Toast.LENGTH_LONG).show()
        if (Animation==fadeAnimator)
            Toast.makeText(this,"Fade Animation Ended",Toast.LENGTH_LONG).show()

    }

    override fun onAnimationCancel(Animation: Animator?) {
        if(Animation==scaleAnimator)
            Toast.makeText(this,"Scale Animation Cancelled",Toast.LENGTH_LONG).show()
        if (Animation==rotateAnimator)
            Toast.makeText(this,"Rotate Animation Cancelled",Toast.LENGTH_LONG).show()
        if (Animation==translateAnimator)
            Toast.makeText(this,"Translate Animation Cancelled",Toast.LENGTH_LONG).show()
        if (Animation==fadeAnimator)
            Toast.makeText(this,"Fade Animation Cancelled",Toast.LENGTH_LONG).show()

    }

    override fun onAnimationStart(Animation: Animator?) {
        if(Animation==scaleAnimator)
            Toast.makeText(this,"Scale Animation Started",Toast.LENGTH_LONG).show()
        if (Animation==rotateAnimator)
            Toast.makeText(this,"Rotate Animation Started",Toast.LENGTH_LONG).show()
        if (Animation==translateAnimator)
            Toast.makeText(this,"Translate Animation Started",Toast.LENGTH_LONG).show()
        if (Animation==fadeAnimator)
            Toast.makeText(this,"Fade Animation Started",Toast.LENGTH_LONG).show()

    }

}
