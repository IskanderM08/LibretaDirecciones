package address.data;

//Autor: Iskander Emilio Mercader Olivares

/* En esta sección se crea el constructor de la clase junto a los atributos privados, los que serán visibles mediante los métodos de la clase. */

public class AddressEntry {
    private String firstName;
    private String lastName;
    private Address newAddress;
    private String phoneNumber;
    private String userEmail;

    public AddressEntry(String firstName, String lastName, Address newAddress, String phoneNumber, String userEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.newAddress = newAddress;
        this.phoneNumber = phoneNumber;
        this.userEmail = userEmail;
    }

    /* En esta sección se declaran los getters y setters de la clase, diseñados para cambiar y obtener los atributos de la clase. */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address newAddress) {
        this.newAddress = newAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getNewAddress() {
        return newAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    /* En esta sección se declara el método toString, el cual imprimirá los atributos de la clase incluyendo el atributo Address. */

    @Override
    public String toString() {
        return  "*Nombre: " + firstName + ", Apellido: " + lastName + newAddress + ", \nTeléfono: " + phoneNumber +
                ", Correo electrónico: " + userEmail;
    }
}