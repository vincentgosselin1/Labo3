# Labo3

Un patron MVC fonctionnel 

Un patron Command fonctionnel

Plusieurs patron Singleton fonctionnel

Un patron Observer fonctionnel 

Donc actuellement, on respecte les sp�cifications du labo pour les patrons ! 

La logique impl�ment�e selon les patrons : 

Controller = Brain il ne fait pas grand chose lui m�me mais il sait ce qu'il se passe sur la vue et il sait ce 			 qu'il faut faire en cons�quence. 

Actions via Command  = Execute les instructions demand�es par le Controller sur le Model et les enregistrent 					  					   dans le record. 

Les commandes sont s�par�es en plusieurs classes par actions respectives avec la configuration de chaque actions � faire selon l'op�ration (execute, undo, redo).

Model = Conserve toutes les infos de notre application (c'est cette classe qu'il faudra s�rialis� pour 		l'enregistrement de l'image : voir patron M�mento). Il doit avertir les vues de se mettre � jour 		(m�thode notifyAllObserver). Il ne le fait pas pr�sentement, c'est le Controller qui lance la m�thode, 		il faudrait mettre le lancement de la m�thode dans les m�thodes set du model ou faire une fonction 		plus globale de la mis � jour des donn�es et lancer la mise � jour des vues � la fin de cette m�thode 		(c'est clairement la solution la plus optimale pour �viter trop de redondance.

VueDonnes = Affiche les donn�es du model au format "brut".

VueImage = Affiche les donn�es du model de facon graphique.

La m�thode update appelle juste repaint qui permet de repeindre l'interface au complet. Nos �l�ments graphiques sont tous contenus dans un JPanel dont on a �dit� la m�thode paintComponent qui sera appel�e au moment du repaint. Ainsi, l'interface se remet � jour automatiquement avec les donn�es actuelles peu importe ce qui arrive sur l'interface.

Il reste � faire :

Sauvegarde de l'image : il y a tout � faire ou presque (voir patron m�mento).

Drag : il faut revoir la logique du drag

Nettoyer les incoh�rences (telles que le notifyAllObservers appel� par le Controller)

La VueDonn�e est commenc� mais il reste � faire. Je suis ouvert � afficher toutes donn�es pertinentes dans cette page.

Le KeyBoardListener : il n'a pas �t� du tout fait.

Similarit� dans les commandes : diff�rentes �coutes pour une seule commande, donc un patron adapter serait bon)