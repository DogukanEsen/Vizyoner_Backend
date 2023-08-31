# Vizyoner Genç Web Projesi
## Projeyi çalıştırmak
Projeyi çalıştırmak için projenin dosyalarını indirmek gerekmektedir.
+ [Proje Backend](https://github.com/DogukanEsen/Vizyoner_Backend)
+ [Proje Frontend](https://github.com/DogukanEsen/Vizyoner_Frontend)
+ [Proje Yapay Zeka](https://github.com/emineygt/Vizyoner_ai)  
  Bu dosyaları indirdikten sonra postgresql' de vg_db isimli bir veritabanı oluşturulması gerekmektedir. Bu sayede veritabanına migration ile tablolar eklenecektir. Ardından dosyalar çalıştırılarak proje çalışmaktadır. Proje ilk çalıştırıldığında örnek veriler eklenecektir.
## Proje Özellikleri
Projede 2 tip kullanıcı bulunmaktadır. Normal kullanıcılar ilgili ilanlara başvurabilir, profillerini güncelleyebilir. Kurumsal kullanıcılar ise firma bilgilerini güncelleyebilir ve ilan oluşturabilir. Dışarıdan gelen kişiler her iki tarafa da kayıt olabilir. Dışarıdan gelen kullanıcılar giriş yapmadan firmaları ve ilanları görüntüleyebilir. Projenin bir diğer özelliği ise normal kullanıcıların başvurduğu ilanların türüne ve o ilana başvuran kişilerin başvurdukları ilanlara göre ilan öneri sistemidir.

## Backend
Projede Gradle kullanılmıştır.
Spring Boot uygulamasını Spring çerçevesinde bulunan diğer modüller ile entegre etmek çok kolaydır. Projede veri tabanı işlemlerini desteklemesi adına JPA (Java Persistence API), kullanıcı kimlik doğrulama ve yetkilendirme işlemlerini sağlayan Spring Security ve JSON Web Token (JWT), Web uygulamalarının temel bileşenlerini ve kullanacağımız JSON servisleri için RESTful web service’ini sağlayan Spring Web, veri tabanı migration yönetimi için Flyway Core kullandık.. First commit te emeği geçenler:  
+ Demet Aşgaroğlu: Company, User, Projects sınıfları ve işlemleri    
+ Büşra Çetinkaya: Advert, Resume ve Application sınıfları ve işlemleri   
+ Doğukan Esen: Jwt ve auth sınıfları ve işlemleri