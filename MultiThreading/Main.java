/*
Assignment

Design a BlockingQueue of your own

A blocking queue is a queue that blocks when you try to dequeue from it and the queue is empty, or if you try to enqueue items to it and the queue is already full.
A thread trying to dequeue from an empty queue is blocked until some other thread inserts an item into the queue.
A thread trying to enqueue an item in a full queue is blocked until some other thread makes space in the queue, either by dequeuing one or more items or clearing the queue completely.

Requirements

The queue should have two methods put() and take().
There should be Multiple thread who are producing, and the number of consuming threads will vary on situation and it should be configurable.
If the thread wants to take something from the queue and the queue is empty, then it should print “Queue is empty. There is no task present in the Queue.” 
If the thread wants to add a task to the queue and the queue is already full then it should print an exception saying “Queue is full. No task is already taken by any of the consumer.
* */



import java.util.*;

class BlockingQueue {
    private int capacity;
    private Queue<Integer> blockingQueue = new LinkedList<>();

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void put(int id, int number) {
        while (true) {
            synchronized (this) {
                if (this.blockingQueue.size() == this.capacity) {
                    while (this.blockingQueue.size() == this.capacity) {
                        System.out.println("Queue is full. No task is already taken by any of the consumer.");
                        try {
                            wait();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else {
                    System.out.println("P" + id + " PUT " + number);
                    this.blockingQueue.add(number++);
                    notifyAll();
                }
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void take(int index) {
        while (true) {
            synchronized (this) {
                if (this.blockingQueue.size() == 0) {
                    while (this.blockingQueue.size() == 0) {
                        System.out.println("“Queue is empty. There is no task present in the Queue.”");
                        try {
                            wait();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else {
                    System.out.println("C" + index + " TAKE " + this.blockingQueue.poll());
                    notifyAll();
                }
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

class Producer implements Runnable {
    private int id;
    private BlockingQueue blockingQueue;

    public Producer(int id, BlockingQueue blockingQueue) {
        this.id = id;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        this.blockingQueue.put(this.id, new Random().nextInt(100));
    }
}

class Consumer implements Runnable {
    private int id;
    private BlockingQueue blockingQueue;

    public Consumer(int id, BlockingQueue blockingQueue) {
        this.id = id;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        this.blockingQueue.take(this.id);
    }
}

public class Main {
    static void threads(BlockingQueue blockingQueue, Thread[] producers, Thread[] consumers) {
        
        System.out.println("Creating " + producers.length + " Producer Threads...");
        for (int i = 0; i < producers.length; i++) {
            producers[i] = new Thread(new Producer(i, blockingQueue));
        }

        System.out.println("Creating " + consumers.length + " Consumer Threads...");
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Thread(new Consumer(i, blockingQueue));
        }

        System.out.println("Starting Producers...");
        for (int i = 0; i < producers.length; i++) {
            producers[i].start();
        }

        System.out.println("Starting Consumers...");
        for (int i = 0; i < consumers.length; i++) {
            consumers[i].start();
        }

        for (Thread p : producers) {
            try {
                p.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread c : consumers) {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Capacity:");
        int capacity = s.nextInt();
        BlockingQueue blockingQueue = new BlockingQueue(capacity);
        System.out.println("Enter Number Of Producer Threads:");
        int numberProducers = s.nextInt();
        System.out.println("Enter Number Of Consumer Threads:");
        int numberConsumers = s.nextInt();
        Thread[] producers = new Thread[numberProducers];
        Thread[] consumers = new Thread[numberConsumers];
        System.out.println("Starting:");
        threads(blockingQueue, producers, consumers);
    }
}