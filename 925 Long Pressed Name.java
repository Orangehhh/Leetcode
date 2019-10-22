class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() == 0 || 
            typed == null || typed.length() == 0) return false;
        int j = 0;
        for (int i = 0; i < name.length(); i++) {
            while (j < typed.length() && j > 0 && typed.charAt(j) != name.charAt(i)
                  && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            }
            if (j == typed.length() || name.charAt(i) != typed.charAt(j))  return false;
            j++;
        }
        return true;
    }
}