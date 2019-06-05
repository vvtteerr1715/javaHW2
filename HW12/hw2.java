import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class hw2 extends javax.swing.JFrame {

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

    new hw2();
  }

  // �غc�禡
  public hw2() {
    super("Rigid Area Demo");

    // �����w�qJFrame��Layout Manager��FlowLayout
    this.setLayout(new FlowLayout());

    JPanel jpanel = new JPanel();

    // �w�qLayout Manager��BoxLayout
    // �ѥ��ܥk�t�m
    jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.X_AXIS));

    // �إ�Box��Rigid Area�ϰ�
    jpanel.add(Box.createRigidArea(new Dimension(100, 100)));

    jpanel.add(new JButton("Button 1"));

    // �إ�Box��Rigid Area�ϰ�
    jpanel.add(Box.createRigidArea(new Dimension(150, 150)));

    jpanel.add(new JButton("Button 2"));

    // �إ�Box��Rigid Area�ϰ�
    jpanel.add(Box.createRigidArea(new Dimension(50, 50)));

    this.add(jpanel);

    // �]�w�������j�p
    this.setSize(250, 100);

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
