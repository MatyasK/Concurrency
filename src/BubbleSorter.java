import java.util.ArrayList;

/**
 * Created by Matyas on 9/7/2016.
 */
public class BubbleSorter {
    ArrayList<Integer> randomNumbers = new ArrayList<>();

    public void inputList(ArrayList listToSort){
        randomNumbers = listToSort;
    }


    public void sort() {
        int tempint;

        for (int i = 0; i < randomNumbers.size(); i++) {
            for (int j = 0; j < randomNumbers.size() - i - 1; j++) {
                if (randomNumbers.get(j) > randomNumbers.get(j + 1)) {
                    tempint = randomNumbers.get(j + 1);
                    randomNumbers.set(j + 1, randomNumbers.get(j));
                    randomNumbers.set(j, tempint);
                }
            }
        }
    }
}
