
/**
 * A program that takes the input of students' marks and outputs the maximim and minimim score
 * Author: Chandima karunaratne
 */
import java.util.Scanner;
public class CalcuateStatistics
{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[30];
        int maxMark = 0;
        int minMark = 30;
        int total = 0;
        int counter = 0;
        String asstName;
        
        // getting the assignment name
        System.out.println("Enter the assignment name");
        asstName = scanner.nextLine();
        
        // loop to get the marks
        while(counter < 30) {
        System.out.println("Enter the mark for student " + (counter+1) + " or enter done if you are finished");
        String input = scanner.nextLine();
        
        // check if the user inputs "done"
        if(input.equalsIgnoreCase("done")) {
            break;
        }
        
        // convert the input to an integer
        int mark = -1;
        try {
            mark = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a number");
            continue;
        }
        
        // validate mark
        
        if (mark <0 || mark >30) {
            System.out.println("Error: please enter a mark between 0 and 30");
            continue;
        }
        
        // add marks to the array
        marks[counter] = mark;
        counter++;
        
        //update min and max marks
        if (mark > maxMark) {
            maxMark = mark;
        }
        
        if (mark < minMark) {
            minMark = mark;
        }
        
        // calculate total
        total += mark;
        
    }
    
        
        // calculate mean
        double mean;
        if (counter > 0) {
            mean = (double) total / counter;
        } else {
            mean = 0;
        }
        
        // calculate variance
        double variance = 0;
        for (int i=0; i<counter; i++) {
            variance += Math.pow(marks[i] - mean, 2);
        }
        variance /= counter - 1;
        
        // calculate standard deviation
        double standardDeviation = Math.sqrt(variance);
        
        // print the results
        System.out.println("Assignment name: " + asstName);
        System.out.println("Marks: ");
        for (int i=0; i<counter; i++) {
            System.out.println("Student " + (i +1 ) + ": " + marks[i]);
        }
        System.out.println("Maximum mark is " + maxMark);
        System.out.println("Minimum mark is " + minMark);
        System.out.println("The mean mark is " + mean);
        System.out.println("The standard deviation is " + standardDeviation);
        
        
        //close the scanner
        scanner.close();
    
    }
}
