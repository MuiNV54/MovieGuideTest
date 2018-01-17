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
package com.example.data.entity.mapper;

import com.example.data.VideoEntity;
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

    public Video transform(VideoEntity videoEntity) {
        if (videoEntity == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final Video video = new Video();
        video.setId(videoEntity.getId());
        video.setName(videoEntity.getName());
        video.setSite(videoEntity.getSite());
        video.setType(videoEntity.getType());
        video.setVideoId(videoEntity.getVideoId());
        video.setSize(videoEntity.getSize());

        return video;
    }

    public List<Video> transform(Collection<VideoEntity> videoEntityCollection) {
        List<Video> videoList;

        if (videoEntityCollection != null && !videoEntityCollection.isEmpty()) {
            videoList = new ArrayList<>();
            for (VideoEntity videoEntity : videoEntityCollection) {
                videoList.add(transform(videoEntity));
            }
        } else {
            videoList = Collections.emptyList();
        }

        return videoList;
    }
}
