package org.bukkit.command.defaults;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public abstract class VanillaCommand extends Command {
    protected VanillaCommand(String name) {
        super(name);
    }

    protected VanillaCommand(String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }

    public boolean matches(String input) {
        return input.equalsIgnoreCase(this.getName());
    }

    protected int getInteger(CommandSender sender, String value, int min) {
        return getInteger(sender, value, min, Integer.MAX_VALUE);
    }

    protected int getInteger(CommandSender sender, String value, int min, int max) {
        int i = min;

        try {
            i = Integer.valueOf(value);
        } catch (NumberFormatException ex) {}

        if (i < min) {
            i = min;
        } else if (i > max) {
            i = max;
        }

        return i;
    }

    public static double getDouble(CommandSender sender, String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException ex) {
            return -30000001;
        }
    }

    public static double getDouble(CommandSender sender, String input, double min, double max) {
        double result = getDouble(sender, input);

        if (result < min) {
            result = min;
        } else if (result > max) {
            result = max;
        }

        return result;
    }

    String createString(String[] args, int start) {
        return createString(args, start, " ");
    }

    String createString(String[] args, int start, String glue) {
        StringBuilder string = new StringBuilder();

        for (int x = start; x < args.length; x++) {
            string.append(args[x]);
            if (x != args.length - 1) {
                string.append(glue);
            }
        }

        return string.toString();
    }
}
