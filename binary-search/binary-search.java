public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.search(new int[]{-1,0,3,5,9,12}, 9));
    }
}

class Solution {
    private int target;
    private int[] numbers;
    public int search(int[] nums, int target) {
        this.target = target;
        this.numbers = nums;

        return getIt(0, this.numbers.length - 1);
    }

    public int getIt(int startIndex, int endIndex) {

        if(startIndex > endIndex) return -1;

        int midIndex = getMidIndex(startIndex, endIndex);
        int mid = this.numbers[midIndex];

        if(isTarget(mid)) {
            return midIndex;
        }else if(this.target > mid){
            return getIt(++midIndex, endIndex);
        }

        return getIt(startIndex, --midIndex);
    }

    private int getMidIndex(int startIndex, int endIndex) {
        return startIndex + (endIndex - startIndex) / 2;
    }

    private boolean isTarget(int value) {
        return this.target == value;
    }
}
