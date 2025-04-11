class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0 || s == null) {
            return 0;
        }
        char sign = '+';
        if (s.charAt(0) == '-') {
            sign = '-';
        }
        int num=0;
        if (s.charAt(0) != '+' && s.charAt(0) != '-' && !Character.isDigit(s.charAt(0))) {
            return 0;
        }
        int limit = Integer.MAX_VALUE / 10;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                if (sign == '+') {
                    if ((num > limit) || ((num == limit) && c >= '7')) {
                        num = Integer.MAX_VALUE;
                        break;
                    }
                }  else {
                    if ((num > limit ) || ((num == limit ) && c >= '8')) {
                        num = Integer.MIN_VALUE;
                        break;
                    }
                }
                num = num *10 + c-'0';
            } else {
                if (i != 0) {
                    break;
                }
            }
        }
        if (sign == '+') {
            return num;
        } else {
            return -num;
        }
    }
}


class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, (log1, log2) -> {
            String[] strarray1 = log1.split(" ", 2);
            String[] strarray2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(strarray1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(strarray2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = strarray1[1].compareTo(strarray2[1]);
                if(cmp == 0) {
                    return strarray1[0].compareTo(strarray2[0]);
                } else {
                    return cmp;
                }
            } else if (!isDigit1 && isDigit2) {
                return -1;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else {
                return 0;
            }

        });
        return logs;
    }
}
