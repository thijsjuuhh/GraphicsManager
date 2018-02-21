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
	private GMButtonHandler handler = new GMButtonHandler() {

		@Override
		public void buttonReleased() {
		}

		@Override
		public void buttonPressed() {
		}

		@Override
		public void buttonLeft() {
		}

		@Override
		public void buttonInside() {
		}

		@Override
		public void buttonEntered() {
		}

		@Override
		public void buttonClicked() {
		}
	};
	private GMSprite[][] s;

	private int active = 0;

	private boolean pressed = false;

	private boolean buttonInside = false;
	private int prevActive;

	public GMButton(int x, int y, String name, GMSprite[]... s) {
		super(x, y, s[0].length * s[0][0].getWidth(), s[0][0].getHeight(), name);
		this.s = s;
	}

	@Override
	public void render(Render2D render) {
		for (int i = 0; i < s.length; i++) {
			render.renderSprite(x + (i * s[active][i].getWidth()), y, s[active][i]);
		}
	}

	@Override
	public void update() {
		if (mouse_handler != null) {
			if (isInside(mouse_handler.getMouseX(), mouse_handler.getMouseY())) {

				handler.buttonInside();

				if (active != prevActive) {
					prevActive = active;
				}

				if (s.length > 1)
					active = 1;

				if (!buttonInside) {
					buttonInside = true;
					handler.buttonEntered();
				}

				if (pressed && s.length > 2)
					active = 2;

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
				active = 0;
			}
		}
	}

	public GMButton scale(int nw, int nh) {
		for (int active = 0; active < s.length; active++)
			for (int i = 0; i < s.length; i++)
				s[active][i] = s[active][i].scale(nw / s.length, nh);
		width = nw;
		height = nh;

		return this;
	}

	public GMButton addButtonHandler(GMButtonHandler handler) {
		this.handler = handler;
		return this;
	}

}
