# 🎮 Stick Hero Game

A modular 2D stick-bridging platformer game developed in Java using JavaFX and FXML. Built with Object-Oriented Programming (OOP) best practices, Stick Hero offers a seamless gaming experience, dynamic sound effects, and intuitive UI transitions — all while ensuring maintainable and testable code.

---

## 📌 Project Overview

Stick Hero challenges players to help the character cross platforms using a magic stick. The player must carefully stretch the stick to the right length to successfully bridge the gap between two platforms. The game involves:

- Core mechanics implemented using JavaFX
- Scene transitions using FXML
- Sound effects to enhance gameplay
- Persistent game state storage using serialization
- Unit tests for game logic validation

---

## 🛠️ Tech Stack

| Component       | Technology        |
|----------------|-------------------|
| Language        | Java              |
| UI Framework    | JavaFX            |
| Scene Management| FXML              |
| Testing         | JUnit 5           |
| Build Tool      | Maven             |
| Version Control | Git               |
| Media           | JavaFX Media API  |

---

## 🎮 Gameplay Features

- 🧱 **Random Platform Generation**: Dynamic platforms with varying distances.
- 🧍 **Player Movement & Animation**: The hero walks across the stick when it lands correctly.
- 🔊 **Interactive Sound Effects**: Sounds play on key actions like stick drop or cherry collection.
- 🍒 **Collectibles**: Cherries appear randomly and can be collected for bonus.
- 💾 **Game Saving & Loading**: Game state and high scores are persisted using Java serialization.
- 🧪 **Comprehensive Testing**: Game components tested using JUnit for reliability.

---

## 🧠 OOP Design Principles Used

- **Encapsulation**: Each component (e.g., `Player`, `Platform`, `Stick`) handles its own logic and rendering.
- **Inheritance & Polymorphism**: Shared interfaces and class extensions make the codebase extensible.
- **Abstraction**: Core mechanics are hidden behind well-defined interfaces (e.g., `Movable`).

---


## 🔧 How to Run the Game

### ✅ Prerequisites

- Java 17 or higher
- Maven installed

### 🚀 Run Locally

```bash
# Clone the repository
git clone https://github.com/nikhil190804/stickheroapplication.git
cd stickheroapplication

# Build and run the game
mvn clean javafx:run
```

> Make sure JavaFX SDK is properly set up in your system.

---

## 🧪 Running Unit Tests

```bash
mvn test
```

The test suite covers logic for:
- Stick length validation
- Platform generation
- Collision mechanics
- Object movement and saving state

---

## 🕹️ Game Controls

- **Click & Hold**: To stretch the stick.
- **Release**: To drop the stick and move the player.
- **Collect**: Catch cherries placed between platforms.
- **Menu Options**: Load game, view high scores, restart.

---

## 🌟 Future Enhancements

- Mobile compatibility with JavaFX for Android
- Add sound/music toggle options
- New environments/themes
- Power-ups and difficulty levels
- Leaderboard integration using cloud database

---

Thanks for checking out Stick Hero! Feel free to ⭐️ the repo if you enjoyed it.
