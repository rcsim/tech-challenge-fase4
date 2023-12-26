db = db.getSiblingDB('4movies');

db.createCollection("categories");
db.createCollection("users");
db.createCollection("videos");

// Insert data into the categories collection
var category1 = db.categories.insertOne({ "name": "Action", "description": "Action movies involve instances of physical action such as fights, stunts, car chases, etc." }).insertedId;
var category2 = db.categories.insertOne({ "name": "Comedy", "description": "Comedy movies are designed to elicit laughter." }).insertedId;

// Insert data into the users collection
var user1 = db.users.insertOne({ "name": "John Doe", "email": "johndoe@example.com", "favorites": [] }).insertedId;
var user2 = db.users.insertOne({ "name": "Jane Doe", "email": "janedoe@example.com", "favorites": [] }).insertedId;

// Insert data into the videos collection
var video1 = db.videos.insertOne({
  "title": "The Dark Knight",
  "description": "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
  "url": "https://www.imdb.com/title/tt0468569/",
  "publishDate": "2008-07-18",
  "categories": [category1],
  "views": 100,
  "favoritedBy": [user1]
}).insertedId;

var video2 = db.videos.insertOne({
  "title": "The Hangover",
  "description": "Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing. They make their way around the city in order to find their friend before his wedding.",
  "url": "https://www.imdb.com/title/tt1119646/",
  "publishDate": "2009-06-05",
  "categories": [category2],
  "views": 50,
  "favoritedBy": [user2]
}).insertedId;

var video3 = db.videos.insertOne({
  "title": "Inception",
  "description": "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
  "url": "https://www.imdb.com/title/tt1375666/",
  "publishDate": "2010-07-16",
  "categories": [category1],
  "views": 150,
  "favoritedBy": [user1, user2]
}).insertedId;

// Update the users documents with the _id fields of the videos documents
db.users.updateOne({ "_id": user1 }, { "$set": { "favorites": [video1, video3] } });
db.users.updateOne({ "_id": user2 }, { "$set": { "favorites": [video2, video3] } });

// Update the videos documents with the _id fields of the user and categories documents
db.videos.updateOne({ "_id": video1 }, { "$set": { "favoritedBy": [user1], "categories": [category1] } });
db.videos.updateOne({ "_id": video2 }, { "$set": { "favoritedBy": [user2], "categories": [category2] } });
db.videos.updateOne({ "_id": video3 }, { "$set": { "favoritedBy": [user1, user2], "categories": [category1] } });