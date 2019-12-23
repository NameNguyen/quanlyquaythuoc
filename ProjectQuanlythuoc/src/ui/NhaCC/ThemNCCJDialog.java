package ui.NhaCC;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConnectDB;
import dao.Khachhang.Khachhang_DAO;
import dao.NhaCC.NhaCC_DAO;
import entities.Nhacungcap;

public class ThemNCCJDialog extends JFrame implements ActionListener{
	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinthuoc;
	private JLabel lblMaNCC;
	private JTextField txtMaNCC;
	private JLabel lblTenNCC;
	private JTextField txtTenNCC;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblSDT;
	private JTextField txtSDT;
	private JLabel lblDiachi;
	private JTextArea txaDiachi;
	private JButton btnLuu;
	private JButton btnDong;
	private NhaCC_DAO nhacungcap_DAO;

	public ThemNCCJDialog() {
		ConnectDB.getInstance().getConnection();
		nhacungcap_DAO = new NhaCC_DAO();
		setSize(600, 400);
		setTitle("Thêm mới");
		ImageIcon image = new ImageIcon(getClass().getResource("/image/icons8-clinic-64.png"));
		setIconImage(image.getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		getContentPane().setBackground(Color.white);
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("QUẢN LÝ NHÀ CC");
		lblTitle.setBounds(0, 0, 200, 25);

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
		
		srcThongtinthuoc = new JScrollPane();
		srcThongtinthuoc.setBorder(BorderFactory.createTitledBorder("Thông tin thuốc"));
		srcThongtinthuoc.setLayout(null);
		srcThongtinthuoc.setBackground(new Color(240, 240, 240));
		//
		lblMaNCC = new JLabel();
		lblMaNCC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMaNCC.setText("Mã NCC:");
		lblMaNCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNCC.setBounds(10, 20, 100, 30);
		txtMaNCC = new JTextField();
		txtMaNCC.setBounds(130, 24, 400, 23);
		txtMaNCC.setEditable(false);
		//
		lblTenNCC = new JLabel();
		lblTenNCC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTenNCC.setText("Tên NCC:");
		lblTenNCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNCC.setBounds(10, 55, 100, 30);
		txtTenNCC = new JTextField();
		txtTenNCC.setBounds(130, 59, 400, 23);
		//
		lblEmail = new JLabel();
		lblEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblEmail.setText("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(10, 90, 100, 30);
		txtEmail = new JTextField();
		txtEmail.setBounds(130, 94, 400, 23);
		//
		lblSDT = new JLabel();
		lblSDT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblSDT.setText("SĐT:");
		lblSDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSDT.setBounds(10, 125, 100, 30);
		txtSDT = new JTextField();
		txtSDT.setBounds(130, 129, 400, 23);
		//
		lblDiachi = new JLabel("Địa chỉ:");
		lblDiachi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblDiachi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiachi.setBounds(10, 160, 100, 30);
		txaDiachi = new JTextArea();
		txaDiachi.setBounds(130, 164, 250, 70);
		txaDiachi.setLineWrap(true);
		txaDiachi.setWrapStyleWord(true);
		//
		btnLuu = new JButton("Lưu", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-save-24.png")));
		btnLuu.setFocusPainted(false);
		btnLuu.setFont(new Font("Arial", 0, 14));
		btnLuu.setForeground(new Color(45, 179, 0));
		btnLuu.setBounds(70, 250, 130, 40);
		btnLuu.setBackground(Color.white);
		//
		btnDong = new JButton("Đóng", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delete-24.png")));
		btnDong.setFocusPainted(false);
		btnDong.setFont(new Font("Arial", 0, 14));
		btnDong.setForeground(new Color(45, 179, 0));
		btnDong.setBounds(370, 250, 130, 40);
		btnDong.setBackground(Color.white);
		//
		srcThongtinthuoc.setBounds(10, 50, 574, 300);
		srcThongtinthuoc.add(lblMaNCC);
		srcThongtinthuoc.add(txtMaNCC);
		srcThongtinthuoc.add(lblTenNCC);
		srcThongtinthuoc.add(txtTenNCC);
		srcThongtinthuoc.add(lblEmail);
		srcThongtinthuoc.add(txtEmail);
		srcThongtinthuoc.add(txtEmail);
		srcThongtinthuoc.add(lblSDT);
		srcThongtinthuoc.add(txtSDT);
		srcThongtinthuoc.add(lblDiachi);
		srcThongtinthuoc.add(txaDiachi);
		srcThongtinthuoc.add(btnLuu);
		srcThongtinthuoc.add(btnDong);
		//
		add(lblTitle);
		add(lblQuanly);
		add(lblChucnang);
		add(srcThongtinthuoc);
		//
		btnDong.addActionListener(this);
		btnLuu.addActionListener(this);
		if (checkMa(randomMa()) == true) {
			txtMaNCC.setText(randomMa());
		}
	}
	private String randomMa() {
		int max = 1000;
		int min = 0;
		Random rand = new Random();
		int n = rand.nextInt((max-min)+1) + min;
		String maduan = "NCC"+n;
		return maduan;
	}
	public static void main(String[] args) {
		new ThemNCCJDialog().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDong)) {
			dispose();
		}else {
			if (o.equals(btnLuu)) {
				luuAction();
			}
		}
	}
	private void luuAction() {
		// TODO Auto-generated method stub
		String ma = txtMaNCC.getText().trim();
		String ten = txtTenNCC.getText().trim();
		String sdt = txtSDT.getText().trim();
		String email = txtEmail.getText().trim();
		String diachi = txaDiachi.getText().trim();
		if (valid(ten, sdt, email, diachi)== true) {
			Nhacungcap ncc = new Nhacungcap(ma, ten, email, sdt, diachi);
			if(nhacungcap_DAO.taoNhacungcap(ncc)==true) {
				int hoinhac = JOptionPane.showConfirmDialog(this, "Bạn vừa tạo một nhà cung cấp. Bạn có muốn tạo thêm nhà cung cấp nữa không","Nhà cung cấp", JOptionPane.YES_NO_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					clearText();
				}
				else {
					dispose();
				}
			}
		}
	}
	private boolean valid(String ten, String sdt, String email, String diachi) {
		if (!(ten.matches("[A-Z][a-zA-Z' ]+") && ten.length()>0)) {
			JOptionPane.showMessageDialog(this, "Tên bắt đầu bằng chữ hoa không có chữ số");
			return false;
		}
		if (!(sdt.matches("\\d{10}") && sdt.length()>0)) {
			JOptionPane.showMessageDialog(this, "Số điện thoại gồm 10 số");
			return false;
		}
		if (!(email.matches("[\\w]+@[a-z]+\\.[a-z]+"))) {
			JOptionPane.showMessageDialog(this, "Định dạng email sai");
			return false;
		}
		if (!(diachi.length()>0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ");
			return false;
		}
		return true;
	}
	private void clearText() {
		// TODO Auto-generated method stub
		if (checkMa(randomMa()) == true) {
			txtMaNCC.setText(randomMa());
		}
		txtTenNCC.setText("");
		txtSDT.setText("");
		txtEmail.setText("");
		txaDiachi.setText("");
	}
	private boolean checkMa(String ma) {
		List<String> dsma = nhacungcap_DAO.checktrungma();
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
