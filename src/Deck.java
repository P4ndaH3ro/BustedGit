/**
 *@author Antony Martel
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Deck 
{  
    static ArrayList<Card> deckList;
    
    public Deck(String deckName, ArrayList<Card> cardPool)
    {
        deckList = new ArrayList<>();
        String deckString = new String();
        String delimiter = "[,]+"; 
        try 
        {
            Scanner in = new Scanner(new FileReader("components/"+deckName+".txt"));
            while(in.hasNext())
            {
                deckString += in.next();
            }
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Deck file not found.");
        }
        
        String[] tokens = deckString.split(delimiter);
        int toInt;
        for (int i = 0; i < tokens.length; i++)
        {
            toInt = Integer.parseInt(tokens[i]);
            deckList.add(cardPool.get(toInt-1));
        }     
    }
}
