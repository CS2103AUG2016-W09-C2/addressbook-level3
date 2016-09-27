package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.UniquePersonList.DuplicatePersonException;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

public class UndoCommand extends Command{
	
    public static final String COMMAND_WORD = "undo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Undo your most recent command which modified the addressbook.\n\t"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_UNDO_SUCCESS = "Undo succeeded.";
    public static final String MESSAGE_UNDO_FAIL = "Nothing to undo.";
    public boolean disable;

	@Override
	public CommandResult execute() {
		// TODO Auto-generated method stub
		try{
			addressBook.undoOperation();
			return new CommandResult(MESSAGE_UNDO_SUCCESS);
		} catch (DuplicatePersonException dpe){
			return new CommandResult(AddCommand.MESSAGE_DUPLICATE_PERSON);
		} catch (PersonNotFoundException npe){
			return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
		} catch (IllegalArgumentException e){
			return new CommandResult(MESSAGE_UNDO_FAIL);
		}
	}

}
