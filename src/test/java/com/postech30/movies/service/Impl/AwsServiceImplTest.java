package com.postech30.movies.service.Impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.postech30.movies.service.AwsService;
import com.postech30.movies.service.Impl.AwsServiceImpl;
import com.postech30.movies.util.PathUtil;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@MockitoSettings(strictness = Strictness.LENIENT) // Adjust for strict or lenient stubbing
@ExtendWith(MockitoExtension.class)
class AwsServiceImplTest {

    @Mock
    private AmazonS3 amazonS3Client;
    @Mock
    private PathUtil pathUtil;

    private AwsService awsService;



    @Test
    void getVideoById_SuccessfullyDownloadsVideo() throws IOException {
        String id = "1";
        String bucketName = "video-techchallenge";
        String videoFileName = "video1.mp4";
        String videoContent = "Test video content";

        S3Object s3Object = mock(S3Object.class);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(videoContent.getBytes());
        S3ObjectInputStream inputStream = new S3ObjectInputStream(byteArrayInputStream, null);
        when(amazonS3Client.getObject(bucketName, videoFileName)).thenReturn(s3Object);
        when(s3Object.getObjectContent()).thenReturn(inputStream);

        this.awsService = new AwsServiceImpl(amazonS3Client);

        awsService.getVideoById("1");

        verify(amazonS3Client).getObject(bucketName, videoFileName);

        }
    }


