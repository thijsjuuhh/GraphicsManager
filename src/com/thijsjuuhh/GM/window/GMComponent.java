package com.thijsjuuhh.GM.window;

import com.thijsjuuhh.GM.graphics.Render;
import com.thijsjuuhh.GM.handlers.GMMouseHandler;

public abstract class GMComponent implements Render, Update {

	protected int x, y, width, height;
	protected String name;
	protected GMMouseHandler mouse_handler;

	public GMComponent(int x, int y, int width, int height, String name) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public GMComponent(String name) {
		this(0, 0, 0, 0, name);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public boolean isInside(int x, int y) {
		return (x > this.x && x < this.x + width && y > this.y && y < this.y + height);
	}

	public void addMouseHandler(GMMouseHandler mouse_handler) {
		this.mouse_handler = mouse_handler;
	}

}
