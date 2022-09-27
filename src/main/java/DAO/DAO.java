package main.java.DAO;

import org.apache.commons.csv.CSVRecord;

public interface DAO<T>{
    void createTable();

    void insert(CSVRecord row);
}
