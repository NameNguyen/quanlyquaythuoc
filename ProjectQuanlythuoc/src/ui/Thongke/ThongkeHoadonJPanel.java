package ui.Thongke;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale.Category;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import dao.ConnectDB;
import dao.Thongke.ThongKe;
import dao.Thuoc.TimThuoc_DAO;
import entities.Thuoc;

public class ThongkeHoadonJPanel extends JPanel implements ActionListener{

	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JScrollPane srcBangthongke;
	private DefaultTableModel tableModel;
	private JTable table;
	private ThongKe tkThuocNhap_DAO;
	public ThongkeHoadonJPanel() {
		ConnectDB.getInstance().getConnection();
		setBackground(Color.white);
		setLayout(null);
		tkThuocNhap_DAO= new ThongKe();
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("THỐNG KÊ");
		lblTitle.setBounds(0, 0, 200, 25);

		lblQuanly = new JLabel();
		lblQuanly.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblQuanly.setForeground(new java.awt.Color(0, 204, 153));
		lblQuanly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
		lblQuanly.setText("QUẢN LÝ QUẦY THUỐC");
		lblQuanly.setBounds(1100, 0, 280, 50);

		lblChucnang = new JLabel();
		lblChucnang.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
		lblChucnang.setText(">>Thống kê thuốc nhập");
		lblChucnang.setBounds(10, 25, 200, 20);
		
		add(lblChucnang);
		add(lblQuanly);
		add(lblTitle);
		srcBangthongke = new JScrollPane();
		String [] headers = "Ngày nhập;Số lượng".split(";");
	  	tableModel = new DefaultTableModel(headers, 0);
		add(srcBangthongke = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		srcBangthongke.setBorder(BorderFactory.createTitledBorder("Danh sách ngày lập các hóa đơn"));
		srcBangthongke.setBounds(7, 50, 675, 620);
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32,136,203));
		srcBangthongke.setBackground(Color.white);
		loadTable();

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		List<Thuoc> dsthuoc = tkThuocNhap_DAO.thongKeHoadon();
		for(Thuoc t : dsthuoc) {
			int tong = (int) t.getDonGia();
			dataset.addValue(tong, "Hóa đơn bán", t.getNgayHethan());
		}
		JFreeChart chart = ChartFactory.createBarChart("Hóa đơn", "Ngày bán", "Số lượng", dataset);
		chart.setBackgroundPaint(Color.white);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(700, 50, 650, 620);
		add(chartPanel);
	}
	private void loadTable() {
		// TODO Auto-generated method stub
		List<Thuoc> dsthuoc = tkThuocNhap_DAO.thongKeHoadon();
		for(Thuoc t : dsthuoc) {
			tableModel.addRow(new Object[] {
				t.getNgayHethan(),
				(int)t.getDonGia()
			});
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
