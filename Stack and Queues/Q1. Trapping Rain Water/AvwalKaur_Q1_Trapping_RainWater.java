public class AvwalKaur_Q1_Trapping_RainWater {
    // Using prefix concept
    public int trap(int[] height) {
        int n=height.length;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        leftMax[0]=height[0];
        rightMax[n-1]=height[n-1];
        for(int i=1;i<n;i++) leftMax[i]=Math.max(height[i], leftMax[i-1]);
        for(int i=n-2;i>=0;i--) rightMax[i]=Math.max(height[i], rightMax[i+1]);
        int totalWater=0, width=1;
        for(int i=0;i<n;i++) {
            totalWater+=width*(Math.min(leftMax[i], rightMax[i])-height[i]);
        }
        return totalWater;
    }

    // Using Stacks
    public int trapII(int[] height) {
        int n = height.length;
        if (n == 0) return 0; 
        Stack<Integer> st = new Stack<>();
        int totalWater = 0;
    
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int top = stack.pop(); 
                if (st.isEmpty()) break; 
                int left = st.peek(); 
                int width = i - left - 1; 
                int boundedHeight = Math.min(height[i], height[left]) - height[top];
                totalWater += boundedHeight * width;
            }
            st.push(i); 
        }
        return totalWater;
    }
}
