import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
 

public class BrowserSample {
    // These are the buttons for iterating through the page list.
    private JButton backButton, forwardButton;
     
    // Page location text field.
    private JTextField locationTextField;
     
    private JFrame frame;
    private Browser browser;
    private BrowserView browserView;
     
    // Constructor for Web Browser.
    public BrowserSample() {
       
    	frame = new JFrame("Jive");
        frame.setSize(700, 500);
        frame.setVisible(true);
         
        browser = new Browser();
        browserView = new BrowserView(browser);
                      
        // Handle closing events.
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                actionExit();
            }
        });
         
        // Set up file menu.
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem fileExitMenuItem = new JMenuItem("Exit",
                KeyEvent.VK_X);
        fileExitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionExit();
            }
        });
        fileMenu.add(fileExitMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
         
        // Set up button panel.
        JPanel buttonPanel = new JPanel();
        backButton = new JButton("< Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //actionBack();
            }
        });
        backButton.setEnabled(false);
        buttonPanel.add(backButton);
        forwardButton = new JButton("Forward >");
        forwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //actionForward();
            }
        });
        forwardButton.setEnabled(false);
        buttonPanel.add(forwardButton);
        locationTextField = new JTextField(35);
        locationTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    actionGo();
                }
            }
        });
        buttonPanel.add(locationTextField);
        JButton goButton = new JButton("GO");
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionGo();
            }
        });
        buttonPanel.add(goButton);
                 
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        frame.getContentPane().add(browserView, BorderLayout.CENTER);
    }
     
    // Exit this program.
    private void actionExit() {
        System.exit(0);
    }
      
    // Load and show the page specified in the location text field.
    private void actionGo() {
    	browser.loadURL(locationTextField.getText());
    }
         
    // Run the Browser.
    public static void main(String[] args) {
        BrowserSample browser = new BrowserSample();
        //browser.show();
    }
}