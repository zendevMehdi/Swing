package org.zendev.lib.gui.text.listeners;

import org.apache.commons.lang3.StringUtils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class TextListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        if (StringUtils.isNumeric(String.valueOf(e.getKeyChar()))) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
