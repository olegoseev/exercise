package parentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	
	public boolean isValid(String s) {
		
		int len = s.length();
		Stack<Character> q = new Stack<>();
		
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			
			if (c == '(' || c == '{' || c == '[') {
				q.push(c);
			} else {
				char c1 = q.pop();
				
				switch(c) {
					case ')':
						if (c1 != '(') return false;
						break;
					case ']':
						if (c1 != '[') return false;
						break;
					case '}':
						if (c1 != '{') return false;
						break;
					default:
						return false;
				}
			}
		}
		
		return true;
	}

  // Hash table that takes care of the mappings.
  private HashMap<Character, Character> mappings;

  // Initialize hash map with mappings. This simply makes the code easier to read.
  public ValidParentheses() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  public boolean isValid2(String s) {

    // Initialize a stack to be used in the algorithm.
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // If the current character is a closing bracket.
      if (this.mappings.containsKey(c)) {

        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
        char topElement = stack.empty() ? '#' : stack.pop();

        // If the mapping for this bracket doesn't match the stack's top element, return false.
        if (topElement != this.mappings.get(c)) {
          return false;
        }
      } else {
        // If it was an opening bracket, push to the stack.
        stack.push(c);
      }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		ValidParentheses vp = new ValidParentheses();
		
		while ((s = in.readLine()) != null) {
			System.out.println("Are parentheses valid: " + vp.isValid(s));
		}
	}

}
