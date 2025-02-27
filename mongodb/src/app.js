const { MongoClient } = require('mongodb');
const uri = "mongodb://localhost:27017/mydb";
const client = new MongoClient(uri, { useNewUrlParser: true, useUnifiedTopology: true });

client.connect(err => {
    const collection = client.db("test").collection("devices");
    console.log("Connected to MongoDB");
    client.close();
});
