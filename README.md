# Carrot killer
Android game application deploy for the Android Development course at VIA University College, Horsens, Denmark.
By Lucía Cárdenas and Martí Serratosa.

## Description of the Carrot Killer game
Carrot Killer is a role-playing game played in real life in different cities and university campuses in Catalonia. We have constance that has been played in the city of Tarragona, in its mayor city parties ([Més Diari Tarragona article](https://www.diarimes.com/es/noticias/tarragona/2016/08/08/matar_con_una_zanahoria_por_santa_tecla_7031_1091.html), Catalan), and in the Barcelona university campus of the Pompeu Fabra University ([La Vanguardia article](https://www.lavanguardia.com/local/barcelona/20160502/401499839099/universitat-pompeu-fabra-juego-asesino-zanahoria.html?utm_source=facebook&utm_medium=social&utm_campaign=local&fbclid=IwAR1P0HcZB6VQmRqccljQajUs5rQlkB3UcWlraZmRKUzAwOChkJ-NGndgWRc), Spanish).

The objective of this game is to kill the player that has been selected randomly for you, your target. The way of killing is by touching your opponent with a real carrot in any part of the body in the real world. Once you have killed your target, you will notify it on the application and the killed player will confirm it. Every time a player kills its target, the killed player’s target becomes your target. You, as a player, have to kill as much as possible. There are multiple ways of winning the Carrot Killer game:
- Being the last one in the game.
- Being the player with more kills on your carrot.
- If there is a time limit, being alive at the end of it and having the most kills.

If you have been killed, the killer will send a confirmation message to you. Then you have to accept the petition as soon as possible, this process should be done just after the real life killing. If the victim does not have his mobile phone with him or Internet connection is not available, the confirmation can be made later.

The Carrot Killer games can be organized by anyone, then a code of the game will be generated and can be send to everyone to join the game. If a player introduces the code will be able to join the game in question. He will need to upload some information about himself like name, surname, photo, hobbies, studies and work. This information will be used for the other players in order to try to kill him. The game will start at a specific date and time, then all players will see on their applications its targets. During the time the game develops players will be able to kill, notify the killings in the app and discover new targets until the deadline of the game arrives. Then the results of the game will be made public. 

## Motivation behind the project
Bringing the real life Carrot Killer to an Android app is really motivating for us because it will make the game implementation much easier for organizers than the actual methods based on Excels, bracelets and mailing systems. The Carrot Killer app will simplify the procedure and make all the information to players and organizers accessible with a few taps. 

Our goal is to be able to provide an easy infrastructure to deploy the Carrot Killer games for third party organizers. When the app is complete we would like to try the application in a real case scenario having one Carrot Killer game with VIA students. Improving our app with feedback we could recieve.

## Prioritized requirements

### Basics: 
- The app would use the basic options of the Android Studio such as: layouts, imageViews, buttons…

### Interaction: 
- The user will be able to use a real-time interaction via clicking buttons or images and tipping information on the screen.
- The app will have a logging and register screen.
- If there is an error with the information or something related with the app, a notification will be shown to the user.
- The app will have toast messages every time you make relevant interactions.
- The app will have a theme.

### Navigation: 
- Implicit intents to share content to social networks. 

On the *menus* branch we have spend time coding a Share icon on the top bar that would make a screenshot and open the sharing options for that screenshot photo to give users the change to share their content with their friends. 

- Explicit intents for the player profiles.

### UX: 
- The app must have an easy and intuitive interaction.

Time and date pickers has been implemented to the NewGameActivity template to make the initial and final timing easier.

- It must be good looking.
- It must be clean and clear.

### Lists: 
- Players or game history list.

### Architecture: 
- We will recycle views of players and information.
- MVC will be deployed.

### Persistence: 
- SQL will be implemented locally.

### Networking: 
- An API will be implemented for the app, further information will come in the future. Google Maps or Spotify are possible APIs.

We wanted to implement the ([Chuck Norris API](https://api.chucknorris.io/) in the toolbar, getting a toast with a Chuck Norris fact when you pressed an icon just to learn and try how api's worked because we didn't need one for the app. On *StatisticsActivity.java* there is the code we used but we coudn't find a way to GET the data from the JSON, it works on PostMan.

### Firebase: 
- The app will be connected with a Firebase backend.

We have spend lots of time testing and finding the key for all the backend features like the killings, list of users circle of killings, profiles data and statistics but we have not archived a fully operation aplication.

- Users login will be done using Firebase Authentication.

Done sucesfully, you can register with an email and password and a new user will be created at the Firebase to be able to log in. For testing purpose the is on use called *testing@app.com* with the password *testing*.

### Quality: 
- An app without bugs
- Testing the app with JUnit or UI Tests
- The app will have a good performance and stability
- The users’ information will be administered safely and it will be kept private.
- Future user stories will be defined as issues.

## List of templates
- Log in
- Home
- Create new game
- Join a game
- Share code
- Fill your player information
- Waiting game beginning
- Your target
- Killing waiting for confirmation
- Confirm your killing
- Killing confirmed
- You have been killed
- Results
- Settings
- List of players
- Statistics

## Development status
The app is not currently fully operational because all the logics of the Firebase is missing, therefore you cannot play a game. Further improvements on the templated beautiness, navigation tools, toolbar and api needs to be done.
