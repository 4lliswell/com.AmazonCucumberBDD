@amazon
Feature: Kullanici Amazon Sitesine Login Olup Sepete Urun Ekleyip, Cikarabilmeli ve Cikis Yapabilmeli

  Scenario: Kullanici Amazon Sitesine Login Olup Sepete Urun Ekleyip, Cikararir ve Cikis Yapar
    Given kullanici URL'e gider "amazonUrl"
    And ana sayfanin acildigi kontrol edilir "amazonUrl"
    When cerez tercihlerinden cerezleri kabul et secilir
    When siteye login olunur "amazonEmail" "amazonPassword"
    And login islemi kontrol edilir
    When arama butonu yanindaki kategoriler tabindan "Bilgisayarlar" secilir
    And "Bilgisayarlar" kategorisi secildigi kontrol edilir
    When arama alanina "MSI" yazilir ve arama yapilir
    And arama yapildigi kontrol edilir "MSI"
    When arama sonuclari sayfasindan "2" sayfa acilir
    And "2" sayfanin acildigi kontrol edilir
    When sayfadaki "2" urun favorilere eklenir
    And urunun favorilere eklendigi kontrol edilir
    When hesabim seceneginden favori listem sayfasina gidilir
    And favori listem sayfasinin acildigi kontrol edilir
    When eklenen urun favorilerden silinir
    And silme isleminin gercekleştigi kontrol edilir
    When uye cikis islemi yapilir
    And cikis isleminin yapildigi kontrol edilir
    Then kullanici tarayiciyi kapatir
