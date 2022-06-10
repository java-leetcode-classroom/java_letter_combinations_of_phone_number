# java_letter_combinations_of_phone_number

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in **any order**.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

![https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png](https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)

## Examples

**Example 1:**

```
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

```

**Example 2:**

```
Input: digits = ""
Output: []

```

**Example 3:**

```
Input: digits = "2"
Output: ["a","b","c"]

```

**Constraints:**

- `0 <= digits.length <= 4`
- `digits[i]` is a digit in the range `['2', '9']`.

## 解析

假設給一個數字對應到字元的方式，如同手機按鍵一樣

2 -> a, b, c
3 -> d, e, f

...

要求寫一個演算法來從給定的一個數字組成的字串找出所可能透過上面對應方式組出的字串

首先要能知道如何去做窮舉

一個可行的方式是把每個數字對應到一個字串 , 而該字串是由所有可能字元串接而成

這樣每次在於到該數字時，就可以透過字串位置來逐步找到該可能字元

然後把每個數字字元逐步找對應

方式如下

![](https://i.imgur.com/uiZEylz.png)

## 程式碼
```java
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


```

## 困難點

1. 需要找到窮舉的方式
2. 想到讓數字對應字元的資料結構
## Solve Point

- [x]  Understand what problem need to solve
- [x]  Analysis Complexity