package HomeWork__1.HomeWork5;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AppData {
    public static void main(String[] args) throws IOException {

        List<String[]> csvData = createCsvDataSimple();

        try (CSVWriter writer = new CSVWriter(new FileWriter("HomeWork5/test.csv"))) {
            writer.writeAll(csvData);
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("HomeWork5/test.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }
    private static List<String[]> createCsvDataSimple() {
        String[] header = {"Value 1", "Value 2", "Value 3", "Value 4"};
        String[] record1 = {"100", "200", "300", "400"};
        String[] record2 = {"5", "600", "700", "800"};

        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(record1);
        list.add(record2);

        return  list;
    }
}
