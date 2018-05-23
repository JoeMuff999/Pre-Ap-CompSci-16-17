import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class Snake extends Frame implements WindowListener, ActionListener
{
    // private JToggles.extends;
    private JToggleButton[][] btnNumbers;
    private boolean left  = false; 
    private boolean right = true; 
    private boolean up = false; 
    private boolean down = false;
    private Timer gametimer;
    private int[][] gridNumbers;
    private int snakeHead;
    private boolean gameOver = false;
    public Snake()
    {

        Panel panelButtons = new Panel(new GridLayout(20,20));
        btnNumbers = new JToggleButton[20][20];
        gridNumbers = new int[20][20];
        gridNumbers[0][0]= 5;
        snakeHead = 5;

        addKeyListener(new SnakeKeys());
        setFocusable(true);
        for(int x = 0; x < 20; x++)
        {
            for(int y = 0; y < 20; y++)
            {
                btnNumbers[x][y] = new JToggleButton();
                btnNumbers [x][y].setIcon(new ImageIcon("White.png"));
                panelButtons.add(btnNumbers[x][y]);
                btnNumbers[x][y].addActionListener(this);

            }
        }
        setLayout(new BorderLayout());
        add(panelButtons,BorderLayout.CENTER);
        gametimer = new Timer(200,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)

                {
                    if(gameOver == false)
                    {
                        moveSnake();
                    }
                    else
                    {
                        System.out.println("YOU LOSE");
                    }
                }
            });
        gametimer.start();
        setTitle("Snake");
        setSize(900,900);
        setVisible(true);
        addWindowListener(this);
    }

    public void moveSnake()
    {
        boolean alreadyMoved = false;
        for(int x = 0; x < 20; x++)
        {
            for(int y = 0; y < 20; y++)
            {
                if(alreadyMoved == false)
                {
                    if( gridNumbers[x][y] == snakeHead)
                    {
                        if(right&& y+1 >= 20)
                        {
                            gridNumbers[x][0] = snakeHead+1;

                            alreadyMoved = true;
                        }
                        else if(left && y-1 <= -1)
                        {
                            gameOver = true;
                            alreadyMoved = true;
                        }
                        else if(up && x-1 >= 20)
                        {
                            gameOver = true;
                            alreadyMoved = true;
                        }
                        else if(up && x+1 <= -1)
                        {
                            gameOver = true;
                            alreadyMoved = true;
                        }
                        else
                        {
                            if(right)
                            {
                                if(gridNumbers[x][y+1] >0)
                                {
                                    gameOver = true;
                                }
                                gridNumbers[x][y+1] = snakeHead+1;

                            }
                            else if (left)
                            {
                                if(gridNumbers[x][y-1] >0)
                                {
                                    gameOver = true;
                                }
                                gridNumbers[x][y-1] = snakeHead+1;

                            }
                            else if (down)
                            {
                                if(gridNumbers[x+1][y] >0)
                                {
                                    gameOver = true;
                                }
                                gridNumbers[x+1][y] = snakeHead+1;

                            }
                            else
                            {
                                if(gridNumbers[x-1][y] >0)
                                {
                                    gameOver = true;
                                }
                                gridNumbers[x-1][y] = snakeHead+1;

                            }
                            alreadyMoved = true;

                        }
                    }
                }

            }

        }
        for(int x = 0; x < 20; x++)
        {
            for(int y = 0; y < 20; y++)
            {
                if(gridNumbers[x][y] > 0)
                {
                    gridNumbers[x][y]--;
                    btnNumbers[x][y].setIcon(new ImageIcon("black.png"));
                }
                else if(gridNumbers[x][y] <0)
                {
                    btnNumbers[x][y].setIcon(new ImageIcon("RED.png"));
                }
                else
                {
                    btnNumbers[x][y].setIcon(new ImageIcon("white.png"));
                }
            }

        }
    }

    public static void main(String [] args)
    {
        new Snake();

    }

    @Override
    public void actionPerformed(ActionEvent evt) {

    }

    @Override
    public void windowClosing(WindowEvent evt) {
        System.exit(0);  
    }

    @Override public void windowOpened(WindowEvent evt) { }

    @Override public void windowClosed(WindowEvent evt) { }

    @Override public void windowIconified(WindowEvent evt) { }

    @Override public void windowDeiconified(WindowEvent evt) { }

    @Override public void windowActivated(WindowEvent evt) { }

    @Override public void windowDeactivated(WindowEvent evt) { }
    private class SnakeKeys extends KeyAdapter
    {
        @Override 
        public void keyPressed(KeyEvent e)
        {
            int keytyped = e.getKeyCode();
            if(keytyped == KeyEvent.VK_LEFT)
            {
                left = true;
                up = false;
                down = false;
                right = false;
            }
            if(keytyped == KeyEvent.VK_UP)
            {
                left = false;
                up = true;
                down = false;
                right = false;
            }
            if(keytyped == KeyEvent.VK_RIGHT)
            {
                left = false;
                up = false;
                down = false;
                right = true;
            }
            if(keytyped == KeyEvent.VK_DOWN)
            {
                left = false;
                up = false;
                down = true;
                right = false;
            }
        }
    }
}