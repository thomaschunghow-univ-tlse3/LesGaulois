package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

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

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup( (force / 3) * effetPotion);

	}

	public void boirePotion(Druide druide) {
		effetPotion = druide.getForcePotion();
		parler("Merci " + druide.getNom() + ", je sens que ma force est " + effetPotion + " fois décuplée.");
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
