package Util;

import Classes.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

//import static Classes.ClassesForInAndOut.getString;
import static Classes.MainLogic.*;


public class FrameMain extends JFrame {
    private JButton readFileBtn;
    private JButton writeFileBtn;


    private JPanel panelMain;
    private JTextField textField1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextField textField2;
    private JTextField textField3;



    public FrameMain() throws IOException {

//        runTest();

        this.setTitle("Основная программа");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();

        JFileChooser fileChooserOpen;
        JFileChooser fileChooserSave;

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");


        JFileChooser finalFileChooserOpen = fileChooserOpen;
        readFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (finalFileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        SimpleLinkedQueue<String> ans = ClassesForInAndOut.readFile(finalFileChooserOpen.getSelectedFile().getPath());
                        textArea2.setText(massivVStroki(ans));
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        JFileChooser finalFileChooserSave = fileChooserOpen;
        writeFileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (finalFileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String str = textArea2.getText();
                        String[] strNew = str.split(" ");
                        SimpleLinkedQueue<String> ans = new SimpleLinkedQueue<>();
                        LinkedBlockingQueue<String> ans2 = new LinkedBlockingQueue<>();
                        for (int i = strNew.length - 1;i >= 0; i--){
                            ans.addFirst(strNew[i]);
                            ans2.add(strNew[i]);
                        }
                        ans.getAnswer();
                        getAnswer(ans2);
                        textArea3.setText(massivVStroki(ans));
                        textArea1.setText(massivVStroki(ans2));
                        textField1.setText("Ответ на основе метода из самодельного класса очереди:");
                        textField3.setText("Ответ по методу на основе существующего класса очереди:");
                        String path = finalFileChooserSave.getSelectedFile().getPath();
                        File file = new File(path);
                        PrintWriter pw = new PrintWriter(file);
                        pw.println(textArea3.getText());
                        pw.close();
                    }
                    } catch(Exception ex){
                        SwingUtils.showErrorMessageBox(ex);
                    }
            }
        });
        textArea2.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        textArea3.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}