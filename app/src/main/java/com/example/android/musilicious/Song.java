package com.example.android.musilicious;

import java.io.Serializable;

/**
 * Created by ankurg22 on 22/7/17.
 */

//Model class for Song info
public class Song implements Serializable {
    private int id;
    private String title;
    private String artist;
    private String album;
    private int imageId;

    public Song(int id, String title, String artist, String album, int imageId) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String mTitle) {
        this.title = mTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String mArtist) {
        this.artist = mArtist;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int mImageId) {
        this.imageId = mImageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int mId) {
        this.id = mId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String mAlbum) {
        this.album = mAlbum;
    }

}
