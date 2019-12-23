CREATE DATABASE QLThuoc
ON PRIMARY
(NAME ='QLThuoc_DATA',
FILENAME = 'G:\Nam\TL Đại Học\Phát triển ứng dụng\Quan Ly Thuoc\Data\QLThuoc_DATA.MDF',
SIZE=20,
MAXSIZE=40,
FILEGROWTH=1)
LOG ON
(NAME ='QLThuoc_LOG',
FILENAME = 'G:\Nam\TL Đại Học\Phát triển ứng dụng\Quan Ly Thuoc\Data\QLTHuoc_LOG.LDF',
SIZE=6,
MAXSIZE=8,
FILEGROWTH=1)
------
use QLThuoc
-----------
CREATE TABLE TaiKhoan(
MSNV nvarchar(30)NOT NULL PRIMARY KEY
, pass nvarchar(30) NOT NULL)
-----------
CREATE TABLE NguoiDung(
MSNV nvarchar(30)NOT NULL REFERENCES TaiKhoan(MSNV)
, HoTen NVARCHAR(30) NOT NULL
, gioitinh nvarchar(10) NOT NULL
,diachi nvarchar(50) NOT NULL
, chucvu nvarchar(10) NOT NULL
, PRIMARY KEY(MSNV))
--------------
CREATE TABLE NhaCungCap(
maNCC nvarchar(30)NOT NULL PRIMARY KEY
, tenNCC nvarchar(50)NOT NULL
, sdt nvarchar(50)
, email nvarchar(50) NOT NULL
,diachi nvarchar(100) NOT NULL)
-------------
CREATE TABLE DonViThuoc(
madonvi nvarchar(30) not null PRIMARY KEY,
tendonvi nvarchar(30) not null)
------------
CREATE TABLE Nuoc(
manuoc nvarchar(20) not null PRIMARY KEY
, tennuoc nvarchar(20) not null )
-----------
CREATE TABLE Thuoc(
mathuoc nvarchar(30)NOT NULL PRIMARY KEY,
tenthuoc nvarchar(30) not null,
madonvi nvarchar(30) not null REFERENCES DonViThuoc(madonvi),
dongia MONEY NOT NULL,
maNCC nvarchar(30) not null REFERENCES NhaCungCap(maNCC),
manuoc nvarchar(20) not null REFERENCES Nuoc(manuoc),
danhmucthuoc nvarchar(30) NOT NULL,
tinhtrang nvarchar(10) not null,
ngaynhap date not null,
ngayhetHan date not null)
-------------
CREATE TABLE KhachHang(
maKH nvarchar(30) not null primary key
, hotenKH nvarchar(30) not null
,sdt nvarchar(50) NOT NULL
, diachi nvarchar(50) NOT NULL) 
-------------
CREATE TABLE HoaDon(
maHD nvarchar(30)NOT NULL PRIMARY KEY
, MSNV nvarchar(30)NOT NULL REFERENCES NguoiDung(MSNV)
, maKH nvarchar(30) NOT NULL REFERENCES KhachHang(maKH)
, ngayban date)
-------------
CREATE TABLE ChiTietHoaDon(
maHD nvarchar(30) NOT NULL REFERENCES HoaDon(maHD)
, mathuoc nvarchar(30) NOT NULL REFERENCES Thuoc(mathuoc)
, soluong int, PRIMARY KEY(maHD,mathuoc))
---------------
create table thongtindangnhap(
manv nvarchar(30) not null,
passw nvarchar(30),
hoten nvarchar(30),
chucVu nvarchar(10) not null
)
---------------
insert TaiKhoan values ('NV01',123456)
insert TaiKhoan values ('NV02',123456)
insert TaiKhoan values ('NV03',123456)
insert TaiKhoan values ('NV04',123456)
insert TaiKhoan values ('NV05',123456)
insert TaiKhoan values ('NV06',123456)
insert TaiKhoan values ('NV07',123456)
insert TaiKhoan values ('NV08',123456)
insert TaiKhoan values ('NV09',123456)
insert TaiKhoan values ('NV10',123456)
insert TaiKhoan values ('NV11',123456)
insert TaiKhoan values ('NV12',123456)
insert TaiKhoan values ('NV13',123456)
insert TaiKhoan values ('NV14',123456)
insert TaiKhoan values ('NV15',123456)
insert TaiKhoan values ('NV16',123456)
insert TaiKhoan values ('NV17',123456)
insert TaiKhoan values ('NV18',123456)
insert TaiKhoan values ('NV19',123456)
insert TaiKhoan values ('NV20',123456)
insert TaiKhoan values ('NV21',123456)
insert TaiKhoan values ('NV22',123456)
insert TaiKhoan values ('NV23',123456)
insert TaiKhoan values ('NV24',123456)
insert TaiKhoan values ('NV25',123456)
insert TaiKhoan values ('NV26',123456)
insert TaiKhoan values ('NV27',123456)
insert TaiKhoan values ('NV28',123456)
insert TaiKhoan values ('NV29',123456)
insert TaiKhoan values ('NV30',123456)
---------------
insert NguoiDung values ('NV01', N'Nguyễn Trường Nam',  'Nam',N'12/04/6 Quận 12, Phường 3, Thành phố HCM','Admin')
insert NguoiDung values ('NV02', N'Trần Đức Toàn', 'Nam', N'12/04/6 Quận Gò Vấp, Phường 6, Thành phố HCM','Admin')
insert NguoiDung values ('NV03', N'Hoàng Tiến Dũng','Nam',N'12/04/6 Quận 9, Phường 5, Thành phố HCM',N'Admin')
insert NguoiDung values ('NV04', N'Mai Quốc Bảo', N'Nữ',  N'12/04/6 Quận 12, Phường 3, Thành phố HCM',N'Quản lý')
insert NguoiDung values ('NV05', N'Phan Thị Minh Châu', 'Nam',     N'12/04/6 Quận Gò Vấp, Phường 6, Thành phố HCM',N'Admin')
insert NguoiDung values ('NV06', N'Nguyễn Thành Chính', N'Nữ',      N'12/04/6 Quận 9, Phường 5, Thành phố HCM',N'Nhân viên')
insert NguoiDung values ('NV07', N'Hà Quốc Cường', 'Nam',    N'12/04/6 Quận 12, Phường 3, Thành phố HCM',N'Quản lý')
insert NguoiDung values ('NV08', N'Nguyễn Chí Cường', 'Nam',       N'12/04/6 Quận Gò Vấp, Phường 6, Thành phố HCM',N'Admin')
insert NguoiDung values ('NV09', N'Võ Chí Cường', 'Nam',	  N'12/04/6 Quận 9, Phường 5, Thành phố HCM',N'Nhân viên')
insert NguoiDung values ('NV10', N'Lâm Chánh Đại ', N'Nữ',         N'12/04/6 Quận 12, Phường 3, Thành phố HCM',N'Quản lý')
insert NguoiDung values ('NV11', N'Nguyễn Lê Thành Đạt', 'Nam',     N'12/04/6 Quận Gò Vấp, Phường 6, Thành phố HCM',N'Admin')
insert NguoiDung values ('NV12', N'Võ Thành Đoàn', 'Nam',      N'12/04/6 Quận 9, Phường 5, Thành phố HCM',N'Nhân viên')
insert NguoiDung values ('NV14', N'Nguyễn Quốc Duy', 'Nam',       N'12/04/6 Quận 12, Phường 3, Thành phố HCM',N'Quản lý')
insert NguoiDung values ('NV15', N'Huỳnh Trần Công Hậu', 'Nam',   N'12/04/6 Quận Gò Vấp, Phường 6, Thành phố HCM',N'Admin')
insert NguoiDung values ('NV16', N'Lê Minh Hậu', 'Nam',       N'12/04/6 Quận 9, Phường 5, Thành phố HCM',N'Nhân viên')
insert NguoiDung values ('NV17', N'Lê Kế Hiền', 'Nam',     N'12/04/6 Quận 12, Phường 3, Thành phố HCM',N'Quản lý')
insert NguoiDung values ('NV18', N'Trần Đại Hiệp', N'Nữ',        N'12/04/6 Quận Gò Vấp, Phường 6, Thành phố HCM',N'Admin')
insert NguoiDung values ('NV19', N'Nguyễn Trung Hiếu', 'Nam',      N'12/04/6 Quận 9, Phường 5, Thành phố HCM',N'Nhân viên')
insert NguoiDung values ('NV20', N'Ngô Minh Hoàng', N'Nữ',       N'12/04/6 Quận 12, Phường 3, Thành phố HCM',N'Quản lý')
insert NguoiDung values ('NV21', N'Nguyễn Thế Hùng', N'Nam',      N'12/04/6 Quận Gò Vấp, Phường 6, Thành phố HCM',N'Admin')
insert NguoiDung values ('NV22', N'Đỗ Xuân Hưng', N'Nữ',         N'12/04/6 Quận 9, Phường 5, Thành phố HCM',N'Nhân viên')
insert NguoiDung values ('NV23', N'Nguyễn Nhật Huy', N'Nữ',       N'12/04/6 Quận 12, Phường 3, Thành phố HCM',N'Quản lý')
insert NguoiDung values ('NV24', N'Đặng Thụy Mỹ Huyền', N'Nữ',        N'12/04/6 Quận Gò Vấp, Phường 6, Thành phố HCM',N'Admin')
insert NguoiDung values ('NV25', N'Nguyễn Thị Ngọc Huyền', N'Nữ',     N'12/04/6 Quận 9, Phường 5, Thành phố HCM',N'Nhân viên')
insert NguoiDung values ('NV26', N'Phạm Minh Khoa', N'Nữ',       N'12/04/6 Quận 12, Phường 3, Thành phố HCM',N'Quản lý')
insert NguoiDung values ('NV27', N'Lê Đức Linh', N'Nữ',        N'12/04/6 Quận Gò Vấp, Phường 6, Thành phố HCM',N'Admin')
insert NguoiDung values ('NV28', N'Trần Ngọc Long', N'Nữ',       N'12/04/6 Quận 9, Phường 5, Thành phố HCM',N'Nhân viên')
--------------
insert NhaCungCap values ('NCC01', N'Cong Ty TNHH Lê Hào', '037190219', 'sales.lehaoco@gmail.com', N'26/36 Đường Thượng Hội, Xã Tân Hội, H. Đan Phượng Hà Nội')
insert NhaCungCap values ('NCC02',N'Công Ty Cổ Phần Difoco','066857787','info@difoco.com',N'289 Đinh Bộ Lĩnh, P. 26, Q. Bình Thạnh, Tp. Hồ Chí Minh')
insert NhaCungCap values ('NCC03',N'Công Ty CP Nông Nghiệp Công Nghệ Cao Thăng Long','0972339095','cagaileosadu@gmail.com',N'Xã Đại Yên, Chương Mỹ, Hà Nội')
insert NhaCungCap values ('NCC04', N'TẬP ĐOÀN VINGROUP-CÔNG TY CP', '0928421998', 'sales.lehaoco@gmail.com', N'26/36 Đường Thượng Hội, Xã Tân Hội, H. Đan Phượng Hà Nội')
insert NhaCungCap values ('NCC05',N'CÔNG TY CP ĐẦU TƯ THẾ GIỚI DI ĐỘNG','0929321998','info@difoco.com',N'289 Đinh Bộ Lĩnh, P. 26, Q. Bình Thạnh, Tp. Hồ Chí Minh')
insert NhaCungCap values ('NCC06',N'CÔNG TY CP SỮA VIỆT NAM','0889641998','cagaileosadu@gmail.com',N'Xã Đại Yên, Chương Mỹ, Hà Nội')
insert NhaCungCap values ('NCC07', N'CÔNG TY CP TẬP ĐOÀN VÀNG BẠC ĐÁ QUÝ DOJI', '0911.33.1998', 'sales.lehaoco@gmail.com', N'26/36 Đường Thượng Hội, Xã Tân Hội, H. Đan Phượng Hà Nội')
insert NhaCungCap values ('NCC08',N'CÔNG TY CP ÔTÔ TRƯỜNG HẢI','0946031998','info@difoco.com',N'289 Đinh Bộ Lĩnh, P. 26, Q. Bình Thạnh, Tp. Hồ Chí Minh')
insert NhaCungCap values ('NCC09',N'CÔNG TY CP TẬP ĐOÀN HÒA PHÁT','0916391998','cagaileosadu@gmail.com',N'Xã Đại Yên, Chương Mỹ, Hà Nội')
insert NhaCungCap values ('NCC10', N'CÔNG TY CP FPT', '0911711998','sales.lehaoco@gmail.com', N'26/36 Đường Thượng Hội, Xã Tân Hội, H. Đan Phượng Hà Nội')
insert NhaCungCap values ('NCC11',N'CÔNG TY CP HÀNG KHÔNG VIETJET','0845671998','info@difoco.com',N'289 Đinh Bộ Lĩnh, P. 26, Q. Bình Thạnh, Tp. Hồ Chí Minh')
insert NhaCungCap values ('NCC12',N'NGÂN HÀNG TMCP VIỆT NAM THỊNH VƯỢNG','0708041998','cagaileosadu@gmail.com',N'Xã Đại Yên, Chương Mỹ, Hà Nội')
insert NhaCungCap values ('NCC13', N'CÔNG TY CP TẬP ĐOÀN MASAN', '0917561998', 'saleslehaoco@gmail.com', N'26/36 Đường Thượng Hội, Xã Tân Hội, H. Đan Phượng Hà Nội')
insert NhaCungCap values ('NCC14',N'TỔNG CÔNG TY CP BIA RƯỢU NƯỚC GIẢI KHÁT SÀI GÒN','0389221998','info@difoco.com',N'289 Đinh Bộ Lĩnh, P. 26, Q. Bình Thạnh, Tp. Hồ Chí Minh')
insert NhaCungCap values ('NCC15',N'NGÂN HÀNG TMCP SÀI GÒN','0353711998','cagaileosadu@gmail.com',N'Xã Đại Yên, Chương Mỹ, Hà Nội')
insert NhaCungCap values ('NCC16', N'CÔNG TY CP XÂY DỰNG COTECCONS', '	0948651998', 'sales.lehaoco@gmail.com', N'26/36 Đường Thượng Hội, Xã Tân Hội, H. Đan Phượng Hà Nội')
insert NhaCungCap values ('NCC17',N'CÔNG TY CP TẬP ĐOÀN HOA SEN','0915431998','info@difoco.com',N'289 Đinh Bộ Lĩnh, P. 26, Q. Bình Thạnh, Tp. Hồ Chí Minh')
insert NhaCungCap values ('NCC18',N'NGÂN HÀNG TMCP KỸ THƯƠNG VIỆT NAM','0915781998','cagaileosadu@gmail.com',N'Xã Đại Yên, Chương Mỹ, Hà Nội')
insert NhaCungCap values ('NCC19', N'NGÂN HÀNG TMCP SÀI GÒN THƯƠNG TÍN', '0914611998', 'sales.lehaoco@gmail.com', N'26/36 Đường Thượng Hội, Xã Tân Hội, H. Đan Phượng Hà Nội')
insert NhaCungCap values ('NCC20',N'NGÂN HÀNG TMCP QUÂN ĐỘI','0914651998','info@difoco.com',N'289 Đinh Bộ Lĩnh, P. 26, Q. Bình Thạnh, Tp. Hồ Chí Minh')
insert NhaCungCap values ('NCC21',N'NGÂN HÀNG TMCP Á CHÂU','0915721998','cagaileosadu@gmail.com',N'Xã Đại Yên, Chương Mỹ, Hà Nội')
insert NhaCungCap values ('NCC22', N'NGÂN HÀNG TMCP SÀI GÒN-HÀ NỘI', '0915401998', 'saleslehaoco@gmail.com', N'26/36 Đường Thượng Hội, Xã Tân Hội, H. Đan Phượng Hà Nội')
insert NhaCungCap values ('NCC23',N'CÔNG TY CP TẬP ĐOÀN THÉP NGUYỄN MINH','0915471998','info@difoco.com',N'289 Đinh Bộ Lĩnh, P. 26, Q. Bình Thạnh, Tp. Hồ Chí Minh')
insert NhaCungCap values ('NCC24',N'CÔNG TY CP TẬP ĐOÀN THÀNH CÔNG','0914961998','cagaileosadu@gmail.com',N'Xã Đại Yên, Chương Mỹ, Hà Nội')
insert NhaCungCap values ('NCC25', N'CÔNG TY CP THƯƠNG MẠI THÁI HƯNG', '0915751998', 'sales.lehaoco@gmail.com', N'26/36 Đường Thượng Hội, Xã Tân Hội, H. Đan Phượng Hà Nội')
insert NhaCungCap values ('NCC26',N'CÔNG TY CP Y DƯỢC PHẨM VIMEDIMEX','0914621998','info@difoco.com',N'289 Đinh Bộ Lĩnh, P. 26, Q. Bình Thạnh, Tp. Hồ Chí Minh')
insert NhaCungCap values ('NCC27',N'CÔNG TY CP HYUNDAI THÀNH CÔNG VIỆT NAM','0833261998','cagaileosadu@gmail.com',N'Xã Đại Yên, Chương Mỹ, Hà Nội')
insert NhaCungCap values ('NCC28', N'CÔNG TY CP DỊCH VỤ TỔNG HỢP SÀI GÒN', '0829561998', 'sales.lehaoco@gmail.com', N'26/36 Đường Thượng Hội, Xã Tân Hội, H. Đan Phượng Hà Nội')
insert NhaCungCap values ('NCC29',N'CÔNG TY CP ĐẠI TÂN VIỆT','0789731998','info@difoco.com',N'289 Đinh Bộ Lĩnh, P. 26, Q. Bình Thạnh, Tp. Hồ Chí Minh')
insert NhaCungCap values ('NCC30',N'CÔNG TY CP BÁN LẺ KỸ THUẬT SỐ FPT (FPT RETAIL)','0923821998','cagaileosadu@gmail.com',N'Xã Đại Yên, Chương Mỹ, Hà Nội')

-------------
insert DonViThuoc values ('DV12',N'Hộp')
insert DonViThuoc values ('DV13',N'Chai')
insert DonViThuoc values ('DV14',N'Lọ')
insert DonViThuoc values ('DV15',N'Vị')
insert DonViThuoc values ('DV16',N'Viên')
-------------
insert Nuoc values ('N01','Viet Nam')
insert Nuoc values ('N02','American')
insert Nuoc values ('N03','France')
insert Nuoc values ('N04','England')
insert Nuoc values ('N05','Japan')
insert Nuoc values ('N06','Laos')
insert Nuoc values ('N07','Thailand')
insert Nuoc values ('N08','China')
insert Nuoc values ('N09','India')
insert Nuoc values ('N10','Russia')
insert Nuoc values ('N11','Spain')
insert Nuoc values ('N12','Brunei')
insert Nuoc values ('N13','Malaysia')
insert Nuoc values ('N14','Myanmar')
insert Nuoc values ('N15','Panama')
insert Nuoc values ('N16','Ecuador')
insert Nuoc values ('N17','Haiti')
insert Nuoc values ('N18','Cong hoa Dominica')
insert Nuoc values ('N19','Nepal')
insert Nuoc values ('N20','Sri Lanka')
insert Nuoc values ('N21','Iran')
insert Nuoc values ('N22','Burundi')
insert Nuoc values ('N23','Somalia')


-----------
insert KhachHang values('KH01',N'Nguyễn Văn Hoàng', '0123456789', N'22/45/5 Đường Quang Trung, Quân 3, Tp.HCM')
insert KhachHang values('KH02',N'Nguyễn Thị Yến', '0123234524', N'11/2/5 Đường Nguyễn Huệ, Quận 1, Tp.HCM')
insert KhachHang values('KH03',N'Bùi Thị Vân', '052416952', N'3/1/9 Đường Trần Duy Hưng, Quận 12, Tp.HCM')
insert KhachHang values('KH04',N'Bùi Thị Vy', '036874125', N'22/45/5 Đường Quang Trung, Quân 3, Tp.HCM')
insert KhachHang values('KH05',N'Cát Tường', '0234456732', N'11/2/5 Đường Nguyễn Huệ, Quận 1, Tp.HCM')
insert KhachHang values('KH06',N'Nguyễn Hoàng Tiến Dũng', N'073457424', N'3/1/9 Đường Trần Duy Hưng, Quận 12, Tp.HCM')
insert KhachHang values('KH07',N'Vũ Văn Hoàng', '0356789823', N'22/45/5 Đường Quang Trung, Quân 3, Tp.HCM')
insert KhachHang values('KH08',N'Tạ Thị Quỳnh', '03452456', N'11/2/5 Đường Nguyễn Huệ, Quận 1, Tp.HCM')
insert KhachHang values('KH09',N'Trịnh Thị Xường', '15605614', N'3/1/9 Đường Trần Duy Hưng, Quận 12, Tp.HCM')
insert KhachHang values('KH10',N'Phan Văn Tài', '0123456789', N'22/45/5 Đường Quang Trung, Quân 3, Tp.HCM')
insert KhachHang values('KH11',N'Hoàng Hữu Anh', '9875643210', N'11/2/5 Đường Nguyễn Huệ, Quận 1, Tp.HCM')
insert KhachHang values('KH12',N'Đinh Văn Hữu', '15605614', N'3/1/9 Đường Trần Duy Hưng, Quận 12, Tp.HCM')
insert KhachHang values('KH13',N'Nguyễn Văn Nhật', '0123456789', N'22/45/5 Đường Quang Trung, Quân 3, Tp.HCM')
insert KhachHang values('KH14',N'Nguyễn Tường Vân', '9875643210', N'11/2/5 Đường Nguyễn Huệ, Quận 1, Tp.HCM')
insert KhachHang values('KH15',N'Lò Văn Lợi', '15605614', N'3/1/9 Đường Trần Duy Hưng, Quận 12, Tp.HCM')
insert KhachHang values('KH16',N'Vũ Văn Nhi', '0123456789', N'22/45/5 Đường Quang Trung, Quân 3, Tp.HCM')
insert KhachHang values('KH17',N'Hồ Văn Hương', '9875643210', N'11/2/5 Đường Nguyễn Huệ, Quận 1, Tp.HCM')
insert KhachHang values('KH18',N'Trịnh Thị Kim Yến', '15605614', N'3/1/9 Đường Trần Duy Hưng, Quận 12, Tp.HCM')
insert KhachHang values('KH19',N'Vũ Văn Linh', '0123456789', N'22/45/5 Đường Quang Trung, Quân 3, Tp.HCM')
insert KhachHang values('KH20',N'Nguyễn Bảo Ngọc', '9875643210', N'11/2/5 Đường Nguyễn Huệ, Quận 1, Tp.HCM')
insert KhachHang values('KH21',N'Đỗ Văn Uyên', '15605614', N'3/1/9 Đường Trần Duy Hưng, Quận 12, Tp.HCM')
insert KhachHang values('KH22',N'Nguyễn Băng Tâm', '0123456789', N'22/45/5 Đường Quang Trung, Quân 3, Tp.HCM')
insert KhachHang values('KH23',N'Nguyễn Thanh Tâm', '9875643210', N'11/2/5 Đường Nguyễn Huệ, Quận 1, Tp.HCM')
insert KhachHang values('KH24',N'Vũ Kim Huyền', '15605614', N'3/1/9 Đường Trần Duy Hưng, Quận 12, Tp.HCM')
insert KhachHang values('KH25',N'Đỗ Văn Thùy', '0123456789', N'22/45/5 Đường Quang Trung, Quân 3, Tp.HCM')
insert KhachHang values('KH26',N'Trường Văn Thùy', '9875643210', N'11/2/5 Đường Nguyễn Huệ, Quận 1, Tp.HCM')
insert KhachHang values('KH27',N'Nguyễn Văn Tình', '15605614', N'3/1/9 Đường Trần Duy Hưng, Quận 12, Tp.HCM')
insert KhachHang values('KH28',N'Lê Trọng Khôi', '0123456789', N'22/45/5 Đường Quang Trung, Quân 3, Tp.HCM')
insert KhachHang values('KH29',N'Lê Đức Thọ', '9875643210', N'11/2/5 Đường Nguyễn Huệ, Quận 1, Tp.HCM')
insert KhachHang values('KH30',N'Nguyễn Văn Công', '15605614', N'3/1/9 Đường Trần Duy Hưng, Quận 12, Tp.HCM')
-------------
--CREATE TABLE Thuoc(
--mathuoc nvarchar(30)NOT NULL PRIMARY KEY,
--tenthuoc nvarchar(30) not null,
--madonvi nvarchar(30) not null REFERENCES DonViThuoc(madonvi),
--dongia MONEY NOT NULL,
--maNCC nvarchar(30) not null REFERENCES NhaCungCap(maNCC),
--manuoc nvarchar(20) not null REFERENCES Nuoc(manuoc),
--danhmucthuoc nvarchar(30) NOT NULL,
--tinhtrang nvarchar(10) not null)

insert Thuoc values('T01','OTiV 30VQ','DV14','330000','NCC01', 'N01', N'Theo đơn', N'Còn', '2019-12-12', '2020-12-20')
insert Thuoc values('T02','Panadol Extra','DV12','50000','NCC02','N02', N'Không theo đơn', N'Còn', '2019-01-01', '2020-12-20')
insert Thuoc values('T03','Fexofenadine','DV15','4000000','NCC03', 'N04', N'Theo đơn', N'Còn', '2018-12-22', '2020-12-20')
insert Thuoc values('T04','Vitamin','DV15','400000','NCC04', 'N05', N'Theo đơn', N'Hết', '2019-04-05', '2020-12-20')
insert Thuoc values('T05','Eumovate cream 30VQ','DV14','440000','NCC05', 'N01', N'Theo đơn', N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T06','Prenatal','DV12','50000','NCC06','N02', N'Không theo đơn', N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T07','Viabiovit','DV15','4000000','NCC07', 'N03', N'Theo đơn', N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T08','Acetylcystein 200mg','DV15','400000','NCC08', 'N05', N'Theo đơn', N'Hết', '2019-04-05', '2020-12-20')
insert Thuoc values('T09','Broncho-Vaxom Children','DV14','330000','NCC09', 'N01', N'Theo đơn', N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T10','Contractubex','DV12','50000','NCC10','N02', N'Không theo đơn' ,N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T11','KSol','DV15','4000000','NCC11', 'N03', N'Theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T12','Promethazin 2','DV15','400000','NCC12', 'N05', N'Theo đơn',N'Hết', '2019-04-05', '2020-12-20')
insert Thuoc values('T13','Eumovate cream 5g','DV14','330000','NCC13', 'N01', N'Theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T14','Diflucan 150mg','DV12','50000','NCC14','N02', N'Không theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T15','Genk','DV15','4000000','NCC15', 'N03', N'Theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T16','Bepanthen 30g','DV15','400000','NCC16', 'N05', N'Theo đơn',N'Hết', '2019-04-05', '2020-12-20')
insert Thuoc values('T17','Omega 3','DV14','330000','NCC17', 'N01', N'Theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T18','Safaria','DV12','50000','NCC15','N02', N'Không theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T20','Acular','DV15','4000000','NCC11', 'N03', N'Theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T21','Acular','DV15','400000','NCC27', 'N05', N'Theo đơn',N'Hết', '2019-04-05', '2020-12-20')
insert Thuoc values('T22','A.D.O','DV14','330000','NCC18', 'N01', N'Theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T23','Albendazol 400mg','DV12','50000','NCC19','N02', N'Không theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T24','Acyclovir 200mg','DV15','4000000','NCC20', 'N03', N'Theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T25','Aldactone','DV15','400000','NCC21', 'N05', N'Theo đơn',N'Hết', '2019-04-05', '2020-12-20')
insert Thuoc values('T26','Alpha chymotrypsin 4 2mg','DV14','330000','NCC22', 'N01', N'Theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T27','Alverin citrat 40mg','DV12','50000','NCC23','N02', N'Không theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T28','Fexofenadine','DV15','4000000','NCC25', 'N03', N'Theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T29','Amlodipine AM10','DV15','400000','NCC28', 'N05', N'Theo đơn',N'Hết', '2019-04-05', '2020-12-20')
insert Thuoc values('T30','Albendazole ABZ 400','DV14','330000','NCC27', 'N01', N'Theo đơn',N'Còn', '2019-04-05', '2020-12-20')
insert Thuoc values('T31','Aminoplasmal hepa','DV12','50000','NCC25','N02', N'Không theo đơn', N'Còn', '2019-04-05', '2020-12-20')
-------------
insert HoaDon values ('HD01','NV06','KH01','2019/6/10')
insert HoaDon values ('HD02','NV09','KH02','2019/6/10')
insert HoaDon values ('HD03','NV12','KH03','2019/6/10')
insert HoaDon values ('HD04','NV12','KH04','2019/6/10')
insert HoaDon values ('HD05','NV09','KH05','2019/6/10')
insert HoaDon values ('HD06','NV06','KH06','2019/6/10')
insert HoaDon values ('HD07','NV09','KH07','2019/6/10')
insert HoaDon values ('HD08','NV10','KH08','2019/6/10')
insert HoaDon values ('HD09','NV12','KH09','2019/6/10')
insert HoaDon values ('HD10','NV09','KH10','2019/6/10')
insert HoaDon values ('HD11','NV12','KH11','2019/6/10')
insert HoaDon values ('HD12','NV09','KH12','2019/6/10')
insert HoaDon values ('HD13','NV06','KH13','2019/6/10')
insert HoaDon values ('HD14','NV15','KH14','2019/6/10')
insert HoaDon values ('HD15','NV15','KH15','2019/6/10')
insert HoaDon values ('HD16','NV19','KH16','2019/6/10')
insert HoaDon values ('HD17','NV22','KH17','2019/6/10')
insert HoaDon values ('HD18','NV25','KH18','2019/6/10')
--------------
insert ChiTietHoaDon values ('HD01','T01',1)
insert ChiTietHoaDon values ('HD01','T02',2)
insert ChiTietHoaDon values ('HD01','T03',1)

insert ChiTietHoaDon values ('HD02','T04',1)
insert ChiTietHoaDon values ('HD02','T05',1)
insert ChiTietHoaDon values ('HD02','T06',2)

insert ChiTietHoaDon values ('HD03','T09',1)
insert ChiTietHoaDon values ('HD03','T08',1)
insert ChiTietHoaDon values ('HD03','T10',1)

insert ChiTietHoaDon values ('HD04','T11',5)
insert ChiTietHoaDon values ('HD04','T12',2)
insert ChiTietHoaDon values ('HD04','T13',1)

insert ChiTietHoaDon values ('HD05','T14',1)
insert ChiTietHoaDon values ('HD05','T15',1)
insert ChiTietHoaDon values ('HD05','T16',2)

insert ChiTietHoaDon values ('HD06','T17',1)
insert ChiTietHoaDon values ('HD06','T18',1)
insert ChiTietHoaDon values ('HD06','T19',1)

insert ChiTietHoaDon values ('HD07','T20',5)
insert ChiTietHoaDon values ('HD07','T21',2)
insert ChiTietHoaDon values ('HD07','T22',1)

insert ChiTietHoaDon values ('HD08','T23',1)
insert ChiTietHoaDon values ('HD08','T24',1)
insert ChiTietHoaDon values ('HD08','T25',2)

insert ChiTietHoaDon values ('HD09','T26',1)
insert ChiTietHoaDon values ('HD09','T27',1)
insert ChiTietHoaDon values ('HD09','T28',1)

insert ChiTietHoaDon values ('HD10','T21',5)
insert ChiTietHoaDon values ('HD10','T22',2)
insert ChiTietHoaDon values ('HD10','T23',1)

insert ChiTietHoaDon values ('HD11','T10',1)
insert ChiTietHoaDon values ('HD11','T21',1)
insert ChiTietHoaDon values ('HD11','T23',2)

insert ChiTietHoaDon values ('HD12','T23',1)
insert ChiTietHoaDon values ('HD12','T22',1)
insert ChiTietHoaDon values ('HD12','T24',1)

insert ChiTietHoaDon values ('HD13','T01',5)
insert ChiTietHoaDon values ('HD13','T02',2)
insert ChiTietHoaDon values ('HD13','T03',1)

insert ChiTietHoaDon values ('HD14','T04',1)
insert ChiTietHoaDon values ('HD14','T05',1)
insert ChiTietHoaDon values ('HD14','T06',2)

insert ChiTietHoaDon values ('HD15','T07',1)
insert ChiTietHoaDon values ('HD15','T08',1)
insert ChiTietHoaDon values ('HD15','T09',1)

insert ChiTietHoaDon values ('HD16','T10',5)
insert ChiTietHoaDon values ('HD16','T11',2)
insert ChiTietHoaDon values ('HD16','T12',1)

insert ChiTietHoaDon values ('HD17','T13',1)
insert ChiTietHoaDon values ('HD17','T14',1)
insert ChiTietHoaDon values ('HD17','T15',2)

insert ChiTietHoaDon values ('HD18','T16',1)
insert ChiTietHoaDon values ('HD18','T17',1)
insert ChiTietHoaDon values ('HD18','T18',1)
