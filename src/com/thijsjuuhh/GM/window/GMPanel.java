package com.thijsjuuhh.GM.window;

import java.util.LinkedList;

import com.thijsjuuhh.GM.graphics.Render2D;
import com.thijsjuuhh.GM.handlers.GMMouseHandler;

public class GMPanel {

	private LinkedList<GMComponent> components = new LinkedList<GMComponent>();

	protected GMMouseHandler mouse_handler;

	public void render(Render2D render) {
		for (GMComponent com : components)
			com.render(render);
	}

	public void update() {
		for (GMComponent com : components)
			com.update();
	}

	public void addComponent(GMComponent component) {
		components.add(component);
		component.addMouseHandler(mouse_handler);
	}

	public void addMouseHandler(GMMouseHandler mouse_handler) {
		this.mouse_handler = mouse_handler;
	}
}
