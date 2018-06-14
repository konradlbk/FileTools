package pl.konrad.openclose;

import javax.swing.*;
import java.awt.*;

public class FileToolsWindow extends JFrame {
    private JList<IFunction> functionJList = new JList<IFunction>();
    private DefaultListModel<IFunction> functionListModel = new DefaultListModel<>();
    private JButton useSelectedFunction = new JButton("Apply");

    public void addFunction(IFunction function) {
        functionListModel.addElement(function);
    }

    public FileToolsWindow() throws HeadlessException {

        functionJList.setModel(functionListModel);
        setSize(350,380);
        setLocation(100,100);
        setResizable(false);
        setLayout(new BorderLayout());
        add(functionJList,BorderLayout.CENTER);
        add(useSelectedFunction,BorderLayout.PAGE_END);
        useSelectedFunction.addActionListener(e -> functionJList.getSelectedValue().launch());


    }


}