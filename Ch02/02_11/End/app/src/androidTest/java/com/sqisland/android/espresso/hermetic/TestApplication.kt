package com.sqisland.android.espresso.hermetic

import org.mockito.Mockito

class TestApplication: GreetingApplication() {
  private val clock: Clock by lazy {
    Mockito.mock(Clock::class.java)
  }

  override fun provideClock(): Clock = clock
}