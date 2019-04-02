//build the Trie with every given words
//run dfs for every cell and check if the recursive dfs leads to any word in the Trie

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if(words.length == 0 || board.length == 0){
            return result;
        }
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, int row, int col, TrieNode node, List<String> result){
        //only valid index will be called, so no needs to check
        //check if already visited for this round
        char c = board[row][col];
        int index = c - 'a';
        if(c == '*' || node.children[index] == null){
            return;
        }
        
        board[row][col] = '*';
        node = node.children[index];
        
        if(node.word != null){
            result.add(node.word);
            node.word = null; //to avoid duplicacy
        }
        
        if(row-1 >= 0) dfs(board, row-1, col, node, result);
        if(row+1 < board.length) dfs(board, row+1, col, node, result);
        if(col-1 >= 0) dfs(board, row, col-1, node, result);
        if(col+1 < board[0].length) dfs(board, row, col+1, node, result);
        board[row][col] = c;
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode n = root;
            for(char c : word.toCharArray()){
                int i = c - 'a';
                if(n.children[i] == null){
                    n.children[i] = new TrieNode();
                }
                n = n.children[i];
            }
            n.word = word;
        }
        return root;
    }
    
    class TrieNode{
        String word;
        TrieNode[] children = new TrieNode[26];
    }
}
