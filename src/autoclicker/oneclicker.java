package autoclicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class oneclicker {

	public static void main(String[] args) throws AWTException {
		Robot r;
		r = new Robot();

		r.delay(5000);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		//r.mousePress(InputEvent.BUTTON1_DOWN_MASK);

	}

}
