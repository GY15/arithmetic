package PAT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
*
*  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
              this.date2 = sdf.parse(date);

 Calendar cal = Calendar.getInstance();
            cal.setTime(date2);
            cal.add(Calendar.YEAR,200);
            Date d3=cal.getTime();
* */

public class Population {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Info temp = null;
        Info max = null;
        Info min =null;
        int total = 0;
        for (int i = 0; i < n;i++){
            String s[] = scanner.nextLine().split(" ");
            temp = new Info(s[0], s[1]);
            if(temp.valid()){
                total++;
                if(max==null){
                    max = temp;
                }else{
                    if(max.date2.after(temp.date2)){
                        max = temp;
                    }
                }
                if(min==null){
                    min = temp;
                }else{
                    if(min.date2.before(temp.date2)){
                        min = temp;
                    }
                }
            }
        }
        System.out.println(total+" "+max.name+" "+min.name);
    }
    static class Info{
        String name;
        String date;
        Date date2;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Info(String name, String date) throws ParseException {
            this.date= date;
            this.name = name;
            this.date2 = sdf.parse(date);
        }
        public boolean valid(){
            try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date2);
            cal.add(Calendar.YEAR,200);
            Date d3=cal.getTime();
                if(sdf.parse("2014/09/06").before(date2)||sdf.parse("2014/09/06").after(d3)){
                    return false;
                }

            return true;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
