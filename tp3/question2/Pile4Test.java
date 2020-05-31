package question2;

/**
 * Classe-test Pile4Test.
 *
 * @Frederic Khoueiry 
 * @1.0
 * 
 *          Les classes-test sont documentées ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basées sur le document © 2002 Robert A. Ballance intitulé
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associés aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque méthode Test à
 *          exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 *          automatiquement (par introspection) les méthodes Test de votre
 *          classe Test et générera la TestSuite conséquente. Chaque appel d'une
 *          méthode Test sera précédé d'un appel de setUp(), qui réalise les
 *          engagements, et suivi d'un appel à tearDown(), qui les détruit.
 */
public class Pile4Test extends junit.framework.TestCase {
	// Définissez ici les variables d'instance nécessaires à vos engagements;
	// Vous pouvez également les saisir automatiquement du présentoir
	// à l'aide du menu contextuel "Présentoir --> Engagements".
	// Notez cependant que ce dernier ne peut saisir les objets primitifs
	// du présentoir (les objets sans constructeur, comme int, float, etc.).

	 private PileI p1;
    private PileI p2;

    public void setUp() {
        p1 = new question2.Pile();
        p2 = new question2.Pile();
    }

    public void test_Pile_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
    }

    public void test_Pile_estPleine() throws Exception {
        PileI p = new question2.Pile(3);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile_sommet() throws Exception {
        PileI p = new question2.Pile(3);
        assertEquals(true, p.estVide());

        p.empiler(3);
        assertEquals(" sommet ?? ", 3, p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ",3, p.depiler());
        assertEquals(0, p.taille());
    }

    public void test_Pile_estVide() throws Exception {
        PileI p = new question2.Pile(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile_toString() throws Exception {
        PileI pile1 = new question2.Pile(3);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect ? ", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString incorrect ? ", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString incorrect ? ", "[3, 5, 4]", pile1.toString());

    }

    public void test_Pile_TailleNegative() {
        PileI p = new question2.Pile(-3);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }

    public void test_Pile_equals() throws Exception {
        p1 = new question2.Pile(3);
        p1.empiler(3);
        p1.empiler(2);
        p1.empiler(1);

        p2 = new question2.Pile(3);
        p2.empiler(3);
        p2.empiler(2);
        p2.empiler(1);

        assertTrue("Egalite de deux piles ? ", p1.equals(p2));
        assertTrue("Egalite de deux piles ? ", p2.equals(p1));
        assertTrue("Egalite de deux piles ? ", p1.equals(p1));
    }

}
