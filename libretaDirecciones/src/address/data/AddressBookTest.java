package address.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    @Test
    public void testAddAndRemoveEntry() {
        // Crear una instancia de la clase Address
        Address address = new Address("California", "Los Angeles", "Main Street", "12345");

        // Crear una instancia de la clase AddressEntry
        AddressEntry entry = new AddressEntry("John", "Doe", address, "1234567890", "john.doe@example.com");

        // Crear una instancia de la clase AddressBook
        AddressBook addressBook = new AddressBook();

        // Agregar la entrada al libro de direcciones
        addressBook.addEntry(entry);

        // Verificar que la entrada se haya agregado correctamente
        List<AddressEntry> entries = addressBook.displayEntries();
        Assertions.assertEquals(1, entries.size());
        Assertions.assertEquals(entry, entries.get(0));

        // Eliminar la entrada del libro de direcciones
        addressBook.removeEntry(entry);

        // Verificar que la entrada se haya eliminado correctamente
        entries = addressBook.displayEntries();
        Assertions.assertEquals(0, entries.size());
    }

    @Test
    public void testDisplayEntries() {
        // Crear instancias de la clase Address
        Address address1 = new Address("California", "Los Angeles", "Main Street", "12345");
        Address address2 = new Address("New York", "New York City", "Broadway", "67890");

        // Crear instancias de la clase AddressEntry
        AddressEntry entry1 = new AddressEntry("John", "Doe", address1, "1234567890", "john.doe@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "Smith", address2, "9876543210", "jane.smith@example.com");

        // Crear una instancia de la clase AddressBook
        AddressBook addressBook = new AddressBook();

        // Agregar las entradas al libro de direcciones
        addressBook.addEntry(entry1);
        addressBook.addEntry(entry2);

        // Obtener las entradas ordenadas alfabéticamente
        List<AddressEntry> entries = addressBook.displayEntries();

        // Verificar el orden de las entradas
        Assertions.assertEquals(entry1, entries.get(0));
        Assertions.assertEquals(entry2, entries.get(1));
    }

    @Test
    public void testReadEntries() {
        // Crear una instancia de la clase AddressBook
        AddressBook addressBook = new AddressBook();

        // Leer las entradas de un archivo de prueba
        String filePath = "test_entries.txt";
        try {
            addressBook.readEntries(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Obtener las entradas del libro de direcciones
        List<AddressEntry> entries = addressBook.displayEntries();

        // Verificar la cantidad de entradas leídas
        Assertions.assertEquals(2, entries.size());

        // Verificar los atributos de la primera entrada
        AddressEntry entry1 = entries.get(0);
        Assertions.assertEquals("John", entry1.getFirstName());
        Assertions.assertEquals("Doe", entry1.getLastName());
        Assertions.assertEquals("California", entry1.getNewAddress().getStateName());
        Assertions.assertEquals("Los Angeles", entry1.getNewAddress().getCityName());
        Assertions.assertEquals("Main Street", entry1.getNewAddress().getStreetName());
        Assertions.assertEquals("12345", entry1.getNewAddress().getPostalCode());
        Assertions.assertEquals("1234567890", entry1.getPhoneNumber());
        Assertions.assertEquals("john.doe@example.com", entry1.getUserEmail());

        // Verificar los atributos de la segunda entrada
        AddressEntry entry2 = entries.get(1);
        Assertions.assertEquals("Jane", entry2.getFirstName());
        Assertions.assertEquals("Smith", entry2.getLastName());
        Assertions.assertEquals("New York", entry2.getNewAddress().getStateName());
        Assertions.assertEquals("New York City", entry2.getNewAddress().getCityName());
        Assertions.assertEquals("Broadway", entry2.getNewAddress().getStreetName());
        Assertions.assertEquals("67890", entry2.getNewAddress().getPostalCode());
        Assertions.assertEquals("9876543210", entry2.getPhoneNumber());
        Assertions.assertEquals("jane.smith@example.com", entry2.getUserEmail());
    }

    @Test
    public void testSearchEntry() {
        // Crear instancias de la clase Address
        Address address1 = new Address("California", "Los Angeles", "Main Street", "12345");
        Address address2 = new Address("New York", "New York City", "Broadway", "67890");

        // Crear instancias de la clase AddressEntry
        AddressEntry entry1 = new AddressEntry("John", "Doe", address1, "1234567890", "john.doe@example.com");
        AddressEntry entry2 = new AddressEntry("Jane", "Smith", address2, "9876543210", "jane.smith@example.com");

        // Crear una instancia de la clase AddressBook
        AddressBook addressBook = new AddressBook();

        // Agregar las entradas al libro de direcciones
        addressBook.addEntry(entry1);
        addressBook.addEntry(entry2);

        // Buscar entradas por apellido
        List<AddressEntry> foundEntries = addressBook.searchEntry("Doe");

        // Verificar la cantidad de entradas encontradas
        Assertions.assertEquals(1, foundEntries.size());

        // Verificar que se haya encontrado la entrada correcta
        Assertions.assertEquals(entry1, foundEntries.get(0));
    }


    @org.junit.jupiter.api.Test
    void addEntry() {
    }

    @org.junit.jupiter.api.Test
    void removeEntry() {
    }

    @org.junit.jupiter.api.Test
    void displayEntries() {
    }

    @org.junit.jupiter.api.Test
    void readEntries() {
    }

    @org.junit.jupiter.api.Test
    void searchEntry() {
    }
}