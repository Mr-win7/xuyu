CREATE DATABASE xuyu;
USE xuyu;

/*CREATE TABLE line
(
    line_id INT NOT NULL AUTO_INCREMENT,
    content TEXT,
    moment_id INT, 
    PRIMARY KEY(line_id),
    FOREIGN KEY(moment_id) REFERENCES moment(moment_id)
);*/

CREATE TABLE users
(
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(24) NOT NULL,
    sex ENUM('male','female') DEFAULT 'male',
    avatar CHAR(30),
    phone_number BIGINT(11),
    PRIMARY KEY(user_id)
);

CREATE TABLE movie
(
    title VARCHAR(50),
    PRIMARY KEY(title)
);

CREATE TABLE moment
(
    user_id INT,
    moment_id INT NOT NULL AUTO_INCREMENT,
    movie VARCHAR(50),
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(moment_id),
    FOREIGN KEY(movie) REFERENCES movie(title),
    FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE moment_photo
(
    id CHAR(30),
    moment_id INT, 
    PRIMARY KEY(id),
    FOREIGN KEY(moment_id) REFERENCES moment(moment_id)
);

CREATE TABLE comments
(
    comment_id INT NOT NULL AUTO_INCREMENT,
    writer INT,
    moment_id INT,
    interlocutor INT,
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    content TEXT,
    PRIMARY KEY(comment_id),
    FOREIGN KEY(writer) REFERENCES users(user_id),
    FOREIGN KEY(interlocutor) REFERENCES users(user_id),
    FOREIGN KEY(moment_id) REFERENCES moment(moment_id)
);

CREATE TABLE users_agree_comments
(
    user_id INT,
    comment_id INT,
    PRIMARY KEY(user_id, comment_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    FOREIGN KEY(comment_id) REFERENCES comments(comment_id)
);

CREATE TABLE users_favorite_comments
(
    user_id INT,
    comment_id INT,
    PRIMARY KEY(user_id, comment_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    FOREIGN KEY(comment_id) REFERENCES comments(comment_id)
);

CREATE TABLE users_favorite_moment
(
    user_id INT,
    moment_id INT,
    PRIMARY KEY(user_id, moment_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    FOREIGN KEY(moment_id) REFERENCES moment(moment_id) 
);

select moment.moment_id, moment.movie from moment left join (select count(*) as comments_sum, moment_id from comments group by moment_id) as moment_comments_sum on moment.moment_id = moment_comments_sum.moment_id order by moment_comments_sum.comments_sum;
