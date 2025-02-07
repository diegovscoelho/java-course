import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\T-GAMER\\Desktop\\Codes\\Backend\\Sources\\votes.csv";

        Map<String, Integer> totalVotes = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while(line != null) {

                String[] fields = line.split(",");
                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                if (totalVotes.containsKey(name)) {
                    totalVotes.put(name, totalVotes.get(name) + votes);
                } else {
                    totalVotes.put(name, votes);
                }

                line = br.readLine();
            }

            totalVotes.forEach((name, votes) -> System.out.println(name + ": " + votes));

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}