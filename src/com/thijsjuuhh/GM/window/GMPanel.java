package com.thijsjuuhh.GM.window;

import java.util.LinkedList;

import com.thijsjuuhh.GM.graphics.Render2D;

public class GMPanel {

	private LinkedList<GMComponent> components = new LinkedList<GMComponent>();

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
	}

}
