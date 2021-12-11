import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        return Stream.of(words)
                .sorted()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(enumerate -> enumerate.getKey())
                .limit(k)
                .collect(Collectors.toList());
    }
}