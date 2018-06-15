package com.sqisland.android.espresso.hermetic

import android.app.Application

open class GreetingApplication: Application() {
  open fun provideClock(): Clock = Clock()
}