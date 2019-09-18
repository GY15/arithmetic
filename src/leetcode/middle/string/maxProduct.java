package leetcode.middle.string;

import test.Map;

public class maxProduct {
    public static void main(String[] args) {
        new maxProduct().maxProduct(new String[]{"a","aa","aaa","aaaa"});
    }
    public int maxProduct(String[] words) {
        int[]lengths = new int[words.length];
        int[]bytesOfString = new int[words.length];
        for (int i = 0; i < words.length;i++){
            lengths[i] = words[i].length();
            for(int j = 0; j < words[i].length(); j++) {
                bytesOfString[i] |= 1 << words[i].charAt(j) - 'a';
            }
        }
        int max = 0;
        for (int i = 0; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++){
                if ((bytesOfString[i] & bytesOfString[j]) == 0){
                    max = Math.max(max,lengths[i]*lengths[j]);
                }
            }
        }
        return max;
    }
}
