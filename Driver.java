package Engine;

import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.Line;

public class Driver {
	public static ArrayList<MyLine> lines = new ArrayList<MyLine>();
	public static ArrayList<MyLine> colliderLines = new ArrayList<MyLine>();
	
	public static void main(String[] args) {

		EngineCore engnCore = new EngineCore(608, 1, 3,"Binding of Isaac", "Assets//");
		GameObject ballOfLight = new GameObject();
		Lighting lightingComponent = new Lighting(ballOfLight);
		ballOfLight.compList.add(lightingComponent);
		lightingComponent.w=true;

//	    GameObject ballOfLight2 = new GameObject();
//		Lighting lightingComponent2 = new Lighting(ballOfLight2);
//		ballOfLight2.pos.translate(500, 500);
//		ballOfLight2.compList.add(lightingComponent2);
		
		
		
		MyLine obstacleLine1 = new MyLine(100, 100, 100, 600);
		MyLine obstacleLine2 = new MyLine(100, 100, 200, 100);
		MyLine obstacleLine3 = new MyLine(200, 100, 200, 600);
		MyLine obstacleLine4 = new MyLine(100, 600, 200, 600);

	
		MyLine obstacleLine5 = new MyLine(300, 100, 300, 400);
		MyLine obstacleLine6 = new MyLine(600, 100, 600, 400);
		MyLine obstacleLine7 = new MyLine(300, 100, 600, 100);
		MyLine obstacleLine8 = new MyLine(600, 400, 300, 400);

		MyLine obstacleLine9 = new MyLine(360, 160, 360, 340);
		MyLine obstacleLine10 = new MyLine(360, 160, 540, 160);
		MyLine obstacleLine11 = new MyLine(540, 160, 540, 360);
		MyLine obstacleLine12 = new MyLine(540, 360, 360, 340);
		
		
		MyLine obstacleLine13 = new MyLine(600, 600, 900, 50);
		
		colliderLines.add(obstacleLine1);
		colliderLines.add(obstacleLine2);
		colliderLines.add(obstacleLine3);
		colliderLines.add(obstacleLine4);
		colliderLines.add(obstacleLine5);
		colliderLines.add(obstacleLine6);
		colliderLines.add(obstacleLine7);
		colliderLines.add(obstacleLine8);
		colliderLines.add(obstacleLine9);
		colliderLines.add(obstacleLine10);
		colliderLines.add(obstacleLine11);
		colliderLines.add(obstacleLine12);
		colliderLines.add(obstacleLine13);
		engnCore.start();		
	}
}