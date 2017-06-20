package com.gigago.entities;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.gigago.GigaGo;
import com.gigago.util.Camera;

public class Entity {
	
	private String name;
	private boolean following;
	private int x;
	private int y;
	
	private boolean alive;
	
	public Entity(String name, int x, int y, int h) {
		setName(name);
		setX(x);
		setY(y);
		setAlive(true);
	}
	
	public void update() {
		draw();
	}
	
	public void draw() {
		
	}
	
	/**
	 * Kills the entity.
	 * @return - void.
	 */
	public void kill() {
		setAlive(false);
	}
	
	/**
	 * Loads an image from the specified URL.
	 * @param source - The {@link Entity} that is shooting
	 * @param target - The {@link Entity} that is being shot at
	 * @return - a {@link boolean} stating if the shoot was executed.
	 */
	public boolean isShootable(Entity source, Entity target) {		
		return target.isAlive() && source.isAlive();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void follow() {
		following = true;
	}
	
	public void unfollow() {
		following = false;
	}
	
	public boolean isFollowing() {
		return following;
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

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
}
