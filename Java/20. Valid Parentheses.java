public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for(int i = 0; i < s.length(); i++){
		if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
			if(stack.isEmpty()) return false;
			if(s.charAt(i) == ')' && stack.peek() != '(') return false;
			if(s.charAt(i) == ']' && stack.peek() != '[') return false;
			if(s.charAt(i) == '}' && stack.peek() != '{') return false;
			stack.pop();
		}else{
			stack.push(s.charAt(i));
		}
	}
	if(stack.isEmpty()) return true;
	return false;
}