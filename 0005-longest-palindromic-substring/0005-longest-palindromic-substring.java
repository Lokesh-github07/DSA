class Solution {
    public String longestPalindrome(String s) {

            if (s.length()< 2){
                return s;
            }
            int start = 0;
            int end = 0;

            for(int i = 0; i < s.length(); i++){
                int odd = expand(s, i, i);
                int even = expand(s, i, i + 1);
                int length = Math.max(odd, even);

                if (length > end - start + 1){
                    start = i - (length - 1) / 2;
                    end = i + length / 2;
                }
            }
            return s.substring(start, end + 1);
    }
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}