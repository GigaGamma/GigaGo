package com.gigago.entities;

import java.util.ArrayList;

import com.gigago.GigaGo;
import com.gigago.util.Cooldown;
import com.gigago.util.RemoveOrder;
import com.gigago.util.RemoveOrderType;
import com.gigago.util.RemoveStack;

public class Projectile extends Entity {
	
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	private int off;
	
	private Cooldown dcool = new Cooldown(20);
	private Cooldown kcool = new Cooldown(GigaGo.getGigaGo().world.tiles.size() / 7);
	
	public Projectile(String name, int x, int y, int h, int off) {
		super(name, x, y, h);
		setOff(off);
		
		projectiles.add(this);
	}
	
	@Override
	public void update() {
		if (dcool.isDone()) {
			for (Entity entity : GigaGo.getGigaGo().world.entities) {
				if (entity.getX() + 8 > getX() && entity.getX() < getX() + 20 - 8 && entity.getY() + 8 > getY() && entity.getY() < getY() + 20 - 8) {
					onEntityHit(entity);
				}
			}
		}
		if (kcool.isDone()) {
			kill();
		}
		
		dcool.tick();
		kcool.tick();
		
		super.update();
	}
	
	public void onEntityHit(Entity entity) {
		
	}

	@Override
	public void kill() {
		//projectiles.remove(this);
		RemoveStack.orders.add(new RemoveOrder(this, RemoveOrderType.PROJECTILE));
		
		super.kill();
	}

	public int getOff() {
		return off;
	}

	public void setOff(int off) {
		this.off = off;
	}

	public Cooldown getKcool() {
		return kcool;
	}

	public void setKcool(Cooldown kcool) {
		this.kcool = kcool;
	}

}
