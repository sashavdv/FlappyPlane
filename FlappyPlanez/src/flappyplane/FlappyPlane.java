/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappyplane;

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

    boolean test = false;
    boolean running = false;
    Image speler;
    Image background;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlappyPlane frame;
        frame = new FlappyPlane();
    }

    public static Timer t1;
    //public Panel panel = new Panel();
    public int y = 250;

    public FlappyPlane() {
        speler = new ImageIcon(getClass().getResource("/crocoz.png")).getImage();
        background = new ImageIcon(getClass().getResource("/background.png")).getImage();
        this.setVisible(true);
        this.setPreferredSize(new Dimension(1000, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.Start();
 addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        //                  if (y > 0 ) {
                    //                        t1.start();
                    y += -50;
                }
            }
        });
//
//        t1 = new Timer(10, new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               y++;
//
//            
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
//
//            }
//        });
//
//        t1.setRepeats(true);
//
//        this.add(panel);
//        this.setTitle("hallo");
//        panel.repaint();
//        this.pack();
//       
//
//        });
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
        y++;
       try {
            Thread.sleep(3);
         } catch (Exception e) {}
     

    }
    // //for (int i = 0; i < Panel.Pipes.size(); i++) {
//                    Pipe pipe = panel.Pipes.get(i);
//                    pipe.ChangeDistanceToPlayer();
//
//                    if (pipe.GetXDistance() == 600) {
//                        Pipe zpipe;
//                        int random = (int) (399 * Math.random()) + 100;
//                        zpipe = new Pipe(random);
//                        panel.Pipes.add(zpipe);
//                    }
//                    if (pipe.GetXDistance() <= -100) {
//                        panel.Pipes.remove(pipe);
//                    }
//                }
        // if (panel.gameOver) {

        //   System.exit(0);
    //  }
    //                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
    //                    if (y > 0 ) {
    //                        t1.start();
    //                        y += -30;
    //                        if (!test) {
    //                            Pipe zpipe;
    //                            int random = (int) (399 * Math.random()) + 100;
    //                            zpipe = new Pipe(random);
    //                            panel.Pipes.add(zpipe);
    //                            test = true;
    //                        }
    //                        panel.repaint();
    //                    }
    //                }
    //            }
    // }
        //      
    //
    //          
    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(background, 0, 0, this);
        g.drawImage(speler, 80, y, this);
        g.dispose();
        bs.show();
    }

}
