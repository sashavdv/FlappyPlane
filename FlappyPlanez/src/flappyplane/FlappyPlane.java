/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappyplane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author 6 TSO Informatica 1
 */
public class FlappyPlane extends JFrame implements Runnable {

    Image speler;
    Image background;
    boolean test = false;
    boolean running = false;
    public Panel panel;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlappyPlane frame;
        frame = new FlappyPlane();
    }

    public static Timer t1;
    //public Panel panel = new Panel();

    public FlappyPlane() {

        this.setPreferredSize(new Dimension(1000, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        panel = new Panel();
        panel.addKeyListener(panel);
        panel.setFocusable(true);
        add(panel);
        this.setVisible(true);
        this.Start();
        speler = new ImageIcon(getClass().getResource("/crocoz.png")).getImage();
        background = new ImageIcon(getClass().getResource("/background.png")).getImage();
    }

    public synchronized void Start() {
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public synchronized void Stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            tick();
            render();
        }

    }

    public void tick() {
        panel.Drop();
        panel.addPipes();
        try {
            Thread.sleep(3);
        } catch (Exception e) {
        }

    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(background, 0, 0, this);
        g.drawImage(speler, 80, panel.y, this);
        g.dispose();
        bs.show();
    }
}

//   
//                //Check if player dies
//                for (int i = 0; i < panel.Pipes.size(); i++) {
//                    Pipe pipe = panel.Pipes.get(i);
//                    if ((pipe.GetXDistance() <= 200 && pipe.GetXDistance() <= 225) && (y >= pipe.GetYHeight() - 60 ||y <= pipe.GetYHeight() - 150)) {
//                        panel.gameOver = true;
//                    }
//                    System.out.println(pipe.GetXDistance());
//                }
//
//                if (y > 450) {
//                    panel.gameOver = true;
//                }
//                panel.repaint();

