import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        long startTime1 = System.nanoTime();
        runParallelStream();
        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;
        System.out.println("1: " + duration1);

        long startTime2 = System.nanoTime();
        runStream();
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        System.out.println("2: " + duration2);

        long startTime3 = System.nanoTime();
        runThread();
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;
        System.out.println("3: " + duration3);

        long startTime4 = System.nanoTime();
        runThreads();
        long endTime4 = System.nanoTime();
        long duration4 = endTime4 - startTime4;
        System.out.println("4: " + duration4);
    }

    public static void runParallelStream() {
        List<Harddrive> harddrivesList = CsvParser.parseCsv();
       List<Harddrive> dataSetList = harddrivesList.parallelStream().filter(harddrive -> harddrive.getModel().contains("Hitachi")).collect(Collectors.toList());
    }

    public static void runStream() {
        List<Harddrive> harddrivesList = CsvParser.parseCsv();
        List<Harddrive> dataSetList = harddrivesList.stream().filter(harddrive -> harddrive.getModel().contains("Hitachi")).collect(Collectors.toList());
    }

    public static void runThread() {
        List<Harddrive> harddrivesList = CsvParser.parseCsv();
        List<Harddrive> dataSetList = new ArrayList<>();
        Thread singleThread = new Thread() {
            @Override
            public void run() {
                for (Harddrive harddrive : harddrivesList) {
                   if (harddrive.getModel().contains("Hitachi")) {
                        dataSetList.add(harddrive);
                  }
                }
            }
        };
        singleThread.start();
    }

    public static void runThreads() {
        List<Harddrive> harddrivesList = CsvParser.parseCsv();
        Integer subCollectionsSize = harddrivesList.size() / 2;
        List<Harddrive> dataSetList = new ArrayList<>();

        Thread singleThread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < subCollectionsSize; i++) {
                    Harddrive listItem = harddrivesList.get(i);
                    if (listItem.getModel().contains("Hitachi")) {
                        dataSetList.add(listItem);
                    }
                }
            }
        };
        singleThread1.start();

        Thread singleThread2 = new Thread() {
            @Override
            public void run() {
                for (int i = subCollectionsSize; i < harddrivesList.size(); i++) {
                    Harddrive listItem = harddrivesList.get(i);
                    if (listItem.getModel().contains("Hitachi")) {
                        dataSetList.add(listItem);
                    }
                }
            }
        };
        singleThread2.start();
    }
}
