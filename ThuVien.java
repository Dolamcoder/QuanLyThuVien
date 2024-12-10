package QuanLyThuVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ThuVien implements QuanLy {
	private String  idThuvien;
	private String tenThuVien;
	ArrayList<Sach> arr=new ArrayList<>();
	
	public ThuVien(String idThuvien, String tenThuVien) {
		this.idThuvien = idThuvien;
		this.tenThuVien = tenThuVien;
	}

	@Override
	public void themSach(Sach a) {
		
		arr.add(a);
		System.out.println("Them thanh cong sach: "+a.getTieuDe());
	}
	
	@Override
	public void xoaSach(Sach a) {
	   for(int i=0;i<arr.size();i++)	
	   {
		   if(arr.get(i).getId().equals(a.getId())) {
			   arr.remove(i);
		   }
	   }
	}
	@Override
	 public String timKiemSach(String author_tieude) {
		String result="";
		 for(int i=0;i<arr.size();i++)
		 {
			 if(arr.get(i).getAuthor().equals(author_tieude) || arr.get(i).getTieuDe().equals(author_tieude)) {
				 result+=arr.get(i).toString()+"\n";
			 }
		 }
		 return result;
	 }
	@Override
	public void danhSach()
	{
		for(Sach x:arr) {
			System.out.println(x);
		}
	}
	public ArrayList<Sach> getBook() {
		return arr;
	}

	public ArrayList<Sach> danhSachXapXep() {
	   Collections.sort(arr, new Comparator<Sach>() {
		@Override
		public int compare(Sach a, Sach b) {
			if(a.getNamXuatBan()!=b.getNamXuatBan())
			return b.getNamXuatBan()-a.getNamXuatBan();
			return a.getTieuDe().compareTo(b.getTieuDe());
		}
	   });
	   return arr;
	}
	public String getIdThuvien() {
		return idThuvien;
	}

	public void setIdThuvien(String idThuvien) {
		this.idThuvien = idThuvien;
	}

	public String getTenThuVien() {
		return tenThuVien;
	}

	public void setTenThuVien(String tenThuVien) {
		this.tenThuVien = tenThuVien;
	}

	@Override
	public String toString() {
		return "ThuVien [idThuvien=" + idThuvien + ", tenThuVien=" + tenThuVien +",Tong so sach: " + arr.size()+"]";
		
	}
}
