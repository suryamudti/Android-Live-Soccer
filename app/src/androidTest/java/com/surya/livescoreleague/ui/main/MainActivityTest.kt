package com.surya.livescoreleague.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.surya.livescoreleague.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by suryamudti on 25/11/2019.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Test fun shouldOpenLigaInggrisMenu(){
        onView(withId(R.id.recycleLeague)).check(matches(isDisplayed()))
        onView(withId(R.id.recycleLeague)).perform(RecyclerViewActions.actionOnItemAtPosition<
                RecyclerView.ViewHolder>(0,click()))

    }


}