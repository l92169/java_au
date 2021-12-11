import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @org.junit.jupiter.api.Test
    void getWords() {
        List<String> expected = List.of("hellooo", "nameeeee");
        List<String> result = solution.getWords("hellooo my nameeeee is Lisa");
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void getReversedWords() {
        String expected = "olleh ym eman si asiL";
        String result = solution.getReversedWords("hello my name is Lisa");
        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void getDistanceSorted() {
        List<Integer> x = List.of(1, -3, -2, 5, 3);
        List<Integer> y = List.of(3, 2, -1, -3, 6);
        List<Map.Entry<Integer, Integer>> expected = List.of(Map.entry(-3,2), Map.entry(5, -3));
        assertEquals(expected, solution.getDistanceSorted(x, y));
    }

    @Test
    void testGetTop10() {
        List<Post> feed = getFeed(10);
        List<Comment> comments = List.of(new Comment());
        List<Post> expected = List.of(
                new Post(2,8, comments),
                new Post(1,9, comments)
        );
        assertEquals(expected, solution.getTop10(feed));
    }

    List<Post> getFeed(int length) {
        List<Post> feed = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<Comment> comments = List.of(new Comment());
            Post post = new Post(length - i, i, comments);
            feed.add(post);
        }
        return feed;
    }
}