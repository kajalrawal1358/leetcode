class Solution {
    public int findDuplicate(int[] nums) {
        int arr[] = new int[nums.length];

        for (int i : nums) {
            // If number already visited → duplicate found
            if (arr[i] != 0)
                return i;
            else
                arr[i]++;
        }

        // Default case (won’t occur as per constraints)
        return 0;
    }
}