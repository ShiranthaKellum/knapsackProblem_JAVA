import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class knapsackProblem {
    public static void minimumPrice(ArrayList <Integer> x, ArrayList<Integer> y, ArrayList<Integer> z) {
        ArrayList <Integer> unitPrice = new ArrayList<Integer> ();                  // # list for the unit price in each container
        for (int i = 0; i < x.get(1); i++) {
            int unit = z.get(i) / y.get(i);                                         // price of a sack
            unitPrice.add(unit);    

        }
        Collections.sort(unitPrice);                                                // sort the unitprice list

        for (int i = 0; i < x.get(1); i++) {                                        // rearrange the number of sacks in oder to unit price 
            for (int j = 0; j < x.get(1); j++) {
                if (unitPrice.get(i) == z.get(j) / y.get(j)) {
                    Collections.swap(y, i, j);                                      // swap values of index number i & j                
                
                }
            }   
        }
        int minPrice = 0;                                                           // optimized price
        int sacks = 0;
        for (int i = 0; i < x.get(1); i++) {
            for (int j = 0; j < y.get(i); j++) {
                if (sacks < x.get(0)) {
                    minPrice += unitPrice.get(i);
                    sacks++;
                    
                }
            }
        }
        System.out.println(minPrice);
    
    }
    public static void main(String[] args) {
        ArrayList <Integer> sacksAndContainers = new ArrayList <Integer> ();        // list containing num. of sacks piyasena have and num. of containvers farmers have   

        ArrayList <Integer> sacksInContainer = new ArrayList<Integer> ();           // num.of sacks in each container

        ArrayList <Integer> containerPrice = new ArrayList<Integer> ();             // price of each container
        
        Scanner input = new Scanner (System.in);        

        for (int i = 0; i < 2; i++) {
            int a = input.nextInt();
            sacksAndContainers.add(a);

        }
        for (int i = 0; i < 3; i++) {
            int a = input.nextInt ();
            sacksInContainer.add(a);
            
        }
        for (int i = 0; i < 3; i++) {
            int a = input.nextInt();
            containerPrice.add(a);
        }
        input.close();

        minimumPrice (sacksAndContainers, sacksInContainer, containerPrice);

    }
}