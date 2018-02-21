package com.thijsjuuhh.GM.graphics;

public class Render2D {

	private final int WIDTH, HEIGHT;
	private int[] pixels;

	public Render2D(int width, int height, int[] pixels) {
		WIDTH = width;
		HEIGHT = height;
		this.pixels = pixels;
	}

	public void renderRectangle(int x, int y, int width, int height, int col) {
		for (int y0 = 0; y0 < height; y0++) {
			int yPix = y + y0;
			for (int x0 = 0; x0 < width; x0++) {
				int xPix = x + x0;
				pixels[xPix + yPix * WIDTH] = col;
			}
		}
	}

	public void renderSprite(int x, int y, GMSprite sprite) {
		for (int y0 = 0; y0 < sprite.getHeight(); y0++) {
			int yPix = y0 + y;
			for (int x0 = 0; x0 < sprite.getWidth(); x0++) {
				int xPix = x0 + x;
				pixels[xPix + yPix * WIDTH] = sprite.pixels[x0 + y0 * sprite.getWidth()];
			}
		}
	}

	public void fillWindow(int col) {
		for (int pix = 0; pix < WIDTH * HEIGHT; pix++)
			pixels[pix] = col;
	}

	// TODO: render stuff
}
