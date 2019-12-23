package ui.menuAll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import dao.Baocao.BCDoanhThu_DAO;
import ui.Baocao.BCDoanhThuJPanel;
import ui.Baocao.BCDoanhThuJPanel;
import ui.Dangnhap.Dangnhap_UI;
import ui.Hethong.DoimatkhauJDialog;
import ui.Hethong.XemThongtinJFrame;
import ui.Hoadon.TaoHDJPanel;
import ui.Khachhang.QuanlyKHJPanel;
import ui.Khachhang.ThemKHJDialog;
import ui.Nguoidung.QuanlyNDJPanel;
import ui.Nguoidung.ThemNguoidungJDialog;
import ui.NhaCC.ThemNCCJDialog;
import ui.NhaCC.XemNCCJPanel;
import ui.Thongke.ThongkeDoanhthuJPanel;
import ui.Thongke.ThongkeHoadonJPanel;
import ui.Thongke.ThongkethuocHethanJPanel;
import ui.Thongke.ThongkethuocNhapJPanel;
import ui.Thuoc.KiemtraDVThuocJPanel;
import ui.Thuoc.KiemtraTTThuocJPanel;
import ui.Thuoc.KiemtradanhmucJPanel;
import ui.Thuoc.TimthuocJPanel;

public class Menu extends JFrame implements ActionListener{
	private static String ma;
	private JMenuBar menuAll;
	private JMenu mnMain;
	private JMenu mnThuoc;
	private JMenuItem mnitimThuoc;
	private JMenuItem mniKtDMThuoc;
	private JMenuItem mniKtTinhtrangThuoc;
	private JMenuItem mniKTDonviT;
	private JMenu mnHoadon;
	private JMenuItem mniTaohoadon;
	private JMenu mnKH;
	private JMenuItem mniThemKH;
	private JMenu mnNhacc;
	private JMenuItem mniThemNCC;
	private JMenuItem mniXemNCC;
	private JMenuItem mniXemKH;
	private JMenu mnQLyNV;
	private JMenuItem mniThemNV;
	private JMenuItem mniXemNV;
	private JMenu mnThongke;
	private JMenuItem mniTKDT;
	private JMenuItem mniTKTN;
	private JMenuItem mniTKThuocHH;
	private JMenuItem mniTKHoadon;
	private JMenu mnBaocao;
	private JMenuItem mniBCDT;
	private JMenuItem mniBCHD;
	private JMenu mnHethong;
	private JMenuItem mniDoiMK;
	private JMenuItem mniDangxuat;
	private JMenuItem mniThoat;
	private JPanel pnlAll;
	private JLabel lblTendangnhap;
	private JMenuItem mniXemthongtin;
	private String msnv;

	public Menu(String ma) {
		setTitle("===========QUẢN LÝ THUỐC===========");
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1000, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		msnv = ma;
		ImageIcon image = new ImageIcon(getClass().getResource("/image/icons8-clinic-64.png"));
		setIconImage(image.getImage());
		menuAll = new JMenuBar();
		menuAll.setBackground(Color.white);
		////
		mnMain = new JMenu();
		mnMain.setIcon(new ImageIcon(getClass().getResource("/image/squared-menu-24.png")));
		////Menu Thuốc
		mnThuoc = new JMenu("Thuốc");
		mnThuoc.setBackground(Color.white);
		mnThuoc.setFont(new Font("Arial", Font.BOLD, 18));
		//
		mnitimThuoc = new JMenuItem("Tìm Thuốc", new ImageIcon(getClass().getResource("/image/icons8-search-24.png")));
		mnitimThuoc.setFont(new Font("Arial", Font.BOLD, 16));
		//
		mniKtDMThuoc = new JMenuItem("Kiểm tra danh mục thuốc", new ImageIcon(getClass().getResource("/image/icons8-KTDMThuoc-24.png")));
		mniKtDMThuoc.setFont(new Font("Arial", Font.BOLD, 16));
		//
		mniKtTinhtrangThuoc = new JMenuItem("Kiểm tra tình trạng thuốc", new ImageIcon(getClass().getResource("/image/icons8-KTTTThuoc-24.png")));
		mniKtTinhtrangThuoc.setFont(new Font("Arial", Font.BOLD, 16));
		//
		mniKTDonviT = new JMenuItem("Kiểm tra đơn vị thuốc", new ImageIcon(getClass().getResource("/image/icons8-check-24.png")));
		mniKTDonviT.setFont(new Font("Arial", Font.BOLD, 16));
		mnThuoc.add(mnitimThuoc);
		mnThuoc.add(mniKtDMThuoc);
		mnThuoc.add(mniKtTinhtrangThuoc);
		mnThuoc.add(mniKTDonviT);
		////Menu Hóa đơn
		mnHoadon = new JMenu("Hóa đơn");
		mnHoadon.setFont(new Font("Arial", Font.BOLD, 18));
		//
		mniTaohoadon = new JMenuItem("Tạo hóa đơn", new ImageIcon(getClass().getResource("/image/icons8-TaoHD-24.png")));
		mniTaohoadon.setFont(new Font("Arial", Font.BOLD, 16));
		mnHoadon.add(mniTaohoadon);
		////Menu khách hàng
		mnKH = new JMenu("Khách hàng");
		mnKH.setFont(new Font("Arial", Font.BOLD, 18));
		mniThemKH = new JMenuItem("Thêm khách hàng", new ImageIcon(getClass().getResource("/image/icons8-add-24.png")));
		mniThemKH.setFont(new Font("Arial", Font.BOLD, 16));
		mniXemKH = new JMenuItem("Quản lý khách hàng", new ImageIcon(getClass().getResource("/image/icons8-people-24.png")));
		mniXemKH.setFont(new Font("Arial", Font.BOLD, 16));
		mnKH.add(mniThemKH);
		mnKH.add(mniXemKH);
		////Menu nhà cung cấp
		mnNhacc = new JMenu("Nhà cung cấp");
		mnNhacc.setFont(new Font("Arial", Font.BOLD, 18));
		mniThemNCC = new JMenuItem("Thêm nhà cung cấp", new ImageIcon(getClass().getResource("/image/icons8-add-24.png")));
		mniThemNCC.setFont(new Font("Arial", Font.BOLD, 16));
		mniXemNCC = new JMenuItem("Xem nhà cung cấp", new ImageIcon(getClass().getResource("/image/icons8-truck-24.png")));
		mniXemNCC.setFont(new Font("Arial", Font.BOLD, 16));
		mnNhacc.add(mniThemNCC);
		mnNhacc.add(mniXemNCC);
		///Menu quản lý nhân viên
		mnQLyNV = new JMenu("Quản lý nhân viên");
		mnQLyNV.setFont(new Font("Arial", Font.BOLD, 18));
		mniThemNV = new JMenuItem("Thêm nhân viên", new ImageIcon(getClass().getResource("/image/icons8-add-24.png")));
		mniThemNV.setFont(new Font("Arial", Font.BOLD, 16));
		mniXemNV = new JMenuItem("Xem nhân viên", new ImageIcon(getClass().getResource("/image/icons8-person-24.png")));
		mniXemNV.setFont(new Font("Arial", Font.BOLD, 16));
		mnQLyNV.add(mniXemNV);
		mnQLyNV.add(mniThemNV);
		////Menu Thống kê
		mnThongke = new JMenu("Thống kê");
		mnThongke.setFont(new Font("Arial", Font.BOLD, 18));
		mniTKDT = new JMenuItem("Thống kê doanh thu", new ImageIcon(getClass().getResource("/image/icons8-financial-growth-analysis-24.png")));
		mniTKDT.setFont(new Font("Arial", Font.BOLD, 16));
		mniTKTN = new JMenuItem("Thống kê thuốc nhập", new ImageIcon(getClass().getResource("/image/icons8-partially-shipped-24.png")));
		mniTKTN.setFont(new Font("Arial", Font.BOLD, 16));
		mniTKThuocHH = new JMenuItem("Thống kê thuốc hết hạn", new ImageIcon(getClass().getResource("/image/icons8-expired-24.png")));
		mniTKThuocHH.setFont(new Font("Arial", Font.BOLD, 16));
		mniTKHoadon = new JMenuItem("Thống kê hóa đơn", new ImageIcon(getClass().getResource("/image/icons8-sell-24.png")));
		mniTKHoadon.setFont(new Font("Arial", Font.BOLD, 16));
		mnThongke.add(mniTKDT);
		mnThongke.add(mniTKHoadon);
		mnThongke.add(mniTKThuocHH);
		mnThongke.add(mniTKTN);
		////Menu báo cáo
		mnBaocao  = new JMenu("Báo cáo");
		mnBaocao.setFont(new Font("Arial", Font.BOLD, 18));
		mniBCDT = new JMenuItem("Báo cáo doanh thu", new ImageIcon(getClass().getResource("/image/icons8-sales-performance-24.png")));
		mniBCDT.setFont(new Font("Arial", Font.BOLD, 16));
		mniBCHD = new JMenuItem("Báo cáo hóa đơn", new ImageIcon(getClass().getResource("/image/icons8-invoice-24.png")));
		mniBCHD.setFont(new Font("Arial", Font.BOLD, 16));
		mnBaocao.add(mniBCDT);
		////Menu hệ thống
		mnHethong = new JMenu("Hệ thống");
		mnHethong.setFont(new Font("Arial", Font.BOLD, 18));
		mniDoiMK = new JMenuItem("Đổi mật khẩu", new ImageIcon(getClass().getResource("/image/icons8-password-reset-24.png")));
		mniDoiMK.setFont(new Font("Arial", Font.BOLD, 16));
		mniDangxuat = new JMenuItem("Đăng xuất", new ImageIcon(getClass().getResource("/image/icons8-exit-24.png")));
		mniDangxuat.setFont(new Font("Arial", Font.BOLD, 16));
		mniXemthongtin = new JMenuItem("Xem thông tin", new ImageIcon(getClass().getResource("/image/icons8-view-details-24.png")));
		mniXemthongtin.setFont(new Font("Arial", Font.BOLD, 16));
		mniThoat = new JMenuItem("Thoát", new ImageIcon(getClass().getResource("/image/icons8-cancel-24.png")));
		mniThoat.setFont(new Font("Arial", Font.BOLD, 16));
		mnHethong.add(mniDoiMK);
		mnHethong.add(mniXemthongtin);
		mnHethong.add(mniDangxuat);
		mnHethong.add(mniThoat);
		////
		pnlAll = new JPanel();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)dim.getWidth();
		int height = (int)dim.getHeight();
//		System.out.println(width+ " " + height);
		pnlAll.setSize(width,height);
		pnlAll.setLayout(new BorderLayout());
		pnlAll.setBackground(Color.white);
//		JLabel wIcon = new JLabel(new ImageIcon(getClass().getResource("/image/download.jpg")));
//		pnlAll.add(wIcon);
		
		////Add
		menuAll.add(mnMain);
		menuAll.add(mnThuoc);
		menuAll.add(mnHoadon);
		menuAll.add(mnKH);
		menuAll.add(mnNhacc);
		menuAll.add(mnQLyNV);
		menuAll.add(mnThongke);
		menuAll.add(mnBaocao);
		menuAll.add(mnHethong);
//		menuAll.add(lblTendangnhap);
		setJMenuBar(menuAll);
		add(pnlAll);
		mniBCDT.addActionListener(this);
		mniBCHD.addActionListener(this);
		mniDangxuat.addActionListener(this);
		mniDoiMK.addActionListener(this);
		mniKtDMThuoc.addActionListener(this);
		mniKTDonviT.addActionListener(this);
		mniKtTinhtrangThuoc.addActionListener(this);
		mniTaohoadon.addActionListener(this);
		mniThemKH.addActionListener(this);
		mniThemNCC.addActionListener(this);
		mniThemNV.addActionListener(this);
		mnitimThuoc.addActionListener(this);
		mniThoat.addActionListener(this);
		mniTKDT.addActionListener(this);
		mniTKHoadon.addActionListener(this);
		mniTKThuocHH.addActionListener(this);
		mniTKTN.addActionListener(this);
		mniXemKH.addActionListener(this);
		mniXemNCC.addActionListener(this);
		mniXemNV.addActionListener(this);
		mniXemthongtin.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new Menu(ma).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(mnitimThuoc)) {
			chuyenManhinh(pnlAll, new TimthuocJPanel());
		} else {
			if (o.equals(mniThemKH)) {
				ThemKHJDialog themKH = new ThemKHJDialog();
				themKH.setAlwaysOnTop(true);
				themKH.setVisible(true);
			} else {
				if (o.equals(mniKtDMThuoc)) {
					chuyenManhinh(pnlAll, new KiemtradanhmucJPanel());
				} else {
					if (o.equals(mniKtTinhtrangThuoc)) {
						chuyenManhinh(pnlAll, new KiemtraTTThuocJPanel());
					} else {
						if (o.equals(mniKTDonviT)) {
							chuyenManhinh(pnlAll, new KiemtraDVThuocJPanel());
						} else {
							if (o.equals(mniThemNCC)) {
								ThemNCCJDialog themNCC_UI = new ThemNCCJDialog();
								themNCC_UI.setAlwaysOnTop(true);
								themNCC_UI.setVisible(true);
							} else {
								if (o.equals(mniTaohoadon)) {
									chuyenManhinh(pnlAll, new TaoHDJPanel(msnv));
								}else {
									if (o.equals(mniXemNCC)) {
										chuyenManhinh(pnlAll, new XemNCCJPanel());
									} else {
										if (o.equals(mniXemKH)) {
											chuyenManhinh(pnlAll, new QuanlyKHJPanel());
										} else {
											if (o.equals(mniThemNV)) {
												ThemNguoidungJDialog themND_UI = new ThemNguoidungJDialog();
												themND_UI.setAlwaysOnTop(true);
												themND_UI.setVisible(true);
											} else {
												if (o.equals(mniXemNV)) {
													chuyenManhinh(pnlAll, new QuanlyNDJPanel());
												} else {
													if (o.equals(mniDangxuat)) {
														setVisible(false);
														Dangnhap_UI dn_UI = new Dangnhap_UI();
														dn_UI.setAlwaysOnTop(true);
														dn_UI.setVisible(true);
													} else {
														if (o.equals(mniDoiMK)) {
															DoimatkhauJDialog doimk_UI = new DoimatkhauJDialog();
															doimk_UI.setAlwaysOnTop(true);
															doimk_UI.setVisible(true);
														} else {
															if (o.equals(mniThoat)) {
																dispose();
															}else if (o.equals(mniXemthongtin)) {
																XemThongtinJFrame xemUI = new XemThongtinJFrame();
																xemUI.setAlwaysOnTop(true);
																xemUI.setVisible(true);
															}else if (o.equals(mniTKTN)) {
																chuyenManhinh(pnlAll, new ThongkethuocNhapJPanel());
															}else if (o.equals(mniTKThuocHH)) {
																chuyenManhinh(pnlAll, new ThongkethuocHethanJPanel());
															}else if (o.equals(mniBCDT)) {
																chuyenManhinh(pnlAll, new BCDoanhThuJPanel(ma));
															}else if (o.equals(mniTKHoadon)) {
																chuyenManhinh(pnlAll, new ThongkeHoadonJPanel());
															}else if (o.equals(mniTKDT)) {
																chuyenManhinh(pnlAll, new ThongkeDoanhthuJPanel());
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	private void chuyenManhinh(JPanel pManhinh, JPanel pNew) {
		pnlAll.removeAll();
		pnlAll.setLayout(new BorderLayout());
		pnlAll.add(pNew);
		pnlAll.validate();
		pnlAll.repaint();
	}
}
