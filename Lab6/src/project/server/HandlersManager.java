package project.server;

import project.client.commands.Command;
import project.client.commands.commandType.*;
import project.server.handlers.*;

import java.util.HashMap;
import java.util.Map;

public class HandlersManager {
    private CollectionManager collectionManager;
    private Map<Class<?>, ICommandHandler> handlers;
    private FieldSetter fieldSetter;

    public HandlersManager(CollectionManager collectionManager, FieldSetter fieldSetter) {
        this.collectionManager = collectionManager;
        this.handlers = new HashMap<Class<?>, ICommandHandler>() {{
            put(ExitCommand.class, new ExitCommandHandler());
            put(AddCommand.class, new AddCommandHandler(collectionManager, fieldSetter));
            put(InfoCommand.class, new InfoCommandHandler(collectionManager));
            put(HelpCommand.class, new HelpCommandHandler());
            put(PrintAscendingCommand.class, new PrintAscendingCommandHandler(collectionManager));
            put(RemoveIdCommand.class, new RemoveIdCommandHandler(collectionManager));
            put(RemoveLowerCommand.class, new RemoveLowerCommandHandler(collectionManager));
            put(AddIfMinCommand.class, new AddIfMinCommandHandler(collectionManager, fieldSetter));
            put(FilterContainsNameCommand.class, new FilterContainsNameCommandHandler(collectionManager));
            put(HeadCommand.class, new HeadCommandHandler(collectionManager));
            put(MaxByEmployeeCommand.class, new MaxByEmployeeCommandHandler(collectionManager));
            put(SaveCommand.class, new SaveCommandHandler(collectionManager));
            put(ShowCommand.class, new ShowCommandHandler(collectionManager));
            put(UpdateIdCommand.class, new UpdateIdCommandHandler(collectionManager, fieldSetter));
            put(ClearCommand.class, new ClearCommandHandler(collectionManager));
            put(ExecuteScriptCommand.class, new ExecuteScriptCommandHandler());
        }};
    }



    public String handling(Command command) {
        return handlers.get(command.getClass()).processCommand(command);
    }

    //метод, который выполняет метод commandProcess, возвращает строку - ответ каждой команды

    //public static void main(String[] args) {
    //    CollectionManager collectionManager = new CollectionManager();
    //    System.out.println(collectionManager);
    //    HandlersManager handlersManager = new HandlersManager(collectionManager, new FieldSetter());
    //    ICommandHandler h = handlersManager.handlers.get(AddCommand.class);
    //    AddCommandHandler ah = (AddCommandHandler) h;
    //    System.out.println("awdawd" + ah.getCollectionManager());
    //}
}