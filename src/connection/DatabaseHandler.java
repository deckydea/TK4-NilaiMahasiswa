package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Mahasiswa;

public class DatabaseHandler {
	private Connection connection;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/mahasiswa";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";

	public DatabaseHandler() {
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Gagal terhubung ke database.");
		}
	}

    public void insertMahasiswa(Mahasiswa mahasiswa) {
        try {
        	 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO nilai_mahasiswa (nama, nim, nilai_tugas, nilai_kuis, nilai_uts, nilai_uas) VALUES (?, ?, ?, ?, ?, ?)");
             preparedStatement.setString(1, mahasiswa.getNama());
             preparedStatement.setString(2, mahasiswa.getNim());
             preparedStatement.setInt(3, mahasiswa.getNilaiTugas());
             preparedStatement.setInt(4, mahasiswa.getNilaiKuis());
             preparedStatement.setInt(5, mahasiswa.getNilaiUTS());
             preparedStatement.setInt(6, mahasiswa.getNilaiUAS());
             preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
