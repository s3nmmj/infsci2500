import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListComparison {
    final static int NUMBER_OF_ENTRIES = 1000000;
    final static String ARRAY_LIST = "ArrayList";
    final static String LINKED_LIST = "LinkedList";

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        // add
        long startTime, endTime;
        startTime = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_ENTRIES; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        printRunTime(ARRAY_LIST, "add", endTime - startTime);
        startTime = System.nanoTime();
        for (int i = 0; i < NUMBER_OF_ENTRIES; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        printRunTime(LINKED_LIST, "add", endTime - startTime);

        // get
        startTime = System.nanoTime();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        printRunTime(ARRAY_LIST, "get", endTime - startTime);
        startTime = System.nanoTime();
        for (Integer integer : linkedList) {
        }

        endTime = System.nanoTime();
        printRunTime(LINKED_LIST, "get", endTime - startTime);

        // delete
        startTime = System.nanoTime();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        // System.out.println("arrayList size: " + arrayList.size());
        endTime = System.nanoTime();
        printRunTime(ARRAY_LIST, "delete", endTime - startTime);
        startTime = System.nanoTime();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        // System.out.println("linkedList size: " + linkedList.size());

        endTime = System.nanoTime();
        printRunTime(LINKED_LIST, "delete", endTime - startTime);
    }

    public static void printRunTime(String listType, String action, long elapsedTime) {
        System.out.printf("%s %s: %f sec\n", listType, action, (double) elapsedTime / 1_000_000_000);
    }
}