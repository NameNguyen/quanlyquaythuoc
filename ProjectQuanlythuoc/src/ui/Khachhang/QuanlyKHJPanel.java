package ui.Khachhang;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
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
import dao.Khachhang.Khachhang_DAO;
import entities.Khachhang;

public class QuanlyKHJPanel extends JPanel implements ActionListener{

	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinKH;
	private JLabel lblMaKH;
	private JTextField txtMaKH;
	private JLabel lblTenKH;
	private JTextField txtTenKH;
	private JLabel lblSDT;
	private JLabel lblDiachi;
	private JTextField txtSDT;
	private JTextArea txaDiachi;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnCapnhat;
	private JButton btnXoa;
	private JScrollPane srcBangthongtin;
	private DefaultTableModel tableModel;
	private JTable table;
	private Khachhang_DAO khachhang_DAO;
	private JButton btnRefresh;
	private JButton btnXoarong;

	public QuanlyKHJPanel() {
		ConnectDB.getInstance().getConnection();
		khachhang_DAO = new Khachhang_DAO();
		setBackground(Color.white);
		setLayout(null);
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("QUẢN LÝ THUỐC");
		lblTitle.setBounds(0, 0, 200, 25);

		lblQuanly = new JLabel();
		lblQuanly.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblQuanly.setForeground(new java.awt.Color(0, 204, 153));
		lblQuanly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
		lblQuanly.setText("QUẢN LÝ KHÁCH HÀNG");
		lblQuanly.setBounds(1100, 0, 280, 50);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lblChucnang.setText(">>Thêm, xóa, sửa khách hàng");
		lblChucnang.setBounds(10, 25, 200, 20);

		srcThongtinKH = new JScrollPane();
		srcThongtinKH.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		srcThongtinKH.setLayout(null);
		//
		lblMaKH = new JLabel();
		lblMaKH.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblMaKH.setText("Mã KH:");
		lblMaKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaKH.setBounds(0, 20, 100, 30);
		txtMaKH = new JTextField();
		txtMaKH.setBounds(130, 24, 200, 23);
		txtMaKH.setEditable(false);
		//
		lblTenKH = new JLabel();
		lblTenKH.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTenKH.setText("Tên KH:");
		lblTenKH.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKH.setBounds(0, 90, 100, 30);
		txtTenKH = new JTextField();
		txtTenKH.setBounds(130, 94, 200, 23);
		//
		lblSDT = new JLabel();
		lblSDT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblSDT.setText("SĐT:");
		lblSDT.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSDT.setBounds(400, 20, 100, 30);
		txtSDT = new JTextField();
		txtSDT.setBounds(530, 24, 200, 23);
		//
		lblDiachi = new JLabel("Địa chỉ:");
		lblDiachi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblDiachi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiachi.setBounds(400, 90, 100, 30);
		txaDiachi = new JTextArea();
		txaDiachi.setBounds(530, 94, 200, 70);
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
		srcThongtinKH.setBounds(0, 50, 1360, 200);
		srcThongtinKH.add(lblMaKH);
		srcThongtinKH.add(txtMaKH);
		srcThongtinKH.add(lblTenKH);
		srcThongtinKH.add(txtTenKH);
		srcThongtinKH.add(lblSDT);
		srcThongtinKH.add(txtSDT);
		srcThongtinKH.add(lblDiachi);
		srcThongtinKH.add(txaDiachi);
		srcThongtinKH.add(btnCapnhat);
		srcThongtinKH.add(btnThem);
		srcThongtinKH.add(btnTim);
		srcThongtinKH.add(btnXoa);
		srcThongtinKH.add(btnRefresh);
		srcThongtinKH.add(btnXoarong);
		//
		srcBangthongtin = new JScrollPane();
		String [] headers = "Mã KH;Tên KH;SDT;Địa chỉ".split(";");
	  	tableModel = new DefaultTableModel(headers, 0);
		add(srcBangthongtin = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		srcBangthongtin.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));
		srcBangthongtin.setBounds(7, 260, 1350, 400);
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32,136,203));
		srcBangthongtin.setBackground(Color.white);
		srcThongtinKH.setBackground(Color.white);
		//
		add(lblChucnang);
		add(lblQuanly);
		add(lblTitle);
		add(srcThongtinKH);
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
				txtMaKH.setText(tableModel.getValueAt(row, 0).toString());
				txtTenKH.setText(tableModel.getValueAt(row, 1).toString());
				txtSDT.setText(tableModel.getValueAt(row, 2).toString());
				txaDiachi.setText(tableModel.getValueAt(row, 3).toString());
			}
		});
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		List<Khachhang> dskh = khachhang_DAO.getAllKhachhang();
		for(Khachhang kh : dskh) {
			tableModel.addRow(new Object[] {
					kh.getMaKH(),
					kh.getHoten(),
					kh.getSdt(),
					kh.getDiaChi()
			});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			ThemKHJDialog themKH = new ThemKHJDialog();
			themKH.setAlwaysOnTop(true);
			themKH.setVisible(true);
		}else {
			if (o.equals(btnTim)) {
				String ten = txtTenKH.getText().trim();
				String sdt = txtSDT.getText().trim();
				String diachi = txaDiachi.getText().trim();
				if(sdt.equalsIgnoreCase("") && diachi.equalsIgnoreCase("")) {
					if (ten.equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khách hàng");
					} else {
						tableModel.setRowCount(0);
						timTen(ten);
					}
				}else {
					if (ten.equalsIgnoreCase("") && diachi.equalsIgnoreCase("")) {
						if (sdt.equalsIgnoreCase("")) {
							JOptionPane.showMessageDialog(this, "Vui lòng nhập SDT khách hàng");
						} else {
							tableModel.setRowCount(0);
							timSDT(sdt);
						}
					}else {
						if (ten.equalsIgnoreCase("") && sdt.equalsIgnoreCase("")) {
							if (diachi.equalsIgnoreCase("")) {
								JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ khách hàng");
							} else {
								tableModel.setRowCount(0);
								timDiachi(diachi);
							}
						}
					}
				}
						
			}else {
				if (o.equals(btnCapnhat)) {
					capnhatAction();
				} else {
					if (o.equals(btnXoa)) {
						xoaAction();
					} else {
						if(o.equals(btnRefresh)) {
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
		txtMaKH.setText("");
		txtSDT.setText("");
		txtTenKH.setText("");
		txaDiachi.setText("");
	}

	private void xoaAction() {
		// TODO Auto-generated method stub
		String ma = txtMaKH.getText().trim();
		if(ma.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn mã khách hàng");
		}else {
			khachhang_DAO.deleteKhachhang(ma);
			JOptionPane.showMessageDialog(this, "Xóa thành công");
			tableModel.getDataVector().removeAllElements();
			loadTable();
		}
	}

	private void timDiachi(String diachi) {
		// TODO Auto-generated method stub
		List<Khachhang> dskh = khachhang_DAO.timKhachhangByDiachi(diachi);
		for(Khachhang kh : dskh) {
			tableModel.addRow(new Object[] {
					kh.getMaKH(),
					kh.getHoten(),
					kh.getSdt(),
					kh.getDiaChi()
			});
		}
	}

	private void timSDT(String sdt) {
		// TODO Auto-generated method stub
		List<Khachhang> dskh = khachhang_DAO.timKhachhangBySDT(sdt);
		for(Khachhang kh : dskh) {
			tableModel.addRow(new Object[] {
					kh.getMaKH(),
					kh.getHoten(),
					kh.getSdt(),
					kh.getDiaChi()
			});
		}
	}

	private void timTen(String ten) {
		// TODO Auto-generated method stub
		List<Khachhang> dskh = khachhang_DAO.timKhachhangByten(ten);
		for(Khachhang kh : dskh) {
			tableModel.addRow(new Object[] {
					kh.getMaKH(),
					kh.getHoten(),
					kh.getSdt(),
					kh.getDiaChi()
			});
		}
	}

	private void capnhatAction() {
		// TODO Auto-generated method stub
		String ma = txtMaKH.getText().trim();
		String ten = txtTenKH.getText().trim();
		String sdt = txtSDT.getText().trim();
		String diachi = txaDiachi.getText().trim();
		if (valid(ten, sdt, diachi)== true) {
			Khachhang kh = new Khachhang(ma, ten, sdt, diachi);
			if(khachhang_DAO.updateKhachhang(kh)==true) {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				tableModel.getDataVector().removeAllElements();
				loadTable();
			}else {
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
			}
		}
	}
	private boolean valid(String ten, String sdt, String diachi) {
		if (!(ten.matches("[A-Z][a-zA-Z' ]+") && ten.length()>0)) {
			JOptionPane.showMessageDialog(this, "Tên bắt đầu bằng chữ hoa không có chữ số");
			return false;
		}
		if (!(sdt.matches("\\d{10}") && sdt.length()>0)) {
			JOptionPane.showMessageDialog(this, "Số điện thoại gồm 10 số");
			return false;
		}
		if (!(diachi.length()>0)) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ");
			return false;
		}
		return true;
	}
}
