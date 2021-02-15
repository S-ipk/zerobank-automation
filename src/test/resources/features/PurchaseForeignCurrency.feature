Feature: Purchase Foreign Currency


  Scenario: Available currencies
    Given the user accesses the Purchase foreign currency cash tab
    Then following currencies should be available
              |Australia (dollar)   |
              |Canada (dollar)      |
              |Switzerland (franc)  |
              |China (yuan)         |
              |Denmark (krone)      |
              |Eurozone (euro)      |
              |Great Britain (pound)|
              |Hong Kong (dollar)   |
              |Japan (yen)          |
              |Mexico (peso)        |
              |Norway (krone)       |
              |New Zealand (dollar) |
              |Sweden (krona)       |
              |Singapore (dollar)   |
              |Thailand (baht)      |

  Scenario: Error message for not selecting currency
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost "500" without selecting a currency
    Then error message should be displayed


  Scenario: Error message for not entering value
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without entering a value
    Then error message should be displayed
