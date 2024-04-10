package org.zendev.lib.gui.res;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class Resources {

    public static void setComponentIcon(Component component, String path) {
        setComponentIcon(component, path, 20, 20);
    }

    public static void setComponentIcon(Component component, String path, int x, int y) {
        ImageIcon i = new ImageIcon((Objects.requireNonNull(Resources.class.getResource(path))));
        Image image = i.getImage();

        Image newImg = image.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        i = new ImageIcon(newImg);

        if (component instanceof JMenuItem) {
            ((JMenuItem) component).setIcon(i);
        } else if (component instanceof JButton) {
            ((JButton) component).setIcon(i);
        } else if (component instanceof JLabel) {
            ((JLabel) component).setIcon(i);
        } else if (component instanceof JToggleButton) {
            ((JToggleButton) component).setIcon(i);
        }
    }
}
