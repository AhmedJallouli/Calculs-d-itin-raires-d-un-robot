package Menu;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.stage.Window;


public class DropDownMenu {


    private ContextMenu menu;
    private final String[] menuList = {"Set as obstacle", "Set as start", "Set as end", "delete node"};

    public DropDownMenu(Window window, double x, double y) {

        menu = new ContextMenu();
        menu.setAutoHide(true);
        for (String text : menuList) {
            MenuItem menuItem = new MenuItem(text);
            menu.getItems().add(menuItem);
        }
        //show
        menu.show(window, x, y);
    }
}
