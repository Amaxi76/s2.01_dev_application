package controleur;
/** SAE 2.02
  * date : le 06/06/2023
  * @author : Alizéa Lebaron, Mathys Poret, Maximilien Lesterlin ,Mohamad Marrouche, Eleonore Bouloché
  */

import metier.*;
import ihm.*;
import java.util.List;
import java.awt.*;

public class Controleur
{
	private	FramePlateau ihm;
	private Joueur       j1;
	private Joueur       j2;

	/** Contructeur qui initialise le jeu
	 */
	public Controleur ( )
	{
		new FrameAccueil ( this );
	}

	/** Accesseur qui retourne la couleur du joueur en cours
	 * @return couleur du joueur en cours
	 */
	public Color              getCouleurj1               ( ) { return this.j1.getPartie ( ).getCoulLigne ( ) ;    }

	public Joueur             getJoueur1                 ( ) { return this.j1;                                    }

	/** Accesseur qui retourne le nombre de régions visitées
	 * @return nombre de régions visitées
	 */
	public int                getNbRegionsVisite         ( ) { return this.j1.getPartie ( ).getNbRegionsVisite ( );                                          }


	public boolean            estFinDePartie ( )             { return this.j1.getPartie ( ).getFinPartie ( );     }

	public boolean jouer ( VoieMaritime voieMaritime, boolean b )
	{
		if ( this.estFinDePartie ( ) )
			return false;
		
		return this.j1.jouer ( voieMaritime, b );
	}

	public void  lancerFrame      ( )          { this.j1     = new Joueur  ( ); this.ihm    = new FramePlateau ( this ); }

	public void  lancerScenario   (int numero) { this.j1     = new Joueur  (numero); this.ihm    = new FramePlateau ( this );}
 {}
	public void  modeDeuxJouers   ( )          { this.j1     = new Joueur  ( ); this.j2     = new Joueur  ( ); this.ihm    = new FramePlateau ( this ); }

	public Carte getCarteEnCours  ( )          { return this.j1.getPartie ( ).getCarteEnCours ( ); }

	public int   calculerScore    ( )          { return this.j1.getPartie ( ).calculerScore   ( ); }

	public boolean estJouable ( Ile ile, List<Ile> lstExtremite ) { return this.j1.estJouable ( ile, lstExtremite ); }

	public void majIHM ( ) { this.ihm.majIHM ( );}

	public static void main ( String[] arg ) { new Controleur ( ); }
}
