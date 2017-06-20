package com.gigago.world;

import java.util.ArrayList;
import java.util.Random;

import com.gigago.entities.Entity;
import com.gigago.entities.Mage;

public class World {
	
	public ArrayList<Tile> tiles = new ArrayList<Tile>();
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public World() {
		for (int y = -20; y < 20; y++) {
			for (int x = -20; x < 20; x++) {
				if (x == 0 && y == 5) {
					tiles.add(new SpawnTile(x * 80, y * 80, x * y));
				}
				else if (new Random().nextInt(50) > 0) {
					tiles.add(new IronTile(x * 80, y * 80, x * y));
					if (new Random().nextInt(50) == new Random().nextInt(50)) {
						entities.add(new Mage(x * 80, y * 80, 0));
					}
				}
				else {
					tiles.add(new LavaTile(x * 80, y * 80, x * y));
				}
				//tiles.add(new Tile(160, 160, 5));
			}
		}
	}
	
	public void draw() {
		for (Tile tile : tiles) {
			tile.update();
		}
		for (Entity ent : entities) {
			ent.update();
		}
	}
	
}
