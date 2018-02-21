package com.thijsjuuhh.GM.window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.thijsjuuhh.GM.graphics.Render2D;

public class GMWindow implements Runnable {

	private int w, h;
	private String title;
	private Thread t;

	private Render2D render;

	private JFrame frame;

	private BufferedImage img;

	protected int[] pixels;

	private GMPanel panel = new GMPanel();
	private LinkedList<GMPanel> panels;
	private boolean running;

	public GMWindow(int width, int height, String title, boolean useGMLibrary) {
		w = width;
		h = height;

		this.title = title;

		frame = new JFrame();

		img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();

		render = new Render2D(width, height, pixels);
		render.fillWindow(0xffffff);

		frame.setSize(new Dimension(w, h));
		frame.setTitle(title);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		if (useGMLibrary)
			createThread(title);

		panels = new LinkedList<GMPanel>();
		panels.add(panel);

	}

	public Thread createThread(String threadName) {
		t = new Thread(this);
		running = true;
		t.start();
		return t;
	}

	public void stopThread() {
		try {
			if (t != null)
				t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getTitle() {
		return title;
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public GMWindow add(GMComponent component) {
		panel.addComponent(component);
		return this;
	}

	public GMWindow addPanel(GMPanel panel) {
		panels.add(panel);
		return this;
	}

	public void render() {
		BufferStrategy bs = frame.getBufferStrategy();
		if (bs == null) {
			frame.createBufferStrategy(3);
			return;
		}

		renderPanels();

		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();
		bs.show();
	}

	private void renderPanels() {
		for (GMPanel panel : panels)
			panel.render(render);
	}

	@Override
	public void run() {
		while (running) {
			render();
		}
	}

}
