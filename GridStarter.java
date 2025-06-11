//Name: Griffin Tattongeyer
//Date: 2025, may 29 - june
//Purpose: to run Viking chess
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.applet.*;
import sun.audio.*;
import java.io.FileInputStream.*;
import java.io.File;
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
    //reset aray
    int br[] [] = {{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},
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
    int sqDimension = 27; //27
    JLabel turnpic;
    int turn = 3;
    int px, py;
    boolean kingmove = false;
    AudioClip soundFile;

    JButton save;
    Panel grid;
    //save vars
    PrintWriter out;
    BufferedReader in;

    //opening
    int titleVar = 0;
    JButton next;

    //Formatting
    Color backgroundColour = new Color (25, 86, 45);
    Color buttonColour = new Color (23, 113, 43);
    Color buttonText = new Color (253, 221, 9);
    Color titleColour = new Color (253, 221, 9);
    Font titleFont = new Font ("Arial", Font.PLAIN, 30);
    Font promptFont = new Font ("Arial", Font.PLAIN, 20);
    Dimension boardSquare = new Dimension (96, 96); //still not shure what this does
    String picStart = "c";
    String picFileType = ".png";

    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	opening ();
	instructions ();
	gameScreen ();
	resize (350, 500);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
	try
	{ //lodes the save into memory
	    in = new BufferedReader (new FileReader ("LokisSave.txt"));
	    for (int i = 0 ; i < row ; i++)
	    {
		for (int j = 0 ; j < col ; j++)
		{
		    b [i] [j] = Integer.parseInt (in.readLine ()); //throws an aray out of bounds error ask ms. Gorski
		}
	    }
	    turn = Integer.parseInt (in.readLine ());
	    in.close ();
	}
	catch (IOException e)
	{
	}
	redraw ();
	turnpic.setIcon (createImageIcon ("c" + turn + ".png"));

    }


    public void opening ()
    { //code for the opning
	card1 = new Panel ();
	card1.setBackground (backgroundColour);
	next = new JButton (createImageIcon ("loiki1.png"));
	next.setActionCommand ("s2");
	next.addActionListener (this);
	next.setBackground (buttonColour);
	next.setForeground (buttonText);
	next.setBorder (null);
	card1.add (next);
	p_card.add ("1", card1);
    }


    public void instructions ()
    { //sets up the instruction screen
	card2 = new Panel ();
	card2.setBackground (backgroundColour);
	JLabel title = new JLabel ("Welcome To Viking Chess");
	title.setFont (titleFont);
	title.setForeground (titleColour);
	JLabel instruct = new JLabel (createImageIcon ("instructions.png"));
	Panel p = new Panel ();
	JButton settings = new JButton ("Clear Save");
	settings.setActionCommand ("clearSave");
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
	card2.add (instruct);
	p.add (settings);
	p.add (gameScreen);
	card2.add (p);
	p_card.add ("2", card2);
    }


    public void gameScreen ()
    { //sets up the heder and the grid
	card4 = new Panel ();
	card4.setBackground (backgroundColour);
	JLabel title = new JLabel ("Lokis Viking Chess");
	title.setFont (titleFont);
	title.setForeground (titleColour);
	Panel p2 = new Panel ();
	turnpic = new JLabel (createImageIcon ("c3.png"));
	JLabel ins = new JLabel ("The current turn:");
	p2.add (ins);
	p2.add (turnpic);

	grid = new Panel (new GridLayout (row, col));
	int m = 0;
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		if (b [i] [j] == 7)
		{ //genrates rune border
		    int r = (int) (Math.random () * 8) + 7;
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
	//the set up code for the bottom of the screen
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
	save = new JButton ("Save Game");
	save.addActionListener (this);
	save.setActionCommand ("save");
	save.setPreferredSize (new Dimension (100, 30));
	save.setBackground (buttonColour);
	save.setForeground (buttonText);
	p3.add (save);

	soundFile = getAudioClip (getDocumentBase (), "alvedon.snd");
	//this attaches the sound file "alvedon"
	soundFile.loop ();
	//put the sound on repeat

	card4.add (title);
	card4.add (p2);
	card4.add (grid);
	card4.add (p3);
	p_card.add ("4", card4);
    }



    public void actionPerformed (ActionEvent e)
    { //action prefoms for moving around sceens
	if (e.getActionCommand ().equals ("s1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s2"))
	{
	    if (titleVar == 0) //changes the initial pic to the title pic
	    {
		next.setIcon (createImageIcon ("loiki2.png"));
		titleVar++;
	    }
	    else
		cdLayout.show (p_card, "2");
	}
	else if (e.getActionCommand ().equals ("s3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("s4"))
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("instruct"))
	{
	    cdLayout.show (p_card, "2");
	}

	//resets the bord
	else if (e.getActionCommand ().equals ("reset"))
	{
	    reset ();
	}
	else if (e.getActionCommand ().equals ("save"))
	{ //saves the game to LokisSave. txt
	    try
	    {
		out = new PrintWriter (new FileWriter ("LokisSave.txt"));
		for (int i = 0 ; i < row ; i++)
		{
		    for (int j = 0 ; j < col ; j++)
		    {
			out.println (b [i] [j]);
			//System.out.println ("test");
		    }
		}
		out.println (turn);
		//save ("LokisSave.txt");
		out.close ();
	    }
	    catch (IOException g)
	    {
		System.out.println ("Error opening file " + g);
	    }
	}
	else if (e.getActionCommand ().equals ("clearSave"))
	{ //removes the save fial so that the player can start fresh
	    File save = new File ("LokisSave.txt");
	    save.delete ();
	    reset ();
	}
	//handuls the slecting and movement of peces
	else
	{
	    int n = Integer.parseInt (e.getActionCommand ());
	    int x = n / col;
	    int y = n % col;
	    if (turn == 2)
	    {
		if (b [x] [y] == 2) //show movment
		{
		    clear (x, y);
		    moveselection (x, y, false);
		    kingmove = false;

		}
		else if (b [x] [y] == 1) //move stander peice
		{
		    move (x, y, 2);
		    turn = 3;
		    turnpic.setIcon (createImageIcon ("c3.png"));
		    clear (x, y);
		    capture (x, y, 2, 3);
		}
		else if (b [x] [y] == 4) //move king
		{
		    clear (x, y);
		    moveselection (x, y, true);
		    kingmove = true;
		}
		else if (b [x] [y] == 6)
		{

		    //Show a warning dialog with the options OK, CANCEL, title 'Warning',
		    // and message 'Click OK to continue':
		    Object[] options = {"reset bord", "view the bord"};
		    int ans = JOptionPane.showOptionDialog (null, "white has escaped the bord they win", "white win",
			    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			    null, options, options [0]);
		    if (ans == 0)
			reset ();
			//makes it so the bord can not be edited or saveed after win 
		    grid.setEnabled (false);
		    save.setEnabled (false);
		    kingmove = true;
		    move (x, y, 2);
		    clear (x, y);
		}

	    }
	    if (turn == 3)
	    {
		if (b [x] [y] == 3)
		{
		    clear (x, y);
		    moveselection (x, y, false);
		}
		else if (b [x] [y] == 1)
		{
		    move (x, y, 3);
		    turn = 2;
		    turnpic.setIcon (createImageIcon ("c2.png"));
		    clear (x, y);
		    capture (x, y, 3, 2);
		}
	    }
	}
    }


    public void reset ()
    { //resets the bord
	for (int i = 0 ; i < row ; i++)
	{
	    for (int j = 0 ; j < col ; j++)
	    {
		b [i] [j] = br [i] [j];
	    }
	}
	grid.setEnabled (true);
	save.setEnabled (true);
	redraw ();
    }


    //handuls the cheking for capshers
    public void capture (int x, int y, int team, int Oteam)
    { //there has to be a beter way. there is probly not going to fix it thou
	//verdical
	if (b [x - 1] [y] == Oteam && (b [x - 2] [y] == team || b [x - 2] [y] == 5))
	{
	    //System.out.println ("up");
	    b [x - 1] [y] = 0;
	}


	//king clause up
	else if (team == 2 && b [x - 1] [y] == Oteam && b [x - 2] [y] == 4)
	    b [x - 1] [y] = 0;
	else if (b [x + 1] [y] == Oteam && (b [x + 2] [y] == team || b [x + 2] [y] == 5))
	{
	    //System.out.println ("down");
	    b [x + 1] [y] = 0;
	}


	//king clause down
	else if (team == 2 && b [x + 1] [y] == Oteam && b [x + 2] [y] == 4)
	    b [x - 1] [y] = 0;

	//horazontal
	if (b [x] [y - 1] == Oteam && (b [x] [y - 2] == team || b [x] [y - 2] == 5))
	{
	    //System.out.println ("left");
	    b [x] [y - 1] = 0;
	}


	//king clause left
	else if (team == 2 && b [x] [y - 1] == Oteam && b [x] [y - 2] == 4)
	    b [x] [y - 1] = 0;
	else if (b [x] [y + 1] == Oteam && (b [x] [y + 2] == team || b [x] [y + 2] == 5))
	{
	    //System.out.println ("right");
	    b [x] [y + 1] = 0;
	}


	//king clause right
	else if (team == 2 && b [x] [y + 1] == Oteam && b [x] [y + 2] == 4)
	    b [x] [y - 1] = 0;

	//king
	if (team == 3)
	{ //really proud of this code
	    kingTake (x, y, -1, 0, -2, 0, -1, -1, 1, -1);  //under king
	    kingTake (x, y, 1, 0, 2, 0, 1, 1, -1, 1);  //above king
	    kingTake (x, y, 0, -1, 0, -2, -1, -1, 1, -1);  //right of king
	    kingTake (x, y, 0, 1, 0, 2, 1, 1, -1, 1); //left of king
	}


	redraw ();
    }


    public void kingTake (int x, int y, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
    { //genrlization for king capshers
	if (b [x + x1] [y + y1] == 4)
	{
	    if (b [x + x2] [y + y2] == 3 && b [x + x3] [y + y3] == 3 && b [x + x4] [y + y4] == 3)
	    {
		b [x + x1] [y + y1] = 0;
		Object[] options = {"reset bord", "view bord"};
		int ans = JOptionPane.showOptionDialog (null, "red has killed the king and won the game", "red win",
			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
			null, options, options [0]);
		if (ans == 0)
		    reset ();
		    //makes it so the bord can not be edited or saveed after win 
		grid.setEnabled (false);
		save.setEnabled (false);
		clear (x, y);
	    }
	}
    }


    public void move (int x, int y, int team)
    { //moves the peises

	if (kingmove == false)
	    b [x] [y] = team;
	else
	{
	    b [x] [y] = 4;
	    kingmove = false;
	}


	b [px] [py] = 0;
	soundEffect ("pieceMoveCut");
	redraw ();
    }


    public void clear (int x, int y)
    { //removes move tials
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


    public void moveselection (int x, int y, boolean king)
    { //creates move tials for relevent pieces
	//up
	int cx1 = x - 1;
	while (cx1 >= 0 && (b [cx1] [y] == 0 || b [cx1] [y] == 5))
	{
	    if (b [cx1] [y] == 0)
		b [cx1] [y] = 1;
	    else if (king == true && b [cx1] [y] == 5)
		b [cx1] [y] = 6;
	    cx1--;
	}


	//down
	int cx2 = x + 1;
	while (cx2 < row && b [cx2] [y] == 0 || b [cx2] [y] == 5)
	{
	    if (b [cx2] [y] == 0)
		b [cx2] [y] = 1;
	    else if (king == true && b [cx2] [y] == 5)
		b [cx2] [y] = 6;
	    cx2++;
	}


	//right
	int cy1 = y + 1;
	while (cy1 < col && b [x] [cy1] == 0 || b [x] [cy1] == 5)
	{
	    if (b [x] [cy1] == 0)
		b [x] [cy1] = 1;
	    else if (king == true && b [x] [cy1] == 5)
		b [x] [cy1] = 6;
	    cy1++;
	}


	//left
	int cy2 = y - 1;
	while (cy2 >= 0 && b [x] [cy2] == 0 || b [x] [cy2] == 5)
	{
	    if (b [x] [cy2] == 0)
		b [x] [cy2] = 1;
	    else if (king == true && b [x] [cy2] == 5)
		b [x] [cy2] = 6;
	    cy2--;
	}


	px = x;
	py = y;
	soundEffect ("pieceSelectCut"); // make so can not be spamed
	redraw ();
    }


    public void redraw ()
    { //updates the screen to mach the aray
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


    //For a single sound effect
    public void soundEffect (String filepath)
    {
	//initialize objects
	//declare sound effect player
	AudioPlayer SEP = AudioPlayer.player;
	//declare sound effect
	AudioStream SE;
	//declare audio data
	AudioData MA;
	//set as single run (NOT LOOP)
	AudioDataStream play = null;

	try
	{
	    //set file
	    SE = new AudioStream (new FileInputStream (filepath + ".wav"));
	    MA = SE.getData ();
	    //set data to play once (NOT LOOP)
	    play = new AudioDataStream (MA);
	}


	catch (IOException error)
	{
	    System.out.println ("Audio - File not found.");
	}


	SEP.start (play);
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


