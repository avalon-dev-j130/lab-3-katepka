package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    private Path source;
    private Path destination;
    
    public FileCopyAction(String source, String destination) {
        this.source = Paths.get(source);
        this.destination = Paths.get(destination);
    }
    
    @Override
    public void start() {
        new Thread(this).start();
        System.out.println("Запуск потока копирования файла");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */
        try {
            Files.copy(source, destination, StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException ex) {
            Logger.getLogger(FileCopyAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ошибка копирования");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        source = null;
        destination = null;        
    }
}
