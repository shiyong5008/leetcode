class Solution {
    public static int myAtoi(String s) {
        int o = 0;
        long res = 0;
        int f = 0;
        int pn = 1;
        int flagSign = 1;
        int flagSpace = 1;
        int i=0;
        while(i<s.length()) {
            int k = Integer.valueOf(s.charAt(i));
            // int kn= Integer.valueOf(s.charAt(i+1));
            if(k==32 && flagSpace==1) {
                i++;
            // } else if(k==43 && kn>=48 && kn<=57 && flag ==1) {
            } else if(k==43 && flagSign ==1) {
                pn = 1;
                flagSign = 0;
                flagSpace = 0;
                i++;
            // } else if(k==45 && kn>=48 && kn<=57 && flag ==1) {
            } else if(k==45 && flagSign ==1) {
                pn = 0;
                flagSign = 0;
                flagSpace = 0;
                i++;
            } else if(k>=48 && k<=57) {
                o=s.charAt(i)-'0';

                if(pn==1 && (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && o>Integer.MAX_VALUE%10))){
                    return Integer.MAX_VALUE;
                }

                if(pn==0 && (-res < Integer.MIN_VALUE/10 || (-res == Integer.MIN_VALUE/10 && -o<Integer.MIN_VALUE%10))){
                    return Integer.MIN_VALUE;
                }
                res=res*10+o;
                i++;
                flagSign = 0;
                flagSpace = 0;
            } else {
                break;
            }
        }

        if(pn==1) {
            res = res;
        } else if(pn==0) {
            res = - res;
        }

        f= (int) res;
        return f;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("000-123x"));
        System.out.println(myAtoi("   4 6-123x"));
        System.out.println(myAtoi("   -0123x123"));
        System.out.println(myAtoi("   +123x"));
        System.out.println(myAtoi("-123x"));
        System.out.println(myAtoi("+123x"));
        System.out.println(myAtoi(" 123x"));
        System.out.println(myAtoi("w123x"));
        System.out.println(myAtoi("   --123x"));
        System.out.println(myAtoi("   ++123x"));
        System.out.println(myAtoi("091283472332"));
        System.out.println(myAtoi("-091283472332"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(Integer.MIN_VALUE%10);
    }

}

/*
?????????????????????
        ??????

        ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????

        ???????????????????????????????????????????????????????????????????????????????????????????????????????????????

        ????????????????????????????????????????????? s??????????????????????????????????????? c?????????????????? c ???????????????????????? s'??????????????????????????????????????????????????????????????? s ??? c ????????? s' ??????????????????????????????????????????

        ??????

        ????????????????????????????????????????????????



        ????????????????????????????????????????????????????????????

        ' '	+/-	number	other
        start	start	signed	in_number	end
        signed	end	end	in_number	end
        in_number	end	end	in_number	end
        end	end	end	end	end
        ????????????????????????????????????????????????????????????????????????????????????????????????????????????

        ????????????????????????????????????????????????????????????????????? s' ??? in_number ????????????????????????????????????????????????????????????????????????

        Python3C++Java

class Solution {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

?????????LeetCode-Solution
        ?????????https://leetcode-cn.com/problems/string-to-integer-atoi/solution/zi-fu-chuan-zhuan-huan-zheng-shu-atoi-by-leetcode-/
        ??????????????????LeetCode???
        ??????????????????????????????????????????????????????????????????????????????????????????????????????


 */