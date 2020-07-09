import Service.ConsoleDisplayService;
import Service.ConsoleInputDataService;
import Service.FileCreator;
import model.Invoice;


import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        FileCreator file = new FileCreator();
        String folder = file.createFolder();
        String fileName = file.createFile();
        ConsoleInputDataService consoleInputDataService = new ConsoleInputDataService();
        ConsoleDisplayService consoleDisplayService = new ConsoleDisplayService();
        Invoice invoice = consoleInputDataService.invoiceStub();
        System.out.println(file.getDateWithTime());
//Pusta faktura
        char[][] invoiceTemplate = consoleDisplayService.createInvoiceTemplate(33, 100);
//Puste Sekcje
        char[][] dateFrame = consoleDisplayService.createEmptySectionWithFrame(3, 32);
        char[][] sellerFrame = consoleDisplayService.createEmptySectionWithFrame(6, 40);
        char[][] buyerFrame = consoleDisplayService.createEmptySectionWithFrame(6, 40);
        char[][] titleFame = consoleDisplayService.createInvoiceTemplate(3,24);
        char[][] payFrame = consoleDisplayService.createInvoiceTemplate(2,30);
        char[][] itemsNameFrame = consoleDisplayService.createInvoiceTemplate(5,19);
        char[][] itemsNettopriceFrame = consoleDisplayService.createInvoiceTemplate(5,17);
        char[][] itemsVatFrame = consoleDisplayService.createInvoiceTemplate(5, 8);
        char[][] itemsGrossFrame = consoleDisplayService.createInvoiceTemplate(5, 13);
        char[][] itemNameHeader = consoleDisplayService.createInvoiceTemplate(2, 7);
        char[][] itemNettoHeader = consoleDisplayService.createInvoiceTemplate(2,12);
        char[][] itemVatHeader = consoleDisplayService.createInvoiceTemplate(2,12);
        char[][] itemGrossHeader = consoleDisplayService.createInvoiceTemplate(2,17);
        char[][] totalValueWritten = consoleDisplayService.createInvoiceTemplate(2, 99);
//Wypelnianie sekcji
        consoleDisplayService.fillsTitleSectionWithDate(titleFame, invoice.getTitle());
        consoleDisplayService.fillSellerSectionWithData(sellerFrame, invoice.getSeller());
        consoleDisplayService.fillSBuyerSectionWithData(buyerFrame,invoice.getBuyer());
        consoleDisplayService.fillsDateSectionWithData(dateFrame, invoice.getIssueDate());
        consoleDisplayService.fillsValueToPay(payFrame, invoice.getTotalValue());
        consoleDisplayService.fillsItemsNameSectionWithData(itemsNameFrame, invoice.getItemList());
        consoleDisplayService.fillsItemsNettoPriceSectionWithData(itemsNettopriceFrame, invoice.getItemList());
        consoleDisplayService.fillsItemsVatValueSectionWithData(itemsVatFrame, invoice.getItemList());
        consoleDisplayService.fillsItemsGrossValueSectionWithData(itemsGrossFrame, invoice.getItemList());
        consoleDisplayService.fillsTableNamesForItems(itemNameHeader, "Nazwa");
        consoleDisplayService.fillsTableNamesForItems(itemNettoHeader, "Cena Netto");
        consoleDisplayService.fillsTableNamesForItems(itemVatHeader, "Stawka VAT");
        consoleDisplayService.fillsTableNamesForItems(itemGrossHeader, "Wartość Brutto");
        consoleDisplayService.fillsValueToPayWritten(totalValueWritten, invoice.getTotalValue() );
//Wklejanie sekcji
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, titleFame, 33,7);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, dateFrame, 0, 0);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, sellerFrame, 0, 10);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, buyerFrame, 50, 10);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, payFrame, 0, 28);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, itemsNameFrame, 0, 20);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate,itemsNettopriceFrame, 18, 20);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, itemsVatFrame, 35,20);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, itemsGrossFrame, 45, 20);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, itemNameHeader, 0, 19);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, itemNettoHeader,18,19);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, itemVatHeader,31,19);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, itemGrossHeader,43,19);
        consoleDisplayService.insertSectionIntoInvoice(invoiceTemplate, totalValueWritten, 0, 30);
//Wyswietlanie faktury z sekcjami
        consoleDisplayService.display2DArray(invoiceTemplate);
        file.writeToFile(fileName,invoiceTemplate);



    }
}


