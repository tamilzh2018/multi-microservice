// app.js
const express = require('express');
const app = express();
const port = 3000;

app.use(express.json());

app.get('/api/data', (req, res) => {
    res.json({ message: 'Hello from Node.js!' });
});

app.listen(port, () => {
    console.log(`Node.js API running on http://localhost:${port}/api/data`);
});
