package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class fullJustify {
    //居中显示，最后一行左对齐
    public static void main(String[] args) {
        new fullJustify().fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16);
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list =new ArrayList<>();
        int length = 0;
        int begin = 0;
        for(int i = 0;i < words.length;i++){
            if (length+i-begin+words[i].length()>maxWidth){
                list.add(init(words,begin,i,length,maxWidth));
                length=words[i].length();
                begin = i;
            } else {
                length+=words[i].length();
            }
        }
        StringBuffer last = new StringBuffer();
        for (int i = begin;i < words.length;i++){
            if (i!=begin){
                last.append(" ");
            }
            last.append(words[i]);
        }
        for (int i = last.length();i<maxWidth;i++){
            last.append(" ");
        }
        list.add(last.toString());
        return list;
    }

    private String init(String[] words, int begin, int i, int l,int maxWidth) {
        StringBuffer s =new StringBuffer();
        if (i-begin==1){
            s.append(words[begin]);
            for (int j = words[begin].length();j < maxWidth;j++){
                s.append(" ");
            }
            return s.toString();
        }
        l = (maxWidth-l);
        while(begin<i){
            s.append(words[begin]);
            begin++;
            if (i==begin){
                break;
            }
            int space = l/(i-begin);
            if (l%(i-begin)!=0){
                space++;
            }
            l-=space;

            for (int j = 0;j < space;j++){
                s.append(" ");
            }
        }
        return s.toString();
    }
}
