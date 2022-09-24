package main.java.DAO;

public interface DAO<T>{
    void createTable();

    void insert(T t);
}