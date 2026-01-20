package core.repository;

import core.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentMap;

public interface FileConversion {
    public ConcurrentMap readFromFile();
    public void writeToFile() throws FileNotFoundException;
}
