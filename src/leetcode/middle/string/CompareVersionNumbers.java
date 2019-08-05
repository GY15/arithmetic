package leetcode.middle.string;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        new CompareVersionNumbers().compareVersion("01","1");
    }
    public int compareVersion(String version1, String version2) {
        String s1[] = version1.split("\\.");
        String s2[] = version2.split("\\.");
        int i = 0;
        for( ;i < s1.length;i++){
            if(i < s2.length){
                if (Integer.parseInt(s1[i]) > Integer.parseInt(s2[i])){
                    return 1;
                }else if (Integer.parseInt(s1[i]) < Integer.parseInt(s2[i])){
                    return -1;
                }
            }else{
                if (Integer.parseInt(s1[i]) != 0){
                    return 1;
                }
            }
        }
        for (;i< s2.length;i++){
            if (Integer.parseInt(s2[i]) != 0){
                return -1;
            }
        }
        return 0;
    }
}
