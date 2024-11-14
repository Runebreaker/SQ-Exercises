package ex2;

import javax.swing.*;
import java.awt.*;

/*
   Very bad program... to clean up! Change whatever you want ... but dont break it
*/

public class ShowMyAreaApp extends JFrame {
    public static void main(String[] args) {
        MainWindow.open();
    }
}



interface GUI {
    void drawBox(Bounds bounds, RGB color);

    void drawText(String text, int fontSize, Bounds bounds, RGB color);
}
class MainWindow {

    public static void open() {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
        //note: Schedule a job for the swing GUI framework event-dispatching thread:
        // see https://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("ShowMyArea v0.1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 640, 480);
        frame.getContentPane().add(new ShapeDrawingPanel());
        frame.setVisible(true);
    }
}

class ShapeDrawingPanel extends JPanel implements GUI {
    // Constants
    private final JButton rectangleButton;
    private final Rectangle shownRectangle = new Rectangle(50, 50, 100, 200, 1.0f, 0.0f, 0.0f);

    // Variables
    private Graphics graphicsContext;
    private boolean bRectangleDrawn = false;

    public ShapeDrawingPanel() {
        rectangleButton = new JButton("Draw Rectangle");
        rectangleButton.addActionListener(e -> handleButtonEvent());
        add(rectangleButton);
    }

    private void handleButtonEvent() {
        System.out.println("press");
        bRectangleDrawn = !bRectangleDrawn;
        rectangleButton.setText(bRectangleDrawn ? "Erase the rectangle" : "Draw a rectangle");
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        graphicsContext = g;
        var bounds = shownRectangle.getBounds();
        var color = shownRectangle.getRGB();
        if (bRectangleDrawn) {
            shownRectangle.draw(this);
            drawText("Area = " + bounds.area(), 20, bounds, color);
        }
    }

    @Override
    public void drawBox(Bounds bounds, RGB rgb) {
        if (graphicsContext != null) {
            graphicsContext.setColor(rgb.asColor());
            graphicsContext.drawRect(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
        }
    }

    @Override
    public void drawText(String text, int fontSize, Bounds bounds, RGB rgb) {
        if (graphicsContext != null) {
            graphicsContext.setColor(rgb.asColor());
            graphicsContext.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            graphicsContext.drawString(text, bounds.getX(), bounds.getY());
        }
    }
}

class RGB {
    private float red;
    private float blue;
    private float green;

    public RGB(float red, float blue, float green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public Color asColor() {
        return new Color(red, blue, green);
    }

    public float getRed() {
        return red;
    }

    public void setRed(float red) {
        this.red = red;
    }

    public float getBlue() {
        return blue;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }

    public float getGreen() {
        return green;
    }

    public void setGreen(float green) {
        this.green = green;
    }
}

class Bounds {
    private int x, y, width, height;

    public Bounds(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // region Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
    // endregion

    // region Calculations
    public int area() {
        return width * height;
    }
    // endregion
}

class Rectangle {
    private final Bounds bounds;
    private final RGB rgb;

    public Rectangle(int x, int y, int width, int height, float red, float blue, float green) {
        this.bounds = new Bounds(x, y, width, height);
        this.rgb = new RGB(red, blue, green);
    }

    public void draw(GUI gui) {
        gui.drawBox(bounds, rgb);
    }

    public void setBounds(int x, int y, int width, int height) {
        bounds.setX(x);
        bounds.setY(y);
        bounds.setWidth(width);
        bounds.setHeight(height);
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setRGB(float red, float blue, float green) {
        rgb.setRed(red);
        rgb.setBlue(blue);
        rgb.setGreen(green);
    }

    public RGB getRGB() {
        return rgb;
    }
}
