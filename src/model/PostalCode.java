package model;

public class PostalCode {

    private String value;

    public PostalCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PostalCode{" +
                "value='" + value + '\'' +
                '}';
    }
}
