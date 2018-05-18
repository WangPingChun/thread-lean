package wang.crispin.concurrent.base;

/**
 * @author : chris
 * 2018-05-18
 */
public class Stage extends Thread {
    @Override
    public void run() {

        ArmyRunnable armyTaskOfDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        Thread armyOfDynasty = new Thread(armyTaskOfDynasty, "隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农名起义军");

        // 启动线程，让军队开始作战
        armyOfDynasty.start();
        armyOfRevolt.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        armyTaskOfDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;
        try {
            armyOfRevolt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
