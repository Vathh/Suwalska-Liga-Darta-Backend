This is an API created to manage dart tournament games. It was designed to streamline the organization of local competitions held annually, divided into the spring and autumn seasons. Each season consists of several weekly tournaments. The tournament is played in a 'double K.O.' system, which means that losing one match does not mean losing the entire tournament.

Participants earn points based on their final positions in each tournament. A leaderboard is maintained, where the ranking is determined by the total points accumulated in a given season. Additionally, statistics regarding 'achievements' such as 180's (180-point turns), 170+ (170+ point turns), quick finish (leg finished in less than 20 darts), and high finish (leg finished with a value above 99) are collected.

# **Features**

### The application allows:
- Storing players in a database
- Creating 'double K.O.' tournament brackets for 16, 32, or 48 players (or fewer)
- Storing statistics and tournament histories divided by seasons and players
- Storing achievements statistics (180, 170+, QF, HF)

### **Tournament Management Workflow:**
- Creating a season with tournaments
- Adding players to the database
- Activating the selected tournament, drawing matches for the tournament bracket for selected players
- Updating matches for the active tournament

### **API Endpoints and Roles**

API requests go through an authorization process. Here is a list of available endpoints divided by roles:

### **Admin:**
  - Add a new player
  - Add a new season/tournament
  - Activate a tournament
  - Cancel an active tournament
  - Delete a season/tournament
  - User permissions listed below
### **User:**
  - Fetch active matches
  - Add a new achievement
  - Update a match
  - Unauthenticated user permissions listed below
### **Unauthenticated User:**      
  - Log into the application
  - Fetch the list of matches for a specific tournament
  - Fetch the list of players
  - Fetch the list of seasons
  - Fetch season statistics
  - Fetch the list of tournaments for a specific season
  - Fetch details of an active tournament
  - Fetch statistics of a selected tournament

## Technologies used:
- Spring Framework:
  - Spring Boot
  - Spring Data JPA
  - Spring Security With JWT
- Gradle as a build tool
- PostgreSQL database
- Flyway for database migrations
- Thymeleaf for templating
- Lombok for boilerplate code reduction
- MapStruct for object mapping

**Getting Started**
