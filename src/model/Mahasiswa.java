package model;

public class Mahasiswa {
	private String nama;
	private String nim;
	private int nilaiTugas;
	private int nilaiKuis;
	private int nilaiUTS;
	private int nilaiUAS;

	public Mahasiswa(String nama, String nim, int nilaiTugas, int nilaiKuis, int nilaiUTS, int nilaiUAS) {
		this.nama = nama;
		this.nim = nim;
		this.nilaiTugas = nilaiTugas;
		this.nilaiKuis = nilaiKuis;
		this.nilaiUTS = nilaiUTS;
		this.nilaiUAS = nilaiUAS;
	}

	public double hitungRerata() {
		return (nilaiTugas + nilaiKuis + nilaiUTS + nilaiUAS) / 4.0;
	}

	public String tentukanGrade() {
		double rerata = hitungRerata();
		if (rerata >= 80) {
			return "A";
		} else if (rerata >= 70) {
			return "B";
		} else if (rerata >= 60) {
			return "C";
		} else {
			return "D";
		}
	}

	public String tentukanKeterangan() {
		double rerata = hitungRerata();
		return rerata >= 60 ? "Lulus" : "Tidak Lulus";
	}

	@Override
	public String toString() {
		return "Nama: " + nama + "\nNIM: " + nim + "\nRerata: " + hitungRerata() + "\nGrade: " + tentukanGrade()
				+ "\nKeterangan: " + tentukanKeterangan() + "\n";
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public int getNilaiTugas() {
		return nilaiTugas;
	}

	public void setNilaiTugas(int nilaiTugas) {
		this.nilaiTugas = nilaiTugas;
	}

	public int getNilaiKuis() {
		return nilaiKuis;
	}

	public void setNilaiKuis(int nilaiKuis) {
		this.nilaiKuis = nilaiKuis;
	}

	public int getNilaiUTS() {
		return nilaiUTS;
	}

	public void setNilaiUTS(int nilaiUTS) {
		this.nilaiUTS = nilaiUTS;
	}

	public int getNilaiUAS() {
		return nilaiUAS;
	}

	public void setNilaiUAS(int nilaiUAS) {
		this.nilaiUAS = nilaiUAS;
	}
	
	
	
}
