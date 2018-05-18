package wang.crispin.concurrent;

/**
 * @author : chris
 * 2018-05-18
 */
public class Actor extends Thread {

    public Actor(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + "是一个演员！");

        int count = 0;

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(getName() + "登台演出" + ++count);
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


        System.out.println(getName() + "的演出结束了！");
    }

    public static void main(String[] args) {
        Thread actor = new Actor("Mr.Thread");
        actor.start();

        Thread actress = new Thread(new Actress(), "Ms.Runnable");
        actress.start();
    }
}
