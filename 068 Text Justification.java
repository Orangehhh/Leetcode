class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ans;
        }
        int i = 0;
        while (i < words.length) {
            int j = i;
            int charLeft = maxWidth;
            while (j < words.length && charLeft >= words[j].length()) {
                charLeft -= words[j].length() + 1;
                j++;
            }
            String str = arrange(words, i, j - 1, charLeft, maxWidth);
            ans.add(str);
            i = j;
        }
        return ans;
    }
    
    private String arrange(String[] words, int start, int end, int charLeft,
                          int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int numOfWord = end - start + 1;
        int numOfSpaces = charLeft + numOfWord;
        int spaces = numOfWord != 1 ? 
            numOfSpaces / (numOfWord - 1) : numOfSpaces;
        int extraSpaces = numOfSpaces - spaces * (numOfWord - 1);
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i != end) {
                int addSpaces = extraSpaces > 0 ? spaces + 1 : spaces;
                if (end == words.length - 1) {
                    addSpaces = 1;
                }
                while (addSpaces > 0) {
                    sb.append(" ");
                    addSpaces--;
                }
            }
            extraSpaces--;
        }
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        return sb.toString();
    }
}