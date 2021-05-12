import java.util.Random;

public abstract class MarkJava {

	protected static Random random = new Random();
	private int energia = 10;
	public boolean haMogut = false;

	public int obteEnergia() {

		return energia;
	}

	public boolean decideixSiMou() {
		if (haMogut) {
			return false;
		}
		haMogut = true;
		return true;
	}

	public void gastaEnergia(int energiaGastada) {
		energia = energia - energiaGastada;

		if (energia < 0) {
			energia = 0;
		}
	}

	public void gastaBateria() {
		energia = 0;
	}

	public abstract void interactua(MarkJava unAltreRobot);

	public void recarregaBateri() {
		energia = 10;
	}

}
