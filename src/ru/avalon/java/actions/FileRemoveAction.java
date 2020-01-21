package ru.avalon.java.actions;

import java.io.File;

public class FileRemoveAction implements Action {
    private String filename;
    
    public FileRemoveAction(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void start() {
        new Thread(this).run();
    }

    @Override
    public void run() {
        File file = new File(filename);
        if (file.delete()) {
            System.out.printf("Файл %s успешно удален", filename);
        } else {
            System.out.printf("Файл с именем %s не найден", filename);
        }
    }

    @Override
    public void close() throws Exception {
        filename = null;
    }
    
}
