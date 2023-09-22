package program5;

import java.util.Arrays;
import java.util.ArrayList;

public class Program5Demo {

	public static void main(String[] args) {
		
		System.out.println("Part I: Palindromes");
		
		String test;
		boolean answer;
		
		test = "racecar";
		answer = is_palindrome(test);
		System.out.println("Word: " + test + ", Is palindrome: " + answer);

		test = "aa";
		answer = is_palindrome(test);
		System.out.println("Word: " + test + ", Is palindrome: " + answer);
		

		test = "computer";
		answer = is_palindrome(test);
		System.out.println("Word: " + test + ", Is palindrome: " + answer);
		
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Part II: Binary Search");
		int[] array = {2, 6, 12, 14, 17, 19, 20, 23, 27, 29, 32, 37, 40, 42, 45};
		int num, answer2;
		
		int low = 0;
		int high = array.length - 1;
		
		System.out.println(Arrays.toString(array));
		
		num = 12;
		answer2 = binary_search(array,num,low,high);
		System.out.println(num + " is located at index: " + answer2);
		
		num = 45;
		answer2 = binary_search(array,num,low,high);
		System.out.println(num + " is located at index: " + answer2);
		
		num = 29;
		answer2 = binary_search(array,num,low,high);
		System.out.println(num + " is located at index: " + answer2);
		
		num = 55;
		answer2 = binary_search(array,num,low,high);
		System.out.println(num + " is located at index: " + answer2);
		
		System.out.println("-----------------------------------------------------");
		System.out.println("Part III and IV: Finding minimum number of coins");
		int k; //target value
		int n; // answer for part III
		int[] D = {1, 5, 10, 18, 25};
		
		k = 37; //find minimum number of coins from D to make value K 
		n = min_coins(D, k);
		System.out.println("Minimum coins needed to create " + k + ": " + n);
		System.out.println("Coins used:");
		find_coins(D,k,n);
		
		k = 4; //find minimum number of coins from D to make value K 
		n = min_coins(D, k);
		System.out.println("Minimum coins needed to create " + k + ": " + n);
		System.out.println("Coins used:");
		find_coins(D,k,n);
		
		k = 19; //find minimum number of coins from D to make value K 
		n = min_coins(D, k);
		System.out.println("Minimum coins needed to create " + k + ": " + n);
		System.out.println("Coins used:");
		find_coins(D,k,n);
				
	}

	private static boolean is_palindrome(String test) {
		String first = test.substring(0, 1);
        String last = test.substring(test.length()-1, test.length());
        
        while (test.length() > 1) {
            if (first.equals(last)) {
                test = test.substring(1, test.length()-1);
                if (test.length() > 0) {
                    is_palindrome(test);
                }
                else {
                    return true;
                }  
            }
            else {
                return false;
            }
        }
		return true;
	}

	private static int binary_search(int[] array, int num, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (num == array[mid]) {
				return mid;
			}
			else if(num > array[mid]) {
				return binary_search(array, num, mid+1, high);
			}
			else {
				return binary_search(array, num, 0, mid-1);
			}
		}
		else {
			return -1;
		}
	}
    

	private static int min_coins(int[] d, int k) {
		if (k == 0) {
			return 0;
		}
		else {
			int min = Integer.MAX_VALUE;
			int a = Integer.MAX_VALUE;

			for (int i = 0; i < d.length; i++) {
				if (k - d[i] >= 0) {
					a = min_coins(d, k - d[i]);
				}
				if (a < min) {
					min = a;
				}
			}
			return 1 + min;
		}
	}
	
	private static void find_coins(int[] d, int k, int n) {
        
        int chosen[] = new int[n + 1];
 
        calculate_combinations(chosen, d, 0, n, 0, d.length - 1, k);
    }

    private static void calculate_combinations(int[] chosen, int[] arr, int index, int r, int start, int end, int target) {

        if (index == r) {
        		int counter = 0;
        		ArrayList<Integer> coins = new ArrayList<Integer>();
	            for (int i = 0; i < r; i++) {
	                counter += arr[chosen[i]];
	                coins.add(arr[chosen[i]]);
	            }
	            if(counter == target) {
	            	System.out.println(coins);
	            }
	            return;
        }
 
        for (int i = start; i <= end; i++) {
            chosen[index] = i;
            calculate_combinations(chosen, arr, index + 1, r, i, end, target);
        }
        return;   
    }
}

