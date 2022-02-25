
public class Leetcode215 {
    public static int findKthLargest(int[] nums, int k) {
        mergesort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }

    public static void mergesort(int[] nums, int start, int end){
        int mid = (start+end)/2;
        if(start == end)
            return;
        mergesort(nums, start, mid);
        mergesort(nums, mid+1, end);

        merge(start, mid, end, nums);
    }

    public static void merge(int start, int mid, int end, int[] nums){
        int[] copy = new int[end-start+1];

        int i=start;
        int j=mid+1;
        for(int k=0; k< copy.length; k++){
            if(i<=mid && j<=end && nums[i]<=nums[j]) {
                copy[k] = nums[i];
                i++;
            } else if(i<=mid && j<=end && nums[j]<nums[i]) {
                copy[k] = nums[j];
                j++;
            } else if(i>mid){
                copy[k] = nums[j];
                j++;
            } else if(j>end){
                copy[k] = nums[i];
                i++;
            }
        }

        int index = start;
        for(int k=0; k<copy.length; k++){
            nums[index++] = copy[k];
        }
    }

    public static void main(String[] args) {
        int[] input = {2,4,7,2,8,5,8};
        System.out.println(findKthLargest(input, 2));
    }
}
