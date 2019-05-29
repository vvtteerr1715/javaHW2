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
      // �]�wMetal Look and Feel
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    
    new DecorationDemo();
  }

  // �غc�禡
  public DecorationDemo() {
    // ���o�ثe��Class Loader
    /*cl = this.getClass().getClassLoader();

    this.setUndecorated(true);
    this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
    this.setTitle("Decoration: FRAME");

    // �]�w�����ϥ�
   // this.setIconImage(new ImageIcon(cl.getResource("images/java.png")).getImage());*/
   this.setTitle("Decoration: FRAME");

    // �إ߿��C
    JMenuBar jmenubar = createJMenuBar();

    // �w�q�����ϥΪ̤��������C
    this.setJMenuBar(jmenubar);

    // �]�w�������j�p
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

    // ��ܵ���
    this.setVisible(true);
    
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  private JMenuBar createJMenuBar() {
    // �إ߿��C
   JMenuBar jmenubar = new JMenuBar();

    // �إ߿��
    JMenu jmenuFile = new JMenu("File");

    // �إ߿�涵��
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

    // �إ߿��
    JMenu jmenuDec = new JMenu("Decoration");

    // �غc�s��
    ButtonGroup group = new ButtonGroup();

    for (int i=0; i<item.length; i++) {
      jrbmenuitem[i] = new JRadioButtonMenuItem(item[i]);
	   // �]�w�O�_�ҥο�涵��
      jrbmenuitem[i].setEnabled(isLookAndFeelSupported(classname[i]));

      jmenuDec.add(jrbmenuitem[i]);
      group.add(jrbmenuitem[i]);
      
      // ���U ActionListener
      jrbmenuitem[i].addActionListener(this);
     
       if (i==0)
        jrbmenuitem[i].setSelected(true);
    }


    // �s�W���ܿ��C
    jmenubar.add(jmenuFile);
    jmenubar.add(jmenuDec);
   // jmenubar.add(jmenuHelp);

    return jmenubar;
  }
  private boolean isLookAndFeelSupported(String lnfname) {
    try { 
      Class lnfclass = Class.forName(lnfname);
      javax.swing.LookAndFeel lnf = (LookAndFeel)(lnfclass.newInstance());
            // �P�_�@�~�t�άO�_�䴩Look and Feel
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
