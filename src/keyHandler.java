import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

	GUI gui;
	public keyHandler(GUI gui) {
		this.gui=gui;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown()&& e.getKeyCode()==KeyEvent.VK_S) {
			gui.file.Save();
		}
		if(e.isShiftDown()&& e.isControlDown()&& e.getKeyCode()==KeyEvent.VK_S) {
			gui.file.SaveAs();
		}
		if(e.isAltDown()&& e.getKeyCode()==KeyEvent.VK_F) {
			gui.menuFile.doClick();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
