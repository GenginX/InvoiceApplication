package Service;

import model.Entity;
import model.Invoice;
import model.Item;

import java.awt.*;
import java.util.Date;

public class ConsoleDisplayService {


    public char[][] createInvoiceTemplate(int invoiceLength, int invoiceWidth){
        return createEmptySection(invoiceLength, invoiceWidth);
    }

    public void display2DArray(char[][] twoDimArray){
        for(char[] array: twoDimArray){
            System.out.println(array);
        }

    }

    public char[][] createEmptySectionWithFrame(int Length, int Width){

        char[][] board = createEmptySection(Length, Width);
        for(int i = 0; i < Length; i++){
            board[i][0] = '*';
            board[i][Width - 1] = '*';
        }
        for(int i = 0; i < Width; i++){
            board[0][i] = '*';
            board[Length - 1][i] = '*';
        }
        return  board;

//        for (int i = 0; i < Length; i++) {
//            for (int j = 0; j < Width; j++) {
//                if(i == 0 || i == Length -1){
//                    board[i][j] = '*';
//                }
//                else if(j == 0 || j == Width - 1){
//                    board[i][j] = '*';
//                }
//                else {
//                    board[i][j] = ' ';
//                }
//            }
//        }
    }

    private char[][] createEmptySection(int Length, int Width){
        char sign = ' ';
        char[][] section = new char[Length][Width];
        for(int i = 0; i < Length; i++){
            for(int j = 0; j < Width; j++){
                section[i][j] = sign;
            }
        }
        return section;

    }


    private void customSystemArrayCopy(char[] sekcjaKtoraKopiujemy,
                                       char[] linijkaWFakturze,
                                       int gdzieWLinijceFakturyWklejamy) {
        for (int i = 0; i < sekcjaKtoraKopiujemy.length; i++) {
            linijkaWFakturze[gdzieWLinijceFakturyWklejamy + i] = sekcjaKtoraKopiujemy[i];
        }
    }


    public void insertSectionIntoInvoice(char[][] invoiceTemplate, char[][] data, int x, int y){
        insert2DimArrayInto2DimArray(invoiceTemplate, data, x, y);
    }

    public void insertDataIntoSection(char[][] section, char[][] data){
        insert2DimArrayInto2DimArray(section, data, 2, 1);
    }

    public void insert2DimArrayInto2DimArray(char[][] bigArray, char[][] smallArray, int x, int y){
        for (int i = 0; i < smallArray.length ; i++) {
            System.arraycopy(smallArray[i],0, bigArray[y + i], x, smallArray[i].length);
        }
    }

    private void fillEmptySectionWithProvidedData(String[] data, char[][] section ){

        int maxLength = 0;

        for (String line: data) {
            if(maxLength < line.length()){
                maxLength = line.length();
            }
        }

        char[][] dataCharacters = createEmptySection(data.length, maxLength);

        for (int i = 0; i < data.length ; i++) {
            dataCharacters[i] = data[i].toCharArray();
        }
        insertDataIntoSection(section, dataCharacters);
    }

    public void fillSellerSectionWithData(char[][] section, Entity entity) {

        fillSEntitySectionWithData(section, entity, true);

    }
    public void fillSBuyerSectionWithData(char[][] section, Entity entity) {

        fillSEntitySectionWithData(section, entity, false);

    }
    public void fillSEntitySectionWithData(char[][] section, Entity entity, boolean isSeller) {


        String postalcode = entity.getAddress().getPostalCode().getValue();
        String city = entity.getAddress().getCity();
        String street = entity.getAddress().getStreet();
        String streetNumber = entity.getAddress().getBuildingNumber();
        String nip = entity.getNip().getValue();
        String accountNumber = entity.getAccountNumber().getValue();
        String paymentDay = entity.getPaymentDate();

        String lastValue;
        if (isSeller) {
            lastValue = "Nr konta: " + accountNumber;
        } else {
            lastValue = "Dzień zaplaty: " + paymentDay;
        }


        String[] entityData = new String[]{
                entity.getCompanyName(),
                postalcode + " " + city + " " + street + " " + streetNumber,
                "NIP: " + nip,
                lastValue
        };

        fillEmptySectionWithProvidedData(entityData, section);

    }

    public void fillsDateSectionWithData(char[][] section, String date){

        String[] invoiceData = new String[]{
                "Data wystawienia: " + date
        };
        fillEmptySectionWithProvidedData(invoiceData, section);
    }

    public void fillsTitleSectionWithDate(char[][] section, String title){

        String[] invoiceTitle = new String[]{
                title
        };
        fillEmptySectionWithProvidedData(invoiceTitle, section);

    }

//    public void fillsItemSectionWithDate(char[][] section, Item[] items){
//
//        String[] itemsData = new String[]{
//
//
//        }

    public void fillsValueToPay(char[][] section, double valueToPay){

        String valueToPayString = String.valueOf(valueToPay);
        String[] valueToPayData = new String[]{
               "Kwota do zapłaty: " + valueToPayString + " zł"
        };

        fillEmptySectionWithProvidedData(valueToPayData, section);

    }



    public void fillsItemsNameSectionWithData(char[][] section, Item[] items) {

        String[] itemsList = new String[items.length];

        for (int i = 0; i < items.length; i++) {
            int counter = i + 1;
            itemsList[i] = counter + ". " + items[i].getName();
        }
        fillEmptySectionWithProvidedData(itemsList, section);
    }
    public void fillsItemsNettoPriceSectionWithData(char[][] section, Item[] items) {

        String[] itemsList = new String[items.length];

        for (int i = 0; i < itemsList.length ; i++) {
            itemsList[i] = "";
        }

        int maxLen = 0;

        for (int i = 0; i <items.length ; i++) {
            int len = items[i].getNettValue().toString().length();
            if(len > maxLen){
                maxLen = len;
            }
        }



        for (int i = 0; i < items.length; i++) {
            int len = items[i].getNettValue().toString().length();
            int n = 0;
            if(maxLen > len){
                n = maxLen - len;
            }
            for (int j = 0; j < n ; j++) {
                itemsList[i] = itemsList[i] + " ";
            }
            itemsList[i] = itemsList[i]  + items[i].getNettValue().toString() + " PLN";
        }
        fillEmptySectionWithProvidedData(itemsList, section);
    }

    public void fillsItemsVatValueSectionWithData(char[][] section, Item[] items) {

        String[] itemsList = new String[items.length];

        for (int i = 0; i < itemsList.length ; i++) {
            itemsList[i] = "";
        }

        int maxLen = 0;

        for (int i = 0; i <items.length ; i++) {
            String tax = "" + items[i].getTaxRate();
            int len = tax.length();
            if(len > maxLen){
                maxLen = len;
            }
        }

        for (int i = 0; i < items.length; i++) {
            String tax = "" + items[i].getTaxRate();
            int len = tax.length();;
            int n = 0;
            if(maxLen > len){
                n = maxLen - len;
            }
            for (int j = 0; j < n ; j++) {
                itemsList[i] = itemsList[i] + " ";
            }
            itemsList[i] = itemsList[i]  + tax + "%";
        }
        fillEmptySectionWithProvidedData(itemsList, section);
    }
    public void fillsItemsGrossValueSectionWithData(char[][] section, Item[] items) {

        String[] itemsList = new String[items.length];

        for (int i = 0; i < itemsList.length ; i++) {
            itemsList[i] = "";
        }

        int maxLen = 0;

        for (int i = 0; i <items.length ; i++) {
            int len = items[i].getGrossValue().toString().length();
            if(len > maxLen){
                maxLen = len;
            }
        }
        for (int i = 0; i < items.length; i++) {
            int len = items[i].getGrossValue().toString().length();
            int n = 0;
            if(maxLen > len){
                n = maxLen - len;
            }
            for (int j = 0; j < n ; j++) {
                itemsList[i] = itemsList[i] + " ";
            }
            itemsList[i] = itemsList[i]  + items[i].getGrossValue().toString() + " PLN";
        }
        fillEmptySectionWithProvidedData(itemsList, section);
    }

    public void fillsTableNamesForItems(char[][] section, String header){

        String[] headerArray = new String[]{
                header
        };
        fillEmptySectionWithProvidedData(headerArray, section);

    }

    public void fillsValueToPayWritten(char[][] section, double number){

        Integer intNumber = (int) number;
        String slownie= "";
        int koncowka;
        int rzad = 0;
        int j = 0;

         String[] dziesiatki = {
                 "",
                 " dziesięć",
                 " dwadzieścia",
                 " trzydzieści",
                 " czterdzieści",
                 " pięćdziesiąt",
                 " sześćdziesiąt",
                 " siedemdziesiąt",
                 " osiemdziesiąt",
                 " dziewięćdziesiąt"
        };

         String[] jednosci = {
                 "",
                 " jeden",
                 " dwa",
                 " trzy",
                 " cztery",
                 " pięć",
                 " sześć",
                 " siedem",
                 " osiem",
                 " dziewięć",
                 " dziesięć"
         };

         String[] nascie = {
                 " jedenaśćie",
                 " dwanaście",
                 " trzynaście",
                 " czternaście",
                 " piętnaście",
                 " szesnaście",
                 " siedemnaśćie",
                 " osiemnaście",
                 " dziewiętnaście",
         };

         String[] setki = {
                 "",
                 " sto",
                 " dwieście",
                 " trzysta",
                 " czterysta",
                 " pięćset",
                 " sześćset",
                 " siedemset",
                 " osiemset",
                 " dziewięćset"
         };

         String[] powerNums = {
                 "",
                 " tysiąc",
                 " milion",
                 " miliard",
                 " bilion",
                 " biliard"
        };

         

         if(intNumber == 0) {
             slownie = "zero";
         }

         while (intNumber > 0) {

             koncowka = (intNumber % 10);
             intNumber /= 10;
             if ((j == 0) && (intNumber % 100 != 0 || koncowka != 0)) {
                 slownie = powerNums[rzad] + slownie;
             }
             if ((j == 0) && (intNumber % 10 != 1)) {
                 slownie = jednosci[koncowka] + slownie;
             }
             if ((j == 0) && (intNumber % 10 == 1)) {
                 slownie = nascie[koncowka] + slownie;
                 intNumber /= 10;
                 j += 2;
                 continue;
             }
             if (j == 1) {
                 slownie = dziesiatki[koncowka] + slownie;
             }
             if (j == 2) {
                 slownie = setki[koncowka] + slownie;
                 j = -1;
                 rzad++;
             }
             j++;
         }


         String[] writtenArray = new String[]{
                 "Słownie:" + slownie + " złotych"
         };

         fillEmptySectionWithProvidedData(writtenArray, section);




    }



}
