package com.sqisland.android.espresso.hermetic

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner

class CustomTestRunner: AndroidJUnitRunner() {
  override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
    return super.newApplication(cl, "com.sqisland.android.espresso.hermetic.TestApplication", context)
  }
}