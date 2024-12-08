const express = require('express');
const mysql = require('mysql2');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const port = 5000;

// Middleware
app.use(cors());
app.use(bodyParser.json());

// MySQL Database Connection
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root', // replace with your MySQL username
    password: 'Dinesh@123', // replace with your MySQL password
    database: 'sfs', // replace with your database name
});

// Connect to Database
db.connect((err) => {
    if (err) {
        console.error('Database connection failed:', err.stack);
        return;
    }
    console.log('Connected to database.');
});

// API endpoint to add faculty
app.post('/add-faculty', (req, res) => {
    const { facultyName, facultyEmail, facultyDepartment } = req.body;

    const query = 'INSERT INTO faculty (name, email, department) VALUES (?, ?, ?)';
    db.query(query, [facultyName, facultyEmail, facultyDepartment], (err, results) => {
        if (err) {
            console.error(err);
            res.status(500).send('Error adding faculty');
        } else {
            res.status(200).send('Faculty added successfully');
        }
    });
});
// API endpoint to add student
app.post('/add-student', (req, res) => {
    const { studentName, course } = req.body;

    // SQL query to insert student details into students table
    const query = 'INSERT INTO students (student_name, course) VALUES (?, ?)';
    db.query(query, [studentName, course], (err, results) => {
        if (err) {
            console.error(err);
            return res.status(500).send('Error adding student');
        }
        res.status(200).send('Student added successfully');
    });
});
// Start Server
app.listen(port, () => {
    console.log(`Server running on http://localhost:${port}`);
});
