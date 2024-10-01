//MON SCENARIO
//package histoire;
//
//import personnages.Druide;
//import personnages.Gaulois;
//import personnages.Romain;
//
//public class Scenario {
//
//	public static void main(String[] args) {
//		Gaulois asterix;
//		asterix = new Gaulois("AstÃ©rix", 8);
//		Romain minus;
//		minus = new Romain("Minus", 6);
////		asterix.parler("Bonjour Ã  tous");
////		minus.parler("UN GAU... UN GAUGAU...");
////		asterix.frapper(minus);
////		asterix.frapper(minus);
////		asterix.frapper(minus);
//		Druide panoramix;
//		panoramix = new Druide("Panoramix", 5, 10);
//		Gaulois obelix;
//		obelix = new Gaulois("ObÃ©lix", 25);
//		panoramix.preparerPotion();
//		panoramix.booster(obelix);
//		obelix.parler("Par BÃ©lÃ©nos, ce n'est pas juste !");
//		panoramix.booster(asterix);
//		asterix.boirePotion(panoramix);
//		asterix.parler("Bonjour");
//		minus.parler("UN GAU... UN GAUGAU...");
//		asterix.frapper(minus);
//	}
//
//}

package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
//import villagegaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0);
		
//		Partie a decommenter
		
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);

	}

}