package leetcode.middle.string;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/..."));
    }
    public String simplifyPath(String path) {
        List<String> stack = new ArrayList<>();

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {

            } else if (path.charAt(i) == '.') {
                if (i+1 < path.length()  && path.charAt(i + 1) == '.') {
                    i++;
                    if (i+1 < path.length()  && path.charAt(i + 1) != '/') {
                        int last = path.indexOf("/", i);
                        if (last < 0) {
                            stack.add(path.substring(i-1));
                            break;
                        } else {
                            stack.add(path.substring(i-1, last));
                            i=last;
                        }
                    }else{
                        if (stack.size()>0)
                            stack.remove(stack.size() - 1);
                    }

                }else if (i+1 < path.length()  && path.charAt(i + 1) != '/'){
                    i++;
                    int last = path.indexOf("/", i);
                    if (last < 0) {
                        stack.add(path.substring(i-1));
                        break;
                    } else {
                        stack.add(path.substring(i-1, last));
                        i=last;
                    }
                }
            } else {
                int last = path.indexOf("/", i);
                if (last < 0) {
                    stack.add(path.substring(i));
                    break;
                } else {
                    stack.add(path.substring(i, last));
                    i = last;
                }
            }
        }
        if (stack.size()==0){
            return "/";
        }
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < stack.size();i++){
            s.append("/");
            s.append(stack.get(i));
        }
        return s.toString();
    }
}
