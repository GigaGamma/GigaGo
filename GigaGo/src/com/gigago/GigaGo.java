package com.gigago;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.swing.JFrame;

import com.gigago.entities.Player;
import com.gigago.entities.Projectile;
import com.gigago.util.Camera;
import com.gigago.util.InputHandler;
import com.gigago.util.RemoveOrder;
import com.gigago.util.RemoveOrderType;
import com.gigago.util.RemoveStack;
import com.gigago.world.SpawnTile;
import com.gigago.world.Tile;
import com.gigago.world.World;

public class GigaGo extends JFrame {

	/**
	 * @author Auguste Rame
	 * TODO Add level Port Horizon (w/ Port Horizon by Kevin MacLeod)
	 * TODO Add level Industria (w/ Industrial Cinematic by Kevin MacLeod)
	 * TODO Add level Dream Castle (w/ Dreamer by Kevin MacLeod)
	 * TODO Add boss level Castle 1 (w/ Killers by Kevin MacLeod)
	 * TODO Add level factory (w/ Crypto by Kevin MacLeod)
	 * TODO Add boss level Castle 2 (w/ Cyborg Ninja by Kevin MacLeod)
	 * TODO Add boss level Final Level (w/ Clash Defiant by Kevin MacLeod)
	 * TODO Win music is In Your Arms by Kevin MacLeod
	 */
	private static final long serialVersionUID = 7762187709028786063L;
	private static GigaGo instance;
	
	private boolean isRunning = false;
	private long time;
	private Graphics2D graphics2d;
	protected boolean devmode = true;
	
	public BufferedImage background;
	public Player player;
	public InputHandler input;
	public World world;
	
	public int width = 2000;
	public int height = 2000;
	
	public GigaGo() {
		SplashScreen splash = SplashScreen.getSplashScreen();
		/*Graphics2D g = splash.createGraphics();
		//g.setColor(Color.black);
		//g.fillRect(0, 0, (int) splash.getBounds().getWidth(), (int) splash.getBounds().getHeight());
		splash.update();*/
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setTitle("GigaGo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(2000, 2000));
		setVisible(true);
		
		this.isRunning = true;
		this.background = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		for (int h = 0; h < background.getHeight(); h++) {
			for (int w = 0; w < background.getWidth(); w++) {
				background.setRGB(w, h, 170);
			}
		}
		
		this.instance = this;
		this.input = new InputHandler(this);
		
		this.world = new World();
		int sx = 0;
		int sy = 0;
		for (Tile tile : world.tiles) {
			if (tile instanceof SpawnTile) {
				sx = tile.getX();
				sy = tile.getY();
			}
		}
		this.player = new Player(sx, sy);
		world.entities.add(player);
		Camera.moveTo(width / 2, height / 2);
		
		setExtendedState(MAXIMIZED_BOTH);
		
		while (isRunning) {
			time = System.currentTimeMillis();
			
			render();
			
			time = (1000 / 60) - (System.currentTimeMillis() - time);
			
			if (time > 0) {
				try {
					Thread.sleep(time); 
				}
				catch(Exception e){}
            }
		}
	}

	void render() {
		setGraphics2d((Graphics2D) background.getGraphics());
		getGraphics().drawImage(background, 0, 0, this);
		getGraphics2d().setColor(Color.WHITE);
		getGraphics2d().fillRect(0, 0, getWidth(), getHeight());
		
		player.mode = Player.NORMAL;
		
		AffineTransform trans = new AffineTransform();
		trans.scale((double) ((width + height) / 2) / 2000, (double) ((width + height) / 2) / 2000);
		
		getGraphics2d().transform(trans);
		
		if (input.isKeyDown(KeyEvent.VK_ESCAPE) && devmode) {
			System.exit(0);
		}
		
		world.draw();
		Iterator<Projectile> iter = Projectile.projectiles.iterator();

		while (iter.hasNext()) {
		    Projectile proj = iter.next();
			proj.update();
			
			for (RemoveOrder order : RemoveStack.orders) {
				if (order.getType() == RemoveOrderType.PROJECTILE && ((Projectile) order.getObject()) == proj) {
					iter.remove();
				}
			}
		}
		//player.update();
		
		//Camera.move(1, 0);
		player.follow();
		
		try {
			GigaGo.getGigaGo().getGraphics2d().transform(trans.createInverse());
		} catch (NoninvertibleTransformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Graphics2D getGraphics2d() {
		return graphics2d;
	}

	public void setGraphics2d(Graphics2D graphics2d) {
		this.graphics2d = graphics2d;
	}
	
	public static GigaGo getGigaGo() {
		return GigaGo.instance;
	}
	
}
