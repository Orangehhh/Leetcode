class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] arr = path.split(" ");
            String dir = arr[0];
            for (int i = 1; i < arr.length; i++) {
                String[] arr1 = (arr[i].substring(0, arr[i].length() - 1)).split("\\(");
                String filename = arr1[0];
                String content = arr1[1];
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(dir + "/" + filename);
            }    
        }
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                ans.add(list);
            }
        }
        return ans;
    }
}