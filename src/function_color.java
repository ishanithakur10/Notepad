import java.awt.Color;

public class function_color {
	GUI gui;
	
	public function_color(GUI gui) {
		this.gui=gui;
	}
	
	public void changeColor(String color) {
		switch(color) {
		case"white":
			gui.window.getContentPane().setBackground(Color.WHITE);
			gui.textArea.setBackground(Color.WHITE);
			gui.textArea.setForeground(Color.BLACK);
			break; 
			
		case"black":
			gui.window.getContentPane().setBackground(Color.BLACK);
			gui.textArea.setBackground(Color.BLACK);
			gui.textArea.setForeground(Color.WHITE);
			break;
		
		case"orange":
			gui.window.getContentPane().setBackground(Color.ORANGE);
			gui.textArea.setBackground(Color.ORANGE);
			gui.textArea.setForeground(Color.WHITE);
            break;
		}
	}	
	
}	


