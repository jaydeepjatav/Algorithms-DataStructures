# Backtracking Algorithms 
Backtracking is an algorithmic technique that systematically searches for solutions by exploring all possible candidates and abandoning paths that fail to satisfy constraints. It builds solutions incrementally and removes candidates that cannot lead to valid solutions.

#### When to Use Backtracking
1. Finding all possible solutions or configurations
2. Constraint satisfaction problems
3. Combinatorial optimization problems
4. Problems requiring exhaustive search with pruning

### Core Concepts
The Backtracking Template<br>
```java
java public class BacktrackingTemplate {
    public void backtrack(State state, List<Choice> choices, Constraints constraints) {
        if (isSolution(state)) {
            processSolution(state);
            return;
        }
        
        for (Choice choice : choices) {
            if (isValid(choice, state, constraints)) {
                makeChoice(state, choice);
                backtrack(state, choices, constraints);
                undoChoice(state, choice);  // Backtrack
            }
        }
    }
}
```
### Problem Categories
1. Permutations and Combinations
Problems:<br>
* Generate all permutations<br>
* Generate all combinations<br>
* Combination sum<br>
* Letter combinations of a phone number<br>

Example: Permutations

```java
  java public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> path, 
                          int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            // Make choice
            path.add(nums[i]);
            used[i] = true;
            
            backtrack(result, path, nums, used);
            
            // Undo choice
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
```

2. Subset Problems<br>
* All subsets (power set)<br>
* Subset sum<br>
* Partition to k equal sum subsets<br>

Example: Subsets
```java
javapublic class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> path, 
                          int[] nums, int start) {
        result.add(new ArrayList<>(path));
        
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(result, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
```

3. Grid-Based Problems
* N-Queens<br>
* Sudoku solver<br>
* Word search<br>
* Rat in a maze<br>

Example: N-Queens
```java
javapublic class NQueens {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();  // row - col
        Set<Integer> diag2 = new HashSet<>();  // row + col
        
        backtrack(result, board, 0, cols, diag1, diag2);
        return result;
    }
    
    private void backtrack(List<List<String>> result, char[][] board, int row,
                          Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || 
                diag2.contains(row + col)) {
                continue;
            }
            
            // Make choice
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);
            
            backtrack(result, board, row + 1, cols, diag1, diag2);
            
            // Undo choice
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}
```

4. String Problems
* Generate parentheses<br>
* Palindrome partitioning<br>
* Word break II<br>
* Restore IP addresses<br>

Example: Generate Parentheses
```java
javapublic class GenerateParentheses {
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder current, 
                          int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
```
5. Graph Problems
* All paths from source to target<br>
* Word ladder II<br>
* Hamiltonian path<br>
* Graph coloring<br>

Example: All Paths Source to Target
```java
javapublic class AllPaths {
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(result, path, graph, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> path,
                          int[][] graph, int node) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            backtrack(result, path, graph, nextNode);
            path.remove(path.size() - 1);
        }
    }
}
```
### Problems by Difficulty
#### Easy<br>
  1.Subsets<br>
  2.Combination Sum<br>
  3.Letter Combinations<br>
  4.Generate Parentheses<br>

#### Medium<br>
  5.Permutations<br>
  6.Permutations II<br>
  7.Combination Sum II<br>
  8.Word Search<br>
  9.Palindrome Partitioning<br>
  10.Restore IP Addresses<br>

#### Hard<br>
  11.N-Queens<br>
  12.Sudoku Solver<br>
  13.Word Search II<br>
  14.Regular Expression Matching<br>
  15.Wildcard Matching<br>

### Time Complexity Analysis

| Problem Type | Time Complexity |Space Complexity |
|--------------|-----------------|-----------------|
|Permutations |O(n! × n) |O(n) |
|Combinations |O(2^n × n) |O(n) |
|Subsets |O(2^n × n) |O(n) |
| N-Queens |O(n!)| O(n²) |
| Sudoku |O(9^(n×n)) |O(n²) |
