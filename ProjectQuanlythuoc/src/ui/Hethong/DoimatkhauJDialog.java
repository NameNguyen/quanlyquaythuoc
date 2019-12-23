package ui.Hethong;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.ConnectDB;
import dao.Nguoidung.Nguoidung_DAO;
import dao.Taikhoan.Taikhoan_DAO;
import entities.Taikhoan;

public class DoimatkhauJDialog extends JDialog implements ActionListener{

	private JLabel lblTitle;
	private JLabel lblChucnang;
	private JLabel lblOldPass;
	private JPasswordField pafOld;
	private JLabel lblOldNew;
	private JPasswordField pafNew;
	private JLabel lblXacnhan;
	private JTextField txtXacnhan;
	private JButton btnLuu;
	private JButton btnDong;
	private Nguoidung_DAO nguoidung_DAO;
	private Taikhoan_DAO taikhoan_DAO;
	private JLabel lblMaND;
	private JTextField txtMaND;

	public DoimatkhauJDialog() {
		ConnectDB.getInstance().getConnection();
		nguoidung_DAO = new Nguoidung_DAO();
		taikhoan_DAO = new Taikhoan_DAO();
		setBackground(Color.white);
		setLayout(null);
		setSize(400, 300);
		ImageIcon image = new ImageIcon(getClass().getResource("/image/icons8-clinic-64.png"));
		setIconImage(image.getImage());
		setTitle("Đổi mật khẩu");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("HỆ THỐNG");
		lblTitle.setBounds(0, 0, 150, 25);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lblChucnang.setText(">>Đổi mật khẩu");
		lblChucnang.setBounds(10, 20, 200, 20);
		//
		lblMaND = new JLabel();
		lblMaND.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMaND.setText("Mã ND:");
		lblMaND.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaND.setBounds(0, 40, 120, 30);
		txtMaND = new JTextField();
		txtMaND.setBounds(140, 44, 200, 23);
		txtMaND.setEditable(false);
		//
		lblOldPass = new JLabel();
		lblOldPass.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); // NOI18N
		lblOldPass.setText("Mật khẩu cũ:");
		lblOldPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOldPass.setBounds(0, 75, 120, 30);
		pafOld = new JPasswordField();
		pafOld.setBounds(140, 79, 200, 23);
		//
		lblOldNew = new JLabel();
		lblOldNew.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); // NOI18N
		lblOldNew.setText("Mật khẩu mới:");
		lblOldNew.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOldNew.setBounds(0, 115, 120, 30);
		pafNew = new JPasswordField();
		pafNew.setBounds(140, 119, 200, 23);
		//
		lblXacnhan = new JLabel();
		lblXacnhan.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); // NOI18N
		lblXacnhan.setText("Nhập lại mật khẩu:");
		lblXacnhan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblXacnhan.setBounds(0, 150, 120, 30);
		txtXacnhan = new JTextField();
		txtXacnhan.setBounds(140, 154, 200, 23);
		//
		btnLuu = new JButton("Lưu", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-save-24.png")));
		btnLuu.setFocusPainted(false);
		btnLuu.setFont(new Font("Arial", 0, 14));
		btnLuu.setForeground(new Color(45, 179, 0));
		btnLuu.setBounds(30, 200, 120, 40);
		btnLuu.setBackground(Color.white);
		//
		btnDong = new JButton("Đóng", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delete-24.png")));
		btnDong.setFocusPainted(false);
		btnDong.setFont(new Font("Arial", 0, 14));
		btnDong.setForeground(new Color(45, 179, 0));
		btnDong.setBounds(230, 200, 120, 40);
		btnDong.setBackground(Color.white);
		//
		add(lblChucnang);
		add(lblMaND);
		add(txtMaND);
		add(lblTitle);
		add(lblOldPass);
		add(pafOld);
		add(lblOldNew);
		add(pafNew);
		add(lblXacnhan);
		add(txtXacnhan);
		add(btnDong);
		add(btnLuu);
		btnDong.addActionListener(this);
		btnLuu.addActionListener(this);
		load();
	}
	private void load() {
		// TODO Auto-generated method stub
		Taikhoan tk = taikhoan_DAO.getThongTindangnhap();
		txtMaND.setText(tk.getUserName());
	}
	public static void main(String[] args) {
		DoimatkhauJDialog dmkJDi = new DoimatkhauJDialog();
		dmkJDi.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnDong)) {
			dispose();
		} else {
			if(o.equals(btnLuu)) {
				luuAction();
			}
		}
	}
	private void luuAction() {
		// TODO Auto-generated method stub
		String passCu = pafOld.getText().trim();
		String passMoi = pafNew.getText().trim();
		String xacPass = txtXacnhan.getText().trim();
//		String ma = "NV01";
		Taikhoan tk1 = taikhoan_DAO.getThongTindangnhap();
		Taikhoan tk = taikhoan_DAO.timTaikhoanbyMa(tk1.getUserName());
		if (passMoi.equalsIgnoreCase(xacPass) && passCu.equalsIgnoreCase(tk.getPassWord())) {
			tk.setPassWord(passMoi);
			if(taikhoan_DAO.updateTaikhoan(tk)==true) {
				JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
			}else {
				JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại");
			}
		}
	}
}
