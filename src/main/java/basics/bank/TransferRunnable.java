package basics.bank;

/**
 * Created by sulong on 2019/1/30.
 */
public class TransferRunnable implements Runnable {
    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    public TransferRunnable(Bank b ,int from,double max){
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    @Override
    public void run() {
        try {
            while (true){
                int toAccount = (int)(bank.size()*Math.random());
                double amount = maxAmount*Math.random();
                bank.transfe(fromAccount,toAccount,amount);
                Thread.sleep((int)(DELAY * Math.random()));
            }
        }catch (InterruptedException e){
            System.out.println("InterruptedException e");
        }
    }

}
