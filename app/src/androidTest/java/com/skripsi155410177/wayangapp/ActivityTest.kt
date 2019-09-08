package com.skripsi155410177.wayangapp


import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(SplashscreenActivity::class.java)

    @Test
    fun activityTest() {
        val cardView = onView(
            allOf(
                withId(R.id.btn1),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        cardView.perform(click())

        val recyclerView = onView(
            allOf(
                withId(R.id.rvWayang),
                childAtPosition(
                    withClassName(`is`("android.support.design.widget.CoordinatorLayout")),
                    1
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        val appCompatImageButton = onView(
            allOf(
                withContentDescription("Navigasi naik"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            allOf(withId(R.id.collapsing_toolbar), withContentDescription("Detail Tokoh Wayang")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val appCompatImageButton2 = onView(
            allOf(
                withContentDescription("Navigasi naik"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            withClassName(`is`("android.support.design.widget.AppBarLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton2.perform(click())

        val cardView2 = onView(
            allOf(
                withId(R.id.btn2),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        cardView2.perform(click())

        val cardView3 = onView(
            allOf(
                withId(R.id.brt1),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.support.design.widget.CoordinatorLayout")),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        cardView3.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(7000)

        pressBack()

        val appCompatButton = onView(
            allOf(
                withId(android.R.id.button1), withText("Ya"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.buttonPanel),
                        0
                    ),
                    3
                )
            )
        )
        appCompatButton.perform(scrollTo(), click())

        pressBack()

        val cardView4 = onView(
            allOf(
                withId(R.id.btn3),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        cardView4.perform(click())

        val appCompatTextView = onData(anything())
            .inAdapterView(
                allOf(
                    withId(R.id.list1),
                    childAtPosition(
                        withClassName(`is`("android.widget.RelativeLayout")),
                        0
                    )
                )
            )
            .atPosition(1)
        appCompatTextView.perform(click())

        val appCompatTextView2 = onData(anything())
            .inAdapterView(
                allOf(
                    withId(R.id.list1),
                    childAtPosition(
                        withClassName(`is`("android.widget.RelativeLayout")),
                        0
                    )
                )
            )
            .atPosition(12)
        appCompatTextView2.perform(click())

        pressBack()

        val cardView5 = onView(
            allOf(
                withId(R.id.btn4),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        cardView5.perform(click())

        val appCompatRadioButton = onView(
            allOf(
                withId(R.id.rb_choice1), withText("Premadi"),
                childAtPosition(
                    allOf(
                        withId(R.id.rg_choice),
                        childAtPosition(
                            withClassName(`is`("android.widget.RelativeLayout")),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatRadioButton.perform(click())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.btnNext), withText("next"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.RelativeLayout")),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val appCompatImageButton3 = onView(
            allOf(
                withContentDescription("Navigasi naik"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            withClassName(`is`("android.support.design.widget.AppBarLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton3.perform(click())

        val appCompatButton3 = onView(
            allOf(
                withId(android.R.id.button1), withText("Ya"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.buttonPanel),
                        0
                    ),
                    3
                )
            )
        )
        appCompatButton3.perform(scrollTo(), click())

        val appCompatImageButton4 = onView(
            allOf(
                withContentDescription("Open"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            withClassName(`is`("android.support.design.widget.AppBarLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton4.perform(click())

        val navigationMenuItemView = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.design_navigation_view),
                        childAtPosition(
                            withId(R.id.nav_view),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        navigationMenuItemView.perform(click())

        val appCompatImageButton5 = onView(
            allOf(
                withContentDescription("Navigasi naik"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            allOf(withId(R.id.collapsing_toolbar), withContentDescription("Profil Aplikasi")),
                            1
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton5.perform(click())

        val navigationMenuItemView2 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.design_navigation_view),
                        childAtPosition(
                            withId(R.id.nav_view),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        navigationMenuItemView2.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.subjek),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.support.v7.widget.CardView")),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(click())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.subjek),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.support.v7.widget.CardView")),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("Ini i subjek"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.pesan),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.support.v7.widget.CardView")),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("Konten"), closeSoftKeyboard())

        val appCompatButton4 = onView(
            allOf(
                withId(R.id.btnKirim), withText("Kirim"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.support.v7.widget.CardView")),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton4.perform(click())

        pressBack()

        pressBack()

        val navigationMenuItemView3 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.design_navigation_view),
                        childAtPosition(
                            withId(R.id.nav_view),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        navigationMenuItemView3.perform(click())

        val linearLayout = onData(anything())
            .inAdapterView(
                allOf(
                    withId(R.id.listView),
                    childAtPosition(
                        withClassName(`is`("android.support.design.widget.CoordinatorLayout")),
                        1
                    )
                )
            )
            .atPosition(0)
        linearLayout.perform(click())

        val linearLayout2 = onData(anything())
            .inAdapterView(
                allOf(
                    withId(R.id.listView),
                    childAtPosition(
                        withClassName(`is`("android.support.design.widget.CoordinatorLayout")),
                        1
                    )
                )
            )
            .atPosition(1)
        linearLayout2.perform(click())

        val appCompatImageButton6 = onView(
            allOf(
                withContentDescription("Navigasi naik"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            withClassName(`is`("android.support.design.widget.AppBarLayout")),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton6.perform(click())

        val navigationMenuItemView4 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.design_navigation_view),
                        childAtPosition(
                            withId(R.id.nav_view),
                            0
                        )
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        navigationMenuItemView4.perform(click())

        val navigationMenuItemView5 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.design_navigation_view),
                        childAtPosition(
                            withId(R.id.nav_view),
                            0
                        )
                    ),
                    7
                ),
                isDisplayed()
            )
        )
        navigationMenuItemView5.perform(click())

        val navigationMenuItemView6 = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.design_navigation_view),
                        childAtPosition(
                            withId(R.id.nav_view),
                            0
                        )
                    ),
                    10
                ),
                isDisplayed()
            )
        )
        navigationMenuItemView6.perform(click())

        val appCompatButton5 = onView(
            allOf(
                withId(android.R.id.button2), withText("Tidak"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.buttonPanel),
                        0
                    ),
                    2
                )
            )
        )
        appCompatButton5.perform(scrollTo(), click())

        pressBack()

        val appCompatButton6 = onView(
            allOf(
                withId(android.R.id.button1), withText("Ya"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.buttonPanel),
                        0
                    ),
                    3
                )
            )
        )
        appCompatButton6.perform(scrollTo(), click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
