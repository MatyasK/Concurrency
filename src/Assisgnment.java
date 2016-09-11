import javafx.collections.transformation.SortedList;

import java.util.ArrayList;

/**
 * Created by Matyas on 9/7/2016.
 */
public class Assisgnment {

    public static final int THRESHOLD = 1000;

    public static void main(String[] args) {

        for (int x = 0; x < 1; x++) {
            // Creating ArrayLists
            ArrayList<Integer> randomNumbers = new ArrayList<>();
//            ArrayList<Integer> firstHalf = new ArrayList<>();
//            ArrayList<Integer> secondHalf = new ArrayList<>();

            // How many elements to sort
            int amountOfNumbers = 25000;

            //Preset the arraylist size to avoid creating new arraylists
            randomNumbers.ensureCapacity(amountOfNumbers);
//            firstHalf.ensureCapacity(amountOfNumbers / 2 + 1);
//            secondHalf.ensureCapacity(amountOfNumbers / 2 + 1);

            // Creating the random numbers
            for (int i = 0; i < amountOfNumbers; i++) {
                randomNumbers.add((int) (Math.random() * (7000) + 1));
            }

            // Dividing the Arraylist to parts
//            for (int i = 0; i < randomNR.size(); i++) {
//                if (i < (randomNR.size() / 2)) {
//                    firstHalf.add(randomNR.get(i));
//                } else {
//                    secondHalf.add(randomNR.get(i));
//                }
//            }

//            for (Integer integer : firstHalf) {
//                System.out.println(integer);
//            }
            // Get the current systemTime for measurement
            long startTime = System.currentTimeMillis();

            //Creating new Sortes and Threads
            BubbleSorter b1 = new BubbleSorter();
//            BubbleSorter b2 = new BubbleSorter();
            Adder a1 = new Adder(b1, randomNumbers);
//            Adder a2 = new Adder(b2, secondHalf);
            Thread t1 = new Thread(a1);
//            Thread t2 = new Thread(a2);

            // Start Threads
            t1.start();
//            t2.start();

            // Wait for them to finish
            try {
                t1.join();
//                t2.join();
            } catch (InterruptedException e) {
            }

            ArrayList<Integer> sortedList = a1.getList();
            System.out.println("List Size" + sortedList.size());
            for (Integer integer : sortedList) {
                System.out.println(integer);
            }

//            int i = 0;
//            int j = 0;
//            while (i < firstHalf.size() && j < secondHalf.size()) {
//                if (firstHalf.get(i) < secondHalf.get(j)) {
//                    sortedList.add(firstHalf.get(i));
//                    i++;
//                } else {
//                    sortedList.add(secondHalf.get(j));
//                    j++;
//                }
//            }
//            while (i < firstHalf.size()) {
//                sortedList.add(firstHalf.get(i));
//                i++;
//            }
//            while (j < secondHalf.size()) {
//                sortedList.add(secondHalf.get(j));
//                j++;
//            }

            long endTime = System.currentTimeMillis();
            long elapsedTime = (endTime - startTime);

            System.out.println("time " + (x+1) + ": "+ elapsedTime);
        }
    }


   


}
