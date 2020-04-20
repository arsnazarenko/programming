package client.commandProducers;

import client.servises.IObjectCreator;
import client.servises.ObjectCreator;
import library.clientCommands.Command;
import library.clientCommands.commandType.AddIfMinCommand;

import java.util.Scanner;

public class AddIfMinCommandProd implements StandardCommandProducer, ScanProperties {
    private IObjectCreator objectCreator;
    private Scanner scanner = null;

    public AddIfMinCommandProd(IObjectCreator objectCreator) {
        this.objectCreator = objectCreator;
    }

    @Override
    public void setReaderForCreate(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Command createCommand() {
        if (scanner != null) {
            return new AddIfMinCommand(objectCreator.create(scanner));
        } else {
            return null;
        }
    }
}
