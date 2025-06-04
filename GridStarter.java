//Name: Griffin Tattongeyer
//Date: 2025, may 29 - june
//Purpose: to run Viking chess
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
public class GridStarter extends Applet implements ActionListener
{
    //For screens
    Panel p_card;
    Panel card1, card2, card3, card4;
    CardLayout cdLayout = new CardLayout ();

    //Game screen's grid
    int row = 13;
    int col = 13;

    int b[] [] = {{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
	    {7, 5, 0, 0, 3, 3, 3, 3, 3, 0, 0, 5, 7},
	    {7, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 7},
	    {7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7},
	    {7, 3, 0, 0, 0, 0, 2, 0, 0, 0, 0, 3, 7},
	    {7, 3, 0, 0, 0, 2, 2, 2, 0, 0, 0, 3, 7},
	    {7, 3, 3, 0, 2, 2, 4, 2, 2, 0, 3, 3, 7},
	    {7, 3, 0, 0, 0, 2, 2, 2, 0, 0, 0, 3, 7},
	    {7, 3, 0, 0, 0, 0, 2, 0, 0, 0, 0, 3, 7},
	    {7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7},
	    {7, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 7},
	    {7, 5, 0, 0, 3, 3, 3, 3, 3, 0, 0, 5, 7},
	    {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}};
    JButton pics[] = new JButton [row * col];
    int sqDimension = 25;
    String picStart = "c";
    String picFileType = ".png";
    JLabel turnpic;
    int turn = 1;
    int px, py;

    //Settings
    JTextField choice, name, first;

    //Formatting
    Color backgroundColour = Color.white;
    Color buttonColour = Color.lightGray;
    Color buttonText = Color.black;
    Color titleColour = Color.black;
    Font titleFont = new Font ("Arial", Font.PLAIN, 30);
    Font promptFont = new Font ("Arial", Font.PLAIN, 20);
    Dimension boardSquare = new Dimension (96, 96);

    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	//TO DO: Bring back in when you are ready to work on other screens
	//opening ();
	//instructions ();
	//settings ();
	gameScreen ();
	resize (350, 500);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void opening ()
    { //TO DO: Fill this comment in
	card1 = new Panel ();
	card1.setBackground (backgroundColour);
	JLabel title = new JLabel ("Welcome to Tic Tac Toe!");
	title.setFont (new Font ("Arial", Font.PLAIN, 30));
	title.setForeground (titleColour);
	JButton next = new JButton ("Enter");
	next.setPreferredSize (new Dimension (300, 50));
	next.setActionCommand ("s2");
	next.addActionListener (this);
	next.setBackground (buttonColour);
	next.setForeground (buttonText);
	card1.add (title);
	card1.add (next);
	p_card.add ("1", card1);
    }


    public void instructions ()
    { //TO DO: Fill this comment in
	card2 = new Panel ();
	card2.setBackground (backgroundColour);
	JLabel title = new JLabel ("The Instructions");
	title.setFont (titleFont);
	title.setForeground (titleColour);
	Panel p = new Panel ();
	JButton settings = new JButton ("Settings");
	settings.setActionCommand ("s3");
	settings.addActionListener (this);
	settings.setPreferredSize (new Dimension (150, 50));
	settings.setBackground (buttonColour);
	settings.setForeground (buttonText);
	JButton gameScreen = new JButton ("Game");
	gameScreen.setActionCommand ("s4");
	gameScreen.addActionListener (this);
	gameScreen.setPreferredSize (new Dimension (150, 50));
	gameScreen.setBackground (buttonColour);
	gameScreen.setForeground (buttonText);

	card2.add (title);
	p.add (settings);
	p.add (gameScreen);
	card2.add (p);
	p_card.add ("2", card2);
    }


    public void settings ()
    { //TO DO: Fill this comment in
	card3 = new Panel ();
	card3.setBackground (backgroundColour);
	JLabel title = new JLabel ("Choose your settings:");
	title.setFont (titleFont);
	title.setForeground (titleColour);
	Panel p = new Panel ();
	JLabel namePmt = new JLabel ("Your name:");
	namePmt.setFont (promptFont);
	name = new JTextField (10);
	name.setFont (promptFont);
	Panel p2 = new Panel ();
	JLabel choicePmt = new JLabel ("X or O:");
	choicePmt.setFont (promptFont);
	choice = new JTextField (4);
	choice.setFont (promptFont);
	Panel p3 = new Panel ();
	JLabel firstPmt = new JLabel ("Go first? y or n?");
	firstPmt.setFont (promptFont);
	first = new JTextField (4);
	first.setFont (promptFont);
	JButton entrance = new JButton ("To the game");
	entrance.setActionCommand ("s4");
	entrance.addActionListener (this);
	entrance.setPreferredSize (new Dimension (300, 50));
	entrance.setBackground (buttonColour);
	entrance.setForeground (buttonText);

	card3.add (title);
	p.add (namePmt);
	p.add (name);
	p2.add (choicePmt);
	p2.add (choice);
	p3.add (firstPmt);
	p3.add (first);
	card3.add (p);
	card3.add (p2);
	card3.add (p3);
	card3.add (entrance);
	p_card.add ("3", card3);
    }


    public void gameScreen ()
    { //TO DO: Fill this comment in
	card4 = new Panel ();
	card4.setBackground (backgroundColour);
	JLabel title = new JLabel ("Loikis Viking Chess");
	title.setFont (titleFont);
	title.setForeground (titleColour);
	Panel p2 = new Panel ();
	turnpic = new JLabel (createImageIcon ("c3.png"));
	JLabel ins = new JLabel ("The current turn:");
	p2.add (ins);
	p2.add (turnpic);

	Panel grid = new Panel (new GridLayout (row, col));
	int m = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (b [i] [j] == 7)
		{ //genrates rune border
		    int r = (int) (Math.random () * 3) + 7;
		    pics [m] = new JButton (createImageIcon (picStart + r + picFileType));
		    pics [m].setPreferredSize (new Dimension (sqDimension, sqDimension));
		    pics [m].setActionCommand (m + "");
		    pics [m].addActionListener (this);
		    pics [m].setBorder (null);
		    grid.add (pics [m]);
		    m++;
		}
		else
		{
		    pics [m] = new JButton (createImageIcon (picStart + b [i] [j] + picFileType));
		    pics [m].setPreferredSize (new Dimension (sqDimension, sqDimension));
		    pics [m].setActionCommand (m + "");
		    pics [m].addActionListener (this);
		    pics [m].setBorder (null);
		    grid.add (pics [m]);
		    m++;
		}
	    }
	}
	add (grid);
	//TO DO: Fill this comment in
	Panel p3 = new Panel ();
	JButton reset = new JButton ("Again");
	reset.addActionListener (this);
	reset.setActionCommand ("reset");
	reset.setPreferredSize (new Dimension (100, 30));
	reset.setBackground (buttonColour);
	reset.setForeground (buttonText);
	p3.add (reset);
	JButton instruct = new JButton ("Instructions");
	instruct.addActionListener (this);
	instruct.setActionCommand ("instruct");
	instruct.setPreferredSize (new Dimension (120, 30));
	instruct.setBackground (buttonColour);
	instruct.setForeground (buttonText);
	p3.add (instruct);
	JButton settings = new JButton ("Settings");
	settings.addActionListener (this);
	settings.setActionCommand ("settings");
	settings.setPreferredSize (new Dimension (100, 30));
	settings.setBackground (buttonColour);
	settings.setForeground (buttonText);
	p3.add (settings);

	card4.add (title);
	card4.add (p2);
	card4.add (grid);
	card4.add (p3);
	p_card.add ("4", card4);
    }



    public void actionPerformed (ActionEvent e)
    { //TO DO: Fill this comment in
	if (e.getActionCommand ().equals ("s1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("s3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("s4"))
	    cdLayout.show (p_card, "4");

	//TO DO: Fill this comment in
	else if (e.getActionCommand ().equals ("reset"))
	{

	}
	else if (e.getActionCommand ().equals ("settings"))
	{
	    cdLayout.show (p_card, "3");
	}
	else if (e.getActionCommand ().equals ("instruct"))
	{
	    cdLayout.show (p_card, "2");
	}
	//TO DO: Fill this comment in
	else
	{
	    int n = Integer.parseInt (e.getActionCommand ());
	    int x = n / col;
	    int y = n % col;
	    if (turn == 0)
	    {
		if (b [x] [y] == 2)
		{
		    clear (x, y);
		    moveselection (x, y);

		}
		else if (b [x] [y] == 1)
		{
		    move (x, y, 2);
		    turn = 1;
		    turnpic.setIcon (createImageIcon ("c3.png"));
		    clear (x, y);
		    capture (x, y, 2, 3);
		}


	    }
	    if (turn == 1)
	    {
		if (b [x] [y] == 3)
		{
		    clear (x, y);
		    moveselection (x, y);
		}
		else if (b [x] [y] == 1)
		{
		    move (x, y, 3);
		    turn = 0;
		    turnpic.setIcon (createImageIcon ("c2.png"));
		    clear (x, y);
		    capture (x, y, 3, 2);
		}

	    }
	}
    }


    public void capture (int x, int y, int team, int Oteam)
    { //there has to be a beter way
	//horazontal
	if (b [x - 1] [y] == Oteam && b [x - 2] [y] == team)
	    b [x - 1] [y] = 0;
	else if (b [x + 1] [y] == Oteam && b [x + 2] [y] == team)
	    b [x + 1] [y] = 0;
	if (b [x - 1] [y] == Oteam && b [x + 1] [y] == Oteam)
	    b [x] [y] = 0;
	//verdical
	if (b [x] [y - 1] == Oteam && b [x] [y - 2] == team)
	    b [x] [y - 1] = 0;
	else if (b [x] [y + 1] == Oteam && b [x] [y + 2] == team)
	    b [x] [y + 1] = 0;
	if (b [x] [y - 1] == Oteam && b [x] [y + 1] == Oteam)
	    b [x] [y] = 0;
	    //king
	redraw ();
    }


    public void move (int x, int y, int team)
    {
	b [px] [py] = 0;
	b [x] [y] = team;
	redraw ();
    }


    public void clear (int x, int y)
    {
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (b [i] [j] == 1)
		    b [i] [j] = 0;
	    }
	}
	redraw ();
    }


    public void moveselection (int x, int y)
    {
	//up
	int cx1 = x - 1;
	while (cx1 >= 0 && (b [cx1] [y] == 0 || b [cx1] [y] == 2))
	{
	if(b [cx1] [y] == 0)
	    b [cx1] [y] = 1;
	    /*else 
	    b [cx1] [y] = -1;*/
	    cx1--;
	}
	//down
	int cx2 = x + 1;
	while (cx2 < row && b [cx2] [y] == 0)
	{
	    b [cx2] [y] = 1;
	    cx2++;
	}
	//right
	int cy1 = y + 1;
	while (cy1 < col && b [x] [cy1] == 0)
	{
	    b [x] [cy1] = 1;
	    cy1++;
	}
	//left
	int cy2 = y - 1;
	while (cy2 >= 0 && b [x] [cy2] == 0)
	{
	    b [x] [cy2] = 1;
	    cy2--;
	}
	
	px = x;
	py = y;
	redraw ();
    }


    public void redraw ()
    {
	int m = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (!(b [i] [j] == 7))
		{
		pics [m].setIcon (createImageIcon ("c" + b [i] [j] + ".png"));
		}
		m++;
	    }
	}
    }



    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = GridStarter.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}


	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
}


