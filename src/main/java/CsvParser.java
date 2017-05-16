import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CsvParser {

    public static List<Harddrive> parseCsv() {
        String csvFile = "E:/Data/Java/Java Workspace/StreamsVsThreads/src/main/resources/harddrive.csv";
        String cvsSplitBy = ",";

        List<Harddrive> harddriveList = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             Scanner scanner = new Scanner(br)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String finalLine = line;
                executorService.submit(() -> {
                    String[] data = finalLine.split(cvsSplitBy);
                    Harddrive harddrive = new Harddrive();
                    harddrive.setDate(data[0]);
                    harddrive.setSerial_number(data[1]);
                    harddrive.setModel(data[2]);
                    harddrive.setCapacity_bytes(data[3]);
                    harddrive.setFailure(data[4]);
                    harddrive.setSmart_1_normalized(data[5]);
                    harddrive.setSmart_1_raw(data[6]);
                    harddrive.setSmart_2_normalized(data[7]);
                    harddrive.setSmart_2_raw(data[8]);
                    harddrive.setSmart_3_normalized(data[9]);
                    harddrive.setSmart_3_raw(data[10]);
                    harddrive.setSmart_4_normalized(data[11]);
                    harddrive.setSmart_4_raw(data[12]);
                    harddrive.setSmart_5_normalized(data[13]);
                    harddrive.setSmart_5_raw(data[14]);
                    harddrive.setSmart_7_normalized(data[15]);
                    harddrive.setSmart_7_raw(data[16]);
                    harddrive.setSmart_8_normalized(data[17]);
                    harddrive.setSmart_8_raw(data[18]);
                    harddrive.setSmart_9_normalized(data[19]);
                    harddrive.setSmart_9_raw(data[20]);
                    harddrive.setSmart_10_normalized(data[21]);
                    harddrive.setSmart_10_raw(data[22]);
                    harddrive.setSmart_11_normalized(data[23]);
                    harddrive.setSmart_11_raw(data[24]);
                    harddrive.setSmart_12_normalized(data[25]);
                    harddrive.setSmart_12_raw(data[26]);
                    harddrive.setSmart_13_normalized(data[27]);
                    harddrive.setSmart_13_raw(data[28]);
                    harddrive.setSmart_15_normalized(data[29]);
                    harddrive.setSmart_15_raw(data[30]);
                    harddrive.setSmart_22_normalized(data[31]);
                    harddrive.setSmart_22_raw(data[32]);
                    harddrive.setSmart_183_normalized(data[33]);
                    harddrive.setSmart_183_raw(data[34]);
                    harddrive.setSmart_184_normalized(data[35]);
                    harddrive.setSmart_184_raw(data[36]);
                    harddrive.setSmart_187_normalized(data[37]);
                    harddrive.setSmart_187_raw(data[38]);
                    harddrive.setSmart_188_normalized(data[39]);
                    harddrive.setSmart_188_raw(data[40]);
                    harddrive.setSmart_189_normalized(data[41]);
                    harddrive.setSmart_189_raw(data[42]);
                    harddrive.setSmart_190_normalized(data[43]);
                    harddrive.setSmart_190_raw(data[44]);
                    harddrive.setSmart_191_normalized(data[45]);
                    harddrive.setSmart_191_raw(data[46]);
                    harddrive.setSmart_192_normalized(data[47]);
                    harddrive.setSmart_192_raw(data[48]);
                    harddrive.setSmart_193_normalized(data[49]);
                    harddrive.setSmart_193_raw(data[50]);
                    harddrive.setSmart_194_normalized(data[51]);
                    harddrive.setSmart_194_raw(data[52]);
                    harddrive.setSmart_195_normalized(data[53]);
                    harddrive.setSmart_195_raw(data[54]);
                    harddrive.setSmart_196_normalized(data[55]);
                    harddrive.setSmart_196_raw(data[56]);
                    harddrive.setSmart_197_normalized(data[57]);
                    harddrive.setSmart_197_raw(data[58]);
                    harddrive.setSmart_198_normalized(data[59]);
                    harddrive.setSmart_198_raw(data[60]);
                    harddrive.setSmart_199_normalized(data[61]);
                    harddrive.setSmart_199_raw(data[62]);
                    harddrive.setSmart_200_normalized(data[63]);
                    harddrive.setSmart_200_raw(data[64]);
                    harddrive.setSmart_201_normalized(data[65]);
                    harddrive.setSmart_201_raw(data[66]);
                    harddrive.setSmart_220_normalized(data[67]);
                    harddrive.setSmart_220_raw(data[68]);
                    harddrive.setSmart_222_normalized(data[69]);
                    harddrive.setSmart_222_raw(data[70]);
                    harddrive.setSmart_223_normalized(data[71]);
                    harddrive.setSmart_223_raw(data[72]);
                    harddrive.setSmart_224_normalized(data[73]);
                    harddrive.setSmart_224_raw(data[74]);
                    harddrive.setSmart_225_normalized(data[75]);
                    harddrive.setSmart_225_raw(data[76]);
                    harddrive.setSmart_226_normalized(data[77]);
                    harddrive.setSmart_226_raw(data[78]);
                    harddrive.setSmart_240_normalized(data[79]);
                    harddrive.setSmart_240_raw(data[80]);
                    harddrive.setSmart_241_normalized(data[81]);
                    harddrive.setSmart_241_raw(data[82]);
                    harddrive.setSmart_242_normalized(data[83]);
                    harddrive.setSmart_242_raw(data[84]);
                    harddrive.setSmart_250_normalized(data[85]);
                    harddrive.setSmart_250_raw(data[86]);
                    harddrive.setSmart_251_normalized(data[87]);
                    harddrive.setSmart_251_raw(data[88]);
                    harddrive.setSmart_252_normalized(data[89]);
                    harddrive.setSmart_252_raw(data[90]);
                    harddrive.setSmart_254_normalized(data[91]);
                    harddrive.setSmart_254_raw(data[92]);
                    harddrive.setSmart_255_normalized(data[93]);
                    harddrive.setSmart_255_raw(data[94]);
                    harddriveList.add(harddrive);
                });
            }
            try {
                while (!executorService.isTerminated()) {
                    executorService.shutdown();
                }
            } finally {
                executorService.shutdown();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return harddriveList;
    }

}