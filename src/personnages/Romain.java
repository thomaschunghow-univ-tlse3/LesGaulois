package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		assert(force >= 0);
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert(forceCoup >= 0);
		int forceInitiale;
		forceInitiale = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert (forceInitiale > force);
	}

	public static void main(String[] args) {
		Romain romain;
		romain = new Romain("Romain", 5);
//		QUESTION 2b
		System.out.println(romain.prendreParole());
		romain.parler("Ouille !");
		romain.recevoirCoup(2);
		romain.recevoirCoup(2);
		romain.recevoirCoup(2);
	}
}