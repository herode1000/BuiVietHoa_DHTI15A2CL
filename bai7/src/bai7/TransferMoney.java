/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7;

/**
 *
 * @author Admin
 */
import java.util.Random;

public class TransferMoney implements Runnable {
    Bank bank;
    int fromAcc;
    double maxAmount;
    int delay = 1000;
    int numberOfTransactions;

    public TransferMoney(Bank bank, int fromAcc, double maxAmount, int numberOfTransactions) {
        this.bank = bank;
        this.fromAcc = fromAcc;
        this.maxAmount = maxAmount;
        this.numberOfTransactions = numberOfTransactions;
    }

    @Override
    public void run() {
        Random rd = new Random();
        int toAcc = 0;
        double amount = 0;
        try {
            for (int i = 0; i < numberOfTransactions; i++) {
                do {
                    toAcc = rd.nextInt(bank.size());
                } while (toAcc == fromAcc);
                amount = rd.nextInt((int) maxAmount);
                bank.transfer(fromAcc, toAcc, amount);
                Thread.sleep(rd.nextInt(delay));
            }
        } catch (InterruptedException ex) {
            System.out.println("Giao dịch chuyển tiền từ account " + fromAcc + " sang account " + toAcc + " bị gián đoạn");
        }
    }
}


