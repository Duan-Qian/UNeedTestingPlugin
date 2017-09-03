/**
 * This method shows message when achieved an achievement event.
 */
package uneedtestingplugin;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import uneedtestingplugin.DataBase.AchievementDao;

public class Animate {
	private Component frame;
	public static boolean checkMessage;
	public void bronze (String event) {
		ImageIcon icon = new ImageIcon(Animate.class.getResource("/icons/bronze.png"));
		showMessage(event, icon);
	}
	
	public void silver (String event) {
		ImageIcon icon = new ImageIcon(Animate.class.getResource("/icons/silver.png"));
		showMessage(event, icon);
	}
	
	public void gold (String event) {
		ImageIcon icon = new ImageIcon(Animate.class.getResource("/icons/gold.png"));
		showMessage(event, icon);
	}
	
	public void hiddenAchievement (String event) {
		if (event.equals("Merry Christmas")) {
			ImageIcon icon = new ImageIcon(Animate.class.getResource("/icons/christmas.png"));
			showMessage(event, icon);
		} else if (event.equals("Rings")) {
			ImageIcon icon = new ImageIcon(Animate.class.getResource("/icons/rings.jpg"));
			showMessage(event, icon);
		} else if (event.equals("Happy Valentine Day!")) {
			ImageIcon icon = new ImageIcon(Animate.class.getResource("/icons/valentine.png"));
			showMessage(event, icon);
		} else if (event.equals("Good Start")) {
			ImageIcon icon = new ImageIcon(Animate.class.getResource("/icons/gold.png"));
			showMessage(event, icon);
		}
	}
	
	public void showMessage (String event, ImageIcon icon) {
		AchievementDao aDao = new AchievementDao();
		String description = aDao.getDescription(event);
		JOptionPane.showMessageDialog(frame,
				"New Achievement Achieved!\n" + "You unlocked " + event + "\n" + description,
			    "Congratulation!",
			    JOptionPane.PLAIN_MESSAGE,
			    icon);
		checkMessage = true;

	}
}