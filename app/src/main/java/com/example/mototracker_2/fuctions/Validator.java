package com.example.mototracker_2.fuctions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String passwordRegex = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])";//+ "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
    private static final String phoneRegex = "^[0-9]{8,8}$";

    private static final String emailRegex= "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public static boolean Password(String password){
        if (password == null) {
            return false;
        }
        return  checkRegex(password,passwordRegex);
    }

    public static boolean NonEmptyText(String text){
        return (text==null || text.isEmpty())? false : true;
    }

    public static boolean TextLength(String text, int from, int to){
        return (text.length()>to || text.length()<from)? false : true;
    }

    public static boolean Phone(String phone){
        if (phone == null) {
            return false;
        }
        return  checkRegex(phone,phoneRegex);
    }

    public static boolean Email(String email) {
        if (email == null) {
            return false;
        }
        return  checkRegex(email,emailRegex);
    }

    private static boolean checkRegex(String text, String regex){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        return m.matches();
    }
}
