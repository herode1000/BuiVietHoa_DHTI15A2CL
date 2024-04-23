/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7;

/**
 *
 * @author Admin
 */
public class SynchBank {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank(100, 1000);
        int size = bank.size();
        int numberOfTransactions = 100; // Số giao dịch muốn thực hiện
        for (int i = 0; i < size; i++) {
            TransferMoney transferMoney = new TransferMoney(bank, i, 1000, numberOfTransactions);
            Thread thread = new Thread(transferMoney);
            thread.start();
        }
    }
}
