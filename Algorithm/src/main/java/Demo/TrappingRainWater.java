package Demo;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {

    }

    public int process(int[] height){
        int size=height.length;
        if (size<2){
            return 0;
        }
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int index = 1; index <size ; index++) {
            int stackTop=stack.peek();
            if (height[index]<height[stackTop]){
                stack.push(index);
            }else if (height[index]==height[stackTop]){
                stack.pop();
                stack.push(index);
            }else {
                int right=height[index];
                while (!stack.isEmpty() && right > height[stackTop]){
                    int mid=stack.pop();
                    int left=stack.peek();
                    int h=Math.min(left,height[index]);
                    int w=index-left-1;
                }
            }
        }
        return 0;
    }
}
