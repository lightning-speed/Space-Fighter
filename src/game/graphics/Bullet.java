package game.graphics;

import game.internal.Core;
import game.ui.GameView;
import game.ui.Window;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bullet {
    public static Timer tr;
    public static int temp = 0;
    public static JPanel bullets[] = new JPanel[10000];
    static Color ci = new Color(250,100,20);
    public static void ini(){
        for(int i = 0;i<3000;i++){
            bullets[i]=new JPanel();
            bullets[i].setBackground(ci);
            Window.view.add(bullets[i]);
        }
        tr = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = temp-15;i<=temp;i++) {
                    try {
                        bullets[i].setBounds(bullets[i].getX() + 8, bullets[i].getY(), 15, 3);
                    } catch (Exception e1) {
                    }
                    Obs.checkObs();
                    Window.view.repaint();
                }
                if(!Core.running)tr.stop();
            }
        });tr.start();
    }
    public static void shoot(){
        if(!Core.running)return;
        temp++;
       bullets[temp].setBounds( GameView.ship.getX()+10,GameView.ship.getY()+31,15,3);
    }
}
