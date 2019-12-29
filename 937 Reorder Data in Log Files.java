class Solution {
    class Tuple implements Comparable<Tuple> {
        String identifier;
        String str;
        
        Tuple(String identifier, String str) {
            this.identifier = identifier;
            this.str = str;
        }
        
        @Override
        public int compareTo(Tuple t) {
            if (this.str.compareTo(t.str) == 0) {
                return this.identifier.compareTo(t.identifier);
            }
            return this.str.compareTo(t.str);
        }
    }
    
    public String[] reorderLogFiles(String[] logs) {
        List<String> ans = new ArrayList<>();
        PriorityQueue<Tuple> letterPq = new PriorityQueue<>();
        List<String> digitList = new ArrayList<>();
        for (String log : logs) {
            String[] words = log.split(" ");
            if (isDigit(words[1].charAt(0))) {
                digitList.add(log);
            }
            else {
                
                letterPq.offer(new Tuple(words[0], log.substring(words[0].length())));
            }
        }
        while (!letterPq.isEmpty()) {
            Tuple t = letterPq.poll();
            ans.add(t.identifier + t.str);
        }
        for (String s : digitList) {
            ans.add(s);
        }
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
    
    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}