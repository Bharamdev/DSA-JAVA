class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){
                stack.push(asteroids[i]);
            }
            else{
                while(!stack.isEmpty() && stack.peek()>0 && Math.abs(asteroids[i])>stack.peek()){
                    stack.pop();
                }
                if(!stack.isEmpty() && Math.abs(asteroids[i])==stack.peek()){
                    stack.pop();
                }
                else if(stack.isEmpty() || stack.peek()<0){
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] arr = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            arr[i]=stack.pop();
        }
        return arr;
    }
}