  package QuanLyThuVien;

public class Sach {
	private String id;
	private String tieuDe;
	private String author;
	private String theLoai;
	private int namXuatBan;
	private boolean  trangThai;
	public Sach(String id, String tieuDe, String author, String theLoai, int namXuatBan, boolean trangThai) {
		super();
		this.id = id;
		this.tieuDe = tieuDe;
		this.author = author;
		this.theLoai = theLoai;
		this.namXuatBan = namXuatBan;
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "Sach [id=" + id + ", tieuDe=" + tieuDe + ", author=" + author + ", theLoai=" + theLoai + ", namXuatBan="
				+ namXuatBan + ", trangThai=" + trangThai + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public boolean getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
}
