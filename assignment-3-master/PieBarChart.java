package ah224uq_assign3;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PieBarChart {

	public static void main(String[] args) {
	

        if (args == null || args.length == 0) {
            System.out.println("Usage: $(basename ${0}) [FILE]");
            System.exit(1);
        }

        File file = openFile(args[0]);
        if (file != null) {
            int[] stats = calculateFileStatistics(file);
            displayHistogram(file.getName(), stats);
        }
    }

    /**
     * Displays a histogram of the frequency of numbers in a specified file.
     *
     * @param fileName The name of the file. Used for display only.
     * @param data     The frequency distribution as an integer array.
     */
    private static void displayHistogram(String fileName, int[] data)
    {
        // Create and Customize Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600)
                                                        .title("Histogram")
                                                        .xAxisTitle("Number")
                                                        .yAxisTitle("Frequency")
                                                        .build();
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(5);

        // Generate data
        ArrayList yData = new ArrayList();
        for (int i = 0; i < data.length; i++) {
            yData.add((double) data[i]);
        }

        // Hardcoded xData does the job but != pretty ..
        ArrayList<String> xData = new ArrayList<>(Arrays.asList(
                new String[]{"1-10", "11-20", "21-30", "31-40", "41-50",
                             "51-60", "61-70", "71-80", "81-90", "91-100"}));

        chart.addSeries("Number Frequency for file \"" + fileName + "\"",
                        xData, yData);

        // Display plot
        new SwingWrapper(chart).displayChart();
    }

    /**
     * Tries to a file at a specified path.
     *
     * @param path The path to the file.
     * @return A file if opening was successful, else null.
     */
    private static File openFile(String path)
    {
        File file = null;

        try {
            file = new File(path);
        } catch (Exception e) {
            System.out.printf("ERROR: %s%n", e.toString());
            System.exit(1);
        }

        return file;
    }

    /**
     * Calculates the distribution of numbers in a specified file.
     *
     * Based on code written for Lab #4 in the course 1DV506, 2017-01-07.
     * With the following modifications:
     *
     * * Modified to return suitable data type.
     * * Now accepts a file instead of a file path as String.
     * * Removed everything related to printing to stdout.
     * * Simplified dividing the numbers up into "buckets".
     *
     * @param file The file on which to calculate statistics.
     * @return The distribution frequency of numbers in the specified file.
     */
    private static int[] calculateFileStatistics(File file)
    {
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: %s%n", e.toString());
            System.exit(1);
        }

        int[] intervalNumberFrequency = new int[10];
        while (scan.hasNextLine()) {
            /* Match one or more digits, possibly preceded by a dash. */
            String digits = scan.findInLine("-?\\d+");
            if (digits == null) {
                scan.nextLine();
                continue;
            }

            try {
                int number = Integer.parseInt(digits);
                if (number >= 1 && number <= 100) {
                    int bucket = (number - 1) / 10;
                    intervalNumberFrequency[bucket]++;
                }
            } catch (NumberFormatException e) {
                System.out.printf("ERROR: %s%n", e.toString());
            }

            scan.nextLine();
        }
        scan.close();

        return intervalNumberFrequency;
	}

}
