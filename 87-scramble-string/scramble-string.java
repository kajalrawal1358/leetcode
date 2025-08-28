class Solution {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if (len != s2.length()) {
            return false;
        }
        if (len == 0) {
            return true;
        } else if (len == 1) {
            return s1.equals(s2);
        } else {
            Map<String, Boolean> memo = new HashMap<>();
            return isScrambleHelper(memo, s1, s2);
        }
    }

    private boolean isScrambleHelper(Map<String, Boolean> memo, String s1, String s2) {
        int len = s1.length();
        boolean result = false;

        if (len == 0) {
            return true;
        } else if (len == 1) {
            return s1.equals(s2);
        } else {
            if (memo.containsKey(s1 + s2)) {
                return memo.get(s1 + s2);
            }

            if (s1.equals(s2)) {
                result = true;
            } else {
                for (int i = 1; i < len && !result; i++) {
                    result = (isScrambleHelper(memo, s1.substring(0, i), s2.substring(0, i)) && isScrambleHelper(memo, s1.substring(i), s2.substring(i))) ||
                             (isScrambleHelper(memo, s1.substring(0, i), s2.substring(len - i)) && isScrambleHelper(memo, s1.substring(i), s2.substring(0, len - i)));
                }
            }

            memo.put(s1 + s2, result);
            return result;
        }
    }
}