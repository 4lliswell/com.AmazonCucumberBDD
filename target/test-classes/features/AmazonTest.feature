@amazon
Feature: Kullanici Amazon Sitesine Login Olup Sepete Urun Ekleyip, Cikarabilmeli ve Cikis Yapabilmeli

  Scenario: Kullanici Amazon Sitesine Login Olup Sepete Urun Ekleyip, Cikararir ve Cikis Yapar

    Given chrome browser kullanilarak "amazonUrl" ana sayfasina gidilir
    And ana sayfanin acildigi kontrol edilir
    When cerez tercihlerinden cerezleri kabul et secilir
    When siteye login olunur
    And login islemi kontrol edilir
    When arama butonu yanindaki kategoriler tabindan bilgisayar secilir
    And bilgisayar kategorisi secildigi kontrol edilir
    When arama alanina MSI yazilir ve arama yapilir
    And arama yapildigi kontrol edilir
    When arama sonuclari sayfasindan ikinci sayfa acilir
    And ikinci sayfanin acildigi kontrol edilir
    When sayfadaki ikinci urun favorilere eklenir
    And ikinci urunun favorilere eklendigi kontrol edilir
    When hesabim seceneginden favori listem sayfasina gidilir
    And favori listem sayfasinin acildigi kontrol edilir
    When eklenen urun favorilerden silinir
    And silme isleminin gercekleştigi kontrol edilir
    When uye cikis islemi yapilir
    And cikis isleminin yapildigi kontrol edilir
    Then chrome browser kapatilir
