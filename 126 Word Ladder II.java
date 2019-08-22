/*
 * @Author: Hao Liu
 * @Date: 2019-08-21 21:05:58
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-21 21:06:16
 * @Description: BFS + DFS
 */

 class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }
        wordSet.remove(endWord);
        wordSet.remove(beginWord);
        Map<String, List<String>> children = new HashMap<>();
        Map<String, Integer> steps = new HashMap<>();
        steps.put(endWord, 0);
        Queue<String> q = new LinkedList<>();
        q.offer(endWord);
        boolean found = false;
        int step = 0;
        while (!q.isEmpty() && !found) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                for (int l = 0; l < str.length(); l++) {
                    char[] chArr = str.toCharArray();
                    char ch = chArr[l];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == ch)    continue;
                        chArr[l] = k;
                        String newStr = new String(chArr);
                        if (newStr.equals(beginWord)) {
                            found = true;
                            if (!children.containsKey(newStr)) {
                                children.put(newStr, new ArrayList<>());
                            }
                            children.get(newStr).add(str);
                        }
                        else {
                            if (steps.containsKey(newStr) && 
                                steps.get(newStr) == step) {
                                children.get(newStr).add(str);
                            }
                        }
                        if (!wordSet.contains(newStr)) {
                            continue;
                        }
                        if (!children.containsKey(newStr)) {
                            children.put(newStr, new ArrayList<>());
                        }
                        children.get(newStr).add(str);
                        q.offer(newStr);
                        steps.put(newStr, step);
                        wordSet.remove(newStr);
                    }
                    chArr[l] = ch;
                }
            }
        }    
        List<List<String>> ans = new ArrayList<>();
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            getPath(ans, path, children, beginWord, endWord);
        }
        return ans;
    }
    
    private void getPath(List<List<String>> ans, 
                         List<String> path,
                         Map<String, List<String>> children, 
                         String curWord, String endWord) {
        if (curWord.equals(endWord)) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (!children.containsKey(curWord)) return;
        for (String str : children.get(curWord)) {
            path.add(str);
            getPath(ans, path, children, str, endWord);
            path.remove(path.size() - 1);
        }
    }
}
