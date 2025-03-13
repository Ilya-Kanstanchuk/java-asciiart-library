package com.ilya.asciiart;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

class ImageLoader {
    private String imgPath;
    public ImageLoader(String imgPath)
    {
        this.imgPath = imgPath;
    }
    public BufferedImage getImage()
    {
        try {
            checkImageFormat();
            BufferedImage image = ImageIO.read(new File(imgPath));
            return resizingImage(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void checkImageFormat() throws IOException
    {
        ImageInputStream iis = ImageIO.createImageInputStream(new File(imgPath));
        Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
        if (!iter.hasNext())
        {
            throw new RuntimeException("Wrong image type!");
        }
        ImageReader reader = iter.next();
        String imgFormat = reader.getFormatName();
        if (!(imgFormat.equalsIgnoreCase("PNG") || imgFormat.equalsIgnoreCase("GIF") || imgFormat.equalsIgnoreCase("JPG") || imgFormat.equalsIgnoreCase("JPEG")))
        {
            throw new RuntimeException("Wrong image type!");
        }
    }
    private BufferedImage resizingImage(BufferedImage image)
    {
        int newWidth = image.getWidth() / 3;
        int newHeight = image.getHeight() / 3;
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, image.getType());
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(image, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        return resizedImage;
    }
}
