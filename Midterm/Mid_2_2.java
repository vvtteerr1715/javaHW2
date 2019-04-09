import java.awt.*;
import java.awt.event.*;

public class Mid_2_2 extends java.awt.Frame {

  public static void main(String args[]){
    new Mid_2_2();
  }
  
  public Mid_2_2() {
    super("Mid_2_2");
    
    FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER); 
    flowlayout.setHgap(10);
    flowlayout.setVgap(10);
    setLayout(flowlayout); 
    
    Button button1 = new Button("HI");
    Button button2 = new Button("HELLO");
    Button button3 = new Button("�A�n");
    Button button4 = new Button("���w");
    Button button5 = new Button("�ڶٳ�");
    add(button1);
    add(button2);
    add(button3);
    add(button4);
    add(button5);

    this.setSize(200, 150);

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