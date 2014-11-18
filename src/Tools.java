/**
 *@author Antony Martel
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Tools 
{
    public static BufferedImage loadImage (String imageName)
    {
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File("Components/"+imageName+".png"));
        } 
        catch (IOException e) 
        {
            System.out.println("The image " + imageName + " couldn't be loaded.");
        }
        return img;
    }
    
    public static ArrayList<Card> loadCardPool(String fileName)
    {
        ArrayList<Card> pool = new ArrayList<>();
        String cardPoolString = new String();
        String delimiter = "[,]+";  
        BufferedImage tempImage = null;
        try 
        {
            Scanner in = new Scanner(new FileReader("components/"+fileName+".txt"));
            while(in.hasNext())
            {
                cardPoolString+= in.next();
            }
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Card pool file not found.");
        }
        tempImage = loadImage("CardPool");
        
        String[] tokens = cardPoolString.split(delimiter);  
        Card temp = new Card();
        int cardNbr = -1;
        int toInt;    
        int floorInt = -1;
        for (int i = 0; i < tokens.length; i++)
        {
            switch(i%4)
            {
                case 0: if(cardNbr != -1)
                        {
                            pool.add(temp);
                        }
                        temp = new Card();
                        cardNbr++;
                        if(cardNbr%10 == 0)floorInt++;
                        temp.name = tokens[i];
                        break;
                case 1: toInt = Integer.parseInt(tokens[i]);
                        temp.id = toInt;                 
                        temp.image = tempImage.getSubimage(((toInt-1)%10)*100, floorInt*150, 100, 150);
                        break;
                case 2: toInt = Integer.parseInt(tokens[i]);
                        temp.cost = toInt;
                        break;
                case 3: toInt = Integer.parseInt(tokens[i]); 
                        temp.type = toInt;
                        break;
            }
        }
        pool.add(temp);
        return pool;
    } 

    public static void readCardPool(ArrayList<Card> cardPool)
    {
        for (int i=0;i<cardPool.size();i++)
        {
            System.out.println("Card Name: " + cardPool.get(i).name); 
            System.out.println("Card ID: " + cardPool.get(i).id); 
            System.out.println("Card Cost: " + cardPool.get(i).cost); 
            System.out.println("Card Type: " + cardPool.get(i).type);         
        }
    }
}
