package ui.Thuoc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import dao.Thuoc.TimThuoc_DAO;
import entities.Donvithuoc;
import entities.Nhacungcap;
import entities.Nuoc;
import entities.Thuoc;

public class TimthuocJPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane srcThongtinthuoc;
	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JLabel lblTenThuoc;
	private JTextField txtTenThuoc;
	private JLabel lbltinhTrang;
	private JComboBox<String> cmbtinhTrang;
	private JLabel lbldonGia;
	private JTextField txtdonGia;
	private JLabel lbldanhMucthuoc;
	private JComboBox<String> cmbdanhMucthuoc;
	private JLabel lblDonvithuoc;
	private JComboBox<String> cmbDonvithuoc;
	private JLabel lblNuoc;
	private JComboBox<String> cmbNuoc;
	private JLabel lblNhaCC;
	private JComboBox<String> cmbNhaCC;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnCapnhat;
	private JButton btnXoa;
	private JScrollPane srcBangthongtin;
	private JTable table;
	private DefaultTableModel tableModel;
	private JLabel lblNgaynhap;
	private JDateChooser choseNgaynhap;
	private TimThuoc_DAO timthuoc_DAO;
	private JLabel lblMathuoc;
	private JTextField txtMathuoc;
	private JButton btnRefresh;
	private JButton btnXoarong;
	private JLabel lblNgayhethan;
	private JDateChooser choseNgayhethan;

	public TimthuocJPanel() {
		ConnectDB.getInstance().getConnection();
		setBackground(Color.white);
		setLayout(null);
		timthuoc_DAO = new TimThuoc_DAO();
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("QUẢN LÝ THUỐC");
		lblTitle.setBounds(0, 0, 200, 25);

		lblQuanly = new JLabel();
		lblQuanly.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblQuanly.setForeground(new java.awt.Color(0, 204, 153));
		lblQuanly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
		lblQuanly.setText("QUẢN LÝ QUẦY THUỐC");
		lblQuanly.setBounds(1100, 0, 280, 50);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lblChucnang.setText(">>Thêm, xóa, sửa thuốc");
		lblChucnang.setBounds(10, 25, 200, 20);

		srcThongtinthuoc = new JScrollPane();
		srcThongtinthuoc.setBorder(BorderFactory.createTitledBorder("Thông tin tìm kiếm thuốc"));
		srcThongtinthuoc.setLayout(null);
		srcThongtinthuoc.setBackground(Color.white);
		//
		lblMathuoc = new JLabel();
		lblMathuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMathuoc.setText("Mã thuốc:");
		lblMathuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMathuoc.setBounds(0, 20, 80, 30);
		txtMathuoc = new JTextField();
		txtMathuoc.setBounds(100, 24, 200, 23);
		txtMathuoc.setEditable(false);
		//
		lblTenThuoc = new JLabel();
		lblTenThuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTenThuoc.setText("Tên thuốc:");
		lblTenThuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenThuoc.setBounds(0, 55, 80, 30);
		txtTenThuoc = new JTextField();
		txtTenThuoc.setBounds(100, 59, 200, 23);
		//
		lbltinhTrang = new JLabel();
		lbltinhTrang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbltinhTrang.setText("Tình trạng:");
		lbltinhTrang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltinhTrang.setBounds(0, 90, 80, 30);
		cmbtinhTrang = new JComboBox<String>();
		cmbtinhTrang.setBounds(100, 94, 200, 23);
		//
		lbldonGia = new JLabel();
		lbldonGia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbldonGia.setText("Đơn giá:");
		lbldonGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldonGia.setBounds(0, 125, 80, 30);
		txtdonGia = new JTextField();
		txtdonGia.setBounds(100, 129, 200, 23);
		//
		lblDonvithuoc = new JLabel("Đơn vị:");
		lblDonvithuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblDonvithuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDonvithuoc.setBounds(0, 160, 80, 30);
		cmbDonvithuoc = new JComboBox<String>();
		cmbDonvithuoc.setBounds(100, 164, 200, 23);
		//
		lbldanhMucthuoc = new JLabel();
		lbldanhMucthuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbldanhMucthuoc.setText("Danh mục thuốc:");
		lbldanhMucthuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldanhMucthuoc.setBounds(400, 20, 130, 30);
		cmbdanhMucthuoc = new JComboBox<String>();
		cmbdanhMucthuoc.setBounds(550, 24, 300, 23);
		//
		lblNuoc = new JLabel("Nước:");
		lblNuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblNuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNuoc.setBounds(400, 55, 130, 30);
		cmbNuoc = new JComboBox<String>();
		cmbNuoc.setBounds(550, 59, 300, 23);
		//
		lblNhaCC = new JLabel("Nhà cung cấp:");
		lblNhaCC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblNhaCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNhaCC.setBounds(400, 90, 130, 30);
		cmbNhaCC = new JComboBox<String>();
		cmbNhaCC.setBounds(550, 94, 300, 23);
		//
		lblNgaynhap = new JLabel("Ngày nhập:");
		lblNgaynhap.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblNgaynhap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgaynhap.setBounds(400, 125, 130, 30);
		choseNgaynhap = new JDateChooser();
		choseNgaynhap.setDateFormatString("dd/MM/yyyy");
		choseNgaynhap.setBounds(550, 129, 300, 23);
		//
		lblNgayhethan = new JLabel("Ngày hết hạn:");
		lblNgayhethan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblNgayhethan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgayhethan.setBounds(400, 160, 130, 30);
		choseNgayhethan = new JDateChooser();
		choseNgayhethan.setDateFormatString("dd/MM/yyyy");
		choseNgayhethan.setBounds(550, 164, 300, 23);
		//
		btnTim = new JButton("Tìm", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-24.png")));
		btnTim.setFocusPainted(false);
		btnTim.setFont(new Font("Arial", 0, 14));
		btnTim.setForeground(new Color(45, 179, 0));
		btnTim.setBounds(1180, 20, 150, 30);
		btnTim.setBackground(Color.white);
		//
		btnThem = new JButton("Thêm mới", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-add-24.png")));
		btnThem.setFocusPainted(false);
		btnThem.setFont(new Font("Arial", 0, 14));
		btnThem.setForeground(new Color(45, 179, 0));
		btnThem.setBounds(1000, 20, 150, 30);
		btnThem.setBackground(Color.white);
		//
		btnCapnhat = new JButton("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-update-24.png")));
		btnCapnhat.setFocusPainted(false);
		btnCapnhat.setFont(new Font("Arial", 0, 14));
		btnCapnhat.setForeground(new Color(45, 179, 0));
		btnCapnhat.setBounds(1000, 55, 150, 30);
		btnCapnhat.setBackground(Color.white);
		//
		btnXoa = new JButton("Xóa", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delete-24.png")));
		btnXoa.setFocusPainted(false);
		btnXoa.setFont(new Font("Arial", 0, 14));
		btnXoa.setForeground(new Color(45, 179, 0));
		btnXoa.setBounds(1000, 90, 150, 30);
		btnXoa.setBackground(Color.white);
		//
		btnRefresh = new JButton("Refresh", new ImageIcon(getClass().getResource("/image/icons8-refresh-24.png")));
		btnRefresh.setFocusPainted(false);
		btnRefresh.setFont(new Font("Arial", 0, 14));
		btnRefresh.setForeground(new Color(45, 179, 0));
		btnRefresh.setBounds(1180, 55, 150, 30);
		btnRefresh.setBackground(Color.white);
		//
		btnXoarong = new JButton();
		btnXoarong.setBackground(new java.awt.Color(255, 255, 255));
        btnXoarong.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnXoarong.setForeground(new java.awt.Color(45, 179, 0));
        btnXoarong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-eraser-24.png"))); // NOI18N
        btnXoarong.setText("Xóa rỗng");
        btnXoarong.setFocusPainted(false);
        btnXoarong.setBounds(1180, 90, 150, 30);
		//
		srcBangthongtin = new JScrollPane();
		String [] headers = "Mã thuốc;Tên Thuốc;Đơn Vị;Đơn Giá;Nhà cung cấp;Nước;Danh Mục;Tình Trạng;Ngày Nhập;Ngày hết hạn".split(";");
	  	tableModel = new DefaultTableModel(headers, 0);
		add(srcBangthongtin = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		srcBangthongtin.setBorder(BorderFactory.createTitledBorder("Danh sách thuốc"));
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32,136,203));
		srcBangthongtin.setBackground(Color.white);
		srcBangthongtin.setBounds(7, 260, 1350, 400);
		//
		srcThongtinthuoc.setBounds(7, 50, 1350, 200);
		srcThongtinthuoc.add(lblMathuoc);
		srcThongtinthuoc.add(txtMathuoc);
		srcThongtinthuoc.add(lblTenThuoc);
		srcThongtinthuoc.add(txtTenThuoc);
		srcThongtinthuoc.add(lbltinhTrang);
		srcThongtinthuoc.add(cmbtinhTrang);
		srcThongtinthuoc.add(lbldonGia);
		srcThongtinthuoc.add(txtdonGia);
		srcThongtinthuoc.add(lbldanhMucthuoc);
		srcThongtinthuoc.add(cmbdanhMucthuoc);
		srcThongtinthuoc.add(lblDonvithuoc);
		srcThongtinthuoc.add(cmbDonvithuoc);
		srcThongtinthuoc.add(lblNuoc);
		srcThongtinthuoc.add(cmbNuoc);
		srcThongtinthuoc.add(lblNhaCC);
		srcThongtinthuoc.add(cmbNhaCC);
		srcThongtinthuoc.add(lblNgaynhap);
		srcThongtinthuoc.add(choseNgaynhap);
		srcThongtinthuoc.add(lblNgayhethan);
		srcThongtinthuoc.add(choseNgayhethan);
		srcThongtinthuoc.add(btnTim);
		srcThongtinthuoc.add(btnThem);
		srcThongtinthuoc.add(btnCapnhat);
		srcThongtinthuoc.add(btnXoa);
		srcThongtinthuoc.add(btnRefresh);
		srcThongtinthuoc.add(btnXoarong);
		add(lblTitle);
		add(lblQuanly);
		add(lblChucnang);
		add(srcThongtinthuoc);
		add(srcBangthongtin);
		btnThem.addActionListener(this);
		loadData();
		loadCmb();
		btnTim.addActionListener(this);
		btnCapnhat.addActionListener(this);
		btnXoa.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnXoarong.addActionListener(this);
		//
		table.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				int row = table.getSelectedRow();
				txtMathuoc.setText(tableModel.getValueAt(row, 0).toString());
				txtdonGia.setText(tableModel.getValueAt(row, 3).toString());
				cmbdanhMucthuoc.setSelectedItem(tableModel.getValueAt(row, 6).toString());
				String ma1 = (String) tableModel.getValueAt(row, 2);
				String tendv = timthuoc_DAO.timDVByma(ma1);
				cmbDonvithuoc.setSelectedItem(tendv);
				//
				String ma2 = (String) tableModel.getValueAt(row, 4);
				String tenNCC = timthuoc_DAO.timNCCByma(ma2);
				cmbNhaCC.setSelectedItem(tenNCC);
				//
				String ma = (String) tableModel.getValueAt(row, 5);
				String tenNuoc = timthuoc_DAO.timNuocByMa(ma);
				cmbNuoc.setSelectedItem(tenNuoc);
				//
				cmbtinhTrang.setSelectedItem(tableModel.getValueAt(row, 7));
				txtTenThuoc.setText(tableModel.getValueAt(row, 1).toString());
				choseNgaynhap.setDate((Date) tableModel.getValueAt(row, 8));
				choseNgayhethan.setDate((Date) tableModel.getValueAt(row, 9));
			}
		});
	}

	private void loadCmb() {
		List<String> dsNuoc = timthuoc_DAO.getNuoc();
		dsNuoc.add(0, "");
		for(String s : dsNuoc) {
			cmbNuoc.addItem(s);
		}
		List<String> dsNCC = timthuoc_DAO.getNhaCC();
		dsNCC.add(0, "");
		for(String a : dsNCC) {
			cmbNhaCC.addItem(a);
		}
		List<String> dsDmuc = Arrays.asList("Theo đơn", "Không theo đơn");
		for(String s : dsDmuc) {
			cmbdanhMucthuoc.addItem(s);
		}
		List<String> dsTinhtrang = Arrays.asList("Hết", "Còn");
		for(String s : dsTinhtrang) {
			cmbtinhTrang.addItem(s);
		}
		List<String> dsDonvi = timthuoc_DAO.getAllTenDonvi();
		for(String s : dsDonvi) {
			cmbDonvithuoc.addItem(s);
		}
	}

	private void loadData() {
		// TODO Auto-generated method stub
		List<Thuoc> dsthuoc = timthuoc_DAO.getAllThuoc();
		for(Thuoc t : dsthuoc) {
			tableModel.addRow(new Object[] {
				t.getMaThuoc(),
				t.getTenThuoc(),
				t.getMaDonvi().getMaDonvi(),
				t.getDonGia(),
				t.getMaNhaCC().getMaNhaCC(),
				t.getMaNuoc().getMaLoai(),
				t.getDanhMucthuoc(),
				t.getTinhTrang(),
				t.getNgayNhap(),
				t.getNgayHethan()
			});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			ThemthuocJDialog themThuocUI = new ThemthuocJDialog();
			themThuocUI.setAlwaysOnTop(true);
			themThuocUI.setVisible(true);
		}else {
			if (o.equals(btnTim)) {
				String tenTh = txtTenThuoc.getText().trim();
				String tenNuoc = (String) cmbNuoc.getSelectedItem();
				String tenNCC = (String) cmbNhaCC.getSelectedItem();
				String gia = txtdonGia.getText().trim();
				if(tenTh.equalsIgnoreCase("") && tenNCC.equalsIgnoreCase("") && gia.equals("")) {
					String maNuoc = timthuoc_DAO.timNuocByten(tenNuoc);
					tableModel.setRowCount(0);
					timByNuoc(maNuoc);
				}else {
					if (tenNuoc.equalsIgnoreCase("") && tenTh.equalsIgnoreCase("") && gia.equals("")) {
						String maNCC = timthuoc_DAO.timNCCByten(tenNCC);
						tableModel.setRowCount(0);
						timByNCC(maNCC);
					}else {
						if (tenNuoc.equals("") && tenNCC.equals("") && gia.equals("")) {
							tableModel.setRowCount(0);
							timAction(tenTh);
						} else {
							if (tenTh.equals("") && tenNuoc.equals("") && tenNCC.equals("")) {
								tableModel.setRowCount(0);
								double dongia = Double.parseDouble(gia);
								timDongia(dongia);
							}else {
									JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin tìm kiếm");
							}
						}
					}
				}
			}else {
				if (o.equals(btnCapnhat)) {
					capnhatAction();
				}else if (o.equals(btnXoa)) {
					xoaAction();
				}else if (o.equals(btnRefresh)) {
					tableModel.getDataVector().removeAllElements();
					loadData();
				}else if (o.equals(btnXoarong)) {
					clearText();
				}
			}
		}
	}

	private void clearText() {
		// TODO Auto-generated method stub
		txtMathuoc.setText("");
		cmbdanhMucthuoc.setSelectedIndex(0);
		cmbDonvithuoc.setSelectedIndex(0);
		cmbNhaCC.setSelectedIndex(0);
		cmbNuoc.setSelectedIndex(0);
		cmbtinhTrang.setSelectedIndex(0);
		txtTenThuoc.setText("");
		txtdonGia.setText("");
		choseNgaynhap.setDate(new Date());
		choseNgayhethan.setDate(new Date());
	}

	private void timDongia(double dongia) {
		// TODO Auto-generated method stub
		List<Thuoc> dsTh = timthuoc_DAO.timThuocByDongia(dongia);
		for(Thuoc t : dsTh) {
			tableModel.addRow(new Object[] {
				t.getMaThuoc(),
				t.getTenThuoc(),
				t.getMaDonvi().getMaDonvi(),
				t.getDonGia(),
				t.getMaNhaCC().getMaNhaCC(),
				t.getMaNuoc().getMaLoai(),
				t.getDanhMucthuoc(),
				t.getTinhTrang(),
				t.getNgayNhap(),
				t.getNgayHethan()
			});
		}
	}

	private void xoaAction() {
		// TODO Auto-generated method stub
		String ma = txtMathuoc.getText().trim();
		if(ma.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn mã thuốc");
		}else {
			timthuoc_DAO.deleteThuoc(ma);
			JOptionPane.showMessageDialog(this, "Xóa thành công");
			tableModel.getDataVector().removeAllElements();
			loadData();
		}
	}

	private void capnhatAction() {
		// TODO Auto-generated method stub
		String ma = txtMathuoc.getText().trim();
		String ten = txtTenThuoc.getText().trim();
		String tinhtrang = cmbtinhTrang.getSelectedItem().toString();
		String dv = (String) cmbDonvithuoc.getSelectedItem();
		String maDV = timthuoc_DAO.timDVByten(dv);
		String NCC = (String) cmbNhaCC.getSelectedItem();
		String maNCC = timthuoc_DAO.timNCCByten(NCC);
		String nuoc = (String) cmbNuoc.getSelectedItem();
		String maNuoc = timthuoc_DAO.timNuocByten(nuoc);
		String danhmuc = (String) cmbdanhMucthuoc.getSelectedItem();
		Date dateNgaynhap = choseNgaynhap.getDate();
		Date dateNgayhethan = choseNgayhethan.getDate();
		String dongia = txtdonGia.getText().trim();
		if (valid(ten, dateNgaynhap, dongia, NCC, nuoc, dateNgayhethan)==true) {
			double gia = Double.parseDouble(dongia);
			if (gia < 500.0f) {
				JOptionPane.showMessageDialog(this, "Giá thuốc phải lớn hơn 500đ");
			}else {
				java.sql.Date sqlDateNgaynhap = new java.sql.Date(dateNgaynhap.getTime());
				java.sql.Date sqlDateNgayhethan = new java.sql.Date(dateNgayhethan.getTime());
				Thuoc t = new Thuoc(ma, ten, tinhtrang, gia, danhmuc, sqlDateNgaynhap, sqlDateNgayhethan, 
						new Donvithuoc(maDV), new Nuoc(maNuoc), new Nhacungcap(maNCC));
				if(timthuoc_DAO.updateThuoc(t) == true) {
					JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					tableModel.getDataVector().removeAllElements();
					loadData();
				}else {
					JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
				}
			}
		}
	}
	@SuppressWarnings("deprecation")
	private boolean valid(String ten, Date dateNgaynhap, String dongia, String NCC, String nuoc, Date dateNgayhethan) {
		if(!(ten.matches("[\\w' ]+") && ten.length()>0)) {
			JOptionPane.showMessageDialog(this, "Tên không được để trống phải là chữ");
			return false;
		}
		if(!(dongia.matches("[\\d]+.[\\d]+") && dongia.length()>0)) {
			JOptionPane.showMessageDialog(this, "Đơn giá phải là số");
			return false;
		}
		Calendar calendarNhap = new GregorianCalendar();
		Calendar calendarHet = new GregorianCalendar();
		calendarNhap.setTime(dateNgaynhap);
		calendarHet.setTime(dateNgayhethan);
		int yearNhap = calendarNhap.get(Calendar.YEAR);
		int monthNhap = calendarNhap.get(Calendar.MONTH);
		int yearHet = calendarHet.get(Calendar.YEAR);
		int monthHet = calendarHet.get(Calendar.MONTH);
		int year = yearHet-yearNhap;
		int month = monthHet-monthNhap;
		if(year<0) {
			JOptionPane.showMessageDialog(this, "Ngày hết hạn phải lớn hơn ngày nhập");
			return false;
		}else if (month<0) {
			JOptionPane.showMessageDialog(this, "Tháng thuốc hết phải lớn hơn hoặc bằng tháng nhập");
			return false;
		}
		if (!(nuoc.length()>0)) {
			JOptionPane.showMessageDialog(this, "Bạn phải chọn nước");
			return false;
		}
		if (!(NCC.length()>0)) {
			JOptionPane.showMessageDialog(this, "Bạn phải chọn nhà cung cấp");
			return false;
		}
		return true;
	}
	private void timByNCC(String maNCC) {
		// TODO Auto-generated method stub
		List<Thuoc> dsTh = timthuoc_DAO.timThuocByNCC(maNCC);
		for(Thuoc t : dsTh) {
			tableModel.addRow(new Object[] {
				t.getMaThuoc(),
				t.getTenThuoc(),
				t.getMaDonvi().getMaDonvi(),
				t.getDonGia(),
				t.getMaNhaCC().getMaNhaCC(),
				t.getMaNuoc().getMaLoai(),
				t.getDanhMucthuoc(),
				t.getTinhTrang(),
				t.getNgayNhap(),
				t.getNgayHethan()
			});
		}
	}

	private void timByNuoc(String maNuoc) {
		// TODO Auto-generated method stub
		List<Thuoc> dsTh = timthuoc_DAO.timThuocByNuoc(maNuoc);
		for(Thuoc t : dsTh) {
			tableModel.addRow(new Object[] {
				t.getMaThuoc(),
				t.getTenThuoc(),
				t.getMaDonvi().getMaDonvi(),
				t.getDonGia(),
				t.getMaNhaCC().getMaNhaCC(),
				t.getMaNuoc().getMaLoai(),
				t.getDanhMucthuoc(),
				t.getTinhTrang(),
				t.getNgayNhap(),
				t.getNgayHethan()
			});
		}
	}

	private void timAction(String tenThuoc) {
		List<Thuoc> dsTh = timthuoc_DAO.timThuocByten(tenThuoc);
		for(Thuoc t : dsTh) {
			tableModel.addRow(new Object[] {
				t.getMaThuoc(),
				t.getTenThuoc(),
				t.getMaDonvi().getMaDonvi(),
				t.getDonGia(),
				t.getMaNhaCC().getMaNhaCC(),
				t.getMaNuoc().getMaLoai(),
				t.getDanhMucthuoc(),
				t.getTinhTrang(),
				t.getNgayNhap(),
				t.getNgayHethan()
			});
		}
	}
}
