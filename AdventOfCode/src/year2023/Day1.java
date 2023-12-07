package year2023;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day1 {
    
    static HashMap<Integer, String> map = new HashMap<>();
    
    public static void main(String[] args) throws FileNotFoundException
    {
        populateMap();
        File file = new File("src/year2023/day1_in.txt");
        Scanner inFile = new Scanner(file);
        
        int sum = 0;
        String number = "";
        ArrayList<Integer> nums = new ArrayList<>();
        String flow = "";
        
        while(inFile.hasNext())
        {
            String line = inFile.nextLine();
            String[] letters = line.split("");
            for (int i = 0; i < letters.length; i++) 
            {
                try
                {
                    int num = Integer.parseInt(letters[i]);
                    nums.add(num);
                    flow = "";
                }
                // FOR PART 1 SOLUTION, COMMENT OUT CATCH BODY
                catch (NumberFormatException exp) 
                {
                    flow += letters[i];
                    int x = checkMap(flow);
                    if(x != -1)
                    {
                        nums.add(x);
                        flow = flow.substring(flow.length() - 1);
                    }
                }
            }
            
            number += nums.get(0); number += nums.get(nums.size() - 1);
            sum += Integer.valueOf(number);
            
            number = "";
            nums.clear();
            flow = "";
        }
        System.out.println(sum);
    }
    
    public static int checkMap(String tempNum)
    {
        for (int i = 1; i < map.size() + 1; i++) 
        {
            if(tempNum.contains(map.get(i)))
            {
                return i;
            }
        }
        return -1;
    }
    
    public static void populateMap()
    {
        map.put(1, "one");
        map.put(2, "two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(5, "five");
        map.put(6,"six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
    }
}   