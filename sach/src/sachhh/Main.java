package sachhh;

import javax.swing.JFrame;

public class Main {
public static void main(String[] args) {
	Gui gui = new Gui();
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.setTitle("mooon");
	gui.setSize(900,400);
	gui.setVisible(true);
	gui.setResizable(false);
	gui.setLocationRelativeTo(null);
}
}
