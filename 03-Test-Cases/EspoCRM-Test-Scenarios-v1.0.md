# EspoCRM Test Scenarios

**EspoCRM QA Automation Project**  
**Version 1.2 | Revised Traceability Baseline | 19 September 2026**

## Document Control

| Item | Details |
|---|---|
| Document | EspoCRM Test Scenarios |
| Version | 1.2 |
| Application | EspoCRM |
| Project | EspoCRM QA Automation Project |
| Status | Revised Traceability Baseline |
| Active Scope | Login, Accounts and Contacts |
| Scenario ID Pattern | TS-<MODULE>-<NUMBER> |

> **Scope revision:** Leads and Opportunities are de-scoped from the active project scope due to project time constraints. Their previous artifacts are historical only and are not part of the active scenario baseline.

> **Traceability basis:** This scenario baseline is aligned to the current Detailed Test Cases workbook and the Master RTM. It therefore uses the existing TS identifiers already present in those artifacts rather than the earlier 23-scenario summary.

## 1. Scenario Summary

| Module | Scenario Count |
|---|---:|
| Login | 10 |
| Accounts | 17 |
| Contacts | 44 |
| **Total Active Scenarios** | **71** |

The active baseline contains **71 scenarios** mapped to **90 detailed test cases** and **54 represented functional requirements**.

## 2. Login

| Scenario ID | Test Scenario | Requirement ID(s) | Associated Test Case(s) |
|---|---|---|---|
| TS-AUTH-001 | Verify login page accessibility | FR-AUTH-001 | TC-AUTH-001 |
| TS-AUTH-002 | Verify login with valid credentials | FR-AUTH-004 | TC-AUTH-002 |
| TS-AUTH-003 | Verify login with invalid username | FR-AUTH-005 | TC-AUTH-003 |
| TS-AUTH-004 | Verify login with invalid password | FR-AUTH-005 | TC-AUTH-004 |
| TS-AUTH-005 | Verify login with invalid username and password | FR-AUTH-005 | TC-AUTH-005 |
| TS-AUTH-006 | Verify login with blank username | FR-AUTH-005 | TC-AUTH-006 |
| TS-AUTH-007 | Verify login with blank password | FR-AUTH-005 | TC-AUTH-007 |
| TS-AUTH-008 | Verify login with both fields blank | FR-AUTH-005 | TC-AUTH-008 |
| TS-AUTH-009 | Verify password masking | FR-AUTH-003 | TC-AUTH-009 |
| TS-AUTH-010 | Verify logout functionality | FR-AUTH-006 | TC-AUTH-010 |

## 3. Accounts

| Scenario ID | Test Scenario | Requirement ID(s) | Associated Test Case(s) |
|---|---|---|---|
| TS-ACC-001 | Verify user can access the Accounts module | FR-ACC-001 | TC-ACC-001 |
| TS-ACC-002 | Verify Accounts list displays empty state when no accounts exist | FR-ACC-002 | TC-ACC-002, TC-ACC-010, TC-ACC-011 |
| TS-ACC-003 | Verify user can open the Create Account form | FR-ACC-003 | TC-ACC-003, TC-ACC-006, TC-ACC-007 |
| TS-ACC-004 | Verify Account Name field is displayed | FR-ACC-004 | TC-ACC-004, TC-ACC-005 |
| TS-ACC-011 | Verify Save button creates the account | FR-ACC-011 | TC-ACC-008 |
| TS-ACC-012 | Verify Cancel button cancels account creation | FR-ACC-012 | TC-ACC-009 |
| TS-ACC-013 | Verify phone number can be saved without country code | FR-ACC-013 | TC-ACC-030, TC-ACC-031 |
| TS-ACC-016 | Verify All filter displays available Accounts | FR-ACC-016 | TC-ACC-032, TC-ACC-033, TC-ACC-034, TC-ACC-035, TC-ACC-036 |
| TS-ACC-017 | Verify user can view Account details | FR-ACC-017 | TC-ACC-012 |
| TS-ACC-018 | Verify user can edit Account details | FR-ACC-018 | TC-ACC-013, TC-ACC-014 |
| TS-ACC-019 | Verify Delete action displays confirmation | FR-ACC-019 | TC-ACC-015, TC-ACC-016, TC-ACC-017 |
| TS-ACC-020 | Verify Duplicate action detects an existing Account | FR-ACC-020 | TC-ACC-018, TC-ACC-019 |
| TS-ACC-021 | Verify Personal Data option is available | FR-ACC-021 | TC-ACC-020 |
| TS-ACC-022 | Verify Followers section allows a user to be followed | FR-ACC-022 | TC-ACC-021, TC-ACC-022, TC-ACC-023, TC-ACC-024 |
| TS-ACC-023 | Verify Account Audit Log displays recorded activities | FR-ACC-023 | TC-ACC-025 |
| TS-ACC-024 | Verify User Access displays Read, Edit, Delete and Stream access | FR-ACC-024 | TC-ACC-026 |
| TS-ACC-025 | Verify locked Account cannot be edited | FR-ACC-025 | TC-ACC-027, TC-ACC-028, TC-ACC-029 |

## 4. Contacts

| Scenario ID | Test Scenario | Requirement ID(s) | Associated Test Case(s) |
|---|---|---|---|
| TS-CON-001 | Verify user can access the Contacts module | FR-CON-001 | TC-CON-001 |
| TS-CON-002 | Verify Contacts list displays the empty state when no Contacts exist | FR-CON-002 | TC-CON-002 |
| TS-CON-003 | Verify user can open the Create Contact form | FR-CON-003 | TC-CON-003 |
| TS-CON-004 | Verify Prefix is mandatory | FR-CON-004 | TC-CON-004 |
| TS-CON-005 | Verify First Name is mandatory | FR-CON-004A | TC-CON-005 |
| TS-CON-006 | Verify Last Name is mandatory | FR-CON-004B | TC-CON-006 |
| TS-CON-007 | Verify Contact can be created with mandatory Name fields only | FR-CON-005 | TC-CON-007 |
| TS-CON-008 | Verify user can associate an Account with a Contact | FR-CON-006 | TC-CON-008 |
| TS-CON-009 | Verify user can associate multiple Accounts with a Contact | FR-CON-006 | TC-CON-009 |
| TS-CON-010 | Verify Account Title field is available for an associated Account | FR-CON-007 | TC-CON-010 |
| TS-CON-011 | Verify valid Email can be saved | FR-CON-008 | TC-CON-011 |
| TS-CON-012 | Verify invalid Email is rejected | FR-CON-009 | TC-CON-012 |
| TS-CON-013 | Verify multiple Email addresses can be added | FR-CON-010 | TC-CON-013 |
| TS-CON-014 | Verify Email Opt Out option can be selected | FR-CON-011 | TC-CON-014 |
| TS-CON-015 | Verify Email Invalid option can be selected | FR-CON-011 | TC-CON-015 |
| TS-CON-016 | Verify one Email can be marked as Starred | FR-CON-011 | TC-CON-016 |
| TS-CON-017 | Verify Email can be removed | FR-CON-011 | TC-CON-017 |
| TS-CON-018 | Verify Mobile phone can be saved without country code | FR-CON-012 | TC-CON-018 |
| TS-CON-019 | Verify Mobile phone can be saved with India country code | FR-CON-012 | TC-CON-019 |
| TS-CON-020 | Verify multiple phone numbers can be saved | FR-CON-013 | TC-CON-020 |
| TS-CON-021 | Verify phone types can be selected | FR-CON-013 | TC-CON-021 |
| TS-CON-022 | Verify Office phone number validation | FR-CON-014 | TC-CON-022 |
| TS-CON-023 | Verify user can view Contact details | FR-CON-015 | TC-CON-023 |
| TS-CON-024 | Verify user can edit Contact details | FR-CON-016 | TC-CON-024 |
| TS-CON-025 | Verify edited Contact data is saved | FR-CON-017 | TC-CON-025 |
| TS-CON-026 | Verify Delete action displays confirmation | FR-CON-018 | TC-CON-026 |
| TS-CON-027 | Verify user can delete a Contact | FR-CON-018 | TC-CON-027 |
| TS-CON-028 | Verify deleted Contact cannot be found | FR-CON-019 | TC-CON-028 |
| TS-CON-029 | Verify Duplicate action displays existing-record warning | FR-CON-020 | TC-CON-029 |
| TS-CON-030 | Verify duplicated Contact can be saved after warning | FR-CON-020 | TC-CON-030 |
| TS-CON-031 | Verify Personal Data displays available Contact personal data | FR-CON-021 | TC-CON-031 |
| TS-CON-032 | Verify Personal Data supports individual and Select All selection | FR-CON-021 | TC-CON-032 |
| TS-CON-033 | Verify selected Personal Data can be erased | FR-CON-021 | TC-CON-033 |
| TS-CON-034 | Verify User Access displays available access levels | FR-CON-022 | TC-CON-034 |
| TS-CON-035 | Verify search returns an existing Contact | FR-CON-023 | TC-CON-035 |
| TS-CON-036 | Verify search returns no data for a non-existing Contact | FR-CON-023 | TC-CON-036 |
| TS-CON-037 | Verify list field selection displays Account, Email, Phone and Assigned User | FR-CON-024 | TC-CON-037 |
| TS-CON-038 | Verify All filter displays available Contacts | FR-CON-025 | TC-CON-038 |
| TS-CON-039 | Verify Starred filter displays starred Contacts | FR-CON-026 | TC-CON-039 |
| TS-CON-040 | Verify Portal Users filter behavior | FR-CON-027 | TC-CON-040 |
| TS-CON-041 | Verify Only My filter displays Contacts assigned to current user | FR-CON-028 | TC-CON-041 |
| TS-CON-042 | Verify Followed filter displays followed Contacts | FR-CON-029 | TC-CON-042 |
| TS-CON-043 | Verify user can add a follower and Contact appears under Followed | FR-CON-030 | TC-CON-043 |
| TS-CON-044 | Verify user can unfollow a Contact and Followed filter is updated | FR-CON-030 | TC-CON-044 |

## 5. Status Definitions

| Status | Meaning |
|---|---|
| Not Run | Scenario has not been executed. |
| Pass | Expected behavior is observed. |
| Fail | Observed behavior differs from expected behavior. |
| Blocked | Execution cannot proceed because of a dependency or environment issue. |
| N/A | Scenario is not applicable to the configured environment. |

## 6. Traceability Relationship

Functional Requirement (FR) → Test Scenario (TS) → Test Case (TC) → RTM / Execution Evidence

Execution results and defect references remain maintained in the Master RTM and Detailed Test Cases workbook; this document defines the active scenario baseline and its mappings.

## 7. Revision History

| Version | Date | Description |
|---|---|---|
| 1.2 | 19-Sep-2026 | Expanded and aligned the active scenario baseline to the existing 71 TS identifiers used by the Login, Accounts and Contacts detailed test cases and Master RTM. Leads and Opportunities remain de-scoped. |
| 1.1 | 19-Sep-2026 | Reduced active scope to Login, Accounts and Contacts; Leads and Opportunities de-scoped due to project time constraints. |
