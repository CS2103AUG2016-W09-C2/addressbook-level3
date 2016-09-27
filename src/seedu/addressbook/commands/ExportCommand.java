package seedu.addressbook.commands;

import seedu.addressbook.logic.Logic;
import seedu.addressbook.storage.StorageFile;
import seedu.addressbook.storage.StorageFile.InvalidStorageFilePathException;
import seedu.addressbook.storage.StorageFile.StorageOperationException;

public class ExportCommand extends Command{
	
	public static final String COMMAND_WORD = "export";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Exports addressBook to specified directory."
            + "Parameters: FILEPATH\n\t"
            + "Example: " + COMMAND_WORD + " c://data/addressbook.txt";
    public static final String MESSAGE_EXPORT_SUCCESS = "Successfully export the addressBook to ";
    public static final String MESSAGE_EXPORT_FAIL = "Export failed.";
    
    private final String directory;
    
    public ExportCommand(String directory){
    	this.directory = directory;
    }

	@Override
	public CommandResult execute() {
		// TODO Auto-generated method stub
		StorageFile.DEFAULT_STORAGE_FILEPATH = directory;
		try {
			StorageFile newFile = new StorageFile(directory);
			newFile.save(addressBook);
			return new CommandResult(MESSAGE_EXPORT_SUCCESS + directory);
		} catch (InvalidStorageFilePathException e) {
			// TODO Auto-generated catch block
			return new CommandResult(MESSAGE_EXPORT_FAIL);
		} catch (StorageOperationException e) {
			// TODO Auto-generated catch block
			return new CommandResult(MESSAGE_EXPORT_FAIL);
		}
		
		
	}
	
}
