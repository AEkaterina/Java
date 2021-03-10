package by.belstu.it.Astapkina;

/*
*"author Ekaterina
* @version 1.0
 */

import static java.lang.Math.*;         //импорт класса
public class Main {
    /*
    *@return void
    * @throws divide by zero
    * @param String[] args
     */
    public static void main(String[] args) {
	// write your code here
        //TODO add something
        TextFunction obj = new TextFunction();

        for(int i = 0; i < 9; i++) {
            if (i > -1 && i < 10) System.out.println(i);
        }

        obj.onCreate();

        char vchar = 'k';
        int vint = 54323432;
        short vshort = 243;
        byte vbyte = 21;
        long vlong = 234214342;
        boolean vbool1 = true;
        boolean vbool2 = false;
        String vstr = "Persik ";
        double vdouble = 35.35489;

        System.out.println(vstr + vint);
        System.out.println(vstr + vchar);
        System.out.println(vstr + vdouble);

        //byte resbyte = vbyte + vint;
        //int resint = vdouble + vlong;

        long reslong = vint + 2147483647;
        System.out.println(reslong);

        System.out.println(sint);

        boolean resbool1 = vbool1 && vbool2;
        System.out.println(resbool1);
        boolean resbool2 = vbool1 ^ vbool2;
        //resbool2 = vbool1 + vbool2;

        //long var = 9223372036854775807;
        //double fl = 0x7fff_ffff_ffff;

        char ch1 = 'a', ch2 = '\u0061', ch3 = 97;
        System.out.println(ch1 + ch2 + ch3);

        System.out.println(3.45 % 2.4);
        System.out.println(1.0 / 0.0);
        System.out.println(0.0 / 0.0);
        System.out.println(log(-345));

        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));

        System.out.println(Math.PI);
        System.out.println(Math.E);
        System.out.println(Math.round(Math.PI));
        System.out.println(Math.round(Math.E));
        System.out.println(Math.min(Math.PI, Math.E));
        double math1 = Math.random();
        System.out.println(math1);

        ExE();
        ExF();
        ExG();
        var wrapper = new WrapperString("ewr");
        wrapper.replace('e', 'r');
    }
    static int sint;

    public static void ExE() {
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
        System.out.println(vch);

        int vint = ~oInt;
        System.out.println(vint);

        int vshort = oShort >> 2;
        System.out.println(vshort);
        int vshort2 = oShort >>> 2;

        long vlong = oLong&111;
        System.out.println(vlong);

        System.out.println(oLong.MIN_VALUE);
        System.out.println(oLong.MAX_VALUE);
        System.out.println(oDouble.MIN_VALUE);
        System.out.println(oDouble.MAX_VALUE);

        Integer bint = new Integer(1567);
        int inint = bint;
        Byte bbyte = new Byte((byte)6);
        byte inbyte = bbyte;

        int a = Integer.parseInt("654");
        System.out.println(a);
        System.out.println(Integer.toHexString(9));
        System.out.println(Integer.compare(22, 39));
        System.out.println(Integer.toString(215, 2));
        System.out.println(Integer.bitCount(215));
    }

    public static void ExF() {
        System.out.println("Exercise F");
        String s34 = "2345";
        System.out.println(Integer.valueOf(s34));
        Integer i = new Integer(s34);
        System.out.println(i);

        byte [] arr = s34.getBytes();
        System.out.println(arr);
        String news34 = new String(arr);
        System.out.println(news34);

        System.out.println(Boolean.valueOf(s34));
        System.out.println(Boolean.getBoolean(s34));

        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.compareTo(str2));

        str2 = null;
        System.out.println(str1==str2);
        //System.out.println(str2.equals(str1));
        //System.out.println(str1.compareTo(str2));

        String mystr = new String("This is my code on java");
        for(String word : mystr.split(" ")) {
            System.out.println(word);
        }
        System.out.println(mystr.contains("java"));
        System.out.println(mystr.hashCode());
        System.out.println(mystr.indexOf("java"));
        System.out.println(mystr.length());
        System.out.println(mystr.replace("java", "C#"));
    }

    public static void ExG() {
        System.out.println("Exercise G");
        char [][] c1;
        int [] c2 [];
        int c3 [][];

        int zero[] = new int [0];
        //System.out.println(zero[2]);

        c1 = new char[3][];
        c1[0] = new char[0];
        c1[1] = new char[1];
        c1[2] = new char[2];
        System.out.println(c1.length);
        System.out.println(c1[0].length);
        System.out.println(c1[1].length);
        System.out.println(c1[2].length);

        c2 = new int[][] {{1,2,3}, {4,5,6}, {1,4,3}};
        c3 = new int[][] {{1,2,3}, {4,5,6}, {1,4,3}};
        boolean comRez = c2 == c3;
        System.out.println(comRez);
        c2 = c3;

        for(int[] i1 : c2) {
            for(int i2 : i1) {
                System.out.println(i2);
            }
        }
    }
}

