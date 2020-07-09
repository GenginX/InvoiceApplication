package model;

public class Item {

    private String Name;
    private Double nettValue;
    private short taxRate;
    private Double grossValue;


    public Item(String name, Double nettValue, short taxRate) {
        Name = name;
        this.nettValue = nettValue;
        this.taxRate = taxRate;
        this.grossValue = createGrossValue();
    }

    public String getName() {
        return Name;
    }

    public Double getNettValue() {
        return nettValue;
    }

    public short getTaxRate() {
        return taxRate;
    }

    public Double getGrossValue() {
        return grossValue;
    }

    @Override
    public String toString() {
        return "\n      Item{" +
                "Name='" + Name + '\'' +
                ", nettValue=" + nettValue +
                ", taxRate=" + taxRate +
                ", grossValue=" + grossValue +
                "}";
    }

    private Double createGrossValue(){
        return (getNettValue() * taxRate / 100) + getNettValue();
    }

}
