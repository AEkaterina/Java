package by.belstu.it.Astapkina;

public class TextFunction {
    private int a;
    public TextFunction(int a) {
        this.a = a;
    }

    public TextFunction() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getValue() {
        PrintInf();
        return "Hello from First project";
    }

    private void PrintInf() {
        System.out.println("Some information");
        int a = 3, b = 2;
        int c;
        c = a + b;
        System.out.println("с = " +  c);
    }

    public void onCreate() {
        for (int count = 0; count < 10; count++) {
            System.out.println("Counter " + count);
        }
    }


}
