package ui.Thuoc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.ConnectDB;
import dao.Thuoc.TimThuoc_DAO;
import entities.Thuoc;

public class KiemtraTTThuocJPanel extends JPanel implements ActionListener{

	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcThongtinDM;
	private JLabel lbltinhTrang;
	private JComboBox<String> cmbtinhTrang;
	private JButton btnCheck;
	private JScrollPane srcBangthongtin;
	private DefaultTableModel tableModel;
	private JTable table;
	private TimThuoc_DAO timthuoc_DAO;

	public KiemtraTTThuocJPanel() {
		ConnectDB.getInstance().getConnection();
		timthuoc_DAO = new TimThuoc_DAO();
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
		lblQuanly.setText("QUẢN LÝ QUẦY THUỐC");
		lblQuanly.setBounds(1100, 0, 280, 50);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lblChucnang.setText(">>Kiểm tra tình trạng");
		lblChucnang.setBounds(10, 25, 200, 20);

		srcThongtinDM = new JScrollPane();
		srcThongtinDM.setBorder(BorderFactory.createTitledBorder("Thông tin tình trạng"));
		srcThongtinDM.setLayout(null);
		srcThongtinDM.setBackground(Color.white);
		//
		lbltinhTrang = new JLabel();
		lbltinhTrang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbltinhTrang.setText("Tình trạng:");
		lbltinhTrang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltinhTrang.setBounds(0, 50, 80, 30);
		cmbtinhTrang = new JComboBox<String>();
		cmbtinhTrang.setBounds(100, 54, 200, 23);
		//
		btnCheck = new JButton("Kiểm tra", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-check-24.png")));
		btnCheck.setFocusPainted(false);
		btnCheck.setFont(new Font("Arial", 0, 14));
		btnCheck.setForeground(new Color(45, 179, 0));
		btnCheck.setBounds(1000, 50, 150, 30);
		btnCheck.setBackground(Color.white);
		//
		srcThongtinDM.setBounds(7, 50, 1350, 150);
		srcThongtinDM.add(lbltinhTrang);
		srcThongtinDM.add(cmbtinhTrang);
		srcThongtinDM.add(btnCheck);
		//
		srcBangthongtin = new JScrollPane();
		String [] headers = "Mã thuốc;Tên Thuốc;Tình Trạng".split(";");
	  	tableModel = new DefaultTableModel(headers, 0);
		add(srcBangthongtin = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		srcBangthongtin.setBorder(BorderFactory.createTitledBorder("Danh sách thuốc theo tình trạng"));
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32,136,203));
		srcBangthongtin.setBackground(Color.white);

		srcBangthongtin.setBounds(7, 200, 1350, 450);
		//
		add(lblChucnang);
		add(lblQuanly);
		add(lblTitle);
		add(srcThongtinDM);
		add(srcBangthongtin);
		btnCheck.addActionListener(this);
		loadCmb();
		loadTable();
	}

	private void loadTable() {
		// TODO Auto-generated method stub
		List<Thuoc> dsthuoc = timthuoc_DAO.getAllThuoc();
		for(Thuoc t : dsthuoc) {
			tableModel.addRow(new Object[] {
				t.getMaThuoc(),
				t.getTenThuoc(),
				t.getTinhTrang(),
			});
		}
	}

	private void loadCmb() {
		List<String> dsTinhtrang = Arrays.asList("Hết", "Còn");
		for(String s : dsTinhtrang) {
			cmbtinhTrang.addItem(s);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnCheck)) {
			tableModel.setRowCount(0);
			kiemtratinhtrangAction();
		}
	}

	private void kiemtratinhtrangAction() {
		// TODO Auto-generated method stub
		String tinhtrang = (String) cmbtinhTrang.getSelectedItem();
		List<Thuoc> dsTh = timthuoc_DAO.timThuocByTinhtrang(tinhtrang);
		for(Thuoc t : dsTh) {
			tableModel.addRow(new Object[] {
					t.getMaThuoc(),
					t.getTenThuoc(),
//					t.getMaDonvi().getMaDonvi(),
//					t.getDonGia(),
//					t.getMaNhaCC().getMaNhaCC(),
//					t.getMaNuoc().getMaLoai(),
//					t.getDanhMucthuoc()
					t.getTinhTrang()
//					t.getNgayNhap()
			});
		}
	}
}
