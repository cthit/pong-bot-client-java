import pong.*;

public class Bot implements Player {

	private Paddle myPaddle(GameState gameState) {
        for (Paddle paddle : gameState.getPaddles())
            if (paddle.getPlayer() == Communicator.clientId)
                return paddle;
		throw new RuntimeException("Couldn't find player");
	}

	/**
	 * Should return a {@link Paddle.State} in response to a {@link GameState} received by the server.
	 * @param gameState the GameState received from the server.
	 * @return a Paddle.State
	 */
    @Override
    public Paddle.State play(GameState gameState) {
		// Enter your bot logic here...

		// Example...
		return Paddle.State.MOVE_CLOCKWISE;
    }

}