package com.example.data.repository.entity.mapper;

import com.example.data.VideoEntity;
import com.example.data.entity.mapper.VideoModelDataMapper;
import com.example.domain.Movie;
import com.example.domain.Video;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by nguyen.van.mui on 19/01/2018.
 */

public class VideoEntityMapperTest {
    private static final String VIDEO_ID = "123";
    private static String VIDEO_NAME = "test name";

    private VideoModelDataMapper mEntityDataMapper;

    @Before
    public void setup() {
        mEntityDataMapper = new VideoModelDataMapper();
    }

    @Test
    public void testTransformVideoEntity() {
        VideoEntity videoEntity = createFakeVideo();
        Video video = mEntityDataMapper.transform(videoEntity);

        assertThat(video, is(instanceOf(Video.class)));
        assertThat(video.getId(), is(VIDEO_ID));
        assertThat(video.getName(), is(VIDEO_NAME));
    }

    @Test
    public void testTransformVideoEntityCollection() {
        VideoEntity entity1 = mock(VideoEntity.class);
        VideoEntity entity2 = mock(VideoEntity.class);

        List<VideoEntity> entityList = new ArrayList<>();
        entityList.add(entity1);
        entityList.add(entity2);

        List<Video> videoList = mEntityDataMapper.transform(entityList);

        assertThat(videoList.get(0), is(instanceOf(Video.class)));
        assertThat(videoList.get(1), is(instanceOf(Video.class)));
        assertThat(videoList.size(), is(2));
    }

    private VideoEntity createFakeVideo() {
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setId(VIDEO_ID);
        videoEntity.setName(VIDEO_NAME);

        return videoEntity;
    }
}
