package telran.time;
public enum MonthName {
    JAN(1), FEB(2), MAR(3), APR(4), MAY(5), JUN(6), JUL(7), AUG(8), SEP(9), OCT(10), NOV(11), DEC(12);
    private int valueOfMonth;
MonthName(int valueOfMonth) {
       this.valueOfMonth = valueOfMonth;
    }
    public int getValueOfMonth(){
        return valueOfMonth;
}
public static MonthName fromValue(int month) {
    MonthName[] monthArray = MonthName.values();
    int i = 0;
        while (i<monthArray.length) {
            if (monthArray[i].getValueOfMonth() == month) {
                return monthArray[i];

            }
i++;
}
throw new IllegalArgumentException("Invalid month value: " + month);
}

}