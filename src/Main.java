import javax.swing.SwingUtilities;

import ui.MahasiswaApp;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new MahasiswaApp();
            }
        });
    }
}