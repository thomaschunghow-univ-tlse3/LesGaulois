package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	int nbTrophee = 0;

	public Musee() {
		this.trophees = trophees;
		this.nbTrophee = nbTrophee;
	}

	public Trophee[] getTrophees() {
		return trophees;
	}

	public int getNbTrophee() {
		return nbTrophee;
	}

	private void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee nouveauTrophee = new Trophee(gaulois, equipement);
		trophees[nbTrophee] = nouveauTrophee;
		nbTrophee += 1;
	}
	
	private void name() {
		
	}
	
	public static void main(String[] args) {
		Musee musee = new Musee();
		
	}
}
