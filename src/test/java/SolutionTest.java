import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    final Solution sol = new Solution();
    @Test
    void letterCombinationsExample1() {
        assertEquals(List.of("ad", "ae","af", "bd", "be", "bf", "cd", "ce", "cf"),sol.letterCombinations("23"));
    }
    @Test
    void letterCombinationsExample2() {
        assertEquals(List.of(),sol.letterCombinations(""));
    }
    @Test
    void letterCombinationsExample3() {
        assertEquals(List.of("a", "b", "c"),sol.letterCombinations("2"));
    }
}