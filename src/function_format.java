import java.awt.Font;

public class function_format {
	GUI gui;
	Font arial,comicSansMS,timesNewRoman;
	String selectedFont;
	
	public function_format(GUI gui){
		this.gui=gui;
	}
	
	public void wordWrap() {
		if(gui.wordWrapOn==false) {
			gui.wordWrapOn=true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.item.setText("wordWrap:On");
		}
		else if(gui.wordWrapOn==true) {
			gui.wordWrapOn=false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.item.setText("wordWrap:Off");
		}
	}
	
	public void createFont(int fontSize) {
		arial=new Font("Arial",Font.PLAIN,fontSize);
		comicSansMS=new Font("Comic Sans MS",Font.PLAIN,fontSize);
		timesNewRoman=new Font("Times New Roman",Font.PLAIN,fontSize);
		
		setFont(selectedFont);
	}
	
	public void setFont(String font) {
		
		selectedFont=font;
		
		switch(selectedFont) {
		case "Arial":
			gui.textArea.setFont(arial);
			break;
		
		case "Comic Sans MS":
			gui.textArea.setFont(comicSansMS);
			break;
		
		case "Times New Roman":
			gui.textArea.setFont(timesNewRoman);
			break;

		}
	}
}
