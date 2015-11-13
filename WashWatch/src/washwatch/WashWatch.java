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
 *  Wash Watch is a system for tracking the state of a dormitory washer bank
 *  and pushing data to an app or site to show when the next washer will be
 *  available
 * @author roanm
 */
public class WashWatch {
    
    private final ADC adc; // Analog to Digital converter with SPI interface
    
    public WashWatch () throws IOException
    {
        adc = new ADC(0);
    }
    
    /**
     * Instansizes the class and starts timed loop.
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        //Init code
        WashWatch WW = new WashWatch(); // Create object of self
        
        //WW.TimedLoop();
        
        
        //Main timing loop: simple 1 min loop implementatation
    }
        
    /**
     * Loop that times the execution of readings
     * TODO: Flesh out with functions once skeleton code is writ
     * 
     * @return Run Errors
     */
    int TimedLoop() throws InterruptedException
    {
        boolean run = true;
        int i = 0;
        while (run)
        {
            //Power Up I sensor(s)
            
            Thread.sleep(3500); //Wait to allow stabilization of sensor
            read(); //Exange with SPI chip for sensor value(s)
            
            //Data storage code here.

            //Wait for next cycle
            i++;
            //waitSecs = 
            Thread.sleep(60000);
            
        }
        
        return 0;
    }
    
    /**
     * Call ADC to read value
     * @return value read by ADC
     */
    int read ()
    {
        //TODO: Read Code Here
        
        return 0;
    }

    /**
     * Class to operate current sensor
     */
    private class CurrentSensor {
    
        //TODO: add GPIO needs
        final int PORT;
        
        public CurrentSensor (int port)
        {
            PORT = port;
        }
        
        int powerUp ()
        {
            //TODO: GPIO Code Here
            System.out.println("Power Up."); //Diagnostic Print
            return 0;
        }
    }
            
    /**
     * Class to deal with comm to the ADC over SPI
     */
    private class ADC {
        
        final int PORT;
        
        private final SpiDevice spi;
        
        /**
         * Constructor
         * 
         * @param port
         * @throws IOException 
         */
        public ADC (int port) throws IOException {
            PORT = port;
            
            // Get an instance of the SPI communicator
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


