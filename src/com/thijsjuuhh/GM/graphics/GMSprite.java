package com.thijsjuuhh.GM.graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class GMSprite {

	private int x, y, width, height;
	public int[] pixels;
	private GMSpriteSheet sheet;

	public GMSprite(int x, int y, int width, int height, GMSpriteSheet sheet) {
		this.x = x * width;
		this.y = y * height;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
		pixels = new int[width * height];

		load();
	}

	private GMSprite(int[] pixels) {
		this.pixels = new int[pixels.length];
		for (int i = 0; i < pixels.length; i++)
			this.pixels[i] = pixels[i];
	}

	public GMSprite(BufferedImage img) {
		width = img.getWidth();
		height = img.getHeight();
		pixels = new int[width * height];
		img.getRGB(0, 0, width, height, pixels, 0, width);
	}

	private void load() {
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.getWidth()];
	}

	public GMSprite scale(int nw, int nh) {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		img.setRGB(0, 0, width, height, pixels, 0, width);

		BufferedImage resized = new BufferedImage(nw, nh, BufferedImage.TYPE_INT_RGB);
		Graphics g = resized.getGraphics();
		g.drawImage(img.getScaledInstance(nh, nw, Image.SCALE_SMOOTH), 0, 0, nw, nh, null);
		g.dispose();

		return new GMSprite(resized);

	}

	public GMSprite(int width, int height, int pixels[]) {
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public GMSprite replaceColor(int colorToReplace, int color) {
		GMSprite result = new GMSprite(pixels);

		result.width = width;
		result.height = height;

		for (int pix = 0; pix < result.pixels.length; pix++)
			if (result.pixels[pix] == colorToReplace) {
				result.pixels[pix] = color;
			}

		return result;

	}

	public GMSprite flipHorizontal() {
		int[] tempPix = new int[pixels.length];
		for (int x = width - 1; x >= 0; x--)
			for (int y = 0; y < height; y++) {
				int x0 = (width - 1) - x;
				tempPix[x0 + y * width] = pixels[x + y * width];
			}
		pixels = tempPix;
		return this;

	}

	public GMSprite flipVertical() {
		int[] tempPix = new int[pixels.length];
		for (int y = height - 1; y >= 0; y--)
			for (int x = 0; x < width; x++) {
				int y0 = (height - 1) - y;
				tempPix[x + y0 * width] = pixels[x + y * width];
			}
		pixels = tempPix;
		return this;

	}

	public static GMSprite[] replaceColors(int colorToReplace, int colorToReplaceTo, GMSprite... s) {
		GMSprite[] res = new GMSprite[s.length];
		for (int sprite = 0; sprite < res.length; sprite++)
			res[sprite] = s[sprite].replaceColor(colorToReplace, colorToReplaceTo);
		return res;
	}

	public static GMSprite[] replaceColors(int[] colorToReplace, int[] colorToReplaceTo, GMSprite... s) {
		int length = colorToReplace.length;

		GMSprite[] result = s;

		if (colorToReplace.length < colorToReplaceTo.length)
			length = colorToReplace.length;

		for (int sprite = 0; sprite < length; sprite++)
			result = replaceColors(colorToReplace[sprite], colorToReplaceTo[sprite], result);

		return result;
	}
}
