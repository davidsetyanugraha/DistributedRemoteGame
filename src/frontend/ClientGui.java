package frontend;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import backend.IRemoteGame;

public class ClientGui {

  public static void main(String[] args)
      throws MalformedURLException, RemoteException, NotBoundException {
    new ClientGui();
    Registry registry = LocateRegistry.getRegistry("localhost");
    IRemoteGame remoteGame = (IRemoteGame) registry.lookup("GameServer");

    /** get Username input */
    System.out.println("Enter your username: ");
    String username = new Scanner(System.in).nextLine();

    /** Client Imp example */
    Client client = new Client(username);
    client.joinGame(remoteGame);
    client.sendMessage("hello from " + username);
    client.addWord("word1");
    client.pass();
    client.vote(true, "word1");
    client.logout();
  }
}
