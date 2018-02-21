import com.thijsjuuhh.GM.graphics.GMSprite;
import com.thijsjuuhh.GM.window.GMButton;
import com.thijsjuuhh.GM.window.GMWindow;

public class Main {

	private static final int[] toChange = { 0xff000000, 0xff000001, 0xff000002 };

	static GMSprite[] s0 = GMSprite.replaceColors(toChange, new int[] { 0xff000000, 0xff00ff00, 0xffcccccc },
			GMButton.DEFAULT);

	static GMSprite[] s1 = GMSprite.replaceColors(toChange, new int[] { 0xff220000, 0xff550000, 0xffcc0000 },
			GMButton.DEFAULT);

	public static void main(String[] args) {

		GMButton button = new GMButton(50, 50, "begin!", s0, s1,
				GMSprite.replaceColors(toChange, new int[] { 0xff002200, 0xff005500, 0xff00cc00 }, GMButton.DEFAULT))
						.scale(500, 500);
		GMWindow w = new GMWindow(800, 600, "Hey there", true);
		w.add(button);

	}

}
