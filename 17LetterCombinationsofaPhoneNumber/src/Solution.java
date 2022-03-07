import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    List<String> lists = new ArrayList<>();
    HashMap<Character, String> map;

    public List<String> letterCombinations(String digits) {
         map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");

        if (digits.length() == 0) return lists;
        dfs(digits, 0, new StringBuffer());
        return lists;

    }

    public void dfs(String digits, int idx, StringBuffer list) {
        if (idx == digits.length()) {
            lists.add(list.toString());
            return;
        }
        char digit = digits.charAt(idx);
        String letters = map.get(digit);
        int count = letters.length();
        for (int i = 0; i < count; ++i) {
            list.append(letters.charAt(i));
            dfs(digits, idx + 1, list);
            list.deleteCharAt(idx);
        }
    }

}
