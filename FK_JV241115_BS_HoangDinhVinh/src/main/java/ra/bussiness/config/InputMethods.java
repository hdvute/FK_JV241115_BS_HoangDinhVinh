package ra.bussiness.config;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * <p><b><u}>Description detail</u></b> </p>
 * <p>getString()       ==>> Return a string value from the user.</p>
 * <p>getChar()         ==>> Return a character value from the user</p>
 * <p>getBoolean()	    ==>> Return a boolean value from the user.</p>
 * <p>getByte()	        ==>> Return a byte value from the user.</p>
 * <p>getShort()	    ==>> Return a short value from the user.</p>
 * <p>getInteger()	    ==>> Return a integer value from the user.</p>
 * <p>getLong()	        ==>> Return a long value from the user.</p>
 * <p>getFloat()	    ==>> Return a float value from the user.</p>
 * <p>getDouble()	    ==>> Return a double value from the user.</p>
 */
public final class InputMethods {
    private static final String ERROR_ALERT = "===>>....";
    private static final String EMPTY_ALERT = "===>> i....";
    /*========================================Input Method Start========================================*/

    /**
     * getString()  Return a String value from the user.
     */
    public static String getString() {
        while (true) {
            String result = getInput();
            if (result.equals("")) {
                System.err.println(EMPTY_ALERT + "Dữ liệu nhập vào không hợp lệ ");
                continue;
            }
            return result;
        }
    }

    /**
     * getChar()  Return a Character value from the user.
     */
    public static char getChar() {
        return getString().charAt(0);
    }

    /**
     * getBoolean()  Return a Boolean value from the user.
     */
    public static boolean getBoolean() {
        String result = getString();
        return result.equalsIgnoreCase("true");
    }

    /**
     * getByte()  Return a Byte value from the user.
     */
    public static byte getByte() {
        while (true) {
            try {
                return Byte.parseByte(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }
    public static BigDecimal getBigDecimal() {
        while (true) {
            try {
                return new BigDecimal(getInput());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }



    /**
     * getShort()  Return a Short value from the user.
     */
    public static short getShort() {
        while (true) {
            try {
                return Short.parseShort(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getInteger()  Return a Integer value from the user.
     */
    public static int getInteger() {
        while (true) {
            try {
                return Integer.parseInt(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getLong()  Return a Long value from the user.
     */
    public static long getLong() {
        while (true) {
            try {
                return Long.parseLong(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getFloat()  Return a Float value from the user.
     */
    public static float getFloat() {
        while (true) {
            try {
                return Float.parseFloat(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }

    /**
     * getDouble()  Return a Double value from the user.
     */
    public static double getDouble() {
        while (true) {
            try {
                return Double.parseDouble(getString());
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT);
            }
        }
    }
    public static Date getDate() {
        while (true) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String line =new Scanner(System.in).nextLine();
            try {
                Date birth =  sdf.parse(line);
                return birth;
            } catch (ParseException e) {
                System.err.println("ngày tháng ko đúng địn dạng , nhập lại");
            }
        }
    }
    /*========================================Input Method End========================================*/

    /**
     * getInput()  Return any String value from the user.
     */
    public static String getInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    /**
     * pressAnyKey()  Press any key to continue....
     */
    public static void pressAnyKey() {
        getInput();
    }
    /*========================================Other Method========================================*/

    public static float[] swapIfGreater(float value1, float value2) {
        if (value1 > value2) {
            float temp = value1;
            value1 = value2;
            value2 = temp;
        }
        return new float[] {value1, value2};
    }

    // Positive
    public static BigDecimal getBigDecimalPositive() {
        while (true) {
            try {
                BigDecimal number = new BigDecimal(getInput());
                if (number.compareTo(BigDecimal.ZERO) > 0) {
                    return number;
                }else{
                    System.err.println("Nhập số lớn hơn 0");
                }
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT+ "Nhập một số lớn hơn 0");
            }
        }
    }

    // Positive
    public static int getIntegerPositive() {
        while (true) {
            try {
                int number = Integer.parseInt(getString());
                if (number > 0) {
                    return number;
                }else{
                    System.err.println("Nhập số dương lớn hơn 0");
                }
            } catch (NumberFormatException errException) {
                System.err.println(ERROR_ALERT+" Nhập số nguyên dương lớn hơn 0");
            }
        }
    }


}

