package com.epam.command;

import java.util.HashMap;
import java.util.Map;

import com.epam.command.impl.AddCommand;
import com.epam.command.impl.AddEMailCommand;
import com.epam.command.impl.AddSignCommand;
import com.epam.command.impl.AddTitleCommand;
import com.epam.command.impl.ChangeCommand;
import com.epam.command.impl.CloneCommand;
import com.epam.command.impl.DeleteAllCommand;
import com.epam.command.impl.DeleteCommand;
import com.epam.command.impl.FindCommand;
import com.epam.command.impl.FindDateCommand;
import com.epam.command.impl.FindEMailCommand;
import com.epam.command.impl.FindNoteCommand;
import com.epam.command.impl.FindSignCommand;
import com.epam.command.impl.FindTitleCommand;
import com.epam.command.impl.FormatCommand;
import com.epam.command.impl.ReplaceCommand;
import com.epam.command.impl.SortCommand;

public class CommandHelper {

	private Map<CommandName, Command> commands = new HashMap<>();

    public CommandHelper(){ 
                    commands.put(CommandName.ADD, new AddCommand());
                    commands.put(CommandName.ADD_EMAIL_NOTE, new AddEMailCommand());
                    commands.put(CommandName.ADD_SIGN_NOTE, new AddSignCommand());
                    commands.put(CommandName.ADD_TITLE_NOTE, new AddTitleCommand());
                    
                    commands.put(CommandName.DETETE, new DeleteCommand());
                    commands.put(CommandName.DELETE_ALL, new DeleteAllCommand());
                    
                    commands.put(CommandName.FIND, new FindCommand());
                    commands.put(CommandName.FIND_BY_DATE, new FindDateCommand());
                    commands.put(CommandName.FIND_BY_EMAIL, new FindEMailCommand());
                    commands.put(CommandName.FIND_BY_NOTE, new FindNoteCommand());
                    commands.put(CommandName.FIND_BY_SIGN, new FindSignCommand());
                    commands.put(CommandName.FIND_BY_TITLE, new FindTitleCommand());
                    
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
