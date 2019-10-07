import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Model{
	int canvasWidth;
	int canvasHeight;
	int imageWidth;
	int imageHeight;
	int xloc=0;
	int yloc=0;
	double xIncr=8;
	double yIncr=2;	
	Direction direct=Direction.EAST;
	BassMode mode=BassMode.DEFAULT;
	
	public Model(int canvasWidth, int canvasHeight, int imageWidth, int imageHeight) {
		this.canvasWidth=canvasWidth;
		this.canvasHeight=canvasHeight;
		this.imageWidth=imageWidth;
		this.imageHeight=imageHeight;
	}
	
	public void updateModeAndDirection(Direction direction, BassMode bassMode) {
		direct=direction;
		mode=bassMode;
	}
	
	public void updateLocationandDirection() {
		if (mode==BassMode.DEFAULT) {
			xIncr=8;
			yIncr=2;
		}
		if (mode==BassMode.CONFUSE) {
			xIncr=4;
			yIncr=1;
		}
		if (mode==BassMode.ATTAC) {
			xIncr=16;
			yIncr=4;
		}
		if (direct==Direction.NORTH) {
			xIncr = 0;
			yIncr = -4;
		}
		if (direct==Direction.NORTHEAST) {
			yIncr =- yIncr;
		}
		if (direct==Direction.EAST) {
			yIncr = 0;
		}
		if (direct==Direction.SOUTH) {
			xIncr = 0;
			yIncr = 4;
		}
		if (direct==Direction.SOUTHWEST) {
			xIncr =- xIncr;
		}
		if (direct==Direction.WEST) {
			xIncr =- xIncr;
			yIncr = 0;
		}
		if (direct==Direction.NORTHWEST) {
			xIncr=-xIncr;
			yIncr=-yIncr;
		}
		xloc+=xIncr;
		yloc+=yIncr;
		getDirection();
	}
	

	public int getX() {
		return xloc;
	}
	
	public int getY() {
		return yloc;
	}
	
	public Direction getDirection() {
		return direct;
	}
}