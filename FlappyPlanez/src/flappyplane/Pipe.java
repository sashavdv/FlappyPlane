/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flappyplane;

/**
 *
 * @author 6 TSO Informatica 1
 */

public class Pipe {
    private int xDistance;
    private int yHeight;
    private final int Height = 500;
    private final int Width = 100;
    
    public Pipe(int yHeight){
        this.yHeight = yHeight;
        this.xDistance = 1000;
    }
    
    public void ChangeDistanceToPlayer(){
        this.xDistance-=2;
    }
    
    public int GetXDistance(){
        return this.xDistance;
    }
    
    public int GetYHeight(){
        return this.yHeight;
    }
    
    public int GetPipeTopHeight(){
        return this.yHeight;
    }
    
    public int GetWidth(){
        return this.Width;
    }
    
    public int GetHeight(){
        return this.Height;
    }
}

