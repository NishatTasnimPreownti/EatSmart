#  EatSmart

**EatSmart** is a console-based Java application that promotes healthy living by helping users understand their **BMI**, determine personalized **daily calorie goals**, get **meal suggestions**, find **healthy ingredient alternatives**, and stay motivated with **daily wellness challenges**.

---

##  Project Overview

EatSmart empowers users to make informed and sustainable health choices. Whether you're trying to lose, gain, or maintain weight, this application tailors its suggestions based on user input like age, gender, activity level, and health goals. It’s a lightweight yet comprehensive tool perfect for anyone who wants to track and improve their nutritional habits using a simple, user-friendly interface.

---

## ⚙️ Features

### 1. **BMI Calculator**
- Takes weight and height input.
- Calculates BMI and categorizes health status based on WHO standards.

### 2. **Daily Calorie Goal**
- Calculates BMR using the Harris-Benedict equation.
- Adjusts calories based on activity level and weight goal.
- Estimates how long it will take to gain/lose a given weight.

### 3. **Meal Planner**
- Suggests personalized meals based on the user’s calorie goal.
- Meals are categorized by type (breakfast, lunch, dinner, snacks) and calorie count.

### 4. **Healthy Ingredient Substitutes**
- Suggests healthier alternatives for commonly used unhealthy ingredients.
- Reads swaps from a file (`swaps.txt`), allowing easy customization.

### 5. **Daily Health Challenges**
- Offers random wellness challenges to keep users engaged.
- Users can view a challenge for the day or a full weekly schedule.

---

## 🚀 How to Use

> 🖥️ Make sure you have **Java 17 or later** installed.

### 🔧 Step 1: Clone the Repository

```bash
https://github.com/NishatTasnimPreownti/EatSmart.git
cd EatSmart
### ⚙️ Step 2: Compile the Application
bash
javac Main.java
This will also compile all the required service classes automatically.

### ▶️ Step 3: Run the Application
bash
java Main
### 💡 Step 4: Follow the Menu
Once the app starts, you'll see a menu like this:

╔═══════════════════════════╗
║      E A T  S M A R T     ║
╚═══════════════════════════╝
1. Calculate BMI
2. Get Daily Calorie Goal
3. Suggest Meals by Calorie Goal
4. Healthy Substitutes
5. Daily Challenge
6. Exit
Use the number keys to select options and follow the on-screen prompts.

Example Inputs:

Enter male or female when asked for sex.

Enter calorie goals above 500.

Type back anytime during input to return to the main menu.

License
This project is open-source under the MIT License.

Author
EatSmart was developed by Nishat Tasnim as a final semester project to promote awareness around healthy habits using interactive software.
