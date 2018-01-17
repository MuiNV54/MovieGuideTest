/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.esoxjem.movieguide.mapper;

import com.esoxjem.movieguide.VideoModel;
import com.example.domain.Video;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class VideoModelDataMapper {

    @Inject
    public VideoModelDataMapper() {
    }

    public VideoModel transform(Video video) {
        if (video == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final VideoModel videoModel = new VideoModel();
        videoModel.setId(video.getId());
        videoModel.setName(video.getName());
        videoModel.setSite(video.getSite());
        videoModel.setType(video.getType());
        videoModel.setVideoId(video.getVideoId());
        videoModel.setSize(video.getSize());

        return videoModel;
    }

    public List<VideoModel> transform(Collection<Video> videoCollection) {
        List<VideoModel> videoModelList;

        if (videoCollection != null && !videoCollection.isEmpty()) {
            videoModelList = new ArrayList<>();
            for (Video video : videoCollection) {
                videoModelList.add(transform(video));
            }
        } else {
            videoModelList = Collections.emptyList();
        }

        return videoModelList;
    }
}
