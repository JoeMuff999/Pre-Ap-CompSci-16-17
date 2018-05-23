public class AdventureGame
{
    private int area;
    private boolean hasKey;
    
    private boolean hasSword;
    private boolean hasB;
    private boolean hasA;
    private boolean hasC;
    private boolean hasTreasure;
    private boolean mDead;

    public AdventureGame()
    {
        area = 0;
        hasKey = false;
        hasSword = false;
        hasA= false;
        hasB = false; 
        hasC = false;
        hasTreasure = false;
        mDead = false;
        
    }

    public void areaDescription()
    {
        switch(area)
        {
            case 0 : System.out.println("You are in an abandoned house. You can go west or south...");
            System.out.println("There is a locked door here leading east");
            break;
            case 1 : System.out.println("You find yourself in a pitch black room...a sign to the North and South read \" DANGER!!! \"");
            break;
            case 2: System.out.println("Its a giant Hole!!!");
            break;
            case 3: System.out.println("Its a giant Hole!!!");
            break;
            case 4: System.out.println("You died, type \"restart\" to start over");
            break;
            case 5: System.out.println("You leave the house, further south you see a cave deep inside a forest...You can go south.");
            break;
            case 6: System.out.println("As you approach the cave, you notice a shop to the east...Might be useful to visit before venturing to the cave.");
            break;
            case 7: System.out.println("A battered sign outside of the cave reads \"DEATH AHEAD\"...Your instinct tells you to turn back and maybe find a weapon before going inside...");
            break;
            case 8: System.out.println("After defeating the monster, you notice a glimmer in the cave to the south...");
            break;
            case 9: System.out.println("You venture eastward, inspecting the shop as you get closer...Your mind tells you to keep getting closer...");
            break;
            case 10: System.out.println("The shop comes into view... the sign out front reads \"Rick's pawn shop\", with the slogan \"you never know WHAT is gonna come through that door!\"");
            break;
            case 11: System.out.println("As you enter the shop, a lovely redneck gentleman behind a glass display case says to you \"I’m Rick Harrison, and this is my pawn shop.\n I work here with my old man and my son, Big Hoss. Everything in here has a story and a price.\"...You should TALK to him, maybe he has something to sell to you of interest...");
            break;
            case 12: System.out.println("Mr. Harrison introduces himself as the shop owner, and asks if he can help you...(Use letters as the command) \n A). Call him \"Big Hoss\" \n B). Ask about where you are. \n C). Inquire about the KEY in the display case.");
            break;
            case 13: System.out.println("Mr. Harrison blushes, thanks your for your kind remarks, and gives you an antique sword for being nice...This might be useful to take to the cave...\nTALK to him you would like to know more, or go WEST to leave...");
            break;
            case 14: System.out.println("Mr. Harrison tells you that you are in a random forest, and that the only way out is to unlock the door from where you started with the KEY that he has in the display case...\nTALK to him about something else??? West to leave.");
            break;
            case 15: System.out.println("Mr. Harrison tells you that this is they KEY to unlock the door from the start...\nTo buy it from him would require you to go to the cave to the south and give him the treasure you find...\nTALK to him about something else??? West to leave.");
            break;
            case 16: System.out.println("As you walk deeper into the cave past the monster, you notice a gold coin... TAKE this coin??? Maybe Rick would find this useful?");
            break;
            case 17: System.out.println("Rick notices the gold coin in your hand... he tells you that he will give you the key for the coin... GIVE it to him???");
            break;
            case 18: System.out.println("The room is encrusted with gold, a diamond chandelier flails from the ceiling....A MONSTER STANDS IN THE CENTER!!! PREPARE FOR BATTLE !!!\n A). RUN LIKE A BABY?!?!?  \n B). STRIKE WITH YOUR SWORD!!! \n C). SUMMON RICK HARRISON?! (USE one,two,three) ");
            break;
            //case 19 is the if they die from the fight ("You felt like you died, but the its almost like God gave you a second chance so you wouldn't have to do everything again...")
            case 19: System.out.println("You felt like you died, but the its almost like God gave you a second chance so you wouldn't have to do everything again...Go east to restart the battle...");
            break;
            case 21:System.out.println("Go east to claim your prize...");
            break;
            case 20: System.out.println("AYY YOU DID IT LETS GOOO WOOOOOOO");
            break;
            default : System.out.println("You are somewhere unknown.");

            
            break;
        }
    }

    public void nextCommand(String command)
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
                System.out.println("You cannot go that way.");
            }
            break;

            case "south" :
            if(area == 1)
            {
                area = 4;
                System.out.println("You fall to your death...");
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
                System.out.println("Despite the risk of the cave you feel safe with your sword...");
                area = 7;
            }
             else if(area == 6 && hasSword == false)
            {
                System.out.println("Without a weapon your instinct screams at you to turn back and head to the shop...");
                area = 7;
            }
            else if(area == 7&& hasSword == false)
            {
                area = 4;
                System.out.println("A giant monster attacks you upon entering the cave... Without a weapon you stood no chance...");
            }
            else if(area ==7 && hasSword == true)
            {
                area = 8;
                System.out.println("A giant monster attacked you upon entering the cave, however, with a quick strike from your sword you easily take it down...");
            }
            else if(area == 8 && hasTreasure == false)
            {
                area = 16;
            }
            else
            {
                System.out.println("You cannot go that way...");
            }
            break;
            
            case "east" :
           if(area == 0 && hasKey == false)
           {
               System.out.println("The door is locked...");
            }
            else if(area == 1)
            {
                area = 0;
            }
           else if(area == 0 && hasKey == true)
           {
               System.out.println("You unlocked the door!!!");
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
            }
            else if(area == 19)
            {
                area = 0;
            }
            else
            {
                System.out.println("You cannot go that way...");
            }
            break;
            case "north":if (area == 1)
            {
                area = 4;
                System.out.println("You fall to your death...");
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
                System.out.println("You cannot go that way...");
            }
            break;
            case "restart": 
            if(area == 4 )
            {
                area = 0;
            }
            else
            {
                System.out.println("You haven't died yet!!!");
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
                System.out.println("Don't talk to yourself you weirdo...");
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
                System.out.println("You already complimented him you weirdo...Mr. Harrison might consider taking that sword back...");
            }
            else
            {
                System.out.println("Command not applicable...Check Directions!");
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
                System.out.println("You already asked that question you weirdo...Mr. Harrison doesnt like repeating things...");
                area = 12;
            }
            else
            {
                System.out.println("Command not applicable...Check Directions!");
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
                System.out.println("Stop asking about the key and go get the treasure...");
            }
            else
            {
                System.out.println("Command not applicable...Check Directions!");
            }
            
            break;
            case "take":
            if(area == 16 && hasTreasure == false && hasC == false)
            {
                hasTreasure = true;
                System.out.println("The gold coin feels heavier than it should... take this back to Rick and maybe he will give you something for it...EXIT the cave?");
                
            }
            else if(area == 16 && hasTreasure == false && hasC == true)
            {
                hasTreasure = true;
                System.out.println("The gold coin feels heavier than it should...Take this to Rick to exchange it for the key...EXIT the cave?");
            }
            else if(area == 16 && hasTreasure == true)
            {
                System.out.println("You already have the coin!!!");
            }
            else
            {
                System.out.println("You can't take anything...");
        
            }
            break;
            case "exit":
            if(area == 16)
            {
                area = 7;
            }
              else
            {
                System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "give":
            if(area == 17)
            {
                hasKey = true;
                System.out.println("Rick gladly give you the key...Take it to the start and unlock that door!!!Go WEST to exit the shop...");
            }
              else
            {
                System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "one": 
            if(area == 18)
            {
                System.out.println("YOU RAN?!?!?!?!? I PUT SO MUCH WORK INTO THIS GAME AND YOU RUN??? THE MONSTER OBLITERATES YOU MUAHAHAHA!!!");
                area = 19;
            }
            else
            {
                System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "two":
            if(area == 18)
            {
                System.out.println("THE MONSTER CROSSES YOU UP, BREAKS YOUR ANKLES, POSTS IT TO WORLDSTAR, THEN DESTROYS YOU...");
                area = 19;
            }
            else
            {
                System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "three":
            if(area == 18)
            {
                System.out.println("YOU HAVE CHOSEN WISELY!!! \n Rick appears and slowly whispers to the monster \" you never know whats going to come through that d o o r\" \n the monster EXPLODES into a million pieces...");
                mDead = true;
                area = 21;
            }
            else
            {
                System.out.println("Command not applicable...Check Directions!");
            }
            break;
            case "help":
            System.out.println("The main commands are \"south\",\"east\",\"west\",\"north\", with \"take\", \"talk\", \"give\",\"restart\",\"a\",\"b\",\"c\",\"one\",\"two\",\"three\", and \"exit\" being situational");
            break;
            case "credit":
            System.out.println("Made by Joey Muffoletto");
            break;
            case "credits":
            System.out.println("Made by Joey Muffoletto");
            break;
            default : System.out.println("I don't know that command."); break;
        }
    }

    public boolean gameOver()
    {
        if(area == 20)
        {
            System.out.println("You escaped the forest...Congrats!");
            return true;
        }
        else
        {
            return false;
        }
    }
}