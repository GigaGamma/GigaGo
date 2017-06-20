package com.gigago.util;

import java.awt.Component;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import com.gigago.GigaGo;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener, ComponentListener {
	
	public static final int[] FORWARD = {KeyEvent.VK_UP, KeyEvent.VK_W};
	public static final int[] BACK = {KeyEvent.VK_DOWN, KeyEvent.VK_S};
	public static final int[] LEFT = {KeyEvent.VK_LEFT, KeyEvent.VK_A};
	public static final int[] RIGHT = {KeyEvent.VK_RIGHT, KeyEvent.VK_D};
	
	public boolean[] keys = new boolean[256];
	public MouseEvent mouseEvent;
	
	public int ox = 0;
	public int oy = 0;
	public int xdif = 0;
	public int ydif = 0;
	
	public InputHandler(Component c) {
		c.addKeyListener(this);
		c.addMouseListener(this);
		c.addMouseMotionListener(this);
		c.addComponentListener(this);
	}
	
	public boolean isKeyDown(int keyCode) {
		if (keyCode > 0 && keyCode < 256) {
			return keys[keyCode];
		}
		
		return false;
	}
	
	public boolean isKeyDown(int[] keyMatch) {
		for (int key : keyMatch) {
			if (key > 0 && key < 256) {
				if (keys[key] == true) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			keys[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) {
			keys[e.getKeyCode()] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseEvent = e;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		xdif = (e.getX() - (ox + 1));
		ydif = (e.getY() - (oy + 1));
		ox = mouseEvent.getX();
		oy = mouseEvent.getY();
		
		if (mouseEvent.getButton() == 2) { // Center
			
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		GigaGo.getGigaGo().background = new BufferedImage(GigaGo.getGigaGo().getWidth(), GigaGo.getGigaGo().getHeight(), BufferedImage.TYPE_INT_RGB);
		GigaGo.getGigaGo().width = (int) e.getComponent().getSize().getWidth();
		GigaGo.getGigaGo().height = (int) e.getComponent().getSize().getHeight();
		
		Camera.moveTo(GigaGo.getGigaGo().width / 3, GigaGo.getGigaGo().height / 3);
	}

	@Override
	public void componentShown(ComponentEvent e) {
		
	}

}
