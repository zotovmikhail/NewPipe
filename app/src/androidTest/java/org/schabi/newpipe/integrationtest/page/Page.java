package org.schabi.newpipe.integrationtest.page;

import android.view.KeyEvent;

import androidx.test.espresso.action.ViewActions;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

abstract class Page {
    void clickSearch() {
        onView(isRoot()).perform(pressKey(KeyEvent.KEYCODE_ENTER));
    }

    void clickBack() {
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void clickElementWithText(String text) {
        onView(withText(text)).perform(click());
    }
}
