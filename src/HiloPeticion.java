import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by dremon on 10/02/16.
 */
public class HiloPeticion extends Thread{

    Socket socketescuchado;

    public HiloPeticion(Socket s){

        socketescuchado = s;

    }

    @Override
    public void run() {
        System.out.println("Se ha recibido una llamada!");
        try {
            InputStream is = socketescuchado.getInputStream();
            OutputStream os = socketescuchado.getOutputStream();
            byte[] mensaje = new byte[6000];
            is.read(mensaje);
            System.out.println("mensaje recibido: " + new String(mensaje));
            System.out.println(socketescuchado.getInetAddress().toString());
            System.out.println("Cerrando!");
            os.write("Adeu!".getBytes());
            socketescuchado.close();
            is.close();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
