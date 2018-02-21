package com.thijsjuuhh.GM.window;

import com.thijsjuuhh.GM.graphics.GMSprite;
import com.thijsjuuhh.GM.graphics.GMSpriteSheet;
import com.thijsjuuhh.GM.graphics.Render2D;
import com.thijsjuuhh.GM.handlers.GMButtonHandler;

public class GMButton extends GMComponent {

	private static final GMSpriteSheet DEF = new GMSpriteSheet("/com/thijsjuuhh/GM/defaultGraphics/button.png");
	public static final GMSprite[] DEFAULT = { new GMSprite(0, 0, 50, 50, DEF), new GMSprite(1, 0, 50, 50, DEF),
			new GMSprite(0, 0, 50, 50, DEF).flipHorizontal() };

	// private String text;
	private GMButtonHandler handler;
	private GMSprite[] s;

	private boolean pressed = false;

	private boolean buttonInside = false;

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
		if (mouse_handler != null) {
			if (isInside(mouse_handler.getMouseX(), mouse_handler.getMouseY())) {
				handler.buttonInside();

				if (!buttonInside) {
					buttonInside = true;
					handler.buttonEntered();
				}

				if (mouse_handler.leftMousePressed()) {
					if (!pressed) {
						pressed = true;
					}
					handler.buttonPressed();
				} else {
					if (pressed) {
						pressed = false;
						handler.buttonClicked();
					}
					handler.buttonReleased();
				}
			} else {
				if (buttonInside) {
					buttonInside = false;
					handler.buttonLeft();
				}
				pressed = false;
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
			s[i] = s[i].scale(nw / s.length, nh);
		width = nw;
		height = nh;

		return this;
	}

	public GMButton addButtonHandler(GMButtonHandler handler) {
		this.handler = handler;
		return this;
	}

}
