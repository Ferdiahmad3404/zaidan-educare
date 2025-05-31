Feature: User Login
  @valid
  Scenario: Check login is successful with valid credentials as role "bendahara"
    Given User navigated to Login page
    When User enters username "bendahara"
    And Enters password "admin123"
    And Clicks on login button
    Then User navigated to bendahara Dashboard page
    And User should see the following sidebar items:
      | Dasbor  |
      | Tagihan Siswa |
      | Transaksi Penerimaan Dana |
      | Pengaturan Notifikasi |
      | Status Pembayaran |
      | Rekapitulasi |
      | Progres Transaksi Penerimaan Dana |

  @invalid
  Scenario: Check login is un-successful with invalid credentials. Its is username not registered
    Given User navigated to Login page
    When User enters username "indra"
    And Enters password "admin123"
    And Clicks on login button
    Then User should get a warning message "Username atau password salah"
