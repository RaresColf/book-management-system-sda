package com.sda.rares.bookmanagement.menu;

public enum UserOption {

    CREATE_AUTHOR(1,"Create author"),
    SHOWALLAUTHORS(2,"Display all authors"),
    UPDATEAUTHOR(3,"Update author"),
    EXIT(99,"Exit"),
    UNKNOWN(100,"Unknown option");

    private int numericOption;
    private String displayValue;

    UserOption(int numericOption, String displayValue) {
        this.numericOption = numericOption;
        this.displayValue = displayValue;
    }

    public static void printAllOptions(){
        for (UserOption value : values()) {
            if(value != UNKNOWN) {
                System.out.println(value.getNumericOption() + " - " + value.getDisplayValue());
            }

        }
    }

    public static UserOption findUserOption (int numericValue){
        for (UserOption value : values()) {
            if(value.getNumericOption() == numericValue) {
                return value;
            }
        }
        return UNKNOWN;
    }

    public int getNumericOption() {
        return numericOption;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
