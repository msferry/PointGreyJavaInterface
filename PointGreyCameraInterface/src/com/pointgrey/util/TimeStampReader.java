
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import javax.imageio.ImageIO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class TimeStampReader {
    public static double readTimeStamp(BufferedImage image){
        byte[] imageData = ((DataBufferByte)(image.getRaster().getDataBuffer())).getData();
        
        return getTimeStamp(imageData[0], imageData[1], imageData[2], imageData[3]);
    }
    
    private static double getTimeStamp(byte byte0, byte byte1, byte byte2, byte byte3){
        int nSeconds, nCycleCount, nCycleOffset;
        long rawTime = 0;
        
        //Put the bytes in little endian format
        rawTime += byte3 < 0 ? (int)byte3 + 256 : byte3;
        rawTime = rawTime << 8;
        rawTime += byte2 < 0 ? (int)byte2 + 256 : byte2;
        rawTime = rawTime << 8;
        rawTime += byte1 < 0 ? (int)byte1 + 256 : byte1;
        rawTime = rawTime << 8;
        rawTime += byte0 < 0 ? (int)byte0 + 256 : byte0;
        
        //Read the timestamp
        nSeconds     = (int)(rawTime >> 25);  // get rid of cycle_* - keep 7 bits
        nCycleCount  = (int)(rawTime >> 12) & 0x1FFF; // get rid of offset
        nCycleOffset = (int)(rawTime >>  0) & 0xFFF;  // get rid of *_count

        System.out.println(nSeconds + " seconds and " + nCycleCount / 8 + " milliseconds with a cycle offset of " + nCycleOffset);
        return (double)nSeconds + nCycleCount/8000;
    }
}
