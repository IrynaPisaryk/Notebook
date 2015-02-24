package com.epam.command;

import java.util.HashMap;
import java.util.Map;

import com.epam.command.all.AddCommand;
import com.epam.command.all.AddEMailCommand;
import com.epam.command.all.AddSignCommand;
import com.epam.command.all.AddTitleCommand;
import com.epam.command.all.ChangeCommand;
import com.epam.command.all.CloneCommand;
import com.epam.command.all.DeleteAllCommand;
import com.epam.command.all.DeleteCommand;
import com.epam.command.all.FindByDateCommand;
import com.epam.command.all.FindByMailCommand;
import com.epam.command.all.FindByNoteCommand;
import com.epam.command.all.FindBySignCommand;
import com.epam.command.all.FindByTitleCommand;
import com.epam.command.all.FindNoteCommand;
import com.epam.command.all.FormatCommand;
import com.epam.command.all.ReplaceCommand;
import com.epam.command.all.SortCommand;

public class CommandHelper {

	private Map<CommandName, Command> commands = new HashMap<>();

    public CommandHelper(){ 
                    commands.put(CommandName.ADD, new AddCommand());
                    commands.put(CommandName.ADD_EMAIL, new AddEMailCommand());
                    commands.put(CommandName.ADD_SIGN, new AddSignCommand());
                    commands.put(CommandName.ADD_TITLE, new AddTitleCommand());
                    commands.put(CommandName.DETETE, new DeleteCommand());
                    commands.put(CommandName.DELETE_ALL, new DeleteAllCommand());
                    commands.put(CommandName.FIND, new FindNoteCommand());
                    commands.put(CommandName.FIND_TITLE, new FindByTitleCommand());
                    commands.put(CommandName.FIND_SIGN, new FindBySignCommand());
                    commands.put(CommandName.FIND_MAIL, new FindByMailCommand());
                    commands.put(CommandName.FIND_DATE, new FindByDateCommand());                    
                    commands.put(CommandName.FIND_NOTE, new FindByNoteCommand());
                    commands.put(CommandName.CHANGE, new ChangeCommand());
                    commands.put(CommandName.SORT, new SortCommand());
                    commands.put(CommandName.REPLACE, new ReplaceCommand());                    
                    commands.put(CommandName.CLONE, new CloneCommand());
                    commands.put(CommandName.FORMAT, new FormatCommand());
    }
    
    public Command getCommand(CommandName nameCommand){
                    Command command = commands.get(nameCommand);
                    return command;
    }
	
}
