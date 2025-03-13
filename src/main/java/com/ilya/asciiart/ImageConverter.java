package com.ilya.asciiart;

import java.awt.image.BufferedImage;

class ImageConverter {
    private ImageLoader loader;
    private String imgPath;
    public ImageConverter(String imgPath)
    {
        this.imgPath = imgPath;
        loader = new ImageLoader(imgPath);
    }
    public char[][] getAsciiArray()
    {
        int[][] pixelArray = convertToPixelsArray();
        char[][] asciiArray = new char[pixelArray.length][pixelArray[0].length];
        for (int i = 0; i < pixelArray.length; i++)
        {
            for (int j = 0; j < pixelArray[0].length; j++)
            {
                asciiArray[i][j] = convertPixelToChar(pixelArray[i][j]);
            }
        }
        return asciiArray;
    }
    private int[][] convertToPixelsArray()
    {
        BufferedImage image = loader.getImage();
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] pixelsArray = new int[height][width];
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                pixelsArray[y][x] = image.getRGB(x, y);
            }
        }
        return pixelsArray;
    }
    private char convertPixelToChar(int pixel)
    {
        int red   = (pixel >> 16) & 0xFF;
        int green = (pixel >> 8)  & 0xFF;
        int blue  = pixel & 0xFF;
        int overall = red + green + blue;
        if (overall < 100)
        {
            return '.';
        }
        else if (overall < 200)
        {
            return '*';
        }
        else if (overall < 300)
        {
            return '+';
        }
        else if (overall < 400)
        {
            return '|';
        }
        else if (overall < 500)
        {
            return '?';
        }
        else if (overall < 600)
        {
            return '(';
        }
        else if (overall < 700)
        {
            return 'x';
        }
        else
        {
            return 'U';
        }
    }
}
