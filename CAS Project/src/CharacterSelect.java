import java.awt.*;
import javax.swing.*;

public class CharacterSelect{
	Image background;
	JButton champButtons[] = new JButton[3];
	JButton lockIn = new JButton();
	
	boolean showLockIn = false;
	boolean show;
	CharacterSelect(int num, boolean show){
		this.show = show;
		background = new ImageIcon("src\\Images\\Panel 3\\ChampSelect\\background"+num+".png").getImage();
		setUpButtons();
		setUpLock();
		
	}
	
	public void setUpLock() {
		Image img = new ImageIcon("src\\Images\\Panel 3\\ChampSelect\\lockIn.png").getImage();
		lockIn.setIcon(new ImageIcon(img.getScaledInstance(300,100,java.awt.Image.SCALE_SMOOTH)));
		lockIn.setBounds(400,600,300,100);
		lockIn.setMargin(new Insets(0, 0, 0, 0));
		lockIn.setVisible(true);
	}
	
	public void setUpButtons() {
		Image img[] = new Image[champButtons.length];
		int buttonDimension = 150;
		for (int i =0; i<img.length; i++) {
			img[i] = new ImageIcon("src\\Images\\Panel 3\\Characters\\CharacterIcon"+i+"_1.png").getImage();
		}
		int x = 0;
		int y = 1;
		for (int i =0; i<champButtons.length; i++) {
			champButtons[i] = new JButton();
			champButtons[i].setIcon(new ImageIcon(img[i].getScaledInstance(buttonDimension, buttonDimension,java.awt.Image.SCALE_SMOOTH)));
			champButtons[i].setBounds(270+250*x,150+150*y,buttonDimension, buttonDimension);
			champButtons[i].setMargin(new Insets(0, 0, 0, 0));
			champButtons[i].setVisible(true);
			if(200+150*x>800) {
				x=-1;
				y++;
			}
			x++;
		}
		
	}
}
