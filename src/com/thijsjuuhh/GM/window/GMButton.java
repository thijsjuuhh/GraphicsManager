package com.thijsjuuhh.GM.window;

import com.thijsjuuhh.GM.graphics.GMSprite;
import com.thijsjuuhh.GM.graphics.GMSpriteSheet;
import com.thijsjuuhh.GM.graphics.Render2D;
import com.thijsjuuhh.GM.handlers.GMButtonHandler;
import com.thijsjuuhh.GM.handlers.GMMouseHandler;

public class GMButton extends GMComponent {

	private static final GMSpriteSheet DEF = new GMSpriteSheet("/com/thijsjuuhh/GM/defaultGraphics/button.png");
	public static final GMSprite[] DEFAULT = { new GMSprite(0, 0, 50, 50, DEF), new GMSprite(1, 0, 50, 50, DEF),
			new GMSprite(0, 0, 50, 50, DEF).flipHorizontal() };

	// private String text;
	private GMMouseHandler m;
	private GMButtonHandler handler;
	private GMSprite[] s;

	private boolean buttonInside = false;

	public GMButton(int x, int y, int width, int height, String name) {
		super(x, y, width, height, name);
	}

	public GMButton(int x, int y, String name, GMSprite... s) {
		super(x, y, s.length * s[0].getWidth(), s[0].getHeight(), name);
		this.s = s;
	}

	@Override
	public void render(Render2D render) {
		for (int i = 0; i < s.length; i++) {
			render.renderSprite(x + (i * s[i].getWidth()), y, s[i]);
		}
	}

	@Override
	public void update() {
		if (m != null) {
			if (isInside(m.getMouseX(), m.getMouseY())) {
				handler.buttonInside();

				if (!buttonInside) {
					buttonInside = true;
					handler.buttonEntered();
				}
				
				if(m.leftMousePressed())
					handler.buttonPressed();
			}
		}
	}

	public GMButton replaceColors(int colorToReplace, int colorToReplaceTo) {
		for (int i = 0; i < s.length; i++) {
			s[i] = s[i].replaceColor(colorToReplace, colorToReplaceTo);
		}
		return this;
	}

	public GMButton scale(int nw, int nh) {
		for (int i = 0; i < s.length; i++)
			s[i] = s[i].scale(nw / s.length, nh / s.length);
		width = nw / s.length;
		height = nh;

		return this;
	}

	public GMButton addMouseHandler(GMMouseHandler m) {
		this.m = m;
		return this;
	}

}
