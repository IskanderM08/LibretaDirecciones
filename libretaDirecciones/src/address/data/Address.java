package address.data;

//Autor: Iskander Emilio Mercader Olivares

/* En esta sección se crea el constructor de la clase junto a los atributos privados, los que serán visibles mediante los métodos de la clase. */

public class Address {
    private String stateName;
    private String cityName;
    private String streetName;
    private String postalCode;

    public Address(String stateName, String cityName, String streetName, String postalCode) {
        this.stateName = stateName;
        this.cityName = cityName;
        this.streetName = streetName;
        this.postalCode = postalCode;
    }

    /* En esta sección se declaran los getters y setters de la clase, diseñados para cambiar y obtener los atributos de la clase. */

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /* En esta sección se declara el método toString, el cual imprimirá los atributos de la clase. */

    @Override
    public String toString() {
        return ", Estado: " + stateName + ", Ciudad: " + cityName + ", Calle: " + streetName + ", Código Postal: " + postalCode;
    }
}
