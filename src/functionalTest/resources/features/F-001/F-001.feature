@F-001
Feature: Create Role Assignments for Users

  Background:
    Given an appropriate test context as detailed in the test data source

  @S-001
  Scenario: must successfully create org role mapping for single user with single role assignment
    Given a user with [an active IDAM profile with full permissions],
    And a successful call [to create the caseworker profile] as in [S-001_CreateCaseworkerProfileInCRD],
    And a successful call [to provide adequate time for RAS to create records] as in [WaitForRASProcessing],
#    And the request [contains the actorId of the user just created],
#    When a request is prepared with appropriate values,
#    And it is submitted to call the [Fetch Assignment From Role Assignment Service] operation of [Role Assignment Service],
#    Then a positive response is received,
#    And the response has all other details as expected,
#    And a successful call [to delete role assignments just created above] as in [S-001_DeleteDataForRoleAssignments].


#  @S-002
#  @FeatureToggle(orm-base-flag)
#  Scenario: must successfully create org role mapping for single user with single role assignment
#    Given a user with [an active IDAM profile with full permissions],
#    And a successful call [to create the caseworker profile] as in [S-001_CreateCaseworkerProfileInCRD],
#    And a successful call [to provide adequate time for RAS to create records] as in [WaitForRASProcessing],
#    And the request [contains the actorId of the user just created],
#    When a request is prepared with appropriate values,
#    And it is submitted to call the [Fetch Assignment From Role Assignment Service] operation of [Role Assignment Service],
#    Then a positive response is received,
#    And the response has all other details as expected,
#    And a successful call [to delete role assignments just created above] as in [S-001_DeleteDataForRoleAssignments].
