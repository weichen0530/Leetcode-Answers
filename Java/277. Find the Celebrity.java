/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = n-1; i >=0; i--){
            stack.push(i);
        }
        int celebrity = -1;
        while(!stack.isEmpty()){
            int x = stack.pop();
            if(stack.isEmpty()){
                celebrity = x;
                break;
            }
            int y = stack.pop();
            if(knows(x,y)){
                stack.push(y);
            }else{
                stack.push(x);
            }
        }
        for(int i = 0; i < n; i++){
            if(i == celebrity) continue;
            if(knows(celebrity, i) || !knows(i,celebrity)) return -1;
        }
        return celebrity;
    }
}