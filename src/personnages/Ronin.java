package personnages;

public class Ronin extends Humain{
	
	private int honneur = 1;
	
	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom,boissonFavorite,argent);
	}
	
	public void donner(Commercant beneficiaire) {
		
		int argentDonne = argent/10;
		parler(beneficiaire.getNom() + " prends ces " + argentDonne + " sous.");
		perdreArgent(argentDonne);
		beneficiaire.gagnerArgent(argentDonne);
		beneficiaire.recevoir(argentDonne);
		honneur += 1;
	}
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		int force = honneur * 2;
		if (force >= adversaire.reputation) {
			parler("Je t’ai eu petit yakusa!");
			adversaire.perdre();
			gagnerArgent(adversaire.argent);
			honneur += 1;
		}
		else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(argent);
			perdreArgent(argent);
				honneur -= 1;
		}
	}
	
}