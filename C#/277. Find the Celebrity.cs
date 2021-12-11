/* The Knows API is defined in the parent class Relation.
      bool Knows(int a, int b); */

public class Solution : Relation {
    public int FindCelebrity(int n) {
        Stack<int> stack = new Stack<int>();
        for(int i = n-1; i>=0; i--){
            stack.Push(i);
        }
        int celebrity = -1;
        while(stack.Count() != 0){
            int x = stack.Pop();
            if(stack.Count() == 0){
                celebrity = x;
                break;
            }
            int y = stack.Pop();
            if(Knows(x,y)){
                stack.Push(y);
            }else{
                stack.Push(x);
            }
        }
        for(int i = 0; i < n; i++){
            if(celebrity == i) continue;
            if(Knows(celebrity, i) || !Knows(i, celebrity)) return -1;
        }
        return celebrity;
    }
}