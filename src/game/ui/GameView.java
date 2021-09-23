package game.ui;

import game.graphics.Bullet;
import game.graphics.GameObject;
import game.graphics.Obs;
import game.internal.Core;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    public static Core core = new Core();
    public static Obs ob;
    public static JLabel hm  = new JLabel("Health: 100");
    public static GameObject ship = new GameObject(65,65,"assets/images/sprite.png");
    public static GameObject obs[] = new GameObject[2];
    public static JLabel scoreL = new JLabel("Score: 0");
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("assets/images/background.png").getImage(), 0, 0, null);
    }
    public void startGame(){
           setLayout(null);
           ship.setLocation(150,200);
           add(ship);
           scoreL.setForeground(Color.WHITE);
           scoreL.setFont(new Font("Arial",Font.PLAIN,18));
           scoreL.setBounds(10,10,100,20);
           add(scoreL);
           hm.setForeground(Color.WHITE);
           hm.setFont(new Font("Arial",Font.PLAIN,18));
           hm.setBounds(600,10,100,20);
           add(hm);
           ob = new Obs();
        Bullet.ini();

    }
}
