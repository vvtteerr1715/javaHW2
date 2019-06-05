import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class hw1 extends javax.swing.JFrame {

  // Main method
  public static void main(String[] args) {
    UIManager.put("swing.boldMetal", Boolean.FALSE);
    JDialog.setDefaultLookAndFeelDecorated(true);
    JFrame.setDefaultLookAndFeelDecorated(true);
    Toolkit.getDefaultToolkit().setDynamicLayout(true);

    try {
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    new hw1();
  }

  // �غc�禡
  public hw1() {
    super("Overlay Layout Demo");

    // �����w�qJFrame��Layout Manager��BorderLayout
    this.setLayout(new BorderLayout());

    JPanel jpanel = new JPanel();

    // �w�qLayout Manager��OverlayLayout
    jpanel.setLayout(new OverlayLayout(jpanel));
    
    JButton jbutton1 = new JButton("Button 1");
    // �]�w jbutton1 ����������I
    jbutton1.setAlignmentX(0.5f);
    // �]�w jbutton1 ����������I
    jbutton1.setAlignmentY(0.0f);
    // �]�w�̤p�ؤo
    jbutton1.setMinimumSize(new Dimension(100, 100));
    // �]�w�̨Τؤo
    jbutton1.setPreferredSize(new Dimension(200, 200));
    // �]�w�̤j�ؤo
//    jbutton1.setMaximumSize(new Dimension(150, 150));
    jpanel.add(jbutton1);

    JButton jbutton2 = new JButton("Button 2");
    // �]�w jbutton2 ����������I
    jbutton2.setAlignmentX(0.0f);
    // �]�w jbutton2 ����������I
    jbutton2.setAlignmentY(0.5f);
    // �]�w�̤p�ؤo
    jbutton2.setMinimumSize(new Dimension(100, 100));
    // �]�w�̨Τؤo
    jbutton2.setPreferredSize(new Dimension(200, 200));
    // �]�w�̤j�ؤo
//    jbutton2.setMaximumSize(new Dimension(150, 150));
    jpanel.add(jbutton2);

    this.add(jpanel, BorderLayout.CENTER);
    
    // �]�w�������j�p
    this.setSize(250, 150);

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
}
