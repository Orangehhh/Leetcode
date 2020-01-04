class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            char[] keyCharArr = new char[26];
            for (int i = 0; i < 26; i++) {
                keyCharArr[i] = (char) count[i];
            }
            String key = new String(keyCharArr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for (List<String> list : map.values()) {
            ans.add(list);
        }
        return ans;
    }
}