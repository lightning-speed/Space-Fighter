package game.internal;

import game.graphics.Bullet;
import game.graphics.GameMovement;
import game.graphics.Obs;
import game.ui.GameView;
import game.ui.LostWindow;
import game.ui.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Core {
    static Timer r;
    static Timer t4;
    public static boolean cj = false;
    public static boolean ismu = false;
    public static boolean ismd = false;
    public static boolean running = true;
    public static int high  = 0;
    public static int health = 10;
    static boolean canWarn = true;
    public static void Window_init(Window ip){
        health = 100;
        t4 = new Timer(140, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cj)
                Bullet.shoot();
                if(ismu) GameMovement.MoveShip(0);
                if(ismd)  GameMovement.MoveShip(1);
                if(!running)t4.stop();
            }
        });
        t4.start();
        high = Integer.parseInt(FileManager.read("data/hi.data").replace("\n",""));
       ip.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {


            }

            @Override
            public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == 38) {

                        ismu = true;
                    }
                    else if (e.getKeyCode() == 40) {

                        ismd = true;
                    }
                if(e.getKeyChar()==' ') {
                   cj = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar()==' '){
                    cj = false;
                }
                if (e.getKeyCode() == 38) {
                    ismu = false;
                }
                else if (e.getKeyCode() == 40) {
                    ismd = false;
                }
            }
        });
    }
    public static void warn(){
        if(canWarn){
            canWarn = false;
            health-=8;
            GameView.hm.setText("Health: "+health);
            System.out.println("L");
            if(health<=0){
                lose();
            }
            r = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!Core.running)r.stop();
                    canWarn = true;
                    r.stop();
                }
            });
            r.start();
        }
    }
    public static void lose(){
     running = false;
        new LostWindow();
        Window.view.removeAll();
        health=100;
        GameView.hm.setText("Health: 100");
        Obs.score = 0;
        GameView.scoreL.setText("Score: 0");
    }
}
