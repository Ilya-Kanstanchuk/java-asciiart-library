package com.ilya.asciiart;

public class ASCIIArt {
    public static char[][] convert(String filePath)
    {
        ImageConverter imageConverter = new ImageConverter(filePath);
        return imageConverter.getAsciiArray();
    }
}
