package com.DCLink.task.constants;

public interface InputCheck {

    static boolean isLongNumber(String number){
        try {
            Long.parseLong(number);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    static boolean isFloatNumber(String number){
        try {
            Float.parseFloat(number);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}
