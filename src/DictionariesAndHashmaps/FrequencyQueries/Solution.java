package DictionariesAndHashmaps.FrequencyQueries;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> out = new ArrayList<>();
        Map<Integer, Integer> value = new HashMap<>();
        List<Integer> counts = new ArrayList<>();

        for (List<Integer> data : queries) {
            int num = data.get(1);
            int command = data.get(0);

            switch (command) {
                case 1:
                    if(value.containsKey(num)){
                        counts.remove(value.get(num));
                        value.put(num,value.get(num) + 1);
                    }else{
                        value.put(num,1);
                    }
                    counts.add(value.get(num));
                    break;
                case 2:
                    if (value.containsKey(num) && value.get(num) > 0) {
                        counts.remove(value.get(num));
                        value.put(num, value.get(num) - 1);
                        counts.add(value.get(num));
                    }
                    break;
                case 3:
                    out.add(counts.contains(num) ? 1 : 0);
                    break;
            }
        }

        return out;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
