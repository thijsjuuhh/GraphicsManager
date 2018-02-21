package com.thijsjuuhh.GM.handlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GMMouseHandler extends MouseAdapter {

	private int mouseX = 0;
	private int mouseY = 0;
	private boolean right_click = false;
	private boolean middle_click = false;
	private boolean left_click = false;
	private boolean inside = false;

	public GMMouseHandler() {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			left_click = true;

		if (e.getButton() == MouseEvent.BUTTON2)
			middle_click = true;

		if (e.getButton() == MouseEvent.BUTTON3)
			right_click = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			left_click = false;

		if (e.getButton() == MouseEvent.BUTTON2)
			middle_click = false;

		if (e.getButton() == MouseEvent.BUTTON3)
			right_click = false;

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		inside = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		inside = false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public boolean rightMousePressed() {
		return right_click;
	}

	public boolean middleMousePressed() {
		return middle_click;
	}

	public boolean leftMousePressed() {
		return left_click;
	}

	public boolean isInside() {
		return inside;
	}

}
