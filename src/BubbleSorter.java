import java.util.ArrayList;

/**
 * Created by Matyas on 9/7/2016.
 */
public class BubbleSorter {
    private ArrayList<Integer> result = new ArrayList<>();


    public void sort(ArrayList<Integer> list) {

        int tempint;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    tempint = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, tempint);
                }
            }
        }
        this.result = list;
    }
    public ArrayList<Integer> getList(){
        if (result != null){
            return result;
        }else {
            return new ArrayList<>();
        }
    }
}
