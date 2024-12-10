package QuanLyThuVien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Swing{
    private JFrame frame;
    ThuVien thuVienGoc=new ThuVien("0001", "Nha Sach Lac Viet");
    public Swing() {
        frame = new JFrame("Library Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea Area = new JTextArea();
        Area.setEditable(false);
        Area.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(Area);
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(6, 1, 10, 30)); 

        JButton addLibraryButton = new JButton("addLibrary");
        JButton addBookButton = new JButton("addBook");
        JButton searchBookButton = new JButton("searchBook");
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");

        rightPanel.add(addLibraryButton);
        rightPanel.add(addBookButton);
        rightPanel.add(searchBookButton);
        rightPanel.add(saveButton);
        rightPanel.add(exitButton);

       
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 4, 10, 10)); 

        JButton bookInfoButton = new JButton("BookInformation");
        JButton sortButton = new JButton("SortBook");
        JButton libraryButton = new JButton("Library");

        bottomPanel.add(bookInfoButton);
        bottomPanel.add(sortButton);
        bottomPanel.add(libraryButton);
        
        // su kien
        exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
        	
        });
        ArrayList<ThuVien> thuviens=new ArrayList<>();
        thuviens.add(thuVienGoc);
        addLibraryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "";
		        String name = "";
		        while (id == null || id.trim().isEmpty()) {
		            id = JOptionPane.showInputDialog("Nhập vào mã thư viện mới:");
		            if (id == null || id.trim().isEmpty()) {
		                JOptionPane.showMessageDialog(frame, "Mã thư viện không thể trống. Vui lòng nhập lại.");
		            }
		        }
		        while (name == null || name.trim().isEmpty()) {
		            name = JOptionPane.showInputDialog("Nhập tên thư viện mới:");
		            if (name == null || name.trim().isEmpty()) {
		                JOptionPane.showMessageDialog(frame, "Tên thư viện không thể trống. Vui lòng nhập lại.");
		            }
		        }

				ThuVien thuvien=new ThuVien(id, name);
				thuviens.add(thuvien);
			    JOptionPane.showMessageDialog(frame, "Them thu vien moi thanh cong");
			}
        	
        });
        libraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Area.setText("");
                for(ThuVien a: thuviens) {
                	 Area.append(a.toString() + "\n");
                }
            }
        });
        addBookButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					String id = JOptionPane.showInputDialog("Nhập mã sách vào: ");
		            if (id == null || id.trim().isEmpty()) {
		                JOptionPane.showMessageDialog(frame, "Mã sách không thể trống.");
		                return;
		            }
		            String tieuDe = JOptionPane.showInputDialog("Nhập tiêu đề sách vào: ");
		            if (tieuDe == null || tieuDe.trim().isEmpty()) {
		                JOptionPane.showMessageDialog(frame, "Tiêu đề sách không thể trống.");
		                return;
		            }
		            String author = JOptionPane.showInputDialog("Nhập tên tác giả vào: ");
		            if (author == null || author.trim().isEmpty()) {
		                JOptionPane.showMessageDialog(frame, "Tên tác giả không thể trống.");
		                return;
		            }
		            String theLoai = JOptionPane.showInputDialog("Nhập thể loại vào: ");
		            if (theLoai == null || theLoai.trim().isEmpty()) {
		                JOptionPane.showMessageDialog(frame, "Thể loại không thể trống.");
		                return;
		                }
		         int namXb=Integer.parseInt(JOptionPane.showInputDialog("Nhap nam xuat ban vao"));
		         if(namXb<0 || namXb>2024) {
		        	 JOptionPane.showMessageDialog(frame, "Sai nam xuat ban");
		        	 return;
		         }
		         boolean trangthai=true;
				Sach book=new Sach(id, tieuDe, author, theLoai, namXb, trangthai);
				thuVienGoc.themSach(book);
				JOptionPane.showMessageDialog(frame, "Da them sach vao thu vien "+thuVienGoc.getIdThuvien());
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(frame, "Loi nam xuat ban phai la so");
				}
				}
        });
        bookInfoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Area.setText("");
				for(Sach sach:thuVienGoc.getBook())
				{
					Area.append(sach.toString()+"\n");
				}	
			}
        });	
        searchBookButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String query=JOptionPane.showInputDialog("Nhap vao ten tac gia hoac tieu de de tim kiem");
				Area.setText(thuVienGoc.timKiemSach(query));
				
			}
        });
        sortButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			   Area.setText("");
			   for(Sach sach:thuVienGoc.danhSachXapXep()) {
				   Area.append(sach.toString()+"\n");
			   }
			}
        });
        frame.add(scrollPane, BorderLayout.CENTER); 
        frame.add(rightPanel, BorderLayout.EAST);   
        frame.add(bottomPanel, BorderLayout.SOUTH); 
        frame.setVisible(true);
    }
}
