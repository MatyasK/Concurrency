import java.util.ArrayList;

/**
 * Created by Matyas on 9/8/2016.
 */
public class Adder implements Runnable {

    private BubbleSorter sorter;
    private ArrayList<Integer> list;

    public Adder(BubbleSorter bubbleSorter, ArrayList<Integer> list){
        sorter = bubbleSorter;
        this.list  = list;
    }




    @Override
    public void run() {

        if (list.size() >= Assignment.THRESHOLD) {
            ArrayList<Integer> firstHalf = new ArrayList<>();
            ArrayList<Integer> secondHalf = new ArrayList<>();
            // Divide
            for (int i = 0; i < list.size(); i++) {
                if (i < (list.size() / 2)) {
                    firstHalf.add(list.get(i));
                } else {
                    secondHalf.add(list.get(i));
                }
            }

            Adder a1 = new Adder(sorter, firstHalf);
            Adder a2 = new Adder(sorter, secondHalf);
            Thread t1 = new Thread(a1);
            Thread t2 = new Thread(a2);

            // Start Threads
            t1.start();
            t2.start();

            // Wait for them to finish
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            firstHalf = a1.getList();
            secondHalf = a2.getList();

            ArrayList<Integer> sortedList = new ArrayList<>();
            int i = 0;
            int j = 0;
            while (i < firstHalf.size() && j < secondHalf.size()) {
                if (firstHalf.get(i) < secondHalf.get(j)) {
                    sortedList.add(firstHalf.get(i));
                    i++;
                } else {
                    sortedList.add(secondHalf.get(j));
                    j++;
                }
            }
            while (i < firstHalf.size()) {
                sortedList.add(firstHalf.get(i));
                i++;
            }
            while (j < secondHalf.size()) {
                sortedList.add(secondHalf.get(j));
                j++;
            }
            this.list = sortedList;
        } else {
            sorter.sort(list);
            this.list = sorter.getList();
            }
        }

    public ArrayList<Integer> getList(){
        return list;
    }
    }


