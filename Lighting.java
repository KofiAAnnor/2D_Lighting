package Engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Lighting extends Component {
	boolean w = false;
	int color = 250;
	boolean up = false;

	public Lighting(GameObject object) {
		super(object);
	}

	public static Double computeIntersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		double denom = ((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4));
		double tNum = ((x1 - x3) * (y3 - y4)) - ((y1 - y3) * (x3 - x4));
		double uNum = -(((x1 - x2) * (y1 - y3)) - ((y1 - y2) * (x1 - x3)));
		double Px = 0;
		double Py = 0;
		if (denom == 0) {
			return null;
		}
		double t = tNum / denom;
		double u = uNum / denom;
		if (t > 0 && t < 1) {
			Px = (x1 + (t * (x2 - x1)));
			Py = (y1 + (t * (y2 - y1)));
		} else if (u > 0 && u < 1) {
			Px = (x3 + (u * (x4 - x3)));
			Py = (y3 + (u * (y4 - y3)));
		}
		if (Line2D.ptSegDist(x1, y1, x2, y2, Px, Py) + Line2D.ptSegDist(x3, y3, x4, y4, Px, Py) < 0.01) {
			return Point2D.distance((double) x3, (double) y3, Px, Py);
		} else {
			return null;
		}
	}

	public static Point2D.Double getIntersection(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		double denom = ((x1 - x2) * (y3 - y4)) - ((y1 - y2) * (x3 - x4));
		double tNum = ((x1 - x3) * (y3 - y4)) - ((y1 - y3) * (x3 - x4));
		double uNum = -(((x1 - x2) * (y1 - y3)) - ((y1 - y2) * (x1 - x3)));
		double Px = 0;
		double Py = 0;
		if (denom == 0) {
			return null;
		}
		double t = tNum / denom;
		double u = uNum / denom;
		if (t > 0 && t < 1) {
			Px = (x1 + (t * (x2 - x1)));
			Py = (y1 + (t * (y2 - y1)));
		} else if (u > 0 && u < 1) {
			Px = (x3 + (u * (x4 - x3)));
			Py = (y3 + (u * (y4 - y3)));
		}
		if (Line2D.ptSegDist(x1, y1, x2, y2, Px, Py) + Line2D.ptSegDist(x3, y3, x4, y4, Px, Py) < 0.01) {
			return new Point2D.Double(Px, Py);
		} else {
			return null;
		}
	}

	public void graphics(int a, Graphics2D G) {
		Driver.lines.clear();
		for (int i = 0; i < 360; i++) {
			int startX = (int) this.parent.pos.getTranslateX();
			int startY = (int) this.parent.pos.getTranslateY();
			int endX = (int) ((1000 * Math.cos(Math.toRadians(i))) + startX);
			int endY = (int) ((1000 * Math.sin(Math.toRadians(i))) + startY);
			MyLine x = new MyLine(startX, startY, endX, endY);
			ArrayList<Double> distances = new ArrayList<Double>();
			for (int index = 0; index < Driver.colliderLines.size(); index++) {
				MyLine l = Driver.colliderLines.get(index);
				Double d = computeIntersection(l.startX, l.startY, l.endX, l.endY, x.startX, x.startY, x.endX, x.endY);
				distances.add(d);
			}
			int ind = -1;
			for (int index = 0; index < distances.size(); index++) {
				if (distances.get(index) != null) {
					if (ind == -1 || distances.get(index) < distances.get(ind)) {
						ind = index;
					}
				}
			}
			if (ind == -1) {
			} else {
				MyLine theLine = new MyLine(Driver.colliderLines.get(ind).startX, Driver.colliderLines.get(ind).startY,
						Driver.colliderLines.get(ind).endX, Driver.colliderLines.get(ind).endY);
				Point2D.Double point = getIntersection(theLine.startX, theLine.startY, theLine.endX, theLine.endY,
						x.startX, x.startY, x.endX, x.endY);
				if (point != null) {
					x.endX = (int) point.x;
					x.endY = (int) point.y;
				}
			}
			Driver.lines.add(x);
		}

		for (MyLine l : Driver.lines) {
			G.setColor(Color.WHITE);
			G.drawLine(l.startX, l.startY, l.endX, l.endY);

		}
		for (MyLine l : Driver.colliderLines) {
			G.setColor(Color.BLACK);
			G.drawLine(l.startX, l.startY, l.endX, l.endY);
		}
	}

	public void logic(int i) {

		if (w) {
			if (InputHandler.pressedKeys.contains(KeyEvent.VK_W)) {
				this.parent.pos.translate(0, -4);
			} else if (InputHandler.pressedKeys.contains(KeyEvent.VK_S)) {
				this.parent.pos.translate(0, 4);
			} else if (InputHandler.pressedKeys.contains(KeyEvent.VK_A)) {
				this.parent.pos.translate(-4, 0);
			} else if (InputHandler.pressedKeys.contains(KeyEvent.VK_D)) {
				this.parent.pos.translate(4, 0);
			}
		} else {
			if (InputHandler.pressedKeys.contains(KeyEvent.VK_UP)) {
				this.parent.pos.translate(0, -4);
			} else if (InputHandler.pressedKeys.contains(KeyEvent.VK_DOWN)) {
				this.parent.pos.translate(0, 4);
			} else if (InputHandler.pressedKeys.contains(KeyEvent.VK_LEFT)) {
				this.parent.pos.translate(-4, 0);
			} else if (InputHandler.pressedKeys.contains(KeyEvent.VK_RIGHT)) {
				this.parent.pos.translate(4, 0);
			}
		}
	}
}
