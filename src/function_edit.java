
public class function_edit {

	GUI gui;
	public function_edit(GUI gui) {
		this.gui=gui;
	}
	
	public void undo() {
		gui.um.undo();
	}
	
	public void redo() {
		gui.um.redo();
	}
}

