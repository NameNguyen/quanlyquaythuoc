package ui.Baocao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.toedter.calendar.JDateChooser;

import dao.ConnectDB;
import dao.Baocao.BCDoanhThu_DAO;
import entities.Chitiethoadon;
import entities.Hoadon;



public class BCDoanhThuJPanel extends javax.swing.JPanel implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private BCDoanhThu_DAO bc_dao;
	private String msnv;
	private String tien;
	private String Ngaychon;
	private JLabel lblTitle;
	private JLabel lblQuanly;
	private JLabel lblChucnang;
	private JLabel lblNgaynhap;
	private JDateChooser choseNgaynhap;
	private JLabel lbldonGia;
	private JTextField txtdonGia;
	private JButton btnThem;
	private JButton btnXuat;
	private JButton btnXoarong;
	private JScrollPane srcBangthongtin;
	private JTable table;
	/**
	 * Creates new form BCDoanhThu
	 */
	public BCDoanhThuJPanel(String ma) {
		ConnectDB.getInstance().getConnection();
		bc_dao = new BCDoanhThu_DAO();
		msnv = ma;

		setBackground(Color.white);
		setLayout(null);
		lblTitle = new JLabel();
		lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
		lblTitle.setForeground(new java.awt.Color(51, 153, 255));
		lblTitle.setText("BÁO CÁO DOANH THU");
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
		
		JScrollPane srcThongtinbc = new JScrollPane();
		srcThongtinbc.setBorder(BorderFactory.createTitledBorder("Thông tin báo cáo"));
		srcThongtinbc.setLayout(null);
		srcThongtinbc.setBounds(0, 50, 1360, 200);
		
		lblNgaynhap = new JLabel("Ngày nhập:");
		lblNgaynhap.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblNgaynhap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNgaynhap.setBounds(0, 20, 100, 30);
		choseNgaynhap = new JDateChooser();
		choseNgaynhap.setDateFormatString("dd/MM/yyyy");
		choseNgaynhap.setBounds(130, 24, 200, 23);
		
		lbldonGia = new JLabel();
		lbldonGia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lbldonGia.setText("Doanh thu:");
		lbldonGia.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldonGia.setBounds(0, 90, 100, 30);
		txtdonGia = new JTextField();
		txtdonGia.setEditable(false);
		txtdonGia.setBounds(130, 94, 200, 23);
		
		btnThem = new JButton("Tạo báo cáo", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-add-24.png")));
		btnThem.setFocusPainted(false);
		btnThem.setFont(new Font("Arial", 0, 14));
		btnThem.setForeground(new Color(45, 179, 0));
		btnThem.setBounds(1000, 20, 150, 30);
		btnThem.setBackground(Color.white);
		
		btnXuat = new JButton("Xuất báo cáo", new javax.swing.ImageIcon(getClass().getResource("/image/icons8-update-24.png")));
		btnXuat.setFocusPainted(false);
		btnXuat.setFont(new Font("Arial", 0, 14));
		btnXuat.setForeground(new Color(45, 179, 0));
		btnXuat.setBounds(1000, 55, 150, 30);
		btnXuat.setBackground(Color.white);
		
		btnXoarong = new JButton();
		btnXoarong.setBackground(new java.awt.Color(255, 255, 255));
        btnXoarong.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnXoarong.setForeground(new java.awt.Color(45, 179, 0));
        btnXoarong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-eraser-24.png"))); // NOI18N
        btnXoarong.setText("Xóa rỗng");
        btnXoarong.setFocusPainted(false);
        btnXoarong.setBounds(1000, 90, 150, 30);
        
        srcBangthongtin = new JScrollPane();
		String [] headers = "Mã hóa đơn;Số lượng thuốc;Đơn giá;Ngày lập".split(";");
	  	tableModel = new DefaultTableModel(headers, 0);
		add(srcBangthongtin = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		srcBangthongtin.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
		table.setBackground(Color.white);
		table.getTableHeader().setBackground(new Color(32,136,203));
		srcBangthongtin.setBackground(Color.white);
		srcBangthongtin.setBounds(7, 260, 1350, 400);
		
		srcThongtinbc.setBounds(7, 50, 1350, 200);
		srcThongtinbc.add(lblNgaynhap);
		srcThongtinbc.add(choseNgaynhap);
		srcThongtinbc.add(lbldonGia);
		srcThongtinbc.add(txtdonGia);
		srcThongtinbc.add(btnThem);
		srcThongtinbc.add(btnXuat);
		srcThongtinbc.add(btnXoarong);
		srcThongtinbc.setBackground(Color.white);
		
		add(lblTitle);
		add(lblQuanly);
		add(lblChucnang);
		add(srcThongtinbc);
		add(srcBangthongtin);
		
		btnThem.addActionListener(this);
		btnXuat.addActionListener(this);
		btnXoarong.addActionListener(this);
		
	}


	private static final String digits = "0123456789";
	private static final String ALPHA_NUMERIC = digits;
	private XWPFDocument doc;
	private void docdata(String Day) {
		List<Hoadon> list = bc_dao.gethddate(Day);
		long tongdoanhthu = 0;
		for(Hoadon hd : list) {
			String ma = hd.getMaHoaDon();
			int a = tongthuoc(ma);
			long  b = (long) test(ma);
			tongdoanhthu +=b;
			tableModel.addRow(new Object[] {
					hd.getMaHoaDon(),
					a,
					b,
					hd.getNgayLap()
			});
		}
		String tongtien = String.valueOf(tongdoanhthu);
		txtdonGia.setText(tongtien+"VND");
		tien = tongtien;
	}
	public double test(String ma) {
		List<Chitiethoadon> list = bc_dao.getmathuoc(ma);
		long tongtien = (long) 0.0;;
		for(Chitiethoadon t : list) {
			String mathuoc = t.getMaThuoc().getMaThuoc();
			double gia1thuoc = bc_dao.getallThuoc2(mathuoc);
			int soluong1thuoc = bc_dao.getsoluongthuoc(ma, mathuoc);
			tongtien += gia1thuoc*soluong1thuoc;
		}
		return tongtien;
	}
	public int tongthuoc(String ma) {
		List<Chitiethoadon> list2 = bc_dao.getsoluong(ma);
		int a = 0;
		for(Chitiethoadon ct : list2) {
			a += ct.getSoLuong();
		}
		return a;
	}

	private String nguoilap(String ma) {
		String ten = bc_dao.timNguoidungByMa(ma);
		return ten;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			String ngaylap = choseNgaynhap.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
			Ngaychon = ngaylap;
			docdata(ngaylap);
		}else {
			if (o.equals(btnXuat)) {
				try {
					FileOutputStream outputStream = new FileOutputStream("BaoCaoDT.docx");
					doc = new XWPFDocument();
					XWPFParagraph paragraph = doc.createParagraph();
					paragraph.setAlignment(ParagraphAlignment.CENTER);
					XWPFRun run = paragraph.createRun();
					run.setBold(true);
					run.setFontSize(20);
					run.setText("BÁO CÁO DOANH THU");

//					XWPFParagraph paragraph2 = doc.createParagraph();
//					paragraph2.setAlignment(ParagraphAlignment.LEFT);
//					XWPFRun run2 = paragraph2.createRun();
//					run2.setBold(true);
//					run2.setFontSize(12);
//					run2.setText("Người lập: " + nguoilap(msnv));

					XWPFParagraph paragraph3 = doc.createParagraph();
					paragraph3.setAlignment(ParagraphAlignment.LEFT);
					XWPFRun run3 = paragraph3.createRun();
					run3.setBold(true);
					run3.setFontSize(12);
					run3.setText("Ngày Lập báo cáo: " + LocalDate.now().toString());

					XWPFParagraph paragraph4 = doc.createParagraph();
					paragraph3.setAlignment(ParagraphAlignment.LEFT);
					XWPFRun run4 = paragraph4.createRun();
					run4.setBold(true);
					run4.setFontSize(12);
					run4.setText("Ngày tính: " + Ngaychon);

					XWPFParagraph paragraph5 = doc.createParagraph();
					paragraph4.setAlignment(ParagraphAlignment.LEFT);
					XWPFRun run5 = paragraph5.createRun();
					run5.setBold(true);
					run5.setFontSize(12);
					run5.setText("Tổng doanh thu: " + tien + " VND");

					doc.write(outputStream);
					outputStream.close();
					JOptionPane.showConfirmDialog(null, "Bạn muốn xuất báo cáo?");
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, e2);
				}
			}else {
				if (o.equals(btnXoarong)) {
					tableModel.setRowCount(0);
				}
			}
		}
	}
}
