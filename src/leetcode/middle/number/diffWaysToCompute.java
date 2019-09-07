package leetcode.middle.number;

import java.util.ArrayList;
import java.util.List;

public class diffWaysToCompute {
    public static void main(String[] args) {
        new diffWaysToCompute().diffWaysToCompute("2*3-4*5");
    }
    public List<Integer> diffWaysToCompute(String input) {
        List<String> list = new ArrayList<>();
        int begin = 0;
        for (int i = 0; i < input.length();i++){
            if (input.charAt(i) == '+' || input.charAt(i) == '*' || input.charAt(i) == '-'){
                list.add(input.substring(begin,i+1));
                begin = i+1;
            }
        }
        list.add(input.substring(begin,input.length()));

        return handle(list);
    }
    public List<Integer> handle(List<String> strs) {
        List<Integer> r = new ArrayList<>();
        if (strs.size()==1){
            r.add(Integer.parseInt(strs.get(0)));
            return r;
        }
        List<Expression> res = new ArrayList<>();
        for (int i = strs.size()-1; i >= 0;i--){
            if (res.size() == 0){
                res.add(new Expression(Integer.parseInt(strs.get(i))));
                continue;
            }
            handleLastString(strs.get(i),res,i==0);
        }
        for (int i = 0 ; i < res.size();i++){
            r.add(res.get(i).calculateAll());
        }
        return r;
    }

    private void handleLastString(String s, List<Expression> res, boolean isLast) {
        for (int i = res.size()-1; i >= 0; i--){
            Expression cur = res.remove(i);
            if (isLast){
                cur.concat(s);
                res.add(cur);
            }else{
                cur.concat(s);
                res.add(cur);
                while (cur.operator.size() > 1) {
                    Expression next = cur.getNextExp();
                    cur = next;
                    res.add(next);
                }
            }
        }
    }

    class Expression{
        List<Integer> operator = new ArrayList<>();
        List<Character> operation = new ArrayList<>();

        public Expression(int num) {
            operator.add(num);
        }
        public Expression(Expression exp){
            this.operator = new ArrayList<>(exp.operator);
            this.operation = new ArrayList<>(exp.operation);
        }
        public void concat(String s) {
            operator.add(0,Integer.parseInt(s.substring(0,s.length()-1)));
            operation.add(0,s.charAt(s.length()-1));
        }
        public Expression getNextExp(){
            Expression expression = new Expression(this);
            int n1 = expression.operator.remove(0);
            int n2 = expression.operator.remove(0);
            switch (expression.operation.remove(0)){
                case '+':
                    n1 += n2;
                    break;
                case '-':
                    n1 -= n2;
                    break;
                case '*':
                    n1 *= n2;
                    break;
                default:
            }
            expression.operator.add(0,n1);
            return expression;
        }
        public int calculateAll(){
            int cal = operator.get(0);
            for (int i = 1; i < operator.size();i++){
                switch (operation.get(i-1)){
                    case '+':
                        cal += operator.get(i);
                        break;
                    case '-':
                        cal -= operator.get(i);
                        break;
                    case '*':
                        cal *= operator.get(i);
                        break;
                        default:

                }
            }
            return cal;
        }
    }
}
