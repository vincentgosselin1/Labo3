package Patrons.PVue;


import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import Patrons.PModel.ModelImage;
import Patrons.PModel.Observable;


/**
 * Classe <b><i>Vue</i></b> <br><br>
 * 
 * Affichage est une classe qui permet d'afficher le contenu d'un fichier XML
 * dans une fen�tre selon une certaine mise en page. 
 */
@SuppressWarnings("serial")
public abstract class Vue extends JFrame implements ObserverIF {
	//Objets n�cessaires � l'affichage
	protected Observable model = ModelImage.getInstance();
	protected JScrollPane scroll;
	protected JPanel panel;
	protected JMenuBar menuBar = new JMenuBar();

	//s principaux du menu
	protected JMenu Fichier = new JMenu("Fichier"), 
			Edition = new JMenu("�dition"),
			Affichage = new JMenu("Affichage"),
			Zoom	  = new JMenu("Zoom");

	//Sous-s du menu
	protected JMenuItem Ouvrir = new JMenuItem("Ouvrir image"), 
			Save   = new JMenuItem("Sauvegarder"), 
			UnDo   = new JMenuItem("Annuler"),
			ReDo   = new JMenuItem("Restaurer"),
			ToggleVueImage = new JMenuItem("Toggle la vue de l'image"),
			ToggleVueDonnees = new JMenuItem("Toggle la vue des donn�es"),
			ZoomIn	   = new JMenuItem("Zoom in"),
			ZoomOut	   = new JMenuItem("Zoom out");
	/**
	 * Constructeur de la classe <b><i>Affichage</i></b> 
	 * initialise tout notre fen�tre.
	 */
	public Vue(){	
		Ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		UnDo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
		ReDo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
		ToggleVueImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
		ToggleVueDonnees.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
		Fichier.add(Ouvrir);
		Fichier.add(Save);
		Edition.add(UnDo);
		Edition.add(ReDo);
		Zoom.add(ZoomIn);
		Zoom.add(ZoomOut);
		Affichage.add(ToggleVueDonnees);
		Affichage.add(ToggleVueImage);

		menuBar.add(Fichier);
		menuBar.add(Edition);
		menuBar.add(Affichage);
		Zoom.add(ZoomIn);
		Zoom.add(ZoomOut);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		model.addObserver(this);
	}

	public void addButtonListener(ActionListener listenerButton){
		Ouvrir.addActionListener(listenerButton);
		Save.addActionListener(listenerButton);
		UnDo.addActionListener(listenerButton);
		ReDo.addActionListener(listenerButton);
		ZoomIn.addActionListener(listenerButton);
		ZoomOut.addActionListener(listenerButton);
		ToggleVueImage.addActionListener(listenerButton);
		ToggleVueDonnees.addActionListener(listenerButton);
		addButtonListenerOnChildren(listenerButton);
	}
	
	public abstract void addButtonListenerOnChildren(ActionListener listenerButton);
	
	public abstract void addMouseListeners(MouseAdapter mouseAdapter);

	@Override
	public abstract void update();

	public void setCursor(Cursor cursor){
		panel.setCursor(cursor);
	}

	public void closing(){
		model.deleteObserver(this);
	}
}
