/**
 *@author Antony Martel
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener
{
    JPanel pnlButton = new JPanel();
    JButton btnMatchmaking = new JButton("Matchmaking");
    JButton btnProfile = new JButton("Profile");
    JButton btnOption = new JButton("Options");
    JButton btnExit = new JButton("Exit");
    
    public Menu(String s) 
    {        
        btnMatchmaking.setAlignmentX(CENTER_ALIGNMENT);
        btnOption.setAlignmentX(CENTER_ALIGNMENT);
        btnProfile.setAlignmentX(CENTER_ALIGNMENT);
        btnExit.setAlignmentX(CENTER_ALIGNMENT);
        pnlButton.setLayout(new BoxLayout(pnlButton,BoxLayout.Y_AXIS));
        pnlButton.add(btnMatchmaking);
        pnlButton.add(btnProfile);
        pnlButton.add(btnOption);
        pnlButton.add(btnExit);
        btnExit.addActionListener(this);
        btnMatchmaking.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocation(800,300);
        super.setResizable(false);
        super.add(pnlButton);
        super.pack();
    }
    
    //Handle action events.
    //@param evt
    @Override
    public void actionPerformed(ActionEvent evt) 
    { 
        if(evt.getSource() == btnMatchmaking)
        { 
            if(Main.theBoard == null)
            {
                Main.theBoard = new Board("TestBoard");
            }
            super.setLocation(0,0);
            super.remove(pnlButton);
            super.setLayout(new BorderLayout()); 
            super.add(Main.theBoard.playerAHideout,BorderLayout.SOUTH);
            super.add(Main.theBoard,BorderLayout.CENTER);
           // super.add(Main.theBoard.playerBHideout,BorderLayout.NORTH);
            super.pack();        
        }
        if(evt.getSource() == btnExit)
        {
            System.exit(0);
        }
    }
}
