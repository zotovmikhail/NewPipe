package org.schabi.newpipe.integrationtest.page;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import org.schabi.newpipe.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class PlaylistDetailsPage extends Page {

    private final static ViewInteraction SEARCH_RESULTS_LIST = onView(withId(R.id.items_list));

    public VideoDetailsPage selectFirstVideo() {
        SEARCH_RESULTS_LIST
                .perform(RecyclerViewActions.actionOnItemAtPosition(
                        1, click()));

        return new VideoDetailsPage();
    }
}
