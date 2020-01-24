package ru.avalon.java;

import ru.avalon.java.console.ConsoleUI;

import java.io.IOException;
import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileCreateAction;
import ru.avalon.java.actions.FileMoveAction;
import ru.avalon.java.actions.FileRemoveAction;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI {
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        new Lab3().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
//    Lab3() {
//        super(Commands.class);
//    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command.command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */
                new FileCopyAction(command.params[0], command.params[1]).start();
                System.out.println("Запущено копирование");
                break;
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */
                new FileMoveAction(command.params[0], command.params[1]).start();
                break;
            case exit:
                close();
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
            case create:
                new FileCreateAction(command.params[0]).start();
                break;
            case remove:
                new FileRemoveAction(command.params[0]).start();
                break;
        }
    }
    
}
