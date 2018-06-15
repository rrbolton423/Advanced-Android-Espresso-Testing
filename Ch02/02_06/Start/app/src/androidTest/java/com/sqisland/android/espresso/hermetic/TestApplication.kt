package com.sqisland.android.espresso.hermetic

class TestApplication: GreetingApplication() {
  private lateinit var clock: Clock

  fun setClock(clock: Clock) {
    this.clock = clock
  }

  override fun provideClock(): Clock = clock
}