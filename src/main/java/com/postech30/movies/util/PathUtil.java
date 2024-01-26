package com.postech30.movies.util;

import java.io.File;

public class PathUtil {


    public static String getVideoPath(){
        File b = new File("");
        return  b.getAbsolutePath() + File.separator + "videos" + File.separator + "video.mp4";
    }
}
