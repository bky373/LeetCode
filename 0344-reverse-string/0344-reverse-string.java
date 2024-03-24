class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char leftc;
        char rightc;
        
        while (left < right) {
            leftc = s[left];
            rightc = s[right];
            
            s[left] = rightc;
            s[right] = leftc;
            
            left++;
            right--;
        }
    }
}