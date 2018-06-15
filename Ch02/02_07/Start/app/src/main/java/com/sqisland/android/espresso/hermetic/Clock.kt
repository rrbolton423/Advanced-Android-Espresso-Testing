package com.sqisland.android.espresso.hermetic

import org.joda.time.DateTime

open class Clock {
  open fun getNow() = DateTime()
}