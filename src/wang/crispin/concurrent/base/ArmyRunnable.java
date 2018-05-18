package wang.crispin.concurrent.base;

/**
 * 军队线程.
 *
 * @author : chris
 * 2018-05-18
 */
public class ArmyRunnable implements Runnable {
    /**
     * volatile 保证了线程可以正确的读取到其它线程写入的值--可见性问题
     */
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (keepRunning) {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + "进攻对方[" + i + "]");
                // 让出了处理器时间
                Thread.yield();
            }

        }
        System.out.println(name + "结束了战斗！");
    }
}
