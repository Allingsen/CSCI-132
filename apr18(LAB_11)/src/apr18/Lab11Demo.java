package apr18;


import java.util.Stack;

public class Lab11Demo {


	public static String fix_string(String s) {
		//TO DO: Use recursion to solve this problem
		String newString = "";
		if (s.length() == 0) {
			newString = newString + "";
		}
		else {
			
			if (s.charAt(0) == 'c') {
				s = s.substring(1);
				newString = newString + "g" + fix_string(s);
				
			}
			else if (s.charAt(0) == 'g') {
				s = s.substring(1);
				newString = newString + "c" + fix_string(s);
			}
			else if (s.charAt(0) == 'a') {
				s = s.substring(1);
				newString = newString + "t" + fix_string(s);
			}
			else if (s.charAt(0) == 't') {
				s = s.substring(1);
				newString = newString + "a" + fix_string(s);
			}
			
		}
		return(newString);
	}
	
	public static void print_stack_reverse_recursive(Stack<String> stack) {
		//TO DO: Use recursion to solve this problem
        Stack<String> reverseStack = new Stack<String>();
        if (stack.empty()) {
            return;
        }
        else {
            String top = stack.pop();
            reverseStack.push(top);
            print_stack_reverse_recursive(stack);
        }
		if (reverseStack.empty()) {
			return;
		}
		else {
			String rev_top = reverseStack.pop();
			String fixed = fix_string(rev_top);
			System.out.println("Original String: " + rev_top);
			System.out.println("Fixed String: " + fixed);
			System.out.println("--------------------------------");
			print_stack_reverse_recursive(reverseStack);
		}

	}
	
	
	
	//You should NOT change anything below this comment
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("ctgtcctt");
		stack.push("agtgccct");
		stack.push("taacgcgg");
		stack.push("ccctcagt");
		stack.push("ggataata");
		stack.push("gtgaatgc");
			
		System.out.println("Printing out the stack in reverse order:");
		System.out.println();
		print_stack_reverse_recursive(stack);
	}

}
