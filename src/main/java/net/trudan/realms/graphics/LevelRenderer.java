package net.trudan.realms.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import net.trudan.realms.Realms;
import net.trudan.realms.level.Level;

public class LevelRenderer extends Renderer {
	
	private Level level;

	public LevelRenderer(Realms realms, Screen screen, Level level) {
		super(realms, screen);
		this.level = level;
	}

	public void render(BufferStrategy bs) {
		super.render(bs);
		
		renderLevel();
		
		getPlayer().render(screen);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, screen.getWidth()*3, screen.getHeight()*3, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 10));
		g.drawString("TL Tile X: " + (getRenderX() >> 4) + ", Y:" + (getRenderY() >> 4), 5, 10);
		g.drawString("Player  X: " + (getPlayer().x >> 4) + ", Y:" + (getPlayer().y >> 4) + ", D: " + getPlayer().direction, 5, 20);

		g.drawString("TPS: " + realms.getTPS() + ", FPS:" + realms.getFPS(), 5, 30);

		g.dispose();
	}
	
	private void renderLevel() {
		screen.setOffset(getRenderX(), getRenderY());
		int x0 = getRenderX() >> 4;
		int x1 = (getRenderX() + screen.getWidth() + 16) >> 4;
		int y0 = getRenderY() >> 4;
		int y1 = (getRenderY() + screen.getHeight() + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				screen.renderTile(x << 4, y << 4, level.getTile(x, y));
			}
		}
	}

}
