/**
 *@author Antony Martel
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Hideout extends JPanel
{
    BufferedImage hideoutImage;
    Dimension hideoutSize;
    
    public Hideout(String hideoutName)
    {        
        hideoutImage = Tools.loadImage(hideoutName);
        hideoutSize = new Dimension(hideoutImage.getWidth(),hideoutImage.getHeight());
        super.setPreferredSize(hideoutSize);
    }
   
    @Override
    public void paintComponent(Graphics g) 
    {
        g.drawImage(hideoutImage, 0, 0, null);
    }
}
