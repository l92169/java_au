class Solution {
    public Integer get_first_nonnegative(int[] nums){
        for (int i = 0; i < nums.length;i++){
            if (nums[i] >= 0){
                return i;
            }
        }
        return -1;
    }
    public int[] sortedSquares(int[] nums) {
        Integer ind = get_first_nonnegative(nums);
        if (ind == -1) {
            int[] A = new int[nums.length];
            Integer count = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                A[i] = nums[count] * nums[count];
                count += 1;
            }
            return A;
        }
        else if (ind == 0) {
            int[] A = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                A[i] = nums[i] * nums[i];
            }
            return A;
        }
        else {
            Integer left = ind - 1, right = ind;
            Integer length = nums.length;
            int[] res = new int[nums.length];
            Integer i = 0;
            while (right < length && left >= 0) {
                if (nums[left] * nums[left] < nums[right] * nums[right]) {
                    res[i] = (nums[left] * nums[left]);
                    left -= 1;
                    i++;
                } else {
                    res[i] = (nums[right] * nums[right]);
                    right += 1;
                    i++;
                }
            }
            while (left >= 0) {
                res[i] = (nums[left] * nums[left]);
                left -= 1;
                i++;
            }
            while (right < length) {
                res[i] = (nums[right] * nums[right]);
                right += 1;
                i++;
            }
            return res;
        }
    }
}