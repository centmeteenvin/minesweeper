package java2d;

import game.Visuals;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Java2DVisuals extends Visuals {
    final JFrame jFrame = new JFrame("LUNA'S SUPER MIJNENVEGER!:D");
    BufferedImage bufferedImage;
    private final int width = 1000;
    private final int height = 1000;
    final JPanel jPanel = new JPanel(false) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D imageGraphics = (Graphics2D) bufferedImage.getGraphics();
            Graphics2D graphics2D = (Graphics2D) g;
            Toolkit.getDefaultToolkit().sync(); //Black magic.
            graphics2D.drawImage(bufferedImage, 0, 0, null); //Draw the bufferedImage to the current screen.
            if (imageGraphics != null) {
                imageGraphics.clearRect(0, 0, width, height);
                imageGraphics.setColor(Color.white);
                imageGraphics.fillRect(0, 0, width, height);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }

    };

    public Java2DVisuals() {
        jFrame.setResizable(true);
        jFrame.add(jPanel);
        jPanel.setVisible(true);
        jFrame.setSize(width, height);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.bufferedImage = new BufferedImage(jPanel.getWidth(), jPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
    }


    @Override
    public void draw() {
        int blockSize = Math.min(width / (board.getWidth() + 2), height / (board.getHeight() + 2));
        bufferedImage = new BufferedImage(jPanel.getWidth(), jPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();

        for (int row = 1; row <= board.getWidth(); row++) {
            for (int column = 1; column <= board.getHeight(); column++) {
                graphics2D.setColor(Color.red);
                graphics2D.fillRect(column * blockSize, row * blockSize, blockSize - 1, blockSize - 1);
            }
        }
        jPanel.repaint();
    }

}
