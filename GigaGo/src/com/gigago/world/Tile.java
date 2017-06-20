package com.gigago.world;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;

import com.gigago.GigaGo;
import com.gigago.util.Camera;

public class Tile {
	
	private int x;
	private int y;
	private int z;
	private Color color;
	
	public Tile(int x, int y, int z, Color color) {
		setX(x);
		setY(y);
		//setZ(z);
	
		setColor(color);
	}
	
	public void update() {
		if (getX() - getZ() + Camera.xOffset > -80 && getY() + Camera.yOffset > -80 && getX() - getZ() + Camera.xOffset < GigaGo.getGigaGo().width && getY() + Camera.yOffset < GigaGo.getGigaGo().height) {
			AffineTransform trans = new AffineTransform();
			//trans.shear(-0.5, -0.03);
			GigaGo.getGigaGo().getGraphics2d().transform(trans);
			draw();
			//GigaGo.getGigaGo().getGraphics2d().drawLine(x, y - z, x + 80, y - z);
			//GigaGo.getGigaGo().getGraphics2d().drawLine(x + 80, y - z, x + 80, y - z + 20);
			try {
				GigaGo.getGigaGo().getGraphics2d().transform(trans.createInverse());
			} catch (NoninvertibleTransformException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (GigaGo.getGigaGo().player.getX() + 8 > getX() && GigaGo.getGigaGo().player.getX() < getX() + 80 - 8 && GigaGo.getGigaGo().player.getY() + 8 > getY() && GigaGo.getGigaGo().player.getY() < getY() + 80 - 8) {
			onPlayerTouch();
		}
	}
	
	public void draw() {
		GigaGo.getGigaGo().getGraphics2d().setColor(getColor());
		GigaGo.getGigaGo().getGraphics2d().fill3DRect(getX() - getZ() + Camera.xOffset, getY() + Camera.yOffset, 80, 80, true);
	}
	
	public void onPlayerTouch() {
		
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
