package com.postech30.movies.service;

import com.amazonaws.services.s3.model.S3Object;

import java.io.IOException;

public interface AwsService {

    public void getVideoById(String id) throws IOException;
}
