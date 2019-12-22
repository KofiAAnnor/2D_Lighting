package Engine;


import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class GameObject {

	static int Min, Max;
	AffineTransform pos;
	ArrayList<Component> compList = new ArrayList<Component>();
	
	public GameObject() {
		EngineCore.AddObject(this);
		pos = new AffineTransform();
		pos.setToIdentity();
	}
	
	public void graphic(int i, Graphics2D G) {
		for (Component comp : compList) {
			comp.graphics(i,G);
		}
	}
	
	public void logic(int i) {
		for (Component comp : compList) {
			comp.logic(i);
		}
	}
	
	public boolean addComponent(Component a) {
		if (!compList.contains(a)) {
			compList.add(a);
			return true;
		}
		return false;
	}
	
	public boolean removeCompeonent(Class a) {
		for (Component comp : compList) {
			if (comp.getClass() == a) {
				compList.remove(comp);
				return true;
			}
		}
		return false;
	}
	
	public Component getComponent(Class a) {
		for (Component comp : compList) {
			if (comp.getClass() == a) {
				return comp;
			}
		}
		return null;
	}
}
