package Expriment_seventeen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JLabel;

public class calendarBean implements ActionListener {
    int year = 0;
    int month = 0;
    JLabel now;
    JLabel[] label;
    String[] day;

    public calendarBean() { }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String[] getCalendar() {
        String[] a = new String[42];
        Calendar rill = Calendar.getInstance();
        rill.set(this.year, this.month - 1, 1);
        int weekday = rill.get(7) - 1;
        int day = 0;
        if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
            day = 31;
        }

        if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
            day = 30;
        }

        if (this.month == 2) {
            if ((this.year % 4 != 0 || this.year % 100 == 0) && this.year % 400 != 0) {
                day = 28;
            } else {
                day = 29;
            }
        }

        int i;
        for(i = 0; i < weekday; ++i) {
            a[i] = "";
        }

        i = weekday;

        for(int n = 1; i < weekday + day; ++i) {
            a[i] = String.valueOf(n);
            ++n;
        }

        for(i = weekday + day; i < a.length; ++i) {
            a[i] = "";
        }

        return a;
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("last")) {
            --this.month;
            if (this.month == 0) {
                --this.year;
                this.month = 12;
            }
        } else if (str.equals("next")) {
            ++this.month;
            if (this.month == 13) {
                ++this.year;
                this.month = 1;
            }
        }

        this.now.setText(this.year + "年" + this.month + "月");
        this.day = this.getCalendar();

        for(int i = 0; i < this.day.length; ++i) {
            this.label[i].setText("        " + this.day[i]);
        }

    }
}