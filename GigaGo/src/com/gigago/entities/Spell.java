package com.gigago.entities;

import java.awt.Color;

import com.gigago.GigaGo;
import com.gigago.util.Camera;

public class Spell extends TargetProjectile {

	public Spell(int x, int y, int h, int off, Entity target) {
		super("Magic Spell", x, y, h, off, target);
	}
	
	@Override
	public void draw() {
		//System.out.println(1 - (float) getKcool().getTicked() / getKcool().getDuration() / 2);
		GigaGo.getGigaGo().getGraphics2d().setColor(new Color(0, 0, 1, 1 - (float) getKcool().getTicked() / getKcool().getDuration() / 2));
		GigaGo.getGigaGo().getGraphics2d().fillOval(getX() + Camera.xOffset, getY() + Camera.yOffset, 20, 20);
	}
	
	@Override
	public void onEntityHit(Entity entity) {
		entity.kill();
	}

}
