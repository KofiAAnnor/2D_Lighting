package Engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class InputHandler implements KeyListener {

	static ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	
	public InputHandler() {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!pressedKeys.contains(new Integer(e.getKeyCode()))) {
			pressedKeys.add(new Integer(e.getKeyCode()));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(pressedKeys.contains(new Integer(e.getKeyCode()))) {
			pressedKeys.remove(new Integer(e.getKeyCode()));
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}

//