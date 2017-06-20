package com.gigago.entities;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.gigago.GigaGo;
import com.gigago.util.Camera;
import com.gigago.util.Cooldown;
import com.gigago.util.ImageUtil;

public class Mage extends Entity {
	
	public static final BufferedImage NORMAL = ImageUtil.getScaledImage(ImageUtil.loadImage(ClassLoader.getSystemResource("sprites/entities/mage.png")), 50, 70);
	
	public BufferedImage mode = NORMAL;
	private Cooldown scool = new Cooldown(120);
	
	public Mage(int x, int y, int h) {
		super("Mage", x, y, h);
	}
	
	public void draw() {
		//GigaGo.getGigaGo().getGraphics2d().setColor(Color.RED);
		//GigaGo.getGigaGo().getGraphics2d().drawOval(getX() + Camera.xOffset, getY() + Camera.yOffset, 20, 20);
		if (isAlive()) {
			GigaGo.getGigaGo().getGraphics2d().drawImage(mode, getX() + Camera.xOffset, getY() + Camera.yOffset - 10, null);
			if (scool.isDone()) {
				//shoot(new Spell(getX(), getY(), 0, GigaGo.getGigaGo().player, 10));
				if (isShootable(this, GigaGo.getGigaGo().player)) {
					new Spell(getX(), getY(), 0, new Random().nextInt(3), GigaGo.getGigaGo().player);
				}
				scool.setDone(false);
			}
			scool.tick();
		}
	}

}
