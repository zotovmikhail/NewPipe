package org.schabi.newpipe.integrationtest.page;

public class PlaylistTabPage extends Page {

    public PlaylistDetailsPage selectPlaylist(String playlistName) {
        this.pause(1);
        this.clickElementWithText(playlistName);

        return new PlaylistDetailsPage();
    }
}
