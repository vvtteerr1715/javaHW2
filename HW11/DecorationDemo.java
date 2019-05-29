import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;

public class DecorationDemo extends javax.swing.JFrame implements ActionListener {

  JRadioButtonMenuItem[] jrbmenuitem = new JRadioButtonMenuItem[7];
  
  String item[] = {
    "Metal", "CDE/Motif", "Windows XP", 
    "Windows Classic", "GTK+", "Mac", };
	
	String classname[] = {
		"javax.swing.plaf.metal.MetalLookAndFeel",
		"com.sun.java.swing.plaf.motif.MotifLookAndFeel",
		"com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
		"com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel",
		"com.sun.java.swing.plaf.metal.MetalLookAndFeel",
		"com.sun.java.swing.plaf.mac.MaclookAndFeel"}; 
  // Main method
  public static void main(String[] args) {
    UIManager.put("swing.boldMetal", Boolean.FALSE);
    try {
      // 設定Metal Look and Feel
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    
    new DecorationDemo();
  }

  // 建構函式
  public DecorationDemo() {
    // 取得目前之Class Loader
    /*cl = this.getClass().getClassLoader();

    this.setUndecorated(true);
    this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
    this.setTitle("Decoration: FRAME");

    // 設定視窗圖示
   // this.setIconImage(new ImageIcon(cl.getResource("images/java.png")).getImage());*/
   this.setTitle("Decoration: FRAME");

    // 建立選單列
    JMenuBar jmenubar = createJMenuBar();

    // 定義視窗使用者介面之選單列
    this.setJMenuBar(jmenubar);

    // 設定視窗的大小
    this.setSize(250, 150);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();

    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;

    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;

    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    // 顯示視窗
    this.setVisible(true);
    
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  private JMenuBar createJMenuBar() {
    // 建立選單列
   JMenuBar jmenubar = new JMenuBar();

    // 建立選單
    JMenu jmenuFile = new JMenu("File");

    // 建立選單項目
    JMenuItem jmenuFileExit = new JMenuItem("Exit");
    jmenuFileExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane joptionpane = new JOptionPane();
        int iResult = joptionpane.showConfirmDialog(null, "Are you sure to quit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (iResult == 0) {
          System.exit(0);
        }
      }
    });

    jmenuFile.addSeparator();
    jmenuFile.add(jmenuFileExit);

    // 建立選單
    JMenu jmenuDec = new JMenu("Decoration");

    // 建構群組
    ButtonGroup group = new ButtonGroup();

    for (int i=0; i<item.length; i++) {
      jrbmenuitem[i] = new JRadioButtonMenuItem(item[i]);
	   // 設定是否啟用選單項目
      jrbmenuitem[i].setEnabled(isLookAndFeelSupported(classname[i]));

      jmenuDec.add(jrbmenuitem[i]);
      group.add(jrbmenuitem[i]);
      
      // 註冊 ActionListener
      jrbmenuitem[i].addActionListener(this);
     
       if (i==0)
        jrbmenuitem[i].setSelected(true);
    }


    // 新增選單至選單列
    jmenubar.add(jmenuFile);
    jmenubar.add(jmenuDec);
   // jmenubar.add(jmenuHelp);

    return jmenubar;
  }
  private boolean isLookAndFeelSupported(String lnfname) {
    try { 
      Class lnfclass = Class.forName(lnfname);
      javax.swing.LookAndFeel lnf = (LookAndFeel)(lnfclass.newInstance());
            // 判斷作業系統是否支援Look and Feel
      return lnf.isSupportedLookAndFeel();
    } 
    catch(Exception ex) { 
      return false;    }  }


  public void actionPerformed(ActionEvent e) {
    try {
      for(int i=0;i<item.length;i++){
		  if(e.getActionCommand().equals(item[i])){
			   UIManager.setLookAndFeel(classname[i]);
		  }
			  
    }
  }
  catch(Exception ex) {}
  SwingUtilities.updateComponentTreeUI(this);
  }
}
