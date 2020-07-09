package model;

public class AccountNumber {

    private String value;

    public AccountNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AccountNumber{" +
                "value='" + value + '\'' +
                '}';
    }

    public static void validateAccountNumber(String accountNumber){

        String regex = "\\d{26}?";
        if(accountNumber.matches(regex)){
            System.out.println("Number rachunku bankowego jest poprawny");
        }else{
            System.out.println("Numer rachunku bankowego jest niepoprawny");
        }

    }

}
