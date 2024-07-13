class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0 || s.length() == 1){
            return false;
        }
        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']'){
            return false;
        }
        Stack<Character> charStack = new Stack<>();
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                charStack.push(s.charAt(i));
            }
            else if(charStack.size()>0){
                if(s.charAt(i) == ')'){
                    if(charStack.peek() == '('){
                        charStack.pop();
                        continue;
                    }
                }

                if(s.charAt(i) == '}'){
                    if(charStack.peek() == '{'){
                        charStack.pop();
                        continue;
                    }
                }

                if(s.charAt(i) == ']'){
                    if(charStack.peek() == '['){
                        charStack.pop();
                        continue;
                    }
                }
                return false;
            }
            else
                return false;
        }
        if(charStack.size() == 0)
            return true;
        return false;
    }
}
