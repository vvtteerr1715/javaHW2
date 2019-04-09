import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mid_3 extends java.awt.Frame {

  public static void main(String args[]){
    new Mid_3();
  }
  
  // 建構函式
  public Mid_3() {
    super("h1");

    final int row = 2,column = 1;
    setLayout(new GridLayout(row, column));

  
    java.awt.Button button;
    button = new Button("Button");
    button.setFont(new Font("", Font.BOLD, 20));
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
    		if (e.getSource().equals(button))
    			System.out.println("Button pressed");
    	  }
	});
    add(button);

    // 設定視窗的大小
    this.setSize(300, 200);

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
}