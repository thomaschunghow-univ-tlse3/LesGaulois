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

	public int getForce() {
		return force;
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

//	// MA METHODE RECEVOIRCOUP
//	public void recevoirCoup(int forceCoup) {
//		assert (forceCoup >= 0);
//		int forceInitiale;
//		forceInitiale = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("AÃ¯e");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert (forceInitiale > force);
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force <= 0)
			parler("Aïe");
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0)
			forceCoup = 0;
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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