package model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Entity {

    private String companyName;
    private Address address;
    private NIP nip;
    private AccountNumber accountNumber;
    private String paymentDate;

    public Entity(String companyName, Address address, NIP nip, AccountNumber accountNumber) {
        this.companyName = companyName;
        this.address = address;
        this.nip = nip;
        this.accountNumber = accountNumber;
        this.paymentDate = createPaymentDate();
    }

    public Entity(){

    }

    public String getCompanyName() {
        return companyName;
    }

    public Address getAddress() {
        return address;
    }

    public NIP getNip() {
        return nip;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public String  getPaymentDate() {
        return paymentDate;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "companyName='" + companyName + '\'' +
                ", address=" + address +
                ", nip=" + nip +
                ", accountNumber=" + accountNumber +
                ", paymentDate=" + paymentDate +
                '}';
    }

    public void validateNIP(String nip){

        String regex = "\\d{10}?";
        int[] weights = {6, 5, 7, 2, 3, 4, 5, 6, 7};
        char[] nipCharArray = nip.toCharArray();
        int[] nipIntArray = new int[nipCharArray.length];
        boolean islastNipNumberCorret;

        for (int i = 0; i < nipCharArray.length; i++) {
            int value = Character.getNumericValue(nipCharArray[i]);
            nipIntArray[i] = value;
        }

        int sum = 0;
        for (int i = 0; i < weights.length ; i++) {
            sum = sum + weights[i] * nipIntArray[i];
        }

        if(sum % 11 == nipIntArray[nipIntArray.length - 1]){
            islastNipNumberCorret = true;
        }else{
            islastNipNumberCorret = false;
        }


        if(nip.matches(regex) && islastNipNumberCorret){
            System.out.println("Nip jest odpowiedni");
        }else{
            System.out.println("Nip jest błędny, podaj proszę jeszcze raz");
        }

    }

    public String createPaymentDate(){
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date date = calendar.getTime();
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String dateTimeString = ft.format(date);
        return dateTimeString;

    }

    public String currentDate(){
        LocalDateTime timeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(timeNow);
    }
}
