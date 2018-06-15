package com.sqisland.android.espresso.hermetic

import android.app.Application

class GreetingApplication: Application() {
  fun provideClock(): Clock = Clock()
}