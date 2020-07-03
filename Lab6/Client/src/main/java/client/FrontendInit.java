package client;

import client.commandProducers.ClearCommandProd;
import client.servises.ArgumentValidateManager;
import client.servises.MessageService;
import client.servises.ObjectDataValidator;
import frontend.ClientManager;
import frontend.graphicsInterface.Menu;
import frontend.graphicsInterface.controllers.Controllers;
import frontend.graphicsInterface.loginForm.LogInWindow;
import frontend.mvc.ObjectCreatorUI;
import frontend.mvc.OrganizationController;
import frontend.mvc.OrganizationView;

import java.util.Locale;
import java.util.stream.Collectors;

public class FrontendInit {
    private ClientManager clientManager;
    private final Locale DEFAULT_LOCALE = new Locale("ru");
    private final String FONT = "Century Gothic";
    private Menu menu;
    private LogInWindow logInWindow;
    private Controllers controllers;


    public FrontendInit(MessageService messageService, ArgumentValidateManager argumentValidator) {

        menu = new Menu(DEFAULT_LOCALE, FONT);
        logInWindow = new LogInWindow(FONT,DEFAULT_LOCALE);
        clientManager = new ClientManager(messageService, argumentValidator);
        controllers = new Controllers(logInWindow,clientManager,menu,DEFAULT_LOCALE);
        controllers.setLogListeners();
        controllers.setMenuListeners();
        controllers.setWindowListener();
        logInWindow.setJMenuBar(menu);
        logInWindow.setVisible(true);
    }

    public synchronized Controllers getControllers() {
        return controllers;
    }
}
