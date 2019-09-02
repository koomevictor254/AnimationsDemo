package com.example.animationsdemo
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycleractivity.*
import kotlinx.android.synthetic.main.activity_recycleractivity.view.*


class RecyclerActivity() : AppCompatActivity(), Parcelable {

	constructor(parcel: Parcel) : this() {
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_recycleractivity)

		setUpRecyclerView()
	}

	private fun setUpRecyclerView() {

		val adapter = RecyclerAdapter(this, Landscape.data)
		recyclerView.adapter=adapter

		val layoutManager = LinearLayoutManager(this)
		layoutManager.orientation = LinearLayoutManager.VERTICAL

		recyclerView.layoutManager = layoutManager

		recyclerView.itemAnimator = DefaultItemAnimator()
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {

	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<RecyclerActivity> {
		override fun createFromParcel(parcel: Parcel): RecyclerActivity {
			return RecyclerActivity(parcel)
		}

		override fun newArray(size: Int): Array<RecyclerActivity?> {
			return arrayOfNulls(size)
		}
	}
}

