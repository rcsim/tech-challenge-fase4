package com.postech30.movies.service.Impl;

import ch.qos.logback.core.Context;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.postech30.movies.service.AwsService;
import com.postech30.movies.util.PathUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class AwsServiceImpl implements AwsService {

    AmazonS3 amazonS3Client;

    @Autowired
    public AwsServiceImpl(AmazonS3 amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    private final String BUKET_NAME="video-techchallenge";


    @Override
    public void getVideoById(String id) throws IOException {
        S3Object s3object = amazonS3Client.getObject(BUKET_NAME, "video"+id+".mp4");
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        FileUtils.copyInputStreamToFile(inputStream, new File(PathUtil.getVideoPath()));
    }

}
