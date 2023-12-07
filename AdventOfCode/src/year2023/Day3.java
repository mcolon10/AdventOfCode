package year2023;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author matt
 *
 * STILL WORKING ON
 */
public class Day3 {

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("src/year2023/day3_in.txt");
        Scanner inFile = new java.util.Scanner(file);
        ArrayList<String> lineContent;
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        int rows = 0;

        
        while(inFile.hasNext())
        {
            String line = inFile.nextLine();
            String[] content = line.split("");
            lineContent = new ArrayList( Arrays.asList(content));
            rows++;
            map.put(rows, lineContent);
        }
        sum(map, rows);
    }    
    public static int sum(HashMap<Integer, ArrayList<String>> map, int rows)
    {
        int sum = 0;
        String num = "";
        boolean foundDigit = false;
        for (int i = 0; i < rows; i++) 
        {
            ArrayList<String> currentLine = map.get(i);
            for (int j = 0; j < currentLine.size(); j++) 
            {
                try
                {
                    int digit = Integer.parseInt(currentLine.get(i));
                    num += digit;
                    foundDigit = true;
                }
                catch(NumberFormatException e)
                {
                    if(foundDigit)
                    {
                        foundDigit = false;
                        if(checkAdj(num, i, j, map))
                            sum += Integer.valueOf(num);
                    }
                }
            }
        }
        return sum;
    }
    
    public static boolean checkAdj(String num, int i, int j, HashMap<Integer, ArrayList<String>> map)
    {
        // this should check digit of num + 2 area around current j index for rows i +- 1
        return true;
    }
}
