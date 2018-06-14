package pl.konrad.openclose;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.*;

@AdnotacjaIFunction

public class DeleteFileFunction extends JFrame implements IFunction {
    private JTextField targetFile = new JTextField();
    private JTextField sourceFile = new JTextField(20);
    private JLabel source = new JLabel("Source:");

    private JButton deleteButton = new JButton("DELETE");

    @Override
    public void launch() {
        setVisible(true);
    }

    public DeleteFileFunction() throws HeadlessException {
        setSize(480,240);
        //setLocation(300,200);
        setLayout(null);
        setResizable(false);
        add(source).setBounds(30, 30, 50, 25);
        add(sourceFile).setBounds(90, 30, 325, 25);
        add(deleteButton).setBounds(202, 120, 85, 30);
        deleteButton.addActionListener(e -> deleteFiles());

    }

    public void deleteFiles(){

        try {
            Files.delete(Paths.get(sourceFile.getText()));
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n");
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n");
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }

    }

    @Override
    public String toString() {
        return "Delete File";
    }
}