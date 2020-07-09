package Service;

import model.*;

import java.util.Date;

public class ConsoleInputDataService {

    public Invoice invoiceStub(){

//        Dane sprzedawcy
        PostalCode postalCode = new PostalCode("90-000");
        Address sellerAddress = new Address(postalCode, "Lodz", "Piotrkowska", "140a", (short) 21);
        NIP sellerNip = new NIP("3463463463426");
        AccountNumber accountNumber = new AccountNumber("123523523523");
        Entity seller = new Entity("JanuszPol", sellerAddress, sellerNip, accountNumber);

//        Dane Kupujacego

        PostalCode buyerPostalCode = new PostalCode("91-222");
        Address buyerAddress = new Address(buyerPostalCode, "Ozorków", "Wodna", "123", (short) 7);
        NIP buyerNip = new NIP("574574523672");
        AccountNumber buyerAccountNumber = new AccountNumber("367347234612346");
        Entity buyer = new Entity("StefanPol", buyerAddress, buyerNip, buyerAccountNumber);
        Date date = new Date();

//        Tworzenie listy itemow

        Item[] items = new Item[]{
                new Item("Komputer", 2000D, (short) 23),
                new Item("Kwiatek", 230D, (short) 8),
                new Item("Mycie podlogi", 340D, (short) 23),
                new Item("Telewizor", 5000D, (short) 23)
        };

//        Wypelniamy fakture
        Invoice invoice = new Invoice("Faktura VAT " + new Entity().currentDate() , seller, buyer, items);
        return invoice;
    }



}
