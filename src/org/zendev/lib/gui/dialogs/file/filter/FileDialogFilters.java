package org.zendev.lib.gui.dialogs.file.filter;

import javax.swing.filechooser.FileNameExtensionFilter;

public class FileDialogFilters {

    public static final FileNameExtensionFilter[] textFileFilters = {new FileNameExtensionFilter("Text files", "txt"),
            new FileNameExtensionFilter("Xml file", "xml"), new FileNameExtensionFilter("Json file", "json")};

    public static final FileNameExtensionFilter[] imageFileFilters = {
            new FileNameExtensionFilter("Joint photographic experts group", "jpeg"),
            new FileNameExtensionFilter("Portable network graphics", "png"),
            new FileNameExtensionFilter("Graphics interchange format", "gif"),
            new FileNameExtensionFilter("Tagged image file", "tiff"),
            new FileNameExtensionFilter("Photoshop document", "psd"),
            new FileNameExtensionFilter("Raw image formats", "raw"),};

    public static final FileNameExtensionFilter[] videoFileFilters = {
            new FileNameExtensionFilter("Windows media video", "wmv"),
            new FileNameExtensionFilter("MPEG-4 Part 14", "mp4"), new FileNameExtensionFilter("Flash video", "flv"),
            new FileNameExtensionFilter("Audio video interleave", "avi"),
            new FileNameExtensionFilter("Video transport stream", "ts"),
            new FileNameExtensionFilter("MPEG video file", "mpg"),
            new FileNameExtensionFilter("iTunes video file", "m4v"),
            new FileNameExtensionFilter("H.264 encoded video file", "h264"),
            new FileNameExtensionFilter("Digital video file", "dv"),
            new FileNameExtensionFilter("Windows media file", "wm"),
            new FileNameExtensionFilter("3GPP Media File", "3gpp"),
            new FileNameExtensionFilter("Netflix video file", "nfv"),
            new FileNameExtensionFilter("MPEG-2 video", "m2v")};

    public static final FileNameExtensionFilter[] documentFileFilters = {
            new FileNameExtensionFilter("Microsoft Word documents", "doc", "docx"),
            new FileNameExtensionFilter("Hypertext markup language", "html", "html"),
            new FileNameExtensionFilter("Openoffice word document", "odt"),
            new FileNameExtensionFilter("Portable document format", "pdf"),
            new FileNameExtensionFilter("Microsoft Excel file", "xls", "xlsx"),
            new FileNameExtensionFilter("Openoffice excel document ", "ods"),
            new FileNameExtensionFilter("Microsoft PowerPoint files", "ppt", "pptx")};

    public static final FileNameExtensionFilter[] windowsExecutableFilters = {
            new FileNameExtensionFilter("Batch file", "bat"), new FileNameExtensionFilter("Binary executable", "bin"),
            new FileNameExtensionFilter("Command script", "cmd"), new FileNameExtensionFilter("Command File", "com"),
            new FileNameExtensionFilter("Control panel extension", "cpl"),
            new FileNameExtensionFilter("Executable file", "exe"),
            new FileNameExtensionFilter("Microsoft silent installer", "msi"),
            new FileNameExtensionFilter("Windows gadget", "gadget"),
            new FileNameExtensionFilter("Internet communication settings", "ins"),
            new FileNameExtensionFilter("File shortcuts", "lnk")};

    public static final FileNameExtensionFilter[] linuxExecutableFilters = {
            new FileNameExtensionFilter("Runtime loaded library", "so", "o"),
            new FileNameExtensionFilter("Shell script", "sh"),
            new FileNameExtensionFilter("Installer package for Debian/Ubuntu releases", "deb"),
            new FileNameExtensionFilter("Installer package for RedHat/CentOS releases.", "rpm"),
            new FileNameExtensionFilter("Drivers and kernel modules", "ko"),
            new FileNameExtensionFilter("Linux executable files", "run")};

    public static final FileNameExtensionFilter[] macExecutableFilters = {
            new FileNameExtensionFilter("Mac Os executable files", "app"),
            new FileNameExtensionFilter("Apple disk image file", "dmg")};
}
