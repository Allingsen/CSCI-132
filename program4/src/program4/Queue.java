package program4;

import java.util.LinkedList;
import java.util.Scanner;

public class Queue {
    private LinkedList<Customer> stu_line;
    private LinkedList<Customer> prof_line;
    private int stu_size;
    private int prof_size;
    private double total_wait_time;
    private int people_served;

    public Queue() {
        this.stu_line = new LinkedList<Customer>();
        this.prof_line = new LinkedList<Customer>();
        this.stu_size = 0;
        this.prof_size = 0;
        this.total_wait_time = 0;
        this.people_served = 0;
    }

    public void printQueue() {
        int counter = 1;
        if (this.prof_size == 0 && this.stu_size == 0) {
            System.out.println("The queue is empty.");
        }
        else {
            System.out.println("Current Queue: \n-------------");
            for (Customer i: this.prof_line) {
                System.out.println(counter + ". " + i.getCustomer());
                counter++;
            }
            for (Customer i: this.stu_line) {
                System.out.println(counter + ". " + i.getCustomer());
                counter++;
            }
        }
    }

    public Customer createCustomer(boolean is_prof) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the customer's name?");
        String name = sc.nextLine();
        System.out.println("What would you like to order?");
        String order = sc.nextLine();
        Long start_time = System.nanoTime();
        Customer newCustomer = new Customer(name, order, start_time, is_prof);

        return(newCustomer);
        
    }
    
    public void enqueue(Customer c) {
        c.changeStartTime(System.nanoTime());
        this.stu_line.addLast(c);
        this.stu_size++;

        System.out.println("Added " + c.getName() + " to the queue.");
    }

    public void priorityEnqueue(Customer c) {
        c.changeStartTime(System.nanoTime());
        this.prof_line.addLast(c);
        this.prof_size++;

        System.out.println("Added " + c.getName() + " (Professor) to the queue.");
    }
    
    public void dequeue() {
        Customer next_in_line;
        if (this.prof_size > 0) {
            next_in_line = this.prof_line.getFirst();
            this.prof_line.removeFirst();
            this.prof_size--;
        }
        else {
            next_in_line = this.stu_line.getFirst();
            this.stu_line.removeFirst();
            this.stu_size--;
        }

        long end_time = System.nanoTime();
        long wait_time = (end_time - next_in_line.getStartTime()) / 1000000000;
        int wait = (int) wait_time;

        System.out.println("Time spent in queue: " + wait + " seconds");
        this.total_wait_time += wait;
        this.people_served++;
        System.out.println(next_in_line.getName() + " has been served their " + next_in_line.getOrder());
    }

    public void removeFromQueue(String n) {
        int p_count = 0;
        int s_count = 0;
        for (Customer i: this.prof_line) {
            if (n.equals(i.getName())) {
                long end_time = System.nanoTime();
                Customer leaver = this.prof_line.get(p_count);
                long wait_time = (end_time - leaver.getStartTime()) / 1000000000;
                int wait = (int) wait_time;

                this.prof_line.remove(p_count);
                this.prof_size--;
                System.out.println("Time spent in queue: " + wait + " seconds");
                return;
            }
            p_count++;
        }
        for (Customer i: this.stu_line) {
            if (n.equals(i.getName())) {
                long end_time = System.nanoTime();
                Customer leaver  = this.stu_line.get(s_count);
                long wait_time = (end_time - leaver.getStartTime()) / 1000000000;
                int wait = (int) wait_time;

                this.stu_line.remove(s_count);
                this.stu_size--;
                System.out.println("Time spent in queue: " + wait + " seconds");
                return;
            }
            s_count++;
        }

        System.out.println(n + " was not found.");
    }

    public void printQueueStats() {
        System.out.println("Queue Statistics\n----------------");
        double avg_time = this.total_wait_time / this.people_served;
        System.out.println("Average wait time: " + avg_time + " seconds");
        System.out.println("Customers served: " + people_served);
    }
    
}

