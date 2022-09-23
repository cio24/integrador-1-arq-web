package main.java;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        CSVParser parser = null;
        try {
            parser = CSVFormat.DEFAULT.withHeader().parse(new
                    FileReader("resources/productos.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(CSVRecord row: parser) {
            System.out.println(row.get("idProducto"));
            System.out.println(row.get("nombre"));
            System.out.println(row.get("valor"));
        }
    }
}
