package address.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest {
    @Test
    public void testGettersAndSetters() {
        // Crear una instancia de la clase Address
        Address address = new Address("California", "Los Angeles", "Main Street", "12345");

        // Crear una instancia de la clase AddressEntry
        AddressEntry entry = new AddressEntry("John", "Doe", address, "1234567890", "john.doe@example.com");

        // Verificar los valores iniciales utilizando los getters
        Assertions.assertEquals("John", entry.getFirstName());
        Assertions.assertEquals("Doe", entry.getLastName());
        Assertions.assertEquals(address, entry.getNewAddress());
        Assertions.assertEquals("1234567890", entry.getPhoneNumber());
        Assertions.assertEquals("john.doe@example.com", entry.getUserEmail());

        // Modificar los valores utilizando los setters
        Address newAddress = new Address("New York", "New York City", "Broadway", "67890");
        entry.setFirstName("Jane");
        entry.setLastName("Smith");
        entry.setAddress(newAddress);
        entry.setPhoneNumber("9876543210");
        entry.setUserEmail("jane.smith@example.com");

        // Verificar los nuevos valores utilizando los getters
        Assertions.assertEquals("Jane", entry.getFirstName());
        Assertions.assertEquals("Smith", entry.getLastName());
        Assertions.assertEquals(newAddress, entry.getNewAddress());
        Assertions.assertEquals("9876543210", entry.getPhoneNumber());
        Assertions.assertEquals("jane.smith@example.com", entry.getUserEmail());
    }

    @Test
    public void testMethodToString() {
        // Crear una instancia de la clase Address
        Address address = new Address("California", "Los Angeles", "Main Street", "12345");

        // Crear una instancia de la clase AddressEntry con valores específicos
        AddressEntry entry = new AddressEntry("John", "Doe", address, "1234567890", "john.doe@example.com");

        // Verificar que el método toString devuelve el formato esperado
        String expectedString = "*Nombre: John, Apellido: Doe" + address.toString() +
                ", \nTeléfono: 1234567890, Correo electrónico: john.doe@example.com";
        Assertions.assertEquals(expectedString, entry.toString());
    }

    @org.junit.jupiter.api.Test
    void setFirstName() {
    }

    @org.junit.jupiter.api.Test
    void setLastName() {
    }

    @org.junit.jupiter.api.Test
    void setAddress() {
    }

    @org.junit.jupiter.api.Test
    void setPhoneNumber() {
    }

    @org.junit.jupiter.api.Test
    void setUserEmail() {
    }

    @org.junit.jupiter.api.Test
    void getFirstName() {
    }

    @org.junit.jupiter.api.Test
    void getLastName() {
    }

    @org.junit.jupiter.api.Test
    void getNewAddress() {
    }

    @org.junit.jupiter.api.Test
    void getPhoneNumber() {
    }

    @org.junit.jupiter.api.Test
    void getUserEmail() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}