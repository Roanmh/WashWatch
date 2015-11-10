/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package washwatch;



/**
 *
 * @author roanm
 */
public class WashWatch {

    float initTime;
    float getInitTime(){ return initTime; }
    void setInitTime(){ initTime = System.nanoTime().toSeconds(); }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Init code
        setInitTime();
        
        //Main timing loop: simple 1 min loop implementatation
        
    }
    
    void Initialize()
    {
        
    }
    
    float runningTime()
    {
        return System.nanoTime().toSeconds() - init time ;
    }
    
    float toSeconds(long nanoSeconds)
    {
        return (float)nanoSeconds/1000000000L;
    }
}
