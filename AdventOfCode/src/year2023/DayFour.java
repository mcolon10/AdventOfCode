
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author matt
 */
public class DayFour {
    
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("src/year2023/day_four.txt");
        Scanner inFile = new java.util.Scanner(file);
        HashMap<Integer,Integer> map = populateMap(file);
        int sum = 0;
        int cardVal = 0; // for part 2, number of copies = cardVal
        while(inFile.hasNext())
        {
            sum++; // original card
            String line = inFile.nextLine();
            String[] data = line.split(": ");
            int cardID = Integer.parseInt(data[0].replaceAll("[^0-9]", ""));
            String[] scores = data[1].split("[\\|]");
            String[] correctArr = scores[0].trim().split("\\s+");
            String[] totalArr = scores[1].trim().split("\\s+");
            cardVal = 0;
            for (int i = 0; i < totalArr.length; i++) 
            {
                int current = Integer.parseInt(totalArr[i]);

                for (int j = 0; j < correctArr.length; j++) 
                {
                    if(current == Integer.parseInt(correctArr[j]))
                    {
                        cardVal++;
                    }
                }
            }
            for (int i = 1; i <= cardVal; i++) {
                map.put(cardID + i, map.get(cardID + i) + 1 + (1 * map.get(cardID)));
            }
            sum += map.get(cardID);
            System.out.println("Card: " + cardID + " Copies: " + map.get(cardID));
        }
        System.out.println(sum);
    }
    
    public static HashMap<Integer, Integer> populateMap(File file) throws FileNotFoundException
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner inFile = new java.util.Scanner(file);
        while(inFile.hasNext())
        {
            String line = inFile.nextLine();
            String[] data = line.split(": ");
            int cardID = Integer.parseInt(data[0].replaceAll("[^0-9]", ""));
            map.put(cardID, 0);
        }
        return map;
    }
}
   
