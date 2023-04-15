/*import java.util.*;

public class CapitalGainsProblem {

    private Queue bought;
    private Queue sold;

    public CapitalGainsProblem() {
        bought = new LinkedList<>();
        sold = new LinkedList<>();
    }

    public void addBought(int count, double price) {
        bought.add(new Transaction(count, price));
    }

    public void addSold(int count, double price) {
        sold.add(new Transaction(count, price));
    }

    public int calculateGains() {
        int gains = 0;
        while (!bought.isEmpty() && !sold.isEmpty()) {
            Transaction buy = bought.peek();
            Transaction sell = sold.peek();
            if (buy.getCount() < sell.getCount()) {
                gains += buy.getCount() * (sell.getPrice() - buy.getPrice());
                bought.remove();
                sell.setCount(sell.getCount() - buy.getCount());
            } else if (buy.getCount() > sell.getCount()) {
                gains += sell.getCount() * (sell.getPrice() - buy.getPrice());
                sold.remove();
                buy.setCount(buy.getCount() - sell.getCount());
            } else {
                gains += buy.getCount() * (sell.getPrice() - buy.getPrice());
                bought.remove();
                sold.remove();
            }
        }
        return gains;
    }

    private class Transaction {
        private int count;
        private double price;

        public Transaction(int count, double price) {
            this.count = count;
            this.price = price;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        CapitalGainsProblem problem = new CapitalGainsProblem();
        problem.addBought(100, 10.0);
        problem.addBought(200, 12.0);
        problem.addSold(150, 15.0);
        problem.addSold(150, 18.0);
        int gains = problem.calculateGains();
        System.out.println("Total gains: " + gains);
    }
}*/