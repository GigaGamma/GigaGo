package com.gigago.world;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.gigago.GigaGo;
import com.gigago.util.Camera;
import com.gigago.util.ImageUtil;

public class StairTile extends Tile {
	
	public static final BufferedImage TEXTURE = ImageUtil.getScaledImage(ImageUtil.loadImage(ClassLoader.getSystemResource("textures/stairs.png")), 80, 80);
	
	public StairTile(int x, int y, int z) {
		super(x, y, z, Color.GRAY);
	}
	
	public void draw() {
		GigaGo.getGigaGo().getGraphics2d().drawImage(TEXTURE, getX() - getZ() + Camera.xOffset, getY() + Camera.yOffset, null);
	}
	
	@Override
	public void onPlayerTouch() {
		
		
		super.onPlayerTouch();
	}
	
}
