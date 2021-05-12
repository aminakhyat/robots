
public class Mecanic extends MarkJava {

	@Override
	public void interactua(MarkJava unAltreRobot) {
		if (this.obteEnergia() > 4) {
			unAltreRobot.recarregaBateri();
			this.gastaEnergia(1);
		}

	}

	@Override
	public boolean decideixSiMou() {
		if (super.decideixSiMou() && this.obteEnergia() < 5) {
			this.recarregaBateri();
			return false;
		} else {
			int x = random.nextInt(10) + 1;
			if (x <= 6) {
				return true;
			} else {
				return false;
			}
		}
	}

}
