package ui.NhaCC;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ConnectDB;
import dao.NhaCC.NhaCC_DAO;
import entities.Nhacungcap;
import ui.Khachhang.ThemKHJDialog;

public class XemNCCJPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinNhaCC;
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
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnCapnhat;
	private JButton btnXoa;
	private JScrollPane srcBangthongtin;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnRefresh;
	private NhaCC_DAO nhacungcap_DAO;
	private JButton btnXoarong;

	public XemNCCJPanel() {
		ConnectDB.getInstance().getConnection();
		nhacungcap_DAO = new NhaCC_DAO();
		setBackground(Color.white);
		setLayout(null);
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("QUẢN LÝ NHÀ CUNG CẤP");
		lblTitle.setBounds(0, 0, 240, 25);

		lblQuanly = new JLabel();
		lblQuanly.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblQuanly.setForeground(new java.awt.Color(0, 204, 153));
		lblQuanly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
		lblQuanly.setText("QUẢN LÝ QUẦY THUỐC");
		lblQuanly.setBounds(1100, 0, 280, 50);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lblChucnang.setText(">>Thêm, xóa, sửa nhà cung cấp");
		lblChucnang.setBounds(10, 25, 200, 20);

		srcThongtinNhaCC = new JScrollPane();
		srcThongtinNhaCC.setBorder(BorderFactory.createTitledBorder("Thông tin nhà cung cấp"));
		srcThongtinNhaCC.setLayout(null);
		srcThongtinNhaCC.setBounds(0, 50, 1360, 200);
		//
		lblMaNCC = new JLabel();
		lblMaNCC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMaNCC.setText("Mã NCC:");
		lblMaNCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNCC.setBounds(0, 20, 100, 30);
		txtMaNCC = new JTextField();
		txtMaNCC.setBounds(130, 24, 200, 23);
		txtMaNCC.setEditable(false);
		//
		lblTenNCC = new JLabel();
		lblTenNCC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTenNCC.setText("Tên NCC:");
		lblTenNCC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenNCC.setBounds(0, 90, 100, 30);
		txtTenNCC = new JTextField();
		txtTenNCC.setBounds(130, 94, 200, 23);
		//
		lblEmail = new JLabel();
		lblEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblEmail.setText("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(400, 20, 100, 30);
		txtEmail = new JTextField();
		txtEmail.setBounds(550, 24, 200, 23);
		//
		lblSDT = new JLabel();
		lblSDT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblSDT.setText("SĐT:");
		lblSDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSDT.setBounds(400, 55, 100, 30);
		txtSDT = new JTextField();
		txtSDT.setBounds(550, 59, 200, 23);
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
		srcThongtinNhaCC.add(lblMaNCC);
		srcThongtinNhaCC.add(txtMaNCC);
		srcThongtinNhaCC.add(lblTenNCC);
		srcThongtinNhaCC.add(txtTenNCC);
		srcThongtinNhaCC.add(lblEmail);
		srcThongtinNhaCC.add(txtEmail);
		srcThongtinNhaCC.add(lblSDT);
		srcThongtinNhaCC.add(txtSDT);
		srcThongtinNhaCC.add(lblDiachi);
		srcThongtinNhaCC.add(txaDiachi);
		srcThongtinNhaCC.add(btnCapnhat);
		srcThongtinNhaCC.add(btnTim);
		srcThongtinNhaCC.add(btnThem);
		srcThongtinNhaCC.add(btnXoa);
		srcThongtinNhaCC.add(btnRefresh);
		srcThongtinNhaCC.add(btnXoarong);
		//
		srcBangthongtin = new JScrollPane();
		String [] headers = "Mã NCC;Tên NCC;Email;SDT;Địa chỉ".split(";");
	  	tableModel = new DefaultTableModel(headers, 0);
		add(srcBangthongtin = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		srcBangthongtin.setBorder(BorderFactory.createTitledBorder("Danh sách nhà cung cấp"));
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32,136,203));
		srcBangthongtin.setBackground(Color.white);
		srcThongtinNhaCC.setBackground(Color.white);
		srcBangthongtin.setBounds(7, 260, 1350, 400);
		//
		add(lblChucnang);
		add(lblQuanly);
		add(lblTitle);
		add(srcThongtinNhaCC);
		add(srcBangthongtin);
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnCapnhat.addActionListener(this);
		btnXoa.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnXoarong.addActionListener(this);
		loadTable();
		table.addMouseListener(new MouseListener() {
			
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
				int row = table.getSelectedRow();
				txtMaNCC.setText(tableModel.getValueAt(row, 0).toString());
				txtTenNCC.setText(tableModel.getValueAt(row, 1).toString());
				txtSDT.setText(tableModel.getValueAt(row, 2).toString());
				txtEmail.setText(tableModel.getValueAt(row, 3).toString());
				txaDiachi.setText(tableModel.getValueAt(row, 4).toString());
			}
		});
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		List<Nhacungcap> dsNcc = nhacungcap_DAO.getAllNCC();
		for(Nhacungcap ncc : dsNcc) {
			tableModel.addRow(new Object[] {
					ncc.getMaNhaCC(),
					ncc.getTenNhaCC(),
					ncc.getSdt(),
					ncc.getEmail(),
					ncc.getDiachi()
			});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			ThemNCCJDialog themNCC = new ThemNCCJDialog();
			themNCC.setAlwaysOnTop(true);
			themNCC.setVisible(true);
		}else {
			if (o.equals(btnTim)) {
				String ten = txtTenNCC.getText().trim();
				String sdt = txtSDT.getText().trim();
				String email = txtEmail.getText().trim();
				String diachi = txaDiachi.getText().trim();
				if (sdt.equals("") && email.equals("") && diachi.equals("")) {
					if(ten.equals("")) {
						JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhà cung cấp");
					}else {
						tableModel.setRowCount(0);
						timTen(ten);
					}
				}else {
					if (ten.equals("") && email.equals("") && diachi.equals("")) {
						if(sdt.equals("")) {
							JOptionPane.showMessageDialog(this, "Vui lòng nhập SDT nhà cung cấp");
						}else {
							tableModel.setRowCount(0);
							timSDT(sdt);
						}
					}else {
						if (ten.equals("") && sdt.equals("") && diachi.equals("")) {
							if (email.equals("")) {
								JOptionPane.showMessageDialog(this, "Vui lòng nhập Email nhà cung cấp");
							} else {
								tableModel.setRowCount(0);
								timEmail(email);
							}
						} else {
							if (ten.equals("") && sdt.equals("") && email.equals("")) {
								if (diachi.equals("")) {
									JOptionPane.showMessageDialog(this, "Vui lòng nhập Địa chỉ nhà cung cấp");
								} else {
									tableModel.setRowCount(0);
									timDiachi(diachi);
								}
							}
						}
					}
				}
			} else {
				if (o.equals(btnCapnhat)) {
					capnhatAction();
				} else {
					if(o.equals(btnXoa)) {
						xoaAction();
					}else {
						if (o.equals(btnRefresh)) {
							tableModel.getDataVector().removeAllElements();
							loadTable();
						}else if (o.equals(btnXoarong)) {
							clearText();
						}
					}
				}
			}
		}
	}

	private void clearText() {
		// TODO Auto-generated method stub
		txtMaNCC.setText("");
		txtTenNCC.setText("");
		txtEmail.setText("");
		txtSDT.setText("");
		txaDiachi.setText("");
	}

	private void xoaAction() {
		// TODO Auto-generated method stub
		String ma = txtMaNCC.getText().trim();
		if(ma.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn mã nhà cung cấp");
		}else {
			nhacungcap_DAO.deleteKhachhang(ma);
			JOptionPane.showMessageDialog(this, "Xóa thành công");
			tableModel.getDataVector().removeAllElements();
			loadTable();
		}
	}

	private void capnhatAction() {
		// TODO Auto-generated method stub
		String ma = txtMaNCC.getText().trim();
		String ten = txtTenNCC.getText().trim();
		String sdt = txtSDT.getText().trim();
		String email = txtEmail.getText().trim();
		String diachi = txaDiachi.getText().trim();
		if (valid(ten, sdt, email, diachi) == true) {
			Nhacungcap ncc = new Nhacungcap(ma, ten, email, sdt, diachi);
			if(nhacungcap_DAO.updateNhacungcap(ncc) == true) {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				tableModel.getDataVector().removeAllElements();
				loadTable();
			}else {
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
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
	private void timDiachi(String diachi) {
		// TODO Auto-generated method stub
		List<Nhacungcap> dsNcc = nhacungcap_DAO.timNhaCCbyDiachi(diachi);
		for(Nhacungcap ncc : dsNcc) {
			tableModel.addRow(new Object[] {
					ncc.getMaNhaCC(),
					ncc.getTenNhaCC(),
					ncc.getSdt(),
					ncc.getEmail(),
					ncc.getDiachi()
			});
		}
	}

	private void timEmail(String email) {
		// TODO Auto-generated method stub
		List<Nhacungcap> dsNcc = nhacungcap_DAO.timNhaCCbyEmail(email);
		for(Nhacungcap ncc : dsNcc) {
			tableModel.addRow(new Object[] {
					ncc.getMaNhaCC(),
					ncc.getTenNhaCC(),
					ncc.getSdt(),
					ncc.getEmail(),
					ncc.getDiachi()
			});
		}
	}

	private void timSDT(String sdt) {
		// TODO Auto-generated method stub
		List<Nhacungcap> dsNcc = nhacungcap_DAO.timNhaCCbySDT(sdt);
		for(Nhacungcap ncc : dsNcc) {
			tableModel.addRow(new Object[] {
					ncc.getMaNhaCC(),
					ncc.getTenNhaCC(),
					ncc.getSdt(),
					ncc.getEmail(),
					ncc.getDiachi()
			});
		}
	}

	private void timTen(String ten) {
		// TODO Auto-generated method stub
		List<Nhacungcap> dsNcc = nhacungcap_DAO.timNhaCCbyTen(ten);
		for(Nhacungcap ncc : dsNcc) {
			tableModel.addRow(new Object[] {
					ncc.getMaNhaCC(),
					ncc.getTenNhaCC(),
					ncc.getSdt(),
					ncc.getEmail(),
					ncc.getDiachi()
			});
		}
	}

}
