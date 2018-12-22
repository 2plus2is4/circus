package observer;

import eg.edu.alexu.csd.oop.game.GameObject;
import to_come.ImageObject;
import to_come.MovingPool;
import world_class.Circus;

import java.util.ArrayList;

public class plateServer extends Observer {

	private Circus game;
	MovingPool mpl = MovingPool.getInstance();
	ArrayList<GameObject> newControl ;
	public plateServer(Circus game) {
		this.game = game;
		game.attach(this);
		newControl = game.getControl();
	}

	@Override
	public void update(int num) {

		if (num == 1) {
			operationL(  );
		} else if (num == 2) {
			operationR();
		}
	}

	private void operationL() {

		game.setCurrentMementoL(game.getCurrentMementoL() - 3);
		
		
		for (int k = 0; k < 3; k++) {
			ImageObject s = (ImageObject) game.getControlL().get(game.getControlL().size() - k - 1);
			mpl.releaseObj(s);
			newControl.remove(s);
			
		}
		game.setControlL((ArrayList<GameObject>) Circus.getOriginator()
				.restoreFromMemento(Circus.getCaretaker().getMementoL(game.getCurrentMementoL() - 1)).clone());
		Circus.getCaretaker().removeL();
		Circus.getCaretaker().removeL();
		Circus.getCaretaker().removeL();
	}

	private void operationR() {
		
		if (game.getCurrentMementoR() >= 1) {
			game.setCurrentMementoR(game.getCurrentMementoR() - 3);
			for (int k = 0; k < 3; k++) {
				ImageObject s = (ImageObject) game.getControlR().get(game.getControlR().size() - k - 1);
				mpl.releaseObj(s);
				newControl.remove(s);
			}
			game.setControlR((ArrayList<GameObject>) Circus.getOriginator()
					.restoreFromMemento(Circus.getCaretaker().getMementoR(game.getCurrentMementoR() - 1)).clone());
			Circus.getCaretaker().removeR();
			Circus.getCaretaker().removeR();
			Circus.getCaretaker().removeR();
		}
	}

}
