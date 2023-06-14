package address;

//Autor: Iskander Emilio Mercader Olivares

/* En esta sección se declarán las librerías donde se relacionarán ambos paquetes del proyecto */
import java.util.Scanner;
import address.data.AddressBook;
import address.data.AddressEntry;
import address.data.Address;
import java.io.IOException;

/* En esta sección se crea una nueva libreta de direcciones la cual funcionará en conjunto con las opciones del menú*/

public class Menu {
    private AddressBook newAddressBook;
    private Scanner reader;

    public Menu(AddressBook newAddressBook) {
        this.newAddressBook = newAddressBook;
        reader = new Scanner(System.in);
    }

    /* En esta sección se declara el método donde el menú mostrará las opciones disponibles y el usuario declarará la que busque realizar*/

    public void displayMenu() {
        int optionSelector = 0;
        int minOption = 1;
        int maxOption = 6;
        boolean optionComprobation = false;
        boolean exitApplication = false;

        while (!exitApplication) {
            System.out.println("========Menu========");
            System.out.println("(1) Cargar desde archivo");
            System.out.println("(2) Agregar entrada");
            System.out.println("(3) Eliminar entrada");
            System.out.println("(4) Buscar por apellido");
            System.out.println("(5) Mostrar todas las entradas");
            System.out.println("(6) Salir");

            do{
                try{
                    System.out.print("Ingrese la opción que busca realizar: ");
                    optionSelector = reader.nextInt();
                    optionComprobation = true;
                    if(optionSelector<minOption||optionSelector>maxOption){
                        System.out.println("Error, debe ingresar un número entero entre " + minOption + " y " + maxOption);
                        optionComprobation=false;
                    }
                }catch(Exception e){
                    System.out.println("Error, debe ingresar un número entero entre " + minOption + " y " + maxOption);
                    optionComprobation=false;
                    reader.next();
                }
            }while(!optionComprobation);

            reader.nextLine();

            /* En esta sección se declaran los métodos que el usuario podrá realizar con la libreta de direcciones,
                en este caso importar, agregar, eliminar, mostrar y buscar entradas, además de la función Salir.*/

            switch (optionSelector) {
                case 1:
                    System.out.print("Ingrese la ruta del archivo: ");
                    String filePath = reader.nextLine();

                    if (!validateString(filePath)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }

                    try {
                        newAddressBook.readEntries(filePath);
                        System.out.println("Las entradas se cargaron desde el archivo");
                    } catch (IOException e) {
                        System.out.println("Error, Ruta de archivo incorrecta");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre: ");
                    String firstName = reader.nextLine();
                    if (!validateString(firstName)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }

                    System.out.print("Ingrese el apellido: ");
                    String lastName = reader.nextLine();
                    if (!validateString(lastName)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }

                    System.out.print("Ingrese el nombre del estado: ");
                    String stateName = reader.nextLine();
                    if (!validateString(stateName)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }

                    System.out.print("Ingrese el nombre de la ciudad: ");
                    String cityName = reader.nextLine();
                    if (!validateString(cityName)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }

                    System.out.print("Ingrese el nombre de la calle: ");
                    String streetName = reader.nextLine();
                    if (!validateString(streetName)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }

                    System.out.print("Ingrese el código postal: ");
                    String postalCode = reader.nextLine();
                    if (!validateString(postalCode)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }

                    System.out.print("Ingrese el número de teléfono: ");
                    String phoneNumber = reader.nextLine();
                    if (!validateString(phoneNumber)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }

                    System.out.print("Ingrese el correo electrónico: ");
                    String userEmail = reader.nextLine();
                    if (!validateString(userEmail)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }

                    var address = new Address(stateName, cityName, streetName, postalCode);
                    AddressEntry newEntry = new AddressEntry(firstName, lastName, address, phoneNumber, userEmail);

                    newAddressBook.addEntry(newEntry);
                    System.out.println("La entrada se agregó correctamente");
                    break;

                case 3:
                    System.out.print("Ingrese el apellido de la entrada a eliminar: ");
                    String lastNameToDelete = reader.nextLine();
                    if (!validateString(lastNameToDelete)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }
                    AddressEntry entryToDelete = searchEntry(lastNameToDelete);
                    if (entryToDelete != null) {
                        newAddressBook.removeEntry(entryToDelete);
                        System.out.println("La entrada se eliminó correctamente");
                    } else {
                        System.out.println("No se encontró ninguna entrada con el apellido proporcionado");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el apellido a buscar: ");
                    String lastNameToSearch = reader.nextLine();
                    if (!validateString(lastNameToSearch)) {
                        System.out.println("Error, ningún campo puede estar vacío");
                        break;
                    }
                    AddressEntry foundEntry = searchEntry(lastNameToSearch);
                    if (foundEntry != null) {
                        System.out.println("Entrada encontrada");
                        System.out.println(foundEntry);
                    } else {
                        System.out.println("No se encontró ninguna entrada con el apellido proporcionado");
                    }
                    break;
                case 5:
                    System.out.println("========Entradas========");
                    for (AddressEntry entryList : newAddressBook.displayEntries()) {
                        System.out.println(entryList);
                    }
                    break;
                case 6:
                    exitApplication = true;
                    System.out.println("====================");
                    System.out.println("Muchas gracias por utilizar el programa");
                    break;
            }
        }

        System.out.println();
        reader.close();
    }

    /* En esta sección se declaran los métodos donde se buscará una entrada por medio del apellido y se validará si las cadenas están vacías. */

    private AddressEntry searchEntry(String lastName) {
        for (AddressEntry foundEntry : newAddressBook.displayEntries()) {
            if (foundEntry.getLastName().equalsIgnoreCase(lastName)) {
                return foundEntry;
            }
        }
        return null;
    }

    private boolean validateString(String stringState) {
        return !stringState.trim().isEmpty();
    }
}
