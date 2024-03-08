//package com.example.raiffaisen.Domain;
//
//public class InvestorValidator {
//
//    public int validateEmail(String email) throws Exception {
//        if (email.length() < 3){
//            throw new Exception("Invalid email !");
//        }
//        if ((!Character.toString(email.charAt(email.length() -1)).equals("m") ||
//                !Character.toString(email.charAt(email.length() -2)).equals("o") ||
//                !Character.toString(email.charAt(email.length() -3)).equals("c"))&&
//                (!Character.toString(email.charAt(email.length() -1)).equals("o") ||
//                        !Character.toString(email.charAt(email.length() -2)).equals("r")) ){
//            throw new Exception("Invalid email !");
//        }
//        if (!email.contains("@")){
//            throw new Exception("The email must contain '@' !");
//        }
//        String namePart = email.split("@")[0];
//        if (!namePart.contains("0") || !namePart.contains("1") || !namePart.contains("2") || !namePart.contains("3") ||
//                !namePart.contains("4") || !namePart.contains("5") || !namePart.contains("6") || !namePart.contains("7") ||
//                !namePart.contains("8") || !namePart.contains("9")){
//            throw new Exception("Email must contain numbers !");
//        }
//        return 0;
//    }
//
//    public int validatePassword(String psw) throws Exception {
//        String errors = "";
//        if (psw.length() < 8 || psw.length() > 16){
//            errors.concat("Password must be between 8 and 16 characters !");
//        }
//        if (psw.toLowerCase().equals(psw)){
//            errors.concat("\nPassword must contain at least 1 upper character !");
//        }
//        if (errors.length() > 0){
//            throw new Exception(errors);
//        }
//        return 0;
//    }
//
//    public int validateName(String name) throws Exception {
//        if (name.length() == 0){
//            throw new Exception("You must complete your name !");
//        }
//        return 0;
//    }
//    public int validateSurname(String sn) throws Exception {
//        if (sn.length() == 0) {
//            throw new Exception("You must complete your surname !");
//        }
//        return 0;
//    }
//}
