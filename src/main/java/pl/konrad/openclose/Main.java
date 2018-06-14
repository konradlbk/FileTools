package pl.konrad.openclose;

import org.reflections.Reflections;

import java.util.Set;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException{


        Reflections reflections = new Reflections("pl.konrad.openclose");
        Set<Class<?>> types = reflections.getTypesAnnotatedWith(AdnotacjaIFunction.class);

        FileToolsWindow fileToolsWindow = new FileToolsWindow();
        for (Class<?> aClass : types){


           fileToolsWindow.addFunction((IFunction)aClass.newInstance());

        }
        fileToolsWindow.setVisible(true);
    }
}