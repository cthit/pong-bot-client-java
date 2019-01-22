import java.io.IOException;
import java.lang.System;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

	private final static String     HOST    = "127.0.0.1";
	private final static int        PORT    = 4242;
	private final static String     NAME    = "itstud";
	private final static Player     PLAYER  = new Bot();

	public static void main(String[] args) {

		Store store = new Store();
		Communicator communicator = null;
		try {
			communicator = new Communicator(store, PORT, InetAddress.getByName(HOST), NAME);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't create Socket. Is the server running at " + HOST + ":" + PORT + "?");
			e.printStackTrace();
			System.exit(1);
		}

		communicator.start();

		while (true)
		    if(store.getGameState() != null)
				store.setDesiredPaddleState(PLAYER.play(store.getGameState()));

	}
}
