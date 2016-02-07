package autoclicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Typer {

	static int keyreleasedelay = 10;

	public static void main(String[] args) throws AWTException,
			InterruptedException, IOException {
		Robot r;
		r = new Robot();
		r.delay(5000);
		// r.wait(1000)
		// System.out.println(KeyEvent);
		System.out.println(KeyEvent.VK_LEFT_PARENTHESIS);
		// System.out.println(KeyEvent.VK_Z);
		// System.out.println("a");
		System.out.println("(");
		System.out.println('A' + 0);
		System.out.println('a' + 0);
		System.out.println('a' + 0);
		System.out.println(',' + 0);
		// r.keyPress(KeyEvent.VK_A);
		// r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		//

		// FileWriter fstream = new FileWriter("out.txt");
		// BufferedWriter out = new BufferedWriter(fstream);
		// out.write("Hello Java");
		// out.close();
		//
		//
		// TypeAll("hello");

		//ReadFile("reactor6redpower.txt", 1000, 100, KeyEvent.VK_ENTER);
		// ReadFile("swearomatic.txt",200,1,KeyEvent.VK_ENTER);
		// ReadFile("enderQ.txt");
		// ReadFile("1tree.txt");
		// ReadFile("2tree.txt");
		//r.mousePress(InputEvent.BUTTON3_MASK);
		r.mousePress(InputEvent.BUTTON3_MASK);
		//spamright(100);
	}

	public static void spamright(int in) throws AWTException
	{
		Robot r;
		r = new Robot();
		
		for(int x = 0; x < in*10; x++)
		{
			r.mousePress(InputEvent.BUTTON3_MASK);
			r.delay(50);
			r.mouseRelease(InputEvent.BUTTON3_MASK);
			r.delay(50);
		}
	}
	
	
	public static void shiftAdder(char c, Robot r, int chardelay) {
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
		r.delay(keyreleasedelay);
		r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.delay(chardelay);
	}

	public static void TypeAll(String in, int chardelay) throws AWTException {
		Robot r;
		r = new Robot();
		// in = in.toLowerCase();

		for (int x = 0; x < in.length(); x++) {
			char tempc = in.charAt(x);
			switch (in.charAt(x)) {
			case '~':

				r.keyPress(KeyEvent.VK_BACK_SPACE);
				r.delay(keyreleasedelay);
				r.keyRelease(KeyEvent.VK_BACK_SPACE);
				r.delay(chardelay);

				break;
			case '(':
				tempc = '9';
				shiftAdder(tempc, r, chardelay);

				break;
			case '"':
				tempc = "'".charAt(0);
				shiftAdder(tempc, r, chardelay);
				break;
			case ')':
				tempc = '0';
				shiftAdder(tempc, r, chardelay);
				break;
			case '<':
				tempc = ',';
				shiftAdder(tempc, r, chardelay);
				break;
			case '>':
				tempc = '.';
				shiftAdder(tempc, r, chardelay);
				break;
			case '+':
				tempc = '=';
				shiftAdder(tempc, r, chardelay);
				break;
			case '*':
				tempc = '8';
				shiftAdder(tempc, r, chardelay);
				break;
			case '@':
				tempc = '2';
				shiftAdder(tempc, r, chardelay);
				break;
			case '!':
				tempc = '1';
				shiftAdder(tempc, r, chardelay);
				break;
			case ':':
				tempc = ';';
				shiftAdder(tempc, r, chardelay);
				break;
			case 'À':

				r.keyPress(KeyEvent.VK_ENTER);
				r.delay(keyreleasedelay);
				r.keyRelease(KeyEvent.VK_ENTER);
				r.delay(chardelay);
				break;

			default:
				if (in.toLowerCase().charAt(x) == in.charAt(x)) {
					r.keyPress(KeyEvent.getExtendedKeyCodeForChar(in.charAt(x)));
					r.delay(keyreleasedelay);
					r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(in
							.charAt(x)));
					r.delay(chardelay);
				} else {
					shiftAdder(tempc, r, chardelay);
				}
				break;
			}

			// r.keyPress(KeyEvent.getExtendedKeyCodeForChar(in.charAt(x)));
			// r.delay(keyreleasedelay);
			// r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(in.charAt(x)) );

		}
	}

	public static void ReadFile(String filename, int delayo, int chardelay,
			int linechar) throws IOException, AWTException,
			InterruptedException {
		BufferedReader in = new BufferedReader(new FileReader(filename));

		Robot r;
		r = new Robot();

		String oneline;

		while (in.ready()) {

			oneline = in.readLine();
			int spot = 0;
			char tempchar = ' ';
			if (oneline.length() > 0) {

				tempchar = oneline.charAt(0);
				spot = 0;
				while (tempchar == ' ' && spot != oneline.length()) {
					tempchar = oneline.charAt(spot);
					spot++;
				}
			}

			TypeAll(oneline, chardelay);

			r.keyPress(linechar);
			r.delay(keyreleasedelay);
			r.keyRelease(linechar);

			r.delay(delayo);
			if (delayo == 200) {
				r.keyPress(linechar);
				r.delay(keyreleasedelay);
				r.keyRelease(linechar);

			}

			r.delay(delayo);
			// for(int x = 0; x < spot; x++)
			// {
			// r.keyPress(KeyEvent.VK_BACK_SPACE);
			// r.delay(keyreleasedelay);
			// r.keyRelease(KeyEvent.VK_BACK_SPACE);
			//
			// }

		}

	}

}
