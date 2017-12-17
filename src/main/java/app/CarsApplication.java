package app;

import graphics.GUIApp;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import wsd.Agent2;

public class CarsApplication {
    public static final Long MAX_Y = 20000L;

    public static ContainerController containerController;

    public static void createAgent(String name, String className, String[] args) {
        if (containerController != null) {
            try {
                containerController.createNewAgent(name, className, args).start();
            } catch (StaleProxyException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(() -> GUIApp.main(null)).start();

        Runtime runtime = Runtime.instance();
        Profile profile = new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST, "localhost");
        profile.setParameter(Profile.GUI, "true");
        containerController = runtime.createMainContainer(profile);

       // createAgent("Agent1", Agent2.class.getName(), new String[]{"speed:60"});
    }
}