/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pointgrey.api;

/**
 *
 * @author msferry
 */
public class PGImage {
    private final byte[] img;
    private final PGVideoMode acqMode;
    
    public PGImage(byte[] img, PGVideoMode acqMode){
        this.img=img;
        this.acqMode = acqMode;
    }

    /**
     * @return the img
     */
    public byte[] getImg() {
        return img;
    }

    /**
     * @return the acqMode
     */
    public PGVideoMode getAcqMode() {
        return acqMode;
    }
    
    
}
