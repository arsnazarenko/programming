package project.server.services;

import project.client.сlassModel.Organization;
import project.server.services.CollectionManager;
import project.server.services.JaxbWorker;

import java.io.File;
import java.util.Comparator;
import java.util.Deque;

public class XmlLoader {
    //формирование коллекции объектов из входного xml файла
    public static CollectionManager fromXmlToCollection(File file) {
        CollectionManager collectionManager = new CollectionManager();
        Deque<Organization> organizations =JaxbWorker.fromXmlToObject(file).getOrgCollection();
        //создание коллекции и установение значения счетчика объектов
        CollectionManager.OBJECT_ID_COUNTER = organizations.stream()
                .max(Comparator.comparing(Organization::getId))
                .map(Organization::getId).orElse(0L);
        collectionManager.setOrgCollection(organizations);
        return collectionManager;

    }
}