class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] arr = s.toCharArray();
        char[] array = t.toCharArray();
        int i = 0;

        // Traverse through t and match characters with s
        for (int j = 0; j < array.length && i < arr.length; j++) {
            if (arr[i] == array[j]) {
                i++; // Move pointer in s
            }
        }
        return i == arr.length; // True if all chars of s matched
    }
}