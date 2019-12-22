package Engine;

import java.awt.Graphics2D;

public abstract class Component {
	
	public GameObject parent;
	public boolean active = true;
	public int Priority = 0 ;
	
	public Component(GameObject object){
		parent = object;
	}
	
	public void graphics(int i,Graphics2D G) {
	
	}
	public void logic(int i) {
		
	}
}
