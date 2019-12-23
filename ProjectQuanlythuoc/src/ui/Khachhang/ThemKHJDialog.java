package ui.Khachhang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConnectDB;
import dao.Khachhang.Khachhang_DAO;
import entities.Khachhang;

public class ThemKHJDialog extends JDialog implements ActionListener{

	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinKH;
	private JLabel lblMaKH;
	private JTextField txtMaKH;
	private JLabel lblTenKH;
	private JTextField txtTenKH;
	private JLabel lblSDT;
	private JTextField txtSDT;
	private JLabel lblDiachi;
	private JTextArea txaDiachi;
	private JButton btnLuu;
	private JButton btnDong;
	private Khachhang_DAO khachhang_DAO;

	public ThemKHJDialog() {
		ConnectDB.getInstance().getConnection();
		khachhang_DAO = new Khachhang_DAO();
		setBackground(Color.white);
		setLayout(null);
		setSize(600, 400);
		setTitle("Thêm mới");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(Color.white);
		ImageIcon image = new ImageIcon(getClass().getResource("/image/icons8-clinic-64.png"));
		setIconImage(image.getImage());
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("QUẢN LÝ KHÁCH HÀNG");
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
		
		srcThongtinKH = new JScrollPane();
		srcThongtinKH.setBorder(BorderFactory.createTitledBorder("Thông tin thuốc"));
		srcThongtinKH.setLayout(null);
		//
		lblMaKH = new JLabel();
		lblMaKH.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMaKH.setText("Mã KH:");
		lblMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKH.setBounds(10, 20, 100, 30);
		txtMaKH = new JTextField();
		txtMaKH.setBounds(130, 24, 400, 23);
		txtMaKH.setEditable(false);
		//
		lblTenKH = new JLabel();
		lblTenKH.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTenKH.setText("Tên KH:");
		lblTenKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKH.setBounds(10, 55, 100, 30);
		txtTenKH = new JTextField();
		txtTenKH.setBounds(130, 59, 400, 23);
		//
		lblSDT = new JLabel();
		lblSDT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblSDT.setText("SĐT:");
		lblSDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSDT.setBounds(10, 90, 100, 30);
		txtSDT = new JTextField();
		txtSDT.setBounds(130, 94, 400, 23);
		//
		lblDiachi = new JLabel("Địa chỉ:");
		lblDiachi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblDiachi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiachi.setBounds(10, 125, 100, 30);
		txaDiachi = new JTextArea();
		txaDiachi.setBounds(130, 129, 250, 70);
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
		srcThongtinKH.setBounds(10, 50, 574, 300);
		srcThongtinKH.add(lblMaKH);
		srcThongtinKH.add(txtMaKH);
		srcThongtinKH.add(lblTenKH);
		srcThongtinKH.add(txtTenKH);
		srcThongtinKH.add(lblSDT);
		srcThongtinKH.add(txtSDT);
		srcThongtinKH.add(lblDiachi);
		srcThongtinKH.add(txaDiachi);
		srcThongtinKH.add(btnDong);
		srcThongtinKH.add(btnLuu);
		//
		add(lblTitle);
		add(lblQuanly);
		add(lblChucnang);
		add(srcThongtinKH);
		//
		btnDong.addActionListener(this);
		btnLuu.addActionListener(this);
		if (checkMa(randomMa()) == true) {
			txtMaKH.setText(randomMa());
		}
	}
	private String randomMa() {
		int max = 1000;
		int min = 0;
		Random rand = new Random();
		int n = rand.nextInt((max-min)+1) + min;
		String maduan = "KH"+n;
		return maduan;
	}
	public static void main(String[] args) {
		new ThemKHJDialog().setVisible(true);
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
		String ma = txtMaKH.getText().trim();
		String ten = txtTenKH.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diachi = txaDiachi.getText().trim();
		System.out.println(diachi);
		if(valid(ten, sdt, diachi)== true) {
			Khachhang kh = new Khachhang(ma, ten, sdt, diachi);
			if(khachhang_DAO.taoKhachhang(kh) == true) {
				int hoinhac = JOptionPane.showConfirmDialog(this, "Bạn vừa tạo một khách hàng. Bạn có muốn tạo thêm khách hàng nữa không","Thuốc", JOptionPane.YES_NO_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					clearText();
				}
				else {
					dispose();
				}
			}
		}
	}
	private boolean valid(String ten, String sdt, String diachi) {
		if (!(ten.matches("[A-Z][a-zA-Z' ]+") && ten.length()>0)) {
			JOptionPane.showMessageDialog(this, "Tên bắt đầu bằng chữ hoa không có chữ số");
			return false;
		}
		if (!(sdt.matches("0\\d{9}") && sdt.length()>0)) {
			JOptionPane.showMessageDialog(this, "Số điện thoại gồm 10 số bắt đầu bằng số 0");
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
		txtTenKH.setText("");
		if (checkMa(randomMa()) == true) {
			txtMaKH.setText(randomMa());
		}
		txtSDT.setText("");
		txaDiachi.setText("");
	}
	private boolean checkMa(String ma) {
		List<String> dsma = khachhang_DAO.checktrungma();
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
