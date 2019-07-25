package leetcode.hard;

//正则表达式匹配*和.
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aa","a*"));
    }
    public boolean isMatch(String s, String p) {
        if(p.equals("")){
            return s.equals("");
        }
        String pWithout = p.replaceAll("\\*","");
        int[][] metrix = new int[pWithout.length()][s.length()];
        for (int i = 0; i < pWithout.length(); i++){
            for (int j = 0;j < s.length();j++){
                if (pWithout.charAt(i) == '.' || pWithout.charAt(i) == s.charAt(j)){
                    metrix[i][j] = 1;
                }
            }
        }
        boolean allowMore[] = new boolean[pWithout.length()];
        while (p.indexOf("*") >= 0){
            allowMore[p.indexOf("*")-1] = true;
            p = p.replaceFirst("\\*","");
        }
        return analyse(metrix,allowMore,0, 0, false);
    }

    private boolean analyse(int[][] metrix, boolean[] allowMore, int i, int j, boolean isLast) {
        if (i >= allowMore.length && j >= metrix[0].length -1){
            if (isLast) {
                return true;
            }
        }
        if (j >= metrix[0].length){
            if (allowMore[i] == true){
                return analyse(metrix,allowMore,i+1,j,true);
            }
        }
        if (i < allowMore.length && j < metrix[0].length) {
            if (allowMore[i] == false) {
                if (metrix[i][j] == 1) {
                    if (j == metrix[0].length-1 && i == allowMore.length-1) {
                        return true;
                    }
                    if (i + 1 >= allowMore.length && j + 1 < metrix[0].length){
                        return false;
                    }
                    return analyse(metrix, allowMore, i + 1, j + 1, j == metrix[0].length-1);
                } else {
                    return false;
                }
            } else {
                if (analyse(metrix, allowMore, i + 1, j,false)) {
                    return true;
                }
                for (int num = 0; j + num < metrix[0].length; num++) {
                    if (metrix[i][j + num] == 1) {
                        if (j+num == metrix[0].length-1 && i == allowMore.length-1) {
                            return true;
                        }
                        if (analyse(metrix, allowMore, i + 1, j + num + 1,false)) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }
}
