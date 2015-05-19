/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pointgrey.util;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author msferry
 */
public class WritePGMImage {
    
    public static void writeBinaryPGM(String filename, String filepath,int w, int h, int bpp, byte[] img) throws Exception{
        String completeFilename = filepath + "/" + filename;
        OutputStream fileOutput = new FileOutputStream(completeFilename);
        DataOutputStream output = new DataOutputStream(fileOutput);
        
        //int w = 1280;
        //int h = 960;
        int depth = ((int) Math.pow(2, bpp)) - 1;
        
        //System.out.println("Width: " + w + " Height: " + h + " Depth: " + depth);
        
        output.writeBytes("P5\n#" + filename + "\n" + w + " " + h + "\n" + depth + "\n");
        output.write(img, 0 , img.length);
        output.close();
        
        
    }
    
    public static byte[] twoByteShift(byte[] inArray){
        byte[] outArray = new byte[inArray.length];
        
        for (int i=0; i<inArray.length-2;i+=2){
            outArray[i] = inArray[i+1];
            outArray[i+1] = inArray[i];
        }
        return outArray;
    }
    
    //http://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

}
