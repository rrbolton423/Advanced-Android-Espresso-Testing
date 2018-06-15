package com.sqisland.android.espresso.cat_names

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.ComponentNameMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
  @Rule @JvmField
  var activityRule = IntentsTestRule(MainActivity::class.java)

  @Test
  fun punnyLaunchActivity() {
    onView(withId(R.id.button_punny))
        .perform(click())
    onView(withId(R.id.theme))
        .check(matches(withText(R.string.theme_punny)))
  }

  @Test
  fun punnyIntended() {
    onView(withId(R.id.button_punny))
        .perform(click())

    val context = InstrumentationRegistry.getTargetContext()
    val theme = context.getString(R.string.theme_punny)
    Intents.intended(hasExtra(IdeasActivity.KEY_THEME, theme))
    Intents.intended(IntentMatchers.hasComponent(
        ComponentNameMatchers.hasClassName("com.sqisland.android.espresso.cat_names.IdeasActivity")))
  }
}