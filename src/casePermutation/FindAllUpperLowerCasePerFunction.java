package casePermutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    
    // bfs is slower in this case, since we putting it inside a queue one by one
    public List<String> letterCasePermutationBFS(String S) {
        if(S.length() == 0 || S == null){
            return new ArrayList<>();
        }
        
        Queue<String> queue = new LinkedList<>();
        
        // add original input to queue
        queue.offer(S);
        
        for(int i = 0; i < S.length(); i++){
        	// Skip digits
            if(Character.isDigit(S.charAt(i))){
                continue;
            }
            
            // get queue size
            int size = queue.size();
            
            // queue size since one letter have two combinations
            for(int j = 0; j < size; j++){
                String current = queue.poll();
                
                char[] array = current.toCharArray();
                
                // array[i] what be current element we making upper and lower
                // turn to upper case
                array[i] = Character.toUpperCase(array[i]);
                queue.offer(String.valueOf(array));
                
                // turn to lower case
                array[i] = Character.toLowerCase(array[i]);
                queue.offer(String.valueOf(array));
            }
        }

        return new LinkedList<>(queue);
    }
}
