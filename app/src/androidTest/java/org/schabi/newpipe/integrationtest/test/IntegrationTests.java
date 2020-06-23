package org.schabi.newpipe.integrationtest.test;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.schabi.newpipe.MainActivity;
import org.schabi.newpipe.integrationtest.data.Data;
import org.schabi.newpipe.integrationtest.page.TrendingPage;

@RunWith(AndroidJUnit4.class)
public class IntegrationTests {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testSearchVideo() {
        new TrendingPage()
                .searchVideo(Data.VIDEO_NAME)
                .selectFirstVideoInResults()
                .verifyVideoIsOpened(Data.VIDEO_NAME);
    }

    @Test
    public void testAddVideoToPlaylist() {
        new TrendingPage()
                .searchVideo(Data.VIDEO_NAME)
                .selectFirstVideoInResults()
                .addVideoToPlaylist(Data.PLAYLIST_NAME)
                .clickBackToTrendingPage()
                .clickBackToMenu()
                .clickOpenPlaylistTabButton()
                .selectPlaylist(Data.PLAYLIST_NAME)
                .selectFirstVideo()
                .verifyVideoIsOpened(Data.VIDEO_NAME);
    }

    @Test
    public void testSearchVideoNegative() {
        new TrendingPage()
                .searchVideo(Data.INVALID_VIDEO_NAME)
                .selectFirstVideoInResults()
                .verifyVideoNameNegative(Data.INVALID_VIDEO_NAME);

    }
}
