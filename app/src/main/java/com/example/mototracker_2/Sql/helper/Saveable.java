package com.example.mototracker_2.Sql.helper;

import java.util.List;

public interface Saveable<T> {
    public boolean addRecord(T record);
    public List<T> getAllRecords();
    public void updateRecord(T record);
    public void deleteRecord(T record);

}
