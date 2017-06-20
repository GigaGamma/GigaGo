package com.gigago.world;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.gigago.GigaGo;
import com.gigago.util.Camera;
import com.gigago.util.ImageUtil;

public class LavaTile extends Tile {
	
	public static final BufferedImage TEXTURE = ImageUtil.getScaledImage(ImageUtil.loadImage(ClassLoader.getSystemResource("textures/lava.jpg")), 80, 80);
	
	public LavaTile(int x, int y, int z) {
		super(x, y, z, Color.RED);
	}
	
	public void draw() {
		GigaGo.getGigaGo().getGraphics2d().drawImage(TEXTURE, getX() - getZ() + Camera.xOffset, getY() + Camera.yOffset, null);
	}
	
	@Override
	public void onPlayerTouch() {
		GigaGo.getGigaGo().player.kill();
		
		super.onPlayerTouch();
	}
	
}
