import com.thijsjuuhh.GM.handlers.GMButtonHandler;
import com.thijsjuuhh.GM.window.GMButton;
import com.thijsjuuhh.GM.window.GMWindow;

public class Main {

	public static void main(String[] args) {
		GMButton button = new GMButton(50, 50, "begin!", GMButton.DEFAULT);
		button.replaceColors(0xff000000, 0x00009999).replaceColors(0xff000001, 0x00eeee).replaceColors(0xff000002,
				0xff00bbbb).scale(400, 0200).addButtonHandler(new GMButtonHandler() {
					
					@Override
					public void buttonReleased() {
					//	System.out.println("Released!");
					}
					
					@Override
					public void buttonPressed() {
					//	System.out.println("Pressed!");
					}
					
					@Override
					public void buttonLeft() {
						System.out.println("Out of area!");
					}
					
					@Override
					public void buttonInside() {
					//	System.out.println("Inside area!");
					}
					
					@Override
					public void buttonEntered() {
						System.out.println("Entered");
					}
					
					@Override
					public void buttonClicked() {
						System.out.println("Clicked!");
					}
				});
		GMWindow w = new GMWindow(800, 600, "Hey there", true);
		w.add(button);

	}

}
