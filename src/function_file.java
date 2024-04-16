import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class function_file {

	GUI gui;
	String fileName,fileAddress;
	
	public function_file(GUI gui) {
		this.gui=gui;
	}
	
	//New
	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("New");
		fileName=null;
		fileAddress=null;
		
	}
	
	//Open 
	public void open() {
		FileDialog fd=new FileDialog(gui.window,"Open",FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile()!=null) {
			fileName=fd.getFile();
			fileAddress=fd.getDirectory();
			gui.window.setTitle(fileName);
		}
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(fileAddress+fileName));
			
			gui.textArea.setText("");
			
			String line=null;
			while((line=br.readLine())!=null) {
				gui.textArea.append(line+"\n");
			}
			br.close();
		}catch(Exception e){
			System.out.println("Error while opening the file");
		}
	}
	

	//SaveAs
	public void SaveAs() {  //for a totally new file
		FileDialog fd=new FileDialog(gui.window,"Save",FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile()!=null) {
			fileName=fd.getFile();
			fileAddress=fd.getDirectory();
			gui.window.setTitle(fileName);
		}
		
		try {	
			FileWriter fw=new FileWriter(fileAddress+fileName);
			fw.write(gui.textArea.getText());
			fw.close();
			
			
		}catch(Exception e) {
			System.out.println("Error while saving the file");
		}
		
	}
	
	//save
	public void Save() {
		
		if(fileName==null) {
			SaveAs();
		}else {
			try {
				FileWriter fw=new FileWriter(fileAddress+fileName);
				fw.write(gui.textArea.getText());
				fw.close();
				
			}catch(Exception e) {
				System.out.println("Error while saving the file");
			}
		}
		
	}
	
	//exit
	public void Exit() {
		System.exit(0);
	}

}
