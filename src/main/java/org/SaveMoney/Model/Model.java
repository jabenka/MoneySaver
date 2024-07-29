package org.SaveMoney.Model;

public class Model
{
    private static long amount;
    private static long goal;

    public Model(long amount, long goal) {
        this.amount = amount;
        this.goal = goal;
    }

    public static long getAmount() {
        return amount;
    }

    public static void setAmount(long amount) {
        Model.amount = amount;
    }

    public static long getGoal() {
        return goal;
    }

    public static void setGoal(long goal) {
        Model.goal = goal;
    }
}
