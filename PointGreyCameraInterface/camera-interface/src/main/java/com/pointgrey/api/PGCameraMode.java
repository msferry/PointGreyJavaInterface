package com.pointgrey.api;

/**
 * This class keeps track of a PGFrameRateMode and a PGVideoMode
 * This can be used to represent the capture mode of a camera 
 * (How many FPS is it running at, what is the resolution of the images produced, etc,.)
 * @author Matt
 */
public class PGCameraMode {

    private final PGFrameRateMode frameRateMode;
    private final PGVideoMode videoMode;

    public PGCameraMode(PGVideoMode videoMode, PGFrameRateMode frameRateMode) {
        this.frameRateMode = frameRateMode;
        this.videoMode = videoMode;
    }

    public PGFrameRateMode getFrameRateMode() {
        return frameRateMode;
    }

    public PGVideoMode getVideoMode() {
        return videoMode;
    }

    public int getNeededByteBufferSize() { 
        int bytesPerPixel = (int) Math.ceil(videoMode.getBitsPerPixel() / 8.0);
        return videoMode.getWidth() * videoMode.getHeight() * bytesPerPixel;
    }

    @Override
    public String toString() {
        return "Video Mode: " + videoMode + " FrameRate Mode: " + frameRateMode + " Resolution (" + videoMode.getWidth() + ", " + videoMode.getHeight() + ")";
    }
}
