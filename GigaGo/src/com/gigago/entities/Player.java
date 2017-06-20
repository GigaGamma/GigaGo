package com.gigago.entities;

import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.gigago.GigaGo;
import com.gigago.util.Camera;
import com.gigago.util.ImageUtil;
import com.gigago.util.InputHandler;

public class Player extends Entity {
	
	public static final BufferedImage NORMAL = ImageUtil.getScaledImage(ImageUtil.loadImage(ClassLoader.getSystemResource("sprites/player/player.png")), 50, 70);
	public static final BufferedImage GUN = ImageUtil.getScaledImage(ImageUtil.loadImage(ClassLoader.getSystemResource("sprites/player/playerweapon.png")), 50, 70);
	
	public BufferedImage mode = NORMAL;
	
	public Player(int x, int y) {
		super("Player", x, y, 0);
	}
	
	public void draw() {
		if (isAlive()) {
			int speed = 3;
			
			if (GigaGo.getGigaGo().input.isKeyDown(KeyEvent.VK_G)) {
				mode = Player.GUN;
			}
			if (GigaGo.getGigaGo().input.isKeyDown(KeyEvent.VK_SHIFT)) {
				speed *= 2;
			}
		
			if (GigaGo.getGigaGo().input.isKeyDown(InputHandler.FORWARD)) {
				if (mode != Player.GUN) {
					//x += 1;
					int ym = new Random().nextInt(5) + speed;
					setY(getY() - ym);
					if (isFollowing()) {Camera.move(0, ym);};
				}
			} else if (GigaGo.getGigaGo().input.isKeyDown(InputHandler.BACK)) {
				if (mode != Player.GUN) {
					//x -= 1;
					int ym = new Random().nextInt(5) + speed;
					setY(getY() + ym);
					if (isFollowing()) {Camera.move(0, -ym);};
				}
			}
			if (GigaGo.getGigaGo().input.isKeyDown(InputHandler.LEFT)) {
				if (mode != Player.GUN) {
					int xm = new Random().nextInt(5) + speed;
					setX(getX() - xm);
					if (isFollowing()) {Camera.move(xm, 0);};
				}
				AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
				tx.translate(-mode.getWidth(null), 0);
				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
				mode = op.filter(mode, null);
			} else if (GigaGo.getGigaGo().input.isKeyDown(InputHandler.RIGHT)) {
				if (mode != Player.GUN) {
					int xm = new Random().nextInt(5) + speed;
					setX(getX() + xm);
					if (isFollowing()) {Camera.move(-xm, 0);}
				}
			}
			
			GigaGo.getGigaGo().getGraphics2d().drawImage(mode, getX() + Camera.xOffset, getY() + Camera.yOffset - 10, null);
			//GigaGo.getGigaGo().getGraphics2d().fillOval(getX() + Camera.xOffset, getY() + Camera.yOffset, 20, 20);
		}
	}
	
}
