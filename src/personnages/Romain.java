package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert (force >= 0);
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	public void recevoirCoup(int forceCoup) {
		assert (forceCoup >= 0);
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

	public void sEquiper(Equipement equipement) {
		switch (equipement) {
		case CASQUE: {
			switch (equipements[0]) {
			case null: {

			}
			}
			break;
		}
		case BOUCLIER: {
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + equipement);
		}
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
		romain.equipements[0] = Equipement.BOUCLIER;
		System.out.println(romain.equipements[0]);
	}
}