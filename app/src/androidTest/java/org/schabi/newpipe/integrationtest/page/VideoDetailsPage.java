package org.schabi.newpipe.integrationtest.page;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.schabi.newpipe.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

public class VideoDetailsPage extends Page {
    private final static ViewInteraction VIDEO_TITLE = onView(ViewMatchers.withId(R.id.detail_video_title_view));
    private final static ViewInteraction ADD_TO_PLAYLIST_BUTTON = onView(ViewMatchers.withId(R.id.detail_controls_playlist_append));
    private final static ViewInteraction SELECT_PLAYLIST = onView(ViewMatchers.withId(R.id.itemStreamCountView));

    public VideoDetailsPage verifyVideoIsOpened(String videoName) {
        VIDEO_TITLE
                .check(matches(withText(videoName)));

        return this;
    }

    public VideoDetailsPage verifyVideoNameNegative(String videoName) {
        VIDEO_TITLE
                .check(matches(not(withText(videoName))));

        return this;
    }

    public VideoDetailsPage addVideoToPlaylist(String playlistName) {
        ADD_TO_PLAYLIST_BUTTON
                .perform(click());

        onView(ViewMatchers.withText(playlistName))
                .perform(click());

        return this;
    }

    public TrendingPage clickBackToTrendingPage() {
        this.clickBack();

        return new TrendingPage();
    }
}
