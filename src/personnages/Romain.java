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
		System.out.println(prendreParole() + "Â« " + texte + " Â»");
	}

	public void recevoirCoup(int forceCoup) {
		assert (forceCoup >= 0);
		int forceInitiale;
		forceInitiale = force;
		force -= forceCoup;
		if (force > 0) {
			parler("AÃ¯e");
		} else {
			parler("J'abandonne...");
		}
		assert (forceInitiale > force);
	}

	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement += 1;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			parler("s'équipe avec un " + equipement);
			break;
		case 1:
			if (equipements[0] != equipement) {
				ajouterEquipement(equipement);
				parler("s'équipe avec un " + equipement);
			} else
				parler("possède déjà un " + equipement);
			break;
		default:
			parler("est déjà bien protégé");
			break;
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
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.CASQUE);
		romain.sEquiper(Equipement.BOUCLIER);
		romain.sEquiper(Equipement.BOUCLIER);
	}
}