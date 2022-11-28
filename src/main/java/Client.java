import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.function.Consumer;
public class Client extends Thread{
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    private Consumer<Serializable> callback;

    Client(Consumer<Serializable> call){
        callback = call;
    }

    @Override
    public void run() {
        try {
            socket= new Socket("127.0.0.1",5555);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        }
        catch(Exception e) {}
    }

}

