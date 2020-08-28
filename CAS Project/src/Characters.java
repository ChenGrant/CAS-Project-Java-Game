import java.awt.*;
import javax.swing.*;

public class Characters {
	int minX;
	int minY;
	int maxX;
	int maxY;
	int midX;

	int x;
	int y;
	int dx = 3;
	int dy = 3;

	boolean show = true;

	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;

	int ID = 0;
	int maxID = 0;

	Image icon;
	int iconW = 40;
	int iconH = 40;

	Image healthBack = new ImageIcon("src\\Images\\Panel 3\\Characters\\healthBack.png").getImage();
	int healthBackW = 300;
	int healthBackH = 15;

	Image healthImg = new ImageIcon("src\\Images\\Panel 3\\Characters\\health.png").getImage();
	Image healthLine = new ImageIcon("src\\Images\\Panel 3\\Characters\\healthLine.png").getImage();

	Image cdImg = new ImageIcon("src\\Images\\Panel 3\\Characters\\cd.png").getImage();
	int cdW = 50;
	int cdH = 40;

	Image ready = new ImageIcon("src\\Images\\Panel 3\\Characters\\ready.png").getImage();
	int readyW = 150;
	int readyH = 50;

	double CD;
	boolean onCD = false;
	double startTime;
	double endTime;
	double elapsedTime;

	int health = 100;
	int playerNum = 0;

	Characters(int playerNum, int minX, int minY, int midX, int maxX, int maxY, int ID, int maxID) {
		this.playerNum = playerNum;
		this.minX = minX;
		this.minY = minY;
		this.midX = midX;
		this.maxX = maxX;
		this.maxY = maxY;
		this.ID = ID;
		this.maxID = maxID;
		setUpImage();
		setUp();
	}

	public void setUp() {
		y = (maxY + minY) / 2;
		if (playerNum == 1) {
			x = minX;
		}
		if (playerNum == 2) {
			x = maxX - iconW;
		}
		if (ID == 0) {
			CD = 4;
		}
		if (ID == 1) {
			CD = 3;
		}
		if (ID == 2) {
			CD = 2;
		}
	}

	public void setUpImage() {
		for (int i = 0; i < maxID; i++) {
			if (ID == i)
				icon = new ImageIcon("src\\Images\\Panel 3\\Characters\\CharacterIcon" + i + "_" + playerNum + ".png")
						.getImage();
		}
	}

	public void moveUp() {
		y -= dy;
		if (y < minY) {
			y = minY;
		}
	}

	public void moveDown() {
		y += dy;
		if (y + iconH > maxY) {
			y = maxY - iconH;
		}
	}

	public void moveLeft() {
		x -= dx;
		if (playerNum == 1) {
			if (x < minX) {
				x = minX;
			}
		} else if (playerNum == 2) {
			if (x < midX) {
				x = midX;
			}
		}
	}

	public void moveRight() {
		x += dx;
		if (playerNum == 1) {
			if (x + iconW > midX) {
				x = midX - iconW;
			}
		}
		if (playerNum == 2) {
			if (x + iconW > maxX) {
				x = maxX - iconW;
			}
		}
	}

	public Rectangle bounds() {
		return (new Rectangle(x, y, iconW, iconH));
	}
}
