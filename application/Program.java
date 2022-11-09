package exercicio3.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String path = sc.next();
        sc.close();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Map<String, Integer> votes = new LinkedHashMap<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Integer count = Integer.parseInt(fields[1]);

                if (votes.containsKey(name)) {
                    Integer sum = count + votes.get(name);
                    votes.put(name, sum);
                }
                else{
                    votes.put(name, count);
                }

                line = br.readLine();
            }

            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
