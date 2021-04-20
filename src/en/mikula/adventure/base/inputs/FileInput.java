package en.mikula.adventure.base.inputs;

import en.mikula.adventure.exceptions.EndOfTheFileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Marek Mikula
 * @version 4/20/2021
 */
public class FileInput implements Input {

    private final BufferedReader reader;

    public FileInput(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
    }

    @Override
    public String readLine() throws EndOfTheFileException {
        String line;

        try {
            line = reader.readLine();

            // Close the reader if empty
            if (line == null) {
                this.reader.close();
            }
        } catch (IOException e) {
            return null;
        }

        if (line == null) {
            throw new EndOfTheFileException("The programme hit the end of the command file!");
        }

        return line;
    }

}
