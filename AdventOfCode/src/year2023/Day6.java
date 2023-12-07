package year2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author matt
 */
public class Day6 {
    
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("src//year2023/day6_in.txt");
        Scanner inFile = new Scanner(file);
        
        String line = inFile.nextLine();
        String[] data =  line.split(":");
        String[] times = data[1].strip().split("\\s+");
        line = inFile.nextLine();
        data = line.split(":");
        String[] distances = data[1].strip().split("\\s+");
       
        partOne(times, distances);
        partTwo(times, distances);
    }
    
    public static void partOne(String[] times, String[] distances)
    {
        int instanceSolutions = 0;
        int product = 1;
        ArrayList<Integer> solutions = new ArrayList<>();
       
        for (int i = 0; i < distances.length; i++) {
            instanceSolutions = 0;
            int time = Integer.parseInt(times[i]);
            for (int j = 0; j < time; j++) 
            {
                int distance = j * (time - j);
                if (distance > Integer.valueOf(distances[i]))
                    instanceSolutions++;
            }
           solutions.add(instanceSolutions);
        }
        for (int i = 0; i < solutions.size(); i++) {
            product *= solutions.get(i);
        }
        System.out.println(product);
    }
    
    public static void partTwo(String[] times, String[] distances)
    {
        String timeStr = "";
        String distanceStr = "";
        int solutions = 0;
        for (int i = 0; i < distances.length; i++) {
            timeStr += times[i];
            distanceStr += distances[i];
        }
        double time = Double.valueOf(timeStr);
        double distance = Double.valueOf(distanceStr);
        for (int i = 0; i < time; i++) {
            double score = i * (time - i);
            if (score > distance)
                solutions++;
        }
        System.out.println(solutions);
    }
}
