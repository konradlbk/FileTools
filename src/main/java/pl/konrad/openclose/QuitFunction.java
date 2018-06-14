package pl.konrad.openclose;

import javax.swing.*;
import java.awt.*;

@AdnotacjaIFunction

public class QuitFunction extends JFrame implements IFunction {
    private JButton quitButton = new JButton("Quit");
    @Override
    public void launch() {
        setVisible(true);
    }
    @Override
    public String toString() {
        return "Quit";
    }

    public QuitFunction () throws HeadlessException{

        setSize(150,150);
        setLocation(300,200);
        setResizable(false);
        setLayout(new FlowLayout());
        add(quitButton);
        quitButton.addActionListener(e -> System.exit(0));
    }

}
