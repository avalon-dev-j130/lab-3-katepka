package ru.avalon.java.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    
    private Path source;
    private Path destination;
    
    public FileMoveAction(String source, String destination) {
        this.source = Paths.get(source);
        this.destination = Paths.get(destination);
    }
    
    
    public void start() {
        new Thread(this).run();
        System.out.println("Запущен поток перемещения файла");
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        try {       
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.printf("Файл %s перемещен успешно в директорию %s",
                              source, destination);
        } catch (IOException ex) {
            Logger.getLogger(FileMoveAction.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ошибка перемещения");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        source = null;
        destination = null;
    }

}
