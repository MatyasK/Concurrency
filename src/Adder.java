import java.util.ArrayList;

/**
 * Created by Matyas on 9/8/2016.
 */
public class Adder implements Runnable {

    private BubbleSorter sorter;
    private ArrayList<Integer> list;

    public Adder(BubbleSorter bubbleSorter, ArrayList<Integer> list){
        sorter = bubbleSorter;
       this.list  =list;
    }

    @Override
    public void run() {
        sorter.inputList(list);
        sorter.sort();
    }
}
