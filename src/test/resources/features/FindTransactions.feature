Feature: Find Transactionsin Account Activity

  @wip
  Scenario: Search date range

    Given the user accesses the Find Transactions tab
    When the user enters date range from "2012-9-6" to "2012-9-1"
    And clicks search
    Then results table should only show transactions dates between "2012-9-1" to "2012-9-6"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-9-2" to "2012-9-6"
    And clicks search
    Then results table should only show transactions dates between "2012-9-2" to "2012-9-6"
    And the results table should only not contain transactions dated "2012-9-1"

  Scenario: Search description
    Given the user accesses the Find Transactions tab
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And clicks search
    Then results table should only show descriptions containing "OFFICE"




