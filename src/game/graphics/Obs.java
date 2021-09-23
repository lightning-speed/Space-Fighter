package game.graphics;

import game.internal.Core;
import game.ui.GameView;
import game.ui.Window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Obs {
    public static int score = 0;
    public Obs(){
        for(int i = 0;i<2;i++) {
            GameView.obs[i] = new GameObject(89, 61, "assets/images/sprite_e.png");
            GameView.obs[i].setLocation(500+300*(i+1),(int)(Math.random()*1000)%480);
            Window.view.add(GameView.obs[i]);
        }
        startMove();
    }
    public void startMove(){
        Runnable re = new Runnable() {
            @Override
            public void run() {
                for(;Core.running;) {
                    try {
                        Thread.sleep(13);
                        GameView.obs[0].setLocation(GameView.obs[0].getX()-4,GameView.obs[0].getY());
                        GameView.obs[1].setLocation(GameView.obs[1].getX()-4,GameView.obs[1].getY());
                        if(GameView.obs[0].getX()<-91)GameView.obs[0].setLocation(500+300,(int)(Math.random()*1000)%480);
                        if(GameView.obs[1].getX()<-91)GameView.obs[1].setLocation(500+300,(int)(Math.random()*1000)%480);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        new Thread(re).start();
    }
    public static void checkObs(){
        checkShip();
        for(int i = Bullet.temp-15;i<Bullet.temp;i++){
            try{
            if(GameView.obs[0].getX()+88<=Bullet.bullets[i].getX()&&
                    GameView.obs[0].getX()+168>=Bullet.bullets[i].getX()+15&&
                    Bullet.bullets[i].getY()<=GameView.obs[0].getY()+60&&
                    Bullet.bullets[i].getY()>=GameView.obs[0].getY()){
                GameView.obs[0].setLocation(-80,(int)(Math.random()*1000)%480);
                score++;
                GameView.scoreL.setText("Score: "+score);
            }
                 if(GameView.obs[1].getX()+88<=Bullet.bullets[i].getX()&&
                         GameView.obs[1].getX()+168>=Bullet.bullets[i].getX()+15&&
                         Bullet.bullets[i].getY()<=GameView.obs[1].getY()+60&&Bullet.bullets[i].getY()>=GameView.obs[1].getY()){
                    GameView.obs[1].setLocation(-80,(int)(Math.random()*1000)%480);
                    score++;
                    GameView.scoreL.setText("Score: "+score);
                }
            }catch (Exception e){}
        }
    }
    static void checkShip(){
        if(GameView.ship.getX()<GameView.obs[0].getX()&&
        GameView.ship.getX()>GameView.obs[0].getX()-50&&
        GameView.ship.getY()-60<=GameView.obs[0].getY()&&
                GameView.ship.getY()+60>=GameView.obs[0].getY()){
            Core.warn();
        }
        if(GameView.ship.getX()<GameView.obs[1].getX()&&
                GameView.ship.getX()>GameView.obs[1].getX()-50&&
                GameView.ship.getY()-60<=GameView.obs[1].getY()&&
                GameView.ship.getY()+60>=GameView.obs[1].getY()){
            Core.warn();
        }
    }
}
