/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package washwatch;

import com.pi4j.io.spi.SpiChannel;
import com.pi4j.io.spi.SpiDevice;
import com.pi4j.io.spi.SpiFactory;

import java.io.IOException;
import java.util.Arrays;


/**
 *
 * @author roanm
 */
public class WashWatch {

    private final float initTime; //The system 
    
    private final ADC adc;
    
    public WashWatch () throws IOException
    {
        initTime = System.nanoTime();
        adc = new ADC(0);
    }
    
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        //Init code
        WashWatch WW = new WashWatch();
        
        //WW.TimedLoop();
        
        
        //Main timing loop: simple 1 min loop implementatation
    }
    
//    static void Initialize()
//    {
//        
//    }
    
    /**
     * 
     * @return 
     */
    int TimedLoop() throws InterruptedException
    {
        boolean run = true;
        int i = 0;
        while (run)
        {
            powerUp(); //Power Up I sensor(s)
            Thread.sleep(3500); //Wait to allow stabilization of sensor
            readSPI(); //Exange with SPI chip for sensor value(s)
            
            //Data storage code here.

            //Wait for next cycle
            i++;
            //waitSecs = 
            Thread.sleep(60000);
            
        }
        
        return 0;
    }
    
    /**
     * 
     * @return 
     */
    int powerUp ()
    {
        //TODO: GPIO Code Here
        System.out.println("Power Up.");
        return 0;
    }
    
    int readSPI ()
    {
        //TODO: ReadSPI Code Here
        
        
        
        
        return 0;
    }
    
    /**
     * 
     * @return 
     */
    static float runningTime()
    {
        //return toSeconds(System.nanoTime()) - initTime ; //TODO: fix error on this line
        return 0;
    }
    
    /**
     * 
     * @param nanoSeconds
     * @return 
     */
    static float toSeconds(Long nanoSeconds)
    {
        return (float)nanoSeconds/1000000000L;
    }
       
    private class ADC {
        final int PORT;
        private final SpiDevice spi;
        
        public ADC (int port) throws IOException {
            PORT = port;
            spi = SpiFactory.getInstance(SpiChannel.CS0,
                                     SpiDevice.DEFAULT_SPI_SPEED, // default spi speed 1 MHz
                                     SpiDevice.DEFAULT_SPI_MODE); // default spi mode 0
            System.out.println(Arrays.toString(this.testRead()));
        }
        
        /**
         * Most Basic implementation to choose and read an Analog Input
         * @return Read Value
         */
        public float readSimple()
        {
            //Initiate Coversation
            
            //Send Configuration bits
            
            //Wait for output
            
            //Read output
            
            //Convert to useful value
            
            return 0;
        }
        
        ///TEST FUNCTIONS///
        public byte[] testRead() throws IOException
        {
            byte config[] = new byte[2];
            config[0] = (byte)0b00000001;
            config[1] = (byte)0b10000000;
            return spi.write(config, 0, 16);
        }
    }
    
}


