package personnages;

public class Yakuza extends Humain{
	
	public String clan;
	public int reputation = 0;
//	public int reputation = 4;
	
	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom,boissonFavorite,argent);
		this.clan = clan;
	}
	
	public int getReputation() {
		return reputation;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + " si tu tiens à la vie donne moi ta bourse !");
        int argentVictime = victime.argent;
		gagnerArgent(victime.argent);
		victime.seFaireExtorquer();
        parler(" J’ai piqué les " + argentVictime + " sous de Marco, ce qui me fait " + argent + " sous dans ma poche. Hi ! Hi !");
        reputation += 1;
	}
	
	public int perdre() {
		parler("J’ai perdu mon duel et mes " + argent + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
		perdreArgent(argent);
		reputation -= 1;
		return argent;
	}
	
	public int gagner(int gain) {
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + " ? Je l'ai dépouillé de ses " + gain + " sous.");
		gagnerArgent(gain);
		reputation += 1;
		return argent;
	}
	
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan);
	}
	
}