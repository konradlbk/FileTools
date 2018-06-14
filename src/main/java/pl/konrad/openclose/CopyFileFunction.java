package pl.konrad.openclose;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@AdnotacjaIFunction
public class CopyFileFunction extends JFrame implements IFunction {
    private JTextField sourceFile = new JTextField();
    private JTextField targetFile = new JTextField(20);
    private JButton copyButton = new JButton("COPY");
    private JLabel source = new JLabel("Source File:");
    private JLabel destDirectory = new JLabel("Target Dir: ");




    @Override
    public void launch() {
        setVisible(true);
    }

    public CopyFileFunction() throws HeadlessException {
        sourceFile.setColumns(20);
        setSize(400,360);
        setLocation(300,200);
        setResizable(false);
        setLayout(null);

        add(source).setBounds(50,20, 70, 25);


        add(sourceFile).setBounds(140, 20, 210, 25);


        add(destDirectory).setBounds(55, 90, 100, 25);

        add(targetFile).setBounds(140,90, 210, 25);

        add(copyButton).setBounds(160, 220, 70, 30);



        copyButton.addActionListener(e -> copyFiles());

    }

    private void copyFiles() {
        try {
            File file = new File(sourceFile.getText());
            File output = new File(targetFile.getText());
          // Files.copy(Paths.get(sourceFile.getText()),Paths.get(targetFile.getText()),REPLACE_EXISTING);
           FileUtils.copyFileToDirectory(file, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Copy File";
    }
}