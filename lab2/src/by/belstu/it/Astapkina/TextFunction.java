package by.belstu.it.Astapkina;

public class TextFunction {
    private int a;
    public void Cycle(){
        for(int i=0; i<10;i++) {
            System.out.println("cycle" + i);
        }
    }
    public String getValue() {
        PrintInf();
        return "Hello from First project";
    }
    private void PrintInf() {
        System.out.println("Some information");
    }

    public TextFunction() {

    }
}
