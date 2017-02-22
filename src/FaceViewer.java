import javax.swing.*;
import java.awt.*;

/**
 * Created by dfreer on 2/22/2017.
 * Drawing a face using Swing.
 */
class FaceComponent extends JPanel
{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawArc(110, 45, 70, 70, 0, 360);
        g.drawArc(130, 65, 10, 10, 0, 360);
        g.drawArc(150, 65, 10, 10, 0, 360);
        g.setColor(Color.BLUE);
        g.drawLine(129, 95, 161, 95);
        //mostly used trial and error to figure out how to make this look like
        //the image from Big Java Exercise P2.15
    }
}
public class FaceViewer {
    public Dimension getPreferredSize(){
        return new Dimension(250, 250);
    }
    public static void main(String[] args) {
        JComponent face = new FaceComponent();
        face.setForeground(Color.GREEN);
        JFrame frame = new JFrame("Face!");
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBackground(Color.CYAN);
        jPanel.add(face);
        frame.add(jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel();
        emptyLabel.setText("Testing, testing");
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        frame.setContentPane(jPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
