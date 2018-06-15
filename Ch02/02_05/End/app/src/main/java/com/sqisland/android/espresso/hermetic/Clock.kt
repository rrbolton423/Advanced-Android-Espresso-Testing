package com.sqisland.android.espresso.hermetic

import org.joda.time.DateTime

class Clock {
  fun getNow() = DateTime()
}