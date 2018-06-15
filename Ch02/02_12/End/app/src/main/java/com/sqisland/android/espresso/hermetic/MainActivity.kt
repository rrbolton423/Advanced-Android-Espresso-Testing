package com.sqisland.android.espresso.hermetic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.joda.time.DateTime
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
  @Inject
  lateinit var clock: Clock

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val app = application as GreetingApplication
    app.component.inject(this)

    val greetingId = when (clock.getNow().hourOfDay) {
      in 5..12 -> R.string.greeting_morning
      in 12..17 -> R.string.greeting_afternoon
      in 17..23 -> R.string.greeting_evening
      else -> R.string.greeting_night
    }

    val greetingView = findViewById<TextView>(R.id.greeting)
    greetingView.setText(greetingId)
  }
}