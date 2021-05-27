package university;

import java.util.ArrayList;
import java.util.List;

public class Producer extends Thread {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            store.put();
        }
    }

    /*private String name;
    private boolean inOut;

    public String getName() {
        return name;
    }

    public boolean getInOut() {
        return inOut;
    }

    public Operator(String name, boolean inOut) {
        this.name = name;
        this.inOut = inOut;
    }

    public static List<Operator> GetStudent() {
        List<Operator> students = new ArrayList<Operator>();
        students.add(new Operator("Катя", true));
        students.add(new Operator("Ангелина", true));
        students.add(new Operator("Наташа", false));
        students.add(new Operator("Никита", false));
        students.add(new Operator("Андрей", false));
        students.add(new Operator("Сергей", true));
        return students;
    }
    */

}
