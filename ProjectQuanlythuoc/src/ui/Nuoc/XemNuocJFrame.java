package ui.Nuoc;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ConnectDB;
import dao.Nuoc.Nuoc_DAO;
import entities.Nuoc;
import ui.Thuoc.ThemthuocJDialog;

public class XemNuocJFrame extends JFrame implements ActionListener{
	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcBangthongtin;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnDong;
	private JButton btnThem;
	private JButton btnCapnhat;
	private JButton btnXoa;
	private JScrollPane srcThongtinNuoc;
	private JLabel lblMaNuoc;
	private JTextField txtMaNuoc;
	private JLabel lblTenNuoc;
	private JTextField txtTenNuoc;
	private Nuoc_DAO nuoc_DAO;
	private JButton btnRefresh;

	public XemNuocJFrame() {
		ConnectDB.getInstance().getConnection();
		nuoc_DAO = new Nuoc_DAO();
		setSize(665, 600);
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
		lblChucnang.setText(">>Thêm, xóa, sửa nước");
		lblChucnang.setBounds(10, 25, 200, 20);
		//
		srcThongtinNuoc = new JScrollPane();
		srcThongtinNuoc.setBorder(BorderFactory.createTitledBorder("Thông tin nước"));
		srcThongtinNuoc.setLayout(null);
		srcThongtinNuoc.setBackground(Color.white);
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
		srcThongtinNuoc.setBounds(0, 50, 655, 150);
		srcThongtinNuoc.add(lblMaNuoc);
		srcThongtinNuoc.add(txtMaNuoc);
		srcThongtinNuoc.add(lblTenNuoc);
		srcThongtinNuoc.add(txtTenNuoc);
		//
		srcBangthongtin = new JScrollPane();
		String [] headers = "Mã nước;Tên Nước".split(";");
		tableModel = new DefaultTableModel(headers, 0);
		add(srcBangthongtin = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		srcBangthongtin.setBorder(BorderFactory.createTitledBorder("Danh sách nước sản xuất"));
		srcBangthongtin.setBackground(new Color(240, 240, 240));
		srcBangthongtin.setBounds(0, 205, 655, 320);
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32,136,203));
		srcBangthongtin.setBackground(Color.white);
		//
		btnDong = new JButton("Đóng", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-exit-24.png")));
		btnDong.setFocusPainted(false);
		btnDong.setFont(new Font("Arial", 0, 16));
		btnDong.setForeground(new Color(45, 179, 0));
		btnDong.setBounds(528, 525, 130, 45);
		btnDong.setBackground(Color.white);
		//
		btnThem = new JButton("Thêm", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-add-24.png")));
		btnThem.setFocusPainted(false);
		btnThem.setFont(new Font("Arial", 0, 16));
		btnThem.setForeground(new Color(45, 179, 0));
		btnThem.setBounds(0, 525, 130, 45);
		btnThem.setBackground(Color.white);
		//
		btnCapnhat = new JButton("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-update-24.png")));
		btnCapnhat.setFocusPainted(false);
		btnCapnhat.setFont(new Font("Arial", 0, 16));
		btnCapnhat.setForeground(new Color(45, 179, 0));
		btnCapnhat.setBounds(132, 525, 130, 45);
		btnCapnhat.setBackground(Color.white);
		//
		btnXoa = new JButton("Xóa", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delete-24.png")));
		btnXoa.setFocusPainted(false);
		btnXoa.setFont(new Font("Arial", 0, 16));
		btnXoa.setForeground(new Color(45, 179, 0));
		btnXoa.setBounds(264, 525, 130, 45);
		btnXoa.setBackground(Color.white);
		//
		btnRefresh = new JButton("Refresh", new ImageIcon(getClass().getResource("/image/icons8-refresh-24.png")));
		btnRefresh.setFocusPainted(false);
		btnRefresh.setFont(new Font("Arial", 0, 14));
		btnRefresh.setForeground(new Color(45, 179, 0));
		btnRefresh.setBounds(396, 525, 130, 45);
		btnRefresh.setBackground(Color.white);
		//
		add(lblChucnang);
		add(lblQuanly);
		add(lblTitle);
		add(srcThongtinNuoc);
		add(btnThem);
		add(btnCapnhat);
		add(btnXoa);
		add(btnDong);
		add(btnRefresh);
		loadTable();
		btnCapnhat.addActionListener(this);
		btnDong.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnRefresh.addActionListener(this);
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
				txtMaNuoc.setText(tableModel.getValueAt(row, 0).toString());
				txtTenNuoc.setText(tableModel.getValueAt(row, 1).toString());
			}
		});
	}
	private void loadTable() {
		// TODO Auto-generated method stub
		List<Nuoc> dsNuoc = nuoc_DAO.getAllNuoc();
		for(Nuoc n : dsNuoc) {
			tableModel.addRow(new Object[] {
					n.getMaLoai(),
					n.getTenLoai()
			});
		}
	}
	public static void main(String[] args) {
		new XemNuocJFrame().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnDong)) {
			dispose();
		} else {
			if (o.equals(btnCapnhat)) {
				capnhatAction();
			} else {
				if (o.equals(btnXoa)) {
					xoaAction();
				} else {
					if (o.equals(btnThem)) {
						ThemthuocJDialog themThuocUI = new ThemthuocJDialog();
						themThuocUI.setAlwaysOnTop(true);
						themThuocUI.setVisible(true);
					}else {
						if (o.equals(btnRefresh)) {
							tableModel.getDataVector().removeAllElements();
							loadTable();
						}
					}
				}
			}
		}
	}
	private void xoaAction() {
		// TODO Auto-generated method stub
		String ma = txtMaNuoc.getText().trim().toUpperCase();
		if(nuoc_DAO.deleteNuoc(ma)==true) {
			JOptionPane.showMessageDialog(this, "Xóa thành công");
			tableModel.getDataVector().removeAllElements();
			loadTable();
		}
	}
	private void capnhatAction() {
		String ma = txtMaNuoc.getText().trim().toUpperCase();
		String ten = txtTenNuoc.getText().trim();
		if (valid(ten)== true) {
			Nuoc nuoc = new Nuoc(ma, ten);
			if (nuoc_DAO.updateNuoc(nuoc)== true) {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
				tableModel.getDataVector().removeAllElements();
				loadTable();
			} else {
				JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
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

}
