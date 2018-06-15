package com.sqisland.android.espresso.hermetic

import org.mockito.Mockito

class TestApplication: GreetingApplication() {
  override lateinit var component: ApplicationComponent
}