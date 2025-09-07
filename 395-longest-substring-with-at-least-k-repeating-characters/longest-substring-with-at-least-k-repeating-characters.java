class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for (int start = 0; start < n; start++) {
            int[] freq = new int[26];
            PriorityQueue<Integer> pq = new PriorityQueue<>(); 

            for (int end = start; end < n; end++) {
                char c = s.charAt(end);
                int idx = c - 'a';

                if (freq[idx] > 0) {
                    pq.remove(freq[idx]); 
                }
                freq[idx]++;
                pq.add(freq[idx]); 

                if (pq.peek() >= k) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }

        return maxLen;
    }
}