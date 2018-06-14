package pl.konrad.openclose;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;

@AdnotacjaIFunction

public class CreateTextFileFunction extends JFrame implements IFunction {
    private JTextArea fileContent = new JTextArea();
    private JButton saveButton = new JButton("SAVE");
    private JLabel target = new JLabel("Target File:");
    private JLabel content = new JLabel("Content:");
     private JTextField targetFile = new JTextField(20);


    @Override
    public void launch() {
        setVisible(true);
    }

    public CreateTextFileFunction(){
        setSize(480,480);
        setLocation(300,200);
        setLayout(null);
        fileContent.setColumns(20);
        fileContent.setRows(5);

        add(target).setBounds(25, 30, 80, 25);
        add(targetFile).setBounds(110, 30, 325, 25);
        add(content).setBounds(37, 80, 75, 25);

        add(fileContent).setBounds(17, 110, 429, 240);

        add(saveButton).setBounds(200, 370, 70, 25);
        saveButton.addActionListener(e -> createFile());
    }

    public void createFile(){

        try {
            FileOutputStream outputStream = new FileOutputStream(targetFile.getText(), true);
            outputStream.write(fileContent.getText().getBytes());
            outputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Create Text File";
    }
}
