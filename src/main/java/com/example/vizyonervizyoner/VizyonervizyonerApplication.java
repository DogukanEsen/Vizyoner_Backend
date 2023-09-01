package com.example.vizyonervizyoner;

import com.example.vizyonervizyoner.Advert.Advert;
import com.example.vizyonervizyoner.Application.Application;
import com.example.vizyonervizyoner.Application.ApplicationService;
import com.example.vizyonervizyoner.Company.Company;
import com.example.vizyonervizyoner.Company.CompanyService;
import com.example.vizyonervizyoner.Resume.Resume;
import com.example.vizyonervizyoner.Resume.ResumeService;
import com.example.vizyonervizyoner.User.Role;
import com.example.vizyonervizyoner.User.RoleRepo;
import com.example.vizyonervizyoner.User.UserRepo;
import com.example.vizyonervizyoner.auth.authService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class VizyonervizyonerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VizyonervizyonerApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder encoder, authService AuthService, CompanyService companyService, ResumeService resumeService, ApplicationService applicationService){
		return args -> {
			if(roleRepo.findByAuthority("ROLE_ADMIN").isPresent()) return;
			Role adminRole = roleRepo.save(new Role("ROLE_ADMIN"));
			Role userRole =  roleRepo.save(new Role("ROLE_USER"));


			//Verilerrrrrr
				//User verileri
			AuthService.registerUser("Ali", "Yılmaz", "ali.yilmaz@gmail.com", "sifre123");
			AuthService.registerUser("Ayşe", "Demir", "ayse.demir@yahoo.com", "sifre456");
			AuthService.registerUser("Mehmet", "Kaya", "mehmet.kaya@hotmail.com", "sifre789");
			AuthService.registerUser("Zeynep", "Çelik", "zeynep.celik@example.com", "sifre987");
			AuthService.registerUser("Ahmet", "Şahin", "ahmet.sahin@gmail.com", "sifre123");
			AuthService.registerUser("Fatma", "Aydın", "fatma.aydin@yahoo.com", "sifre456");
			AuthService.registerUser("Mustafa", "Arslan", "mustafa.arslan@hotmail.com", "sifre789");
			AuthService.registerUser("Emine", "Öztürk", "emine.ozturk@example.com", "sifre987");
			AuthService.registerUser("Hasan", "Yıldırım", "hasan.yildirim@gmail.com", "sifre123");
			AuthService.registerUser("Hülya", "Türk", "hulya.turk@yahoo.com", "sifre456");
			AuthService.registerUser("Osman", "Kara", "osman.kara@hotmail.com", "sifre789");
			AuthService.registerUser("Sibel", "Koç", "sibel.koc@example.com", "sifre987");
			AuthService.registerUser("Murat", "Aydın", "murat.aydin@gmail.com", "sifre123");
			AuthService.registerUser("Gül", "Can", "gul.can@yahoo.com", "sifre456");
			AuthService.registerUser("Cem", "Erdoğan", "cem.erdogan@hotmail.com", "sifre789");
			AuthService.registerUser("Nazlı", "Korkmaz", "nazli.korkmaz@example.com", "sifre987");
			AuthService.registerUser("Ebru", "Kurt", "ebru.kurt@gmail.com", "sifre123");
			AuthService.registerUser("Serdar", "Güler", "serdar.guler@yahoo.com", "sifre456");
			AuthService.registerUser("Dilek", "Öz", "dilek.oz@hotmail.com", "sifre789");
			AuthService.registerUser("Ali", "Koçak", "ali.kocak@example.com", "sifre987");
			AuthService.registerUser("Aylin", "Şen", "aylin.sen@gmail.com", "sifre123");
			AuthService.registerUser("Yusuf", "Uzun", "yusuf.uzun@yahoo.com", "sifre456");
			AuthService.registerUser("Merve", "Sarı", "merve.sari@hotmail.com", "sifre789");
			AuthService.registerUser("Selim", "Akar", "selim.akar@example.com", "sifre987");
			AuthService.registerUser("Zehra", "Kurtuluş", "zehra.kurtulus@gmail.com", "sifre123");
			AuthService.registerUser("Ömer", "Sönmez", "omer.sonmez@yahoo.com", "sifre456");
			AuthService.registerUser("Bengü", "Canbaz", "bengu.canbaz@hotmail.com", "sifre789");
			AuthService.registerUser("Eren", "Güney", "eren.guney@example.com", "sifre987");
			AuthService.registerUser("Cansu", "Turan", "cansu.turan@gmail.com", "sifre123");
			AuthService.registerUser("Serkan", "Yılmaz", "serkan.yilmaz@yahoo.com", "sifre456");
				//Admin Verileri
			AuthService.registerFirm("Ayşe", "Demirer", "ayse.demirer@yahoo.com", "password456789");
			AuthService.registerFirm("Ali", "Yılmazer", "ali.yilmazer@gmail.com", "password12345");
			AuthService.registerFirm("Mehmet", "Kayaer", "mehmet.kayaer@hotmail.com", "password78911");
			AuthService.registerFirm("Zeynep", "Çeliker", "zeynep.celiker@example.com", "password98711");
			AuthService.registerFirm("Can", "Erdoğan", "can.erdogan@gmail.com", "password246");
			AuthService.registerFirm("Elif", "Kurt", "elif.kurt@yahoo.com", "password135");
			AuthService.registerFirm("Oğuz", "Yıldırım", "oguz.yildirim@hotmail.com", "password579");
			AuthService.registerFirm("Aslı", "Aydın", "asli.aydin@example.com", "password864");
			AuthService.registerFirm("Emre", "Sönmez", "emre.sonmez@gmail.com", "password321");
			AuthService.registerFirm("Selin", "Kara", "selin.kara@yahoo.com", "password753");
			AuthService.registerFirm("Murat", "Güler", "murat.guler@hotmail.com", "password951");
			AuthService.registerFirm("Nazlı", "Öztürk", "nazli.ozturk@example.com", "password468");
			AuthService.registerFirm("Cem", "Canbaz", "cem.canbaz@gmail.com", "password135");
			AuthService.registerFirm("Ebru", "Sarı", "ebru.sari@yahoo.com", "password246");
			AuthService.registerFirm("Yusuf", "Turan", "yusuf.turan@hotmail.com", "password579");
				//Firma Verileri
			companyService.updateCompanyByUserId(31, new Company("Havelsan", "Havelsan, yazılım ve bilişim teknolojileri alanında faaliyet gösteren bir Türk savunma sanayi şirketidir.", "Savunma Sanayi", true,userRepo.findById(31).orElse(null),null));
			companyService.updateCompanyByUserId(32,new Company("Aselsan", "Aselsan, Türkiye’nin önde gelen elektronik, savunma, haberleşme ve bilişim şirketlerinden biridir.", "Savunma Sanayi", true,userRepo.findById(32).orElse(null),null));
			companyService.updateCompanyByUserId(33,new Company("TUSAŞ", "TUSAŞ, Türk Havacılık ve Uzay Sanayi şirketidir. Uçak, helikopter ve insansız hava araçları üretir.", "Savunma Sanayi", true,userRepo.findById(33).orElse(null),null));
			companyService.updateCompanyByUserId(34,new Company("Roketsan", "Roketsan, Türkiye merkezli bir roket ve füze üreticisidir.", "Savunma Sanayi", true,userRepo.findById(34).orElse(null),null));
			companyService.updateCompanyByUserId(35,new Company("FNSS Savunma Sistemleri", "FNSS, zırhlı araç ve sistemleri tasarlayan ve üreten bir savunma sanayi şirketidir.", "Savunma Sanayi", true,userRepo.findById(35).orElse(null),null));
			companyService.updateCompanyByUserId(36,new Company("BMC", "BMC, askeri araçlar ve ticari araçlar üreten bir şirkettir.", "Savunma Sanayi, Otomotiv", true,userRepo.findById(36).orElse(null),null));
			companyService.updateCompanyByUserId(37,new Company("Otokar", "Otokar, askeri araçlar, zırhlı personel taşıyıcılar ve otobüsler üreten bir Türk şirketidir.", "Savunma Sanayi ,Otomotiv ", true,userRepo.findById(37).orElse(null),null));
			companyService.updateCompanyByUserId(38,new Company("Makina ve Kimya Endüstrisi Kurumu (MKEK)", "MKEK, Türkiye merkezli bir kamu savunma sanayi şirketidir ve silah, mühimmat ve patlayıcılar üretir.", "Savunma Sanayi", true,userRepo.findById(38).orElse(null),null));
			companyService.updateCompanyByUserId(39,new Company("Tübitak SAGE", "Tübitak SAGE, Türk savunma sanayi için araştırma ve geliştirme çalışmaları yapan bir kurumdur.", "Savunma Sanayi", true,userRepo.findById(39).orElse(null),null));
			companyService.updateCompanyByUserId(40,new Company("Vestel", "Vestel, elektronik eşya ve teknoloji ürünleri üreten bir Türk şirketidir.", "Elektronik", false,userRepo.findById(40).orElse(null),null));
			companyService.updateCompanyByUserId(41,new Company("Arçelik", "Arçelik, beyaz eşya ve elektrikli ev aletleri üreten bir Türk şirketidir.", "Beyaz Eşya", false,userRepo.findById(41).orElse(null),null));
			companyService.updateCompanyByUserId(42,new Company("Koç Holding", "Koç Holding, Türkiye nin en büyük sanayi ve ticaret holdinglerinden biridir.", "Holding", false,userRepo.findById(42).orElse(null),null));
			companyService.updateCompanyByUserId(43,new Company("Turkcell", "Turkcell, Türkiye nin önde gelen mobil iletişim şirketlerinden biridir.", "Telekomünikasyon", false, userRepo.findById(43).orElse(null),null));
			companyService.updateCompanyByUserId(44,new Company("Pegasus Airlines", "Pegasus Airlines, Türkiye merkezli bir düşük maliyetli havayolu şirketidir.", "Havacılık", false, userRepo.findById(44).orElse(null),null));
			companyService.updateCompanyByUserId(45,new Company("Ford Otosan", "Ford Otosan, Ford marka ticari araçların Türkiye’de üretimini gerçekleştiren bir şirkettir.", "Otomotiv", false, userRepo.findById(45).orElse(null),null));
			companyService.updateCompanyByUserId(46,new Company("Nurol Makina", "Nurol Makina, zırhlı araçlar ve taktik tekerlekli zırhlı araçlar üreten bir savunma sanayi şirketidir.", "Savunma Sanayi", false, userRepo.findById(46).orElse(null),null));
			companyService.updateCompanyByUserId(47,new Company("Makel", "Makel, elektrik malzemeleri ve aydınlatma sistemleri üreten bir Türk şirketidir.", "Elektrik Malzemeleri", false, userRepo.findById(47).orElse(null),null));
			companyService.updateCompanyByUserId(48,new Company("Kale Havacılık", "Kale Havacılık, havacılık ve uzay alanında faaliyet gösteren bir Türk şirketidir.", "Havacılık ve Uzay", false, userRepo.findById(48).orElse(null),null));
				//Advert verileri
			companyService.ilanAc(31, new Advert(LocalDate.parse("2023-08-08"),"deneme","aaaaaa",LocalDate.parse("2023-08-06"),LocalDate.parse("2023-08-07"),null,"deneme","internship",null,null));
			companyService.ilanAc(32,new Advert (LocalDate.parse("2023-08-02"), "Frontend Stajyeri Aranıyor!", "Web teknolojilerine ilgi duyan, öğrenmeye açık stajyerleri ekibimize bekliyoruz. HTML, CSS, ve JavaScript bilgisine sahip olmak tercihtir.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "İstanbul","contest", "Frontend",null));
			companyService.ilanAc(33,new Advert (LocalDate.parse("2023-08-03"), "Deneyimli Backend Geliştirici Arıyoruz", "Deneyimli ve tutkulu bir backend geliştirici arıyoruz. Java, Node.js veya PHP gibi en az bir programlama dilinde tecrübeniz olmalıdır. Veritabanı tasarımı ve API entegrasyonları konusunda bilgi sahibi olmanız tercih sebebidir.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "Ankara", "contest","Backend",null));
			companyService.ilanAc(34,new Advert (LocalDate.parse("2023-08-04"), "Python ve Görüntü İşlemeye İlgili Stajyerler Aranıyor", "Python programlama diline hakim ve görüntü işleme alanına ilgi duyan stajyerleri ekibimize katılmaya davet ediyoruz. Temel Python bilgisi ve görüntü işleme kütüphaneleri (örn. OpenCV) hakkında bilgi sahibi olmanız beklenmektedir. Görüntü işleme dünyasında kendini kanıtlamak için bu harika fırsatı kaçırmayın!", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "İzmir","contest","Görüntü İşleme , python , MATLAB",null));
			companyService.ilanAc(35,new Advert (LocalDate.parse("2023-08-05"), "Robotik Alanında Yetenekli Takım Arkadaşları Arıyoruz", "Elektrik-Elektronik Mühendisliği, Bilgisayar Mühendisliği veya Mekatronik gibi alanlardan mezun olmanız tercih sebebidir. Adaylardan Robotik programlama, C/C++, ve Python gibi programlama dillerinde deneyim sahibi olmalarını bekliyoruz. Ekip çalışmasına yatkın, yenilikçi ve öğrenmeye istekli olan herkesi bekliyoruz.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "İstanbul", "contest","Robotik , otomasyon ",null));
			companyService.ilanAc(36,new Advert (LocalDate.parse("2023-08-06"), "Web Geliştirme Alanında Yetenekli Takım Arkadaşları Arıyoruz", "PHP, HTML, ve CSS gibi web teknolojilerine hakim adayları ekibimize katılmaya davet ediyoruz. Bilgisayar Mühendisliği, Yazılım Mühendisliği veya ilgili bölümlerden mezun olmanız tercih sebebidir.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "Ankara", "jobPostings","Web Geliştirme , php , html , css",null));
			companyService.ilanAc(37,new Advert (LocalDate.parse("2023-08-07"), "Yapay Zeka Alanında Stajyerler Arıyoruz", "SQL ve Python gibi programlama dillerine hakim, yapay zeka ve veri analitiği konusunda meraklı stajyerleri ekibimize katılmaya davet ediyoruz. Bilgisayar Mühendisliği, Yazılım Mühendisliği, Endüstri Mühendisliği veya ilgili bölümlerden öğrenci olmanız tercih sebebidir.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "İzmir", "jobPostings","Yapay Zeka , python , sql",null));
			companyService.ilanAc(38,new Advert (LocalDate.parse("2023-08-08"), "Mobil Uygulama Geliştirme Alanında Stajyerler Arıyoruz", "Java ve Kotlin gibi programlama dillerine hakim, mobil uygulama geliştirme konusunda ilgili stajyerleri ekibimize katılmaya davet ediyoruz. Bilgisayar Mühendisliği, Yazılım Mühendisliği veya ilgili bölümlerden öğrenci olmanız tercih sebebidir.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "Ankara", "jobPostings","Mobil Uygulama Geliştirme  java , kotlin ",null));
			companyService.ilanAc(39,new Advert (LocalDate.parse("2023-08-09"), "Tıbbi Cihaz ve Biyomedikal Alanında Uzmanlar Arıyoruz", "Biyomedikal veya Elektrik-Elektronik Mühendisliği gibi ilgili bölümlerden mezun adayları ekibimize katılmaya davet ediyoruz. Tıbbi cihazlar ve sağlık teknolojileri konusunda deneyimli, cihaz tasarımı ve kalibrasyonu konusunda bilgi sahibi olmanız tercih sebebidir.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "İstanbul", "jobPostings","Tıbbi Cihaz ve Biyomedikal,tıbbi cihazlar",null));
			companyService.ilanAc(40,new Advert(LocalDate.parse("2023-08-10"), "Frontend React Stajyeri Aranıyor!", "Bilgisayar Mühendisliği, Yazılım Mühendisliği veya ilgili bölümlerden öğrenci olmanız tercih sebebidir. React bilen, HTML, CSS ve JavaScript konularında temel düzeyde deneyim sahibi adayları ekibimize katılmaya davet ediyoruz.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "Ankara", "jobPostings","Frontend,React,html,css",null));
			companyService.ilanAc(41,new Advert(LocalDate.parse("2023-08-11"), "Gömülü Sistemler Uzmanı Aranıyor!", "Elektrik-Elektronik Mühendisliği, Bilgisayar Mühendisliği veya ilgili bölümlerden mezun adayları ekibimize katılmaya davet ediyoruz. Gömülü sistemler ve Raspberry Pi üzerinde deneyimli, donanım ve yazılım entegrasyonu konusunda bilgi sahibi olmanız tercih sebebidir.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "İzmir", "jobPostings","Gömülü Sistemler,Raspberry Pi ",null));
			companyService.ilanAc(42,new Advert(LocalDate.parse("2023-08-12"), "Veri Bilimi Uzmanı Aranıyor!", "Bilgisayar Mühendisliği, Yazılım Mühendisliği, Endüstri Mühendisliği veya ilgili bölümlerden mezun adayları ekibimize katılmaya davet ediyoruz. Veri analizi, makine öğrenmesi ve Python programlama konularında deneyim sahibi olmanız tercih sebebidir.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "Ankara", "jobPostings","Veri Bilimi, python",null));
			companyService.ilanAc(43,new Advert(LocalDate.parse("2023-08-13"), "Proje Yönetimi ve İş Analisti Stajyeri Aranıyor!", "Endüstri Mühendisliği veya ilgili bölümlerden öğrenci olmanız tercih sebebidir. Proje yönetimi ve iş analizi konularında ilgili birikime sahip, iş süreçlerini analiz edebilen ve belgelendirebilen stajyerleri ekibimize katılmaya davet ediyoruz.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "İstanbul", "jobPostings","Proje Yönetimi ,iş analisti",null));
			companyService.ilanAc(44,new Advert(LocalDate.parse("2023-08-14"), "Siber Güvenlik Stajyeri Aranıyor!", "Bilgisayar Mühendisliği, Bilgisayar ve Yazılım Mühendisliği, Siber Güvenlik veya ilgili bölümlerden öğrenci olmanız tercih sebebidir. Kali Linux ve diğer siber güvenlik araçlarına hakim, ağ güvenliği ve zafiyet analizi konularında deneyimli stajyerleri ekibimize katılmaya davet ediyoruz.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "Ankara","internship", "Siber Güvenlik, Kali Linux",null));
			companyService.ilanAc(45,new Advert(LocalDate.parse("2023-08-15"), "Java ve JavaScript Uzmanı Aranıyor!", "Bilgisayar Mühendisliği, Yazılım Mühendisliği veya ilgili bölümlerden mezun adayları ekibimize katılmaya davet ediyoruz. Java ve JavaScript programlama dillerinde güçlü deneyime sahip, web ve yazılım projelerinde tecrübeli stajyerleri arıyoruz.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "Ankara","internship", "Web Geliştirme,java,javascript ",null));
			companyService.ilanAc(46,new Advert(LocalDate.parse("2023-08-16"), "Oyun Geliştirme Uzmanı Aranıyor!", "Bilgisayar Mühendisliği, Yazılım Mühendisliği veya ilgili bölümlerden mezun adayları ekibimize katılmaya davet ediyoruz. Oyun geliştirme konusunda güçlü deneyime sahip, Unity oyun motorunu ve C# programlama dilini çok iyi bilen kişileri arıyoruz. Adaylardan, 2D ve 3D oyun tasarımı, fizik motorları ve animasyon konularında bilgi sahibi olmaları beklenmektedir.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null, "İzmir","internship", "Oyun Geliştirme,unity,C#",null));
			companyService.ilanAc(47,new Advert(LocalDate.parse("2023-08-17"), "İnşaat Mühendisliği Stajyeri Aranıyor!", "İnşaat Mühendisliği veya ilgili bölümlerden öğrenci olmanız tercih sebebidir. Proje yönetimi süreçlerine hakim, inşaat projelerini planlama ve takip etme konusunda deneyimli stajyerleri ekibimize katılmaya davet ediyoruz.", LocalDate.parse("2023-08-01"), LocalDate.parse("2023-09-01"),null,"internship", "Ankara", "İnşaat",null));
				//Resumeler
			resumeService.updateResumeByUserId(1,new Resume("python, matlab, görüntü işleme" ,"86420931785",null,null,"istanbul", "adres1",2.6,"mezun", "yazılım mühendisliği", "Yazılım mühendisliği bölümünden mezun oldum. Görüntü işleme alanına olan büyük ilgimle kendimi geliştirdim. Mezuniyetimle birlikte, Python ve MATLAB gibi programlama dillerini kullanarak görüntü işleme projeleri üzerinde çalıştım.",null));
			resumeService.updateResumeByUserId(2,new Resume("C++, python, java, yapay zeka", "52013789642", null,null, "bursa","adres2",3.20, "4", "bilgisayar mühendisliği", "4. sınıf bilgisayar mühendisliği öğrencisiyim. Programlama konusunda C++, Python ve Java dillerini biliyorum. En çok ilgimi çeken alanlar Yapay Zeka, Veri Bilimi.",null));
			resumeService.updateResumeByUserId(3,new Resume("python, VBA, proje yönetimi, iş analizi","97540361288", null,null, "ankara", "adres3",2.98, "4", "endüstri mühendisliği", "Endüstri mühendisliği alanında 4. sınıf öğrencisiyim. Python, Excel VBA ve Arena gibi dilleri kullanarak simülasyon ve optimizasyon çalışmaları yapıyorum. İş süreçleri analizi ve proje yönetimi konularına büyük ilgi duyuyorum.",null));
			resumeService.updateResumeByUserId(4,new Resume("elektronik devreler, mikroişlemciler","63198520476", null,null, "istanbul", "adres4",2.87, "4", "elektrik elektronik mühendisliği", "Elektrik mühendisliği öğrencisi olarak 4. sınıfı tamamlamak üzereyim. Elektronik devreler, sinyaller ve sistemler ve mikroişlemciler gibi alanlara ilgi duyuyorum.",null));
			resumeService.updateResumeByUserId(5,new Resume("otonom araçlar, robotik, tıbbi cihazlar","10875321964", null,null, "bursa", "adres5",3.22, "mezun", "mekatronik mühendisliği", "Mekatronik mühendisliği bölümünden mezun oldum. İlgi alanlarım otonom araçlar, tıbbi cihazlar ve robotik.",null));
			resumeService.updateResumeByUserId(6,new Resume("proje yönetimi, otomasyon sistemleri","42689103752", null,null, "denizli", "adres6",3.76, "2", "makine mühendisliği", "Makine mühendisliği bölümünde 2. sınıf öğrencisiyim. Proje yönetimi, imalat süreçleri ve otomasyon sistemleri gibi alanlara ilgim var.",null));
			resumeService.updateResumeByUserId(7,new Resume("python, java, web geliştirme, c++, veri bilimi","76210938456", null,null, "ankara", "adres7",2.80, "mezun", "bilgisayar programcılığı", "Bilgisayar programcılığı mezunuyum. Python, Java, C++ ve JavaScript gibi programlama dillerine hakimim. Veri bilimi ve web geliştirme alanına ilgim var.",null));
			resumeService.updateResumeByUserId(8,new Resume("python, ruby, kotlin, yapay zeka, mobil uygulama geliştirme","31542097683",null, null, "elazığ","adres8", 2.21, "3", "yazılım mühendisliği", "3. sınıf yazılım mühendisliği öğrencisiyim. Python, Ruby ve Kotlin programlama dillerine hakimim. Veri Analitiği, Mobil Uygulama Geliştirme ve Yapay Zeka alanlarıyla ilgileniyorum.",null));
			resumeService.updateResumeByUserId(9,new Resume("java, kotlin, sql, mobil uygulama geliştirme","68904321571",null, null, "istanbul", "adres9",2.44, "4", "bilgisayar mühendisliği", "4. sınıf bilgisayar mühendisliği öğrencisiyim. Java, Kotlin ve SQL programlama dillerini biliyorum. Mobil Uygulama Geliştirme konusunda ilgim var.",null));
			resumeService.updateResumeByUserId(10,new Resume("fronted, HTML, CSS React, Javascript" ,"23716049875",null, null, "istanbul", "adres10",3.54, "4", "yazılım mühendisliği", "4. sınıf yazılım mühendisliği öğrencisiyim ve frontend geliştirme alanına olan ilgimle ön plana çıkıyorum. HTML, CSS, Javascript, React dillerini biliyorum.",null));
			resumeService.updateResumeByUserId(11,new Resume("Java, Javascript, PHP, web geliştirme" ,"89456213047",null, null, "istanbul","adres11",2.50, "3", "bilgisayar mühendisliği", "Şu an 3. sınıf öğrencisiyim. Programlama dilleri olarak Java, JavaScript ve PHP ile ilgileniyorum. Web Geliştirme, Mobil Uygulama Geliştirme konularına ilgiliyim.",null));
			resumeService.updateResumeByUserId(12,new Resume("fronted, web geliştirme, HTML, CSS, Typescript, Javascript","15874320966",null, null, "samsun", "adres12",3.10, "mezun", "yazılım mühendisliği", "Yazılım mühendisliği bölümünden mezun oldum. Frontend ve web geliştirme alanlarıyla ilgileniyorum. HTML, CSS, TypeScript, JavaScript gibi dillerle etkileşimli ve kullanıcı dostu web siteleri oluşturdum.",null));
			resumeService.updateResumeByUserId(13,new Resume("görüntü işleme, biyomedikal sinyal işleme","46893571200", null, null, "istanbul","adres13",2.90, "1", "biyomedikal mühendisliği", "Biyomedikal mühendisliği bölümünde 1. sınıf öğrencisiyim. İlgi alanlarımdan biri medikal görüntü işleme ve biyomedikal sinyal işleme. C++ dilini biliyorum.",null));
			resumeService.updateResumeByUserId(14,new Resume("python, c#, sql","80236519478",null, null, "ankara", "adres14",3.80, "2", "bilgisayar mühendisliği", "Ben 2. sınıf bilgisayar mühendisliği öğrencisiyim. Python, C# ve SQL programlama dillerini kullanıyorum. Veri Tabanı Yönetimi ve Nesnelerin İnterneti alanları beni çok heyecanlandırıyor.",null));
			resumeService.updateResumeByUserId(15,new Resume("proje yönetimi, yapı sistemleri, inşaat teknolojileri","27385140629", null, null, "ankara","adres15",2.45, "4", "inşaat mühendisliği", "İnşaat mühendisliği bölümünde son sınıf öğrencisiyim. Proje yönetimi, yapı sistemleri ve inşaat teknolojileri gibi alanlarla ilgileniyorum.",null));
			resumeService.updateResumeByUserId(16,new Resume("C++, python, MATLAB, görüntü işleme, sinyal işleme" ,"94371658203", null, null, "bursa","adres16",3.24, "3", "bilgisayar mühendisliği", "3. sınıf bilgisayar mühendisliği öğrencisiyim. C++, Python ve MATLAB programlama dillerini kullanıyorum. Görüntü İşleme, Sinyal İşleme ve Biyomedikal Mühendislik alanlarında çalışmak istiyorum.",null));
			resumeService.updateResumeByUserId(17,new Resume("C++, java, assembly, otomasyon, kontrol sistemleri","53629147018", null, null, "ankara","adres17",3.20, "mezun", "elektrik elektronik mühendisliği", "Elektrik mühendisliği mezunuyum. C++, Java ve Assembly dillerini biliyorum. Otomasyon ve kontrol sistemleri alanına büyük ilgi duyuyorum.",null));
			resumeService.updateResumeByUserId(18,new Resume("python, ruby, sql, veri analitiği, makine öğrenmesi","65981234702", null, null, "konya","adres18",3.32, "mezun", "bilgisayar mühendisliği", "Bilgisayar mühendisliği bölümünden mezun oldum. Python, Ruby ve Sql programlama dillerini biliyorum Veri Analitiği, Makine Öğrenmesi alanlarında kendimi geliştirmeye çalışıyorum.",null));
			resumeService.updateResumeByUserId(20,new Resume("biyomedikal cihaz, nanoteknoloji, tıbbi cihazlar","21746093581", null, null, "istanbul","adres20",2.95, "2", "biyomedikal mühendisliği", "Biyomedikal mühendisliği bölümünde 2. sınıf öğrencisiyim. İlgi alanlarım biyomedikal cihaz tasarımı ve nanoteknoloji ve tıbbi cihazlar.",null));
			resumeService.updateResumeByUserId(21,new Resume("java, c#, javascript, oyun geliştirme, mobil","38502796154", null, null, "bursa","adres21",2.50, "mezun", "bilgisayar mühendisliği", "Bilgisayar mühendisliği mezunuyum.Java, C# ve JavaScript programlama dillerini öğreniyorum. Oyun Programlama, Mobil Uygulama Geliştirme ile ilgileniyorum.",null));
			resumeService.updateResumeByUserId(22,new Resume("oyun geliştirme, unity, c#, c++","74068921357", null,null, "izmir","adres22",3.25, "3", "yazılım mühendisliği", "3. sınıf yazılım mühendisliği öğrencisiyim ve oyun geliştirme alanına olan tutkumla ön plana çıkıyorum. Unity , C# , C++ dillerini biliyorum.",null));
			resumeService.updateResumeByUserId(23,new Resume("kali linux, c++, python, siber güvenlik","42108654379", null,null, "izmir","adres23",3.43, "4", "bilgisayar mühendisliği", "4. sınıf bilgisayar mühendisliği öğrencisiyim. C++, Python, kali linux gibi dilleri öğrendim. Siber güvenlik alanına ilgim var.",null));
			resumeService.updateResumeByUserId(24,new Resume("mobil uygulama geliştirme, flutter, javascript, c++","97630521874", null,null, "ankara","adres24", 3.51, "4", "yazılım mühendisliği", "Yazılım mühendisliği 4. sınıf öğrencisiyim. Mobil uygulama geliştirmeye olan ilgimle öne çıkıyorum. Flutter , Javascript , C++ biliyorum.",null));
			resumeService.updateResumeByUserId(25,new Resume("otomasyon, robotik","58940273156", null, null, "izmir","adres25",3.67, "3", "elektrik elektronik mühendisliği", "Elektrik mühendisliği bölümünde 3. sınıf öğrencisiyim. Özellikle otomasyon ve kontrol, endüstriyel elektronik ve robotik alanlarında ilgi duyuyorum.",null));
			resumeService.updateResumeByUserId(26,new Resume("robotik, otomotiv","12345678901", null, null, "istanbul","adres26",3.45, "3", "makine mühendisliği", "Makine mühendisliği bölümünde 3. sınıf öğrencisiyim. Proje yönetimi, veri analizi ve robotik gibi derslerle ilgileniyorum. İlgi alanlarımdan biri otomotiv sektörü ve araç tasarımı.",null));
			resumeService.updateResumeByUserId(27,new Resume("c++, robotik, python, matlab","43085216797", null,null, "antalya", "adres27",3.50, "mezun", "yazılım mühendisliği", "Yazılım mühendisliği bölümünden mezun oldum. Robotik alanına olan ilgimle öne çıkıyorum ve özellikle robotik projeleri için C++, Python , MATLAB gibi dilleri kullanarak çalıştım.",null));
			resumeService.updateResumeByUserId(28,new Resume("robotik, otomasyon, gömülü sistemler, raspberry pi","76192850364", null,null, "ankara","adres28", 2.71, "3", "mekatronik mühendisliği", "Mekatronik mühendisliği bölümünde 3. sınıftayım. Python, C++ ve Raspberry Pi programlama dilleriyle ilgileniyorum. İlgi alanlarımdan biri robotik ve otomasyon sistemleri.",null));
			resumeService.updateResumeByUserId(29,new Resume("backend, java, php","25481760392", null,null, "istanbul","adres29",2.34, "2", "bilgisayar mühendisliği", "2. sınıf bilgisayar mühendisliği öğrencisiyim. Python, Java ve PHP programlama dilleriyle ilgileniyorum. Backend geliştirme konusuna ilgim yoğun.",null));
			resumeService.updateResumeByUserId(30,new Resume("python, proje yönetimi, java","69543127810", null, null, "istanbul","adres30",3.12, "3", "endüstri mühendisliği", "Endüstri mühendisliği alanında 3. sınıf öğrencisiyim. Python gibi dillerle çalışıyorum ve endüstriyel mühendislik uygulamaları, kalite yönetimi ve enerji yönetimi gibi alanlara ilgi duyuyorum.",null));

			AuthService.registerFirm("admin","admin","admin","admin");
			AuthService.registerUser("user","user","user","user");

			applicationService.createApplicationIds( 1, 9,  new Application());
			applicationService.createApplicationIds( 1, 14, new Application());
			applicationService.createApplicationIds( 2, 3,  new Application());
			applicationService.createApplicationIds( 2, 16, new Application());
			applicationService.createApplicationIds( 3, 9,  new Application());
			applicationService.createApplicationIds( 3, 13, new Application());
			applicationService.createApplicationIds( 10, 3, new Application());
			applicationService.createApplicationIds( 10, 4, new Application());
			applicationService.createApplicationIds( 11, 17,new Application());
			applicationService.createApplicationIds( 12, 10,new Application());
			applicationService.createApplicationIds( 12, 15,new Application());
			applicationService.createApplicationIds( 13, 2, new Application());
			applicationService.createApplicationIds( 13, 16,new Application());
			applicationService.createApplicationIds( 14, 2, new Application());
			applicationService.createApplicationIds( 14, 13,new Application());
			applicationService.createApplicationIds( 15, 8, new Application());
			applicationService.createApplicationIds( 15, 3, new Application());
			applicationService.createApplicationIds( 17, 1, new Application());
			applicationService.createApplicationIds( 18, 1, new Application());
			applicationService.createApplicationIds( 18, 12,new Application());
			applicationService.createApplicationIds( 31, 12,new Application());
			applicationService.createApplicationIds( 31, 9, new Application());
			applicationService.createApplicationIds( 11, 16,new Application());
			applicationService.createApplicationIds( 11, 17,new Application());
			applicationService.createApplicationIds( 23, 17,new Application());
			applicationService.createApplicationIds( 23, 11,new Application());
			applicationService.createApplicationIds( 21, 11,new Application());
			applicationService.createApplicationIds( 21, 9, new Application());
			applicationService.createApplicationIds( 21, 3, new Application());
			applicationService.createApplicationIds( 17, 9, new Application());
			applicationService.createApplicationIds( 17, 10,new Application());
			applicationService.createApplicationIds( 25, 16,new Application());
			applicationService.createApplicationIds( 25, 5, new Application());
			applicationService.createApplicationIds( 26, 13,new Application());
			applicationService.createApplicationIds( 26, 13,new Application());
			applicationService.createApplicationIds( 19, 17,new Application());
			applicationService.createApplicationIds( 19, 2, new Application());
			applicationService.createApplicationIds( 19, 3, new Application());
			applicationService.createApplicationIds( 5, 4, new Application());
			applicationService.createApplicationIds( 6, 4, new Application());
			applicationService.createApplicationIds( 6, 11,new Application());

			System.out.println("---------Verilerin hepsi eklendi!!----------");
		};
	}
}
