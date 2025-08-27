package proj4;

// Viktor Shkrivani
// CIS 2353
// Fall 2023
// Prof. John P. Baugh


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TriageSimulator simulator = new TriageSimulator();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/proj4/data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                simulator.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!simulator.isEmpty()) {
            String nextPatient = simulator.remove();
            System.out.println("Emergency help (based on priority): " + nextPatient);
        }
    }
}