Feature: Navigating to specific accounts in Accounts Activity


   Scenario Outline: Savings account redirect
    Given the user is logged in
    When the user clicks on "<AccountSummary>" link on the Account Summary page
    Then the "<PageTitle>" page should be displayed
    And Account drop down should have "<dropdownMenu>" selected

    Examples:
    |AccountSummary | PageTitle               | dropdownMenu|
    |Savings        | Zero - Account Activity | Savings     |
    |Brokerage      | Zero - Account Activity | Brokerage   |
    |Checking       | Zero - Account Activity | Checking    |
    |Credit Card    | Zero - Account Activity | Credit Card |
    |Loan           | Zero - Account Activity | Loan        |


   Scenario: Account Summary Requirements
    Given the user is logged in
    When the user clicks on Account Summary on the online banking
    Then Account summary page should have to following account types
    | Cash Accounts       |
    | Investment Accounts |
    | Credit Accounts     |
    | Loan Accounts       |
    And Credit Accounts table must have following columns
    | Account     |
    | Credit Card |
    | Balance     |


    Scenario: Account Activity Requirements
     Given the user is logged in
     When the user clicks on Account Activity on the online banking
     Then Account dropdown should have the following options
     |Savings     |
     |Checking    |
     |Savings     |
     |Loan        |
     |Credit Card |
     |Brokerage   |
     And transactions table should have following columns names
     |Date       |
     |Description|
     |Deposit    |
     |Withdrawal |
     




