package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public void setEffetPotion(int effetPotion) {
		this.effetPotion = effetPotion;
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

//	MA METHODE PRENDREPAROLE
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	MA METHODE FRAPPER
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup( (force / 3) * effetPotion);
//
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		trophees = romain.recevoirCoup((force / 3) * effetPotion);
	}

	public void boirePotion(Druide druide) {
		effetPotion = druide.getForcePotion();
		parler("Merci " + druide.getNom() + ", je sens que ma force est " + effetPotion + " fois décuplée.");
	}

	private void faireUneDonation(Musee musee) {
		parler("Je donne au musee tous mes trophees");
		Trophee[] tableauTrophee = musee.getTrophees();
		for (int i = 0; i < musee.getNbTrophee(); i++) {
//			if (equals(((tableauTrophee[i]).getGaulois()).getNom(), getNom()))
//				System.out.println("- " + ((musee.getTrophees())[i]).getEquipement());
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		Romain romain;
		romain = new Romain("Romain", 3);
		Druide panoramix;
		panoramix = new Druide("Panoramix", 5, 10);
//		QUESTION 1c
//		System.out.println(asterix.getNom());
//		QUESTION 1d
//		System.out.println(asterix);
//		QUESTION 2a
//		System.out.println(asterix.prendreParole());
//		asterix.parler("Blablabla");
		asterix.boirePotion(panoramix);
		asterix.frapper(romain);
	}
}
