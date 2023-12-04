import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) throws FileNotFoundException
    {
        int MAX_RED = 12;
        int MAX_GREEN = 13;
        int MAX_BLUE = 14;
        int highestRed = 0;
        int highestGreen = 0;
        int highestBlue = 0;
        int sum = 0;
        boolean valid = false;
        File file = new File("src/2023/inputs/day_two.txt");
        Scanner inFile = new Scanner(file);
        ArrayList<String> match = new ArrayList<>();
        
        
        while(inFile.hasNext())
        {
            valid = false;
            String line = inFile.nextLine();
            String[] data = line.split(": ");
            
            int gameID = Integer.parseInt(data[0].replaceAll("[^0-9]", ""));
            String[] scores = data[1].split("; ");
            
            for(String score : scores)
            {
                String[] rounds = score.split(", ");
                for(String round : rounds)
                {
                    match.add(round.trim());
                }
                for (int i = 0; i < match.size(); i++) 
                {
                    if(match.get(i).contains("blue"))
                    {
                        int val = Integer.parseInt(match.get(i).replaceAll("[^0-9]", ""));
//                        valid = val <= MAX_BLUE;
//                        if(!valid)
//                            break;
                        if (highestBlue < val)
                        highestBlue = val;
                    }
                    else if(match.get(i).contains("green"))
                    {
                        int val = Integer.parseInt(match.get(i).replaceAll("[^0-9]", ""));
//                        valid = val <= MAX_GREEN;
//                        if(!valid)
//                            break;
                        if (highestGreen < val)
                        highestGreen = val;
                    }
                    else if(match.get(i).contains("red"))
                    {
                        int val = Integer.parseInt(match.get(i).replaceAll("[^0-9]", ""));
//                        valid = val <= MAX_RED;
//                        if(!valid)
//                            break;
                        if (highestRed < val)
                        highestRed = val;
                    }
                }

            }
//            if (valid)
//                sum += gameID;  

            int matchPower = (highestBlue * highestGreen * highestRed);
            sum += matchPower;
            match.clear();
            highestBlue = 0; highestRed = 0; highestGreen = 0;
        }
        System.out.println(sum);
    }
}