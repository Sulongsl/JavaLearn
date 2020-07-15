package basics.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行实例
 * Created by sulong on 2019/1/30.
 */
public class Bank {
    private final double[] accounts;

    private Lock bankLock = new ReentrantLock();

    /**
     * 构造方法
     * @param n
     * @param initialBalance
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
    }

    /**
     * @param from
     * @param to
     * @param amount
     */
    public void transfe(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        // 操作账户余额前拿到锁
        bankLock.lock();
        try{
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f form %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance : %10.2f%n", getTotalBalance());
        }finally {
            bankLock.unlock();
        }


    }

    /**
     * 计算总余额
     * @return
     */
    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;
    }

    /**
     *
     * @return
     */
    public int size(){return accounts.length;}

}
