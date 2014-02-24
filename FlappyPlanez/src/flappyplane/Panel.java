/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappyplane;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author 6 TSO Informatica 1
 */
public class Panel extends JPanel implements KeyListener {

    public ArrayList<Pipe> Pipes = new ArrayList<>();
    public int y = 250;
    public boolean gameOver = false;
    boolean running = false;
    public double velocity;
    public double gravity = 9.81;
    public double weight = 0.3;

    public Panel() {
        Dimension windowsize = new Dimension(1000, 500);
        setPreferredSize(windowsize);
    }

    public void Drop() {
        y = (int) (y + velocity * gravity * weight);
        velocity = velocity + 0.06;
        if (velocity > 1) {
            velocity = 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

        System.out.println("Key pressed!");
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            y -= 50;
        }
    }

    public void addPipes() {
        for (int i = 0; i < Pipes.size(); i++) {
            Pipe pipe = Pipes.get(i);
            pipe.ChangeDistanceToPlayer();

            if (pipe.GetXDistance() == 600) {
                Pipe zpipe;
                int random = (int) (399 * Math.random()) + 100;
                zpipe = new Pipe(random);
                Pipes.add(zpipe);
            }
            if (pipe.GetXDistance() <= -100) {
                Pipes.remove(pipe);
            }
        }
    }

}
//    addKeyListener(new KeyListener() {
//            Listener(new KeyListener() {
//           @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//                    y += -50;
//                }
//            }
//        });
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

