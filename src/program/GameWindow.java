package program;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame{
    public static boolean isUpPress1;
    public static boolean isDownPress1;

    public static boolean isLeftPress2;
    public static boolean isUpPress2;
    public static boolean isDownPress2;
    public static boolean isRightPress2;

    public static boolean isUpPress3;
    public static boolean isDownPress3;
    public static boolean isLeftPress3;
    public static boolean isRightPress3;

    public static boolean isUpPress4;
    public static boolean isDownPress4;
    public static boolean isEnterPress;
    public static boolean isBackSpacePress;


    public GameWindow() {
        this.setTitle("EuropaLeagueFinal"); // title
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // defaultCloseOperation
        this.setResizable(false); // resizable
        //key
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    isEnterPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    isBackSpacePress = true;
                }

                //PLayer1
                if(e.getKeyCode()==KeyEvent.VK_Q)
                    isUpPress1=true;
                if(e.getKeyCode()==KeyEvent.VK_A)
                    isDownPress1=true;
                //Player2
                if(e.getKeyCode() == KeyEvent.VK_E) {
                    isUpPress2 = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_F) {
                    isRightPress2 = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D) {
                    isDownPress2 = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    isLeftPress2 = true;
                }


                //Player3
                if(e.getKeyCode()==KeyEvent.VK_I)
                    isUpPress3=true;
                if(e.getKeyCode()==KeyEvent.VK_K)
                    isDownPress3=true;
                if(e.getKeyCode()==KeyEvent.VK_J)
                    isLeftPress3=true;
                if(e.getKeyCode()==KeyEvent.VK_L)
                    isRightPress3=true;
                //Player4
                if(e.getKeyCode()==KeyEvent.VK_P)
                    isUpPress4=true;
                if(e.getKeyCode()==KeyEvent.VK_SEMICOLON)
                    isDownPress4=true;


            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    isEnterPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    isBackSpacePress = false;
                }

                // Player1
                if(e.getKeyCode()==KeyEvent.VK_Q)
                    isUpPress1=false;
                if(e.getKeyCode()==KeyEvent.VK_A)
                    isDownPress1=false;

                //Player2
                if(e.getKeyCode() == KeyEvent.VK_E ) {
                    isUpPress2 = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_F ) {
                    isRightPress2 = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D ) {
                    isDownPress2 = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S ) {
                    isLeftPress2 = false;
                }


                //Player3
                if(e.getKeyCode()==KeyEvent.VK_I)
                    isUpPress3=false;
                if(e.getKeyCode()==KeyEvent.VK_K)
                    isDownPress3=false;
                if(e.getKeyCode()==KeyEvent.VK_J)
                    isLeftPress3=false;
                if(e.getKeyCode()==KeyEvent.VK_L)
                    isRightPress3=false;
                //Player4
                if(e.getKeyCode()==KeyEvent.VK_P)
                    isUpPress4=false;
                if(e.getKeyCode()==KeyEvent.VK_SEMICOLON)
                    isDownPress4=false;


            }
        });




    }


}
