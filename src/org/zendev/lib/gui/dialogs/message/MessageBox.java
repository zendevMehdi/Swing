package org.zendev.lib.gui.dialogs.message;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MessageBox {
    private final String title;
    private final String message;

    private final int messageType;

    private final Color background;
    private final Color foreground;

    private final Font buttonFont;
    private final Font messageFont;

    private final List<String> buttons;
    private final Icon dialogIcon;

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public int getMessageType() {
        return messageType;
    }

    public Color getBackground() {
        return background;
    }

    public Color getForeground() {
        return foreground;
    }

    public Font getButtonFont() {
        return buttonFont;
    }

    public Font getMessageFont() {
        return messageFont;
    }

    public List<String> getButtons() {
        return buttons;
    }

    public Icon getDialogIcon() {
        return dialogIcon;
    }

    private MessageBox(MessageBoxBuilder builder) {
        this.title = builder.title;
        this.message = builder.message;

        this.messageType = builder.messageType;

        this.background = builder.background;
        this.foreground = builder.foreground;

        this.buttonFont = builder.buttonFont;
        this.messageFont = builder.messageFont;

        this.buttons = builder.buttons;
        this.dialogIcon = builder.dialogIcon;

        initValues();
    }

    private void initValues() {
        UIManager.put("OptionPane.background", background);
        UIManager.put("OptionPane.messageForeground", foreground);

        UIManager.put("OptionPane.buttonFont", buttonFont);
        UIManager.put("OptionPane.messageFont", messageFont);

        UIManager.put("OptionPane.yesButtonText", "Yes");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
    }


    public void showDialog() {
        JOptionPane.showMessageDialog(null, message, title, messageType, dialogIcon);
    }

    public boolean showYesNoDialog() {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, messageType, dialogIcon)
                == JOptionPane.YES_OPTION;
    }

    public int showYesNoCancelDialog() {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_CANCEL_OPTION, messageType,
                dialogIcon);
    }

    public int showOptionsDialog() {
        Object[] boxButtons = null;

        if (buttons.isEmpty()) {
            boxButtons = new Object[]{"Ok"};
        } else {
            boxButtons = buttons.toArray();
        }

        return JOptionPane.showOptionDialog(null, message, title, JOptionPane.DEFAULT_OPTION,
                messageType, dialogIcon, boxButtons, boxButtons[0]);
    }

    public static class MessageBoxBuilder {
        private String title;
        private String message;

        private int messageType;

        private Color background;
        private Color foreground;

        private Font buttonFont;
        private Font messageFont;

        private List<String> buttons;
        private Icon dialogIcon;

        public MessageBoxBuilder(String title, String message) {
            this.title = title;
            this.message = message;

            this.messageType = JOptionPane.INFORMATION_MESSAGE;

            background = new Color(255, 255, 255);
            foreground = new Color(0, 0, 0);

            buttonFont = new Font("Consolas", Font.PLAIN, 13);
            messageFont = new Font("Consolas", Font.PLAIN, 13);

            buttons = new ArrayList<>();
            dialogIcon = null;
        }

        public MessageBoxBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MessageBoxBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public MessageBoxBuilder setMessageType(int messageType) {
            this.messageType = messageType;
            return this;
        }

        public MessageBoxBuilder setBackground(Color background) {
            this.background = background;
            return this;
        }

        public MessageBoxBuilder setForeground(Color foreground) {
            this.foreground = foreground;
            return this;
        }

        public MessageBoxBuilder setButtonFont(Font buttonFont) {
            this.buttonFont = buttonFont;
            return this;
        }

        public MessageBoxBuilder setMessageFont(Font messageFont) {
            this.messageFont = messageFont;
            return this;
        }

        public MessageBoxBuilder setButtons(List<String> buttons) {
            this.buttons = buttons;
            return this;
        }

        public MessageBoxBuilder setDialogIcon(Icon dialogIcon) {
            this.dialogIcon = dialogIcon;
            return this;
        }

        public MessageBox build() {
            return new MessageBox(this);
        }
    }
}
