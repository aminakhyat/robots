
public class Destructor extends MarkJava {

	@Override
	public void interactua(MarkJava unAltreRobot) {

		if (this.obteEnergia() >= 5) {
			if (unAltreRobot instanceof Destructor) {
				int x = random.nextInt(2);
				if (x == 0) {
					unAltreRobot.gastaBateria();
				}
			} else {
				unAltreRobot.gastaBateria();
			}
			this.gastaEnergia(3);
		}
	}

	@Override
	public boolean decideixSiMou() {

		if (super.decideixSiMou()) {
			if (this.obteEnergia() < 5) {
				return false;
			} else {
				int x = random.nextInt(10) + 1;
				if (x <= 4) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

}
