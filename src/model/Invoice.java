package model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class Invoice {

    private String issueDate;
    private String title;
    private Entity seller;
    private Entity buyer;
    private Item[] itemList;
    private Double totalValue;
    private String totalValueWritten;

    public Invoice(String title, Entity seller, Entity buyer, Item[] itemList) {
        this.title = title;
        this.seller = seller;
        this.buyer = buyer;
        this.itemList = itemList;
        this.issueDate = createIssueDate();
        this.totalValue = createTotalValue();
    }



    public String getIssueDate() {
        return issueDate;
    }

    public String getTitle() {
        return title;
    }

    public Entity getSeller() {
        return seller;
    }

    public Entity getBuyer() {
        return buyer;
    }

    public Item[] getItemList() {
        return itemList;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public String getTotalValueWritten() {
        return totalValueWritten;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "\nissueDate=" + issueDate +
                "\n, title='" + title + '\'' +
                "\n, seller=" + seller +
                "\n, buyer=" + buyer +
                "\n, itemList=" + Arrays.toString(itemList) +
                "\n, totalValue=" + totalValue +
                "\n, totalValueWritten='" + totalValueWritten + '\'' +
                '}';
    }

    private String createIssueDate() {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String dateTimeString = ft.format(date).toString();
        return dateTimeString;
    }

    private Double createTotalValue(){
        Double totalValue = 0D;
        for (int i = 0; i < getItemList().length ; i++) {
            totalValue += getItemList()[i].getGrossValue();
        }
        return totalValue;
    }


}


