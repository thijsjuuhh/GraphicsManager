package com.thijsjuuhh.GM.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GMSpriteSheet {

	private int width, height;
	public int[] pixels;

	private String path;

	public GMSpriteSheet(String path) {
		this.path = path;
		load();
	}

	private void load() {
		try {
			System.out.print("Trying to load " + path + " ");
			BufferedImage img = ImageIO.read(GMSpriteSheet.class.getResource(path));
			width = img.getWidth();
			height = img.getHeight();
			pixels = new int[width * height];
			img.getRGB(0, 0, width, height, pixels, 0, width);
			System.out.println("Succeeded!");
		} catch (IOException e) {
			System.err.println("FAILED!");
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
