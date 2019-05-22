import java.awt.*;
import java.awt.event.*;
public class CustomDialogDemo extends java.awt.Frame implements java.awt.event.ActionListener
{
  String[] menulabel = { "File" };
  
  String[][] menuitemlabel = { { "New", "Open", "-", "Save", "Save As...", "-", "Exit" } };
  


  java.awt.Menu[] menu = new java.awt.Menu[1];
  MenuItem[][] menuitem = new MenuItem[1][7];
  
  Label label;
  
  FileDialog filedialog ;
  
  public static void main(String[] paramArrayOfString)
  {
    new CustomDialogDemo();
  }
    // �غc�禡
public CustomDialogDemo() {
    super("File Dialog Demo");

    // �w�q Layout Manager �� BorderLayout
    setLayout(new BorderLayout());
    
    // Demo only
    label = new Label();
    add(label, BorderLayout.SOUTH);

    // �إ߿��C
    MenuBar menuBar = createMenuBar();

    // �w�q�����ϥΪ̤��������C
    setMenuBar(menuBar);

    // �]�w�������j�p
    this.setSize(250, 250);

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
  




private MenuBar createMenuBar() {
    // �إ߿��C
    MenuBar menuBar = new MenuBar();

    // �إ߿��
    for (int i=0; i<menulabel.length; i++){
      // �إ߿��
      menu[i] = new Menu(menulabel[i]);
      menu[i].setFont(new Font("dialog", Font.PLAIN, 11));

      // �s�W���ܿ��C
      menuBar.add(menu[i]);
    }

    for(int i=0; i<menulabel.length; i++){
      for(int j=0; j<menuitemlabel[i].length; j++){
        if (menuitemlabel[i][j].equals("-")) {
          // �s�W���j�u
          menu[i].addSeparator();
        }
        else {
          // �إ߿�涵��
          menuitem[i][j] = new MenuItem(menuitemlabel[i][j]);
          menuitem[i][j].setFont(new Font("dialog", Font.PLAIN, 11));

          // ���U ActionListener
          menuitem[i][j].addActionListener(this);

          // �s�W��涵��
          menu[i].add(menuitem[i][j]);
        }          
      }
    }

    return menuBar;
  }
  

  public void actionPerformed(java.awt.event.ActionEvent paramActionEvent)
  {
    MenuItem localMenuItem = (MenuItem)paramActionEvent.getSource();
    Object localObject1;
    Object localObject2; boolean bool; if (localMenuItem.getLabel().equals("New")) {
      localObject1 = localMenuItem.getLabel();
      
      localObject2 = new CustomDialog(this, (String)localObject1, (String)localObject1 + " Dialog Demo.", true);
      
      bool = ((CustomDialog)localObject2).getState();
      
      if (bool) {
        label.setText("Select OK Button.");
      } else {
        label.setText("Select Cancel Button.");
      }
    } else if (localMenuItem.getLabel().equals("Open")) {
      localObject1 = new FileDialog(this, "Open File", 0);
      

      localObject2 = new Filter("java");
      


      ((FileDialog)localObject1).setFilenameFilter((java.io.FilenameFilter)localObject2);
      
      ((FileDialog)localObject1).setVisible(true);
      
      label.setText("File Selected: " + ((FileDialog)localObject1).getDirectory() + ((FileDialog)localObject1).getFile());
    }
    else if (localMenuItem.getLabel().equals("Save")) {
      localObject1 = new FileDialog(this, "Save File", 1);
      

      localObject2 = new Filter("java");
      


      ((FileDialog)localObject1).setFilenameFilter((java.io.FilenameFilter)localObject2);
      
      ((FileDialog)localObject1).setVisible(true);
      
      label.setText("File Selected: " + ((FileDialog)localObject1).getDirectory() + ((FileDialog)localObject1).getFile());
    }
    else if (localMenuItem.getLabel().equals("Save As...")) {
      localObject1 = localMenuItem.getLabel();
      
      localObject2 = new CustomDialog(this, (String)localObject1, (String)localObject1 + " Dialog Demo.", true);
      
      bool = ((CustomDialog)localObject2).getState();
      
      if (bool) {
        label.setText("Select OK Button.");
      } else {
        label.setText("Select Cancel Button.");
      }
    } else if (localMenuItem.getLabel().equals("Exit")) {
      System.exit(0);
    }
  }
}