db = db.getSiblingDB('4movies');

db.createCollection("categories");
db.createCollection("users");
db.createCollection("videos");
db.createCollection("favorite-videos");

// Insert data into the categories collection
var category1 = db.categories.insertOne({ "name": "Action", "description": "Action movies involve instances of physical action such as fights, stunts, car chases, etc." }).insertedId;
var category2 = db.categories.insertOne({ "name": "Comedy", "description": "Comedy movies are designed to elicit laughter." }).insertedId;
var category3 = db.categories.insertOne({ "name": "Romance",  "description": "Romance movies are centered around the theme of love and relationships."}).insertedId;
var category4 = db.categories.insertOne({ "name": "Horror",  "description": "Horror movies are designed to elicit fear and suspense."}).insertedId;

// Insert data into the users collection
var user1 = db.users.insertOne({ "name": "John Doe", "email": "johndoe@example.com", "favorites": [] }).insertedId;
var user2 = db.users.insertOne({ "name": "Jane Doe", "email": "janedoe@example.com", "favorites": [] }).insertedId;

// Insert data into the videos collection
var video1 = db.videos.insertOne({
  "title": "The Dark Knight",
  "description": "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
  "url": "https://www.imdb.com/title/tt0468569/",
  "publishDate": "2008-07-18",
  "category": category1,
  "views": 100,
  "favoritedBy": [user1]
}).insertedId;

var video2 = db.videos.insertOne({
  "title": "The Hangover",
  "description": "Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing. They make their way around the city in order to find their friend before his wedding.",
  "url": "https://www.imdb.com/title/tt1119646/",
  "publishDate": "2009-06-05",
  "category": category2,
  "views": 50,
  "favoritedBy": [user2]
}).insertedId;

var video3 = db.videos.insertOne({
  "title": "Inception",
  "description": "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
  "url": "https://www.imdb.com/title/tt1375666/",
  "publishDate": "2010-07-16",
  "category": category1,
  "views": 150,
  "favoritedBy": [user1, user2]
}).insertedId;

var video4 = db.videos.insertOne({
  "title": "The Shawshank Redemption",
  "description": "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
  "url": "https://www.imdb.com/title/tt0111161/",
  "publishDate": "1994-09-22",
  "category": category1,
  "views": 200,
  "favoritedBy": [user1, user2]
}).insertedId;

var video5 = db.videos.insertOne({
  "title": "The Godfather",
  "description": "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
  "url": "https://www.imdb.com/title/tt0068646/",
  "publishDate": "1972-03-24",
  "category": category2,
  "views": 150,
  "favoritedBy": [user1]
}).insertedId;

var video6 = db.videos.insertOne({
  "title": "The Godfather: Part II",
  "description": "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.",
  "url": "https://www.imdb.com/title/tt0071562/",
  "publishDate": "1974-12-20",
  "category": category2,
  "views": 120,
  "favoritedBy": [user2]
}).insertedId;

var video7 = db.videos.insertOne({
  "title": "Pulp Fiction",
  "description": "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
  "url": "https://www.imdb.com/title/tt0110912/",
  "publishDate": "1994-10-14",
  "category": category1,
  "views": 180,
  "favoritedBy": [user1, user2]
}).insertedId;

var video8 = db.videos.insertOne({
  "title": "Fight Club",
  "description": "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into something much, much more.",
  "url": "https://www.imdb.com/title/tt0137523/",
  "publishDate": "1999-10-15",
  "category": category1,
  "views": 130,
  "favoritedBy": [user1]
}).insertedId;

var video9 = db.videos.insertOne({
  "title": "The Notebook",
  "description": "A poor yet passionate young man falls in love with a rich young woman, giving her a sense of freedom, but they are soon separated because of their social differences.",
  "url": "https://www.imdb.com/title/tt0332280/",
  "publishDate": "2004-06-25",
  "category": category3,
  "views": 220,
  "favoritedBy": [user1]
}).insertedId;

var video10 = db.videos.insertOne({
  "title": "A Walk to Remember",
  "description": "The story of two North Carolina teens, Landon Carter and Jamie Sullivan, who are thrown together after Landon gets into trouble and is made to do community service.",
  "url": "https://www.imdb.com/title/tt0281358/",
  "publishDate": "2002-01-25",
  "category": category3,
  "views": 180,
  "favoritedBy": [user2]
}).insertedId;

var video11 = db.videos.insertOne({
  "title": "The Shining",
  "description": "A family heads to an isolated hotel for the winter where a sinister presence influences the father into violence, while his psychic son sees horrific forebodings from both past and future.",
  "url": "https://www.imdb.com/title/tt0081505/",
  "publishDate": "1980-05-23",
  "category": category4,
  "views": 240,
  "favoritedBy": [user1]
}).insertedId;

var video12 = db.videos.insertOne({
  "title": "Get Out",
  "description": "A young African-American visits his white girlfriend's parents for the weekend, where his simmering uneasiness about their reception of him eventually reaches a boiling point.",
  "url": "https://www.imdb.com/title/tt5052448/",
  "publishDate": "2017-02-24",
  "category": category4,
  "views": 260,
  "favoritedBy": [user2]
}).insertedId;

// Update the users documents with the _id fields of the videos documents
db.users.updateOne({ "_id": user1 }, { "$set": { "favorites": [video1, video3, video4, video5, video7, video8, video9, video11] } });
db.users.updateOne({ "_id": user2 }, { "$set": { "favorites": [video2, video3, video4, video6, video7, video10, video12] } });