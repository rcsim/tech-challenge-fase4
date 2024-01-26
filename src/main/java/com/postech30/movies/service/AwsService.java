package com.postech30.movies.service;

import java.io.IOException;

public interface AwsService {

    public void getVideoById(String id) throws IOException;
}
