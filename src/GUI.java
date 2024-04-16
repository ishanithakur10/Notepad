import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener{

	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn=false;
	
	JMenuBar menuBar;
	JMenu menuFile,menuEdit,menuFormat,menuColor;
	JMenuItem iNew,iSave,iOpen,iSaveAs,iExit;
	
	//for format
	JMenuItem item,Font_Arial,Font_CSM,Font_TM,Font_size8,Font_size12,Font_size16,Font_size19,Font_size24,Font_size28;
	JMenu menuFont,menuFontSize;
	
	//for color menu
	JMenuItem iColor1,iColor2,iColor3;
	
	//for edit
	JMenuItem undo,redo;
	
	function_file file=new function_file(this);
	function_format format=new function_format(this);
	function_color color=new function_color(this);
	function_edit edit=new function_edit(this);
	keyHandler kHandler=new keyHandler(this);
	
	UndoManager um=new UndoManager();
	
	public static void main(String[] args) {
		new GUI();
	}
	
	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		createColorMenu();
		createEditMenu();
		
		format.selectedFont="Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("white");
		
		window.setVisible(true);
	}
	
	public void createWindow() {
		window=new JFrame("NotePad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void createTextArea() {
		textArea=new JTextArea();
		textArea.setFont(format.arial);
		
		textArea.addKeyListener(kHandler);
		
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
			}
		});
		scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}

	public void createMenuBar() {
		menuBar=new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile=new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit=new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat=new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor=new JMenu("Color");
		menuBar.add(menuColor);
	}
	
	public void createFileMenu() {
		
		iNew=new JMenuItem("New");	
		 iNew.addActionListener(this);
		 iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iSave=new JMenuItem("Save");
		 iSave.addActionListener(this);
		 iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iOpen=new JMenuItem("Open");
		 iOpen.addActionListener(this);
		 iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSaveAs=new JMenuItem("SaveAs");
		 iSaveAs.addActionListener(this);
		 iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit=new JMenuItem("Exit");
		 iExit.addActionListener(this);
		 iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	
	public void createEditMenu() {
		undo=new JMenuItem("Undo");
		undo.addActionListener(this);
		undo.setActionCommand("undo");
		menuEdit.add(undo);
		
		redo=new JMenuItem("Redo");
		redo.addActionListener(this);
		redo.setActionCommand("redo");
		menuEdit.add(redo);
	}

	public void createFormatMenu() {
		item=new JMenuItem("Word Wrap: Off");
		item.addActionListener(this);
		item.setActionCommand("Word Wrap");
		menuFormat.add(item);
		
		menuFont=new JMenu("Font");
		menuFormat.add(menuFont);
		
		
		Font_Arial=new JMenuItem("Arial");
		Font_Arial.addActionListener(this);
		Font_Arial.setActionCommand("Arial");
		menuFont.add(Font_Arial);
		
		Font_CSM=new JMenuItem("Comic Sans MS");
		Font_CSM.addActionListener(this);
		Font_CSM.setActionCommand("Comic Sans MS");
		menuFont.add(Font_CSM);
		
		Font_TM=new JMenuItem("Times New Roman");
		Font_TM.addActionListener(this);
		Font_TM.setActionCommand("Times New Roman");
		menuFont.add(Font_TM);
		
		
		menuFontSize=new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		Font_size12=new JMenuItem("12");
		Font_size12.addActionListener(this);
		Font_size12.setActionCommand("12");
		menuFontSize.add(Font_size12);
		
		Font_size8=new JMenuItem("8");
		Font_size8.addActionListener(this);
		Font_size8.setActionCommand("8");
		menuFontSize.add(Font_size8);
		
		Font_size24=new JMenuItem("24");
		Font_size24.addActionListener(this);
		Font_size24.setActionCommand("24");
		menuFontSize.add(Font_size24);
		
		Font_size19=new JMenuItem("19");
		Font_size19.addActionListener(this);
		Font_size19.setActionCommand("19");
		menuFontSize.add(Font_size19);
		
		Font_size16=new JMenuItem("16");
		Font_size16.addActionListener(this);
		Font_size16.setActionCommand("16");
		menuFontSize.add(Font_size16);
		
		Font_size28=new JMenuItem("28");
		Font_size28.addActionListener(this);
		Font_size28.setActionCommand("28");
		menuFontSize.add(Font_size28);
		
	}
//	
	public void createColorMenu() {
		iColor1=new JMenuItem("white");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("white");
		menuColor.add(iColor1);
		
		iColor2=new JMenuItem("black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("black");
		menuColor.add(iColor2);
		
		iColor3=new JMenuItem("orange");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("orange");
		menuColor.add(iColor3);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		switch(command) {
		case "New":
			file.newFile();
			break;
		
		case "Open":
			file.open();
			break;	
			
		case "SaveAs":
			file.SaveAs();
			break;
			
		case "Save":
			file.Save();
			break;	
			
		case "Exit":
			file.Exit();
			break;	
			
		case "Word Wrap":
			format.wordWrap();
			break;	
			
		case "Comic Sans MS":
			format.setFont(command);
			break;	
			
		case "Times New Roman":
			format.setFont(command);
			break;	
			
		case "Arial":
			format.setFont(command);
			break;		
		
		case "8":
			format.createFont(8);
			break;	
			
		case "24":
			format.createFont(24);
			break;	
			
		case "19":
			format.createFont(19);
			break;	
			
		case "28":
			format.createFont(28);
			break;	
			
		case "16":
			format.createFont(16);
			break;	
			
		case "12":
			format.createFont(12);
			break;	
		
		case "white":
			color.changeColor(command);
			break;
		
		case "black":
			color.changeColor(command);
			break;
		
		case "orange":
			color.changeColor(command);
			break;	
			
		case "undo":
			edit.undo();
			break;
			
		case "redo":
			edit.redo();
			break;	
		}
	}
}
