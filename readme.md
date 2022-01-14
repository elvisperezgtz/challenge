# Monefy  exploratory Testing 

The objective of this exploratory test is to discover how the App works and to find and document bugs, to improve the user experience.


# Environment
The following test environment was defined for the exploratory tests: 
 - App in the production environment
 - O.S. : Android 11

# Application Version
**Monefy** 1.16.0

# Charters
| Charter-001                                      |
| ------------------------------------------------ |
| **`Explorer`** enter expenses from a category    |
| **`With`** dated after the current date          |
| **`To discover`** enter expenses from a category |

| Charter-002                                   |
| --------------------------------------------- |
| **`Explorer`** expense from the button        |
| **`With`** negative expense value             |
| **`To discover`** if the app allows saving it |


| Charter-003                                                 |
| ----------------------------------------------------------- |
| **`Explorer`** Expense                                      |
| **`With`** an expense from a category and valid values      |
| **`To discover`** if the expense is shown in the main graph |

| Charter-004                                                       |
| ----------------------------------------------------------------- |
| **`Explorer`** Expense                                            |
| **`With`** a different account                                    |
| **`To discover`** if the expense is saved in the selected account |

| Charter-005                                   |
| --------------------------------------------- |
| **`Explorer`** Expense                        |
| **`With`** dated prior to the current date    |
| **`To discover`** if the app allows saving it |

| Charter-006                                   |
| --------------------------------------------- |
| **`Explorer`** Expense                        |
| **`With`** note field empty                   |
| **`To discover`** if the app allows saving it |

| Charter-007                             |
| --------------------------------------- |
| **`Explorer`** Edit expense             |
| **`With`** different values             |
| **`To discover`** if changes were saved |

| Charter-008                                  |
| -------------------------------------------- |
| **`Explorer`** delete an expense             |
| **`With`** previously saved records          |
| **`To discover`** if expense were eliminated |

| Charter-009                               |
| ----------------------------------------- |
| **`Explorer`** Balances Graph             |
| **`With`** Different expenses and incomes |
| **`To discover`** if changes were saved   |

| Charter-010                                                      |
| ---------------------------------------------------------------- |
| **`Explorer`** Balances Graph                                    |
| **`With`** different expenses in multiple accounts               |
| **`To discover`** if the account balance is calculated correctly |

| Charter-011                                          |
| ---------------------------------------------------- |
| **`Explorer`** Balances Graph                        |
| **`With`** different expenses in multiple accounts   |
| **`To discover`** how the expense details are showed |

| Charter-012                                                        |
| ------------------------------------------------------------------ |
| **`Explorer`** Balance Incomes                                     |
| **`With`** different Incomes in multiple accounts                  |
| **`To discover`** how shows the percentage of expenses by category |

| Charter-013                                                          |
| -------------------------------------------------------------------- |
| **`Explorer`** Balance Incomes                                       |
| **`With`** different Incomes in multiple accounts                    |
| **`To discover`** how income is reflected in the balance sheet chart |

| Charter-014                                                          |
| -------------------------------------------------------------------- |
| **`Explorer`** Balance Incomes                                       |
| **`With`** different Incomes category                                |
| **`To discover`** how income is reflected in the balance sheet chart |

| Charter-015                                                  |
| ------------------------------------------------------------ |
| **`Explorer`** Budget mode                                   |
| **`With`** a definite budget, different incomes and expenses |
| **`To discover`** how works the budget mode                  |

| Charter-016                           |
| ------------------------------------- |
| **`Explorer`** Modify Budget mode     |
| **`With`** different budget values    |
| **`To discover`** bugs on budget mode |

| Charter-017                                      |
| ------------------------------------------------ |
| **`Explorer`** Modify Budget mode                |
| **`With`** different flows to fill budget values |
| **`To discover`** bugs on budget mode            |

| Charter-018                                          |
| ---------------------------------------------------- |
| **`Explorer`** Budget mode                           |
| **`With`** different currencies and amounts          |
| **`To discover`** discover errors in the budget mode |

| Charter-019                                                |
| ---------------------------------------------------------- |
| **`Explorer`** data Backup                                 |
| **`With`** backup name empty                               |
| **`To discover`**  errors in the data backup functionality |

| Charter-020                                                                 |
| --------------------------------------------------------------------------- |
| **`Explorer`** restorer data Backup                                         |
| **`With`** a previous data backup created                                   |
| **`To discover`** if the restorer data backup functionality works correctly |

| Charter-021                                        |
| -------------------------------------------------- |
| **`Explorer`** erase data                          |
| **`With`** incomes and expenses movements          |
| **`To discover`** if the eraser data feature works |

| Charter-022                                                                              |
| ---------------------------------------------------------------------------------------- |
| **`Explorer`** account creation                                                          |
| **`With`** the same data (name, icon, initial account credit)                            |
| **`To discover`** what is the restriction to create accounts with the same configuration |


| Charter-023                                              |
| -------------------------------------------------------- |
| **`Explorer`** account creation                          |
| **`With`** initial account credit greater than 15 digits |
| **`To discover`** if it allows creating it               |

| Charter-024                               |
| ----------------------------------------- |
| **`Explorer`** edit an account            |
| **`With`**  different values              |
| **`To discover`** bugs at editing account |

| Charter-025                                 |
| ------------------------------------------- |
| **`Explorer`** delete an account            |
| **`With`** an account with balance movement |
| **`To discover`** if it allows it           |

| Charter-026                                                   |
| ------------------------------------------------------------- |
| **`Explorer`** Transfers                                      |
| **`With`** large amounts of money from account A to account A |
| **`To discover`** bugs on transfer                            |

| Charter-027                                       |
| ------------------------------------------------- |
| **`Explorer`** Transfers                          |
| **`With`** different flows                        |
| **`To discover`**  bugs on transfer functionality |

| Charter-028                                 |
| ------------------------------------------- |
| **`Explorer`** delete a transfer            |
| **`With`** an account with negative balance |
| **`To discover`**  how it works             |

| Charter-029                                                            |
| ---------------------------------------------------------------------- |
| **`Explorer`** Filters                                                 |
| **`With`** in different dates                                          |
| **`To discover`**  how shows expenses according to the selected filter |

| Charter-030                                                           |
| --------------------------------------------------------------------- |
| **`Explorer`** Filters                                                |
| **`With`** expenses in a specific date                                |
| **`To discover`**  how shows expenses according to the specified date |

| Charter-031                    |
| ------------------------------ |
| **`Explorer`** Configurations  |
| **`With`** different languages |
| **`To discover`** how it works |

| Charter-032                           |
| ------------------------------------- |
| **`Explorer`** Currency configuration |
| **`With`** different currencies       |
| **`To discover`** how it works        |

| Charter-032                    |
| ------------------------------ |
| **`Explorer`** First month day |
| **`With`** different days      |
| **`To discover`** how it works |

## Bugs/defects discovered

All the bugs/defects discovered during the exploratory testing session are listed below:

| Charter   | Bug description                                                        |
| --------- | ---------------------------------------------------------------------- |
| **`018`** | the value field only accepts 10 digits                                 |
| **`019`** | allows you to save an unnamed backup                                   |
| **`027`** | If change from note to amount field, the mobile keyboard still visible |


## Prioritization

Charters are prioritized according to the criticality and frequency of use of each functionality, giving priority to **Expenses**, the main feature of the app.

| Charter   | Prioritization | time      |
| --------- | -------------- | --------- |
| **`001`** | High           | 5 minutes |
| **`002`** | High           | 5 minutes |
| **`003`** | High           | 8 minutes |
| **`006`** | High           | 5 minutes |
| **`008`** | High           | 2 minutes |
| **`009`** | High           | 3 minutes |
| **`013`** | High           | 8 minutes |
| **`014`** | High           | 5 minutes |
| **`015`** | High           | 3 minutes |
| **`017`** | High           | 3 minutes |
| **`022`** | High           | 5 minutes |
| **`026`** | High           | 3 minutes |
| **`028`** | High           | 2 minutes |
| **`031`** | High           | 3 minutes |
| **`032`** | High           | 3 minutes |
| **`004`** | High           | 3 minutes |
| **`005`** | Medium         | 3 minutes |
| **`007`** | Medium         | 3 minutes |
| **`010`** | Medium         | 3 minutes |
| **`011`** | Medium         | 8 minutes |
| **`019`** | Medium         | 3 minutes |
| **`018`** | Medium         | 8 minutes |
| **`020`** | Medium         | 3 minutes |
| **`021`** | Medium         | 2 minutes |
| **`023`** | Medium         | 5 minutes |
| **`025`** | Medium         | 1 minute  |
| **`024`** | Medium         | 3 minutes |
| **`027`** | Medium         | 3 minutes |
| **`016`** | Medium         | 3 minutes |
| **`012`** | Medium         | 8 minutes |
| **`029`** | Low            | 3 minutes |
| **`030`** | Low            | 3 minutes |
| **`033`** | Low            | 3 minutes |



## Risks

| Risk              | Module   | Description                                                                   | Criticism | Actions to do                                                   |
| ----------------- | -------- | ----------------------------------------------------------------------------- | --------- | --------------------------------------------------------------- |
| **`Application`** | Backup   | There is a risk of application data erasure and loss of customer information. | 3         | Verify the integrity of the backup module                       |
| **`Security`**    | Security | There is a risk that external applications can access and share app data.     | 3         | Perform penetration tests in search of possible security flaws. |
