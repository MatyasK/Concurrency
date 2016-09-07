import java.util.ArrayList;

/**
 * Created by Matyas on 9/7/2016.
 */
public class Assisgnment {
    private ArrayList<Integer> randomNumbers = new ArrayList<>();

    public void run() {
            int amountOfNumbers = 100000;
            for (int i = 0; i < amountOfNumbers; i++) {
                randomNumbers.add((int) (Math.random() * (7000) + 1));
            }

            long startTime = System.currentTimeMillis();

            int tempint;
            int addInt;
            for (int i = 0; i < randomNumbers.size(); i++) {
                for (int j = 0; j < randomNumbers.size() - i - 1; j++) {
                    if (randomNumbers.get(j) > randomNumbers.get(j + 1)) {
                        tempint = randomNumbers.get(j + 1);
                        addInt = randomNumbers.get(j);
                        randomNumbers.set(j + 1, addInt);
                        randomNumbers.set(j, tempint);
                    }
                }
            }

            long stopTime = System.currentTimeMillis();
            long elapsedTime = (stopTime - startTime);
            System.out.println("Result of the:" + elapsedTime);
    }
    public void BubbleSort(){

    }


    public static void main(String[] args) {
        (new Assisgnment()).run();
    }
}
