package computacao_grafica.geometria.io;

import java.awt.FileDialog;
import javax.swing.JFrame;

public class DialogUtil {

    private FileDialog fd;

    public DialogUtil(JFrame frame, int mode) {
        fd = new FileDialog(frame, "Escolha um XML", mode);
        fd.setFile("*.xml");
    }

    public String getFilePath() {
        String filename = null;
        fd.setVisible(true);
        if (fd.getFile() != null && fd.getDirectory() != null) {
            filename = fd.getDirectory() + fd.getFile();
        }
        return filename;
    }

}
