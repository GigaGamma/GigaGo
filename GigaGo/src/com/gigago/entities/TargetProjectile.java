package com.gigago.entities;

public class TargetProjectile extends Projectile {

	private Entity target;
	
	public TargetProjectile(String name, int x, int y, int h, int off, Entity target) {
		super(name, x, y, h, off);
		setTarget(target);
	}
	
	@Override
	public void update() {
		if (getX() > getTarget().getX()) {
			setX(getX() - 1 - getOff());
		} else {
			setX(getX() + 1 + getOff());
		}
		if (getY() > getTarget().getY()) {
			setY(getY() - 1 - getOff());
		} else {
			setY(getY() + 1 + getOff());
		}
		
		if (getTarget().getX() + 8 > getX() && getTarget().getX() < getX() + 20 - 8 && getTarget().getY() + 8 > getY() && getTarget().getY() < getY() + 20 - 8) {
			onTargetHit();
		}
		
		super.update();
	}

	public void onTargetHit() {
		
	}
	
	public Entity getTarget() {
		return target;
	}

	public void setTarget(Entity target) {
		this.target = target;
	}
	
}
