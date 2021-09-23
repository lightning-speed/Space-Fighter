package game.ui;

import game.graphics.Bullet;
import game.internal.Core;

import javax.swing.*;

public class Window extends JFrame {
    public static GameView view = new GameView();
    public Window(){
        super("Space Fight 2D");
        this.setIconImage(new ImageIcon("assets/images/icon.png").getImage());
        this.setVisible(true);
        this.setSize(700,550);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(view);
        view.startGame();
        Core.Window_init(this);
    }
}
