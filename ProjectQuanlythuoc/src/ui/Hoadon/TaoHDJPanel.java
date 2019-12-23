package ui.Hoadon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.ConnectDB;
import dao.Hoadon.Hoadon_DAO;
import dao.Taikhoan.Taikhoan_DAO;
import entities.Chitiethoadon;
import entities.Hoadon;
import entities.Khachhang;
import entities.Nguoidung;
import entities.Taikhoan;
import entities.Thuoc;

public class TaoHDJPanel extends JPanel implements ActionListener{
	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinHD;
	private JLabel lblMaHD;
	private JTextField txtMaHD;
	private JLabel lblTenKH;
	private JLabel lblSoluong;
	private JTextField txtSoluong;
	private JLabel lbltenThuoc;
	private JComboBox<String> cmbTenthuoc;
	private JLabel lblDongia;
	private JTextField txtDongia;
	private JLabel lblNgaynhap;
	private JDateChooser choseNgaynhap;
	private JScrollPane srcBangthongtin1;
	private DefaultTableModel tableModel1;
	private JTable table1;
	private JLabel lblSDT;
	private JTextField txtSDT;
	private JScrollPane srcThongtinKH;
	private JLabel lblTenNV;
	private JTextField txtTenNV;
	private JComboBox<String> cmbTenKH;
	private JScrollPane srcThaotac;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnCapnhat;
	private JButton btnXoa;
	private JScrollPane srcBangthongtin2;
	private DefaultTableModel tableModel2;
	private JTable table2;
	private Hoadon_DAO hoadon_dao;
	private String MAHD = null;
	private String MAHD2 = null;
	private JButton btnXoarong;
	private String msnv;
	private Taikhoan_DAO tk_DAO;

	public TaoHDJPanel(String ma) {
		ConnectDB.getInstance().getConnection();
		hoadon_dao = new Hoadon_DAO();
		setBackground(Color.white);
		setLayout(null);
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("QUẢN LÝ THUỐC");
		lblTitle.setBounds(0, 0, 200, 25);

		lblQuanly = new JLabel();
		lblQuanly.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblQuanly.setForeground(new java.awt.Color(0, 204, 153));
		lblQuanly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
		lblQuanly.setText("QUẢN LÝ HÓA ĐƠN");
		lblQuanly.setBounds(1140, 0, 280, 50);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lblChucnang.setText(">>Tạo hóa đơn");
		lblChucnang.setBounds(10, 25, 200, 20);

		srcThongtinHD = new JScrollPane();
		srcThongtinHD.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		srcThongtinHD.setLayout(null);
		//
		lblMaHD = new JLabel();
		lblMaHD.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMaHD.setText("Mã HD:");
		lblMaHD.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaHD.setBounds(-20, 20, 100, 30);
		txtMaHD = new JTextField();
		txtMaHD.setBounds(100, 24, 400, 23);
		txtMaHD.setEditable(false);
		//
		lblTenKH = new JLabel();
		lblTenKH.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTenKH.setText("Tên KH:");
		lblTenKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKH.setBounds(-40, 55, 100, 30);
		cmbTenKH = new JComboBox<String>();
		cmbTenKH.setBounds(80, 59, 200, 23);
		//
		lblSDT = new JLabel();
		lblSDT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblSDT.setText("SĐT:");
		lblSDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSDT.setBounds(-40, 90, 100, 30);
		txtSDT = new JTextField();
		txtSDT.setBounds(80, 94, 200, 23);
		txtSDT.setEditable(false);
		//
		lblSoluong = new JLabel();
		lblSoluong.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblSoluong.setText("Số lượng:");
		lblSoluong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoluong.setBounds(-20, 90, 100, 30);
		txtSoluong = new JTextField();
		txtSoluong.setBounds(100, 94, 70, 23);
		//
		lbltenThuoc = new JLabel();
		lbltenThuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbltenThuoc.setText("Tên thuốc:");
		lbltenThuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltenThuoc.setBounds(-20, 55, 100, 30);
		cmbTenthuoc = new JComboBox<String>();
		cmbTenthuoc.setBounds(100, 59, 200, 23);
		//
		lblDongia = new JLabel();
		lblDongia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblDongia.setText("Đơn giá:");
		lblDongia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDongia.setBounds(260, 55, 100, 30);
		txtDongia = new JTextField();
		txtDongia.setBounds(370, 59, 130, 23);
		txtDongia.setEditable(false);
		//
		lblNgaynhap = new JLabel("Ngày bán:");
		lblNgaynhap.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblNgaynhap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgaynhap.setBounds(140, 90, 100, 30);
		choseNgaynhap = new JDateChooser();
		choseNgaynhap.setDateFormatString("dd/MM/yyyy");
		choseNgaynhap.setBounds(250, 94, 250, 23);
		//
		lblTenNV = new JLabel();
		lblTenNV.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTenNV.setText("Tên NV:");
		lblTenNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNV.setBounds(-40, 20, 100, 30);
		txtTenNV = new JTextField();
		txtTenNV.setBounds(80, 24, 300, 23);
		txtTenNV.setEditable(false);
		//
		srcThongtinHD.setBounds(0, 50, 600, 200);
		srcThongtinHD.setBackground(Color.white);
		srcThongtinHD.add(lblMaHD);
		srcThongtinHD.add(txtMaHD);
		srcThongtinHD.add(lbltenThuoc);
		srcThongtinHD.add(cmbTenthuoc);
		srcThongtinHD.add(lblSoluong);
		srcThongtinHD.add(txtSoluong);
		srcThongtinHD.add(lblDongia);
		srcThongtinHD.add(txtDongia);
		srcThongtinHD.add(lblNgaynhap);
		srcThongtinHD.add(choseNgaynhap);
		//
		srcThongtinKH = new JScrollPane();
		srcThongtinKH.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng mua thuốc và nhân viên thực hiện"));
		srcThongtinKH.setLayout(null);
		srcThongtinKH.setBounds(605, 50, 500, 200);
		srcThongtinKH.setBackground(Color.white);
		srcThongtinKH.add(lblTenNV);
		srcThongtinKH.add(txtTenNV);
		srcThongtinKH.add(lblTenKH);
		srcThongtinKH.add(cmbTenKH);
		srcThongtinKH.add(lblSDT);
		srcThongtinKH.add(txtSDT);
		//
		srcThaotac = new JScrollPane();
		srcThaotac.setBorder(BorderFactory.createTitledBorder(""));
		srcThaotac.setLayout(null);
		//
		btnTim = new JButton("Tìm", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-24.png")));
		btnTim.setFocusPainted(false);
		btnTim.setFont(new Font("Arial", 0, 14));
		btnTim.setForeground(new Color(45, 179, 0));
		btnTim.setBounds(65, 10, 130, 30);
		btnTim.setBackground(Color.white);
		//
		btnThem = new JButton("Tạo HD", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-add-24.png")));
		btnThem.setFocusPainted(false);
		btnThem.setFont(new Font("Arial", 0, 14));
		btnThem.setForeground(new Color(45, 179, 0));
		btnThem.setBounds(65, 45, 130, 30);
		btnThem.setBackground(Color.white);
		//
		btnCapnhat = new JButton("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-update-24.png")));
		btnCapnhat.setFocusPainted(false);
		btnCapnhat.setFont(new Font("Arial", 0, 14));
		btnCapnhat.setForeground(new Color(45, 179, 0));
		btnCapnhat.setBounds(65, 80, 130, 30);
		btnCapnhat.setBackground(Color.white);
		//
		btnXoa = new JButton("Xóa", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delete-24.png")));
		btnXoa.setFocusPainted(false);
		btnXoa.setFont(new Font("Arial", 0, 14));
		btnXoa.setForeground(new Color(45, 179, 0));
		btnXoa.setBounds(65, 115, 130, 30);
		btnXoa.setBackground(Color.white);
		//
		btnXoarong = new JButton();
		btnXoarong.setBackground(new java.awt.Color(255, 255, 255));
		btnXoarong.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		btnXoarong.setForeground(new java.awt.Color(45, 179, 0));
		btnXoarong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-eraser-24.png"))); // NOI18N
		btnXoarong.setText("Xóa rỗng");
		btnXoarong.setFocusPainted(false);
		btnXoarong.setBounds(65, 150, 130, 30);
		//
		srcThaotac.setBounds(1110, 50, 250, 200);
		srcThaotac.setBackground(Color.white);
		srcThaotac.add(btnCapnhat);
		srcThaotac.add(btnTim);
		srcThaotac.add(btnThem);
		srcThaotac.add(btnXoa);
		srcThaotac.add(btnXoarong);
		//
		srcBangthongtin1 = new JScrollPane();
		String [] headers1 = "Mã hóa đơn;Ngày lập HD;Tên KH;Nhân viên;Thành tiền".split(";");
		tableModel1 = new DefaultTableModel(headers1, 0);
		add(srcBangthongtin1 = new JScrollPane(table1 = new JTable(tableModel1), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		srcBangthongtin1.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		table1.setBackground(Color.white);
		table1.getTableHeader().setBackground(new Color(32,136,203));
		srcBangthongtin1.setBackground(Color.white);
		srcBangthongtin1.setBounds(7, 255, 675, 400);
		//
		srcBangthongtin2 = new JScrollPane();
		String [] headers2 = "Mã thuốc;Tên Thuốc;Đơn Giá;Số lượng".split(";");
		tableModel2 = new DefaultTableModel(headers2, 0);
		add(srcBangthongtin2 = new JScrollPane(table2 = new JTable(tableModel2), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		srcBangthongtin2.setBorder(BorderFactory.createTitledBorder("Thông tin chi tiết hóa đơn"));
		table2.setBackground(Color.white);
		table2.getTableHeader().setBackground(new Color(32,136,203));
		srcBangthongtin2.setBackground(Color.white);
		srcBangthongtin2.setBounds(682, 255, 675, 400);
		//
		add(lblTitle);
		add(lblQuanly);
		add(lblChucnang);
		add(srcThongtinHD);
		add(srcThongtinKH);
		add(srcThaotac);
		add(srcBangthongtin1);
		add(srcBangthongtin2);
		docdulieuvaoTable();
		loadCmb();
		table1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table1.getSelectedRow();
				txtMaHD.setText(tableModel1.getValueAt(row, 0).toString());
				choseNgaynhap.setDate((Date) tableModel1.getValueAt(row, 1));
				txtDongia.setText(tableModel1.getValueAt(row, 4).toString());
				String manv = tableModel1.getValueAt(row, 3).toString();
				txtTenNV.setText(hoadon_dao.getNuoiDungTheoMa(manv).getHoten());
				String makh = tableModel1.getValueAt(row, 2).toString();
				cmbTenKH.setSelectedItem(hoadon_dao.getKhachHangTheoMa(makh).getHoten());
				txtSDT.setText(hoadon_dao.getKhachHangTheoMa(makh).getSdt());

				MAHD = txtMaHD.getText();
				if (MAHD2==null) {
					MAHD2 = MAHD;
				}
				if(MAHD2!=MAHD) {
					tableModel2.getDataVector().removeAllElements();
				}
				if (hoadon_dao.checktrungma(MAHD)==true) {
					docdulieuvaoTable2(MAHD);
				}

			}
		});	
		table2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table2.getSelectedRow();
				String mathuoc = (String) tableModel2.getValueAt(row, 1).toString();
				String tenThuoc = hoadon_dao.timThuocByma(mathuoc);
				cmbTenthuoc.setSelectedItem(tenThuoc);
				txtSoluong.setText(tableModel2.getValueAt(row, 3).toString());
			}
		});
		randomMa();
		btnCapnhat.addActionListener(this);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoarong.addActionListener(this);
		doctenNV(ma);
		msnv = ma;
	}

	private void doctenNV(String ma) {
		txtTenNV.setText(hoadon_dao.getNuoiDungTheoMa(ma).getHoten());
	}

	private void docdulieuvaoTable() {
		long tongtien = 0;
		List<Hoadon> list = hoadon_dao.getAllHoaDon();
		long gia=0;
		for(Hoadon hd : list) {
			String mahd = hd.getMaHoaDon();
			tableModel1.addRow(new Object[] {
					hd.getMaHoaDon(),
					hd.getNgayLap(),
					hd.getMaKH().getMaKH(),
					hd.getMaNgdung().getTaiKhoan().getPassWord(),
					gia = dongia(mahd)
			});
		}
	}
	private void docdulieuvaoTable2(String mahd) {
		List<Chitiethoadon> list = hoadon_dao.getAllCTHoaDon(mahd);
		for(Chitiethoadon hd : list) {
			double dongiathuoc = 0;
			String mathuoc = hd.getMaThuoc().getMaThuoc();
			dongiathuoc = hoadon_dao.getAllThuoc2(mathuoc);
			tableModel2.addRow(new Object[] {
					hd.getMaHoadon().getMaHoaDon(),
					hd.getMaThuoc().getMaThuoc(),
					dongiathuoc,
					hd.getSoLuong()
			});
		}
	}
	private void loadCmb() {
		List<Khachhang> dsKhachhang = hoadon_dao.getallTenTK();
		for(Khachhang kh : dsKhachhang) {
			String ten = kh.getHoten();
			cmbTenKH.addItem(ten);
		}

		List<Thuoc> dsthuoc = hoadon_dao.getAllThuoc();
		for(Thuoc t : dsthuoc) {
			String ten = t.getTenThuoc();
			cmbTenthuoc.addItem(ten);
		}
		cmbTenKH.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//				String tenKH = cmbTenKH.getSelectedItem().toString();
//				Khachhang kh = hoadon_dao.getKhachHangTheoTen(tenKH);
//				System.out.println(kh.getSdt());
//				txtSDT.setText(kh.getSdt());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				String tenKH = cmbTenKH.getSelectedItem().toString();
				Khachhang kh = hoadon_dao.getKhachHangTheoTen(tenKH);
				txtSDT.setText(kh.getSdt());
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
//				String tenKH = cmbTenKH.getSelectedItem().toString();
//				Khachhang kh = hoadon_dao.getKhachHangTheoTen(tenKH);
//				System.out.println(kh.getSdt());
//				txtSDT.setText(kh.getSdt());
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String tenKH = cmbTenKH.getSelectedItem().toString();
				Khachhang kh = hoadon_dao.getKhachHangTheoTen(tenKH);
				txtSDT.setText(kh.getSdt());
			}
		});
	}

	public long dongia(String ma) {
		List<Chitiethoadon> list2 = hoadon_dao.getAllCTHoaDon(ma);
		String MaThuoc = null;
		int soluong = 0;
		double gia = 0;
		long dongia = 0;
		for(Chitiethoadon ct : list2) {
			MaThuoc = ct.getMaThuoc().getMaThuoc();
			gia = hoadon_dao.getAllThuoc2(MaThuoc);
			soluong = ct.getSoLuong();
			dongia += gia*soluong;
		}
		return dongia;
	}
	private void randomMa() {
		int max = 100;
		int min = 0;
		boolean listcheck;
		String mahd;
		Random rand = new Random();
		do {
			int n = rand.nextInt((max-min)+1) + min;
			mahd = "HD"+n;
			listcheck = hoadon_dao.checktrungma(mahd);
		} while (listcheck==true);
		txtMaHD.setText(mahd);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoarong)) {
			randomMa();
			txtDongia.setText("");
			txtSDT.setText("");
			txtSoluong.setText("");
			tableModel1.setRowCount(0);
			tableModel2.setRowCount(0);
			docdulieuvaoTable();
			doctenNV(msnv);
		}else {
			if (o.equals(btnXoa)) {
				String mahd = txtMaHD.getText();
				int row1 = table2.getSelectedRow();
				int row2 = table1.getSelectedRow();
				if (row1>=0) {
					String mathuoc = (String) table2.getValueAt(row1, 1);
					if (hoadon_dao.daleteThuoc(mathuoc, mahd)) {
						tableModel2.removeRow(row1);
					}
				}else {
					if (row2>=0) {
						hoadon_dao.daleteHoaDon(mahd);
						tableModel1.removeRow(row2);
						tableModel2.setRowCount(0);
					}else {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn hoá đơn hoặc thuốc trong hóa đơn để xóa");
					}
					randomMa();
				}

			}else {
				if (o.equals(btnThem)) {
					String mahd = txtMaHD.getText();
					Date date = choseNgaynhap.getDate();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					String tenkh = (String) cmbTenKH.getSelectedItem();
					String makh = hoadon_dao.getKhachHangTheoTen(tenkh).getMaKH();
					String manv = msnv;
					tk_DAO = new Taikhoan_DAO();
					Taikhoan tk = tk_DAO.timTaikhoanbyMa(manv);
					Hoadon hd = new Hoadon(mahd, new Khachhang(makh), new Nguoidung(tk), sqlDate);
					if(hoadon_dao.taoHoaDon(hd) == true) {
						double gia = 0;
						tableModel1.addRow(new Object[] {
								hd.getMaHoaDon(),
								hd.getNgayLap(),
								makh,
								hd.getMaNgdung().getTaiKhoan().getUserName(),
								gia
						});
						JOptionPane.showMessageDialog(null,"Tạo thành công");
					}
				}else {
					if (o.equals(btnTim)) {
						if (txtSDT.getText().length()>0) {
							String makh = hoadon_dao.getKhachHangTheoSDT(txtSDT.getText()).getMaKH();
							cmbTenKH.setSelectedItem(hoadon_dao.getKhachHangTheoMa(makh).getHoten());
						}else {
							//							if (choseNgaynhap.getDate().toString().length()>0) {
							//								String date2 = choseNgaynhap.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
							//								tableModel1.setRowCount(0);
							//								docdata(date2);
							//							}else {
							String maNV = "NV06";
							tableModel1.setRowCount(0);
							docdata2(maNV);
							//							}
						}
					}else {
						if (o.equals(btnCapnhat)) {
							String mahd = txtMaHD.getText();
							String tenthuoc = (String) cmbTenthuoc.getSelectedItem();
							String mathuoc = hoadon_dao.getThuocTheoTen(tenthuoc);
							int soluong = Integer.parseInt(txtSoluong.getText());
							if (soluong<=0) {
								JOptionPane.showMessageDialog(null,"Nhập số lượng thuốc thêm");
							}
							Chitiethoadon cthd = new Chitiethoadon(new Hoadon(mahd), new Thuoc(mathuoc), soluong);
							if(hoadon_dao.taoCTHoaDon(cthd) == true) {
								double dongiathuoc = 0;
								dongiathuoc = hoadon_dao.getAllThuoc2(mathuoc);
								tableModel2.addRow(new Object[] {
										cthd.getMaHoadon().getMaHoaDon(),
										cthd.getMaThuoc().getMaThuoc(),
										dongiathuoc,
										cthd.getSoLuong()
								});
								JOptionPane.showMessageDialog(null,"Tạo hóa đơn thành công");
								tableModel1.setRowCount(0);
								docdulieuvaoTable();
							}
						}
					}
				}
			}
		}
	}


	private void docdata2(String manv) {
		List<Hoadon> list = hoadon_dao.getAllHoaDonTheoMaNV(manv);
		long gia=0;
		for(Hoadon hd : list) {
			String mahd = hd.getMaHoaDon();
			tableModel1.addRow(new Object[] {
					hd.getMaHoaDon(),
					hd.getNgayLap(),
					hd.getMaKH().getMaKH(),
					hd.getMaNgdung().getTaiKhoan().getUserName(),
					gia = dongia(mahd)
			});
		}
	}
}
