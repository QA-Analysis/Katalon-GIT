Feature: Create user

  Scenario Outline: Create user
    Given I create user with data 
    When I execute POST with data <age>,<username>,<password>,<gender>
    Then I get user by id with data <age>,<username>,<password>,<gender>

    Examples: 
      | age | username |  password | gender | 
      |  25 |     mimi | 123456789 |   MALE | 
