/*
 * @Author: Hao Liu
 * @Date: 2019-08-08 22:50:31
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-08 22:51:44
 * @Description: 48ms, 49.18%, Union Find + TreeSet
 */

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Map<String, Set<String>> group = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        // Store each email's owner
        // and mark each email's parent as itself 
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                owner.put(account.get(i), account.get(0));
                parent.put(account.get(i), account.get(i));
            }
        }
        
        // Union 
        for (List<String> account : accounts) {
            String r = findRoot(account.get(1), parent);
            for (int i = 1; i < account.size(); i++) {
                parent.put(findRoot(account.get(i), parent), r);
            }
        }
        
        // Create treesets with different connected components
        for (List<String> account : accounts) {
            String r = findRoot(account.get(1), parent);
            if (!group.containsKey(r)) {
                group.put(r, new TreeSet<>());
            }
            for (int i = 1; i < account.size(); i++) {
                group.get(r).add(account.get(i));
            }
        }
        
        // Convert treesets to arraylist
        for (String emailKey : group.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(owner.get(emailKey));
            for (String email : group.get(emailKey)) {
                list.add(email);
            }
            ans.add(list);
        }
        return ans;
    }
    
    private String findRoot(String a, Map<String, String> parent) {
        if (a.equals(parent.get(a))) {
            return a;
        }
        return findRoot(parent.get(a), parent);
    }
}