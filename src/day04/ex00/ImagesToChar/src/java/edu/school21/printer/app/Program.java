package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {

        char white;
        char black;
        BufferedImage bufferedImage;

        if (!(args.length == 3 && args[0].length() == 1 && args[1].length() == 1)) {
            System.out.println("Error");
            System.exit(-1);
        }
        white = args[0].charAt(0);
        black = args[1].charAt(0);
        bufferedImage = ImageIO.read(new File(args[2]));

        Logic logic = new Logic(white, black, bufferedImage);
        logic.printImage();
    }
}
