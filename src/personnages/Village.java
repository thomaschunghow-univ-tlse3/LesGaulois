package personnages;

public class Village {

	private String nom;

	public Village(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	private Gaulois[] villageois;
	private int nbVillageois;

	public int getNbVillageois() {
		return nbVillageois;
	}

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageois = 0;
		Gaulois[] villageois;
		villageois = new Gaulois[nbVillageoisMaximum];
		this.villageois = villageois;
	}

	private void ajouterHabitant(Gaulois gaulois) {
		this.villageois[nbVillageois] = gaulois;
		this.nbVillageois += 1;
	}

	private Gaulois trouverHabitant(int numeroVillageois) {
		return this.villageois[numeroVillageois];
	}

	public void afficherVillageois(Chef chef) {
		System.out.println("Dans village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < getNbVillageois(); i++) {
			System.out.println("- " + (trouverHabitant(i)).getNom());
		}
	}

	public static void main(String[] args) {
		Village village;
		village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
//		at personnages.Village.trouverHabitant(Village.java:33)
//		at personnages.Village.main(Village.java:39)
		Chef abraracourcix;
		abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		Gaulois obelix;
		obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		null
		village.afficherVillageois(abraracourcix);

	}

}