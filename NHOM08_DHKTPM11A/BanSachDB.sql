
USE master
Go

CREATE DATABASE NHOM08_DHKTPM11A
go


use NHOM08_DHKTPM11A
Go

--------

create table TaiKhoan
(
	maTK nvarchar(50) not null constraint "pk_maTK" primary key,
	tenTK nvarchar(50) not null unique,
	matKhau nvarchar(50) not null,
	quyen int not null constraint "ck_quyen" check(quyen=1 or quyen =2)
)
Go

-- tạo bảng khách hàng

create table KhachHang
(
	maKH nvarchar(50) not null constraint "pk_maKH" primary key , 
	tenKH nvarchar(70) not null , 
	cMND nvarchar(15) not null unique, 
	gioiTinh nvarchar(4) not null constraint "ck_gtkh" check (gioiTinh = 'Nam' or gioiTinh = N'Nữ' or gioiTinh = N'Khác') ,
	sDT nvarchar(50) not null ,
	diaChi nvarchar(50) ,
	email nvarchar(50) ,
	constraint "fk_maTKKH" foreign key (maKH) references TaiKhoan(maTK) ON DELETE CASCADE	ON UPDATE CASCADE
)
Go

-- tạo bảng người quản lý

create table QuanTriVien
(
	maQTV nvarchar(50) not null constraint "pk_maQTV" primary key , 
	tenQTV nvarchar(70) not null , 
	cMNDQTV nvarchar(15) not null unique, 
	gioiTinhQTV nvarchar(4) not null constraint "ck_gtQTV" check (gioiTinhQTV = 'Nam' or gioiTinhQTV = N'Nữ' or gioiTinhQTV = N'khác'),
	sDTQTV nvarchar(50) not null,
	diaChiQTV nvarchar(50) ,
	constraint "fk_maTKQTV" foreign key (maQTV) references TaiKhoan(maTK) ON DELETE CASCADE	ON UPDATE CASCADE
)
Go

-- tạo bảng sách

create table Sach
(
	maSach nvarchar(50) not null constraint "pk_maS" primary key,
	tenSach nvarchar(50) not null ,
	nXB nvarchar(50) not null,
	namPH int not null,
	tacGia nvarchar(50) not null,
	gia money not null constraint "ck_giaS" check(gia>0),
	theLoai nvarchar(50) not null,
	hinh nvarchar(50) ,
	soLuong int
)
Go

-- Tạo bảng hóa đơn
create table HoaDon
(
	maHD nvarchar(50)  not null constraint "pk_maHD" primary key,
	maKH nvarchar(50) not null constraint "fk_maKHMua" foreign key(maKH) references KhachHang(maKH), 
	ngayMua nvarchar(50) not null,
	diaChi nvarchar(50) not null,
	sDT nvarchar(50) not null,
	email nvarchar(50) not null,
	tongGia money not null
)
Go

-- tạo bảng Chi tiết hóa đơn

create table ChiTietHD
(
	maCTHD int identity(1,1) not null,
	maHD nvarchar(50) not null constraint "fk_maCTHD" foreign key (maHD) references HoaDon(maHD) ON DELETE CASCADE ON UPDATE  CASCADE,
	maSach nvarchar(50) not null constraint "fk_maSachmua" foreign key (maSach) references Sach(maSach),
	soLuong int not null ,
	
)

Go


insert into Sach values
('S001',N'Dạy con học nói',N'NXB Thanh niên',2017,'Leo',120000,N'Giáo dục', 'images/1.png',1),
('S002',N'Tro tàn trong gió',N'NXB Văn học',2017,'Kathleen',125000,N'Văn học', 'images/2.png',1),
('S003',N'Ai rồi cũng khác',N'NXB Văn học',2017,'Hamlet Trương',115000,N'Văn học', 'images/3.png',1),
('S004',N'Vợ có thuật của vợ',N'NXB Văn học',2017,'Dư San San',215000,N'Văn học', 'images/4.png',1),
('S005',N'Hôn lễ tháng 3',N'v',2017,'Tào Đình',175000,N'Văn học', 'images/5.png',1),
('S006',N'Nhật ký của ngày mai',N'NXB Văn học',2017,'Ahem',115000,N'Văn học', 'images/6.png',1),
('S007',N'Ngay qua bóng ngày',N'NXB Tổng hợp',2017,N'Lê Minh Quốc',92000,N'Văn học', 'images/7.jpg',1),
('S008',N'Người tù của đĩa bay',N'NXB Tổng hợp',2017,N'Tam Vũ',37000,N'Văn học', 'images/8.jpg',1),
('S009',N'Bên kia cầu chữ y',N'NXB Tổng hợp',2017,N'Huỳnh Ngọc Nga',64000,N'Văn học', 'images/9.jpg',1),
('S010',N'Nhà văn già và em mọi nhỏ',N'NXB Tổng hợp',2017,N'Nguyến Thành Nhân',60000,N'Tập truyện', 'images/10.jpg',1),
('S011',N'Chuyện thảo nguyên',N'NXB Hội nhà văn',2017,N'Lại Văn Sinh',127000,N'Tiểu thuyết', 'images/11.jpg',1)


insert into TaiKhoan values
('tk001', 'hoangleo', 'hoangleo',1),
('tk002', 'tinhuynh', 'tinhuynh',1),
('tk003', 'tanlinh', 'tanlinh',1),
('tk000', 'admin', 'admin',2)

insert into KhachHang values
('tk001', N'Nguyễn Việt Hoàng', '145790000', N'Nam', '0944203456', N'12 Nguyễn Văn Bảo', 'hoang@gmail.com') ,
('tk002', N'Huỳnh Trung Tín', '135490000', N'Nam', '01642034565', N'12 Phan Văn Trị', 'tin@gmail.com') ,
('tk003', N'Nguyễn Tấn Linh', '145790090', N'Nữ', '01234576542', N'12 Nguyễn Văn Bảo', 'linh@gmail.com') 

insert into QuanTriVien values
('tk000', 'Nguyen Viet Admin', '12309865', N'Nam', '03212212330', N'12 Nguyễn Văn Bảo') 


insert into HoaDon values
('HD001','tk001','6/4/2018', N'12 Nguyễn Văn Bảo','01642045567', 'hoang@gmail.com', 805000),
('HD002','tk001','5/4/2018', N'13 Nguyễn Văn Bảo','01642064565', 'tin@gmail.com',700000),
('HD003','tk001','3/4/2018', N'14 Nguyễn Văn Bảo','01642023561', 'linh@gmail.com',615000)

insert into ChiTietHD values
('HD001', 'S002', 3),
('HD001', 'S004', 2),
('HD002', 'S001', 1),
('HD002', 'S005', 2),
('HD002', 'S006', 2),
('HD003', 'S002', 3),
('HD003', 'S001', 5)



---------------------------------------
