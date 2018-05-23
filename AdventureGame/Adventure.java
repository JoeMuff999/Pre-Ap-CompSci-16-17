import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.io.*;
import javax.swing.*;
import java.util.Scanner;
import java.awt.Container;

public class Adventure extends Frame implements WindowListener, ActionListener
{
    private int area;
    private boolean hasKey;
    private boolean lease = false;
    private boolean hasSword;
    private boolean hasB;
    private boolean hasA;
    private boolean hasC;
    private boolean hasTreasure;
    private boolean mDead;
    private boolean close = false;
    private JTextField text = new JTextField();
    private JLabel textBox = new JLabel();
    private JButton[][] buttons;
    private JButton mainPanel = new JButton();
    private JLabel inventory = new JLabel();
    private int[] areaNumber;
    private String command = "";
    private String textEntered;
    boolean please = false;
    private boolean k = false;
    private boolean L = false;
    private boolean u = false;
    private boolean i = false; 
    private boolean asdf = false;
    private boolean monsterDead = false;

    public Adventure()
    {
        area = 0;
        hasKey = false;
        hasSword = false;
        hasA= false;
        hasB = false; 
        hasC = false;
        hasTreasure = false;
        mDead = false;

        areaNumber = new int[20];
        //
        //
        //

        Panel panelButtons = new Panel(new GridLayout(2,2));
        Panel something = new Panel(new GridLayout(1,1));
        mainPanel = new JButton();

        something.add(mainPanel);
        inventory = new JLabel();
        inventory.setIcon(new ImageIcon("inventory.png"));
        Dimension inventorySize = new Dimension(250,900);
        Dimension inventorySizex = new Dimension(1500,80);
        inventory.setPreferredSize(inventorySize);
        textBox.setPreferredSize(inventorySizex);
        text = new JTextField();
        text.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String textEntered = text.getText();
                    command = textEntered.toLowerCase();
                    nextCommand();
                    areaDescription();

                    if(u == true)
                    {
                        u = false;
                        mainPanel.setIcon(new ImageIcon ("FightRun.png"));
                        textBox.setText("<html>"+  "<br>YOU RAN?!?!?!?!? I PUT SO MUCH WORK INTO THIS GAME AND YOU RUN??? THE MONSTER OBLITERATES YOU MUAHAHAHA!!!"+"<br>" +textBox.getText() );
                    }
                    if(i == true)
                    {
                        i = false;
                         mainPanel.setIcon(new ImageIcon ("Fight.png"));
                        textBox.setText("<html>"+  "<br>THE MONSTER CROSSES YOU UP, BREAKS YOUR ANKLES, POSTS IT TO WORLDSTAR, THEN DESTROYS YOU..."+"<br>" +textBox.getText() );
                    }
                    if(asdf = true && (area == 20))
                    {
                        mainPanel.setIcon(new ImageIcon("th.gif"));
                    }

                    if(textEntered.equals ("A") && area ==12)
                    {
                        hasSword = true;
                        //inventory.setIcon(new ImageIcon("inventorySword.png"));
                    }
                    if(L == true)
                    {
                        L = false;
                        mainPanel.setIcon(new ImageIcon ("rickSmillin.jpg"));
                        textBox.setText("<html>"+textBox.getText()+  "<br>Rick gladly give you the key...Take it to the start and unlock that door!!! Go WEST to exit the shop...");
                    }
                    if(lease == true)
                    {
                        lease = false;
                        textBox.setText("<html>"+textBox.getText()+  "<br>Made by Joey Muffoletto");
                    }
                    if(k == true)
                    {
                        k = false;	
                        textBox.setText("<html>"+textBox.getText()+  "<br>The gold coin feels heavier than it should... take this back to Rick and maybe he will give you something for it...EXIT the cave?");
                    }
                    inventoryForNestedMethods();

                    text.setText("");
                }
            });
        areaDescription();
        setLayout(new BorderLayout());
        buttons = new JButton[2][2];
        for(int x = 0; x < 2; x++)
        {
            for(int y = 0; y < 2; y++)
            {
                buttons[x][y] = new JButton();
                Dimension arrows = new Dimension(200,350);
                buttons[x][y].setPreferredSize(arrows);

                panelButtons.add(buttons[x][y]);
                buttons[x][y].addActionListener(this);

            }
        }

        buttons[0][0].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String xd = "";

                    xd = "north";

                    command = xd;
                    nextCommand();
                    areaDescription();
                    if(please == true)
                    {
                        please = false;
                        textBox.setText("<html>"+textBox.getText()+  "<br>You cannot go that way...");
                    }
                    inventoryForNestedMethods();

                    xd = "";
                }
            });
        buttons[1][0].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String xd = "";

                    xd = "west";

                    command = xd;
                    nextCommand();
                    areaDescription();
                    if(please == true)
                    {
                        please = false;
                        textBox.setText("<html>"+textBox.getText()+  "<br>You cannot go that way...");
                    }
                    inventoryForNestedMethods();
                    xd = "";
                }
            });
        buttons[0][1].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String xd = "";

                    xd = "south";

                    command = xd;
                    nextCommand();
                    areaDescription();
                    if(please == true)
                    {
                        please = false;
                        textBox.setText("<html>"+textBox.getText()+  "<br>You cannot go that way...");
                    }
                    inventoryForNestedMethods();

                    xd = "";
                }
            });
        buttons[1][1].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String xd = "";

                    xd = "east";

                    command = xd;
                    nextCommand();
                    areaDescription();
                    if(please == true)
                    {
                        please = false;
                        textBox.setText("<html>"+textBox.getText()+  "<br>You cannot go that way...");
                    }
                    if(asdf = true && (area == 20 || area == 21))
                    {
                        mainPanel.setIcon(new ImageIcon("h.jpg"));
                    }
                    inventoryForNestedMethods();

                    xd = "";
                }
            });

        buttons [0][0].setIcon(new ImageIcon("arrows.png"));
        buttons [0][1].setIcon(new ImageIcon("Darrows.png"));
        buttons [1][1].setIcon(new ImageIcon("Rarrows.png"));
        buttons [1][0].setIcon(new ImageIcon("Larrows.png"));
        Dimension buttonSize = new Dimension(200,400);
        for(int x = 0; x < 2; x++)
        {
            for(int y = 0; y< 2; y++)
            {
                buttons[x][y].setPreferredSize(buttonSize);
            }
        }

        add(inventory, BorderLayout.EAST);
        add(something, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.WEST);
        add(text, BorderLayout.SOUTH);

        Font font = new Font("Times New Roman",Font.BOLD,16);
        textBox.setFont(font);
        //textBox.setEditable(false);
        add(textBox,BorderLayout.NORTH);

        setTitle("ADVENTURE");

        setSize(1460,990);

        setVisible(true);

        addWindowListener(this);
    }

    public static void main(String args[])
    {
        new Adventure();
        Scanner keyboard = new Scanner(System.in);
        AdventureGame test = new AdventureGame();

        /*  while(test.gameOver() == false)
        {
        //System.out.println();
        test.areaDescription();
        //System.out.println("What do you want to do? ");
        test.nextCommand(keyboard.next());
        }*/
    }

    public void inventoryForNestedMethods()
    {
        if(hasSword == true)
        {
            inventory.setIcon(new ImageIcon("inventorySword.png"));
        }
        else if(hasTreasure == true)
        {
            inventory.setIcon(new ImageIcon("Inventory coin.png"));
        }
        else if(hasKey == true)
        
        {
            inventory.setIcon(new ImageIcon("InventoryKey.png"));
        }
        else
        {
            inventory.setIcon(new ImageIcon("inventory.png"));
        }
    }

    public void areaDescription()
    {
        switch(area)
        {
            case 0: 
            //textBox.setText("You are in an abandoned house. You can go west or south...There is a locked door here leading east");
            mainPanel.setIcon(new ImageIcon("Haunted.jpg"));
            if(area == 0 && hasKey == false && command == "east")
            {
                textBox.setText("<html>You are in an abandoned house. You can go west or south...There is a locked door here leading east <br> The door is locked...");
            }
            else if (area == 0)
            {
                textBox.setText("You are in an abandoned house. You can go west or south...There is a locked door here leading east");
            }

            break;
            case 1 :  textBox.setText("<html> You find yourself in a pitch black room...a sign to the North and South read \" DANGER!!! \"");
            mainPanel.setIcon(new ImageIcon("caseOneRoom.jpg"));  
            if (area == 1 && (command =="south" || command =="north"))
            {

                area = 4;
            }

            break;
            case 2:  textBox.setText("Its a giant Hole!!!");
            break;
            case 3:  textBox.setText("Its a giant Hole!!!");
            break;
            case 4:  
            mainPanel.setIcon(new ImageIcon("restartImage.jpg"));  
            textBox.setText("<html>You died lol... <br> Type \"restart\" to start over");

            break;
            
            case 5:  textBox.setText("You leave the house, further south you see a cave deep inside a forest...You can go south.");
            mainPanel.setIcon(new ImageIcon("forestCaseFive.gif"));  
            break;
            case 6:  textBox.setText("As you approach the cave, you notice a shop to the east...Might be useful to visit before venturing to the cave.");
            mainPanel.setIcon(new ImageIcon("forestWithShop.jpg"));  
            break;
            case 7:  textBox.setText("A battered sign outside of the cave reads \"DEATH AHEAD\"...Your instinct tells you to turn back and maybe find a weapon before going inside...");
            mainPanel.setIcon(new ImageIcon("cave.png"));  
            break;
            case 8:  textBox.setText("After defeating the monster, you notice a glimmer in the cave to the south...");
            mainPanel.setIcon(new ImageIcon("caveWin.png"));  
            break;
            case 9:  textBox.setText("You venture eastward, inspecting the shop as you get closer...Your mind tells you to keep getting closer...");
            mainPanel.setIcon(new ImageIcon("forestCabin.jpg"));  
            break;
            
            case 10: mainPanel.setIcon(new ImageIcon("harrisonCabin.jpg"));   textBox.setText("<html>The shop comes into view... the sign out front reads \"Rick's pawn shop\", with the slogan \"you never know WHAT is gonna come through that door!\"");
            
            break;
            case 11:mainPanel.setIcon(new ImageIcon("harrisonBoi.jpg"));    textBox.setText("<html>As you enter the shop, a lovely redneck gentleman behind a glass display case says to you \"I’m Rick Harrison, and this is my pawn shop.<br> I work here with my old man and my son, Big Hoss. Everything in here has a story and a price.\"...You should TALK to him, maybe he has something to sell to you of interest...");
            break;
            case 12: mainPanel.setIcon(new ImageIcon("ricky.jpg"));   textBox.setText("<html>Mr. Harrison introduces himself as the shop owner, and asks if he can help you...(Use letters as the command) <br> A). Call him \"Big Hoss\" <br> B). Ask about where you are. <br> C). Inquire about the KEY in the display case.");
            if( hasA== true )
            {
                textBox.setText("<html>Mr. Harrison introduces himself as the shop owner, and asks if he can help you...(Use letters as the command)<br> B). Ask about where you are. <br> C). Inquire about the KEY in the display case.");

            }
            else if (hasB == true)
            {
                textBox.setText("<html>Mr. Harrison introduces himself as the shop owner, and asks if he can help you...(Use letters as the command)<br> A). Call him \"Big Hoss\"<br> C). Inquire about the KEY in the display case.");
            }

            else
            {
                textBox.setText("<html>Mr. Harrison introduces himself as the shop owner, and asks if he can help you...(Use letters as the command) <br> A). Call him \"Big Hoss\" <br> B). Ask about where you are. <br> C). Inquire about the KEY in the display case.");
            }
            break;
            case 13:  textBox.setText("<html>Mr. Harrison blushes, thanks your for your kind remarks, and gives you an antique sword for being nice...This might be useful to take to the cave...<br>TALK to him you would like to know more, or go WEST to leave...");
            break;
            case 14:  textBox.setText("<html>Mr. Harrison tells you that you are in a random forest, and that the only way out is to unlock the door from where you started with the KEY that he has in the display case...<br>TALK to him about something else??? West to leave.");
            break;
            case 15:  textBox.setText("<html>Mr. Harrison tells you that this is they KEY to unlock the door from the start...<br>To buy it from him would require you to go to the cave to the south and give him the treasure you find...<br>TALK to him about something else??? West to leave.");
            break;
            case 16:  textBox.setText("<html>As you walk deeper into the cave past the monster, you notice a gold coin... TAKE this coin??? Maybe Rick would find this useful?");

            break;
            case 17:  textBox.setText("<html>Rick notices the gold coin in your hand... he tells you that he will give you the key for the coin... GIVE it to him???");
            
            break;
           
            case 18:  mainPanel.setIcon(new ImageIcon("FightSword.png"));  textBox.setText("<html>The room is encrusted with gold, a diamond chandelier flails from the ceiling....A MONSTER STANDS IN THE CENTER!!! PREPARE FOR BATTLE !!!<br> A). RUN LIKE A BABY?!?!?  <br> B). STRIKE WITH YOUR SWORD!!! <br> C). SUMMON RICK HARRISON?! (USE one,two,three) ");
            break;
            //case 19 is the if they die from the fight ("You felt like you died, but the its almost like God gave you a second chance so you wouldn't have to do everything again...")
            case 19:   textBox.setText("<html>You felt like you died, but the its almost like God gave you a second chance so you wouldn't have to do everything again...Go east to restart the battle...");
            break;
            case 21: textBox.setText("<html>YOU HAVE CHOSEN WISELY!!! <br> Rick appears and slowly whispers to the monster \" you never know whats going to come through that d o o r\" <br> the monster EXPLODES into a million pieces...<br>Go east to claim your prize...");
            break;
            case 20:  textBox.setText("AYY YOU DID IT LETS GOOO WOOOOOOO");
            break; 
            default :  textBox.setText("You are somewhere unknown.");

            break;
        }
    }

    public void nextCommand()
    {
        command = command.toLowerCase();
        switch(command)
        {
            case "west" : if(area==0)
            {

                area = 1;

            }

            else if(area == 9)
            {
                area = 6;
            }
            else if (area == 10)
            {
                area = 9;
            }
            else if(area == 12)
            {
                area = 10;
            }
            else if(area == 13)
            {
                area = 10;
            }
            else if(area == 14)
            {
                area = 10;
            }
            else if(area == 15)
            {
                area = 10;
            }
            else if(area == 17)
            {
                area = 10;
            }
            else
            {

                please = true;

            }
            break;

            case "south" :
            if(area == 1)
            {
                area = 4;
                ////System.out.println("You fall to your death...");
            }
            else if(area == 0)
            {
                area = 5;
            }
            else if(area == 5)
            {
                area = 6;
            }
            else if(area == 6 && hasSword == true)
            {
                textBox.setText("As you approach the Cave, you realize you feel safe with your sword...");
                area = 7;
            }
            else if(area == 6 && hasSword == false)
            {
                // //System.out.println("Without a weapon your instinct screams at you to turn back and head to the shop...");
                area = 7;
            }
            else if(area == 7&& hasSword == false && monsterDead == false)
            {
                area = 4;
                ////System.out.println("A giant monster attacks you upon entering the cave... Without a weapon you stood no chance...");
            }
            else if(area ==7 && hasSword == true)
            {
                area = 8;
                hasSword = false;
                monsterDead = true;
                //inventory.setIcon(new ImageIcon("inventory.png"));
                // //System.out.println("A giant monster attacked you upon entering the cave, however, with a quick strike from your sword you easily take it down...");
            }
            else if(area == 8 && hasTreasure == false)
            {
                area = 16;
            }
            else
            {
                please = true;
                textBox.setText(textBox.getText()+  "You cannot go that way...");
            }
            break;

            case "east" :
            if(area == 0 && hasKey == false)
            {
                textBox.setText("The door is locked...");
            }
            else if(area == 1)
            {
                area = 0;
            }
            else if(area == 0 && hasKey == true)
            {
                // //System.out.println("You unlocked the door!!!");
                hasKey = false;
                area = 18;
            }
            else if(area == 6)
            {
                area = 9;
            }
            else if(area == 9)
            {
                area = 10;
            }
            else if(area == 10 && hasTreasure == false)
            {
                area = 11;
            }
            else if(area == 10 && hasTreasure == true)
            {
                area = 17;
            }
            else if(area == 18 && mDead == true)
            {
                area = 20;

            }
            else if(area == 21)
            {
                area = 20;
                asdf = true;
            }
            else if(area == 19)
            {
                area = 18;
            }
            else
            {
                please = true;
                ////System.out.println("You cannot go that way...");
            }
            break;
            case "north":if (area == 1)
            {
                area = 4;
                ////System.out.println("You fall to your death...");
            }
            else if(area == 7)
            {
                area = 6;
            }
            else if(area == 6)
            {
                area = 5;
            }
            else if(area == 5)
            {
                area = 0;
            }
            else
            {
                please = true;
                ////System.out.println("You cannot go that way...");
            }
            break;
            case "restart": 
            if(area == 4 )
            {
                area = 0;
            }
            else
            {
                ////System.out.println("You haven't died yet!!!");
            }
            break;
            case"talk":
            if(area == 11)
            {
                area = 12;
            }
            else if(area == 14)
            {
                area = 12;
            }
            else if(area == 13)
            {
                area = 12;
            }
            else if(area == 15)
            {
                area =12;
            }
            else
            {
                ////System.out.println("Don't talk to yourself you weirdo...");
            }
            break;
            case "a":
            if(area == 12 && hasA == false)
            {
                area = 13;
                hasSword = true;
                hasA = true;
            }
            else if( hasA== true)
            {
                ////System.out.println("You already complimented him you weirdo...Mr. Harrison might consider taking that sword back...");
            }
            else
            {
                ////System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "b":
            if(area == 12 && hasB == false)
            {
                area = 14;
                hasB = true;
            }
            else if(hasB == true)
            {
                //System.out.println("You already asked that question you weirdo...Mr. Harrison doesnt like repeating things...");
                area = 12;
            }
            else
            {
                //System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "c":
            if(area == 12 && hasC == false)
            {
                area = 15;
                hasC = true;
            }
            else if(hasC == true)
            {
                //System.out.println("Stop asking about the key and go get the treasure...");
            }
            else
            {
                //System.out.println("Command not applicable...Check Directions!");
            }

            break;
            case "take":
            if(area == 16 && hasTreasure == false && hasC == false)
            {
                hasTreasure = true;

                area = 16;
                k = true;
                //System.out.println("The gold coin feels heavier than it should... take this back to Rick and maybe he will give you something for it...EXIT the cave?");

            }
            else if(area == 16 && hasTreasure == false && hasC == true)
            {
                hasTreasure = true;
                area = 16;
                k = true;
                //System.out.println("The gold coin feels heavier than it should...Take this to Rick to exchange it for the key...EXIT the cave?");
            }
            else if(area == 16 && hasTreasure == true)
            {
                area = 16;
                //System.out.println("You already have the coin!!!");
            }
            else
            {
                //System.out.println("You can't take anything...");

            }
            break;
            case "exit":
            if(area == 16)
            {
                area = 7;
            }
            else
            {
                //System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "give":
            if(area == 17)
            {
                hasKey = true;
                L = true;
                hasTreasure= false;
                //System.out.println("Rick gladly give you the key...Take it to the start and unlock that door!!!Go WEST to exit the shop...");
            }
            else
            {
                //System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "one": 
            if(area == 18)
            {
                //System.out.println("YOU RAN?!?!?!?!? I PUT SO MUCH WORK INTO THIS GAME AND YOU RUN??? THE MONSTER OBLITERATES YOU MUAHAHAHA!!!");
                u = true;
                area = 19;
            }
            else
            {
                //System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "two":
            if(area == 18)
            {
                //System.out.println("THE MONSTER CROSSES YOU UP, BREAKS YOUR ANKLES, POSTS IT TO WORLDSTAR, THEN DESTROYS YOU...");
                i = true;
                area = 19;
            }
            else
            {
                //System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "three":
            if(area == 18)
            {
                //System.out.println("YOU HAVE CHOSEN WISELY!!! <br> Rick appears and slowly whispers to the monster \" you never know whats going to come through that d o o r\" <br> the monster EXPLODES into a million pieces...");
                mDead = true;
                area = 21;
            }
            else
            {
                //System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "help":
            //System.out.println("The main commands are \"south\",\"east\",\"west\",\"north\", with \"take\", \"talk\", \"give\",\"restart\",\"a\",\"b\",\"c\",\"one\",\"two\",\"three\", and \"exit\" being situational");
            break;
            case "credit":
            lease = true;
            //System.out.println("Made by Joey Muffoletto");
            break;

            case "credits":
            lease = true;
            //System.out.println("Made by Joey Muffoletto");
            break;
            default : //System.out.println("I don't know that command."); break;
        }
    }

    public boolean gameOver()
    {
        if(area == 20)
        {
            //System.out.println("You escaped the forest...Congrats!");
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

    }

    @Override
    public void windowClosing(WindowEvent evt) {
        System.exit(0);  
        close = true;
    }

    @Override public void windowOpened(WindowEvent evt) { }

    @Override public void windowClosed(WindowEvent evt) { }

    @Override public void windowIconified(WindowEvent evt) { }

    @Override public void windowDeiconified(WindowEvent evt) { }

    @Override public void windowActivated(WindowEvent evt) { }

    @Override public void windowDeactivated(WindowEvent evt) { }
}
