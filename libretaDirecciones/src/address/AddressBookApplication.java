package address;

//Autor: Iskander Emilio Mercader Olivares

/*Esta clase funciona como la clase principal, donde se utiliza el método para desplegar el menú y crear la libreta de Direcciones. */

import address.data.AddressBook;

public class AddressBookApplication {
    public static void main(String[] args) {
        AddressBook newAddressBook = new AddressBook();
        Menu newMenu = new Menu(newAddressBook);
        newMenu.displayMenu();
    }
}