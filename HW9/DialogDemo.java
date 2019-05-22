import java.awt.*;
import java.awt.event.*;

// �~��java.awt.Dialog
public class DialogDemo extends java.awt.Dialog {

  public static void main(String args[]){
    new DialogDemo();
  }
  
  // �غc�禡
  public DialogDemo() {
    super((Dialog)null);
	
    // �]�w��ܲ����j�p
    this.setSize(250, 150);

    // Center the Dialog
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension dialogSize = this.getSize();

    if (dialogSize.height > screenSize.height)
      dialogSize.height = screenSize.height;

    if (dialogSize.width > screenSize.width)
      dialogSize.width = screenSize.width;

    this.setLocation((screenSize.width - dialogSize.width) / 2, (screenSize.height - dialogSize.height) / 2);

    // ��ܹ�ܲ�
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}