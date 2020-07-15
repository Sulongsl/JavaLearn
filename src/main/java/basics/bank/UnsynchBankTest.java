package basics.bank;

/**
 * Created by sulong on 2019/1/30.
 */
public class UnsynchBankTest implements Runnable{
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS,INITIAL_BALANCE);
        System.out.println("a");
        int i;
        for (i=0;i<NACCOUNTS;i++){
            TransferRunnable r = new TransferRunnable(b,i,INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }

    @Override
    public void run() {

    }
}
