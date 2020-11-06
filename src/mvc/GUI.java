package mvc;

import javax.swing.*;
import strategy.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUI extends JFrame {

	private JFrame frame;
	private JPanel p0;
	private JButton manuelleEingabe, dateiEinlesen, zurueck, okay, karp, power, aLambda, neueEingabe;
	private Strategy c;

	private boolean ausDatei = false;
	private int dimension;
	private int fensterBreite = 750;
	private int fensterHoehe = 750;
	private JTextField textFieldDimension = new JTextField();
	private JTextField textFieldFile = new JTextField();
	private double[][] matrix;
	private JTable matrixT;

	/**
	 * Der konstruktor erstellt ein neues JFrame anschließend werden die Farbe des
	 * Frames und die Höhe/Breite definiert und page1 aufgerufen
	 * 
	 * @param c Strategy
	 */
	public GUI(Strategy c) {
		frame = new JFrame("Studienarbeit Modellierung Sommersemester 2019");
		this.c = c;

		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().setBackground(new java.awt.Color(204, 166, 166));

		frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - fensterBreite / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height / 2) - fensterHoehe / 2);

		frame.setSize(fensterBreite, fensterHoehe);

		page1();
	}

	/**
	 * Startseite hier kann man auswählen, ob die Matrix manuell eigeben oder aus einer
	 * Datei eigelesen werden soll
	 */
	private void page1() {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 205));
		JLabel textPage1_01 = new JLabel("Wollen Sie die Matrix AF manuell eingeben oder aus einer Datei auslesen?");
		manuelleEingabe = new JButton("manuell");
		dateiEinlesen = new JButton("aus Datei");

		textPage1_01.setBounds(20, 20, 450, 15);
		manuelleEingabe.setBounds(100, 100, 90, 40);
		dateiEinlesen.setBounds(280, 100, 90, 40);

		p0.add(textPage1_01);
		p0.add(manuelleEingabe);
		p0.add(dateiEinlesen);

		manuelleEingabe.addActionListener(new Listener1());
		dateiEinlesen.addActionListener(new Listener2());

		frame.add(p0);

		frame.setVisible(true);
	}

	/**
	 * Diese Seite wird im manuellen Eingeben verwendet hier ist es möglich die
	 * Dimension der Matrix eizugeben
	 */
	private void page2() {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 206));
		JLabel textPage2_01 = new JLabel("Welche Dimension hat Ihre Matrix?");

		okay = new JButton("okay");
		zurueck = new JButton("zurück");

		textPage2_01.setBounds(20, 20, 450, 15);
		textFieldDimension.setBounds(20, 100, 100, 20);
		okay.setBounds(120, 100, 90, 40);
		zurueck.setBounds(20, 652, 90, 40);

		p0.add(textPage2_01);
		p0.add(textFieldDimension);
		p0.add(okay);
		p0.add(zurueck);

		zurueck.addActionListener(new Listener3());
		okay.addActionListener(new Listener4());
		frame.add(p0);
		frame.setVisible(true);
	}

	/**
	 * Diese Seite wird beim manuellen Eingeben verwendet und wird aufgerufen wenn
	 * keine natrürliche Zahl als Dimension eingegeben wird
	 */
	private void page3() {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 206));
		JLabel textPage3_01 = new JLabel("Welche Dimension hat Ihre Matrix?");
		JLabel textPage3_02 = new JLabel("Bitte geben Sie eine natürliche Zahl als Dimension an!");
		okay = new JButton("okay");
		zurueck = new JButton("zurück");

		textPage3_01.setBounds(20, 20, 450, 15);
		textPage3_02.setBounds(20, 150, 450, 15);
		textPage3_02.setForeground(Color.RED);
		textFieldDimension.setBounds(20, 100, 100, 20);
		okay.setBounds(120, 100, 90, 40);
		zurueck.setBounds(20, 652, 90, 40);

		p0.add(textPage3_01);
		p0.add(textFieldDimension);
		p0.add(okay);
		p0.add(zurueck);
		p0.add(textPage3_02);

		zurueck.addActionListener(new Listener3());
		okay.addActionListener(new Listener4());
		frame.add(p0);
		frame.setVisible(true);
	}

	/**
	 * Diese Seite wird beim manuellen Eingeben verwendet hier ist es möglich die
	 * Matrix koordinatenweise einzugeben
	 */
	private void page4() {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 206));
		JLabel textPage4_01 = new JLabel("Geben Sie Ihre Matrix AF ein! Eps entspricht hierbei 'Minus-Unendlich'");
		JLabel textPage4_02 = new JLabel("Die Einträge der Matrix AF beschreiben die Fahrzeiten der einzelnen Linien");
		matrixT = new JTable(dimension, dimension);
		okay = new JButton("okay");
		zurueck = new JButton("zurück");

		textPage4_01.setBounds(20, 20, 450, 15);
		textPage4_02.setBounds(20, 50, 450, 15);
		matrixT.setBounds(20, 210, dimension * 50, dimension * 16);
		zurueck.setBounds(20, 652, 90, 40);
		okay.setBounds(120, 652, 90, 40);

		p0.add(textPage4_02);
		p0.add(textPage4_01);
		p0.add(matrixT);
		p0.add(zurueck);
		p0.add(okay);

		okay.addActionListener(new Listener5());
		zurueck.addActionListener(new Listener6());
		frame.add(p0);
		frame.setVisible(true);
	}

	/**
	 * Diese Seite wird beim manuellen Eingeben verwendet sie wird aufgerufen wenn
	 * keine Elemente aus der Max-Plus-Algebra eingegeben werden
	 */
	private void page5() {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 206));
		JLabel textPage5_01 = new JLabel("Geben Sie Ihre Matrix AF ein! Eps entspricht hierbei 'Minus-Unendlich'");
		JLabel textPage5_02 = new JLabel("Die Einträge der Matrix AF beschreiben die Fahrzeiten der einzelnen Linien");
		JLabel textPage5_03 = new JLabel("Bitte geben Sie reelle Zahlen ein!");
		matrixT = new JTable(dimension, dimension);
		okay = new JButton("okay");
		zurueck = new JButton("zurück");

		textPage5_01.setBounds(20, 20, 450, 15);
		textPage5_02.setBounds(20, 50, 450, 15);
		textPage5_03.setBounds(20, 80, 450, 15);
		textPage5_03.setForeground(Color.RED);
		matrixT.setBounds(20, 210, dimension * 50, dimension * 16);
		zurueck.setBounds(20, 652, 90, 40);
		okay.setBounds(120, 652, 90, 40);

		p0.add(textPage5_03);
		p0.add(textPage5_01);
		p0.add(textPage5_02);
		p0.add(matrixT);
		p0.add(zurueck);
		p0.add(okay);

		okay.addActionListener(new Listener5());
		zurueck.addActionListener(new Listener6());
		frame.add(p0);
		frame.setVisible(true);
	}

	/**
	 * Auf dieser Seite ist es möglich einen der beiden Algorithmen auszuwählen und
	 * es wird die Matrix dargestellt von der Eigenwert beziehungsweise Eigenvektor
	 * berechnet werden soll
	 */
	private void page6() {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 206));
		JLabel textPage6_01 = new JLabel("Welcher Algorithmus soll zur Fahrplan-Problemlösung verwandt werden?");
		JLabel textPage6_02 = new JLabel("Hier noch einmal die Matrix AF zur Kontrolle der Fahrzeiten.");
		
		c.setMatrix(matrix);
		String matrixInhalt = c.ausgabe();

		JTextArea matrix = new JTextArea(matrixInhalt);

		zurueck = new JButton("zurück");
		karp = new JButton("KARP");
		aLambda = new JButton("A Lambda");
		power = new JButton("POWER");

		matrix.setOpaque(false);
		textPage6_01.setBounds(20, 20, 450, 15);
		matrix.setBounds(20, 110, dimension * 80, dimension * 30);
		textPage6_02.setBounds(20, 50, 450, 15);
		zurueck.setBounds(20, 652, 90, 40);
		karp.setBounds(120, 652, 90, 40);
		power.setBounds(220, 652, 90, 40);
		aLambda.setBounds(320, 652, 90, 40);

		p0.add(textPage6_02);
		p0.add(matrix);
		p0.add(textPage6_01);
		p0.add(zurueck);
		p0.add(karp);
		p0.add(power);
		p0.add(aLambda);

		zurueck.addActionListener(new Listener7());
		karp.addActionListener(new Listener8());
		power.addActionListener(new Listener9());
		aLambda.addActionListener(new Listener11());
		frame.add(p0);
		frame.setVisible(true);
	}

	/**
	 * Diese Seite stellt nach Auswahl des Karp Algorithmus den errechneten
	 * Eigenwert da
	 * 
	 * @param a Eigenwert errechnet durch Karp
	 */
	private void page7(double a) {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 206));
		JLabel textPage7_01 = new JLabel("Der errechnete Eigenwert ist:");
		JLabel eigenwert = new JLabel(Double.toString(a));
		JLabel textPage7_02 = new JLabel("Der Eigenwert gibt den Takt des Fahrplans vor.");
		JLabel textPage7_03 = new JLabel("Die nächste Abfahrt der k-ten Linie ist demnach Abfahrtzeit + Eigenwert.");

		neueEingabe = new JButton("neue Berechnung");
		
		textPage7_02.setBounds(20, 20, 450, 15);
		textPage7_03.setBounds(20, 50, 450, 15);
		textPage7_01.setBounds(20, 80, 450, 15);
		eigenwert.setBounds(20, 120, 450, 15);
		neueEingabe.setBounds(20, 652, 150, 40);

		p0.add(neueEingabe);
		p0.add(textPage7_03);
		p0.add(textPage7_02);
		p0.add(textPage7_01);
		p0.add(eigenwert);

		neueEingabe.addActionListener(new Listener3());
		frame.add(p0);
		frame.setVisible(true);
	}

	/**
	 * Diese Seite stellt nach Auswahl des Power Algorithmus den Eigenwert und
	 * Eigenvektor da
	 * 
	 * @param a Eigenwert errechnet durch Power
	 * @param v Eigenvektor errechnet durch Power
	 */
	private void page8(double a, double[] v) {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 206));
		JLabel textPage8_01 = new JLabel("Der errechnete Eigenwert ist:");
		JLabel eigenwert = new JLabel(Double.toString(a));
		JLabel textPage8_02 = new JLabel("Der zugehörige Eigenvektor ist:");
		JLabel textPage8_03 = new JLabel("Der Eigenvektor zeigt die Abfahrtzeit der Linie k, an der k-ten Stelle.");
		JLabel textPage8_04 = new JLabel("Die Einträge können hier als Uhrzeiten aufgefasst werden.");
		JLabel textPage8_05 = new JLabel("Der Eigenwert gibt den Takt des Fahrplans vor.");
		JLabel textPage8_06 = new JLabel("Die nächste Abfahrt der k-ten Linie ist demnach Abfahrtzeit + Eigenwert.");
		
		String eigenvektorSTR = "(";
		for (int i = 0; i < v.length; i++) {
			if (i == v.length - 1) {
				eigenvektorSTR = eigenvektorSTR + Double.toString(v[i]) + ")";
			} else {
				eigenvektorSTR = eigenvektorSTR + Double.toString(v[i]) + ",  ";
			}
		}

		JLabel eigenvektor = new JLabel(eigenvektorSTR);

		neueEingabe = new JButton("neue Berechnung");

		textPage8_05.setBounds(20, 20, 450, 15);
		textPage8_06.setBounds(20, 50, 450, 15);
		textPage8_01.setBounds(20, 80, 450, 15);
		eigenwert.setBounds(20, 120, 450, 15);
		textPage8_03.setBounds(20, 180, 450, 15);
		textPage8_04.setBounds(20, 210, 450, 15);
		textPage8_02.setBounds(20, 240, 450, 15);
		eigenvektor.setBounds(20, 270, 450, 15);
		neueEingabe.setBounds(20, 652, 150, 40);

		p0.add(textPage8_06);
		p0.add(textPage8_05);
		p0.add(textPage8_04);
		p0.add(textPage8_03);
		p0.add(eigenvektor);
		p0.add(textPage8_02);
		p0.add(neueEingabe);
		p0.add(textPage8_01);
		p0.add(eigenwert);
		
		neueEingabe.addActionListener(new Listener3());
		frame.add(p0);
		frame.validate();
		frame.setVisible(true);
	}

	/**
	 * Diese Seite wird beim einlesen von einer Datei verwendet hier ist es möglich
	 * den Pfad der Datei einzugeben
	 */
	private void page9() {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 206));
		JLabel textPage9_01 = new JLabel("Welche Datei soll eingelesen werden?");
		okay = new JButton("okay");
		zurueck = new JButton("zurück");

		textPage9_01.setBounds(20, 20, 450, 15);
		textFieldFile.setBounds(20, 100, 200, 20);
		zurueck.setBounds(20, 652, 90, 40);
		okay.setBounds(220, 100, 90, 40);

		p0.add(textPage9_01);
		p0.add(textFieldFile);
		p0.add(zurueck);
		p0.add(okay);

		zurueck.addActionListener(new Listener3());
		okay.addActionListener(new Listener10());

		frame.add(p0);
		frame.setVisible(true);
	}

	/**
	 * Diese Seite wird beim einlesen einer Datei verwendet sie wird immer dann
	 * aufgerufen wenn entweder ein Fehler beim Eingeben des Pfades ensteht oder
	 * wenn ein Fehler beim Auslesen der Werte in der Datei ensteht
	 */
	private void page10() {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 206));	
		JLabel textPage10_01 = new JLabel("Bei Einlesen der Datei scheint ein Fehler aufgetreten zu sein.");
		JLabel textPage10_02 = new JLabel("Sieh bitte in der Anleitung nach, wie die Datei aufgebaut sein sollet und probiere es nochmal.");
		neueEingabe = new JButton("neue Berechnung");
		
		textPage10_01.setBounds(20, 20, 450, 15);
		textPage10_02.setBounds(20, 50, 550, 15);
		textPage10_01.setForeground(Color.RED);
		textPage10_02.setForeground(Color.RED);
		neueEingabe.setBounds(20, 652, 150, 40);

		p0.add(neueEingabe);
		p0.add(textPage10_01);
		p0.add(textPage10_02);		
		
		neueEingabe.addActionListener(new Listener3());
		frame.add(p0);
		frame.setVisible(true);
	}
	
	private void page11(double[] v) {
		p0 = new JPanel();
		p0.setLayout(null);
		p0.setBackground(new java.awt.Color(255, 250, 206));
		
		JLabel textPage11_01 = new JLabel("Der Eigenvektor zeigt die Abfahrtzeit der Linie k, an der k-ten Stelle.");
		JLabel textPage11_02 = new JLabel("Die Einträge können hier als Uhrzeiten aufgefasst werden.");
		JLabel textPage11_03 = new JLabel("Der Eigenvektor zu gegebenem Eigenwert ist:");
		
		String eigenvektorSTR = "(";
		for (int i = 0; i < v.length; i++) {
			if (i == v.length - 1) {
				eigenvektorSTR = eigenvektorSTR + Double.toString(v[i]) + ")";
			} else {
				eigenvektorSTR = eigenvektorSTR + Double.toString(v[i]) + ",  ";
			}
		}

		JLabel eigenvektor = new JLabel(eigenvektorSTR);
		
		neueEingabe = new JButton("neue Berechnung");
		
		
		textPage11_01.setBounds(20, 20, 450, 15);
		textPage11_02.setBounds(20, 50, 450, 15);
		textPage11_03.setBounds(20, 80, 450, 15);
		eigenvektor.setBounds(20, 120, 450, 15);
		neueEingabe.setBounds(20, 652, 150, 40);
		
		p0.add(textPage11_01);
		p0.add(textPage11_02);
		p0.add(textPage11_03);
		p0.add(eigenvektor);
		p0.add(neueEingabe);
		
		neueEingabe.addActionListener(new Listener3());
		frame.add(p0);
		frame.setVisible(true);
	}

	class Listener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			p0.removeAll();
			frame.remove(p0);
			page2();
		}
	}

	class Listener2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ausDatei = true;
			p0.removeAll();
			frame.remove(p0);
			page9();
		}
	}

	class Listener3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			p0.removeAll();
			frame.remove(p0);
			page1();
		}
	}

	class Listener4 implements ActionListener {

		/**
		 * Hier werden die Fehler abgefangen wenn keine ganze Zahl als Wert eingegeben
		 * oder wenn eine ganze Zahl kleiner gleich 0 eigegebn wird. Ist die Eingabe
		 * korrekt wird die Dimension in der Variablen "dimension" abgespeichert
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				dimension = Integer.parseInt(textFieldDimension.getText());
				if (dimension <= 0) {
					p0.removeAll();
					frame.remove(p0);
					page3();
				} else {
					p0.removeAll();
					frame.remove(p0);
					page4();
				}
			} catch (Exception ex) {
				p0.removeAll();
				frame.remove(p0);
				page3();
			}
		}
	}

	class Listener5 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			buildArray(matrixT);
		}

		/**
		 * Hier werden die eingegebenen Werte der Matrix von String Werten in Double
		 * Werte umgerechnet und im zweidimensionalen Array "matrix" abgespeichert dabei
		 * wird geprüft ob die eigegebenen Werte den voraussentzungen entsprochen
		 * haben(nur Zahlen aus der Max-Plus-Algebra) wenn nicht werden die verschiedeen
		 * pages mit den Fehler meldungen aufgerufen
		 * 
		 * @param matrixT Matrix die in page4 von Hand eingegeben wurde
		 */
		public void buildArray(JTable matrixT) {
			matrix = new double[dimension][dimension];
			boolean fehler = false;
			for (int i = 0; i < dimension; i++) {
				for (int j = 0; j < dimension; j++) {
					try {
						if (matrixT.getValueAt(i, j).toString().equals("Eps")) {
							matrix[i][j] = Double.NEGATIVE_INFINITY;
						} else {
							matrix[i][j] = Double.parseDouble(matrixT.getValueAt(i, j).toString());
						}
					} catch (Exception ex) {
						fehler = true;
					}

				}
			}

			if (!fehler) {
				p0.removeAll();
				frame.remove(p0);
				page6();
			} else {
				p0.removeAll();
				frame.remove(p0);
				page5();
			}
		}
	}

	class Listener6 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			p0.removeAll();
			frame.remove(p0);
			page2();
		}
	}

	class Listener7 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			p0.removeAll();
			frame.remove(p0);
			if(ausDatei) {
				page9();
			}
			else {
				page4();
			}
		}
	}

	class Listener8 implements ActionListener {

		/**
		 * Hier wird der Karp-Algorithmus als Lösungsverhalten an die Strategy übergeben
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			c.setLoesungsverhalten(new Karp());
			p0.removeAll();
			frame.remove(p0);
			c.loesenEigenwert();
			c.loesenEigenvektor();
		}
	}

	class Listener9 implements ActionListener {

		/**
		 * Hier wird der Power-Algorithmus als Lösungsverhalten an die Strategy
		 * übergeben
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			c.setLoesungsverhalten(new Power());
			p0.removeAll();
			frame.remove(p0);
			c.loesenEigenwert();
			c.loesenEigenvektor();
		}
	}

	class Listener10 implements ActionListener {

		/**
		 * Hier wird nach dem der Pfad in page9 eingegeben wurde die Werte aus der
		 * dazugehörigen Datei ausgelesen und in einem zweidimensionalen Double Array
		 * "matrix" abgespeichert dabei werden verschiedene Fehler vorab überprüft
		 * beispielsweise ob die Datei die Endung ".txt" hat und ob in der Datei die
		 * richtige Darstellung der Matrix gewählt wurde falls dabei ein Fehler ensteht
		 * wird page10 aufgerufen
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String path = textFieldFile.getText();
			char[] pathArray = path.toCharArray();
			boolean txt = istTextdatei(pathArray);
			if (txt == true) {
				try {
					FileReader fr = new FileReader(path);
					BufferedReader br = new BufferedReader(fr);
					String zeile = br.readLine();
					boolean dim = true;
					while (zeile != null) {
						if (dim) {
							dimension = Integer.parseInt(zeile);
							matrix = new double[dimension][dimension];
							dim = false;
							zeile = br.readLine();
						} else {
							for (int i = 0; i < dimension; i++) {
								for (int j = 0; j < dimension; j++) {
									if (zeile.equals("Eps")) {
										matrix[i][j] = Double.NEGATIVE_INFINITY;
									} else {
										matrix[i][j] = Double.parseDouble(zeile);
									}
									zeile = br.readLine();
								}
							}
						}

					}

					p0.removeAll();
					frame.remove(p0);
					page6();

					br.close();

				} catch (Exception e1) {
					p0.removeAll();
					frame.remove(p0);
					page10();
				}
			} else {
				p0.removeAll();
				frame.remove(p0);
				page10();
			}
		}

		/**
		 * Diese Methode überprüft ob der eingegebene Pfad in page9 die rcihtige Endung
		 * ".txt" hat
		 * 
		 * @param a Pfad der Datei
		 * @return false falls der Pfad nicht die Endung ".txt" hat ansonsten true
		 */
		private boolean istTextdatei(char[] a) {
			int x = a.length;

			if (a[x - 4] != '.') {
				return false;
			} else if (a[x - 3] != 't') {
				return false;
			} else if (a[x - 2] != 'x') {
				return false;
			} else if (a[x - 1] != 't') {
				return false;
			}

			return true;
		}
	}

	class Listener11 implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			c.setLoesungsverhalten(new ALambda());
			p0.removeAll();
			frame.remove(p0);
			c.loesenEigenvektor();
			c.loesenEigenwert();
		}
	}
			
	class Listener12 implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			p0.removeAll();
			frame.remove(p0);
			page6();
		}
	}
	
	/**
	 * Prüft welche Page aufgerufen werden soll da der Karp Algorithmus nur den
	 * Eigenwert berechnet und somit für den Eigenvetor den Wert null liefert
	 * 
	 * @param a Eigenwert errechnet von Karp oder Power
	 * @param b Eigenvektor errechnet von Power oder ALambda
	 */
	public void anzeigen(RMaxZahl a, RMaxVektor b) {
		p0.removeAll();
		frame.remove(p0);
		if (b == null) {
			page7(a.getRMaxZahl());
		} 
		else if (a == null) {
			page11(b.getRMaxZahlen());
		}
		else {
			page8(a.getRMaxZahl(), b.getRMaxZahlen());
		}
	}
}