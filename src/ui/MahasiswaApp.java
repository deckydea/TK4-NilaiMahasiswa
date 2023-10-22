package ui;

import javax.swing.*;

import connection.DatabaseHandler;
import model.Mahasiswa;

import java.awt.*;

public class MahasiswaApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfNama, tfNIM, tfNilaiTugas, tfNilaiKuis, tfNilaiUTS, tfNilaiUAS;
	private JButton btnSimpan, btnHitung, btnReset;
	private JPanel inputPanel, outputPanel, buttonPanel;

	public MahasiswaApp() {
		setTitle("Aplikasi Nilai Mahasiswa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupUI();
	}

	private void setupUI() {
		setLayout(new BorderLayout());

		inputPanel = createInputPanel();
		add(inputPanel, BorderLayout.WEST);

		outputPanel = createOutputPanel();
		add(outputPanel, BorderLayout.CENTER);

		buttonPanel = createButtonPanel();
		add(buttonPanel, BorderLayout.SOUTH);

		pack();
		setSize(600, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JPanel createInputPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(250, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.NORTH;

		JLabel[] labels = { new JLabel("Nama:"), new JLabel("NIM:"), new JLabel("Nilai Tugas:"),
				new JLabel("Nilai Kuis:"), new JLabel("Nilai UTS:"), new JLabel("Nilai UAS:") };

		JTextField[] fields = { tfNama = new JTextField(15), tfNIM = new JTextField(15),
				tfNilaiTugas = new JTextField(3), tfNilaiKuis = new JTextField(3), tfNilaiUTS = new JTextField(3),
				tfNilaiUAS = new JTextField(3) };

		for (int i = 0; i < labels.length; i++) {
			gbc.gridx = 0;
			gbc.gridy = i;
			gbc.anchor = GridBagConstraints.WEST;
			panel.add(labels[i], gbc);

			gbc.gridx = 1;
			gbc.gridy = i;
			gbc.weightx = 1;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.WEST;
			panel.add(fields[i], gbc);
		}

		return panel;
	}

	private JPanel createOutputPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		return panel;
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnSimpan = new JButton("Simpan");
		btnHitung = new JButton("Hitung");
		btnReset = new JButton("Reset");

		btnSimpan.addActionListener(e -> simpanDataMahasiswa());
		btnHitung.addActionListener(e -> hitungRerata());
		btnReset.addActionListener(e -> resetInputFields());

		panel.add(btnSimpan);
		panel.add(btnHitung);
		panel.add(btnReset);

		return panel;
	}

	private void simpanDataMahasiswa() {
		String nama = tfNama.getText();
		String nim = tfNIM.getText();
		int nilaiTugas = Integer.parseInt(tfNilaiTugas.getText());
		int nilaiKuis = Integer.parseInt(tfNilaiKuis.getText());
		int nilaiUTS = Integer.parseInt(tfNilaiUTS.getText());
		int nilaiUAS = Integer.parseInt(tfNilaiUAS.getText());

		Mahasiswa mahasiswa = new Mahasiswa(nama, nim, nilaiTugas, nilaiKuis, nilaiUTS, nilaiUAS);

		DatabaseHandler dbManager = new DatabaseHandler();
		dbManager.insertMahasiswa(mahasiswa);

		JOptionPane.showMessageDialog(this, "Data berhasil disimpan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
		resetInputFields();
	}

	private void hitungRerata() {
		String nama = tfNama.getText();
		String nim = tfNIM.getText();
		int nilaiTugas = Integer.parseInt(tfNilaiTugas.getText());
		int nilaiKuis = Integer.parseInt(tfNilaiKuis.getText());
		int nilaiUTS = Integer.parseInt(tfNilaiUTS.getText());
		int nilaiUAS = Integer.parseInt(tfNilaiUAS.getText());

		Mahasiswa mahasiswa = new Mahasiswa(nama, nim, nilaiTugas, nilaiKuis, nilaiUTS, nilaiUAS);
		display(mahasiswa);
		revalidate();
	}

	private void display(Mahasiswa mahasiswa) {
		JLabel[] labels = { new JLabel("Nama: " + mahasiswa.getNama()), new JLabel("NIM: " + mahasiswa.getNim()),
				new JLabel("Rerata: " + mahasiswa.hitungRerata()), new JLabel("Grade: " + mahasiswa.tentukanGrade()),
				new JLabel("Keterangan: " + mahasiswa.tentukanKeterangan()) };

		for (JLabel label : labels) {
			outputPanel.add(label);
		}
	}

	private void resetInputFields() {
		outputPanel.removeAll();
		outputPanel.revalidate();
		outputPanel.repaint();
		tfNama.setText("");
		tfNIM.setText("");
		tfNilaiTugas.setText("");
		tfNilaiKuis.setText("");
		tfNilaiUTS.setText("");
		tfNilaiUAS.setText("");
	}
}
