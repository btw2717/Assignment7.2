public class WeekDay {
    private String[] day = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    private String name;

    public WeekDay() {
        super();
        this.name = "no day selected";
    }
    public WeekDay(String name) {
        //super();
        this.name = name;
    }

    public String getDay(String name) {
        WeekDay dayName = new WeekDay(name);
        for (int i = 0; i < day.length; i++) {
            if (name.equalsIgnoreCase(day[i])) {
                this.name = day[i];
            } else {
                continue;
            }
        }
        return this.name;
    }

    public String getDay() {
        return this.name;
    }

    public void setDay(String name) {
        for (int i = 0; i < day.length; i++) {
            if (name.equalsIgnoreCase(day[i])) {
                this.name = day[i];
            } else {
                continue;
            }
        }

    }

    private int getIdx(String name) {
        for (int i = 0; i < day.length; i++) {
            if (day[i] == name) {
                return i;
            }
        }
        return -1;
    }

    public String calculateDay(int numberOfDays) {
        String message = "";
        int dayIdx = getIdx(this.name);
        if ((numberOfDays >= 0)) {
            message = day[(dayIdx + numberOfDays) % 7];
        } else if ((numberOfDays < 0)){
            message = day[7 - (Math.abs(numberOfDays - dayIdx) % 7)];
        } else {
            message = "invalid day";
        }
        return message;
    }

    public String getNextDay() {
        return calculateDay(1);
    }
    public String getPreviousDay() {
        return calculateDay(-1);
    }

    @Override
    public String toString() {
        return "The name of the day is: " + name;
    }


}
