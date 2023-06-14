package address;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import address.data.Address;
import address.data.AddressBook;
import address.data.AddressEntry;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private AddressBook addressBook;
    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @BeforeEach
    public void setup() {
        addressBook = new AddressBook();
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void testDisplayMenu_AddEntry() {
        String input = "2\nJohn\nDoe\nCalifornia\nLos Angeles\nMain Street\n12345\n1234567890\njohn.doe@example.com\n5\n6\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        Menu menu = new Menu(addressBook);
        menu.displayMenu();

        List<AddressEntry> entries = addressBook.displayEntries();
        Assertions.assertEquals(1, entries.size());

        AddressEntry entry = entries.get(0);
        Assertions.assertEquals("John", entry.getFirstName());
        Assertions.assertEquals("Doe", entry.getLastName());
        Assertions.assertEquals("California", entry.getNewAddress().getStateName());
        Assertions.assertEquals("Los Angeles", entry.getNewAddress().getCityName());
        Assertions.assertEquals("Main Street", entry.getNewAddress().getStreetName());
        Assertions.assertEquals("12345", entry.getNewAddress().getPostalCode());
        Assertions.assertEquals("1234567890", entry.getPhoneNumber());
        Assertions.assertEquals("john.doe@example.com", entry.getUserEmail());
    }

    @Test
    public void testDisplayMenu_RemoveEntry() {
        Address address = new Address("California", "Los Angeles", "Main Street", "12345");
        AddressEntry entry = new AddressEntry("John", "Doe", address, "1234567890", "john.doe@example.com");
        addressBook.addEntry(entry);

        String input = "3\nDoe\n5\n6\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        Menu menu = new Menu(addressBook);
        menu.displayMenu();

        List<AddressEntry> entries = addressBook.displayEntries();
        Assertions.assertEquals(0, entries.size());
    }

    @Test
    public void testDisplayMenu_SearchEntry() {
        Address address = new Address("California", "Los Angeles", "Main Street", "12345");
        AddressEntry entry = new AddressEntry("John", "Doe", address, "1234567890", "john.doe@example.com");
        addressBook.addEntry(entry);

        String input = "4\nDoe\n5\n6\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        Menu menu = new Menu(addressBook);
        menu.displayMenu();

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Entrada encontrada"));
        Assertions.assertTrue(output.contains("John Doe"));
    }

    @Test
    public void testDisplayMenu_LoadFromFile() throws IOException {
        String filePath = "test_entries.txt";
        addressBook.readEntries(filePath);

        String input = "1\n" + filePath + "\n5\n6\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        Menu menu = new Menu(addressBook);
        menu.displayMenu();

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Las entradas se cargaron desde el archivo"));
    }

    @org.junit.jupiter.api.Test
    void displayMenu() {
    }
}