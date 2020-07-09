package model;

public class Address {

    private PostalCode postalCode;
    private String city;
    private String Street;
    private String buildingNumber;
    private short apartmentNumber;

    public Address(PostalCode postalCode, String city, String street, String buildingNumber, short apartmentNumber) {
        this.postalCode = postalCode;
        this.city = city;
        this.Street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public Address(PostalCode postalCode, String city, String street, String buildingNumber) {
        this.postalCode = postalCode;
        this.city = city;
        Street = street;
        this.buildingNumber = buildingNumber;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return Street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public short getApartmentNumber() {
        return apartmentNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", Street='" + Street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }

    public static void validatePostalCode(String postalCode) {

        String regex = "\\d{2}(-\\d{3})?";
        if(!postalCode.matches(regex)){
            System.out.println("Niepoprawny kod pocztowy. Podaj proszę jeszcze raz!");
        }else{
            System.out.println("Kod pocztwoy jest poprawny");
        }

    }

}
