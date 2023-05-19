create database library;
use library;

create table book(
	id_book varchar(50) not null primary key,
    name_book text,
    author_book text,
    describe_book text,
    quantity_book int
);

create table student(
	id_student varchar(50) not null primary key,
    name_student text,
    class_student text
);

create table book_loan_card(
	id_loan_card varchar(50) not null primary key,
    id_book varchar(50),	
    id_student varchar(50),
    status_loan_card bit,
    borrowed_date date,
    return_date date,
    foreign key (id_book) references book(id_book),
	foreign key (id_student) references student(id_student)
);
SELECT blc.id_loan_card, b.name_book, b.author_book, s.name_student, s.class_student, blc.borrowed_date, blc.return_date FROM book_loan_card blc JOIN book b ON blc.id_book = b.id_book JOIN student s ON blc.id_student = s.id_student;

INSERT INTO `library`.`book` (`id_book`, `name_book`, `author_book`, `describe_book`, `quantity_book`) VALUES ('a1', 'tt', 'tien', 'romace', '1');
