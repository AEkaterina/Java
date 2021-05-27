package university;

import java.util.ArrayList;
import java.util.List;

public class Store {                       //инт имеет только 1 метод run
    private int product = 0;
    private boolean available = false;

    public synchronized void get() {
        while (product<1) {
            try {
                wait();
            } catch (InterruptedException e)
            {

            }
        }
        product--;
        System.out.println("Россия купила 1 трактор");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public synchronized void put() {
        while (product>=3) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        product ++;
        System.out.println("МАЗ добавил 1 трактор");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    /*
    Operator operator;

    public CallCenter(Operator operator) {
        this.operator = operator;
    }

    public void run() {
        for (int i=1; i<6; i++) {
            operator.put();
        }
    }
    */
    /*
    private void ToOccupyDoor(Boolean door) throws InterruptedException{
        door = false;
        System.out.println(student.getName() + " ждёт дверь ");
        Thread.sleep(100);              //остановка
        door = true;
        throw new InterruptedException();
    }

   public void run() {
        System.out.println(student.getName() + " начал(a) " + (student.getInOut() ? " вход " : " выход "));
        synchronized (this){                                //синхронизируем потоки, чтобы ограничить доступ и позволить 1 потоку выполнить действие. Блокирует доступ, пока раотает жругой поток
            try {
                if(!firstDoor){
                    while (!firstDoor)
                        if(!secondDoor)
                            Thread.sleep(100);
                        else
                        {
                            System.out.println(student.getName() + " поменял(а) дверь ");
                            ToOccupyDoor(secondDoor);
                        }
                    ToOccupyDoor(firstDoor);
                }
                else
                    ToOccupyDoor(firstDoor);
            }catch (InterruptedException e) {
                System.out.println(student.getName() + " возобновил(а) " + (student.getInOut() ? " вход " : " выход "));
            }
        }
        System.out.println(student.getName() + " закончил(a) " + (student.getInOut() ? " вход " : " выход "));
    }

    public static void Task(List<Student> students){
        System.out.println();
        System.out.println();

        Boolean door1 = true,
                door2 = true;
        List<Thread> threads = new ArrayList<Thread>();

        for(Student student : students){
            Thread thread = new Thread(new CallCenter(door1, door2, student));
            thread.setName(student.getName());
            threads.add(thread);
            thread.start();                     //запуск потока, вызов run()
        }

        try {
            for (Thread thread : threads){
                thread.join();                          //ожидание завершения потока
            }
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

 */
}
