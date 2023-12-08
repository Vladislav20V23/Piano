package Base;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import javax.sound.midi.*;
import javax.swing.*;

import Base.Button.*;
import Base.Server.IncomingReader;
import Base.Server.Out;
import Base.Server.SetSock;
import Base.Server.ThreadServer;


public class PlayingThePiano extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ThreadServer threadServer;
	protected static ArrayList<JCheckBox> musikJCheckBoxList;
	protected String[] notaName = {"LA", "SOL", "FA", "MI","RE", "UT" }; 
	protected static int [] notaKey = {90,75,60,45,30,25};
	protected static JCheckBox check;
	protected static JFrame frame;
	protected static JDialog use;
	JPanel backgroundPanelNorth;
	JPanel backgroundPanelSOUTH;
	JPanel mainPanel;
	JPanel mainPanelL;	
	JPanel panelBas;
	JPanel southBut;
	JPanel southBut2;
	JPanel panelEast;
	JPanel panelEastArea;
	protected static JLabel panelChat;
	protected static JLabel backgroundLabel;
	JButton start;
	JButton stop;
	JButton tempUp;
	JButton tempDouwn;
	JButton back;
	JButton resetBut;
	JButton importFile;
	protected static JButton out;
	protected static JScrollPane qScroller;
	protected static JTextArea tablo;
	protected static JTextArea outGo;
	protected static JTextArea useNameArea;
	JMenuItem chatOpenClouse;
	JMenuItem chatOpenClouse2;
	JMenuItem setNameMenu;
	JMenuItem systemExit;
	
	protected static Sequencer sequencer;
	protected static Sequence sequence;
	protected static Track track;
	
	protected static PrintWriter writer;
	protected static Socket sock;
	protected static BufferedReader reader;
	protected static String userName = "Анонимчик";
	
	
	public void go() {																// создание GUI 
		
		new UserNameGUIclass().userNameGUI();
		frame = new JFrame("The Pian");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		backgroundLabel = new JLabel(new ImageIcon("src/gx.jpg"));					// создаем лейбл фон (задаем компоновщика)и кидаем во фрейм
		frame.add(backgroundLabel);
		backgroundLabel.setLayout(new BorderLayout());
		backgroundLabel.setOpaque(false);
		
		
		backgroundPanelNorth = new JPanel();												
		backgroundPanelNorth.setOpaque(false);
						
		backgroundLabel.add(BorderLayout.NORTH,backgroundPanelNorth);
		backgroundPanelNorth.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));  
		
		
		start = new JButton("Играть");														//делаем кнопки (к ним слушателей) и добавляем на пенели
		backgroundPanelNorth.add(start);
		start.addActionListener(new ButtonStart());
		
		stop = new JButton("Остановить");
		backgroundPanelNorth.add(stop);
		stop.addActionListener(new ButtonStop());
		
		backgroundPanelSOUTH = new JPanel();
		backgroundPanelSOUTH.setOpaque(false);
		
		
		southBut2 = new JPanel();										//создаем 2 коробки для кнопок и 2 панели для коробок - кидаем на backgroundLabel
		southBut2.setOpaque(false);
		Box tempBox = new Box(BoxLayout.X_AXIS);											
		tempUp = new JButton("Ускорить");
		tempUp.addActionListener(new TempUp());
		tempBox.add(tempUp);
		tempDouwn = new JButton("Замедлить");
		tempDouwn.addActionListener(new TempDown());
		tempBox.add(tempDouwn);
		southBut2.add(tempBox);
		
		southBut = new JPanel();										
		southBut.setOpaque(false);
		Box BoxSaveImport = new Box(BoxLayout.X_AXIS);
		resetBut = new JButton("Создать мелодию");					
		resetBut.addActionListener(new Rand());
		BoxSaveImport.add(resetBut);
		importFile = new JButton("Сбросить");
		importFile.addActionListener(new Reset());
		BoxSaveImport.add(importFile);	
		southBut.add(BoxSaveImport);
		
		backgroundPanelSOUTH.add(southBut2);
		backgroundPanelSOUTH.add(southBut);
		backgroundLabel.add(BorderLayout.SOUTH,backgroundPanelSOUTH);
	
		JMenuBar menyBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Дополнительно");
		JMenuItem dowloadMenuItem = new JMenuItem("Загрузить шаблон");
		dowloadMenuItem.addActionListener(new Import());
		JMenuItem saveMenuItem = new JMenuItem("Сохранить шаблон");
		saveMenuItem.addActionListener(new Save());
		chatOpenClouse = new JMenuItem("Показать чат");
		chatOpenClouse.addActionListener(new Vizible());
		chatOpenClouse2 = new JMenuItem("Закрыть чат");
		chatOpenClouse2.addActionListener(new Vizible2());
		setNameMenu = new JMenuItem("Изменить имя");
		setNameMenu.addActionListener(new UserNameGUI());
		systemExit = new JMenuItem("Выход");
		systemExit.setBackground(Color.red);
		systemExit.addActionListener(new SystemExit());
		fileMenu.add(setNameMenu);
		fileMenu.add(chatOpenClouse);
		fileMenu.add(chatOpenClouse2);
		fileMenu.add(dowloadMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(systemExit);
		
		menyBar.add(fileMenu);
		
		panelChat = new JLabel();
		panelChat.setText("Mini Chat");
		panelChat.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));										
		panelChat.setFont(new Font("Palatino Linotype Bold Italic", Font.PLAIN, 20));									
		panelChat.setForeground(Color.LIGHT_GRAY);
		panelChat.setVisible(false);
		tablo = new JTextArea(17,15);
		qScroller = new JScrollPane(tablo); 									// делаем возможность вертикальной прокрутки текста  
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		tablo.setEditable(false);				
		tablo.setLineWrap(true);	
		tablo.setWrapStyleWord(true);
		qScroller.setVisible(false);
		Font font = new Font("Palatino Linotype Bold Italic", Font.PLAIN, 14);
		tablo.setFont(font);
		
		panelEast = new JPanel();
		panelEast.setOpaque(false);
		panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.Y_AXIS));
		
		backgroundLabel.add(BorderLayout.EAST,panelEast);
		panelEastArea = new JPanel();
		panelEastArea.setOpaque(false);
		panelEastArea.add(qScroller);
		panelEastArea.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));	
		panelEast.add(panelChat);
		panelEast.add(panelEastArea);
		
		outGo = new JTextArea(3,17);
		outGo.setLineWrap(true);	
		outGo.setWrapStyleWord(true);
		outGo.setFont(font);
		outGo.setVisible(false);
		JPanel panelOutGo = new JPanel();
		panelOutGo.setOpaque(false);
		panelOutGo.add(outGo);
		panelEast.add(panelOutGo);
		
		out = new JButton("Отправить");
		out.addActionListener(new Out());
		out.setVisible(false);
		panelEast.add(out);
		

		
		new SetSock().setSock();
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
				
		new NameInst().TestPane();													//запускаем внутренний класс 
		
		musikJCheckBoxList = new ArrayList<JCheckBox>();							//реализуем ArrayList и запускаем класс чеков для музыки
		new GridLayoutCenter().GoGridLayoutCenter();
		
		new MidiOn().midiOn();														//запускаем проигрыватель
		
		
		
	//	GraphicsEnvironment ge = GraphicsEnvironment						// проверка доступных шрифтов в среде разработки
	//	        .getLocalGraphicsEnvironment();

	//	Font[] allFonts = ge.getAllFonts();

	//	for (Font font : allFonts) {
	//	    System.out.println(font.getFontName(Locale.US));
	//	}
		
		frame.setJMenuBar(menyBar);		
	//	frame.setSize(900,600);	
		frame.setBounds(50,50,600,600);					
		frame.pack();			
		
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
		
}
