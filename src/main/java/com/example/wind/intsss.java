package com.example.wind;

public class intsss {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        mainThread.setName("main");
        Thread thread = new Thread() {
            @Override
            public void run() {
                Thread tThread = Thread.currentThread();
                if(tThread==this){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(tThread.getName());
            }
        };
        thread.setName("thread");
        thread.start();
        thread.run();
        thread.join();
        thread.run();

    }
}
