Feature: As a user, I want to read football news

  @DailyMail @Sports @Football
  Scenario: Verify gallery loads full
    Given I am visiting the FootballPage
    And navigate to sports tab
    And navigate to football tab
    And navigate to headline article
    And traverse to the gallery image
    Then should be able to move next
    Then should be able to move prev
    Then should be able to share