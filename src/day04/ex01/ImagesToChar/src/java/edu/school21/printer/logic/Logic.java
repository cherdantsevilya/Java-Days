package edu.school21.printer.logic;

import java.awt.image.BufferedImage;

public class Logic {

    private char whiteColor;
    private char blackColor;
    private BufferedImage bufferedImage;

    public Logic(char white, char black, BufferedImage bufferedImage) {
        this.whiteColor = white;
        this.blackColor = black;
        this.bufferedImage = bufferedImage;
    }

    public void printImage() {
        int color = bufferedImage.getRGB(0, 0);
        for (int i = 0; i < bufferedImage.getHeight(); i++) {
            for (int j = 0; j < bufferedImage.getWidth(); j++) {
                if (color == bufferedImage.getRGB(j, i)) {
                    System.out.print(this.whiteColor);
                }
                else {
                    System.out.print(this.blackColor);
                }
            }
            System.out.println();
        }
    }
}