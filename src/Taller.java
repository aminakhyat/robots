import java.util.Random;

public class Taller {

	private MarkJava[][] robots = new MarkJava[5][5];

	public static void main(String[] args) {
		Taller taller = new Taller();
		taller.creaTaller();
	}

	public void creaTaller() {
		robots[0][1] = new Destructor();
		robots[1][3] = new Mecanic();
		robots[2][4] = new Replicant();

		mostrarTaller();

		for (int i = 0; i < 10; i++) {
			torn();
		}
	}

	public void torn() {
		for (int i = 0; i < robots.length; i++) {
			for (int j = 0; j < robots[i].length; j++) {
				if (robots[i][j] != null) {
					boolean esMou = robots[i][j].decideixSiMou();
					if (esMou) {
						resolMoviment(robots[i][j], i, j);
					}
				}
			}
		}

		for (int i = 0; i < robots.length; i++) {
			for (int j = 0; j < robots[i].length; j++) {
				if (robots[i][j] != null) {
					robots[i][j].haMogut = false;
				}
			}
		}
		
		mostrarTaller();
	}

	public void resolMoviment(MarkJava robotAMoure, int x, int y) {

		Random random = new Random();
		int num = random.nextInt(4);
		int novaY = 0;
		int novaX = 0;
		if (num == 0) {
			novaY = y + 1;
		} else if (num == 1) {
			novaX = x + 1;
		} else if (num == 2) {
			novaY = y - 1;
		} else {
			novaX = x - 1;
		}

		if (novaX >= 0 && novaY <= 4 && novaY >= 0 && novaX <= 4) {
			robotAMoure.gastaEnergia(1);
			if (robots[novaX][novaY] == null) {
				robots[novaX][novaY] = robotAMoure;
				if (robotAMoure instanceof Replicant) {
					crearUnNouRobot((Replicant) robotAMoure, x, y);
				}
			} else {
				robotAMoure.interactua(robots[novaX][novaY]);
			}
		}
	}

	public void crearUnNouRobot(Replicant robotQueCrea, int x, int y) {
		robots[x][y] = robotQueCrea.construeix();
	}

	public void mostrarTaller() {
		for (int i = 0; i < robots.length; i++) {
			for (int j = 0; j < robots[i].length; j++) {
				if (robots[i][j] == null) {
					System.out.print(" - ");
				} else if (robots[i][j] instanceof Destructor) {
					System.out.print(" D ");
				} else if (robots[i][j] instanceof Mecanic) {
					System.out.print(" M ");
				} else if (robots[i][j] instanceof Replicant) {
					System.out.print(" R ");
				}
				if (j != robots[i].length - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (i != robots[i].length - 1) {
				for (int k = 0; k < robots[i].length * 2; k++) {
					System.out.print("--");
				}
				System.out.println();
			}
		}
		System.out.println();
	}

}
