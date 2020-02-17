package casePermutation;

import java.util.ArrayList;
import java.util.List;

public class FindAllUpperLowerCasePerFunction {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        
        if(S.length() == 0 || S == null){
            return result;
        }
        
        // Start from index 0
        dfs(S.toCharArray(), result, 0);
        
        return result;
    }
    
    // Dfs, we reach to the end of the tree, then go back to previous
    private void dfs(char[] nums, List<String> result, int position){
        // Base case, if position reach to end of nums index
        if(position == nums.length){
            result.add(new String(nums));
            return;
        }
        
        // If its digits, just call the dfs 
        // Could also be nums[pos] >= '0' && nums[pos] <= '9'
        if(Character.isDigit(nums[position])){
            dfs(nums, result, position + 1);
            return;
        }
        
        // Do the lowercase one first
        nums[position] = Character.toLowerCase(nums[position]);
        
        dfs(nums, result, position + 1);
        
        // Then do the uppercase after
        nums[position] = Character.toUpperCase(nums[position]);
        
        dfs(nums, result, position + 1);
        
    }
}
