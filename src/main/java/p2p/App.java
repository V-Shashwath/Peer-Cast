package p2p;

import p2p.controller.FileController;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try {
            FileController fileController = new FileController(8081);
            fileController.start();
            System.out.println("PeerCast server started on port 8081");
            System.out.println("UI available at http://localhost:3000");
            Runtime.getRuntime().addShutdownHook(
                    new Thread(
                            () -> {
                                System.out.println("Shutting down the server");
                                fileController.stop();
                            }
                    )
            );
            System.out.println("Press Enter to stop the server");
            System.in.read();

        } catch (Exception ex) {
            System.err.println("Failed to start the server at port: 8081 ");
            ex.printStackTrace();
        }


    }
}
