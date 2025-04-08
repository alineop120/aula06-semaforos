package br.com.jantarfilosofos;

public class Philosopher extends Thread {

    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        for (;;) {
            System.out.println("Philosopher " + id + " is thinking...");
            rightFork.take(id);
            System.out.println("Philosopher " + id + " took the right fork " + rightFork.id);
            leftFork.take(id);
            System.out.println("Philosopher " + id + " took the left fork " + leftFork.id);
            System.out.println("Philosopher " + id + " is eating...");
            leftFork.put(id);
            System.out.println("Philosopher " + id + " has put down the left fork " + leftFork.id);
            rightFork.put(id);
            System.out.println("Philosopher " + id + " has put down the right fork " + rightFork.id);
        }
    }

}