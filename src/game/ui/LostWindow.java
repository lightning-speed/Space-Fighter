package game.ui;

import game.graphics.Obs;
import game.internal.Core;
import game.launcher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LostWindow extends JFrame {
    public GameView panel = new GameView();
    public JLabel los = new JLabel("Your Health fell below 1 and you died");
    public JButton restart = new JButton("Restart");
    public JLabel sc = new JLabel();
    public static launcher laun = new launcher();
    public LostWindow(){
        super("You Lost");
        launcher.win.setVisible(false);
        this.setIconImage(new ImageIcon("assets/images/icon.png").getImage());
        this.setVisible(true);
        this.setSize(700,550);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(panel);
        panel.setLayout(null);
        los.setHorizontalAlignment(SwingConstants.CENTER);
        los.setBounds(0,200,700,40);
        los.setForeground(Color.white);
        los.setFont(new Font("Arial",Font.PLAIN,22));
        panel.add(los);
        sc.setHorizontalAlignment(SwingConstants.CENTER);
        sc.setBounds(0,260,700,40);
        sc.setForeground(Color.white);
        sc.setFont(new Font("Arial",Font.PLAIN,22));
        sc.setText(GameView.scoreL.getText());
        panel.add(sc);
        restart.setHorizontalAlignment(SwingConstants.CENTER);
        restart.setBounds(250,350,200,40);
        restart.setForeground(Color.white);
        restart.setFont(new Font("Arial",Font.PLAIN,22));
        restart.setOpaque(false);
        restart.setContentAreaFilled(false);
        restart.setFocusPainted(false);
        panel.add(restart);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Core.running = true;
                Core.health=100;
                GameView.hm.setText("Health: 100");
                Obs.score = 0;
                laun.launch();
                setVisible(false);
            }
        });
    }
}
