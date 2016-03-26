package com.company;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by alexandra on 25.3.16.
 */
public class CommandProcessor {

    private static final String MSG_COMMAND_NOT_FOUND = "Command not found";
    private static final String MSG_DELIM = "==========================================";

    private Map<String, Command> commands;

    private String consoleEncoding;

    public CommandProcessor(String consoleEncoding) {
        commands = new TreeMap<>();
        Command cmd = new HelpCommand();
        commands.put(cmd.getName(), cmd);
        cmd = new DirCommand();
        commands.put(cmd.getName(), cmd);
        cmd = new ExitCommand();
        commands.put(cmd.getName(), cmd);
        this.consoleEncoding = consoleEncoding;
    }

    public void execute() {
        Context c = new Context();
        c.currentDirectory = new File(".").getAbsoluteFile();
        boolean result = true;
        Scanner scanner = new Scanner(System.in, consoleEncoding);
        do {
            System.out.print("> ");
            String fullCommand = scanner.nextLine();
            ParsedCommand pc = new ParsedCommand(fullCommand);
            if (pc.command == null || "".equals(pc.command)) {
                continue;
            }
            Command cmd = commands.get(pc.command.toUpperCase());
            if (cmd == null) {
                System.out.println(MSG_COMMAND_NOT_FOUND);
                continue;
            }
            result = cmd.execute(c, pc.args);
        } while (result);
    }

    public static void main(String[] args) {
        CommandProcessor cp = new CommandProcessor("Cp1251");
        cp.execute();
    }


    class ParsedCommand {

        String command;

        String[] args;

        public ParsedCommand(String line) {
            String parts[] = line.split(" ");
            if (parts != null) {
                command = parts[0];
                if (parts.length > 1) {
                    args = new String[parts.length - 1];
                    System.arraycopy(parts, 1, args, 0, args.length);
                }
            }
        }
    }

    interface Command {

        boolean execute(Context context, String... args);

        void printHelp();

        String getName();

        String getDescription();
    }

    class Context {

        private File currentDirectory;

    }

    class HelpCommand implements Command {

        @Override
        public boolean execute(Context context, String... args) {
            if (args == null) {
                System.out.println("Avaliable commands:\n" + MSG_DELIM);
                for (Command cmd : commands.values()) {
                    System.out.println(cmd.getName() + ": " + cmd.getDescription());
                }
                System.out.println(MSG_DELIM);
            } else {
                for (String cmd : args) {
                    System.out.println("Help for command " + cmd + ":\n" + MSG_DELIM);
                    Command command = commands.get(cmd.toUpperCase());
                    if (command == null) {
                        System.out.println(MSG_COMMAND_NOT_FOUND);
                    } else {
                        command.printHelp();
                    }
                    System.out.println(MSG_DELIM);
                }
            }
            return true;
        }

        @Override
        public void printHelp() {
            System.out.println(getDescription());
        }

        @Override
        public String getName() {
            return "HELP";
        }

        @Override
        public String getDescription() {
            return "Prints list of available commands";
        }
    }

    class DirCommand implements Command {

        @Override
        public void printHelp() {
            System.out.println(getDescription());
        }

        @Override
        public boolean execute(Context context, String... args) {
            if (args == null) {
                // print current directory content
                printDir(context.currentDirectory);
            } else {
                // print specified directory content
                // todo
            }
            return true;
        }

        @Override
        public String getName() {
            return "DIR";
        }

        private void printDir(File dir) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File f : files) {
                    System.out.println(f.getName());
                }
            }
        }

        @Override
        public String getDescription() {
            return "Prints directory content";
        }
    }

    class ExitCommand implements Command {
        @Override
        public boolean execute(Context context, String... args) {
            System.out.println("Finishing command processor... done.");
            return false;
        }

        @Override
        public void printHelp() {
            System.out.println(getDescription());
        }

        @Override
        public String getName() {
            return "EXIT";
        }

        @Override
        public String getDescription() {
            return "Exits from command processor";
        }
    }
}
