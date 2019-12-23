package ui.Donvi;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConnectDB;
import dao.Donvi.Donvi_DAO;
import dao.Thuoc.ThemThuoc_DAO;
import entities.Donvithuoc;

public class ThemDonViJFrame extends JFrame implements ActionListener{

	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinDonvi;
	private JLabel lblMaDV;
	private JTextField txtMaDV;
	private JLabel lblTenDV;
	private JTextField txtTenDV;
	private JButton btnLuu;
	private JButton btnDong;
	private Donvi_DAO donvi_DAO;
	private ThemThuoc_DAO themthuoc_DAO;

	public ThemDonViJFrame() {
		ConnectDB.getInstance().getConnection();
		donvi_DAO = new Donvi_DAO();
		setSize(600, 300);
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
		lblTitle.setText("QUẢN LÝ ĐƠN VỊ");
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
		
		srcThongtinDonvi = new JScrollPane();
		srcThongtinDonvi.setBorder(BorderFactory.createTitledBorder("Thông tin đơn vị"));
		srcThongtinDonvi.setLayout(null);
		srcThongtinDonvi.setBackground(new Color(240, 240, 240));
		//
		lblMaDV = new JLabel();
		lblMaDV.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMaDV.setText("Mã đơn vị:");
		lblMaDV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaDV.setBounds(10, 20, 100, 30);
		txtMaDV = new JTextField();
		txtMaDV.setBounds(130, 24, 400, 23);
		txtMaDV.setEditable(false);
		//
		lblTenDV = new JLabel();
		lblTenDV.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTenDV.setText("Tên đơn vị:");
		lblTenDV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenDV.setBounds(10, 70, 100, 30);
		txtTenDV = new JTextField();
		txtTenDV.setBounds(130, 74, 400, 23);
		//
		btnLuu = new JButton("Lưu", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-save-24.png")));
		btnLuu.setFocusPainted(false);
		btnLuu.setFont(new Font("Arial", 0, 14));
		btnLuu.setForeground(new Color(45, 179, 0));
		btnLuu.setBounds(70, 150, 130, 40);
		btnLuu.setBackground(Color.white);
		//
		btnDong = new JButton("Đóng", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delete-24.png")));
		btnDong.setFocusPainted(false);
		btnDong.setFont(new Font("Arial", 0, 14));
		btnDong.setForeground(new Color(45, 179, 0));
		btnDong.setBounds(370, 150, 130, 40);
		btnDong.setBackground(Color.white);
		//
		srcThongtinDonvi.setBounds(10, 50, 574, 200);
		srcThongtinDonvi.add(lblMaDV);
		srcThongtinDonvi.add(txtMaDV);
		srcThongtinDonvi.add(lblTenDV);
		srcThongtinDonvi.add(txtTenDV);
		srcThongtinDonvi.add(btnLuu);
		srcThongtinDonvi.add(btnDong);
		//
		add(lblTitle);
		add(lblQuanly);
		add(lblChucnang);
		add(srcThongtinDonvi);
		//
		btnDong.addActionListener(this);
		btnLuu.addActionListener(this);
		if (checkMa(randomMa())== true) {
			txtMaDV.setText(randomMa());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDong)) {
			dispose();
		}else {
			if (o.equals(btnLuu)) {
				themAction();
			}
		}
	}
	private void themAction() {
		// TODO Auto-generated method stub
		String ma = txtMaDV.getText().trim();
		String ten = txtTenDV.getText().trim();
		if (valid(ten)== true) {
			Donvithuoc dv = new Donvithuoc(ma, ten);
			if(donvi_DAO.taoDonvi(dv) == true) {
				int hoinhac = JOptionPane.showConfirmDialog(this, "Bạn vừa tạo một đơn vị. Bạn có muốn tạo thêm đơn vị nữa không","Thuốc", JOptionPane.YES_NO_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					clearText();
				}
				else {
					dispose();
				}
			}
		}
	}
	private boolean valid(String ten) {
		if (!(ten.matches("[A-Z][a-zA-z' ]+")&& ten.length()>0)) {
			JOptionPane.showMessageDialog(this, "Tên đơn vị phải bằng chữ, ký tự đầu phải viết hoa");
			return false;
		}
		return true;
	}
	private void clearText() {
		// TODO Auto-generated method stub
		if (checkMa(randomMa()) == true) {
			txtMaDV.setText(randomMa());
		}
		txtTenDV.setText("");
	}

	public static void main(String[] args) {
		new ThemDonViJFrame().setVisible(true);
	}
	private String randomMa() {
		int max = 1000;
		int min = 0;
		Random rand = new Random();
		int n = rand.nextInt((max-min)+1) + min;
		String maduan = "DV"+n;
		return maduan;
	}
	private boolean checkMa(String ma) {
		List<String> dsma = donvi_DAO.checktrungma();
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
