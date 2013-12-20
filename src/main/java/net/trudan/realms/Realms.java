package net.trudan.realms;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import net.trudan.realms.entity.Player;
import net.trudan.realms.graphics.LevelRenderer;
import net.trudan.realms.graphics.Renderer;
import net.trudan.realms.graphics.Screen;
import net.trudan.realms.input.Keyboard;
import net.trudan.realms.level.Level;
import net.trudan.realms.level.RandomLevel;
import net.trudan.realms.sound.BGSound;

public class Realms extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private static Level level;
	private Player player;
	private boolean running = false;
	private Screen screen;
	private Renderer renderer;
	private BGSound bgSound;

	private int fps = 0;
	private int tps = 0;
	private static int ticks;
	
	int x = 0,y = 0;

	public Realms() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = new RandomLevel(64, 64);
		player = new Player(key);
		renderer = new LevelRenderer(this,screen,level);
		bgSound = new BGSound();

		addKeyListener(key);

	}
	
	public static Level getLevel() {
		return level;
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
		bgSound.play();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();

		final double ns = 16666666.67; // 1,000,000,000.0 / 60.0
		double delta = 0;

		int frames = 0;

		requestFocus();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer = System.currentTimeMillis();
				fps = frames;
				tps = ticks;
				frames = 0;
				ticks = 0;
			}
		}
		bgSound.stopAll();
		stop();
	}

	public void tick() {
		key.tick();
		player.tick();

		if (key.mup) y--;
		if (key.mdown) y++;
		if (key.mleft) x--;
		if (key.mright) x++;
		
		if(player.x-x < 40) {
			x--;
		}
		else if(player.x-x > 250) {
			x++;
		}
		
		if(player.y-y < 40) {
			y--;
		}
		else if(player.y-y > 110) {
			y++;
		}
		
		renderer.setRenderX(x);
		renderer.setRenderY(y);

	}
	
	public static int getTick() {
		return ticks;
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		renderer.render(bs);
		
		bs.show();
	}

	public static void main(String args[]) {
		Realms game = new Realms();
		game.frame.setResizable(false);
		game.frame.setTitle("Realms");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}

	public Player getPlayer() {
		return player;
	}
	
	public int getTPS() {
		return tps;
	}
	
	public int getFPS() {
		return fps;
	}
}
