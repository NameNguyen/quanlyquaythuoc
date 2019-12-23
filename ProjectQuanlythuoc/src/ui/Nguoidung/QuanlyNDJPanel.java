package ui.Nguoidung;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ConnectDB;
import dao.Nguoidung.Nguoidung_DAO;
import dao.Taikhoan.Taikhoan_DAO;
import entities.Nguoidung;
import entities.Taikhoan;
import ui.Khachhang.ThemKHJDialog;

public class QuanlyNDJPanel extends JPanel implements ActionListener{

	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinND;
	private JLabel lblMaND;
	private JTextField txtMaND;
	private JLabel lblHoten;
	private JTextField txtHoten;
	private JLabel lblGioitinh;
	private JLabel lblDiachi;
	private JTextArea txaDiachi;
	private JLabel lblChucvu;
	private JComboBox<String> cmbChucvu;
	private JButton btnTim;
	private AbstractButton btnThem;
	private JButton btnCapnhat;
	private JButton btnXoa;
	private JScrollPane srcBangthongtin;
	private DefaultTableModel tableModel;
	private JTable table;
	private JLabel lblPass;
	private JTextField txtPass;
	private JButton btnRefresh;
	private Nguoidung_DAO nguoidung_DAO;
	private Taikhoan_DAO taikhoan_DAO;
	private JRadioButton radGioitinhNam;
	private JRadioButton radGioitinhNu;
	private ButtonGroup groupButt;
	private JButton btnXoarong;

	public QuanlyNDJPanel() {
		ConnectDB.getInstance().getConnection();
		nguoidung_DAO = new Nguoidung_DAO();
		taikhoan_DAO = new Taikhoan_DAO();
		setBackground(Color.white);
		setLayout(null);
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
		lblQuanly.setBounds(1100, 0, 280, 50);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lblChucnang.setText(">>Thêm, xóa, sửa người dùng");
		lblChucnang.setBounds(10, 25, 200, 20);

		srcThongtinND = new JScrollPane();
		srcThongtinND.setBorder(BorderFactory.createTitledBorder("Thông tin người dùng"));
		srcThongtinND.setLayout(null);
		//
		lblMaND = new JLabel();
		lblMaND.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMaND.setText("Mã ND:");
		lblMaND.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaND.setBounds(0, 20, 100, 30);
		txtMaND = new JTextField();
		txtMaND.setBounds(150, 24, 200, 23);
		txtMaND.setEditable(false);
		//
		lblHoten = new JLabel();
		lblHoten.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblHoten.setText("Họ tên:");
		lblHoten.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoten.setBounds(0, 55, 100, 30);
		txtHoten = new JTextField();
		txtHoten.setBounds(150, 59, 200, 23);
		//
		lblGioitinh = new JLabel();
		lblGioitinh.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblGioitinh.setText("Giới tính:");
		lblGioitinh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGioitinh.setBounds(0, 90, 100, 30);
		radGioitinhNam = new JRadioButton("Nam");
		radGioitinhNu = new JRadioButton("Nữ");
		radGioitinhNam.setBounds(150, 94, 70, 23);
		radGioitinhNu.setBounds(220, 94, 100, 23);
		groupButt = new ButtonGroup();
		groupButt.add(radGioitinhNam);
		groupButt.add(radGioitinhNu);
		//
		lblPass = new JLabel();
		lblPass.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblPass.setText("Mật khẩu:");
		lblPass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPass.setBounds(400, 55, 100, 30);
		txtPass = new JTextField();
		txtPass.setEditable(false);
		txtPass.setBounds(550, 59, 200, 23);
		//
		lblDiachi = new JLabel("Địa chỉ:");
		lblDiachi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblDiachi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiachi.setBounds(400, 90, 100, 30);
		txaDiachi = new JTextArea();
		txaDiachi.setBounds(550, 94, 200, 70);
		txaDiachi.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		txaDiachi.setLineWrap(true);
		txaDiachi.setWrapStyleWord(true);
		//
		lblChucvu = new JLabel();
		lblChucvu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblChucvu.setText("Chức vụ:");
		lblChucvu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChucvu.setBounds(400, 20, 100, 30);
		cmbChucvu = new JComboBox<String>();
		cmbChucvu.setBounds(550, 24, 200, 23);
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
		srcThongtinND.setBounds(0, 50, 1360, 200);
		srcThongtinND.add(lblMaND);
		srcThongtinND.add(txtMaND);
		srcThongtinND.add(lblHoten);
		srcThongtinND.add(txtHoten);
		srcThongtinND.add(lblGioitinh);
		srcThongtinND.add(radGioitinhNam);
		srcThongtinND.add(radGioitinhNu);
		srcThongtinND.add(lblPass);
		srcThongtinND.add(txtPass);
		srcThongtinND.add(lblDiachi);
		srcThongtinND.add(txaDiachi);
		srcThongtinND.add(lblChucvu);
		srcThongtinND.add(cmbChucvu);
		srcThongtinND.add(btnCapnhat);
		srcThongtinND.add(btnThem);
		srcThongtinND.add(btnTim);
		srcThongtinND.add(btnXoa);
		srcThongtinND.add(btnRefresh);
		srcThongtinND.add(btnXoarong);
		//
		srcBangthongtin = new JScrollPane();
		String [] headers = "Mã ND;Họ tên;Giới tính;Địa chỉ;Chức vụ;Mật khẩu".split(";");
	  	tableModel = new DefaultTableModel(headers, 0);
		add(srcBangthongtin = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		srcBangthongtin.setBorder(BorderFactory.createTitledBorder("Danh sách người dùng"));
		srcBangthongtin.setBounds(7, 260, 1350, 400);
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32,136,203));
		srcBangthongtin.setBackground(Color.white);
		srcThongtinND.setBackground(Color.white);
		//
		add(lblChucnang);
		add(lblQuanly);
		add(lblTitle);
		add(srcThongtinND);
		add(srcBangthongtin);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnCapnhat.addActionListener(this);
		btnXoa.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnXoarong.addActionListener(this);
		loadTable();
		loadCmb();
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
				txtMaND.setText(tableModel.getValueAt(row, 0).toString());
				txtHoten.setText(tableModel.getValueAt(row, 1).toString());
				txaDiachi.setText(tableModel.getValueAt(row, 3).toString());
				txtPass.setText(tableModel.getValueAt(row, 5).toString());
				String gioitinh = (String) tableModel.getValueAt(row, 2);
				if(gioitinh.equalsIgnoreCase("Nam")) {
					radGioitinhNam.doClick();
				}else if (gioitinh.equalsIgnoreCase("Nữ")) {
					radGioitinhNu.doClick();
				}
				cmbChucvu.setSelectedItem(tableModel.getValueAt(row, 4));
			}
		});
	}

	private void loadCmb() {
		// TODO Auto-generated method stub
		List<String> dsChucvu = Arrays.asList("","Admin", "Quản lý", "Nhân viên");
		for(String s: dsChucvu) {
			cmbChucvu.addItem(s);
		}
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		List<Nguoidung> dsnd = nguoidung_DAO.getAllNguoidung();
		for(Nguoidung nd : dsnd) {
			tableModel.addRow(new Object [] {
					nd.getTaiKhoan().getUserName(),
					nd.getHoten(),
					nd.getGioiTinh(),
					nd.getDiachi(),
					nd.getChucVu(),
					nd.getTaiKhoan().getPassWord()
			});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			ThemNguoidungJDialog themND_UI = new ThemNguoidungJDialog();
			themND_UI.setAlwaysOnTop(true);
			themND_UI.setVisible(true);
		}
		else {
			if (o.equals(btnTim)) {
				String ten = txtHoten.getText().trim();
				String chucVu = (String) cmbChucvu.getSelectedItem();
				String diaChi = txaDiachi.getText().trim();
				String gioitinh = null;
				if(radGioitinhNam.isSelected()) {
					gioitinh = "Nam";
				}else if (radGioitinhNu.isSelected()) {
					gioitinh = "Nữ";
				}
				if(chucVu.equals("") && diaChi.equals("")) {
					if(ten.equals("")) {
						JOptionPane.showMessageDialog(this, "Vui lòng nhập tên người dùng");
					}else {
						tableModel.setRowCount(0);
						timTen(ten);
					}
				}else if (ten.equals("") && diaChi.equals("")) {
					if (chucVu.equals("")) {
						JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ người dùng");
					} else {
						tableModel.setRowCount(0);
						timChucvu(chucVu);
					}
				}else if (ten.equals("") && chucVu.equals("")) {
					if (diaChi.equals("")) {
						JOptionPane.showMessageDialog(this, "Vui lòng nhập dịa chỉ người dùng");
					} else {
						tableModel.setRowCount(0);
						timDiachi(diaChi);
					}
				}else if (ten.equals("") && chucVu.equals("") && diaChi.equals("")) {
					if (gioitinh.equals("")) {
						JOptionPane.showMessageDialog(this, "Vui lòng nhập giới tính người dùng");
					} else {
						if (gioitinh.equalsIgnoreCase("Nam") || gioitinh.equalsIgnoreCase("Nữ")) {
							tableModel.setRowCount(0);
							timGioitinh(gioitinh);
						}else {
							JOptionPane.showMessageDialog(this, "Giới tính chỉ là Nam hoặc Nữ");
						}
					}
				}
			}else if (o.equals(btnCapnhat)) {
				capnhatAction();
			}else if (o.equals(btnXoa)) {
				xoaAtion();
			}else if (o.equals(btnRefresh)) {
				tableModel.getDataVector().removeAllElements();
				loadTable();
			}else if (o.equals(btnXoarong)) {
				clearText();
			}
		}
	}

	private void clearText() {
		// TODO Auto-generated method stub
		txtMaND.setText("");
		txtHoten.setText("");
		txtPass.setText("");
		txaDiachi.setText("");
		groupButt.clearSelection();
		cmbChucvu.setSelectedIndex(0);
	}

	private void xoaAtion() {
		// TODO Auto-generated method stub
		String ma = txtMaND.getText().trim();
		if(ma.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn mã người dùng");
		}else {
			nguoidung_DAO.deleteNguoidung(ma);
			taikhoan_DAO.deleteTaikhoan(ma);
			JOptionPane.showMessageDialog(this, "Xóa thành công");
			tableModel.getDataVector().removeAllElements();
			loadTable();
		}
	}

	private void capnhatAction() {
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
		if (valid(ten, pass, diaChi)== true) {
			Taikhoan tk = new Taikhoan(ma, pass);
			Nguoidung nd = new Nguoidung(tk, ten, gioiTinh, diaChi, chucVu);
			if(nguoidung_DAO.updateNguoidung(nd)== true) {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				tableModel.getDataVector().removeAllElements();
				loadTable();
			}else {
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
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
	private void timGioitinh(String gioitinh) {
		// TODO Auto-generated method stub
		List<Nguoidung> dsnd = nguoidung_DAO.timNguoidungByGioitinh(gioitinh);
		for(Nguoidung nd : dsnd) {
			tableModel.addRow(new Object [] {
					nd.getTaiKhoan().getUserName(),
					nd.getHoten(),
					nd.getGioiTinh(),
					nd.getDiachi(),
					nd.getChucVu(),
					nd.getTaiKhoan().getPassWord()
			});
		}
	}

	private void timDiachi(String diaChi) {
		// TODO Auto-generated method stub
		List<Nguoidung> dsnd = nguoidung_DAO.timNguoidungByDiachi(diaChi);
		for(Nguoidung nd : dsnd) {
			tableModel.addRow(new Object [] {
					nd.getTaiKhoan().getUserName(),
					nd.getHoten(),
					nd.getGioiTinh(),
					nd.getDiachi(),
					nd.getChucVu(),
					nd.getTaiKhoan().getPassWord()
			});
		}
	}

	private void timChucvu(String chucvu) {
		// TODO Auto-generated method stub
		List<Nguoidung> dsnd = nguoidung_DAO.timNguoidungByChucvu(chucvu);
		for(Nguoidung nd : dsnd) {
			tableModel.addRow(new Object [] {
					nd.getTaiKhoan().getUserName(),
					nd.getHoten(),
					nd.getGioiTinh(),
					nd.getDiachi(),
					nd.getChucVu(),
					nd.getTaiKhoan().getPassWord()
			});
		}
	}

	private void timTen(String ten) {
		// TODO Auto-generated method stub
		List<Nguoidung> dsnd = nguoidung_DAO.timNguoidungByten(ten);
		for(Nguoidung nd : dsnd) {
			tableModel.addRow(new Object [] {
					nd.getTaiKhoan().getUserName(),
					nd.getHoten(),
					nd.getGioiTinh(),
					nd.getDiachi(),
					nd.getChucVu(),
					nd.getTaiKhoan().getPassWord()
			});
		}
	}
}
