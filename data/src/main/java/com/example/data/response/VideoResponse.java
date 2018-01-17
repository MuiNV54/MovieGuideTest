package com.example.data.response;

import com.example.data.VideoEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by ivan on 8/20/2017.
 */

public class VideoResponse {

    @SerializedName("results")
    private List<VideoEntity> videos;

    public List<VideoEntity> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoEntity> videos) {
        this.videos = videos;
    }
}
