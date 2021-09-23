package game.graphics;

import javax.swing.*;

public class GameObject extends JLabel{
    public GameObject(int width,int height,String path){
        this.setSize(width,height);
        this.setIcon(new ImageIcon(path));
    }
}
