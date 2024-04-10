# Swing

Adds additional tools to work with GUI environments with Swing toolkit.

## Authors

- [@Mehdi Lavasani](https://github.com/zendevMehdi)


## Features

- Creates highly customized message box
- Open and save items from your device easily
- Many tools to work with (JTable, JList, JFrame, JDialog, ...)
- Simple popup menu for text compontents

  
## Installation

You can get jar from release section or create new project and add src folder to the project.


## Usage/Examples

I created new messageBox and a file chooser to select text files from my pc.

```java
package org.zendev.lib.gui;

import org.zendev.lib.gui.dialogs.file.FileDialog;
import org.zendev.lib.gui.dialogs.file.filter.FileDialogFilters;
import org.zendev.lib.gui.dialogs.message.MessageBox;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, InterruptedException {


        var defaultFont = new Font("Inter Medium", Font.PLAIN, 16);
        var msgBox = new MessageBox.MessageBoxBuilder("Hello", "Good morning, wake up and start coding")
                .setMessageType(JOptionPane.INFORMATION_MESSAGE)
                .setMessageFont(defaultFont)
                .setButtonFont(defaultFont)
                .setBackground(Color.white)
                .build();

        var fileDialog = new FileDialog.FileDialogBuilder()
                .setTitle("Select a file")
                .setStartPath(System.getProperty("user.home"))
                .setFilters(Arrays.asList(FileDialogFilters.documentFileFilters))
                .setMultipleSelection(false)
                .setFileDialogType(JFileChooser.FILES_ONLY)
                .build();

        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        new Thread(msgBox::showDialog).start();
        new Thread(fileDialog::open).start();
    }
}

```

## Screenshots

![screenshots/sample.png](https://github.com/zendevMehdi/Swing/blob/2ed33870443a463aefa328713630f5fbc1d197e6/screenshots/sample.png)