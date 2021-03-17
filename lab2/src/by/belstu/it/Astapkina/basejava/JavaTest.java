package by.belstu.it.Astapkina.basejava;

import java.util.Arrays;

import static java.lang.Math.*;

public class JavaTest {

    final int const1 = 1;
    public final int const2 = 2;
    public static final int const3 = 3;

    public static void main(String[] args) {
        System.out.print("dsd");

        System.out.println("Exercise B:");
        char vchar = 'k';
        int vint = 54323432;
        short vshort = 243;
        byte vbyte = 21;
        long vlong = 234214342;
        boolean vbool1 = true;
        boolean vbool2 = false;
        String vstr = "Persik ";
        double vdouble = 35.35489;

        System.out.println("String + int: " + vstr + vint);
        System.out.println("String + char: " + vstr + vchar);
        System.out.println("String + double: " + vstr + vdouble);

        byte resbyte = (byte)(vbyte + vint);
        System.out.println("byte + int: " + resbyte);
        int resint = (int)(vdouble + vlong);
        System.out.println("double + long: " + resint);

        long reslong = (long)vint + 2147483647;
        System.out.println("int + 214748647: " + reslong);

        System.out.println("Static: " + sint);

        boolean resbool1 = vbool1 && vbool2;
        System.out.println("boolean && boolean: " + resbool1);
        boolean resbool2 = vbool1 ^ vbool2;
        System.out.println("boollean ^ boolean: " + resbool2);
        //resbool2 = vbool1 + vbool2; выполнить нельзя

        long num1 = 9223372036854775807L;
        long num2 = 0x7fff_ffff_ffffL;

        char ch1 = 'a', ch2 = '\u0061', ch3 = 97;
        System.out.println("a: " + ch1);
        System.out.println("ch2: " + ch2);
        System.out.println("ch3: " + ch3);
        System.out.println("Sum:" + ch1 + ch2 + ch3);

        System.out.println("3.45 % 2.4: " + 3.45 % 2.4);
        System.out.println("1.0 / 0.0: " + 1.0 / 0.0);
        System.out.println("0.0 / 0.0: " + 0.0 / 0.0);
        System.out.println("log(-345): " + log(-345));

        System.out.println("intBitsToFloat: " + Float.intBitsToFloat(0x7F800000));
        System.out.println("intBitsToFloat: " + Float.intBitsToFloat(0xFF800000));

        System.out.println("Exercise D");
        System.out.println("PI: " + Math.PI);
        System.out.println("E: " + Math.E);
        System.out.println("round PI: " + Math.round(Math.PI));
        System.out.println("round E: " + Math.round(Math.E));
        System.out.println("min: " + Math.min(Math.PI, Math.E));
        double math1 = Math.random();
        System.out.println("random [0,1): " + math1);

        ExE();
        ExF();
        ExG();
    }

    private static void ExE() {
        System.out.println("Exercise E");
        Character oChar = new Character('a'); //+
        Boolean oBool = new Boolean(true);  //+
        Integer oInt = new Integer(32165);  //+
        Byte oByte = new Byte((byte)15);
        Short oShort = new Short((short)2341);
        Long oLong = new Long(46865131);
        Double oDouble = new Double(53.13549);

        char vch = 'z';
        vch += oChar;
        System.out.println("+: " + vch);

        int vint = ~oInt;
        System.out.println("~: " + vint);

        int vshort = oShort >> 2;
        System.out.println(">>: " + vshort);
        int vshort2 = oShort >>> 2;
        System.out.println(">>>: " + vshort2);

        long vlong = oLong&111;
        System.out.println("&: " + vlong);

        System.out.println("Min long: " + oLong.MIN_VALUE + "\nMax long: " + oLong.MAX_VALUE);
        System.out.println("Min double: " + oDouble.MIN_VALUE + "\nMax double: " + oDouble.MAX_VALUE);

        //упаковка и распаковка
        Integer bint = new Integer(1567);
        int inint = bint;
        Byte bbyte = new Byte((byte)6);
        byte inbyte = bbyte;

        int a = Integer.parseInt("654");
        System.out.println("parse: " + a);
        System.out.println("toHexString: " + Integer.toHexString(9));
        System.out.println("compare: " + Integer.compare(22, 39));
        System.out.println("toString: " + Integer.toString(215, 2));
        System.out.println("bitCount: " + Integer.bitCount(215));
        System.out.println("isNaN: " + Double.isNaN(oDouble));
    }

    private static void ExF() {
        System.out.println("Exercise F");
        String s34 = "2345";
        //String к int
        System.out.println(Integer.valueOf(s34));
        Integer i = new Integer(s34);
        System.out.println(i);

        byte [] arr = s34.getBytes();
        System.out.println("массив байтов: " + Arrays.toString(arr));
        String news34 = new String(arr);
        System.out.println("из байтов в строку: " + news34);

        System.out.println("Логический тип: ");         //строка в логический тип
        System.out.println("1 - " + Boolean.valueOf(s34));
        System.out.println("2 - " + Boolean.getBoolean(s34));

        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("== - " + str1==str2);
        System.out.println("equals - " + str1.equals(str2));
        System.out.println("compare - " + str1.compareTo(str2));

        str2 = null;
        System.out.println("null: \n" + str1==str2);
        //System.out.println(str2.equals(str1));  exception
        //System.out.println(str1.compareTo(str2)); exception

        String mystr = new String("This is my code on java");
        System.out.println("split:");
        for(String word : mystr.split(" ")) {
            System.out.println(word);
        }
        System.out.println("contains: " + mystr.contains("java"));
        System.out.println("hashCode: " + mystr.hashCode());
        System.out.println("indexOf: " + mystr.indexOf("java"));
        System.out.println("length: " + mystr.length());
        System.out.println("replace: " + mystr.replace("java", "C#"));
    }

    public static void ExG() {
        System.out.println("Exercise G");
        char [][] c1;
        char [] c2 [];
        char c3 [][];

        int zero[] = new int [0];
        //System.out.println(zero[2]); выход за пределы

        c1 = new char[3][];
        c1[0] = new char[0];
        c1[1] = new char[1];
        c1[2] = new char[2];
        System.out.println("длина массива: " + c1.length);
        System.out.println("длина строки 0: " + c1[0].length);
        System.out.println("длина строки 1: " + c1[1].length);
        System.out.println("длина строки 2: " + c1[2].length);

        c2 = new char[][] {{'1','2','3'}, {'4','5','6'}, {'1','4','3'}};
        c3 = new char[][] {{'1','2','3'}, {'4','5','6'}, {'1','4','3'}};
        boolean comRez = c2 == c3;
        System.out.println(comRez);
        c2 = c3;

        for(char[] i1 : c2) {
            for(char i2 : i1) {
                System.out.println(i2);
            }
        }
    }

    static int sint;
}
