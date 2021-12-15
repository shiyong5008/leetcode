import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* fail for the test [0, 10001], do not know why...
class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int ls = s.length();
        int lp = p.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < lp; ++i) {
            char c = p.charAt(i);
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }

        List<Integer> list = new ArrayList<>();

        HashMap<Character, Integer> temp = new HashMap<>();
        int l = 0;
        while (l < ls-lp) {
            for (int j = l; j < l+lp; ++j) {
                char c = s.charAt(j);
                int count = temp.getOrDefault(c, 0) + 1;
                temp.put(c, count);
            }
            boolean flag = false;
            for (int k = l; k < l+lp; ++k) {
                if (temp.get(s.charAt(k)) == map.getOrDefault(s.charAt(k), -1)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                list. add(l);
            }
            temp.clear();
            ++l;

        }

        return list;

    }
}

 */


class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        int ls = s.length();
        int lp = p.length();
        if (ls < lp) return list;

        int[] st = new int[26];
        int[] pt = new int[26];

        for (int i = 0; i < lp; ++i) {
            ++pt[p.charAt(i) - 'a'];
            ++st[s.charAt(i) - 'a'];
        }
        if (Arrays.equals(st, pt)) list.add(0);

        for (int i = 0; i < ls - lp; ++i) {
            --st[s.charAt(i) - 'a'];
            ++st[s.charAt(i+lp) - 'a'];
            if (Arrays.equals(st, pt)) list.add(i+1);
        }

        return list;

    }
}
