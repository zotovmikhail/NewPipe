package org.schabi.newpipe.integrationtest.page;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import org.schabi.newpipe.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TrendingPage extends Page {
    private final static ViewInteraction SEARCH_BUTTON = onView(withId(R.id.action_search));
    private final static ViewInteraction SEARCH_TEXT_FIELD = onView(withId(R.id.toolbar_search_edit_text));
    private final static ViewInteraction DRAWER_LAYOUT = onView(withId(R.id.drawer_layout));
    private final static ViewInteraction SEARCH_RESULTS_LIST = onView(withId(R.id.items_list));

    private TrendingPage clickSearchButton() {
        SEARCH_BUTTON.perform(click());

        return this;
    }

    private TrendingPage enterTextForSearch(String text) {
        SEARCH_TEXT_FIELD.perform(typeText(text));

        return this;
    }

    public TrendingPage searchVideo(String text) {
        this
                .clickSearchButton()
                .enterTextForSearch(text)
                .clickSearch();

        this.pause(2);

        return this;
    }

    public VideoDetailsPage selectFirstVideoInResults() {
        SEARCH_RESULTS_LIST
                .perform(RecyclerViewActions.actionOnItemAtPosition(
                        0, click()));

        this.pause(5);
        return new VideoDetailsPage();
    }

    public PlaylistTabPage clickOpenPlaylistTabButton() {
        DRAWER_LAYOUT
                .perform(swipeLeft()).perform(swipeLeft());

        return new PlaylistTabPage();
    }

    public TrendingPage clickBackToMenu() {
        this.clickBack();

        return this;
    }

}
