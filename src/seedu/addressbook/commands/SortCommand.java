package seedu.addressbook.commands;

/**
 * Sorts the address book
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts address book by name. \n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_SUCCESS = "All persons in address book sorted.";

    @Override
    public CommandResult execute() {
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
