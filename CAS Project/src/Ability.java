import java.awt.*;
import javax.swing.*;

public class Ability {
	int champID;
	int maxID;
	Image img;
	int imgW;
	int imgH;

	int x;
	int y;
	int dx;
	int dy;
	int minX;
	int minY;
	int maxX;
	int maxY;

	int counter = 0;
	boolean show = true;
	int playerNum;

	Ability(int champID, int characterX, int characterY, int characterW, int characterH, int maxID, int playerNum,
			int minX, int minY, int maxX, int maxY) {
		this.champID = champID;
		this.maxID = maxID;
		this.playerNum = playerNum;
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		setUpAbilityIcon();
		setUpPosition(characterX, characterY, characterW, characterH);
	}

	public void setUpPosition(int characterX, int characterY, int characterW, int characterH) {
		y = characterY + (characterH - imgH) / 2;
		if (playerNum == 1) {
			x = characterX + characterW;
		} else if (playerNum == 2) {
			x = characterX - imgW;
		}
	}

	public void setUpAbilityIcon() {
		if (champID == 0) {
			if (playerNum == 1)
				img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability0_1.png").getImage();
			else if (playerNum == 2)
				img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability0_2.png").getImage();
			imgW = 100;
			imgH = 20;
			dx = 8;
			dy = 0;
		}
		if (champID == 1) {
			if (playerNum == 1)
				img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability1_1.gif").getImage();
			else if (playerNum == 2)
				img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability1_2.gif").getImage();
			imgW = 50;
			imgH = 50;
			dx = 4;
			dy = 4;
		}
		if (champID == 2) {
			if (playerNum == 1)
				img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability0_1.png").getImage();
			else if (playerNum == 2)
				img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability0_2.png").getImage();
			imgW = 100;
			imgH = 20;
			dx = 6;
			dy = 20;
		}
	}

	public void move() {
		if (champID == 0) {
			if (playerNum == 1) {
				x += dx;
				if (x + imgW > maxX) {
					show = false;
				}
			} else if (playerNum == 2) {
				x -= dx;
				if (x < minX) {
					show = false;
				}
			}
		}
		if (champID == 1) {
			if (playerNum == 1) {
				x += dx;
				if (x + imgW > maxX) {
					// show = false;
					dx = -dx;
				}
				if (x < (minX + maxX) / 2 && dx < 0) {
					show = false;
				}
				y += dy;
				if (y + imgH > maxY) {
					dy = -dy;
					y -= 5;
				}
				if (y < minY) {
					dy = -dy;
					y += 5;
				}
			} else if (playerNum == 2) {
				x -= dx;
				if (x < minX) {
					dx = -dx;
				}
				if (x + imgW > (minX + maxX) / 2 && dx < 0)
					show = false;
				y += dy;
				if (y + imgH > maxY) {
					dy = -dy;
					y -= 5;
				}
				if (y < minY) {
					dy = -dy;
					y += 5;
				}
			}
		}
		if (champID == 2) {
			if (playerNum == 1) {
				x += dx;
				if (counter % 3 == 0) {
					y += dy;
					dy--;
				}
				if (dy > 3) {
					img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability2_1_0.png").getImage();
					imgW = 100;
					imgH = 30;
				}
				if (3 > dy && dy > -3) {
					img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability2_1_1.png").getImage();
					imgW = 150;
					imgH = 20;

				}
				if (-3 > dy && dy > -10) {
					img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability2_1_2.png").getImage();
					imgW = 100;
					imgH = 40;
				}
				if (dy < -10) {
					img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability2_1_3.png").getImage();
					imgW = 80;
					imgH = 50;

				}
				counter++;

				if (x + imgW > maxX)
					show = false;
			}
			if (playerNum == 2) {
				x -= dx;
				if (counter % 3 == 0) {
					y += dy;
					dy--;
				}

				counter++;

				if (dy > 3) {
					img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability2_2_0.png").getImage();
					imgW = 100;
					imgH = 30;
				}
				if (3 > dy && dy > -3) {
					img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability2_2_1.png").getImage();
					imgW = 150;
					imgH = 20;

				}
				if (-3 > dy && dy > -10) {
					img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability2_2_2.png").getImage();
					imgW = 100;
					imgH = 40;
				}
				if (dy < -10) {
					img = new ImageIcon("src\\Images\\Panel 3\\Ability\\ability2_2_3.png").getImage();
					imgW = 80;
					imgH = 50;

				}
				if (x < minX)
					show = false;
			}

		}
	}

	public Rectangle bounds() {
		return (new Rectangle(x, y, imgW, imgH));
	}
}
