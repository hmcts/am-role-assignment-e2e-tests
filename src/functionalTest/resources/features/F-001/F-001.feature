@F-001
Feature: Create Role Assignments for Users

  Background:
    Given an appropriate test context as detailed in the test data source

  @S-001
  #  @FeatureToggle(orm-base-flag)
  Scenario: must successfully create org role mapping for single user with single role assignment
    Given a user with [an active IDAM profile with full permissions],
    And a successful call [to create the caseworker profile] as in [S-001_CreateCaseworkerProfileInCRD],
    And a successful call [to retrieve the uuid of just uploaded user] as in [S-001_RetrieveUserUUID],
    And a successful call [to provide adequate time for RAS to create records] as in [WaitForRASProcessing],
    And a successful call [to fetch assignment for above actorId] as in [S-001_RetrieveRoleAssignments],
    And a successful call [to update the caseworker profile] as in [S-001_UpdateCaseworkerProfileInCRD],
    And a successful call [to provide adequate time for RAS to create records] as in [WaitForRASProcessing],
    And the request [contains the actorId of the user just created],
    When a request is prepared with appropriate values,
    And it is submitted to call the [Fetch Assignment From Role Assignment Service] operation of [Role Assignment Service],
    Then a positive response is received,
    And the response has all other details as expected,
    And a successful call [to delete role assignments just created above] as in [S-001_DeleteDataForRoleAssignments].
    #Deprioritized by CRD team to implement delete API
#    And a successful call [to delete user profile from CRD] as in [S-001_DeleteDataForRoleAssignments].
#    And a successful call [to delete user profile from UP] as in [S-001_DeleteDataForRoleAssignments].
#    And a successful call [to delete user profile from IDAM] as in [S-001_DeleteDataForRoleAssignments].

  @S-002
  #  @FeatureToggle(orm-base-flag)
  Scenario: must successfully update role details
    Given a user with [an active IDAM profile with full permissions],
    And a successful call [to create the caseworker profile] as in [S-002_CreateCaseworkerProfileInCRD],
    And a successful call [to retrieve the uuid of just uploaded user] as in [S-002_RetrieveUserUUID],
    And a successful call [to provide adequate time for RAS to create records] as in [WaitForRASProcessing],
    And a successful call [to fetch assignment for above actorId] as in [S-002_RetrieveRoleAssignments],
    And a successful call [to update the caseworker profile] as in [S-002_UpdateCaseworkerProfileInCRD],
    And a successful call [to provide adequate time for RAS to create records] as in [WaitForRASProcessing],
    And the request [contains the actorId of the user just created],
    When a request is prepared with appropriate values,
    And the request [contains the updated role value]
    And it is submitted to call the [Fetch Assignment From Role Assignment Service] operation of [Role Assignment Service],
    Then a positive response is received,
    And the response has all other details as expected,
    And a successful call [to delete role assignments just created above] as in [S-002_DeleteDataForRoleAssignments].

  @S-003
  #  @FeatureToggle(orm-base-flag)
  Scenario: must successfully filtered out work areas other than BFA1
    Given a user with [an active IDAM profile with full permissions],
    And a successful call [to create the caseworker profile] as in [S-003_CreateCaseworkerProfileInCRD],
    And a successful call [to retrieve the uuid of just uploaded user] as in [S-003_RetrieveUserUUID],
    And a successful call [to provide adequate time for RAS to create records] as in [WaitForRASProcessing],
    And the request [contains the actorId of the user just created],
    When a request is prepared with appropriate values,
    And it is submitted to call the [Fetch Assignment From Role Assignment Service] operation of [Role Assignment Service],
    Then a positive response is received,
    And the response has all other details as expected,
    And a successful call [to delete role assignments just created above] as in [S-003_DeleteDataForRoleAssignments].

