class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        int prevIdx = -1;
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch))   return false;
            List<Integer> idxArr = map.get(ch);
            if (idxArr.get(idxArr.size() - 1) <= prevIdx)   return false;
            int idx = findPosition(idxArr, prevIdx);
            if (idx >= idxArr.size())   return false;
            prevIdx = idxArr.get(idx);
        }
        return true;
    }
    
    private int findPosition(List<Integer> idxArr, int prevIdx) {
        int l = 0;
        int r = idxArr.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (idxArr.get(mid) > prevIdx) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}