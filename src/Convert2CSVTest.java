import statistics.GDAPerYear;
import util.Convert2CSV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convert2CSVTest {
    public static void main(String[] args) {
//        CSVConvertorFunctionalityTest();
//        GDAPerYearDataTest();
        GDAPerYearTest();
    }

    public static void CSVConvertorFunctionalityTest() {
        List<List<String>> lines = new ArrayList<>();
        List<String> line = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        List<String> anotherLine = new ArrayList<>(Arrays.asList("E", "F", "G", "H"));

        lines.add(line);
        lines.add(anotherLine);

        Convert2CSV.ConvertToCSV(lines, "csvTest.csv");
    }

    public static void GDAPerYearDataTest() {
        List<List<String>> lines = new GDAPerYear().GenresDistributionByYear();
        lines.forEach(System.out::println);
    }

    public static void GDAPerYearTest() {
        Convert2CSV.ConvertToCSV(new GDAPerYear().GenresDistributionByYear(), "gdaPerYear_test.csv");
    }
}
