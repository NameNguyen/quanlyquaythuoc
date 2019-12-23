package ui.Nuoc;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.Nuoc.Nuoc_DAO;
import entities.Nuoc;

public class ThemnuocJDialog extends JFrame implements ActionListener{
	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinNuoc;
	private JLabel lblMaNuoc;
	private JTextField txtMaNuoc;
	private JLabel lblTenNuoc;
	private JTextField txtTenNuoc;
	private JButton btnLuu;
	private JButton btnDong;
	private Nuoc_DAO nuoc_DAO;

	public ThemnuocJDialog(){
		setSize(600, 300);
		nuoc_DAO = new Nuoc_DAO();
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
		lblTitle.setText("QUẢN LÝ NƯỚC");
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
		
		srcThongtinNuoc = new JScrollPane();
		srcThongtinNuoc.setBorder(BorderFactory.createTitledBorder("Thông tin nước"));
		srcThongtinNuoc.setLayout(null);
		srcThongtinNuoc.setBackground(new Color(240, 240, 240));
		//
		lblMaNuoc = new JLabel();
		lblMaNuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMaNuoc.setText("Mã nước:");
		lblMaNuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNuoc.setBounds(10, 20, 100, 30);
		txtMaNuoc = new JTextField();
		txtMaNuoc.setBounds(130, 24, 400, 23);
		txtMaNuoc.setEditable(false);
		//
		lblTenNuoc = new JLabel();
		lblTenNuoc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTenNuoc.setText("Tên nước:");
		lblTenNuoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNuoc.setBounds(10, 70, 100, 30);
		txtTenNuoc = new JTextField();
		txtTenNuoc.setBounds(130, 74, 400, 23);
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
		srcThongtinNuoc.setBounds(10, 50, 574, 200);
		srcThongtinNuoc.add(lblMaNuoc);
		srcThongtinNuoc.add(txtMaNuoc);
		srcThongtinNuoc.add(lblTenNuoc);
		srcThongtinNuoc.add(txtTenNuoc);
		srcThongtinNuoc.add(btnLuu);
		srcThongtinNuoc.add(btnDong);
		//
		add(lblTitle);
		add(lblQuanly);
		add(lblChucnang);
		add(srcThongtinNuoc);
		//
		btnDong.addActionListener(this);
		btnLuu.addActionListener(this);
		if (checkMa(randomMa()) == true) {
			txtMaNuoc.setText(randomMa());
		}
	}
	private String randomMa() {
		int max = 1000;
		int min = 0;
		Random rand = new Random();
		int n = rand.nextInt((max-min)+1) + min;
		String maduan = "N"+n;
		return maduan;
	}
	public static void main(String[] args) {
		new ThemnuocJDialog().setVisible(true);
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
		String ma = txtMaNuoc.getText().trim();
		String ten = txtTenNuoc.getText().trim();
		if(valid(ten)== true) {
			Nuoc n = new Nuoc(ma, ten);
			if(nuoc_DAO.taoNuoc(n) == true) {
				int hoinhac = JOptionPane.showConfirmDialog(this, "Bạn vừa tạo một nước. Bạn có muốn tạo thêm nước nữa không","Thuốc", JOptionPane.YES_NO_OPTION);
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
			JOptionPane.showMessageDialog(this, "Tên nước sản xuất phải bằng chữ, ký tự đầu phải viết hoa");
			return false;
		}
		return true;
	}
	private void clearText() {
		// TODO Auto-generated method stub
		txtMaNuoc.setText(randomMa());
		txtTenNuoc.setText("");
	}
	private boolean checkMa(String ma) {
		List<String> dsma = nuoc_DAO.checktrungma();
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
