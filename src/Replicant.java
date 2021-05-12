
public class Replicant extends MarkJava {

	private MarkJava robotQueReplicara;

	@Override
	public void interactua(MarkJava unAltreRobot) {
		robotQueReplicara = unAltreRobot;

	}

	@Override
	public boolean decideixSiMou() {

		if (super.decideixSiMou()) {
			if (this.obteEnergia() < 7) {
				return false;
			} else {
				int x = random.nextInt(10) + 1;
				if (x <= 6) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
	
	

	public MarkJava construeix() {
		if (this.obteEnergia() >= 7) {
			if (robotQueReplicara != null) {
				this.gastaEnergia(5);
				if (robotQueReplicara instanceof Destructor) {
					return new Destructor();
				} else if (robotQueReplicara instanceof Mecanic) {
					return new Mecanic();
				} else if (robotQueReplicara instanceof Replicant) {
					return new Replicant();
				}
			} else {
				int x = random.nextInt(3);
				if (x == 0) {
					return new Destructor();
				} else if (x == 1) {
					return new Mecanic();
				} else {
					return new Replicant();
				}
			}
		} else {
			return null;
		}
		return null;
	}

}
