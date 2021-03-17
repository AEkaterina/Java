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

        System.out.println("Генерация кода:");
        for(int i = 0; i < 9; i++) {
            if (i > -1 && i < 10)
                System.out.println(i);
        }

        obj.onCreate();
        WrapperString wrapper1 = new WrapperString("fdss");
        WrapperString wrapper2 = new WrapperString("anonim class") {
            @Override
                public void replace (char oldchar, char newchar) {
                    System.out.println("method replace in anonim class");
            }
            public void delete (char newchar) {
                System.out.println("delete something");
            }
        };

    }

}

