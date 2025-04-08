package br.com.jantarfilosofos;

public class DiningPhilosophers {

    public static Philosopher[] createPhilosophers(int n) {

        Fork[] forks = new Fork[n];

        for (int i = 0; i < n; i++) {
            forks[i] = new Fork(i);
        }

        Philosopher[] philosophers = new Philosopher[n];

        for (int i = 0; i < n; i++) {

            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % n];

            philosophers[i] = new Philosopher(i, leftFork, rightFork);

        }

        return philosophers;

    }

    public static void main(String[] args) {

        Philosopher[] philosophers = createPhilosophers(8);

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }

    }

}
