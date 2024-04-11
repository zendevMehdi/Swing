package org.zendev.lib.gui.list;

import javax.swing.*;

public class JListUtils {

    public static <E> void clear(JList<E> list) {
        list.setModel(new DefaultListModel<>());
    }

    public static <E> void add(JList<E> list, E item) {
        ListModel<E> listModel = list.getModel();
        DefaultListModel<E> defaultListModel = new DefaultListModel<>();

        for (int j = 0; j < listModel.getSize(); j++) {
            defaultListModel.addElement(listModel.getElementAt(j));
        }

        defaultListModel.addElement(item);
        list.setModel(defaultListModel);
    }

    public static <E> void remove(JList<E> list, int index) {
        ((DefaultListModel<E>) list.getModel()).remove(index);
    }
}
