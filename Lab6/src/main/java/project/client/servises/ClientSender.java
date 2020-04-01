package project.client.servises;
import project.client.serialization.SerializationManager;

import java.io.IOException;
import java.io.Serializable;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ClientSender implements IClientSender{
    private SerializationManager serializationManager;
    private DatagramChannel datagramChannel;

    public ClientSender(DatagramChannel datagramChannel, SerializationManager serializationManager) {
        this.datagramChannel = datagramChannel;
        this.serializationManager = serializationManager;
    }

    public void send(Serializable letter, SocketAddress address) {
        try {
            ByteBuffer buffer = ByteBuffer.wrap(serializationManager.objectSerial(letter));
            datagramChannel.send(buffer, address);
            buffer.clear();
        } catch (IOException e) {
            System.out.println("ОШИБКА АДРЕСА");
        }

    }

    public SerializationManager getSerializationManager() {
        return serializationManager;
    }

    public void setSerializationManager(SerializationManager serializationManager) {
        this.serializationManager = serializationManager;
    }

    public DatagramChannel getDatagramChannel() {
        return datagramChannel;
    }

    public void setDatagramChannel(DatagramChannel datagramChannel) {
        this.datagramChannel = datagramChannel;
    }
}