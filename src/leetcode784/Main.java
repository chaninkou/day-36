package leetcode784;

public class Main {
	public static void main(String[] args) {
		String S = "a1b2";
		
		System.out.println("Input: " + S);
		
		FindAllUpperLowerCasePerFunction solution = new FindAllUpperLowerCasePerFunction();
		
		System.out.println("Solution: " + solution.letterCasePermutationBFS(S));
		
	}
}
