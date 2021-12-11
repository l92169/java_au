# stream.md

+ [top-k-frequent-words](#top-k-frequent-words)

## top-k-frequent-words

https://leetcode.com/problems/top-k-frequent-words/

<details><summary>Test Cases</summary><blockquote>

``` java
import org.junit.jupiter.api.BeforeEach;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @org.junit.jupiter.api.Test
    void testTopKFrequent() {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        List<String> expected = List.of("i","love");
        assertEquals(expected, solution.topKFrequent(words, 2));
    }
}
```

</blockquote></details>

``` java
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
```