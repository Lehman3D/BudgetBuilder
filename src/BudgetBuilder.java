import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A program to calculate and report how much money i can spend through a
 * budget.
 *
 * @author David Lehman
 */
public final class BudgetBuilder {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private BudgetBuilder() {
        // no code needed here
    }

    /**
     * budget percentages.
     */
    private static final int ROOMANDBOARD = 1000;
    private static final int RENT = 475;

    private static final double pGroceries = 0.38;
    private static final double pFood = 0.19;
    private static final double pAlc = 0.29;
    private static final double pSavings = 0.14;

    /**
     * magic numbers.
     */
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final int ELEVEN = 11;
    private static final int TWELVE = 12;
    private static final int TWENTYEIGHT = 28;
    private static final int THIRTY = 30;
    private static final int THIRTYONE = 31;
    private static final int ONEHUNDRED = 100;

    /**
     *
     * @param balance
     *            the balance of the bank account
     * @param date
     *            the day number
     * @param out
     *            output
     */
    private static void createBudget(double balance, String date,
            SimpleWriter out) {

        double tempBalance = balance;

        double daysLeft = daysLeftInCalender(date);

        //take out savings
        double savings = tempBalance * pSavings;
        tempBalance = tempBalance - savings;

        //get money per day
        double moneyPerDay = tempBalance / daysLeft;

        //get how much can be spent of groceries
        double groceries = tempBalance * pGroceries;
        //tempBalance = tempBalance - groceries;

        //get how much can be spent on food
        double food = tempBalance * pFood;
        //tempBalance = tempBalance - food;

        //get how much to spend on alcohol
        double alc = tempBalance * pAlc;
        // tempBalance = tempBalance - alc;

        //Print Statements
        out.println("You should save $" + String.format("%.2f", savings) + ".");
        out.println("Here is what you can spend on for the rest of the month:");
        out.println("You can spend $" + String.format("%.2f", groceries)
                + " on groceries. You can spend $" + String.format("%.2f", food)
                + " on food and you can spend $" + String.format("%.2f", alc)
                + " on booze.");
        out.println("");
        out.println("You have " + String.format("%.2f", moneyPerDay)
                + " to spend per day");

    }

    /**
     * Reports what I can spend on this week.
     *
     * @param balance
     *            balance in my account
     * @param dayOfTheWeek
     *            day of the week
     * @param date
     *            date formatted "mm/dd"
     * @param out
     *            print statements
     */
    private static void thisWeekReport(double balance, String dayOfTheWeek,
            String date, SimpleWriter out) {
        //gets the day and month days left in the week and in the month
        int day = getDay(date);
        int month = getMonth(date);
        int daysLeftInWeek = daysLeftInTheWeek(dayOfTheWeek);
        int daysLeftInMonth = daysLeftInCalender(date);

    }

    /**
     * Creates and prints out percentages of how much of my total i have spent
     * so far this month.
     *
     * @param balance
     *            the amount of money left in my account
     * @param afterCharge
     *            the amount of money at the beginning of the month
     * @return the percent of how much has been spent
     */
    private static double whatIHaveSpent(double balance, double afterCharge) {

        double spent = afterCharge - balance;

        return (spent / afterCharge);
    }

    /**
     * returns the number of days in the month.
     *
     * @param date
     *            the date formatted in "mm/dd"
     * @return the number of days in that month
     */
    private static int getMonth(String date) {
        //RETURN VARIABLE
        int monthNum;

        //gets the index of '/' in mm/dd
        int seperator = date.indexOf("/");

        //gets the month number
        String month = date.substring(seperator);

        if (month.equals("01")) {
            monthNum = ONE;
        } else if (month.equals("02")) {
            monthNum = TWO;
        } else if (month.equals("03")) {
            monthNum = THREE;
        } else if (month.equals("04")) {
            monthNum = FOUR;
        } else if (month.equals("05")) {
            monthNum = FIVE;
        } else if (month.equals("06")) {
            monthNum = SIX;
        } else if (month.equals("07")) {
            monthNum = SEVEN;
        } else if (month.equals("08")) {
            monthNum = EIGHT;
        } else if (month.equals("09")) {
            monthNum = NINE;
        } else if (month.equals("10")) {
            monthNum = TEN;
        } else if (month.equals("11")) {
            monthNum = ELEVEN;
        } else {
            monthNum = TWELVE;
        }

        return monthNum;

    }

    /**
     * GETS THE CURRENT DAY.
     *
     * @param date
     *            the date formated in "mm/dd"
     * @return the day
     */
    private static int getDay(String date) {

        int num;

        int seperator = date.indexOf("/");

        //gets the month number
        String temp = date.substring(seperator + 1, date.length());

        if (temp.equals("01")) {
            num = ONE;
        } else if (temp.equals("02")) {
            num = TWO;
        } else if (temp.equals("03")) {
            num = THREE;
        } else if (temp.equals("04")) {
            num = FOUR;
        } else if (temp.equals("05")) {
            num = FIVE;
        } else if (temp.equals("06")) {
            num = SIX;
        } else if (temp.equals("07")) {
            num = SEVEN;
        } else if (temp.equals("08")) {
            num = EIGHT;
        } else if (temp.equals("09")) {
            num = NINE;
        } else {
            num = Integer.parseInt(temp);
        }

        return num;
    }

    /**
     * Gets the number of days in the month.
     *
     * @param date
     *            the date formatted in "mm/dd"
     * @return the number of days in the month
     */
    private static int daysInTheMonth(String date) {
        int days;

        //gets the month
        int month = getMonth(date);

        if (month == 2) {
            days = TWENTYEIGHT;
        } else if (month == EIGHT || month == FOUR || month == SIX
                || month == ELEVEN) {
            days = THIRTY;
        } else {
            days = THIRTYONE;
        }

        return days;
    }

    /**
     * Gets how many days are left in the week.
     *
     * @param dayOfTheWeek
     *            The day of the Week
     * @return the amount of days left in the week.
     *
     */
    private static int daysLeftInTheWeek(String dayOfTheWeek) {
        int daysLeft = 0;

        if (dayOfTheWeek.equals("Sun")) {
            daysLeft = SEVEN;
        } else if (dayOfTheWeek.equals("Mon")) {
            daysLeft = SIX;
        } else if (dayOfTheWeek.equals("Tue")) {
            daysLeft = FIVE;
        } else if (dayOfTheWeek.equals("Wed")) {
            daysLeft = FOUR;
        } else if (dayOfTheWeek.equals("Thu")) {
            daysLeft = THREE;
        } else if (dayOfTheWeek.equals("Fri")) {
            daysLeft = TWO;
        } else if (dayOfTheWeek.equals("Sat")) {
            daysLeft = ONE;
        }

        return daysLeft;
    }

    /**
     * Reports how many days are left in the month.
     *
     * @param date
     *            the date formatted by "mm/dd"
     * @return the days left in the month
     */
    private static int daysLeftInCalender(String date) {
        //gets the day
        int day = getDay(date);
        //number of days in the month
        int days = daysInTheMonth(date);

        return (days - day);

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //prompt user for bank balance
        out.println("David Enter your bank account balance: $");
        double balance = in.nextDouble();

        //gets Todays date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd");
        LocalDateTime now = LocalDateTime.now();

        //gets day of the week
        java.util.Date date2 = new java.util.Date();
        String dateTwo = date2.toString();
        int indexSep = dateTwo.indexOf(" ");
        String dayOfTheWeek = dateTwo.substring(0, indexSep);

        String date = dtf.format(now).toString();

        out.println("");
        out.println("Awesome! Since it is only " + dayOfTheWeek
                + ", according to my calculations, you should only spend: ");
        out.println("--------------------------------------------------------");

        //gets how much money was in my account after the first of the month
        int afterCharges = ROOMANDBOARD - RENT;

        //gets the percentage of what I have spent so far
        double spent = whatIHaveSpent(balance, afterCharges);
        spent = spent * ONEHUNDRED;
        out.println("You have spent " + String.format("%.0f", spent)
                + "% of your money so far!");

        //gets the percentage of how far into the month I am
        double pMonth = whatIHaveSpent(daysLeftInCalender(date),
                daysInTheMonth(date));
        pMonth = pMonth * ONEHUNDRED;
        out.println("But you are only " + String.format("%.0f", pMonth)
                + "% of the way through the month!");
        out.println("");

        //creates budget for month
        createBudget(balance, date, out);
        //reports what i can spend this week
        thisWeekReport(balance, dayOfTheWeek, date, out);

        out.close();
        in.close();
    }

}
