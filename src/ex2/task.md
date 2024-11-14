# Task 2
## Task : Cleaning Rectangle
1. Apply the **topics discussed in the lecture** to clean the given code below
and also available in the lecture code repository [here](https://gitlab2.informatik.uni-wuerzburg.de/hci/students/software-quality/ws24/ws-24-software-quality-code-for-students/-/blob/main/java/src/edu/sq/w05/cleaningcodepractice/tasks/task2/showmyarea/verybad/ShowMyAreaApp.java).
2. Submit a zip file with your solution [here](https://wuecampus.uni-wuerzburg.de/moodle/mod/assign/view.php?id=3179619)
>Before Thursday, 14 November 2024, 5:00 PM. Solutions will be discussed during our next meeting
## Scenario: The ShowMyArea App Development
- You are passing a test to be hire in company providing mini app for teachers.
- One software in development in the company is called ShowMyArea.
- It is a simple program allowing schoolchild
to select a 2D shape (e.g. rectangle, square,..) and its size
and see the resulting shape drawn on the screen and a value for its area.
- The developer who has worked on the first version of ShowMyArea has been fired after the showing his code to his manager.
You are applying to the vacant position.
- However, to test your coding skills, the manager asks you to clean as much as you can the code left by the previous developer.
He gives you 1 hour alone with the code below.
You are not supposed to add any functionalities, just clean the mess!
- You can change whatever you want, but dont break the program. Good Luck!

```java
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
    void drawBox(int x, int y, int width, int height, float red, float blue, float green);

    void drawText(String s, int x, int y, int size, float red, float blue, float green);
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

    private JButton rectangleButton;
    private boolean bRectangleDrawn = false;
    private Graphics graphicsContext;
    private Rectangle rect1 = new Rectangle(50, 50, 100, 200, 1.0f, 0.0f, 0.0f);

    public ShapeDrawingPanel() {
        rectangleButton = new JButton("Draw Rectangle");
        add(rectangleButton);
        rectangleButton.addActionListener(e -> {
            System.out.println("press");
            bRectangleDrawn = !bRectangleDrawn;
            rectangleButton.setText(bRectangleDrawn ? "Erase the rectangle" : "Draw a rectangle");
            repaint();
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        graphicsContext = g;
        if (bRectangleDrawn) {
            rect1.draw(this);
            drawText("Area = " + rect1.area(),
                    rect1.getX(), rect1.getY()
                    , 20,
                    rect1.getRed(), rect1.getBlue(), rect1.getBlue()
            );
        }
    }

    @Override
    public void drawBox(int x, int y, int width, int height, float red, float blue, float green) {
        if (graphicsContext != null) {
            graphicsContext.setColor(new Color(red, blue, green));
            graphicsContext.drawRect(x, x, width, height);
        }
    }

    @Override
    public void drawText(String s, int x, int y, int size, float red, float blue, float green) {
        if (graphicsContext != null) {
            graphicsContext.setColor(new Color(red, blue, green));
            graphicsContext.setFont(new Font("TimesRoman", Font.PLAIN, size));
            graphicsContext.drawString(s, x, y);
        }
    }
}



class Rectangle {
    private int width, height;
    private int x, y;
    private float red;
    private float blue;
    private float green;

    public Rectangle(int x, int y, int width, int height, float red, float blue, float green) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public double area() {
        return width * height;
    }

    public void draw(GUI gui) {
        gui.drawBox(x, y, width, height, red, blue, green);
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
```