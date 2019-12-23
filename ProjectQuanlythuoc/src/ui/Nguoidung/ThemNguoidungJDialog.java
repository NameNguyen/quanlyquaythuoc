package ui.Nguoidung;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConnectDB;
import dao.Nguoidung.Nguoidung_DAO;
import dao.Taikhoan.Taikhoan_DAO;
import entities.Nguoidung;
import entities.Taikhoan;

public class ThemNguoidungJDialog extends JFrame implements ActionListener{

	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinND;
	private JLabel lblMaND;
	private JTextField txtMaND;
	private JLabel lblHoten;
	private JTextField txtHoten;
	private JLabel lblGioitinh;
	private JRadioButton radGioitinhNam;
	private JRadioButton radGioitinhNu;
	private JLabel lblDiachi;
	private JTextArea txaDiachi;
	private JLabel lblChucvu;
	private JComboBox<String> cmbChucvu;
	private JButton btnLuu;
	private JButton btnDong;
	private Nguoidung_DAO nguoidung_DAO;
	private JLabel lblPass;
	private JTextField txtPass;
	private ButtonGroup groupButt;
	private Taikhoan_DAO taikhoan_DAO;

	public ThemNguoidungJDialog() {
		ConnectDB.getInstance().getConnection();
		nguoidung_DAO = new Nguoidung_DAO();
		taikhoan_DAO = new Taikhoan_DAO();
		setBackground(Color.white);
		ImageIcon image = new ImageIcon(getClass().getResource("/image/icons8-clinic-64.png"));
		setIconImage(image.getImage());
		setLayout(null);
		setSize(600, 500);
		setTitle("Thêm mới");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(Color.white);
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("QUẢN LÝ NGƯỜI DÙNG");
		lblTitle.setBounds(0, 0, 250, 25);

		lblQuanly = new JLabel();
		lblQuanly.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblQuanly.setForeground(new java.awt.Color(0, 204, 153));
		lblQuanly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
		lblQuanly.setText("QUẢN LÝ QUẦY THUỐC");
		lblQuanly.setBounds(330, 0, 280, 50);
		lblQuanly.setBackground(Color.white);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lblChucnang.setText(">>Thêm mới");
		lblChucnang.setBounds(10, 25, 200, 20);
		
		srcThongtinND = new JScrollPane();
		srcThongtinND.setBorder(BorderFactory.createTitledBorder("Thông tin người dùng"));
		srcThongtinND.setLayout(null);
		//
		lblMaND = new JLabel();
		lblMaND.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMaND.setText("Mã ND:");
		lblMaND.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaND.setBounds(10, 20, 100, 30);
		txtMaND = new JTextField();
		txtMaND.setBounds(130, 24, 400, 23);
		txtMaND.setEditable(false);
		//
		lblHoten = new JLabel();
		lblHoten.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblHoten.setText("Họ tên:");
		lblHoten.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoten.setBounds(10, 55, 100, 30);
		txtHoten = new JTextField();
		txtHoten.setBounds(130, 59, 400, 23);
		//
		lblGioitinh = new JLabel();
		lblGioitinh.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblGioitinh.setText("Giới tính:");
		lblGioitinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGioitinh.setBounds(10, 90, 100, 30);
		radGioitinhNam = new JRadioButton("Nam");
		radGioitinhNu = new JRadioButton("Nữ");
		radGioitinhNam.setBounds(130, 94, 70, 23);
		radGioitinhNu.setBounds(200, 94, 100, 23);
		groupButt = new ButtonGroup();
		groupButt.add(radGioitinhNam);
		groupButt.add(radGioitinhNu);
		//
		lblDiachi = new JLabel("Địa chỉ:");
		lblDiachi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblDiachi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiachi.setBounds(10, 160, 100, 30);
		txaDiachi = new JTextArea();
		txaDiachi.setBounds(130, 170, 250, 70);
		txaDiachi.setLineWrap(true);
		txaDiachi.setWrapStyleWord(true);
		//
		lblPass = new JLabel();
		lblPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblPass.setText("Mật khẩu:");
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setBounds(10, 255, 100, 30);
		txtPass = new JTextField();
		txtPass.setBounds(130, 259, 400, 23);
		//
		lblChucvu = new JLabel();
		lblChucvu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblChucvu.setText("Chức vụ:");
		lblChucvu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChucvu.setBounds(10, 125, 100, 30);
		cmbChucvu = new JComboBox<String>();
		cmbChucvu.setBounds(130, 129, 400, 23);
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
		//
		srcThongtinND.setBounds(10, 50, 574, 400);
		srcThongtinND.add(lblMaND);
		srcThongtinND.add(txtMaND);
		srcThongtinND.add(lblHoten);
		srcThongtinND.add(txtHoten);
		srcThongtinND.add(lblGioitinh);
		srcThongtinND.add(radGioitinhNam);
		srcThongtinND.add(radGioitinhNu);
		srcThongtinND.add(lblDiachi);
		srcThongtinND.add(txaDiachi);
		srcThongtinND.add(lblChucvu);
		srcThongtinND.add(cmbChucvu);
		srcThongtinND.add(lblPass);
		srcThongtinND.add(txtPass);
		srcThongtinND.add(btnLuu);
		srcThongtinND.add(btnDong);
		//
		add(lblChucnang);
		add(lblQuanly);
		add(lblTitle);
		add(srcThongtinND);
		//
		btnDong.addActionListener(this);
		btnLuu.addActionListener(this);
		loadCmb();
		if (checkMa(randomMa()) == true) {
			txtMaND.setText(randomMa());
		}
	}
	private void loadCmb() {
		// TODO Auto-generated method stub
		List<String> dsChucvu = Arrays.asList("Admin", "Quản lý", "Nhân viên");
		for(String s: dsChucvu) {
			cmbChucvu.addItem(s);
		}
	}
	private String randomMa() {
		int max = 1000;
		int min = 0;
		Random rand = new Random();
		int n = rand.nextInt((max-min)+1) + min;
		String maduan = "NV"+n;
		return maduan;
	}
	public static void main(String[] args) {
		new ThemNguoidungJDialog().setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDong)) {
			dispose();
		}else {
			if(o.equals(btnLuu)) {
				luuAction();
			}
		}
	}
	private void luuAction() {
		// TODO Auto-generated method stub
		String ma = txtMaND.getText().trim();
		String ten = txtHoten.getText().trim();
		boolean gt = radGioitinhNam.isSelected(); 
		boolean gt1 = radGioitinhNu.isSelected(); 
		String gioiTinh = null;
		if (gt == true) {
			gioiTinh = "Nam";
		} else {
			if (gt1 == true) {
				gioiTinh = "Nữ";
			}
		}
		String chucVu = (String) cmbChucvu.getSelectedItem();
		String diaChi = txaDiachi.getText().trim();
		String pass = txtPass.getText().trim();
		if (valid(ten, pass, diaChi) == true) {
			Taikhoan tk = new Taikhoan(ma, pass);
			Nguoidung nd = new Nguoidung(tk, ten, gioiTinh, diaChi, chucVu);
			if (taikhoan_DAO.taoTaikhoan(tk) == true && nguoidung_DAO.taoNguoidung(nd) == true) {
				int hoinhac = JOptionPane.showConfirmDialog(this, "Bạn vừa tạo một người dùng. Bạn có muốn tạo thêm người dùng nữa không","Thuốc", JOptionPane.YES_NO_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					clearText();
				}
				else {
					dispose();
				}
			}
		}
	}
	private boolean valid(String ten, String pass, String diaChi) {
		if (!(ten.matches("[A-Z][a-zA-Z' ]+") && ten.length()>0)) {
			JOptionPane.showMessageDialog(this, "Tên bắt đầu bằng chữ hoa không có chữ số");
			return false;
		}
		if (!(pass.matches("[a-zA-z0-9]{8,100}") && pass.length()>0)) {
			JOptionPane.showMessageDialog(this, "Mật khẩu gồm 8 số không chứa kí tự đặc biệt");
			return false;
		}
		if (!(diaChi.length()>0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ");
			return false;
		}
		return true;
	}
	private void clearText() {
		// TODO Auto-generated method stub
		if (checkMa(randomMa()) == true) {
			txtMaND.setText(randomMa());
		}
		txtHoten.setText("");
		txtPass.setText("");
		txaDiachi.setText("");
	}
	private boolean checkMa(String ma) {
		List<String> dsma = taikhoan_DAO.checktrungma();
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
