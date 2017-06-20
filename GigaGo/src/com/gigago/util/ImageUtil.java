package com.gigago.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageUtil {
	
	/**
	 * Loads an image from the specified URL.
	 * @param url - the url
	 * @return - a {@link BufferedImage}.
	 */
	public static BufferedImage loadImage(URL url) {
		try {
			return ImageIO.read(url);
		} catch (IOException e) {e.printStackTrace();}
		
		return null;
	}
	
	/**
	 * Resizes an image using a {@link Graphics2D} object backed by a {@link BufferedImage}.
	 * @param srcImg - source {@link BufferedImage} to scale
	 * @param w - desired width
	 * @param h - desired height
	 * @return - the new resized {@link BufferedImage}
	 */
	public static BufferedImage getScaledImage(BufferedImage srcImg, int w, int h){
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();
		return resizedImg;
	}
	
}
