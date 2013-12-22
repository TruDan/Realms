package net.trudan.realms.graphics;

import static org.lwjgl.opengl.GL11.*;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.FileInputStream;

import net.trudan.engine.Engine;
import net.trudan.realms.entity.Player;
import net.trudan.realms.graphics.gui.GUI;
import net.trudan.realms.level.tile.Terrain;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Renderer {

	protected Screen screen;
	protected Engine realms;
	protected int renderX, renderY;

	protected BufferedImage image;
	protected int[] pixels;
	protected GUI[] guis = new GUI[64];
	protected int guiCount = 0;

	public Renderer(Engine realms, Screen screen) {
		this.realms = realms;
		this.screen = screen;

		image = new BufferedImage(screen.getWidth(), screen.getHeight(), BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	}

	protected Player getPlayer() {
		return realms.getPlayer();
	}

	public void render(BufferStrategy bs) {

	}

	protected final int getRenderX() {
		return renderX;
	}

	protected final int getRenderY() {
		return renderY;
	}

	public void setRenderX(int x) {
		this.renderX = x;
	}

	public void setRenderY(int y) {
		this.renderY = y;
	}

	public void addGUI(GUI gui) {
		guis[guiCount] = gui;
		guiCount++;
	}

}
