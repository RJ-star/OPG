import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) throws IOException {
        int[][] sign = new int[6][6];//1大于，0等于，-1小于，-2不存在
        ArrayList<Character> list = new ArrayList<>();//运算对象
//        ArrayList<Character> list2 = new ArrayList<>();//运算符号

        sign[0][0]=1;
        sign[0][1]=-1;
        sign[0][2]=-1;
        sign[0][3]=-1;
        sign[0][4]=1;
        sign[0][5]=1;

        sign[1][0]=1;
        sign[1][1]=1;
        sign[1][2]=-1;
        sign[1][3]=-1;
        sign[1][4]=1;
        sign[1][5]=1;

        sign[2][0]=1;
        sign[2][1]=1;
        sign[2][2]=-2;
        sign[2][3]=-2;
        sign[2][4]=1;
        sign[2][5]=1;

        sign[3][0]=-1;
        sign[3][1]=-1;
        sign[3][2]=-1;
        sign[3][3]=-1;
        sign[3][4]=0;
        sign[3][5]=-2;

        sign[4][0]=1;
        sign[4][1]=1;
        sign[4][2]=-2;
        sign[4][3]=-2;
        sign[4][4]=1;
        sign[4][5]=1;

        sign[5][0]=-1;
        sign[5][1]=-1;
        sign[5][2]=-1;
        sign[5][3]=-1;
        sign[5][4]=-2;
        sign[5][5]=-2;

//        FileInputStream inputStream = new FileInputStream(args[0]);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//        String s=bufferedReader.readLine()+"#";
//
//        //close
//        inputStream.close();
//        bufferedReader.close();


        Scanner scanner = new Scanner(System.in);
        String s = scanner.next() + "#";
        StringBuffer str = new StringBuffer(s);
        list.add('#');
        while (list.size() != 2 || list.get(1) != 'E' || str.length() != 1 || str.charAt(0) != '#') {
            char a;
            if (list.get(list.size() - 1) == 'E') {
                a = list.get(list.size() - 2);
            }
            else {
                a = list.get(list.size() - 1);
            }
            char b = str.charAt(0);
            int x = check(a);
            int y = check(b);
            if (y == 6 || sign[x][y] == -2) {
                System.out.println("E");
                break;
            }
            if (sign[x][y] == 1) {
                if (a=='i') {
                    list.remove(list.size()-1);
                    list.add('E');
//                    str.delete(0,1);
                    System.out.println("R");
                }
                else {
                    char temp1=list.get(list.size()-1);
                    char temp2=list.get(list.size()-3);
                    if (temp1=='E' && temp2=='E') {
                        list.remove(list.size()-1);
                        list.remove(list.size()-1);
                        list.remove(list.size()-1);
                        list.add('E');
                        System.out.println("R");
                    }
                    else {
                        System.out.println("RE");
                        break;
                    }
                }
            }
            else if (sign[x][y] == 0) {
                if (list.get(list.size()-1)!='E') {
                    System.out.println("RE");
                    break;
                }
                else {
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    str.delete(0,1);
                    System.out.println("I)");
                    list.add('E');
                    System.out.println("R");
                }
            }
            else if (sign[x][y] == -1) {
                list.add(b);
                str.delete(0,1);
                System.out.println("I"+b);
            }

        }
    }

    public static int check(char a) {
        switch (a) {
            case '+':return 0;
            case '*':return 1;
            case 'i':return 2;
            case '(':return 3;
            case ')':return 4;
            case '#':return 5;
            default:return 6;
        }
    }
}
