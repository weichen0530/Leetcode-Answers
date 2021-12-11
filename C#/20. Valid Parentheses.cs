public bool IsValid(string s) {
	Stack<char> stack = new Stack<char>();
	foreach(char c in s){
		if(c == ']' || c== ')' || c=='}'){
			if(stack.Count() == 0) return false;
			if(c == ')' && stack.Peek() != '(') return false;
			if(c == ']' && stack.Peek() != '[') return false;
			if(c == '}' && stack.Peek() != '{') return false;
			stack.Pop();
		}else{
			stack.Push(c);
		}
	}
	if(stack.Count != 0) return false;
	return true;
}