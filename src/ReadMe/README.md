# Giới Thiệu Phần Mềm

# Phần mềm Quản lý cửa hàng Giày

## Team
| stt | Họ Tên  | Phần trăm việc làm |
|---| ----- | ----- |
| 1 | Tăng Chí Chung | 60% |
| 2 | Nguyễn Tuấn Anh | 40% |

| Thư mục | DTO | DAO | BUS | GUI | Lib | Image | Mô hình thực thể kết hợp | Cơ sở dữ liệu |
|---| ----- | ----- | ----- | ----- | ----- | ----- |   ----- |  ----- |
| Link | [DTO](./src/ShoesManager/DTO) | [DAO](./src/ShoesManager/DAO) | [BUS](./src/ShoesManager/BUS) | [GUI](./src/ShoesManager/GUI) | [Lib](./src/ShoesManager/lib) | [Image](./src/ShoesManager/images) | [DataBase](./src/DataBase.PNG) | [ERD](./src/phpAdminSQL.sql) |

# Thông tin chung
- Phần mềm “Quản Lý Cửa Hàng Giày” dành cho cách cửa hàng bán giày hoặc các cửa hàng bán mặc hàng khác muốn kiểm soát công việc 1 cách tốt hơn.<br>
- Tất cả phần tính tổng tiền, tính khuyến mãi đều do phần mềm làm nên người dùng không cần nhập.<br>
- Trong tất cả các chức năng đều có tìm kiếm theo từng loại nên người dùng đừng quá bận tâm khi thấy các sản phẩm, hóa đơn hay phiếu nhập quá nhiều.<br>
- Mọi mã đều là tự động.
- Phần mềm với dữ liệu đã chuẩn hóa lên 3NF với mô hình 3 lớp kết nối chặt chẽ tránh bị mất và sai sót thông tin.
# Chức Năng Của Phần Mềm
## Người dùng đăng nhập, phần mêm có phân làm 6 quyền<br>
- Chủ cửa hàng sẽ bao gồm tất cả chức năng.<br>
-	Thư ký, là người sẽ thống kê và nhập xuất file excel.
-	Nhân viên kiểm tra hàng hóa.
-	Nhân viên nhập hàng.
-	Nhân viên làm khuyến mãi.
-	Nhân viên lập hóa đơn.<br>
## Excel<br>
-	Sẽ đọc file excel và xuất file excel.<br>
Thống kê<br>
-	Thống kê doanh thu theo ngày, quý, tháng và năm.
-	Hiển thị ra tổng thu và tổng chi, sau đó tính ra lợi nhuận.
-	Hiển thị số tiền hóa đơn cao nhất và thấp nhất.
## Sản phẩm<br>
-	Nhân viên kiểm tra hàng hóa sẽ thêm sản phẩm mới và sửa xóa sản phẩm.
## Nhập hàng
-	Tạo mới 1 phiếu nhập và ghi thông tin chi tiết của phiếu nhập đó với tùng sản phẩm mà người dùng nhập.
## Khuyến mãi<br>
-	Tạo mới 1 mã khuyến mãi và cho biết thời gian khuyến mãi của chương trình khuyến mãi đó đối với những loại sản phẩm nào với tỉ lệ khuyến mãi là bao nhiêu.
Hóa đơn<br>
-	Tạo 1 hóa đơn với các thông tin chi tiết của hóa đơn đó.
-	Sau khi làm xong hóa đơn ta có thể xuất hóa đơn đó ra file ảnh.

# Hướng phát triển trong tương lai

-	Khắc phục những chỗ hay vì hiển thị mã thì hiển thị tên.
-	Xử lý được với 1 luồng dữ liệu lớn.
-	Có thể tích hợp trên nhiều hệ điều hành khác như: Linux, Android, ISO, ...
-	Sẽ có một người chuyên thiết kế để có 1 giao diện để trình bày giao diện phân bố một cách hợp lý và ngày càng đẹp hơn.
-	Xuất ra 1 file Apllication để cài đặt nhanh gọn không cần phải tải NetBeans về.
-	Thống kê nhiều danh mục.
-	Đọc file Excel và ghi vào database.
-	Sửa những lỗi nhập số nhập chữ thì hiển thị cho người dùng biết mình nhập sai.
-	Khi đăng nhập hay check tài khoản khách hàng thì sẽ áp dụng thêm nhận dạng thẻ, … .
-	Tăng khả năng bảo mật của phần mềm.
