package game.graphics;

import game.internal.Core;
import game.ui.GameView;


public class GameMovement {

    public static void MoveShip(int direction){

       Runnable r = new Runnable() {
           @Override
           public void run() {
               for(int i = 0;i<20;i++){
                   try {
                       Thread.sleep(9);
                       if(direction==0&&GameView.ship.getY()-6>0)
                       GameView.ship.setLocation( GameView.ship.getX(), GameView.ship.getY()-6);
                       if(direction==1&&GameView.ship.getY()+65+26+6<550)
                           GameView.ship.setLocation( GameView.ship.getX(), GameView.ship.getY()+6);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       };
       if(Core.running)
       new Thread(r).start();
    }
}
