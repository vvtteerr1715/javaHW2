import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class hw1 extends javax.swing.JFrame {

  // Main method
  public static void main(String[] args) {
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
    super("Hello World JFrame");

    //this.setUndecorated(true);
    //this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

    DisplayPanel displayPanel = new DisplayPanel();

    // JDK 1.4���Ϊk
    // ���o��Content Pane 
    //Container contentPane = getContentPane();
    // �w�q Layout Manager �� BorderLayout
    //contentPane.setLayout(new BorderLayout());
    // �N����[��Content Pane��
    //contentPane.add(displayPanel, BorderLayout.CENTER);

    // JDK 5.0���᪺�Ϊk
    // �����w�qJFrame��Layout BorderLayout
    this.setLayout(new BorderLayout());
    this.add(displayPanel, BorderLayout.CENTER);

    this.validate();
    this.setSize(new Dimension(200, 200));

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}

class DisplayPanel extends javax.swing.JPanel {
  public DisplayPanel() {
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawString("Hello MCU", 50, 50);
  }
}
