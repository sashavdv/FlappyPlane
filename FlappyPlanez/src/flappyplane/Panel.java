/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappyplane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author 6 TSO Informatica 1
 */
public class Panel extends JPanel {

    ArrayList<Pipe> Pipes = new ArrayList<>();
   
    public boolean gameOver = false;
    boolean running = false;

    public Panel() {
        

        Dimension windowsize = new Dimension(1000, 500);
        setPreferredSize(windowsize);

        //repaint();
    }

  //  @Override
//    public void paintComponent(Graphics g) {
//        g.clearRect(0, 0, 1000, 500);
//        
//
//        //Random pipes
//        for (int i = 0; i < Pipes.size(); i++) {
//            Pipe fPipe = Pipes.get(i);
//            g.setColor(Color.GRAY);
//            g.fillRect(fPipe.GetXDistance(), fPipe.GetYHeight(), fPipe.GetWidth(), (fPipe.GetHeight() - 150));
//            g.setColor(Color.RED);
//            g.fillRect(fPipe.GetXDistance(), 0, fPipe.GetWidth(), (fPipe.GetPipeTopHeight() - 150));
//        }
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 450, 1000, 50);
//        //gameover
//        if (gameOver) {
//            g.setColor(Color.WHITE);
//            g.fillRect(250, 170, 520, 100);
//            g.setFont(new Font("Segoe UI Bold", Font.PLAIN, 100));
//            g.setColor(Color.red);
//            g.drawString(new String("Game over!"), 250, 250);
//            FlappyPlane.t1.stop();
//
//            // System.exit(0);
//        }
   // }

}
