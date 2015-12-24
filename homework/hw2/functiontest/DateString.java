class DateString{
    
    public static String dateToString(int month, int day, int year) {
        String date;
        String monthStr, dayStr, yearStr;
        monthStr = Integer.toString(month);
        dayStr = Integer.toString(day);
        yearStr = Integer.toString(year);
        date = (monthStr+"/"+dayStr+"/"+yearStr);
        return date;
    }

    public static void main(String[] arg){
        System.out.println(dateToString(12, 10, 2015));
        System.out.println(dateToString(1, 23, 231));
        System.out.println(dateToString(10, 10, 1991));
    }
}
