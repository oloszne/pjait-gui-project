import controller.MainController;
import model.AppData;
import model.AppDataLoader;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        AppData appData = AppDataLoader.load();
        SwingUtilities.invokeLater(() -> {
                new MainController(appData);
        });
    }
}
