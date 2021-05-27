package com.company;

import Road.Road;
import university.Consumer;
import university.Producer;
import university.Store;

public class Main {
    public static void main(String[] args) {
       // University.Task(Student.GetStudent());
       // Road.Task(6);

        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        producer.start();
        consumer.start();
    }
}
