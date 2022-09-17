// Class:		Data structures Section 03
// Term:		Spring 2022
// Name:		Claudio Gutierrez
// Program Number:	Assignment Sorting
// IDE: 		Intelli J java13jdk
package AssignmentSorting;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadixSortClaudioGutierrez {

    public static void main(String args[]) {

        Scanner input= new Scanner(System.in);
        String menu= "";
        ArrayList<Integer> inputs= new ArrayList<>();
        do{
            System.out.println("How many integer numbers do you have?\n");
            int ints= input.nextInt();

            System.out.println("Enter " + ints +" integer numbers\n");

            for (int i= 0; i < ints; i++){

                int userin= input.nextInt();
                inputs.add(userin);
            }

            System.out.println("Inputs array before sorting(radix): " + inputs);

            System.out.println("Inputs array after sorting(radix): " + radixSort(inputs));

            System.out.println("Do you want to continue?");
            input.nextLine();
            menu= input.nextLine();


        }while (menu.contains("y"));


    }

    public static ArrayList radixSort(ArrayList<Integer> input) {
        int count = 0;

        int temp = 0;

        List<Queue<Integer>> queues = new ArrayList<Queue<Integer>>(10);

        for (int i = 0; i < 10; i++) {//populate array of queues
            queues.add(new Queue<Integer>());
        }

        int maxDigits = digitCount(input);//find largest digit for number of passes
        for (int i = 0; i < maxDigits; i++) {//pass to number of digits in the max number
            count = 0;


            for (int j = 0; j < input.size(); j++) {//traverse input array to get numbers in each index
                temp = extractDigit(input.get(j), i);//grab current digit
                queues.get(temp).enqueue(input.get(j));
            }

            for (int j = 0; j < 10; j++) {//go through queues and dequeue
                while (!queues.get(j).isEmpty()) {
                    input.set(count, queues.get(j).dequeue());
                    count++;
                }
            }
        }
        return input;


    }

    public static int extractDigit(int num, int exp) {

        int temp = exp;

        if (exp > 0) {
            num = (int) (num / (Math.pow(10, temp)));
        }
        return num % 10;
    }

    public static int digitCount(ArrayList<Integer> input) {
        int max = 0;
        int Count = 1;
        for (int i = 0; i < input.size(); i++) {

            if (max < input.get(i)) {
                max = input.get(i);
            }

        }
        while (max > 10) {
            max = max / 10;
            Count++;
        }
        return Count;
    }
}




