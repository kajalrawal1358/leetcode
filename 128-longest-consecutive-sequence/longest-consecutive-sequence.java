class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int len=1;
        int maxlen=1;
        Arrays.sort(nums);
        if(n==0){
            return 0;
        }
        for(int i=0;i<n-1;i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            if(nums[i]==nums[i+1]-1){
                len++;
                maxlen=Math.max(maxlen,len);
            }else {
                len=1;
            }
        }
        return maxlen;
    }
}