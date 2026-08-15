\# EspoCRM Functional Requirements



\## Document Information



| Item | Details |

|---|---|

| Project | EspoCRM QA Automation |

| Application | EspoCRM |

| Version | 10.0.4 |

| Document | Functional Requirements |

| Version | 1.0 |

| Prepared By | Mohamed Abubakar Siddiq |

| Date | 15-Aug-2026 |



\---



\# 1. Authentication



\## FR-AUTH-001 — Login



The application shall provide a login mechanism allowing registered users

to access the EspoCRM application.



\## FR-AUTH-002 — Username



The login page shall provide a username field.



\## FR-AUTH-003 — Password



The login page shall provide a password field.



\## FR-AUTH-004 — Successful Login



The application shall allow a valid user to successfully authenticate

and access the CRM application.



\## FR-AUTH-005 — Invalid Login



The application shall prevent authentication when invalid credentials

are provided.



\## FR-AUTH-006 — Logout



The application shall provide a logout mechanism allowing the user to

end the current session.



\---



\# 2. Dashboard



\## FR-DASH-001 — Dashboard Access



An authenticated user shall be able to access the Dashboard.



\## FR-DASH-002 — Dashboard Navigation



The user shall be able to navigate between available CRM modules

from the application interface.



\## FR-DASH-003 — Dashboard Widgets



The Dashboard shall display available CRM information/widgets.



\---



\# 3. Accounts



\## FR-ACC-001 — Account List



The user shall be able to access the Accounts module and view

available accounts.



\## FR-ACC-002 — Create Account



The user shall be able to create a new account.



\## FR-ACC-003 — Account Information



The account form shall provide fields including:



\- Name

\- Website

\- Email

\- Phone

\- Billing Address

\- Shipping Address

\- Type

\- Industry

\- Description

\- Assigned User

\- Teams



\## FR-ACC-004 — Search Accounts



The user shall be able to search for accounts.



\## FR-ACC-005 — Filter Accounts



The user shall be able to filter account records.



\---



\# 4. Contacts



\## FR-CON-001 — Contact List



The user shall be able to access the Contacts module and view

available contacts.



\## FR-CON-002 — Create Contact



The user shall be able to create a new contact.



\## FR-CON-003 — Contact Search



The user shall be able to search contacts.



\## FR-CON-004 — Contact Filtering



The user shall be able to filter contact records.



\## FR-CON-005 — Email Validation



The system shall provide email-related validation/status options

for contact records.



\---



\# 5. Leads



\## FR-LEAD-001 — Lead List



The user shall be able to access the Leads module.



\## FR-LEAD-002 — Create Lead



The user shall be able to create a new lead.



\## FR-LEAD-003 — Lead Status



The system shall support lead statuses observed during reconnaissance:



\- New

\- Assigned

\- In Process

\- Converted

\- Recycled

\- Dead



\## FR-LEAD-004 — Lead Source



The lead form shall provide a Lead Source field.



\## FR-LEAD-005 — Lead Search



The user shall be able to search leads.



\## FR-LEAD-006 — Lead Filtering



The user shall be able to filter leads.



\## FR-LEAD-007 — Campaign Association



The user shall be able to associate a lead with a campaign.



\---



\# 6. Opportunities



\## FR-OPP-001 — Opportunity List



The user shall be able to access the Opportunities module.



\## FR-OPP-002 — Create Opportunity



The user shall be able to create a new opportunity.



\## FR-OPP-003 — Opportunity Views



The system shall provide available opportunity views,

including List and Kanban views.



\## FR-OPP-004 — Account Association



The user shall be able to associate an opportunity with an account.



\## FR-OPP-005 — Opportunity Search



The user shall be able to search opportunities.



\## FR-OPP-006 — Opportunity Filtering



The user shall be able to filter opportunity records.



\---



\# 7. Global Navigation



\## FR-NAV-001 — Main Navigation



The application shall provide navigation to available CRM modules.



\## FR-NAV-002 — Search



The application shall provide search functionality.



\## FR-NAV-003 — Notifications



The application shall provide access to notifications.



\## FR-NAV-004 — User Preferences



The application shall provide access to user preferences.



\## FR-NAV-005 — Administration



The application shall provide access to administration functionality

for authorized users.



\---



\# 8. Requirements Verification Notes



The requirements in this document are derived from the initial

QA reconnaissance performed on the EspoCRM application.



Mandatory/optional field behavior, validation rules, authorization

rules, error handling, and detailed business rules are to be verified

during detailed functional testing.

