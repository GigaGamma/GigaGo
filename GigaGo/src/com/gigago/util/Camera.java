package com.gigago.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Camera {
	
	public static int xOffset;
	public static int yOffset;
	
	/**
	 * Move the camera
	 * @param x - how much x movement
	 * @param y - how much y movement
	 */
	public static void move(int x, int y) {
		xOffset += x;
		yOffset += y;
	}
	
	/**
	 * Move the camera to a point
	 * @param x - how much x movement
	 * @param y - how much y movement
	 */
	public static void moveTo(int x, int y) {
		xOffset = x;
		yOffset = y;
	}
	
}
