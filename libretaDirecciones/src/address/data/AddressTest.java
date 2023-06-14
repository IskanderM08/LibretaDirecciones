package address.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    public void testGettersAndSetters() {
        //  una instancia de la clase Address
        Address address = new Address("California", "Los Angeles", "Main Street", "12345");

        // Verifica los valores iniciales utilizando los getters
        Assertions.assertEquals("California", address.getStateName());
        Assertions.assertEquals("Los Angeles", address.getCityName());
        Assertions.assertEquals("Main Street", address.getStreetName());
        Assertions.assertEquals("12345", address.getPostalCode());

        // Modifica los valores utilizando los setters
        address.setStateName("New York");
        address.setCityName("New York City");
        address.setStreetName("Broadway");
        address.setPostalCode("67890");

        // Verifica los nuevos valores utilizando los getters
        Assertions.assertEquals("New York", address.getStateName());
        Assertions.assertEquals("New York City", address.getCityName());
        Assertions.assertEquals("Broadway", address.getStreetName());
        Assertions.assertEquals("67890", address.getPostalCode());
    }

    @Test
    public void testMethodToString() {
        // Crea una instancia de la clase Address con valores específicos
        Address address = new Address("California", "Los Angeles", "Main Street", "12345");

        // Verificar que el método toString devuelve el formato esperado
        Assertions.assertEquals(", Estado: California, Ciudad: Los Angeles, Calle: Main Street, Código Postal: 12345",
                address.toString());
    }

    @org.junit.jupiter.api.Test
    void getStateName() {
    }

    @org.junit.jupiter.api.Test
    void setStateName() {
    }

    @org.junit.jupiter.api.Test
    void getCityName() {
    }

    @org.junit.jupiter.api.Test
    void setCityName() {
    }

    @org.junit.jupiter.api.Test
    void getStreetName() {
    }

    @org.junit.jupiter.api.Test
    void setStreetName() {
    }

    @org.junit.jupiter.api.Test
    void getPostalCode() {
    }

    @org.junit.jupiter.api.Test
    void setPostalCode() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}