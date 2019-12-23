package ui.Hethong;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import ui.Dangnhap.Dangnhap_UI;

public class XemThongtinJFrame extends JFrame implements ActionListener{
	private Nguoidung_DAO nguoidung_DAO;
	private Taikhoan_DAO taikhoan_DAO;
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
	private ButtonGroup groupButt;
	private JLabel lblDiachi;
	private JTextArea txaDiachi;
	private JLabel lblPass;
	private JTextField txtPass;
	private JLabel lblChucvu;
	private JComboBox<String> cmbChucvu;
	private JButton btnLuu;
	private JButton btnDong;
	private Dangnhap_UI dn;
	private String ma;

	public XemThongtinJFrame() {
		ConnectDB.getInstance().getConnection();
		nguoidung_DAO = new Nguoidung_DAO();
		taikhoan_DAO = new Taikhoan_DAO();
		setBackground(Color.white);
		setLayout(null);
		ImageIcon image = new ImageIcon(getClass().getResource("/image/icons8-clinic-64.png"));
		setIconImage(image.getImage());
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
		lblTitle.setText("THÔNG TIN");
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
		lblChucnang.setText(">>Xem thông tin");
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
		load();
	}

	private void load() {
		// TODO Auto-generated method stub
		List<String> dsChucvu = Arrays.asList("Admin", "Quản lý", "Nhân viên");
		for(String s: dsChucvu) {
			cmbChucvu.addItem(s);
		}
		Taikhoan tk1 = taikhoan_DAO.getThongTindangnhap();
		txtMaND.setText(tk1.getUserName());
		Nguoidung nd = nguoidung_DAO.timNguoidungByMa(tk1.getUserName());
		Taikhoan tk = taikhoan_DAO.timTaikhoanbyMa(tk1.getUserName());
		txtHoten.setText(nd.getHoten());
		txaDiachi.setText(nd.getDiachi());
		cmbChucvu.setSelectedItem(nd.getChucVu());
		String gioitinh = nd.getGioiTinh();
		if(gioitinh.equalsIgnoreCase("Nam")) {
			radGioitinhNam.doClick();
		}else if (gioitinh.equalsIgnoreCase("Nữ")) {
			radGioitinhNu.doClick();
		}
		txtPass.setText(tk.getPassWord());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnLuu)) {
			luuAction();
			
			
		}else if (o.equals(btnDong)) {
			dispose();
		}
	}
	private void luuAction() {
		// TODO Auto-generated method stub
		String ma = txtMaND.getText().trim();
		String ten = txtHoten.getText().trim();
		String gioiTinh = null;
		if(radGioitinhNam.isSelected()) {
			gioiTinh = "Nam";
		}else if (radGioitinhNu.isSelected()) {
			gioiTinh = "Nữ";
		}
		String chucVu = (String) cmbChucvu.getSelectedItem();
		String diaChi = txaDiachi.getText().trim();
		String pass = txtPass.getText().trim();
		Taikhoan tk = new Taikhoan(ma, pass);
		Nguoidung nd = new Nguoidung(tk, ten, gioiTinh, diaChi, chucVu);
		if(nguoidung_DAO.updateNguoidung(nd)== true) {
			JOptionPane.showMessageDialog(this, "Cập nhật thành công");
		}else {
			JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
		}
	}

	public static void main(String[] args) {
		new XemThongtinJFrame().setVisible(true);
	}

}
