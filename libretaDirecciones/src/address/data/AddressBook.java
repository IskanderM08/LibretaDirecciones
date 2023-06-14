package address.data;

//Autor: Iskander Emilio Mercader Olivares

/* En esta sección se declaran las librerías necesarias para declarar la estructura de Lista, la cual contendrá todas las entradas. */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/* En esta sección se declará la estructura de Lista, la cual fue escogida debido su tamaño dinámico que será fundamental en la
ejecución del programa, la facilidad para buscar los índices, los métodos y la eficiencia de la estructura en ejecución. */

public class AddressBook {
    private List<AddressEntry> userEntries;

    public AddressBook() {
        userEntries = new ArrayList<>();
    }

    /* En esta sección se declarán los métodos para agregar y eliminar entradas según busque el usuario. */

    public void addEntry(AddressEntry newEntry) {
        userEntries.add(newEntry);
    }

    public void removeEntry(AddressEntry newEntry) {
        userEntries.remove(newEntry);
    }

    /* En esta sección se declara el método para ordenar alfábeticamente y devolver todas las entradas del usuario. */

    public List<AddressEntry> displayEntries() {
        List<AddressEntry> sortedEntries = new ArrayList<>(userEntries);
        Collections.sort(sortedEntries, Comparator.comparing(AddressEntry::getLastName));
        return sortedEntries;
    }

    /* En esta sección se declara el método para leer entradas de archivos externos, mediante un lector que separa en orden los atributos necesarios. */

    public void readEntries(String filePath) throws IOException {
        File newFile = new File(filePath);
        if (!newFile.exists()) {
            throw new IOException("Ruta de archivo incorrecta");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(newFile))) {
            String newLine;
            int dataLengthLimit = 8;
            while ((newLine = reader.readLine()) != null) {
                String[] entryData = newLine.split(",");
                if (entryData.length == dataLengthLimit) {
                    Address newAddress = new Address(
                            entryData[2].trim(),
                            entryData[3].trim(),
                            entryData[4].trim(),
                            entryData[5].trim()
                    );

                    AddressEntry entry = new AddressEntry(
                            entryData[0].trim(),
                            entryData[1].trim(),
                            newAddress,
                            entryData[6].trim(),
                            entryData[7].trim()
                    );
                    userEntries.add(entry);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* En esta sección se declara el método para buscar entradas, donde buscará la entrada que contenga el apellido indicado por el usuario. */

    public List<AddressEntry> searchEntry(String lastName) {
        List<AddressEntry> foundEntry = new ArrayList<>();
        for (AddressEntry newEntry : userEntries) {
            if (newEntry.getLastName().equalsIgnoreCase(lastName)) {
                foundEntry.add(newEntry);
            }
        }
        return foundEntry;
    }
}
