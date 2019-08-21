/*
 * @Author: Hao Liu
 * @Date: 2019-08-20 22:49:11
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-20 22:50:24
 * @Description: Bidirectional BFS, always expand the set with fewer elements
 */

 class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add(beginWord);
        set2.add(endWord);
        wordSet.remove(beginWord);
        wordSet.remove(endWord);
        
        int steps = 1;
        while (!set1.isEmpty()) {
            steps++;
            Set<String> tmp = new HashSet<>();
            for (String str : set1) {
                char[] chArr = str.toCharArray();
                for (int l = 0; l < str.length(); l++) {
                    char ch = chArr[l];
                    for (char k = 'a'; k < 'z'; k++) {
                        chArr[l] = k;
                        String newStr = new String(chArr);
                        if (set2.contains(newStr)) return steps; 
                        if (!wordSet.contains(newStr))  continue;
                        tmp.add(newStr);
                        wordSet.remove(newStr);
                    }
                    chArr[l] = ch;
                }
            }
            if (tmp.size() > set2.size()) {
                set1 = set2;
                set2 = tmp;
            }
            else {
                set1 = tmp;
            }
            
        }
        return 0;
    }
}
