//https://www.youtube.com/watch?v=6pIC20wCm20

class Solution {
    class Node{
        String word;
        int distance;
        public Node(String word, int distance){
            this.word = word;
            this.distance = distance;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        
        for(String word: wordList){
            set.add(word);
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(beginWord, 1));
        
        while(!queue.isEmpty()){
            Node current = queue.remove();
            HashSet<String> tempSet = new HashSet<String>(set);
            Iterator<String> iterator = tempSet.iterator();
            while(iterator.hasNext()){
                String w = iterator.next();
                if(isDistanceOne(current.word, w)){
                    queue.add(new Node(w, current.distance + 1));
                    set.remove(w);
                    if(w.equals(endWord)){
                        return current.distance + 1;
                    }
                }
                
            }
        }
        return 0;
    }
    
    public boolean isDistanceOne(String a, String b){
        //to check if they are neighbor
        
        int counter = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                counter++;
            }
            if(counter > 1)
                return false;
        }
        if(counter == 1)
            return true;
        return false;
    }
    

}
