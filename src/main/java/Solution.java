import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    static HashMap<Character, String> digitMap = new HashMap<>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        int sLen = digits.length();
        if (sLen == 0) {
            return result;
        }
        StringBuffer sb = new StringBuffer();
        dfs(digits, 0, sb, result);
        return result;
    }
    public static void dfs(String digits,int i, StringBuffer cur, List<String> result) {
        int sLen = digits.length();
        if (i == sLen) {
            result.add(cur.toString());
            return;
        }
        String search = digitMap.get(digits.charAt(i));
        sLen = search.length();
        for (int idx = 0 ;idx < sLen; idx++) {
            cur.append(search.charAt(idx));
            dfs(digits,i+1, cur, result);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
