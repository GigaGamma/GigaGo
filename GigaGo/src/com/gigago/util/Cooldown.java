package com.gigago.util;

public class Cooldown {

	private boolean done;
	private long duration;
	private long ticked;
	
	public Cooldown(long duration) {
		setDone(false);
		setDuration(duration);
		setTicked(0);
	}
	
	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getTicked() {
		return ticked;
	}

	public void setTicked(long ticked) {
		this.ticked = ticked;
	}
	
	public void tick() {
		if (!done) {
			setTicked(getTicked() + 1);
		
			if (getTicked() == getDuration()) {
				setDone(true);
				setTicked(0);
			}
		}
	}
	
}
