package model;

public class NIP {

    private String value;

    public NIP(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NIP{" +
                "value='" + value + '\'' +
                '}';
    }
}
