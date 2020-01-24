package ru.avalon.java;

import java.util.Arrays;

/**
 * Обрабатываемые приложением команды.
 */
public class Commands {

    public enum Command {
        move,
        copy,
        exit,
        create,
        remove
    }

    public Command command;
    public String[] params;
    
    public Commands(String input) throws IllegalCommand {
        String[] parts = input.trim().split(" +");
        switch (parts[0]) {
            case "move":
                command = Command.move;
                break;
            case "copy":
                command = Command.copy;
                break;
            case "exit":
                command = Command.exit;
                break;
            case "create":
                command = Command.create;
                break;
            case "remove":
                command = Command.remove;
                break;
            default:
                throw new IllegalCommand("Не удалось распознать команду: "
                        + input);
        }
        params = Arrays.copyOfRange(parts, 1, parts.length);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder(command.toString() +
                ". Параметры: ");
        for (String param : params) {
            sb.append(" ").append(param);
        }
        return sb.toString();
    }
}
