/**
 *@author Antony Martel
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Board extends JPanel
{
    Hideout playerAHideout;
    //Hideout playerBHideout;
    Deck playerADeck;
    //Deck playerBDeck;
    BufferedImage boardImage;
    Dimension boardSize;
    ArrayList<Card> cardPool;
    
    public Board (String boardName)
    {
        cardPool = Tools.loadCardPool("CardPool");
        playerAHideout = new Hideout("TestHideoutA");
        //playerBHideout = new Hideout("TestHideoutB");
        playerADeck = new Deck("TestDeck",cardPool);
        //playerBDeck = new Deck("TestDeck",cardPool);
        boardImage = Tools.loadImage(boardName);
        boardSize = new Dimension(boardImage.getWidth(),boardImage.getHeight());
        super.setPreferredSize(boardSize);
    }
       
    @Override
    public void paintComponent(Graphics g) 
    {
        g.drawImage(boardImage, 0, 0, null);
    }
}