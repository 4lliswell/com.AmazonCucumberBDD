# Amazon Web Sitesi Selenium Cucumber BDD Otomasyon Testi

Bu proje, Selenium ve Cucumber BDD kullanılarak Amazon Türkiye sitesi üzerinde otomasyon testleri yapmak amacıyla geliştirilmiştir.
Amazon web sitesine yönelik login olma, ürün arama, sepete ürün ekleme, sepet işlemlerini doğrulama gibi çeşitli işlevlere odaklanmaktadır.

## Proje Amaçları

- Amazon Türkiye sitesini açarak ana sayfanın doğru yüklenip yüklenmediğini kontrol etmek.
- Kullanıcı girişi yaparak doğru şekilde giriş yapıldığını kontrol etmek.
- Kategoriler tabından bilgisayar seçeneğini seçerek doğruluğunu kontrol etmek.
- Arama yaparak sonuçların doğru şekilde geldiğini kontrol etmek.
- Favorilere ürün ekleyip, favori listesinden silerek bu işlemlerin doğru çalıştığını kontrol etmek.
- Kullanıcı hesabından çıkış yapıp, çıkışın doğru çalıştığını kontrol etmek.

## Gereksinimler

- Java 8 veya üstü
- Selenium WebDriver
- Cucumber
- Maven (proje bağımlılıklarını yönetmek için)

## Kurulum

1. **Projeyi İndirin:**

   ```bash
   git clone https://github.com/kullanici/proje-adı.git
   cd proje-adı
   ```

2. **Bağımlılıkları Yükleyin:**


   pom.xml
   

## Nasıl Kullanılır

Proje bağımlılıkları yüklendikten sonra, testleri aşağıdaki komutla çalıştırabilirsiniz:

```bash
mvn test
```

## Proje Yapısı

Proje, aşağıdaki dizin yapısına sahiptir:

- `src/test/java`: Test kodları
  - `hooks`: Test senaryolarının öncesinde veya sonrasında çalışacak kod blokları
  - `pages`: Sayfa objeleri için sınıflar
  - `runners`: Cucumber'ın test senaryolarını nasıl yürüteceğini belirtir
  - `stepDefinitions`:  Cucumber senaryolarındaki adımların (steps) kodları
  - `utilities`: Yardımcı sınıflar (Log4j vb.)
- `src/test/reources`: Cucumber senaryolarındaki adımlar (steps)
  - `features`: Test senaryolarının Gherkin dilinde tanımlandığı dosyalar

## Senaryo Adımları ve Kod Örnekleri

Proje içerisinde yer alan senaryolar aşağıda yer almaktadır:

1. **Amazon sitesi açılır ve ana sayfa doğruluğu kontrol edilir:**

2. **Çerez tercihlerinden kabul seçeneği işaretlenir:**

3. **Siteye login olunur ve login işlemi kontrol edilir:**

4. **Arama butonu yanındaki kategoriler tabından bilgisayar seçilir ve doğruluğu kontrol edilir:**

5. **Arama alanına MSI yazılır ve arama yapılır, arama sonuçları kontrol edilir:**

6. **Arama sonuçları sayfasından 2. sayfa açılır ve doğruluğu kontrol edilir:**

7. **Sayfadaki 2. ürün favorilere eklenir ve eklemenin doğruluğu kontrol edilir:**

8. **Hesabım > Favori Listem sayfasına gidilir ve açıldığı kontrol edilir:**

9. **Eklenen ürün favorilerden silinir ve silme işleminin doğruluğu kontrol edilir:**

10. **Üye çıkış işlemi yapılır ve çıkışın doğruluğu kontrol edilir:**
