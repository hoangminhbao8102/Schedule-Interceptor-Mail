# Schedule-Interceptor-Mail

Demo cho môn **Lập trình Java nâng cao**: 
- ✅ Scheduler (`@Scheduled`): heartbeat mỗi 10s, cron 09:00 hàng ngày  
- ✅ Interceptor: 
  - `LoggingInterceptor` log thời gian xử lý request
  - `ApiKeyInterceptor` bảo vệ `/api/secure/**` bằng header `X-API-KEY`
- ✅ Gửi mail: Simple, HTML, Thymeleaf template

## Yêu cầu
- JDK 17
- Maven 3.9+
- Tài khoản SMTP (Gmail App Password / Mailtrap / bất kỳ nhà cung cấp SMTP)

## Cấu hình
Sửa `src/main/resources/application.properties`:
```properties
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
app.mail.from=Demo <your_email@gmail.com>
app.security.api-key=secret123
```
Gmail: Bật 2FA, tạo App Password (16 ký tự), dùng thay cho mật khẩu.

## Chạy
```bash
mvn clean spring-boot:run
```
Mặc định chạy ở http://localhost:8080.

## Thử Interceptor
- Public: GET /hello

- Secure (cần API key):

```bash
curl -H "X-API-KEY: secret123" http://localhost:8080/api/secure/ping
```

## Gửi mail
- Simple:

```bash
curl -X POST http://localhost:8080/api/mail/simple \
  -H "Content-Type: application/json" \
  -d '{"to":"you@example.com","subject":"Hello","text":"This is a simple email"}'
```

- HTML:

```bash
curl -X POST http://localhost:8080/api/mail/html \
  -H "Content-Type: application/json" \
  -d '{"to":"you@example.com","subject":"HTML","html":"<h1>Hi</h1><p>HTML content</p>"}'
```

- Template (Thymeleaf):

```bash
curl -X POST http://localhost:8080/api/mail/welcome \
  -H "Content-Type: application/json" \
  -d '{"to":"you@example.com","name":"Bảo Minh"}'
```
## Scheduler
- `heartbeat()` chạy mỗi 10 giây (log INFO)

- `dailyReport()` chạy lúc 09:00 theo Asia/Ho_Chi_Minh

Sửa cron trong DemoJobs.java nếu muốn.

## Ghi chú bảo mật
- Không commit mật khẩu SMTP lên repo.

- Dùng biến môi trường hoặc Spring Config Server trong môi trường thực tế.

## Bản quyền
MIT

---
