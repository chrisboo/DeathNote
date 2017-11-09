package seedu.address.logic.commands;

import java.io.File;
import java.util.List;

import seedu.address.commons.core.EventsCenter;
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.events.ui.JumpToListRequestEvent;
import seedu.address.commons.events.ui.OpenAddressBookRequestEvent;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.person.ReadOnlyPerson;

//@@author chrisboo
/**
 * Open Address Book
 */
public class OpenCommand extends Command {

    public static final String COMMAND_WORD = "open";
    public static final String COMMAND_SHORT = "o";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Open a different DeathNote. \n"
        + "Paremeters: LOCATION \n"
        + "Example: " + COMMAND_WORD + " C:\\Users\\crispy\\Downloads\\DeathNote.xml";

    public static final String MESSAGE_OPEN_PERSON_SUCCESS = "Opened DeathNote: %1$s";

    private final File file;

    public OpenCommand(File file) {
        this.file = file;
    }

    @Override
    public CommandResult execute() throws CommandException {
        EventsCenter.getInstance().post(new OpenAddressBookRequestEvent(file));
        return new CommandResult(String.format(MESSAGE_OPEN_PERSON_SUCCESS, file.getPath()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof OpenCommand // instanceof handles nulls
            && this.file.equals(((OpenCommand) other).file)); // state check
    }
}
//@@author
