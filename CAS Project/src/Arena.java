import java.awt.*;
import javax.swing.*;

public class Arena {
	Image img = new ImageIcon("src\\Images\\Panel 3\\Game\\background.png").getImage();
	int imgW;
	int imgH;
	int leftX;
	int rightX;
	int midX;
	int topY;
	int bottomY;
	boolean show = false;

	Arena(int maxW, int maxH) {
		leftX = 50;
		rightX = maxW - leftX;
		midX = (leftX + rightX) / 2;
		topY = 100;
		bottomY = maxH - topY - 50;
		imgW = rightX - leftX;
		imgH = bottomY - topY;
	}
}
