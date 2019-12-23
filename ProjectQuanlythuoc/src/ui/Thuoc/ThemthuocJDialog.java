package ui.Thuoc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import dao.ConnectDB;
import dao.Thuoc.ThemThuoc_DAO;
import dao.Thuoc.TimThuoc_DAO;
import entities.Donvithuoc;
import entities.Nhacungcap;
import entities.Nuoc;
import entities.Thuoc;
import ui.Donvi.ThemDonViJFrame;
import ui.Donvi.XemDVJFrame;
import ui.NhaCC.ThemNCCJDialog;
import ui.Nuoc.ThemnuocJDialog;
import ui.Nuoc.XemNuocJFrame;

public class ThemthuocJDialog extends JDialog implements ActionListener{
	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinthuoc;
	private JLabel lblMathuoc;
	private JTextField txtMathuoc;
	private JLabel lblTenthuoc;
	private JTextField txtTenthuoc;
	private JLabel lbltinhTrang;
	private JComboBox<String> cmbtinhTrang;
	private JLabel lbldonGia;
	private JTextField txtdonGia;
	private JLabel lblDonvithuoc;
	private JComboBox<String> cmbDonvithuoc;
	private JLabel lbldanhMucthuoc;
	private JComboBox<String> cmbdanhMucthuoc;
	private JLabel lblNuoc;
	private JComboBox<String> cmbNuoc;
	private JLabel lblNhaCC;
	private JComboBox<String> cmbNhaCC;
	private JButton btnLuu;
	private JButton btnDong;
	private JButton btnThemNCC;
	private JButton btnThemnuoc;
	private JLabel lblNgayhethan;
	private JDateChooser choseNgayhethan;
	private TimThuoc_DAO timthuoc_DAO;
	private ThemThuoc_DAO themthuoc_DAO;
	private JButton btnThemDV;
	private JButton btnXemnuoc;
	private JButton btnXemNCC;
	private JButton btnXemDV;

	public ThemthuocJDialog() {
		ConnectDB.getInstance().getConnection();
		timthuoc_DAO = new TimThuoc_DAO();
		themthuoc_DAO = new ThemThuoc_DAO();
		setSize(650, 500);
		setTitle("Thêm mới");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		ImageIcon image = new ImageIcon(getClass().getResource("/image/icons8-clinic-64.png"));
		setIconImage(image.getImage());
		getContentPane().setBackground(Color.white);
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
		lblQuanly.setBounds(375, 0, 280, 50);
		lblQuanly.setBackground(Color.white);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lblChucnang.setText(">>Thêm mới");
		lblChucnang.setBounds(10, 25, 200, 20);
		
		srcThongtinthuoc = new JScrollPane();
		srcThongtinthuoc.setBorder(BorderFactory.createTitledBorder("Thông tin thuốc"));
		srcThongtinthuoc.setLayout(null);
		//
		lblMathuoc = new JLabel();
		lblMathuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMathuoc.setText("Mã thuốc:");
		lblMathuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMathuoc.setBounds(10, 20, 100, 30);
		txtMathuoc = new JTextField();
		txtMathuoc.setBounds(130, 24, 400, 23);
		txtMathuoc.setEditable(false);
		//
		lblTenthuoc = new JLabel();
		lblTenthuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTenthuoc.setText("Tên thuốc:");
		lblTenthuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenthuoc.setBounds(10, 55, 100, 30);
		txtTenthuoc = new JTextField();
		txtTenthuoc.setBounds(130, 59, 400, 23);
		//
		lbltinhTrang = new JLabel();
		lbltinhTrang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbltinhTrang.setText("Tình trạng:");
		lbltinhTrang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltinhTrang.setBounds(10, 90, 100, 30);
		cmbtinhTrang = new JComboBox<String>();
		cmbtinhTrang.setBounds(130, 94, 400, 23);
		//
		lbldonGia = new JLabel();
		lbldonGia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbldonGia.setText("Đơn giá:");
		lbldonGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldonGia.setBounds(10, 125, 100, 30);
		txtdonGia = new JTextField();
		txtdonGia.setBounds(130, 129, 400, 23);
		//
		lblDonvithuoc = new JLabel("Đơn vị:");
		lblDonvithuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblDonvithuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDonvithuoc.setBounds(10, 160, 100, 30);
		cmbDonvithuoc = new JComboBox<String>();
		cmbDonvithuoc.setBounds(130, 164, 400, 23);
		//
		btnThemDV = new JButton(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-add-24.png")));
		btnThemDV.setBounds(535, 163, 25, 25);
		btnThemDV.setFocusPainted(false);
		btnThemDV.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnThemDV.setBackground(new Color(240, 240, 240));
		btnXemDV = new JButton(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-property-24.png")));
		btnXemDV.setBounds(565, 163, 25, 25);
		btnXemDV.setFocusPainted(false);
		btnXemDV.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnXemDV.setBackground(new Color(240, 240, 240));
		//
		lbldanhMucthuoc = new JLabel();
		lbldanhMucthuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbldanhMucthuoc.setText("Danh mục:");
		lbldanhMucthuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldanhMucthuoc.setBounds(10, 195, 100, 30);
		cmbdanhMucthuoc = new JComboBox<String>();
		cmbdanhMucthuoc.setBounds(130, 199, 400, 23);
		//
		lblNuoc = new JLabel("Nước:");
		lblNuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblNuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNuoc.setBounds(10, 230, 100, 30);
		cmbNuoc = new JComboBox<String>();
		cmbNuoc.setBounds(130, 234, 400, 23);
		//
		btnThemnuoc = new JButton(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-add-24.png")));
		btnThemnuoc.setBounds(535, 233, 25, 25);
		btnThemnuoc.setFocusPainted(false);
		btnThemnuoc.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnThemnuoc.setBackground(new Color(240, 240, 240));
		//
		btnXemnuoc = new JButton(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-property-24.png")));
		btnXemnuoc.setBounds(565, 233, 25, 25);
		btnXemnuoc.setFocusPainted(false);
		btnXemnuoc.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnXemnuoc.setBackground(new Color(240, 240, 240));
		//
		lblNhaCC = new JLabel("Nhà cung cấp:");
		lblNhaCC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblNhaCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNhaCC.setBounds(10, 265, 100, 30);
		cmbNhaCC = new JComboBox<String>();
		cmbNhaCC.setBounds(130, 269, 400, 23);
		//
		btnThemNCC = new JButton(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-add-24.png")));
		btnThemNCC.setBounds(535, 268, 25, 25);
		btnThemNCC.setFocusPainted(false);
		btnThemNCC.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnThemNCC.setBackground(new Color(240, 240, 240));
		//
		btnXemNCC = new JButton(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-property-24.png")));
		btnXemNCC.setBounds(565, 268, 25, 25);
		btnXemNCC.setFocusPainted(false);
		btnXemNCC.setBorder(new LineBorder(new Color(240, 240, 240)));
		btnXemNCC.setBackground(new Color(240, 240, 240));
		//
		lblNgayhethan = new JLabel("Ngày hết hạn:");
		lblNgayhethan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblNgayhethan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgayhethan.setBounds(10, 300, 100, 30);
		choseNgayhethan = new JDateChooser();
		choseNgayhethan.setDateFormatString("dd-MM-yyyy");
		choseNgayhethan.setBounds(130, 304, 400, 23);
		//
		btnLuu = new JButton("Lưu", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-save-24.png")));
		btnLuu.setFocusPainted(false);
		btnLuu.setFont(new Font("Arial", 0, 14));
		btnLuu.setForeground(new Color(45, 179, 0));
		btnLuu.setBounds(70, 350, 130, 40);
		btnLuu.setBackground(Color.white);
		//
		btnDong = new JButton("Đóng", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delete-24.png")));
		btnDong.setFocusPainted(false);
		btnDong.setFont(new Font("Arial", 0, 14));
		btnDong.setForeground(new Color(45, 179, 0));
		btnDong.setBounds(370, 350, 130, 40);
		btnDong.setBackground(Color.white);
		
		srcThongtinthuoc.setBounds(23, 50, 600, 400);
		srcThongtinthuoc.add(lblMathuoc);
		srcThongtinthuoc.add(txtMathuoc);
		srcThongtinthuoc.add(lblTenthuoc);
		srcThongtinthuoc.add(txtTenthuoc);
		srcThongtinthuoc.add(lbltinhTrang);
		srcThongtinthuoc.add(cmbtinhTrang);
		srcThongtinthuoc.add(lbldonGia);
		srcThongtinthuoc.add(txtdonGia);
		srcThongtinthuoc.add(lblDonvithuoc);
		srcThongtinthuoc.add(cmbDonvithuoc);
		srcThongtinthuoc.add(lbldanhMucthuoc);
		srcThongtinthuoc.add(cmbdanhMucthuoc);
		srcThongtinthuoc.add(lblNuoc);
		srcThongtinthuoc.add(cmbNuoc);
		srcThongtinthuoc.add(lblNhaCC);
		srcThongtinthuoc.add(cmbNhaCC);
		srcThongtinthuoc.add(lblNgayhethan);
		srcThongtinthuoc.add(choseNgayhethan);
		srcThongtinthuoc.add(btnLuu);
		srcThongtinthuoc.add(btnDong);
		srcThongtinthuoc.add(btnThemNCC);
		srcThongtinthuoc.add(btnThemnuoc);
		srcThongtinthuoc.add(btnThemDV);
		srcThongtinthuoc.add(btnXemnuoc);
		srcThongtinthuoc.add(btnXemDV);
//		srcThongtinthuoc.add(btnXemNCC);
		
		//
		add(lblTitle);
		add(lblQuanly);
		add(lblChucnang);
		add(srcThongtinthuoc);
		//
		btnLuu.addActionListener(this);
		btnDong.addActionListener(this);
		btnThemNCC.addActionListener(this);
		btnThemnuoc.addActionListener(this);
		btnThemDV.addActionListener(this);
		btnXemDV.addActionListener(this);
		btnXemNCC.addActionListener(this);
		btnXemnuoc.addActionListener(this);
		loadCmb();
	}
	private void loadCmb() {
		if (checkMa(randomMa()) == true ) {
			txtMathuoc.setText(randomMa());
		}
		List<String> dsNuoc = timthuoc_DAO.getNuoc();
		for(String s : dsNuoc) {
			cmbNuoc.addItem(s);
		}
		List<String> dsNCC = timthuoc_DAO.getNhaCC();
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
	private String randomMa() {
		int max = 1000;
		int min = 0;
		Random rand = new Random();
		int n = rand.nextInt((max-min)+1) + min;
		String maduan = "T"+n;
		return maduan;
	}
	public static void main(String[] args) {
		new ThemthuocJDialog().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThemNCC)) {
			ThemNCCJDialog themNCC_UI = new ThemNCCJDialog();
			themNCC_UI.setAlwaysOnTop(true);
			themNCC_UI.setVisible(true);
		} else {
			if (o.equals(btnThemnuoc)) {
				ThemnuocJDialog themNuoc_UI = new ThemnuocJDialog();
				themNuoc_UI.setAlwaysOnTop(true);
				themNuoc_UI.setVisible(true);
			} else {
				if (o.equals(btnDong)) {
					dispose();
				} else {
					if (o.equals(btnLuu)) {
						luuAction();
					} else {
						if (o.equals(btnThemDV)) {
							ThemDonViJFrame themDV_UI = new ThemDonViJFrame();
							themDV_UI.setAlwaysOnTop(true);
							themDV_UI.setVisible(true);
						} else {
							if (o.equals(btnXemDV)) {
								XemDVJFrame xemDV_UI = new XemDVJFrame();
								xemDV_UI.setAlwaysOnTop(true);
								xemDV_UI.setVisible(true);
							} else {
								if (o.equals(btnXemNCC)) {
									
								} else {
									if (o.equals(btnXemnuoc)) {
										XemNuocJFrame xemNuoc_UI = new XemNuocJFrame();
										xemNuoc_UI.setAlwaysOnTop(true);
										xemNuoc_UI.setVisible(true);
									}
								}
							}
						}
					}
				}
			}
		}
		
	}
	private void luuAction() {
		String ma = txtMathuoc.getText().trim();
		String ten = txtTenthuoc.getText().trim();
		String tinhtrang = "Còn";
		String dv = (String) cmbDonvithuoc.getSelectedItem();
		String maDV = timthuoc_DAO.timDVByten(dv);
		String NCC = (String) cmbNhaCC.getSelectedItem();
		String maNCC = timthuoc_DAO.timNCCByten(NCC);
		String nuoc = (String) cmbNuoc.getSelectedItem();
		String maNuoc = timthuoc_DAO.timNuocByten(nuoc);
		String danhmuc = (String) cmbdanhMucthuoc.getSelectedItem();
		String dongia = txtdonGia.getText().trim();
		Date dateNgaynhap = new Date();
		Date dateHethan = choseNgayhethan.getDate();
		if (valid(ten, dateHethan, dongia, dateNgaynhap)==true) {
			double gia = Double.parseDouble(dongia);
			if (gia < 500.0f) {
				JOptionPane.showMessageDialog(this, "Giá thuốc phải lớn hơn 500đ");
			}else {
				java.sql.Date sqlDatehethan = new java.sql.Date(dateHethan.getTime());
				java.sql.Date sqlDatenhap = new java.sql.Date(dateNgaynhap.getTime());
				Thuoc t = new Thuoc(ma, ten, tinhtrang, gia, danhmuc, sqlDatenhap, sqlDatehethan, 
						new Donvithuoc(maDV), new Nuoc(maNuoc), new Nhacungcap(maNCC));
				if(themthuoc_DAO.taoThuoc(t) == true) {
					int hoinhac = JOptionPane.showConfirmDialog(this, "Bạn vừa tạo một thuốc. Bạn có muốn tạo thêm thuốc nữa không","Thuốc", JOptionPane.YES_NO_OPTION);
					if(hoinhac == JOptionPane.YES_OPTION) {
						clearText();
					}
					else {
						dispose();
					}
				}
			}
		}
		
	}
	@SuppressWarnings("deprecation")
	private boolean valid(String ten, Date dateHethan, String dongia, Date dateNgaynhap) {
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
		calendarHet.setTime(dateHethan);
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
		return true;
	}
	private void clearText() {
		// TODO Auto-generated method stub
		if (checkMa(randomMa()) == true ) {
			txtMathuoc.setText(randomMa());
		}
		txtTenthuoc.setText("");
		txtdonGia.setText("");
	}
	private boolean checkMa(String ma) {
		List<String> dsma = themthuoc_DAO.checktrungma();
		boolean flag = true;
		while (flag) {
			ma = randomMa();
			for(String s : dsma){
				if (s.equalsIgnoreCase(ma)) {
					return false;
				}
				else {
					return true;
				}
			}
		}
		return false;
	}

}
