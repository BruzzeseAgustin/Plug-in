
import ij.IJ;
import ij.plugin.frame.PlugInFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author usuario
 */
public class MyPlugin_ extends PlugInFrame {

    /**
     * Creates a new instance of Cell_Counter
     */
    public MyPlugin_() {
        super("My Plugin");
        //B_Mainplugin A_Mainplugin = new B_Mainplugin();
        My_Plugin_ My_Plugin_ = new My_Plugin_();
        //NewJFrame NewJFrame = new NewJFrame();
        //IJ.showMessage("thanks for using Mitochondria Morphology plugin ");
    }

    public void run(String arg) {
               
        Class<?> clazz = My_Plugin_.class;
        String url = clazz.getResourceAsStream("/" + clazz.getName().replace('.', '/') + ".class").toString();
        String pluginsDir = url.substring(5, url.length() - clazz.getName().length() - 6);
        System.setProperty("plugins.dir", pluginsDir);
        IJ.runPlugIn(clazz.getName(), "");
        new My_Plugin_().run("");
        new My_Plugin_().setVisible(true);
        IJ.showMessage("thanks for using Mitochondria Morphology plugin ");
        /*Class<?> clazz = NewJFrame.class;
        String url = clazz.getResource("/" + clazz.getName().replace('.', '/') + ".class").toString();
        String pluginsDir = url.substring(5, url.length() - clazz.getName().length() - 6);
        System.setProperty("plugins.dir", pluginsDir);
        IJ.runPlugIn(clazz.getName(), "");
        new NewJFrame().run("");
        new NewJFrame().setVisible(true);
        IJ.showMessage("thanks for using Mitochondria Morphology plugin ");*/
              

    }
}
