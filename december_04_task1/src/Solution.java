import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Solution {

    public static void main(String[] args) {
        String[] output = new String[] {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(output,2));
        System.out.println(getWords("hellooo my nameeeee is Lisa"));
        System.out.println(getReversedWords("hello my name is Lisa"));
        System.out.println(getDistanceSorted(List.of(-1,-2,3,8,9), List.of(5,5,-5,7,-10)));
        List<Post> f = getTop10(List.of(new Post(1, 5, List.of("Hello","My name is Liza")),
                                        new Post(1, 2, List.of("Hello","My name is Liza","My name is Liza")),
                                        new Post(1, 2, List.of("Hello","My name is Liza","My name is Liza"))));
        System.out.println(getTop10(List.of(new Post(1, 5, List.of("Hello","My name is Liza")),
                new Post(1, 2, List.of("Hello","My name is Liza","My name is Liza")),
                new Post(1, 2, List.of("Hello","My name is Liza","My name is Liza")))));
    }

    public static List<String> getWords(String str) {
        return Stream.of(str.split(" ")).filter(line -> line.length() > 5).collect(Collectors.toList());
    }

    public static String getReversedWords(String str){
        return Stream.of(str.split(" ")).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
    }

    public static List<Map.Entry<Integer, Integer>> getDistanceSorted(List<Integer> x, List<Integer> y) {
        return IntStream.range(0, Math.min(x.size(), y.size()))
                .mapToObj(i -> Map.entry(x.get(i), y.get(i)))
                .filter(pair -> pair.getKey() < 0 && pair.getValue() > 0 || pair.getKey() > 0 && pair.getValue() < 0)
                .sorted((o1, o2)-> {
                    Integer dist1 = o1.getKey() * o1.getKey() + o1.getValue() * o1.getValue();
                    Integer dist2 = o2.getKey() * o2.getKey() + o2.getValue() * o2.getValue();
                    return dist1.compareTo(dist2);
                })
                .collect(Collectors.toList());
    }

    public static List<Post> getTop10(List<Post> feed) {
        return feed.stream()
                .sorted((o1, o2) -> {
                    Integer rank1 = o1.getLikes() + o1.getComments().size();
                    Integer rank2 = o2.getLikes() + o2.getComments().size();
                    return rank1.compareTo(rank2);
                })
                .skip(feed.size() - 2)
                .collect(Collectors.toList());
    }
}