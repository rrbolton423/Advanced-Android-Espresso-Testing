package com.sqisland.android.espresso.cat_names

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IdeasActivityTest {
  @Rule @JvmField
  var activityRule = ActivityTestRule(IdeasActivity::class.java)

  @Test
  fun noTheme() {
    onView(withId(R.id.theme))
        .check(matches(withText(R.string.missing_theme)))
  }
}