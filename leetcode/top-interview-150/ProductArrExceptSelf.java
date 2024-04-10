import java.util.Arrays;

public class ProductArrExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // ans[i] = pre[i] * suff[i]
        // pre[i] = pre[i-1] * nums[i-1]
        // suff[i] = suff[i+1] * nums[i+1]

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int current = 1;

        // prefix products
        for(int i=0; i<n; i++) {
            ans[i] *= current;
            current *= nums[i];
        }

        current = 1;

        // postfix products
        for(int i=n-1; i>=0; i--) {
            ans[i] *= current;
            current *= nums[i];
        }

        return ans;
    }
}
