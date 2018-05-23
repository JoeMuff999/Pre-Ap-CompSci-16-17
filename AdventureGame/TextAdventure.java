public class TextAdventure
{
    private int whichRoom;
    private boolean hasKey;
    private boolean isLocked;
    
    public TextAdventure()
    {
        whichRoom = 0;
        hasKey = false;
        isLocked = true;
    }

    public void roomDescription()
    {
        switch(whichRoom)
        {
            case 0: System.out.println("You are in the woods. Exits are NORTH and EAST.");
            break;
            case 1: System.out.println("You are in the mountains. Exits are SOUTH.");
            if(hasKey==false)
            {
                System.out.println("There is a key on the ground.");
            }
            break;
            case 2: System.out.println("You are in the desert. Exits are WEST and EAST.");
            break;
            case 3: System.out.println("You are in a cave. Exits are WEST.");
            if(isLocked==true)
            {
                System.out.println("There is a locked door here.");
            }
            else
            {
                System.out.println("There is a door here. It is unlocked, so you may GO INSIDE.");
            }
            break;
            default: System.out.println("I'm not sure where you are."); 
            break;
        }
    }

    public void nextCommand(String command, String description)
    {
        command = command.toLowerCase();
        description = description.toLowerCase();
        switch(command)
        {
            case "go " : go(description);
            break;
            case "take": take(description);
            break;
            case "use": use(description);
            break;
            case "exit": whichRoom = 5;
            case "quit": whichRoom = 5;
            break;
            case "help": System.out.println("Enter two word commands. For example, GO SOUTH or USE KEY.\nCommands I know are GO, TAKE, USE, and QUIT GAME.");
            break;
            default: System.out.println("I don't understand the command " + command + ". Type HELP ME for help.");
            break;
        }
    }

    public void go(String where)
    {
        switch(where)
        {
            case "north": if(whichRoom==0)
            {
                whichRoom=1;
            }
            else
            {
                System.out.println("You cannot go that way.");
            }
            break;
            case "south":if(whichRoom==1)
            {
                whichRoom=0;
            }
            else
            {
                System.out.println("You cannot go that way.");
            }
            break;
            case "west":if(whichRoom==2)
            {
                whichRoom=0;
            }
            else if(whichRoom==3)
            {
                whichRoom = 2;
            }
            else
            {
                System.out.println("You cannot go that way.");
            }
            break;
            case "east":if(whichRoom==0)
            {
                whichRoom=2;
            }
            else if(whichRoom==2)
            {
                whichRoom=3;
            }
            else
            {
                System.out.println("You cannot go that way.");
            }
            break;
            case "inside":if(whichRoom==3&&isLocked==false)
            {
                System.out.println("You win!");
                whichRoom=5;
            }
            else if(whichRoom==3)
            {
                System.out.println("The door is locked.");
            }
            else
            {
                System.out.println("You cannot go that way.");
            }
            break;
            default: System.out.println("You cannot go that way.");
            break;
        }
    }

    public void take(String what)
    {
        switch(what)
        {
            case "key": if(whichRoom==1&&hasKey==false)
            {
                System.out.println("You take the key.");
                hasKey=true;
            }
            else if(whichRoom==1)
            {
                System.out.println("You already have the key.");
            }
            else
            {
                System.out.println("There is no key here.");
            }
            break;
            default: System.out.println("You can't take that.");
            break;
        }
    }

    public void use(String whatToUse)
    {
        switch(whatToUse)
        {
            case "key": if(whichRoom==3&&isLocked==true && hasKey==true)
            {
                System.out.println("You unlocked the door.");
                isLocked=false;
            }
            else if(hasKey==false)
            {
                System.out.println("You don't have a key.");
            }
            else if(whichRoom==3)
            {
                System.out.println("You lock the door again.");
                isLocked=true;
            }
            else
            {
                System.out.println("There is nothing to use it on.");
            }
            break;
            default: System.out.println("You can't use that.");
            break;
        }
    }

    public boolean gameOver()
    {
        if(whichRoom == 5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
