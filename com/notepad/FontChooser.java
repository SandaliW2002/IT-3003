package com.notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontChooser extends JDialog {
    private Font selectedFont;
    private JList<String> fontList;
    private JList<String> sizeList;
    private JCheckBox boldCheckBox, italicCheckBox;
    private JLabel previewLabel;
    private boolean approved = false;

    private static final String[] FONT_SIZES = {
        "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"
    };

    public FontChooser(Frame parent, String title, Font initialFont) {
        super(parent, title, true);
        this.selectedFont = initialFont;
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        updatePreview();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    private void initializeComponents() {
        // Get available fonts
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();
        
        fontList = new JList<>(fontNames);
        fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontList.setSelectedValue(selectedFont.getFontName(), true);
        
        sizeList = new JList<>(FONT_SIZES);
        sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sizeList.setSelectedValue(String.valueOf(selectedFont.getSize()), true);
        
        boldCheckBox = new JCheckBox("Bold", selectedFont.isBold());
        italicCheckBox = new JCheckBox("Italic", selectedFont.isItalic());
        
        previewLabel = new JLabel("AaBbYyZz");
        previewLabel.setPreferredSize(new Dimension(200, 100));
        previewLabel.setHorizontalAlignment(JLabel.CENTER);
        previewLabel.setBorder(BorderFactory.createTitledBorder("Preview"));
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Font selection panel
        JPanel fontPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        
        JPanel fontNamePanel = new JPanel(new BorderLayout());
        fontNamePanel.setBorder(BorderFactory.createTitledBorder("Font"));
        fontNamePanel.add(new JScrollPane(fontList));
        
        JPanel fontSizePanel = new JPanel(new BorderLayout());
        fontSizePanel.setBorder(BorderFactory.createTitledBorder("Size"));
        fontSizePanel.add(new JScrollPane(sizeList));
        
        fontPanel.add(fontNamePanel);
        fontPanel.add(fontSizePanel);
        
        // Style panel
        JPanel stylePanel = new JPanel(new FlowLayout());
        stylePanel.setBorder(BorderFactory.createTitledBorder("Style"));
        stylePanel.add(boldCheckBox);
        stylePanel.add(italicCheckBox);
        
        // Top panel combining font and style
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(fontPanel, BorderLayout.CENTER);
        topPanel.add(stylePanel, BorderLayout.SOUTH);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        
        okButton.addActionListener(e -> {
            approved = true;
            dispose();
        });
        
        cancelButton.addActionListener(e -> {
            approved = false;
            dispose();
        });
        
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        
        // Add all panels
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(previewLabel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        pack();
        setLocationRelativeTo(getParent());
    }

    private void setupEventHandlers() {
        fontList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                updateFont();
            }
        });
        
        sizeList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                updateFont();
            }
        });
        
        boldCheckBox.addActionListener(e -> updateFont());
        italicCheckBox.addActionListener(e -> updateFont());
    }

    private void updateFont() {
        String fontName = fontList.getSelectedValue();
        String sizeStr = sizeList.getSelectedValue();
        
        if (fontName == null) fontName = selectedFont.getFontName();
        if (sizeStr == null) sizeStr = String.valueOf(selectedFont.getSize());
        
        int size = Integer.parseInt(sizeStr);
        int style = Font.PLAIN;
        
        if (boldCheckBox.isSelected()) {
            style |= Font.BOLD;
        }
        if (italicCheckBox.isSelected()) {
            style |= Font.ITALIC;
        }
        
        selectedFont = new Font(fontName, style, size);
        updatePreview();
    }

    private void updatePreview() {
        previewLabel.setFont(selectedFont);
        previewLabel.repaint();
    }

    public Font getSelectedFont() {
        return approved ? selectedFont : null;
    }

    public static Font showDialog(Component parent, String title, Font initialFont) {
        Frame frame = parent instanceof Frame ? (Frame) parent : 
                     (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);
        
        FontChooser chooser = new FontChooser(frame, title, initialFont);
        chooser.setVisible(true);
        
        return chooser.getSelectedFont();
    }
}