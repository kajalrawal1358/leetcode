class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        int i = 0, j = 0, count_s2 = 0;
        while(n1 > 0) {
            if(ch1[i] == ch2[j]) {
                if(++j == ch2.length) { j = 0; count_s2++; }
            }

            if(++i == ch1.length) { i = 0; n1--; }
        }

        return count_s2 / n2;
    }
}
