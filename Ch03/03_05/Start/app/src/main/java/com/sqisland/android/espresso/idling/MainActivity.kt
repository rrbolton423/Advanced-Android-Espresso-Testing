package com.sqisland.android.espresso.idling

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {
  private lateinit var textView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    textView = findViewById<TextView>(R.id.text)

    val fragment = LoadingDialogFragment()
    fragment.isCancelable = false
    fragment.show(supportFragmentManager, LoadingDialogFragment.TAG)
  }

  fun onLoadingFinished() {
    textView.setText(R.string.done)
  }
}