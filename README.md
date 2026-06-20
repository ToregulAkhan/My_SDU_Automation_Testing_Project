# 🎓 SDU University Portal — UI Automation Testing

Smoke test suite for the **SDU University student portal** ([my.sdu.edu.kz](https://my.sdu.edu.kz/)), built to validate critical student workflows end-to-end.

> **Why this project exists:** University portals are used daily by thousands of students. A single broken flow — login, grade lookup, course registration — affects everyone. This suite catches regressions before they reach users.

---

## 🚀 What I Built

- **46 classes** (23 page objects + 20 test classes + 3 utilities)
- **4 functional areas** covered: Academic Operations, Information Pages, Profile Management, Services
- **Retry mechanism** — flaky tests auto-retry up to 3 times via `IRetryAnalyzer`
- **Smart waiting** — zero hardcoded `Thread.sleep()`, all explicit waits with `WebDriverWait`
- **StaleElementReference handling** — custom retry logic on DOM updates

---

## 🛠️ Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 17 | Language |
| Selenium WebDriver | 4.21 | Browser automation |
| TestNG | 7.10 | Test execution & assertions |
| Maven | 3.6+ | Build & dependency management |
| ChromeDriver | auto | Browser driver |

---

## ✅ Test Coverage

### Academic Operations
| Flow | What's tested |
|------|--------------|
| Course Registration | Selecting and registering courses |
| Wish List | Adding courses for Summer / Fall / Spring |
| Withdrawals | Withdrawal request flow |
| Consent Requests | Consent submission and status |

### Information Pages
| Flow | What's tested |
|------|--------------|
| Grades List | Grade display and semester selection |
| Transcript | Transcript generation and display |
| Attendance | Electronic attendance records |
| Curriculum | Syllabus view in EN / RU / KZ |
| Gate Entry | Entry records with date filtering |
| Rules & Regulations | PDF document access and tab switching |
| System Calendar | Term selection |

### Profile Management
| Flow | What's tested |
|------|--------------|
| Main Information | Edit and save personal data, marital status dropdown |
| Contacts | Add contact with all owner types and contact types |

### Services
| Flow | What's tested |
|------|--------------|
| Online Services | Order creation and PDF viewing |
| SDU Mail | Redirect and tab switching |
| Messages | Page access and navigation |
| Questionnaires | Questionnaire page access |

---

## 🧠 Technical Decisions

**Page Object Model** — locators and test logic are fully separated. Adding a new test never requires touching existing page classes.

**StaleElementReference retry:**
```java
public void select(By selector, String option) {
    int count = 0;
    while (count < 5) {
        try {
            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(selector));
            new Select(element).selectByVisibleText(option);
            return;
        } catch (StaleElementReferenceException e) {
            count++;
            if (count == 5) throw e;
        }
    }
}
```

**DOM stability pattern** — after Cancel/Save clicks, waits for button to disappear before searching for next element:
```java
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value='Cancel']"))).click();
wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[value='Cancel']")));
// DOM is now stable — safe to find next element
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Edit']"))).click();
```

---

## 📂 Project Structure

```
My_SDU_Automation_Testing_Project/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── page/
│   │           ├── HomePage.java
│   │           ├── LoginPage.java
│   │           ├── MainPage.java
│   │           │
│   │           ├── academic_operations/
│   │           │   ├── Consent_Requests_Page.java
│   │           │   ├── Course_Registration_Page.java
│   │           │   ├── Wish_list_Page.java
│   │           │   └── Withdrawals_Page.java
│   │           │
│   │           ├── information/
│   │           │   ├── Accounting_Info_Page.java
│   │           │   ├── Course_Schedule_Page.java
│   │           │   ├── Curricula_Page.java
│   │           │   ├── Electronic_Attendance_Page.java
│   │           │   ├── Gate_Entry_Records_Page.java
│   │           │   ├── Grades_List_Page.java
│   │           │   ├── My_Curriculum_Page.java
│   │           │   ├── Rules_and_Regulations_Page.java
│   │           │   ├── System_Calendar_Page.java
│   │           │   └── Transcript_Page.java
│   │           │
│   │           ├── profile/
│   │           │   ├── My_Profile_Page.java
│   │           │   └── Settings_Page.java
│   │           │
│   │           └── services/
│   │               ├── Messages_Page.java
│   │               ├── Online_Services_Page.java
│   │               ├── Questionnaires_Page.java
│   │               └── SduMail_Page.java
│   │
│   └── test/
│       └── java/
│           ├── tests/
│           │   ├── BaseTest.java
│           │   ├── HomePage_Test.java
│           │   ├── LoginToMainPage_Test.java
│           │   ├── TestToMainPage.java
│           │   │
│           │   ├── Tests_academic_operations/
│           │   │   ├── Consent_Requests_Page_Test.java
│           │   │   ├── Course_Registration_Page_Test.java
│           │   │   ├── Wish_list_Page_Test.java
│           │   │   └── Withdrawals_Page_Test.java
│           │   │
│           │   ├── Tests_information/
│           │   │   ├── Curricula_Page_Test.java
│           │   │   ├── Electronic_Attendance_Page_Test.java
│           │   │   ├── Gate_Entry_Records_Page_Test.java
│           │   │   ├── Grades_List_Page_Test.java
│           │   │   ├── My_Curriculum_Page_Test.java
│           │   │   ├── Rules_and_Regulations_Page_Test.java
│           │   │   ├── System_Calendar_Page_Test.java
│           │   │   └── Transcript_Page_Test.java
│           │   │
│           │   ├── Tests_profile/
│           │   │   └── My_Profile_Page_Test.java
│           │   │
│           │   └── Tests_services/
│           │       ├── Messages_Page_Test.java
│           │       ├── Online_Services_Page_Test.java
│           │       ├── Questionnaires_Page_Test.java
│           │       └── SduMail_Page_Test.java
│           │
│           └── utils/
│               ├── DriverManager.java
│               ├── Retry.java
│               └── Test_Data.java
│
├── testng.xml                                    # TestNG suite configuration
├── pom.xml                                       # Maven dependencies
├── .gitignore                                    # Git ignore file
├── My_SDU_Automation_Testing_Project.iml         # IntelliJ module file
└── README.md                                     # Project documentation
```

---

## ▶️ How to Run

**Prerequisites:** JDK 17+, Maven 3.6+, Google Chrome

```bash
# Clone
git clone https://github.com/ToregulAkhan/My_SDU_Automation_Testing_Project.git
cd My_SDU_Automation_Testing_Project

# Run all smoke tests
mvn clean test

# Run specific test class
mvn test -Dtest=Grades_List_Page_Test

# Run specific method
mvn test -Dtest=My_Profile_Page_Test#Main_Information
```

> ⚠️ Set your credentials in `src/test/java/utils/Test_Data.java` before running.

---

## 🗺️ Roadmap

- [ ] Allure Report integration
- [ ] Screenshot capture on failure
- [ ] Firefox / Edge support
- [ ] Parallel execution
- [ ] GitHub Actions CI/CD pipeline
- [ ] Docker support

---

## 👤 Author

**Toregul Akhan** — Junior QA Engineer  
[GitHub](https://github.com/ToregulAkhan) · [Email](mailto:toregulahan@gmail.com)