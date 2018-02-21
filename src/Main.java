import com.thijsjuuhh.GM.window.GMButton;
import com.thijsjuuhh.GM.window.GMWindow;

public class Main {

	public static void main(String[] args) {
		GMButton button = new GMButton(50, 50, "begin!", GMButton.DEFAULT);
		button.replaceColors(0xff000000, 0x00009999).replaceColors(0xff000001, 0x00eeee).replaceColors(0xff000002,
				0xff00bbbb).scale(400, 300);
		GMWindow w = new GMWindow(800, 600, "Hey there", true);
		w.add(button);

	}

}
