package org.zendev.lib.gui.text;


import org.zendev.lib.gui.text.listeners.NumberListener;
import org.zendev.lib.gui.text.listeners.TextListener;
import org.zendev.lib.gui.text.options.TextInputType;
import org.zendev.lib.gui.text.options.TextPopupMenuLanguage;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class JTextComponentUtils {


    public static void setLimit(JTextComponent component, int limit) {
        component.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (component.getText().length() == limit) {
                    e.consume();
                } else if (component.getText().length() > limit) {
                    component.setText("");
                }
            }
        });
    }

    public static void setInputType(JTextComponent component, TextInputType type) {
        for (int i = 0; i < component.getKeyListeners().length; i++) {
            component.removeKeyListener(component.getKeyListeners()[i]);
        }

        switch (type) {
            case NUMBER -> component.addKeyListener(new NumberListener());
            case TEXT -> component.addKeyListener(new TextListener());
        }
    }

    public static void setFieldBasicMenu(JTextComponent component, TextPopupMenuLanguage language, Font font) {
        JPopupMenu pop = new JPopupMenu();
        Toolkit kit = Toolkit.getDefaultToolkit();

        final JMenuItem miCopy;
        final JMenuItem miCut;
        final JMenuItem miPaste;
        final JMenuItem miDelete;
        final JMenuItem miClear;
        final JMenuItem miSelectAll;
        final JMenuItem miDateTime;

        if (language == TextPopupMenuLanguage.ENGLISH) {
            miCopy = new JMenuItem("Copy");
            miCut = new JMenuItem("Cut");
            miPaste = new JMenuItem("Paste");
            miDelete = new JMenuItem("Delete");
            miClear = new JMenuItem("Clear");
            miSelectAll = new JMenuItem("Select all");
            miDateTime = new JMenuItem("Date / time");
        } else {
            miCopy = new JMenuItem("کپی");
            miCut = new JMenuItem("بریدن");
            miPaste = new JMenuItem("الحاق");
            miDelete = new JMenuItem("حذف");
            miClear = new JMenuItem("پاک کردن");
            miSelectAll = new JMenuItem("انتخاب همه");
            miDateTime = new JMenuItem("ناریخ / زمان");

            JMenuItem[] menuItems =
                    new JMenuItem[]{miCopy, miCut, miPaste, miDelete, miClear, miSelectAll, miDateTime};

            for (JMenuItem mi : menuItems) {
                mi.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            }
        }

        miCopy.addActionListener((ActionEvent ae) -> {
            kit.getSystemClipboard().setContents(new StringSelection(component.getSelectedText()), null);
        });

        miCut.addActionListener((ActionEvent ae) -> {
            kit.getSystemClipboard().setContents(new StringSelection(component.getSelectedText()), null);

            if (component.getText().equals(component.getSelectedText())) {
                component.setText("");
            } else {
                int index = component.getSelectionStart();
                String begin = component.getText().substring(0, index),
                        end = component.getText().substring(index + component.getSelectedText().length());

                component.setText(begin + end);
            }
        });

        miPaste.addActionListener((ActionEvent ae) -> {
            try {
                int caretPosition = component.getCaretPosition();
                String selectedText = component.getSelectedText(), text = component.getText(),
                        clipBoardText = kit.getSystemClipboard().getData(DataFlavor.stringFlavor).toString();

                if (selectedText == null) {
                    String startString = text.substring(0, caretPosition), endString = text.substring(caretPosition);
                    component.setText(startString + clipBoardText + endString);
                } else {
                    String startString = text.substring(0, component.getSelectionStart()),
                            endString = text.substring(component.getSelectionEnd());

                    component.setText(startString + clipBoardText + endString);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        miDelete.addActionListener((ActionEvent ae) -> {
            int index = component.getSelectionStart();
            String begin = component.getText().substring(0, index),
                    end = component.getText().substring(index + component.getSelectedText().length());

            component.setText(begin + end);
        });

        miClear.addActionListener((ActionEvent ae) -> {
            component.setText("");
        });

        miSelectAll.addActionListener((ActionEvent ae) -> {
            component.selectAll();
        });

        miDateTime.addActionListener((ActionEvent ae) -> {
            int caretPosition = component.getCaretPosition();

            String time = null, date = null, timeDate = null, text = component.getText();
            String startString = text.substring(0, caretPosition), endString = text.substring(caretPosition);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            date = dtf.format(LocalDateTime.now());

            dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            time = dtf.format(LocalDateTime.now());

            timeDate = time.concat(date);
            component.setText(startString + timeDate + endString);
        });

        miCopy.setFont(font);
        miCut.setFont(font);
        miPaste.setFont(font);
        miDelete.setFont(font);
        miClear.setFont(font);
        miSelectAll.setFont(font);
        miDateTime.setFont(font);

        pop.add(miCopy);
        pop.add(miCut);
        pop.add(miPaste);
        pop.add(miDelete);
        pop.add(miClear);
        pop.add(miSelectAll);
        pop.add(miDateTime);

        component.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    if (component.getSelectedText() == null) {
                        miCopy.setEnabled(false);
                        miCut.setEnabled(false);
                        miDelete.setEnabled(false);
                    } else {
                        miCopy.setEnabled(true);
                        miCut.setEnabled(true);
                        miDelete.setEnabled(true);
                    }

                    if (component.getText() == null) {
                        miClear.setEnabled(false);
                        miSelectAll.setEnabled(false);
                    } else {
                        miClear.setEnabled(true);
                        miSelectAll.setEnabled(true);
                    }

                    if (!component.isEditable()) {
                        miCut.setVisible(false);
                        miDelete.setVisible(false);
                        miDateTime.setVisible(false);
                        miClear.setVisible(false);
                        miPaste.setVisible(false);
                    } else {
                        if (component instanceof JPasswordField) {
                            miCopy.setVisible(false);
                            miCut.setVisible(false);
                            miDelete.setVisible(false);
                        } else {
                            miCut.setVisible(true);
                            miDelete.setVisible(true);
                            miDateTime.setVisible(true);
                            miClear.setVisible(true);
                            miPaste.setVisible(true);
                        }
                    }

                    pop.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }
}