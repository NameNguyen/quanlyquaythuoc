package ui.Dangnhap;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConnectDB;
import dao.Taikhoan.Taikhoan_DAO;
import entities.Nguoidung;
import entities.Taikhoan;
import ui.Nguoidung.ThemNguoidungJDialog;
import ui.menuAll.Menu;
import ui.menuAll.MenuNhanvien;
import ui.menuAll.MenuQuanly;

public class Dangnhap_UI extends JFrame implements ActionListener{
	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinND;
	private JSeparator spre;
	private JLabel lblImage;
	private JButton btnThoat;
	private JButton btnDangnhap;
	private JLabel lblDangky;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPass;
	private JPasswordField txpPass;
	private Taikhoan_DAO taikhoan_DAO;

	public Dangnhap_UI() {
		ConnectDB.getInstance().getConnection();
		setBackground(Color.white);
		taikhoan_DAO = new Taikhoan_DAO();
		setLayout(null);
		setSize(600, 300);
		setTitle("Đăng nhập");
		ImageIcon image = new ImageIcon(getClass().getResource("/image/icons8-clinic-64.png"));
		setIconImage(image.getImage());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("ĐĂNG NHẬP");
		lblTitle.setBounds(0, 0, 250, 25);

		lblQuanly = new JLabel();
		lblQuanly.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblQuanly.setForeground(new java.awt.Color(0, 204, 153));
		lblQuanly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
		lblQuanly.setText("QUẢN LÝ QUẦY THUỐC");
		lblQuanly.setBounds(330, 0, 280, 50);
		lblQuanly.setBackground(Color.white);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", Font.BOLD, 11)); // NOI18N
		lblChucnang.setText(">>Đăng nhập để sử dụng chức năng của chương trình");
		lblChucnang.setBounds(5, 25, 310, 20);
		
		spre = new JSeparator();
		spre.setBounds(0, 60, 600, 10);
		//
		lblImage = new JLabel(new ImageIcon(getClass().getResource("/image/locked.png")));
		lblImage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImage.setBounds(30, 85, 120, 130);
		//
		lblUser = new JLabel("UserName:");
		lblUser.setFont(new Font("Arial", Font.BOLD, 14));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(200, 100, 100, 30);
		txtUser = new JTextField();
		txtUser.setBounds(330, 104, 200, 23);
		//
		lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Arial", Font.BOLD, 14));
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setBounds(200, 155, 100, 30);
		txpPass = new JPasswordField();
		txpPass.setBounds(330, 159, 200, 23);
		//
		lblDangky = new JLabel("Bạn chưa có tài khoản");
		lblDangky.setFont(new Font("Arial", Font.ITALIC, 12));
		lblDangky.setBounds(250, 190, 400, 20);
		lblDangky.setForeground(new Color(0, 102, 255));
		//
		btnDangnhap = new JButton("Đăng nhập", new ImageIcon(getClass().getResource("/image/icons8-login-24.png")));
		btnDangnhap.setFocusPainted(false);
		btnDangnhap.setBackground(Color.white);
		btnDangnhap.setFont(new Font("Arial", 0, 13));
		btnDangnhap.setForeground(new Color(45, 179, 0));
		btnDangnhap.setBounds(200, 220, 130, 40);
		btnDangnhap.setBackground(Color.white);
//		btnDangnhap.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDangnhap.setMnemonic(KeyEvent.VK_ENTER);
		//
		btnThoat = new JButton("Thoát", new ImageIcon(getClass().getResource("/image/icons8-exit-24.png")));
		btnThoat.setFocusPainted(false);
		btnThoat.setBackground(Color.white);
		btnThoat.setFont(new Font("Arial", 0, 13));
		btnThoat.setForeground(new Color(45, 179, 0));
		btnThoat.setBounds(370, 220, 130, 40);
		btnThoat.setBackground(Color.white);
		//
		add(lblChucnang);
		add(lblQuanly);
		add(lblTitle);
		add(spre);
		add(lblImage);
		add(lblUser);
		add(txtUser);
		add(lblPass);
		add(txpPass);
		add(lblDangky);
		add(btnDangnhap);
		add(btnThoat);
		btnDangnhap.addActionListener(this);
		btnThoat.addActionListener(this);
		lblDangky.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				ThemNguoidungJDialog themND_UI = new ThemNguoidungJDialog();
				themND_UI.setAlwaysOnTop(true);
				themND_UI.setVisible(true);
			}
		});
	}
	public static void main(String[] args) {
		new Dangnhap_UI().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnDangnhap)) {
			if (dangnhapAction()==true) {
				phanquyen();
				dispose();
			}
		}else if (o.equals(btnThoat)) {
			dispose();
		}
	}
	private boolean dangnhapAction() {
		// TODO Auto-generated method stub
		String ma = txtUser.getText().trim();
		String pass = txpPass.getText().trim();
		if(valid(ma, pass) == true && kiemtradangnhap(ma) == true) {
			taikhoan_DAO.deleteThongtindangnhap();
			taikhoan_DAO.taoThongtindangnhap(ma);
			return true;
		}
		return false;
	}
	private void phanquyen() {
		// TODO Auto-generated method stub
		String ma = txtUser.getText().trim();
		Nguoidung nd = taikhoan_DAO.getThongTindangnhap1();
		String chucvu = nd.getChucVu();
//		"Admin", "Quản lý", "Nhân viên"
		if(chucvu.equalsIgnoreCase("Admin")) {
			new Menu(ma).setVisible(true);
		}else if (chucvu.equalsIgnoreCase("Quản lý")) {
			new MenuQuanly().setVisible(true);
		}else if (chucvu.equalsIgnoreCase("Nhân viên")) {
			new MenuNhanvien().setVisible(true);
		}
	}
	private boolean kiemtradangnhap(String ma) {
		Taikhoan tk = taikhoan_DAO.timTaikhoanbyMa(ma);
		List<Taikhoan> dstk = taikhoan_DAO.getAllNguoidung();
		for(Taikhoan taikhoan : dstk) {
			if(taikhoan.equals(tk)) 
				return true;
		}
		return false;
	}
	private boolean valid(String ma, String pass) {
		if(!(ma.matches("NV[0-9]+")&& ma.length()>0)) {
			lblDangky.setText("Tên tài khoản phải bắt đầu bằng 2 chứ NV+ số thứ tự");
			return false;
		}
		if (!(pass.matches("[a-zA-z0-9]{8,100}") && pass.length()>0)) {
			lblDangky.setText("Mật khẩu không chứa 8 kí tự không chứa kí tự đặc biệt");
			return false;
		}
		return true;
	}
}
