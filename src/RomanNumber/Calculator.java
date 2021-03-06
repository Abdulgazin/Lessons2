package RomanNumber;

import java.util.Scanner;
import java.util.TreeMap;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    private static Object String;
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public final static java.lang.String toRoman(int num) {
        int l = map.floorKey(num);
        if (num == l) {
            var s = map.get(num);
            return s;
        }
        return map.get(l) + toRoman(num - l);
    }

    public static void main(String[] args) {
        int num1 = Integer.parseInt(getLine());
        int num2 = Integer.parseInt(getLine());
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        System.out.println("Результат операции: " + result);
    }

    public static boolean isNumeric(String strNum) {
        try {
            int d = Integer.parseInt(strNum);
            System.out.println("это число");
        } catch (NumberFormatException nfe) {
            System.out.println("это не число");
            return false;
        }
        return true;
   }
    public static int parseInt(String strNum) throws NumberFormatException {
        if(isNumeric(strNum)) {
            System.out.println("String is numeric!");
            //return parseInt(strNum);
        } else {
            System.out.println("String is not numeric.");
        }
        return parseInt(strNum);
    }

    //        public static int toArabic(String value) {
    //          if (value.equals("I")) return 1;
//            if (value.equals("II")) return 2;
    //          if (value.equals("III")) return 3;
//            if (value.equals("IV")) return 4;
    //          if (value.equals("V")) return 5;
//            if (value.equals("VI")) return 6;
    //          if (value.equals("VII")) return 7;
//            if (value.equals("VIII")) return 8;
    //          if (value.equals("IX")) return 9;
//            if (value.equals("X")) return 10;
    //      return 0;
    //    }
//    private class RomanToArabic {
//        static int value(String a) {
//            if (a == "M") return 1000;
//            else if (a == "D") return 500;
//            else if (a == "C") return 100;
//            else if (a == "L") return 50;
//            else if (a == "X") return 10;
//            else if (a == "IX") return 9;
//            else if (a == "VIII") return 8;
//            else if (a == "VII") return 7;
//            else if (a == "VI") return 6;
//            else if (a == "V") return 5;
//            else if (a == "IV") return 4;
//            else if (a == "III") return 3;
//            else if (a == "II") return 9;
//            else if (a == "I") return 1;
//            else return 0;
//        }

        private static java.lang.String getLine() {
            System.out.print("Введите число:");
            java.lang.String num;
            if (scanner.hasNextLine()) {
                num = scanner.nextLine();
            } else {
                System.out.print("Вы допустили ошибку.");
                scanner.next();//рекурсия
                num = getLine();
            }
            return num;
        }

        public static char getOperation() {
            System.out.print("Введите операцию:");
            char operation;
            if (scanner.hasNext()) {
                operation = scanner.next().charAt(0);
            } else {
                System.out.print("Вы допустили ошибку при вводе.");
                scanner.next();//рекурсия
                operation = getOperation();
            }
            return operation;
        }

        public static int calc(int num1, int num2, char operation) {
            int result;
            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Операция не распознана.");
                    result = calc(num1, num2, getOperation());//рекурсия
            }
            return result;
        }
}

