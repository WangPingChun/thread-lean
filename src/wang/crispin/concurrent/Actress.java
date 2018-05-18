package wang.crispin.concurrent;

import static java.lang.Thread.sleep;

/**
 * @author : chris
 * 2018-05-18
 */
public class Actress implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + "是一个演员！");

        int count = 0;

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(threadName + "登台演出" + ++count);
            if (count == 100) {
                keepRunning = false;
            }
            if (count % 10 == 0) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        System.out.println(threadName + "的演出结束了！");
    }
}
